package br.com.raspberry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pi4j.io.gpio.*;
import lombok.Data;
import org.springframework.util.ObjectUtils;

@Data
public class Led {
    private static Led ourInstance;
    @JsonIgnore
    private GpioPinDigitalOutput pin;
    private boolean estado;

    public Led() {
    }

    public static Led getInstance() {
        if (ObjectUtils.isEmpty(ourInstance)) {
            GpioController gpio = GpioFactory.getInstance();
            ourInstance = new Led();
            ourInstance.setPin(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Led 04", PinState.LOW));
        }
        return ourInstance;
    }

    @JsonIgnore
    public boolean isLigado() {
        return this.estado;
    }

    @JsonIgnore
    public void ligar() {
        this.pin.high();
        this.estado = true;
    }

    @JsonIgnore
    public void desligar() {
        this.pin.low();
        this.estado = false;
    }
}
