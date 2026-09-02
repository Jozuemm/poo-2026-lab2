# poo-2026-lab2
Laboratorio numero 2 de arreglos y excepciones
# INTEGRANTES

- Josué Morales Morataya
- Gabriel Yanes

# CARNETS

- 26588
- 26710

# ANALISIS 

1. Propiedades y metodos de las clases

Se utilizaran las clases Parque, PuntoAcceso, Visitante y Main.

Clase PuntoAcceso
Propiedades
- codigo
- nombre
- ubicacion
- capacidadMaximaPorHora
- estado
Métodos
- PuntoAcceso (Constructor)
- getters para poder acceder a las propiedades
- setCapacidadMaximaPorHora()
- setEstado()
- mostrarInformacion()

Clase Visitante
propiedad
- codigoDeEntrada
- nombre
- edad
- cantidadDeAtraccionesVisitadas
- puntosAcumulados
Métodos
- Visitante (Constructor)
- getters para acceder a las propiedades
- setNombre()
- setEdad()
- setAtraccionesVisitadas()
- setPuntosAcumulados()
- mostrarInformacion()

Clase Parque
Propiedades
- nombre
- CodigoIdentificacion
- NombreEncargado
- PuntosDeAcceso
- Visitantes<>
Métodos
- Parque (constructor)
- habilitarPuntoAcceso()
- obtenerPuntoAcceso()
- mostrarPuntosAcceso()
- modificarPuntoAcceso()
- cerrarPuntoAcceso()
- registrarVisitante()
- mostrarVisitantes()
- buscarVisitante()
- modificarVisitante()
- eliminarVisitante()
- contarPuntosHabilitados()
- contarEspaciosDisponibles()
- obtenerPuntoMayorCapacidad()
- obtenerVisitanteMayorPuntaje()
- obtenerVisitanteMasAtracciones()
- calcularPromedioEdad()
    
Clase Main
Metodos
- main()
- mostrarMenu()

2. Tipos de las propiedades y los métodos de cada clase

Clase Punto acceso
Propiedades
- codigo - int
- nombre - String
- ubicacion - String
- capacidadMaximaPorHora - int
- estado - String
Métodos
- PuntoAcceso - Constructor
- getCodigo() - int
- getNombre() - String
- getUbicacion() - String
- getCapacidadMaximaPorHora() - int
- getEstado() - String
- setCapacidadMaximaPorHora() - void
- setEstado() - void
- mostrarInformacion() - void

Clase Visitante
propiedad
- codigoDeEntrada - int
- nombre - String
- edad - int
- atraccionesVisitadas - int
- puntosAcumulados - int
Métodos
- Visitante - Constructor
- getCodigoEntrada() - int
- getNombre() - String
- getEdad() - int
- getAtraccionesVisitadas() - int
- getPuntosAcumulados - int
- setNombre() - void
- setEdad() - void
- setAtraccionesVisitadas() - void
- setPuntosAcumulados() - void
- mostrarInformacion() - void

Clase Parque
Propiedades
- nombre - String
- codigoIdentificacion - int
- nombreEncargado - String
- puntoAcceso - PuntoAcceso[]
- visitantes - ArrayList<Visitantes>
Métodos
- Parque - constructor
- habilitarPuntoAcceso() - boolean
- obtenerPuntoAcceso() - PuntoAcceso
- mostrarPuntosAcceso() - void
- modificarPuntoAcceso() - boolean
- cerrarPuntoAcceso() - boolean
- registrarVisitante() - boolean
- mostrarVisitantes() - void
- buscarVisitante() - Visitante
- modificarVisitante() - boolean
- eliminarVisitante() - boolean
- contarPuntosHabilitados() - int
- contarEspaciosDisponibles() - int
- obtenerPuntoMayorCapacidad() - PuntoAcceso
- obtenerVisitanteMayorPuntaje() - Visitante
- obtenerVisitanteMasAtracciones() - Visitante
- calcularPromedioEdad() - double

3. Propiedaades identificadas que deben implementarse con arreglo basico, que objetos almacenara y cual sera su tamaño

Habrá un arreglo básico puntoAcceso en la Clase Parque, el cual tendra un tamaño fijo de cinco posiciones. Las posiciones que aun no tengan un punto de acceso habilitado seran null

puntoAcceso = new PuntoAcceso[5]

4. Propiedades identificadas que deben implementarse usando ArrayList y que tipo de objetos almacenará

Habrá un ArrayList visitantes en la Clase Parque, el cual tendra un tamaño que podra cambiar. Almacenarpa objetos del tipo Visitante.

visitantes = new ArrayList<Visitante>();

5. Modificadores de visibilidad de los miembros de cada clase

Todas las propiedades de las clases seran private para el encapsulamiento, evitadno asi que otras clases modifiquen el estado de los objetos

Los constructores, getters, setter y los demas metodos van a ser public ya que esto permitirá que sena usados en otras clases.

Los metodos que solo se usen dentro de una clase van a ser private.

6. Parametros requeridos para los metodos en las Clases

Clase PuntoAcceso
- setCapacidadMaximaPorHora(int capacidad)
- setEstado(String estado)

Clase Visitante
- setNombre(String nombre)
- setEdad(int edad)
- setAtraccionesVisitadas(int cantidad)
- setPuntosAcumulados(int puntos)

Clase Parque
- habilitarPuntoAcceso(int posicion, PuntoAcceso puntoAcceso)
- obtenerPuntoAcceso(int posicion)
- modificarPuntoAcceso(int posicion, int nuevaCapacidad, String nuevoEstado)
- cerrarPuntoAcceso(int posicion)
- registrarVisitante(Visitante visitante)
- buscarVisitante(String codigoEntrada)
- modificarVisitante(String codigoEntrada,String nuevoNombre,int nuevaEdad, int nuevasAtracciones, int nuevosPuntos)
- eliminarVisitante(String codigoEntrada)

7. Como se daran valores iniciales a los obajetos, que valores deberan validarse andes de modificar el estado de los objetos

Los valores iniciales se daran en los constructores de las clases

Cuando Parque incie, el constructor inicializará el arreglo y el ArrayList

Cuando se construya un Punto de acceso se debera validar que la capacidad maxima por hora sea mayor que cero

Cuando se construya un Visitante hay que validar que la edad sea positiva, la cantidad de atracciones visitadas sea positiva o 0 y que los puntos acumulados sean positivos o 0

8. Como se determinará si una posicion del arreglo contiene un punto de acceso o null

Primero verificar que la posicion este dentro de los limites del arreglo con un if
Despues comparar el contenido con null (==nul)

9. Operaciones de busqueda, modificacion y eliminacion dentro del ArrayList

Buscar
Para buscar un visitante hay que recorrer el ArrayList y se comparará le codigo de entrada en cada objeto. En caso de encontrar una coincidencia, el metodo devolvera el objeto. Si termina el recorrido sin encontrarlo devolvera null. 

Modificar
Para modificar hay que buscar el visitante y si el resultado es diferente de null se utilizaran setters para cambiar la informacion

Eliminar
Para eliminar hay que recorrer el ArrayList con indices, en un for y luego ejecutar remove para para quitarlos.

10. Situaciones del programa que puden producir excepciones, excepciones que deberan manejarse y en que partes del programa se utilizara try-catch y finally

- El usuario ingresa texto cuando se espera un número - InputMismatchException
- La capacidad es menor o igual que cero - IllegalArgumentException
- La edad es menor o igual que cero - IllegalArgumentException
- Las atracciones visitadas son negativas - IllegalArgumentException
- Los puntos acumulados son negativos - IllegalArgumentException
- Se intenta acceder a una posición fuera del arreglo - ArrayIndexOutOfBoundsException