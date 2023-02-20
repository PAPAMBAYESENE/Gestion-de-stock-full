package com.webgram.web;

import com.webgram.service.ImplementCategorie.ProduitServiceImpl;

public class ProduitController {

    private final ProduitServiceImpl prodService;

    public ProduitController(ProduitServiceImpl prodService) {
        this.prodService = prodService;
    }
}
