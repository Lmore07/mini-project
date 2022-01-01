/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BASE_DATOS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import sun.util.resources.LocaleData;

/**
 *
 * @author luism
 */
public class Resultados {

    public static String id_user;
    private String status, information;
    private String id_resultado, fecha, puntos;

    public Resultados(String id_resultado, String fecha, String puntos) {
        this.id_resultado = id_resultado;
        this.fecha = fecha;
        this.puntos = puntos;
    }

    public Resultados() {
    }

    public Resultados(String puntos) {
        this.puntos = puntos;
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

    public String getId_resultado() {
        return id_resultado;
    }

    public void setId_resultado(String id_resultado) {
        this.id_resultado = id_resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public int insert() {
        String sentence = "INSERT INTO public.resultados(\n"
                + "	fecha, puntos, id_user)\n"
                + "	VALUES ('" + LocalDateTime.now() + "', '" + puntos + "', '" + id_user + "');";
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
        String sentence = "SELECT fecha, puntos\n"
                + "	FROM public.resultados where id_user=" + id_user
                + ";";
        ResultSet resultSet;
        CONEXION connection = new CONEXION();
        if (connection.getStatus().equals("ok")) {
            resultSet = connection.select(sentence);
            try {
                if (resultSet.next()) {
                    this.fecha = resultSet.getString("fecha");
                    this.puntos = resultSet.getString("puntos");
                    ret = 1;
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

    public ResultSet select_rs() {
        int ret = -1;
        String sentence = "SELECT fecha, puntos\n"
                + "	FROM public.resultados where id_user=" + id_user
                + ";";
        ResultSet resultSet = null;
        CONEXION connection = new CONEXION();
        if (connection.getStatus().equals("ok")) {
            resultSet = connection.select(sentence);
            try {
                if (resultSet.next()) {
                    this.fecha = resultSet.getString("fecha");
                    this.puntos = resultSet.getString("puntos");
                    ret = 1;
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
        return resultSet;
    }
}
