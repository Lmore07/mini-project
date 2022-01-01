package BASE_DATOS;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {

    private String status, information;
    private String id_user, nombres, apellidos, celular, correo, password, direccion, genero;

    public Users() {
    }

    public Users(String nombres, String apellidos, String celular, String correo, String password, String direccion, String genero) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.password = password;
        this.direccion = direccion;
        this.genero = genero;
    }

    public Users(String correo) {
        this.correo = correo;
    }

    public int insert() {
        String sentence = "INSERT INTO public.users(\n"
                + "	celular, nombres, apellidos, correo, password, direccion, genero)\n"
                + "	VALUES ('" + celular + "' ,'" + nombres + "', '" + apellidos + "', '" + correo + "', '" + password + "', '" + direccion + "', '" + genero + "');";
        int regInsert = -1;
        CONEXION connection = new CONEXION();
        if (connection.getStatus().equals("ok")) {
            regInsert = connection.insert(sentence);
        }
        status = connection.getStatus();
        information = connection.getInformation();
        return regInsert;
    }

    public int select() {
        int ret = -1;
        String sentence = "SELECT *\n"
                + "	FROM public.users where correo='" + correo + "';";
        ResultSet resultSet;
        CONEXION connection = new CONEXION();
        if (connection.getStatus().equals("ok")) {
            resultSet = connection.select(sentence);
            try {
                if (resultSet.next()) {
                    this.id_user = resultSet.getString("id_user");
                    this.nombres = resultSet.getString("nombres");
                    this.apellidos = resultSet.getString("apellidos");
                    this.celular = resultSet.getString("celular");
                    this.correo = resultSet.getString("correo");
                    this.password = resultSet.getString("password");
                    this.direccion = resultSet.getString("direccion");
                    this.genero = resultSet.getString("genero");
                    ret = 1;
                    Resultados.id_user = this.id_user;
                } else {
                    ret = 0;
                }
            } catch (SQLException e) {
                status = connection.getStatus();
                information = connection.getInformation();
            } finally {
                /*try {
                    resultSet.close();*/
                connection.close();
                /*} catch (Exception e) {
                }*/
            }
        }
        return ret;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
