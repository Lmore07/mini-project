/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BASE_DATOS;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class Preguntas {
 private String status, information;
private String id_preg, id_Cat, pregunta, respuesta;

    public Preguntas() {
    }

    public int select() {
        int ret = -1;
        String sentence = "SELECT pregunta, respuesta\n" +
"	FROM public.preguntas where id_preg="+id_preg+";";
        ResultSet resultSet;
        CONEXION connection = new CONEXION();
        if (connection.getStatus().equals("ok")) {
            resultSet = connection.select(sentence);
            try {
                if (resultSet.next()) {
                    this.pregunta = resultSet.getString("pregunta");
                    this.respuesta = resultSet.getString("respuesta");
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

    public Preguntas(String id_preg) {
        this.id_preg = id_preg;
    }

    public Preguntas(String id_preg, String id_Cat, String pregunta, String respuesta) {
        this.id_preg = id_preg;
        this.id_Cat = id_Cat;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
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

    public String getId_preg() {
        return id_preg;
    }

    public void setId_preg(String id_preg) {
        this.id_preg = id_preg;
    }

    public String getId_Cat() {
        return id_Cat;
    }

    public void setId_Cat(String id_Cat) {
        this.id_Cat = id_Cat;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
