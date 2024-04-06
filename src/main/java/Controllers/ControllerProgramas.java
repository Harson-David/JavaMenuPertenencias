package Controllers;

import Models.Programas;
import Models.ProgramasDAO;

import java.util.List;

public class ControllerProgramas {

    private final ProgramasDAO programasDAO;

    public ControllerProgramas() {
        this.programasDAO = new ProgramasDAO();
    }

    public void create(Programas programa) {
        programasDAO.create(programa);
    }

    public List<Programas> findAll() {
        return programasDAO.findAll();
    }

    public Programas findOne(int programaId) {
        return programasDAO.findOne(programaId);
    }

    public void update(Programas programa) {
        programasDAO.update(programa);
    }

    public void delete(int programaId) {
        programasDAO.delete(programaId);
    }
}
