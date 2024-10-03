package com.example.caluladoragrados;
public class Kelvin extends Grados {

    public Kelvin(double grados) {
        super(grados);
    }

    public Celsius Parse(Celsius c) {
        return new Celsius(getGrados() - 273.15);
    }

    // Convierte Kelvin a Fahrenheit
    public Fahrenheint Parse(Fahrenheint f) {
        return new Fahrenheint((getGrados() - 273.15) * 9/5 + 32);
    }
}
