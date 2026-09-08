import java.util.Scanner;

public class Visitante {
    private int codigoDeEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    Scanner scanner = new Scanner(System.in);

    public Visitante() {
        this.codigoDeEntrada = setCodigoDeEntrada();
        this.nombre = setNombre();
        this.edad = setEdad();
        this.puntosAcumulados = setPuntosAcumulados();
        this.atraccionesVisitadas = setAtraccionesVisitadas();
    }

    public int getCodigoDeEntrada() {
        return codigoDeEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAtraccionesVisitadas() {
        return atraccionesVisitadas;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
    
    public int setCodigoDeEntrada(){
        System.out.println("Ingrese el código de entrada: ");
        while(true){
            try{
            int codigoDeEntrada = scanner.nextInt();
            scanner.nextLine();
            if (codigoDeEntrada<=0){
                throw new IllegalArgumentException("Este valor no es válido, intente de nuevo: ");
            }
            return codigoDeEntrada;
        }catch (Exception e){
        System.out.println("Este valor no es válido, intente de nuevo: ");
        codigoDeEntrada = scanner.nextInt();
        scanner.nextLine();
        }
    }
        
    }
    public String setNombre() {
        System.out.println("Ingrese su nombre: ");
        this.nombre = scanner.nextLine();
        return nombre;

    }

    public int setEdad() {
        while (true){
        try{
        System.out.println("Ingrese su edad: ");
        this.edad = scanner.nextInt();
        scanner.nextLine();
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo.");
        }

        return this.edad;
    }catch(Exception e){
        System.out.println("No se puede imprimir este valor, intente de nuevo: ");
        this.edad = scanner.nextInt();
        scanner.nextLine();
    }
    } 
}

    public int setAtraccionesVisitadas() {
        while(true){
        try{
        System.out.println("Ingrese la cantidad de atracciones: ");
        this.atraccionesVisitadas = scanner.nextInt();
        scanner.nextLine();
        
        if (atraccionesVisitadas<0){
            throw new IllegalArgumentException("Las atracciones deben de ser un número positivo");
        }
        return this.atraccionesVisitadas;
        

        } catch (Exception e){
            System.out.println("No se puede ingresar este valor, intente de nuevo: ");
            this.atraccionesVisitadas = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
    public int setPuntosAcumulados() {
        System.out.println("Ingrese la cantidad de puntos acumulados: ");
        while(true){
        try{

        
        
        this.puntosAcumulados = scanner.nextInt();
        scanner.nextLine();

        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException("Los puntos acumulados no pueden ser negativos.");
        }
        return this.puntosAcumulados;
    } catch (Exception e){
        System.out.println("Este valor no es válido, intente de nuevo: ");
        this.puntosAcumulados = scanner.nextInt();
        scanner.nextLine();
    }
}
    }   
    
    public void mostrarInformacion() {
        System.out.println("Código de Entrada: " + codigoDeEntrada);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Atracciones Visitadas: " + atraccionesVisitadas);
        System.out.println("Puntos Acumulados: " + puntosAcumulados);
    }
}
