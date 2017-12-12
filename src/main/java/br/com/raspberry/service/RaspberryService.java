package br.com.raspberry.service;

import br.com.raspberry.model.Led;
import org.springframework.stereotype.Service;

@Service
public class RaspberryService {

    public Led ligar() {
        Led led = Led.getInstance();
        led.ligar();
        return led;
    }

    public Led desligar() {
        Led led = Led.getInstance();
        led.desligar();
        return led;
    }

    public boolean estado() {
        return Led.getInstance().isLigado();
    }
}
