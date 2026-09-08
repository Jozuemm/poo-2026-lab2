import java.util.Scanner;
import java.util.ArrayList;

public class Parque {
    private String nombre;
    private int codigoIdentificacion;
    private String nombreEncargado;
    private PuntoDeAcceso[] puntosDeAcceso;
    private ArrayList<Visitante> visitantes;


    Scanner scanner = new Scanner(System.in);

    public Parque(){
        this.nombre = setNombre();
        this.codigoIdentificacion = setCodigoIdentificacion();
        this.nombreEncargado = setNombreEncargado();
        this.puntosDeAcceso = new PuntoDeAcceso[5];
        this.visitantes = new ArrayList<Visitante>();
    }


    public String getNombre() {
        return nombre;
    }
    public String setNombre(){
        System.out.println("Ingrese el nombre del parque: ");
        this.nombre = scanner.nextLine();
        return nombre;
    }

    public int getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public int setCodigoIdentificacion(){
        while(true){
        try{  
        System.out.println("Ingrese el código del parque: ");
        this.codigoIdentificacion = scanner.nextInt();
        scanner.nextLine();
        if(codigoIdentificacion<=0){
            throw new IllegalArgumentException("Este valor es inválido");
        }
        return this.codigoIdentificacion;
        }catch (Exception e){
            System.out.println("Este valor es inválido, intente de nuevo");

        }
    }
    }
    public String setNombreEncargado(){
        System.out.println("Ingrese el nombre del encargado del parque: ");
        this.nombreEncargado = scanner.nextLine();
        return nombreEncargado;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    private boolean posicionValida(int posicion) {
        return posicion >= 0 && posicion < puntosDeAcceso.length;
    }

    public boolean habilitarPuntoDeAcceso(int posicion) {
        if (!posicionValida(posicion)){
            return false;
        }

        puntosDeAcceso[posicion] = new PuntoDeAcceso();
        return true;
    }

    public PuntoDeAcceso obtenerPuntoDeAcceso(int posicion2) {
        if (!posicionValida(posicion2)) {
            System.out.println("No hay un punto de acceso en esta posición");
            return null;
        }
        return puntosDeAcceso[posicion2];
    }

    public void mostrarPuntosDeAcceso() {
        boolean existeAlMenosUno = false;

        for (int i = 0; i < puntosDeAcceso.length; i++) {
            if (puntosDeAcceso[i] != null) {
                existeAlMenosUno = true;
                System.out.println("Punto de Acceso en posición " + i + ":");
                puntosDeAcceso[i].mostrarInformacion();
            }
        }

        if (!existeAlMenosUno) {
            System.out.println("No hay puntos de acceso habilitados.");
        }
    }

    public boolean modificarPuntoDeAcceso(int posicion2) {
        if (!posicionValida(posicion2)) {
            return false;
        }
        if (puntosDeAcceso[posicion2] == null) {
            return false;
        }
        puntosDeAcceso[posicion2].setCapacidadMaximaPorHora();
        puntosDeAcceso[posicion2].setEstado();
        
        return true;
    }

    public boolean cerrarPuntoDeAcceso(int posicion){
        if (!posicionValida(posicion)) {
            return false;
        }
        if (puntosDeAcceso[posicion] == null) {
            return false;
        }
        puntosDeAcceso[posicion] = null;
        return true;
    }

    public int contarPuntosHabilitados() {
        int contador = 0;
        for (PuntoDeAcceso punto: puntosDeAcceso){
            if (punto != null){
                contador++;
            }
        }
        return contador;
    }

    public int contarEspaciosDisponibles() {
        return puntosDeAcceso.length - contarPuntosHabilitados();
    }
    public PuntoDeAcceso obtenerPuntoMayorCapacidad() {
        PuntoDeAcceso puntoMayor = null;
        for (PuntoDeAcceso punto: puntosDeAcceso){
            if (punto != null){
                if (puntoMayor == null || punto.getCapacidadMaximaPorHora() > puntoMayor.getCapacidadMaximaPorHora()) {
                    puntoMayor = punto;
                }
            }
        }
        return puntoMayor;
    }

    public Visitante buscarVisitante(int codigoDeEntrada){
        for (Visitante visitante: visitantes){
            if (visitante.getCodigoDeEntrada() == codigoDeEntrada){
                return visitante;
            }
        }
        return null;
    }

    public boolean registrarVisitante(Visitante visitante){
        if (visitante == null) {
            return false;
        }
        Visitante visitanteExistente = buscarVisitante(visitante.getCodigoDeEntrada());
        if (visitanteExistente != null) {
            return false;
        }
        visitantes.add(visitante);
        return true;
    }

    public void mostrarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
            return;
        }
        for (Visitante visitante: visitantes){
            System.out.println("---------------------------");
            visitante.mostrarInformacion();
        }
    }

    public boolean modificarVisitante(int codigoDeEntrada) {
        Visitante visitante = buscarVisitante(codigoDeEntrada);
        if (visitante == null) {
            return false;
        }
        visitante.setNombre();
        visitante.setEdad();
        visitante.setAtraccionesVisitadas();
        visitante.setPuntosAcumulados();
        return true;
    }

    public boolean eliminarVisitante(int codigoDeEntrada) {
        for (int i = 0; i < visitantes.size(); i++){
            Visitante visitante = visitantes.get(i);
            if (visitante.getCodigoDeEntrada() == codigoDeEntrada){
                visitantes.remove(i);
                return true;
            }
        }
        return false;
    }

    public int obtenerCantidadVisitantes() {
        return visitantes.size();
    }

    public Visitante obtenerVisitanteMayorPuntaje() {
        if(visitantes.isEmpty()) {
            return null;
        }
        Visitante visitanteMayor = visitantes.get(0);
        for (Visitante visitante: visitantes){
            if (visitante.getPuntosAcumulados() > visitanteMayor.getPuntosAcumulados()) {
                visitanteMayor = visitante;
            }
        }
        return visitanteMayor;
    }

    public Visitante obtenerVisitanteMasAtracciones(){
        if(visitantes.isEmpty()) {
            return null;
        }
        Visitante visitanteMasAtracciones = visitantes.get(0);
        for (Visitante visitante: visitantes){
            if(visitante.getAtraccionesVisitadas() > visitanteMasAtracciones.getAtraccionesVisitadas()) {
                visitanteMasAtracciones = visitante;
            }
        
    }
    return visitanteMasAtracciones;
    }

    public double calcularPromedioEdad() {
        if(visitantes.isEmpty()) {
            return 0.0;
        }

        int sumaEdades = 0;
        for(Visitante visitante: visitantes){
            sumaEdades += visitante.getEdad();
        }
        return (double) sumaEdades / visitantes.size();

    }
}
