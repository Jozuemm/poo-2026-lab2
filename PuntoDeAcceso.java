import java.util.Scanner;

public class PuntoDeAcceso {
    private int codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private String estado;

    Scanner scanner = new Scanner(System.in);

    public PuntoDeAcceso() {
        this.codigo = setCodigo();
        this.nombre = setNombre();
        this.ubicacion = setUbicacion();
        this.capacidadMaximaPorHora = setCapacidadMaximaPorHora();
        this.estado = setEstado();
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
    public int setCodigo() {
    System.out.println("Ingrese el código del punto de acceso: ");
        while (true){
        try{
        int codigo = scanner.nextInt();
        scanner.nextLine();
        if (codigo <= 0) {
            throw new IllegalArgumentException("La capacidad máxima por hora no puede ser cero o negativa.");
        }
        return codigo;
        
    }catch (Exception e){
        System.out.println("Este valor es invalido, intente de nuevo: ");
        codigo = scanner.nextInt();
        scanner.nextLine();
    }
}
}

    public String setNombre(){
        System.out.println("Ingrese el nombre del punto de acceso: ");
        String nombre = scanner.nextLine();
        return nombre;
    }

    public String setUbicacion(){
    System.out.println("Ingrese la ubicación del punto de acceso: ");
    String ubicacion = scanner.nextLine();
    return ubicacion;
    }

    public int setCapacidadMaximaPorHora() {
        System.out.println("Ingrese la Capacidad Maxima por hora: ");
        while (true){
        try{
        this.capacidadMaximaPorHora = scanner.nextInt();
        scanner.nextLine();
        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException("La capacidad máxima por hora no puede ser cero o negativa.");
        }
        return this.capacidadMaximaPorHora;
        
    }catch (Exception e){
        System.out.println("Este valor es invalido, intente de nuevo: ");
        this.capacidadMaximaPorHora = scanner.nextInt();
        scanner.nextLine();
    }
}
}

    public String setEstado() {
        System.out.println("Ingresa el estado del punto de acceso: ");
        this.estado = scanner.nextLine();
        return estado;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Capacidad Máxima por Hora: " + capacidadMaximaPorHora);
        System.out.println("Estado: " + estado);
    }


}