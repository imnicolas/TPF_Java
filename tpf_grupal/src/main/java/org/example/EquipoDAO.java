package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private final String URL = "jdbc:mysql://localhost:3306/dbequipos";
    private final String USER = "root";
    private final String PASSWORD = "";

    public List<Equipo> listarEquipos() {
        List<Equipo> equipos = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM equipos");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int titulares = rs.getInt("titulares");
                int suplentes = rs.getInt("suplentes");
                String directorTecnico = rs.getString("directorTecnico");
                int puntos = rs.getInt("puntos");
                int partidosJugados = rs.getInt("partidosJugados");

                Equipo equipo = new Equipo(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);
                equipos.add(equipo);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipos;
    }

    public Equipo buscarEquipoPorNombre(String nombre) {
        Equipo equipo = null;

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM equipos WHERE nombre = ?");
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int titulares = rs.getInt("titulares");
                int suplentes = rs.getInt("suplentes");
                String directorTecnico = rs.getString("directorTecnico");
                int puntos = rs.getInt("puntos");
                int partidosJugados = rs.getInt("partidosJugados");

                equipo = new Equipo(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipo;
    }
}
