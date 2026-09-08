import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static Parque parque;
    
    public static void main(String[] args){
    
    System.out.println("=== PARQUE UNIVERSITARIO DE ATRACCIONES ===");
        System.out.println("Ingrese la información inicial del parque.");
        parque = crearParque();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            try {
                ejecutarOpcion(opcion);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (opcion != 13) {
                    System.out.println("Operación finalizada.");
                }
            }
        } while (opcion != 13);

        SCANNER.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n================ MENÚ ================");
        System.out.println("1. Nuevo parque");
        System.out.println("2. Habilitar punto de acceso");
        System.out.println("3. Consultar puntos de acceso");
        System.out.println("4. Consultar un punto de acceso");
        System.out.println("5. Modificar punto de acceso");
        System.out.println("6. Cerrar punto de acceso");
        System.out.println("7. Registrar visitante");
        System.out.println("8. Consultar visitantes");
        System.out.println("9. Buscar visitante");
        System.out.println("10. Modificar visitante");
        System.out.println("11. Eliminar visitante");
        System.out.println("12. Mostrar reporte del parque");
        System.out.println("13. Salir");
    }
 private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                parque = crearParque();
                System.out.println("El parque actual fue reemplazado.");
                break;
            case 2:
                habilitarPunto();
                break;
            case 3:
                parque.mostrarPuntosDeAcceso();
                break;
            case 4:
                consultarPunto();
                break;
            case 5:
                modificarPunto();
                break;
            case 6:
                cerrarPunto();
                break;
            case 7:
                registrarVisitante();
                break;
            case 8:
                parque.mostrarVisitantes();
                break;
            case 9:
                buscarVisitante();
                break;
            case 10:
                modificarVisitante();
                break;
            case 11:
                eliminarVisitante();
                break;
            case 12:
                mostrarReporte();
                break;
            case 13:
                System.out.println("Programa finalizado.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static Parque crearParque() {
        String nombre = leerTexto("Nombre del parque: ");
        int codigo = leerEntero("Código de identificación: ");
        String encargado = leerTexto("Nombre del encargado: ");
        return new Parque(nombre, codigo, encargado);
    }

    private static void habilitarPunto() {
        int posicion = leerPosicion();
        int codigo = leerEntero("Código del punto: ");
        String nombre = leerTexto("Nombre del punto: ");
        String ubicacion = leerTexto("Ubicación: ");
        int capacidad = leerEntero("Capacidad máxima por hora: ");
        String estado = leerTexto("Estado: ");

        PuntoDeAcceso punto = new PuntoDeAcceso(
                codigo, nombre, ubicacion, capacidad, estado);

        if (parque.habilitarPuntoDeAcceso(posicion, punto)) {
            System.out.println("Punto de acceso habilitado.");
        } else {
            System.out.println("La posición no es válida o ya está ocupada.");
        }
    }

    private static void consultarPunto() {
        int posicion = leerPosicion();
        PuntoDeAcceso punto = parque.obtenerPuntoDeAcceso(posicion);
        if (punto == null) {
            System.out.println("La posición no es válida o está vacía.");
        } else {
            punto.mostrarInformacion();
        }
    }

    private static void modificarPunto() {
        int posicion = leerPosicion();
        int capacidad = leerEntero("Nueva capacidad máxima por hora: ");
        String estado = leerTexto("Nuevo estado: ");
        if (parque.modificarPuntoDeAcceso(posicion, capacidad, estado)) {
            System.out.println("Punto de acceso modificado.");
        } else {
            System.out.println("La posición no es válida o está vacía.");
        }
    }

    private static void cerrarPunto() {
        int posicion = leerPosicion();
        if (parque.cerrarPuntoDeAcceso(posicion)) {
            System.out.println("Punto de acceso cerrado.");
        } else {
            System.out.println("La posición no es válida o está vacía.");
        }
    }

    private static void registrarVisitante() {
        int codigo = leerEntero("Código de entrada: ");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        int atracciones = leerEntero("Atracciones visitadas: ");
        int puntos = leerEntero("Puntos acumulados: ");

        Visitante visitante = new Visitante(
                codigo, nombre, edad, atracciones, puntos);

        if (parque.registrarVisitante(visitante)) {
            System.out.println("Visitante registrado.");
        } else {
            System.out.println("Ya existe un visitante con ese código.");
        }
    }

    private static void buscarVisitante() {
        int codigo = leerEntero("Código de entrada: ");
        Visitante visitante = parque.buscarVisitante(codigo);
        if (visitante == null) {
            System.out.println("No se encontró al visitante.");
        } else {
            visitante.mostrarInformacion();
        }
    }

    private static void modificarVisitante() {
        int codigo = leerEntero("Código del visitante: ");
        String nombre = leerTexto("Nuevo nombre: ");
        int edad = leerEntero("Nueva edad: ");
        int atracciones = leerEntero("Nueva cantidad de atracciones: ");
        int puntos = leerEntero("Nuevos puntos: ");

        if (parque.modificarVisitante(codigo, nombre, edad, atracciones, puntos)) {
            System.out.println("Visitante modificado.");
        } else {
            System.out.println("No se encontró al visitante.");
        }
    }

    private static void eliminarVisitante() {
        int codigo = leerEntero("Código del visitante: ");
        if (parque.eliminarVisitante(codigo)) {
            System.out.println("Visitante eliminado.");
        } else {
            System.out.println("No se encontró al visitante.");
        }
    }

    private static void mostrarReporte() {
        System.out.println("\n=== REPORTE DE " + parque.getNombre() + " ===");
        System.out.println("Código: " + parque.getCodigoIdentificacion());
        System.out.println("Encargado: " + parque.getNombreEncargado());
        System.out.println("Puntos habilitados: " + parque.contarPuntosHabilitados());
        System.out.println("Espacios disponibles: " + parque.contarEspaciosDisponibles());

        PuntoDeAcceso puntoMayor = parque.obtenerPuntoMayorCapacidad();
        if (puntoMayor == null) {
            System.out.println("No hay puntos de acceso habilitados.");
        } else {
            System.out.println("\nPunto de acceso con mayor capacidad:");
            puntoMayor.mostrarInformacion();
        }

        System.out.println("\nVisitantes registrados: "
                + parque.obtenerCantidadVisitantes());

        Visitante mayorPuntaje = parque.obtenerVisitanteMayorPuntaje();
        Visitante masAtracciones = parque.obtenerVisitanteMasAtracciones();

        if (mayorPuntaje == null) {
            System.out.println("No hay visitantes para calcular resultados.");
        } else {
            System.out.println("\nVisitante con mayor puntaje:");
            mayorPuntaje.mostrarInformacion();
            System.out.println("\nVisitante con más atracciones:");
            masAtracciones.mostrarInformacion();
            System.out.printf("%nPromedio de edad: %.2f%n",
                    parque.calcularPromedioEdad());
        }
    }

    private static int leerPosicion() {
        return leerEntero("Posición del punto de acceso (1-5): ") - 1;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = SCANNER.nextInt();
                SCANNER.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: debe ingresar un número entero.");
                SCANNER.nextLine();
            }
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return SCANNER.nextLine();
    }
}
