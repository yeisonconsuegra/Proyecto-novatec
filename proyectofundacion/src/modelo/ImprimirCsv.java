package modelo;

import java.util.Date;

public class ImprimirCsv {
    private int documento;
    private String usuarioNombre;
    private double donado;
    private String nomFundacion;
    private String fechaRegistro;

    public ImprimirCsv() {
    }

    public ImprimirCsv(int documento, String usuarioNombre, double donado, String nomFundacion, String fechaRegistro) {
        this.documento = documento;
        this.usuarioNombre = usuarioNombre;
        this.donado = donado;
        this.nomFundacion = nomFundacion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public double getDonado() {
        return donado;
    }

    public void setDonado(double donado) {
        this.donado = donado;
    }

    public String getNomFundacion() {
        return nomFundacion;
    }

    public void setNomFundacion(String nomFundacion) {
        this.nomFundacion = nomFundacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
