package modelo;

public class Donadores {
    private int documento;
    private String nombre;
    private String apellido;
    private double dinero;
    private String fundacion_pertenece;

    public Donadores() {
    }

    public Donadores(int documento, String nombre, String apellido, double dinero, String fundacion_pertenece) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dinero = dinero;
        this.fundacion_pertenece = fundacion_pertenece;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getFundacion_pertenece() {
        return fundacion_pertenece;
    }

    public void setFundacion_pertenece(String fundacion_pertenece) {
        this.fundacion_pertenece = fundacion_pertenece;
    }
    
    
}
