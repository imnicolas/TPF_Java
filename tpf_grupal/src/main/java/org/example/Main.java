package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static EquipoDAO equipoDAO = new EquipoDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        char continuar = 's';

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Listar todos los equipos");
            System.out.println("2. Buscar un equipo por nombre");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Equipo.listarEquipos();
                    System.out.print("Presione Enter para continuar...");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del equipo:");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    String nombreEquipo = scanner.nextLine();
                    Equipo.buscarEquipoPorNombre(nombreEquipo);
                    System.out.print("\nPresione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case 3:
                    continuar='n';
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (continuar!='n');

        scanner.close();
    }
}
