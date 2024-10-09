package com.example.caluladoragrados;

public class Kelvin extends Grados {

    public Kelvin(double valor, String unidad) {
        super(valor, unidad);
    }

    public Kelvin parse(Fahrenheit f) {
        Double kelvin = (f.getValor() + 459.67) * 5 / 9;
        return new Kelvin(kelvin, "K");
    }

    public Kelvin parse(Celsius c) {
        Double kelvin = c.getValor() + 273.15;
        return new Kelvin(kelvin, "K");
    }

    @Override
    public String toString() {
        return valor + " K";
    }
}

