import java.util.ArrayList;

public class Parque {
    private String nombre;
    private int codigoIdentificacion;
    private String nombreEncargado;
    private PuntoDeAcceso[] puntosDeAcceso;
    private ArrayList<Visitante> visitantes;

public Parque(String nombre, int codigoIdentificacion, String nombreEncargado) {
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

    public boolean habilitarPuntoDeAcceso(int posicion, PuntoDeAcceso punto) {
        if (!posicionValida(posicion) || puntosDeAcceso[posicion] != null || punto == null) {
            return false;
        }
        puntosDeAcceso[posicion] = punto;
        return true;
    }

    public PuntoDeAcceso obtenerPuntoDeAcceso(int posicion) {
        if (!posicionValida(posicion)) {
            return null;
        }
        return puntosDeAcceso[posicion];
    }

    public void mostrarPuntosDeAcceso() {
        boolean hayPuntos = false;
        for (int i = 0; i < puntosDeAcceso.length; i++) {
            if (puntosDeAcceso[i] != null) {
                hayPuntos = true;
                System.out.println("\nPosición " + (i + 1) + ":");
                puntosDeAcceso[i].mostrarInformacion();
            }
        }
        if (!hayPuntos) {
            System.out.println("No hay puntos de acceso habilitados.");
        }
    }

    public boolean modificarPuntoDeAcceso(int posicion, int capacidad, String estado) {
        if (!posicionValida(posicion) || puntosDeAcceso[posicion] == null) {
            return false;
        }
        puntosDeAcceso[posicion].setCapacidadMaximaPorHora(capacidad);
        puntosDeAcceso[posicion].setEstado(estado);
        return true;
    }

    public boolean cerrarPuntoDeAcceso(int posicion) {
        if (!posicionValida(posicion) || puntosDeAcceso[posicion] == null) {
            return false;
        }
        puntosDeAcceso[posicion] = null;
        return true;
    }

    public int contarPuntosHabilitados() {
        int contador = 0;
        for (PuntoDeAcceso punto : puntosDeAcceso) {
            if (punto != null) {
                contador++;
            }
        }
        return contador;
    }

    public int contarEspaciosDisponibles() {
        return puntosDeAcceso.length - contarPuntosHabilitados();
    }

    public PuntoDeAcceso obtenerPuntoMayorCapacidad() {
        PuntoDeAcceso mayor = null;
        for (PuntoDeAcceso punto : puntosDeAcceso) {
            if (punto != null && (mayor == null || punto.getCapacidadMaximaPorHora() > mayor.getCapacidadMaximaPorHora())) {
                mayor = punto;
            }
        }
        return mayor;
    }

    public Visitante buscarVisitante(int codigoDeEntrada) {
        for (Visitante visitante : visitantes) {
            if (visitante.getCodigoDeEntrada() == codigoDeEntrada) {
                return visitante;
            }
        }
        return null;
    }

    public boolean registrarVisitante(Visitante visitante) {
        if (visitante == null || buscarVisitante(visitante.getCodigoDeEntrada()) != null) {
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
        for (Visitante visitante : visitantes) {
            System.out.println("\n-------------------------");
            visitante.mostrarInformacion();
        }
    }

    public boolean modificarVisitante(int codigoDeEntrada, String nombre,
            int edad, int atracciones, int puntos) {
        Visitante visitante = buscarVisitante(codigoDeEntrada);
        if (visitante == null) {
            return false;
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0.");
        }
        if (atracciones < 0) {
            throw new IllegalArgumentException("Las atracciones visitadas no pueden ser negativas.");
        }
        if (puntos < 0) {
            throw new IllegalArgumentException("Los puntos acumulados no pueden ser negativos.");
        }

        visitante.setNombre(nombre);
        visitante.setEdad(edad);
        visitante.setAtraccionesVisitadas(atracciones);
        visitante.setPuntosAcumulados(puntos);
        return true;
    }

    public boolean eliminarVisitante(int codigoDeEntrada) {
        for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getCodigoDeEntrada() == codigoDeEntrada) {
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
        Visitante mayor = null;
        for (Visitante visitante : visitantes) {
            if (mayor == null || visitante.getPuntosAcumulados() > mayor.getPuntosAcumulados()) {
                mayor = visitante;
            }
        }
        return mayor;
    }

    public Visitante obtenerVisitanteMasAtracciones() {
        Visitante mayor = null;
        for (Visitante visitante : visitantes) {
            if (mayor == null
                    || visitante.getAtraccionesVisitadas() > mayor.getAtraccionesVisitadas()) {
                mayor = visitante;
            }
        }
        return mayor;
    }

    public double calcularPromedioEdad() {
        if (visitantes.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (Visitante visitante : visitantes) {
            suma += visitante.getEdad();
        }
        return (double) suma / visitantes.size();
    }
}