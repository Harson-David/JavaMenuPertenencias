
package Models;

public class Programas {
    
    private int id_user;
    private String nomPrograma;
    private String centroFormacion;
    private String coordinacion;

    public Programas(int id_user, String nomPrograma, String centroFormacion, String coordinacion) {
        this.id_user = id_user;
        this.nomPrograma = nomPrograma;
        this.centroFormacion = centroFormacion;
        this.coordinacion = coordinacion;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNomPrograma() {
        return nomPrograma;
    }

    public void setNomPrograma(String nomPrograma) {
        this.nomPrograma = nomPrograma;
    }

    public String getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(String centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    public String getCoordinacion() {
        return coordinacion;
    }

    public void setCoordinacion(String coordinacion) {
        this.coordinacion = coordinacion;
    }

    @Override
    public String toString() {
        return "Programas{ " + "id_user=" + id_user + " , nomPrograma=" + nomPrograma + " , centroFormacion=" + centroFormacion + " , coordinacion=" + coordinacion + '}';
    }
    
    
   
    
}
