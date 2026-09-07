import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static int opcion;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Parque> parques = new ArrayList<>();
    
    public static void opcion(int opcion){
        while (true)
        if (opcion == 1){
            parques.add(new Parque());
        }
        else if (opcion == 2){
            System.out.println("Ingrese la posición (del 1 al 5) en la que ingresará el punto de acceso: ");
            int posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){
                habilitarPuntoDeAcceso(posicion);
                
            }
    }
}
    public static void main(String[] args){
    

    System.out.println("Ingrese una de las siguientes opciones: ");
    System.out.println("1. Habilitar nuevo parque");
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
    System.out.println("13. Salir: ");

    opcion = scanner.nextInt();
    scanner.nextLine();
    
    opcion(opcion);
    
    }
}