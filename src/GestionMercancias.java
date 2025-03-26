/**
 * Clase principal que gestiona las mercancías peligrosas.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMercancias {
    public static void main(String[] args) {
        SistemaTransporte sistemaTransporte = new SistemaTransporte();

        sistemaTransporte.agregarMercancia(new Mercancia("Químico A", "España", "Francia", 100));
        sistemaTransporte.agregarMercancia(new Mercancia("Gas B", "Italia", "Alemania", 200));

        sistemaTransporte.mostrarMercancias();
        sistemaTransporte.mostrarTotalMercancias();

        // Filtro por país
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un país de destino para filtrar: ");
        String destinoFiltro = scanner.nextLine();
        sistemaTransporte.mostrarMercanciasPorDestino(destinoFiltro);
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

    public Mercancia(String nombre, String origen, String destino, int cantidad) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.cantidad = cantidad;
    }

    public String obtenerInformacion() {
        return "Mercancía: " + nombre + " | Origen: " + origen + " | Destino: " + destino + " | Cantidad: " + cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCantidad() {
        return cantidad;
    }
}

/**
 * Clase que gestiona la logística de transporte.
 */


class SistemaTransporte {
    private List<Mercancia> listaMercancias = new ArrayList<>();

    public void agregarMercancia(Mercancia mercancia) {
        if (!mercanciaDuplicada(mercancia)) {
            listaMercancias.add(mercancia);
            System.out.println("Mercancía agregada correctamente.");
        } else {
            System.out.println("Error: La mercancía ya está registrada.");
        }
    }

    private boolean mercanciaDuplicada(Mercancia nuevaMercancia) {
        return listaMercancias.stream().anyMatch(m ->
                m.getNombre().equalsIgnoreCase(nuevaMercancia.getNombre()) &&
                        m.getOrigen().equalsIgnoreCase(nuevaMercancia.getOrigen()) &&
                        m.getDestino().equalsIgnoreCase(nuevaMercancia.getDestino()));
    }

    public void mostrarMercancias() {
        System.out.println("\nListado de todas las mercancías:");
        for (Mercancia mercancia : listaMercancias) {
            System.out.println(mercancia.obtenerInformacion());
        }
    }

    public void mostrarTotalMercancias() {
        int total = listaMercancias.stream().mapToInt(Mercancia::getCantidad).sum();
        System.out.println("Cantidad total de mercancías transportadas: " + total + " unidades");
    }

    public void mostrarMercanciasPorDestino(String destino) {
        System.out.println("\nMercancías con destino a " + destino + ":");
        listaMercancias.stream()
                .filter(m -> m.getDestino().equalsIgnoreCase(destino))
                .forEach(m -> System.out.println(m.obtenerInformacion()));
    }
}

