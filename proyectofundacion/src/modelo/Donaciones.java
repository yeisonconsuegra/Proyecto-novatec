package modelo;

import java.util.Date;

public class Donaciones {
    private int docu_usuario;
    private String moneda;
    private double cantidad_donada;
    private String fecha_donada;

    public Donaciones() {
    }

    public Donaciones(int docu_usuario, String moneda, double cantidad_donada, String fecha_donada) {
        this.docu_usuario = docu_usuario;
        this.moneda = moneda;
        this.cantidad_donada = cantidad_donada;
        this.fecha_donada = fecha_donada;
    }

    public int getDocu_usuario() {
        return docu_usuario;
    }

    public void setDocu_usuario(int docu_usuario) {
        this.docu_usuario = docu_usuario;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getCantidad_donada() {
        return cantidad_donada;
    }

    public void setCantidad_donada(double cantidad_donada) {
        this.cantidad_donada = cantidad_donada;
    }

    public String getFecha_donada() {
        return fecha_donada;
    }

    public void setFecha_donada(String fecha_donada) {
        this.fecha_donada = fecha_donada;
    }
    
    public int DolarPeso(int valor){
        int pesos =valor * 4698;
        return pesos;
    }
    
    public int chilenosPesos(int valor){ 
        int pesos = valor * 4;
        return pesos;
    }
    
    public int argentinoPesos(int valor) {
        int pesos = valor * 30;
        return pesos;
    }

    public int euroPesos(int valor) {
        int pesos = valor * 4566;
        return pesos;
    }
}
