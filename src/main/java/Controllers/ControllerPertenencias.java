package Controllers;

import Models.Pertenencias;
import Models.PertenenciasDAO;

import java.util.List;

public class ControllerPertenencias {

    private final PertenenciasDAO pertenenciasDAO;

    public ControllerPertenencias() {
        this.pertenenciasDAO = new PertenenciasDAO();
    }

    public Pertenencias create(Pertenencias pertenencia) {
        PertenenciasDAO.create(pertenencia);
        return pertenencia;
    }

    public void create_bitacora_pertenencia(List<String> pertenencia_ids, int bitacora_id) {
        PertenenciasDAO.create_bitacora_pertenencia(pertenencia_ids, bitacora_id);
    }

    public List<Pertenencias> findAll() {
        return PertenenciasDAO.findAll();
    }

    public Pertenencias findOne(String pertenenciaId) {
        return PertenenciasDAO.findOne(pertenenciaId);
    }

    public void update(Pertenencias pertenencia) {
        PertenenciasDAO.update(pertenencia);
    }

    public void delete(String pertenenciaId) {
        PertenenciasDAO.delete(pertenenciaId);
    }
}
