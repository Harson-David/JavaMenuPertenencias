package Controllers;

import Models.Bitacora;
import Models.BitacoraDAO;


import java.util.List;

public class ControllerBitacora {

    private final BitacoraDAO bitacoraDAO;

    public ControllerBitacora() {
        this.bitacoraDAO = new BitacoraDAO();
    }

    public Bitacora create(Bitacora bitacora) {
        BitacoraDAO.create(bitacora);
        return bitacora;
    }

    public void createBitaco(Bitacora bitacora) {
        BitacoraDAO.createBit(bitacora);
    }

    public List<Bitacora> findAll() {
        return BitacoraDAO.findAll();
    }

    public Bitacora findOne(int bitacoraId) {
        return BitacoraDAO.findOne(bitacoraId);
    }

    public void update(Bitacora bitacora) {
        BitacoraDAO.update(bitacora);
    }

    public void delete(int bitacoraId) {
        BitacoraDAO.delete(bitacoraId);
    }
}
