
import java.util.ArrayList;

public class Parque {
    private String nombre;
    private int codigoIdentificacion;
    private String nombreEncargado;
    private PuntoDeAcceso[] puntosDeAcceso;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, int codigoIdentificacion, String nombreEncargado){
        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreEncargado = nombreEncargado;
        this.puntosDeAcceso = new PuntoDeAcceso[5];
        this.visitantes = new ArrayList<Visitante>();
    }


    public String getNombre() {
        return nombre;
    }

    public int getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    private boolean posicionValida(int posicion) {
        return posicion >= 0 && posicion < puntosDeAcceso.length;
    }

    public boolean habilitarPuntoDeAcceso(int posicion, PuntoDeAcceso puntoDeAcceso) {
        if (!posicionValida(posicion)){
            return false;
        }
        if (puntosDeAcceso[posicion] != null) {
            return false;
        }
        if (puntoDeAcceso == null) {
            return false;
        }
        puntosDeAcceso[posicion] = puntoDeAcceso;
        return true;
    }

    public PuntoDeAcceso obtenerPuntoDeAcceso(int posicion) {
        if (!posicionValida(posicion)) {
            return null;
        }
        return puntosDeAcceso[posicion];
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

    public boolean modificarPuntoDeAcceso(int posicion, int nuevaCapacidad, String nuevoEstado) {
        if (!posicionValida(posicion)) {
            return false;
        }
        if (puntosDeAcceso[posicion] == null) {
            return false;
        }
        puntosDeAcceso[posicion].setCapacidadMaximaPorHora(nuevaCapacidad);
        puntosDeAcceso[posicion].setEstado(nuevoEstado);
        
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

    public boolean modificarVisitante(int codigoDeEntrada, String nuevoNombre, int nuevaEdad, int nuevasAtracciones, int nuevosPuntos) {
        Visitante visitante = buscarVisitante(codigoDeEntrada);
        if (visitante == null) {
            return false;
        }
        if (nuevaEdad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo.");
        }
        if (nuevasAtracciones < 0) {
            throw new IllegalArgumentException("El número de atracciones visitadas no puede ser negativo.");
        }
        if (nuevosPuntos < 0) {
            throw new IllegalArgumentException("Los puntos acumulados no pueden ser negativos.");
        }
        visitante.setNombre(nuevoNombre);
        visitante.setEdad(nuevaEdad);
        visitante.setAtraccionesVisitadas(nuevasAtracciones);
        visitante.setPuntosAcumulados(nuevosPuntos);
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
