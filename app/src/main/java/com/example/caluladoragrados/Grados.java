package com.example.caluladoragrados;

public class Grados {
    protected Double valor;
    protected String unidad;

    public Grados(double valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    protected void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}


