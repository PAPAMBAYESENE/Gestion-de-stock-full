package com.webgram.dao;

import com.webgram.entity.Role;
import com.webgram.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByLibelle(RoleEnum libelle);
}
