import java.util.Arrays;

public class Carrito {
    private Producto[] productos;

    public Carrito(Producto[] productos) {
        this.productos = productos;
    }

    public float calcularTotal() {
        float total = 0;
        for (Producto producto : this.productos) {
            total += producto.calcularPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        String texto = "Productos: ";
        for (Producto producto : this.productos) {
            texto += producto.toString() + "/ ";
        }
        return texto;
    }
}
