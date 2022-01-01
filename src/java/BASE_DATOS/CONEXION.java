package BASE_DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CONEXION {

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
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

    private Connection connection;
    private String status, information;

    public CONEXION() {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/miniproject", "postgres",
                        "12345");
                status = "ok";
                information = "Sucessful Connection";
            } catch (SQLException ex) {
                System.err.println("Error al conectarse a PostgreSQL: "
                        + ex.getMessage());
                status = "Error al conectarse";
                information = ex.getMessage();
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al registrar el Driver de SQL: "
                    + ex.getMessage());
            status = "Error al registrar el Driver";
            information = ex.getMessage();
        }
    }

    public int insert(String sentence) {
        int regInsert = -1;
        try {
            Statement statement = connection.createStatement();
            try {
                regInsert = statement.executeUpdate(sentence);
            } catch (SQLException e) {
                status = "Error al insertar el registro";
                information = e.getMessage();
                System.err.print(sentence);
            }
        } catch (SQLException e) {
            status = "Error al crear el canal de ejecución";
            information = e.getMessage();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

        return regInsert;
    }

    public ResultSet select(String sentence) {
        ResultSet resultSet = null;

        try {
            Statement statement = getConnection().createStatement();
            try {
                resultSet = statement.executeQuery(sentence);
            } catch (SQLException e) {
                setStatus("Error al consultar el registro");
                setInformation(e.getMessage());
                System.err.print(sentence);
            }
        } catch (SQLException e) {
            setStatus("Error al crear el canal de ejecución");
            setInformation(e.getMessage());
        }

        return resultSet;
    }

    public void close() {
        try {
            getConnection().close();
        } catch (SQLException e) {
        }
    }

}
