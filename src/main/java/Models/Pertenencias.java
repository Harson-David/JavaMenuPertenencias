
package Models;


public class Pertenencias {

    private String pertenencia_id;
    private String tipo;
    private String descripcion;
    private int userId;

    public Pertenencias() {
    }

    public Pertenencias(String pertenencia_id, String tipo, String descripcion, int userId) {
        this.pertenencia_id = pertenencia_id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.userId = userId;
    }

    public Pertenencias(String tipo, String descripcion, int userId) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.userId = userId;
    }

    public Pertenencias(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }


    public String getPertenencia_id() {
        return pertenencia_id;
    }

    public void setPertenencia_id(String pertenencia_id) {
        this.pertenencia_id = pertenencia_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Pertenencias{" + "pertenencia_id=" + pertenencia_id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", userId=" + userId + '}';
    }


}
