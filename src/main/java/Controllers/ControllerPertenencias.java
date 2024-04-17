package Controllers;

import Models.Pertenencias;
import Models.PertenenciasDAO;

import java.util.List;

public class ControllerPertenencias {

    private final PertenenciasDAO pertenenciasDAO;

    public ControllerPertenencias() {
        this.pertenenciasDAO = new PertenenciasDAO();
    }

    public void create(Pertenencias pertenencia) {
        pertenenciasDAO.create(pertenencia);
    }

    public List<Pertenencias> findAll() {
        return pertenenciasDAO.findAll();
    }

<<<<<<< HEAD
    public Pertenencias findOne(String pertenenciaId) {
        return pertenenciasDAO.findOne(pertenenciaId);
=======
    public Pertenencias findOne(String pertenenciaId, int bitacoraId) {
        return pertenenciasDAO.findOne(pertenenciaId, bitacoraId);
>>>>>>> b36e289 (Problemas arreglados)
    }

    public void update(Pertenencias pertenencia) {
        pertenenciasDAO.updatePer(pertenencia);
    }

<<<<<<< HEAD
    public void delete(String pertenenciaId) {
        pertenenciasDAO.delete(pertenenciaId);
=======
    public void delete(String pertenenciaId, int bitacoraId) {
        pertenenciasDAO.delete(pertenenciaId, bitacoraId);
>>>>>>> b36e289 (Problemas arreglados)
    }

    public void relacionPerBit(String pertenenciaId, int BitacoraId) {
        pertenenciasDAO.crearRelacionPertenenciaBitacora(pertenenciaId, BitacoraId);
    }
}
