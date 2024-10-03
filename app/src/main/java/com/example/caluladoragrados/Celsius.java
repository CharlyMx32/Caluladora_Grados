package com.example.caluladoragrados;

public class Celsius extends Grados {

        public Celsius(double grados) {
            super(grados);
        }

        // Convierte Celsius a Kelvin
        public Kelvin Parse(Kelvin k) {
            return new Kelvin(getGrados() + 273.15);
        }

        // Convierte Celsius a Fahrenheit
        public Fahrenheint Parse(Fahrenheint f) {
            return new Fahrenheint((getGrados() * 9/5) + 32);
        }
}
