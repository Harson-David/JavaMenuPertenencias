package Models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Bitacora {

    private int bitacoraId;
    private Date fechaIngreso;
    private Time horaEntrada;
    private Time horaSalida;
    private String tipoBitacora;
    private String descripcion;
    private Date fechaSalida;
    private Time horaSalidaEquipoSENA;
    private String motivo_salida;
    private String motivoIngreso;

    public Bitacora(int bitacoraId, Date fechaIngreso, Time horaEntrada, Time horaSalida, String tipoBitacora, String descripcion, Date fechaSalida, Time horaSalidaEquipoSENA, String motivo_salida, String motivoIngreso) {
        this.bitacoraId = bitacoraId;
        this.fechaIngreso = fechaIngreso;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoBitacora = tipoBitacora;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.horaSalidaEquipoSENA = horaSalidaEquipoSENA;
        this.motivo_salida = motivo_salida;
        this.motivoIngreso = motivoIngreso;
    }

    public Bitacora(Date fechaIngreso, Time horaEntrada, Time horaSalida, String tipoBitacora) {
        this.fechaIngreso = fechaIngreso;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoBitacora = tipoBitacora;
    }

    public int getBitacoraId() {
        return bitacoraId;
    }

    public void setBitacoraId(int bitacoraId) {
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

    public String getTipo() {
        return tipoBitacora;
    }

    public void setTipo(String tipoBitacora) {
        this.tipoBitacora = tipoBitacora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Time getHoraSalidaEquipoSENA() {
        return horaSalidaEquipoSENA;
    }

    public void setHoraSalidaEquipoSENA(Time horaSalidaEquipoSENA) {
        this.horaSalidaEquipoSENA = horaSalidaEquipoSENA;
    }

    public String getMotivo_salida() {
        return motivo_salida;
    }

    public void setMotivo_salida(String motivo_salida) {
        this.motivo_salida = motivo_salida;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    @Override
    public String toString() {
        return "Bitacora{" + "bitacoraId=" + bitacoraId + ", fechaIngreso=" + fechaIngreso + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", tipo de bitacora=" + tipoBitacora + ", descripcion=" + descripcion + ", fechaSalida=" + fechaSalida + ", horaSalidaEquipoSENA=" + horaSalidaEquipoSENA + ", motivo_salida=" + motivo_salida + ", motivoIngreso=" + motivoIngreso + '}';
    }

    public Bitacora(int bitacoraId, Date fechaIngreso, Time horaEntrada, Time horaSalida) {
        this.bitacoraId = bitacoraId;
        this.fechaIngreso = fechaIngreso;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Date getDateIngreso() {
        return Date.valueOf(LocalDate.now());
    }

    public void setDateIngreso(Date fechaIngreso) {
        this.fechaIngreso = Date.valueOf(LocalDate.now());
    }

    public Time getHourEntrada() {
        return Time.valueOf(LocalTime.now());
    }

    public void setHourEntrada(Time horaEntrada) {
        this.horaEntrada = Time.valueOf(LocalTime.now());
    }

    public Time getHourSalida() {
        return Time.valueOf(LocalTime.now());
    }

    public void setHourSalida(Time horaSalida) {
        this.horaSalida = Time.valueOf(LocalTime.now());
    }

}
