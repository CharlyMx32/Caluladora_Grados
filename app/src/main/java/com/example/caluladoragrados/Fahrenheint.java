package com.example.caluladoragrados;

public class Fahrenheint extends Grados {

    public Fahrenheint(double grados) {
        super(grados);
    }

    // Convierte Fahrenheit a Celsius
    public Celsius Parse(Celsius c) {
        return new Celsius((getGrados() - 32) * 5/9);
    }

    // Convierte Fahrenheit a Kelvin
    public Kelvin Parse(Kelvin k) {
        return new Kelvin((getGrados() - 32) * 5/9 + 273.15);
    }
}
