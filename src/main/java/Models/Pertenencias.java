
package Models;

import java.sql.Date;
import java.sql.Time;


public class Pertenencias {
    // para pertenencias
    private String pertenencia_id;
    private String tipo;
    private String descripcion;
    private int userId;
    
    //para bitacora
    private Integer bitacoraId; 
    private Date fechaIngreso;
    private Time horaEntrada;
    private Time horaSalida;
    private String bitacoraTipo;


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

    public Pertenencias(String pertenenciaId, String tipo, String descripcion, int userId, Integer bitacoraId, Date fechaIngreso, Time horaEntrada, Time horaSalida, String bitacoraTipo) {
        this.pertenencia_id = pertenenciaId;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.userId = userId;
        this.bitacoraId = bitacoraId;
        this.fechaIngreso = fechaIngreso != null ? fechaIngreso : null;
        this.horaEntrada = horaEntrada != null ? horaEntrada : null;
        this.horaSalida = horaSalida != null ? horaSalida : null;
        this.bitacoraTipo = bitacoraTipo != null ? bitacoraTipo : null;
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
    
    

    public Integer getBitacoraId() {
        return bitacoraId;
    }

    public void setBitacoraId(Integer bitacoraId) {
        this.bitacoraId = bitacoraId;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getBitacoraTipo() {
        return bitacoraTipo;
    }

    public void setBitacoraTipo(String bitacoraTipo) {
        this.bitacoraTipo = bitacoraTipo;
    }
}
