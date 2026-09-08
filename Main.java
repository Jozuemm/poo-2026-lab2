import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static int opcion;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Parque> parques = new ArrayList<>();
    
    public static void main(String[] args){
    
    do{

    System.out.println("-----------------------------");
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
    
    switch (opcion){
        case 1:
            System.out.println("-----------------------------");
            parques.add(new Parque());
            break;

        case 2:
            System.out.println("-----------------------------");
            System.out.println("Ingrese la posición (de 1 a " + parques.size() + ") en la que ingresará el punto de acceso: ");
            int posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){
                try{
                if (posicion>parques.size() || posicion < 0){
                    throw new IllegalArgumentException("Esta posición no entra en el rango");
                }
                else{
                parques.get(posicion).habilitarPuntoDeAcceso(posicion);
            }
            } catch (Exception e){
                System.out.println("Valor de posición inválido");
            }
            }
            else{
                System.out.println("No ha ingresado ningún parque.");
            }
            break;
        
        case 3: 
            System.out.println("-----------------------------");
            for (int i = 0; i<parques.size(); i++){
                parques.get(i).mostrarPuntosDeAcceso();
            }
            break;

        case 4:
            System.out.println("-----------------------------");
            System.out.println("Ingrese la posición (de 1 a " + parques.size() + ") del parque en el que desea ver el punto de acceso: ");
            posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){
                try{
                    if (posicion>parques.size() && posicion < 0){
                        throw new IllegalArgumentException("Valor inválido de posición");
                    }
                    else{
                        System.out.println("Ingrese la posición del punto de acceso (1 a 5): ");
                        int posicion2 = scanner.nextInt()-1;
                        try{
                        if (posicion2 < 0 || posicion > 4){
                            throw new IllegalArgumentException("Esta posición no es válida");
                        }
                        else{
                        PuntoDeAcceso punto =parques.get(posicion).obtenerPuntoDeAcceso(posicion2);
                        punto.mostrarInformacion();
                    }
                    }catch (Exception e){
                        System.out.println("Esta posición no es válida");
                    }
                }
                }catch (Exception e){
                    System.out.println("Este valor es inválido");
                }
            }
            break;

        case 5: 
            System.out.println("-----------------------------");
            System.out.println("Ingrese la posición (de 1 a " + parques.size() + ") de la que desea modificiar el punto de acceso: ");
            posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){

                try{
                    if (posicion>parques.size() && posicion < 0){
                        throw new IllegalArgumentException("Posición inválida");
        }
                    else{
                        System.out.println("Ingrese la posición del punto de acceso (1 a 5): ");
                        int posicion2 = scanner.nextInt()-1;
                        try{
                        if (posicion2 < 0 && posicion > 4){
                            throw new IllegalArgumentException("Esta posición no es válida");
                        }
                        else{
                        parques.get(posicion).modificarPuntoDeAcceso(posicion2);
                    }
                    }   catch (Exception e){
                        System.out.println("Esta posición no es válida");
                    }
                }
        }       catch (Exception e){
                    System.out.println("Este valor de posición es inválida");
        }
    }
            else{
                System.out.println("No ha ingresado ningún parque.");
        }
        break;

        case 6:
            System.out.println("-----------------------------");
            System.out.println("Ingrese la posición (de 1 a " + parques.size() + ") de la que desea cerrar el punto de acceso: ");
            posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){
                try{
                if (posicion>parques.size() && posicion < 0){
                    throw new IllegalArgumentException("Ese valor de posición es inválido.");
                }
                else{
                    parques.get(posicion).cerrarPuntoDeAcceso(posicion);
                }
            }catch (Exception e){
                System.out.println("Valor de posición inválido");
            } 
        }
        break;

        case 7:
            System.out.println("-----------------------------");
            System.out.println("Ingresa la posición(de 1 a " + parques.size() + ") en el que se registrará el visitante: ");
            posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){
                try{
                    if (posicion>parques.size() && posicion < 0){
                        throw new IllegalArgumentException("Esta posición no se encuentra disponible");
                    }
                    else{
                        Visitante visitante = new Visitante();
                        parques.get(posicion).registrarVisitante(visitante);
                    }
                }catch (Exception e){
                    System.out.println("Este valor de posición no es válido");
                }
            }
            else{
                System.out.println("No ha ingresado ningún parque");
            }
            break;
        case 8:
            System.out.println("-----------------------------");
            for (int i = 0; i<parques.size(); i++){
                parques.get(i).mostrarVisitantes();
            }
            break;
        
        case 9:
            System.out.println("-----------------------------");
            System.out.println("Ingrese el código de entrada del visitante: ");
            int codigoDeEntrada = scanner.nextInt();
            scanner.nextLine();
            if (!parques.isEmpty()){
                try{
                    if (codigoDeEntrada<0){
                        throw new IllegalArgumentException("El código de entrada no puede ser menor a 0");
                    }
                    else{
                        for (int i = 0; i<parques.size(); i++){
                            Visitante visitant = parques.get(i).buscarVisitante(codigoDeEntrada);
                            if (visitant != null){
                                visitant.mostrarInformacion();
                                break;
                            }
                        }
                        
                    }
                } catch(Exception e){
                    System.out.println("El valr del código de entrada no es válido");
                }
            }
            else{
                System.out.println("No ha ingresado ningún parque");
            }
            break;

        case 10:
            System.out.println("-----------------------------");
            System.out.println("Ingrese el código de entrada del visitante: ");
            codigoDeEntrada = scanner.nextInt();
            scanner.nextLine();
            if (!parques.isEmpty()){
                try{
                    if (codigoDeEntrada<0){
                        throw new IllegalArgumentException("El código de entrada no puede ser menor a 0");
                    }
                    else{
                        for (int i = 0; i<parques.size(); i++){
                            parques.get(i).modificarVisitante(codigoDeEntrada);
                        }
                    }
                } catch(Exception e){
                    System.out.println("El valor del código de entrada no es válido");
                }
            }
            else{
                System.out.println("No ha ingresado ningún parque");
            }
            break;
        
        case 11:
            System.out.println("-----------------------------");
            System.out.println("Ingrese el código de entrada del visitante: ");
            codigoDeEntrada = scanner.nextInt();
            scanner.nextLine();
            if (!parques.isEmpty()){
                try{
                    if (codigoDeEntrada<0){
                        throw new IllegalArgumentException("El código de entrada no puede ser menor a 0");
                    }
                    else{
                        for (int i = 0; i<parques.size(); i++){
                            parques.get(i).eliminarVisitante(codigoDeEntrada);
                        }
                    }
                } catch(Exception e){
                    System.out.println("El valr del código de entrada no es válido");
                }
            }
            else{
                System.out.println("No ha ingresado ningún parque");
            }
            break;

        case 12:
            System.out.println("-----------------------------");
            System.out.println("Ingresa la posición(de 1 a " + parques.size() + ") en el que se hará el reporte: ");
            posicion = scanner.nextInt()-1;
            if (!parques.isEmpty()){
                try{
                    if (posicion>parques.size() && posicion < 0){
                        throw new IllegalArgumentException("Esta posición no se encuentra disponible");
                    }
                    else{
                    System.out.println("-----------------------------");
                    System.out.println("La cantidad de puntos es de:" +
                        parques.get(posicion).contarPuntosHabilitados() );
                    System.out.println("El punto de acceso con mayor cantidad es de: " +
                        parques.get(posicion).obtenerPuntoMayorCapacidad()
                    ); 
                    System.out.println("La cantidad de visitantes es de: " +
                        parques.get(posicion).obtenerCantidadVisitantes()
                    );
                    System.out.println("El visitante con mayor puntaje es: " +
                        parques.get(posicion).obtenerVisitanteMayorPuntaje()
                    );
                    System.out.println("El visitante con más atracciones es: " +
                        parques.get(posicion).obtenerVisitanteMasAtracciones()
                    );
                    System.out.println("El promedio de Edad es de: " + 
                        parques.get(posicion).calcularPromedioEdad()
                    );
                    }
                }catch (Exception e){
                    System.out.println("Este valor de posición no es válido");
                }
            }
            break;

        case 13:
            System.out.println("Programa finalizado");
            break;
        
        default:
            System.out.println("Opción inválida");
        }
    }while(opcion!=13);
    }
}
        