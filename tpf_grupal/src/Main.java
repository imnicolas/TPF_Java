import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Definir las credenciales de la base de datos
        String url = "jdbc:mysql://localhost:3306/nombre_de_la_bd";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        try {
            // Conectar con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Definir la consulta SQL
            String consulta = "SELECT nombre_equipo, num_jugadores_titulares, num_jugadores_suplentes, nombre_director, puntos, partidos_jugados FROM equipos";

            // Crear un objeto Statement para ejecutar la consulta
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta y obtener un objeto ResultSet con los resultados
            ResultSet resultados = statement.executeQuery(consulta);

            // Recorrer los resultados y mostrar la información por consola
            while (resultados.next()) {
                String nombreEquipo = resultados.getString("nombre_equipo");
                int numJugadoresTitulares = resultados.getInt("num_jugadores_titulares");
                int numJugadoresSuplentes = resultados.getInt("num_jugadores_suplentes");
                String nombreDirector = resultados.getString("nombre_director");
                int puntos = resultados.getInt("puntos");
                int partidosJugados = resultados.getInt("partidos_jugados");

                System.out.println("Equipo: " + nombreEquipo);
                System.out.println("Jugadores titulares: " + numJugadoresTitulares);
                System.out.println("Jugadores suplentes: " + numJugadoresSuplentes);
                System.out.println("Director: " + nombreDirector);
                System.out.println("Puntos: " + puntos);
                System.out.println("Partidos jugados: " + partidosJugados);
                System.out.println("-------------------------");
            }

            // Cerrar los recursos utilizados
            resultados.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}