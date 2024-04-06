package Controllers;

import Models.Bitacora;
import Models.BitacoraDAO;


import java.util.List;

public class ControllerBitacora {

    private final BitacoraDAO bitacoraDAO;

    public ControllerBitacora() {
        this.bitacoraDAO = new BitacoraDAO();
    }

    public void create(Bitacora bitacora) {
        bitacoraDAO.create(bitacora);
    }

    public void createBitaco(Bitacora bitacora) {
        bitacoraDAO.createBit(bitacora);
    }

    public List<Bitacora> findAll() {
        return bitacoraDAO.findAll();
    }

    public Bitacora findOne(int bitacoraId) {
        return bitacoraDAO.findOne(bitacoraId);
    }

    public void update(Bitacora bitacora) {
        bitacoraDAO.update(bitacora);
    }

    public void delete(int bitacoraId) {
        bitacoraDAO.delete(bitacoraId);
    }
}
