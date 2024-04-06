package Models;

public class Users {

    public static UserTypeDocument UserTypeDocument;

    private int user_id;

    public Users(int nd, UserRole userRole, UserTypeDocument UserTypeDocument, String c, String n, String a, int nc, String d, String em, String cr, String cg, String cr0, String cr1, int nc0, String cf, String cr2, String cg0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Users(UserTypeDocument userTypeDocument, String contrasena, String nombres, String apellidos, int numContacto, String direccion, String email, String centroFormacion, String coordi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Users(int numeroDocumento, String tipoDocumento, String contrasena, String nombres, String apellidos, String coordi, String centroFormacion, int numContacto, String direccion, String email, String cargo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

// Enumeración para los roles de usuario
    public enum UserRole {
        APRENDIZ,
        INSTRUCTOR,
        FUNCIONARIO,
        EXTERNO,
        ADMINISTRADOR
    }

    // Variable privada para el rol del usuario
    private UserRole userRol;

    public enum UserTypeDocument {
        CC,
        TI,
        CE,
        PASAPORTE
    }

    private UserTypeDocument typeDocument;

    private String password;
    private String name;
    private String lastName;
    private int numContact;
    private String address;
    private String email;
    private String jornada;
    private String tipoFormacion;
    private String centroFormacion;
    private String coordinacion;
    private int numFicha;
    private int formacion;
    private String cargoActual;
    private String lugarProcedencia;

    public Users(int user_id, UserRole userRol, UserTypeDocument typeDocument, String password, String name, String lastName, int numContact, String address, String email, String jornada, String tipoFormacion, String centroFormacion, String coordinacion, int numFicha, int formacion, String cargoActual, String lugarProcedencia) {
        this.user_id = user_id;
        this.userRol = userRol;
        this.typeDocument = typeDocument;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.numContact = numContact;
        this.address = address;
        this.email = email;
        this.jornada = jornada;
        this.tipoFormacion = tipoFormacion;
        this.centroFormacion = centroFormacion;
        this.coordinacion = coordinacion;
        this.numFicha = numFicha;
        this.formacion = formacion;
        this.cargoActual = cargoActual;
        this.lugarProcedencia = lugarProcedencia;
    }



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public UserRole getUserRol() {
        return userRol;
    }

    public void setUserRol(UserRole userRol) {
        this.userRol = userRol;
    }

    public UserTypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(UserTypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumContact() {
        return numContact;
    }

    public void setNumContact(int numContact) {
        this.numContact = numContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getTipoFormacion() {
        return tipoFormacion;
    }

    public void setTipoFormacion(String tipoFormacion) {
        this.tipoFormacion = tipoFormacion;
    }

    public String getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(String centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    public String getCoordinacion() {
        return coordinacion;
    }

    public void setCoordinacion(String coordinacion) {
        this.coordinacion = coordinacion;
    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    public int getFormacion() {
        return formacion;
    }

    public void setFormacion(int formacion) {
        this.formacion = formacion;
    }

    public String getCargoActual() {
        return cargoActual;
    }

    public void setCargoActual(String cargoActual) {
        this.cargoActual = cargoActual;
    }

    public String getLugarProcedencia() {
        return lugarProcedencia;
    }

    public void setLugarProcedencia(String lugarProcedencia) {
        this.lugarProcedencia = lugarProcedencia;
    }
    
    

    @Override
    public String toString() {
        return "Users{" + "user_id=" + user_id + ", userRol=" + userRol + ", typeDocument=" + typeDocument + ", password=" + password + ", name=" + name + ", lastName=" + lastName + ", numContact=" + numContact + ", address=" + address + ", email=" + email + ", jornada=" + jornada + ", tipoFormacion=" + tipoFormacion + ", centroFormacion=" + centroFormacion + ", coordinacion=" + coordinacion + ", numFicha=" + numFicha + ", formacion=" + formacion + ", cargoActual=" + cargoActual + ", lugarProcedencia=" + lugarProcedencia + '}';
    }

    public Users(int user_id, UserRole userRol, UserTypeDocument typeDocument, String password, String name, String lastName, int numContact, String address, String email,String jornada ,String centroFormacion, String coordinacion, String cargoActual) {
        this.user_id = user_id;
        this.userRol = userRol;
        this.typeDocument = typeDocument;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.numContact = numContact;
        this.address = address;
        this.email = email;
        this.jornada = jornada;
        this.centroFormacion = centroFormacion;
        this.coordinacion = coordinacion;
        this.cargoActual = cargoActual;
    }

    public Users(int user_id, UserRole userRol, UserTypeDocument typeDocument, String password, String name, String lastName, int numContact, String address, String email, String jornada, String tipoFormacion, String centroFormacion, String coordinacion, int numFicha) {
        this.user_id = user_id;
        this.userRol = userRol;
        this.typeDocument = typeDocument;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.numContact = numContact;
        this.address = address;
        this.email = email;
        this.jornada = jornada;
        this.tipoFormacion = tipoFormacion;
        this.centroFormacion = centroFormacion;
        this.coordinacion = coordinacion;
        this.numFicha = numFicha;
    }

    public Users(int user_id, UserRole userRol, UserTypeDocument typeDocument, String password, String name, String lastName, int numContact, String address, String email, String lugarProcedencia) {
        this.user_id = user_id;
        this.userRol = userRol;
        this.typeDocument = typeDocument;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.numContact = numContact;
        this.address = address;
        this.email = email;
        this.lugarProcedencia = lugarProcedencia;
    }

    public Users(int user_id, UserRole userRol, UserTypeDocument typeDocument, String password, String name, String lastName, int numContact, String address, String email, String jornada, String tipoFormacion, String centroFormacion, String coordinacion, int numFicha, int formacion) {
        this.user_id = user_id;
        this.userRol = userRol;
        this.typeDocument = typeDocument;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.numContact = numContact;
        this.address = address;
        this.email = email;
        this.jornada = jornada;
        this.tipoFormacion = tipoFormacion;
        this.centroFormacion = centroFormacion;
        this.coordinacion = coordinacion;
        this.numFicha = numFicha;
        this.formacion = formacion;
    }
    
    
    
    

}
