
package Models;

public class Programas {
    
    private int id_Programa;
    private String nomPrograma;
    private String centroFormacion;
    private String coordinacion;

    public Programas(int id_Programa, String nomPrograma, String centroFormacion, String coordinacion) {
        this.id_Programa = id_Programa;
        this.nomPrograma = nomPrograma;
        this.centroFormacion = centroFormacion;
        this.coordinacion = coordinacion;
    }

    public int getid_Programa() {
        return id_Programa;
    }

    public void setid_Programa(int id_Programa) {
        this.id_Programa = id_Programa;
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
        return "Programas{ " + "id_Programa=" + id_Programa + " , nomPrograma=" + nomPrograma + " , centroFormacion=" + centroFormacion + " , coordinacion=" + coordinacion + '}';
    }
    
    
}
