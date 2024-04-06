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

    public Pertenencias findOne(String pertenenciaId) {
        return pertenenciasDAO.findOne(pertenenciaId);
    }

    public void update(Pertenencias pertenencia) {
        pertenenciasDAO.update(pertenencia);
    }

    public void delete(String pertenenciaId) {
        pertenenciasDAO.delete(pertenenciaId);
    }
}
