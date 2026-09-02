
public class PuntoDeAcceso {
    private int codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private String estado;

    public PuntoDeAcceso(int codigo, String nombre, String ubicacion, int capacidadMaximaPorHora, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        setCapacidadMaximaPorHora(capacidadMaximaPorHora);
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaximaPorHora() {
        return capacidadMaximaPorHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setCapacidadMaximaPorHora(int capacidadMaximaPorHora) {
        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException("La capacidad máxima por hora no puede ser cero o negativa.");
        }
        this.capacidadMaximaPorHora = capacidadMaximaPorHora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Capacidad Máxima por Hora: " + capacidadMaximaPorHora);
        System.out.println("Estado: " + estado);
    }


}