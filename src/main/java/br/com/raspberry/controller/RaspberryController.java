package br.com.raspberry.controller;

import br.com.raspberry.model.Led;
import br.com.raspberry.service.RaspberryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/led")
public class RaspberryController {

    @Autowired
    private RaspberryService service;

    @PostMapping
    @RequestMapping(value = "ligar")
    public Led ligar() {
        return service.ligar();
    }

    @PostMapping
    @RequestMapping(value = "desligar")
    public Led desligar() {
        return service.desligar();
    }

    @GetMapping
    @RequestMapping(value = "estado")
    public boolean estado() {
        return service.estado();
    }
}
