package com.webgram.service.ImplementCategorie;

import com.webgram.dao.RoleRepository;
import com.webgram.dao.UserRepository;
import com.webgram.entity.RoleEnum;
import com.webgram.entity.User;
import com.webgram.pojo.AuthReponse;
import com.webgram.pojo.LoginRequest;
import com.webgram.security.JwtService;
import com.webgram.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public User register(User user) {
        if (userRepository.existsUserByEmailEqualsAndIsDeletedIsFalse(user.getUsername())) {
         throw new RuntimeException("L'adresse email est deja utilisé");
        }
        val role = roleRepository.findByLibelle(RoleEnum.USER);
        var savedUser = User.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(role)
                .build();
      return userRepository.save(savedUser);
    }

    @Override
    public AuthReponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=
                userRepository.findByEmail(
                        request.getEmail().toLowerCase()).get();
        var jwtToken = jwtService.generateToken(user);//on a oublier l'email et mot de passe
        System.out.println("+++++++++++++++++++++++++++++++++++"+jwtToken);

        return AuthReponse.builder()
                .token(jwtToken)
                .build();
    }
}
