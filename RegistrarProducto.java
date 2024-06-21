package registrarproducto;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author Salvador CHavez Klarencce Raul
 */

class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock;
    }
}
     
public class RegistrarProducto {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> listaProductos = new ArrayList<>();

        System.out.println("Bienvenido al registro de productos en Allis - Tienda de Abarrotes");

        boolean continuar = true;
        while (continuar) {
            try {
                System.out.print("Ingrese el nombre del producto: ");
                String nombreProducto = scanner.nextLine();

                System.out.print("Ingrese el precio del producto: ");
                double precioProducto = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer de entrada

                System.out.print("Ingrese la cantidad en stock del producto: ");
                int stockProducto = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                // Validación de datos
                if (precioProducto <= 0 || stockProducto < 0) {
                    throw new IllegalArgumentException("El precio debe ser mayor que cero y el stock no puede ser negativo.");
                }

                Producto producto = new Producto(nombreProducto, precioProducto, stockProducto);
                listaProductos.add(producto);

                System.out.println("¡Producto registrado con éxito!");
                System.out.println("Nombre del producto: " + producto.getNombre());
                System.out.println("Precio del producto: " + producto.getPrecio());
                System.out.println("Stock disponible: " + producto.getStock());

                // Preguntar al usuario si quiere registrar otro producto
                System.out.print("¿Desea registrar otro producto? (Sí/No): ");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("S")) {
                    continuar = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico válido para el precio y el stock.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nLista de productos registrados:");
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }

        scanner.close();
    }
}
