package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
        EquipoDAO equipoDAO = new EquipoDAO();
    }

    @Test
    void listarEquipos() {
        // Crea una lista de equipos para comparar
        List<Equipo> equiposEsperados = new ArrayList<>();
        equiposEsperados.add(new Equipo("Boca Juniors", 11, 7, "Jorge Almiron", 20, 10));
        equiposEsperados.add(new Equipo("River Plate", 11, 7, "Marcelo Gallardo", 18, 10));

        // Crea un objeto Main y llama al método listarEquipos()
        List<Equipo> equiposObtenidos = Equipo.listarEquipos();

        // Verifica que los equipos obtenidos sean iguales a los esperados
        assertEquals(equiposEsperados, equiposObtenidos);
    }

    @Test
    void buscarEquipoPorNombre() {
        // Crea un objeto Main y llama al método buscarEquipoPorNombre()
        Equipo equipoObtenido = Equipo.buscarEquipoPorNombre("Boca Juniors");

        // Verifica que el equipo obtenido tenga los valores esperados
        assertEquals("Boca Juniors", equipoObtenido.getNombre());
        assertEquals(11, equipoObtenido.getTitulares());
        assertEquals(7, equipoObtenido.getSuplentes());
        assertEquals("Jorge Almiron", equipoObtenido.getDirectorTecnico());
        assertEquals(20, equipoObtenido.getPuntos());
        assertEquals(10, equipoObtenido.getPartidosJugados());
    }
}