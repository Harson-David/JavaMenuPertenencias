package Controllers;

import Models.Users;
import Models.UsersDAO;
import java.util.List;

public class ControllerUsers {

    private final UsersDAO usersDAO;

    public ControllerUsers() {
        this.usersDAO = new UsersDAO();
    }

    public void create(Users user) {
        usersDAO.create(user);
    }


    public List<Users> findAll() {
        return usersDAO.findAll();
    }

    public Users findOne(int userId) {
        return usersDAO.findOne(userId);
    }
    
        public void update(Users user) {
        usersDAO.update(user);
    }

    public void updateAprendiz(Users user) {
        usersDAO.updateAprendiz(user);
    }

    public void updateInstructor(Users user) {
        usersDAO.updateInstructor(user);
    }

    public void updateFuncionario(Users user) {
        usersDAO.updateFuncionario(user);
    }

    public void updateExterno(Users user) {
        usersDAO.updateExterno(user);
    }

    public void updateAdministrador(Users user) {
        usersDAO.updateAdministrador(user);
    }

    public void delete(int userId) {
        usersDAO.delete(userId);
    }
}
