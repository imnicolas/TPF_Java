package org.example;

import java.util.List;
import java.util.Objects;

import static org.example.Main.equipoDAO;

public class Equipo {
    private String nombre;
    private int titulares;
    private int suplentes;
    private String directorTecnico;
    private int puntos;
    private int partidosJugados;

    public Equipo(String nombre, int titulares, int suplentes, String directorTecnico, int puntos, int partidosJugados) {
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.directorTecnico = directorTecnico;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTitulares() {
        return titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
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
    
    public static List<Equipo> listarEquipos() {
        List<Equipo> equipos = equipoDAO.listarEquipos();

        for (Equipo equipo : equipos) {
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Titulares: " + equipo.getTitulares());
            System.out.println("Suplentes: " + equipo.getSuplentes());
            System.out.println("Director Técnico: " + equipo.getDirectorTecnico());
            System.out.println("Puntos: " + equipo.getPuntos());
            System.out.println("Partidos jugados: " + equipo.getPartidosJugados());
            System.out.println();
        }
        return equipos;
    }

    public static Equipo buscarEquipoPorNombre(String nombre) {
        Equipo equipo = equipoDAO.buscarEquipoPorNombre(nombre);

        if (equipo != null) {
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Titulares: " + equipo.getTitulares());
            System.out.println("Suplentes: " + equipo.getSuplentes());
            System.out.println("Director Técnico: " + equipo.getDirectorTecnico());
            System.out.println("Puntos: " + equipo.getPuntos());
            System.out.println("Partidos jugados: " + equipo.getPartidosJugados());
        } else {
            System.out.println("Equipo no encontrado.");
        }
        return equipo;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return titulares == equipo.titulares && suplentes == equipo.suplentes && puntos == equipo.puntos && partidosJugados == equipo.partidosJugados && Objects.equals(nombre, equipo.nombre) && Objects.equals(directorTecnico, equipo.directorTecnico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
