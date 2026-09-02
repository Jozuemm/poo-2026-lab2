

public class Visitante {
    private int codigoDeEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(int codigoDeEntrada, String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados) {
        this.codigoDeEntrada = codigoDeEntrada;
        this.nombre = nombre;
        setEdad(edad);
        setAtraccionesVisitadas(atraccionesVisitadas);
        setPuntosAcumulados(puntosAcumulados);
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo.");
        }
        this.edad = edad;
    }

    public void setAtraccionesVisitadas(int atraccionesVisitadas) {
        if (atraccionesVisitadas < 0) {
            throw new IllegalArgumentException("El número de atracciones visitadas no puede ser negativo.");
        }
        this.atraccionesVisitadas = atraccionesVisitadas;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException("Los puntos acumulados no pueden ser negativos.");
        }
        this.puntosAcumulados = puntosAcumulados;
    }   
    
    public void mostrarInformacion() {
        System.out.println("Código de Entrada: " + codigoDeEntrada);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Atracciones Visitadas: " + atraccionesVisitadas);
        System.out.println("Puntos Acumulados: " + puntosAcumulados);
    }
}
