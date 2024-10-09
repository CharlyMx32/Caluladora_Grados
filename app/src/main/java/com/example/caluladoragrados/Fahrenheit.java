package com.example.caluladoragrados;

public class Fahrenheit extends Grados {

    public Fahrenheit(double valor, String unidad) {
        super(valor, unidad);
    }

    public Fahrenheit parse(Celsius c) {
        Double fahrenheit = (c.getValor() - 32) * 5 / 9;
        return new Fahrenheit(fahrenheit, "°F");
    }

    public Fahrenheit parse(Kelvin k) {
        Double fahrenheit = (k.getValor() * 9 / 5) - 459.67;
        return new Fahrenheit(fahrenheit, "°F");
    }

    @Override
    public String toString() {
        return valor + " °F";
    }
}

