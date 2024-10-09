package com.example.caluladoragrados;

public class Celsius extends Grados {

    public Celsius(double valor, String unidad) {
        super(valor, unidad);
    }

    public Celsius parse(Fahrenheit f) {
        // Conviertes de Fahrenheit a Celsius
        Double celsius = (f.getValor() - 32) * 5 / 9;
        return new Celsius(celsius, "°C");
    }

    public Celsius parse(Kelvin k) {
        double celsius = k.getValor() - 273.15;
        return new Celsius(celsius, "°C");
    }

    @Override
    public String toString() {
        return valor + " °C";
    }
}
