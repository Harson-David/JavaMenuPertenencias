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


    public Pertenencias findOne(String pertenenciaId, int bitacoraId) {
        return pertenenciasDAO.findOne(pertenenciaId, bitacoraId);
    }

    public void update(Pertenencias pertenencia) {
        pertenenciasDAO.updatePer(pertenencia);
    }

    public void delete(String pertenenciaId, int bitacoraId) {
        pertenenciasDAO.delete(pertenenciaId, bitacoraId);
    }

    public void relacionPerBit(String pertenenciaId, int BitacoraId) {
        pertenenciasDAO.crearRelacionPertenenciaBitacora(pertenenciaId, BitacoraId);
    }
}
