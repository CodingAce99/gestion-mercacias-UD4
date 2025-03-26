import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que gestiona las mercancías peligrosas.
 * Incluye la creación de un sistema de transporte, adición de mercancías y muestra de datos.
 */
public class GestionMercancias {
    public static void main(String[] args) {
        SistemaTransporte sistemaTransporte = new SistemaTransporte();
        sistemaTransporte.agregarMercancia(new Mercancia("Químico A", "España", "Francia", 100));
        sistemaTransporte.agregarMercancia(new Mercancia("Gas B", "Italia", "Alemania", 200));
        sistemaTransporte.mostrarMercancias();
    }
}

/**
 * Clase que representa una mercancía peligrosa.
 */
class Mercancia {
    private String nombre;
    private String origen;
    private String destino;
    private int cantidad;

    /**
     * Constructor para inicializar una mercancía.
     * @param nombre Nombre de la mercancía.
     * @param origen Lugar de origen.
     * @param destino Lugar de destino.
     * @param cantidad Cantidad de mercancía.
     */
    public Mercancia(String nombre, String origen, String destino, int cantidad) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.cantidad = cantidad;
    }

    /**
     * Método que devuelve la información formateada de la mercancía.
     * @return Información de la mercancía en formato String.
     */
    public String obtenerInformacion() {
        return "Mercancía: " + nombre + " | Origen: " + origen + " | Destino: " + destino + " | Cantidad: " + cantidad;
    }
}

/**
 * Clase que gestiona la logística y la lista de mercancías.
 */
class SistemaTransporte {
    private List<Mercancia> listaMercancias = new ArrayList<>();

    /**
     * Método para agregar una mercancía a la lista.
     * @param mercancia Objeto Mercancia que se desea agregar.
     */
    public void agregarMercancia(Mercancia mercancia) {
        listaMercancias.add(mercancia);
    }

    /**
     * Método para mostrar todas las mercancías registradas.
     */
    public void mostrarMercancias() {
        for (Mercancia mercancia : listaMercancias) {
            mostrarInformacionMercancia(mercancia);
        }
    }

    /**
     * Método que muestra la información de una mercancía específica.
     * @param mercancia Mercancia a mostrar.
     */
    private void mostrarInformacionMercancia(Mercancia mercancia) {
        System.out.println(mercancia.obtenerInformacion());
    }
}

