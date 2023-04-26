package org.example;

import java.sql.*;

public class Equipo {
    private int id;
    private String nombre;
    private int suplente;
    private String directorTecnico;
    private int puntos;
    private int partidosJugados;

    public Equipo() { }

    public Equipo(int id, String nombre, int suplente, String directorTecnico, int puntos, int partidosJugados) {
        this.id = id;
        this.nombre = nombre;
        this.suplente = suplente;
        this.directorTecnico = directorTecnico;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSuplente() {
        return suplente;
    }

    public void setSuplente(int suplente) {
        this.suplente = suplente;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public static Equipo obtenerEquipo (String nombre) throws SQLException {
        PreparedStatement especifica;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/equipos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

            Statement stmt=con.createStatement();

            especifica = con.prepareStatement("select nombre from equipos where especifica(1,nombre) ");

            ResultSet rs=stmt.executeQuery("select nombre from equipos ");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            int result=stmt.executeUpdate("INSERT TABLE `` () VALUES ()");
            System.out.println(especifica + " records affected");

            con.close();
        } catch(Exception e){ System.out.println(e);}
        return null;
    }
}
