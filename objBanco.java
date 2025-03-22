public class objBanco
{
    private String nombre; 
    private double cedula;
    private int telefono;
    private String tipocred;
    public objBanco() {
    }
    public objBanco(String nombre, double cedula, int telefono, String tipocred) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.tipocred = tipocred;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCedula() {
        return cedula;
    }
    public void setCedula(double cedula) {
        this.cedula = cedula;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getTipocred() {
        return tipocred;
    }
    public void setTipocred(String tipocred) {
        this.tipocred = tipocred;
    }
    
     

}