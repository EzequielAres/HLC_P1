import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carrito {
    private ArrayList<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<Producto>();;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public boolean añadirProducto(Producto producto, int unidades) {
        if (producto.comprobarCantidad(unidades)) {
            producto.setUnidades(producto.getUnidades() - unidades);
            for (int i = 0; i < unidades; i++) {
                this.productos.add(producto);
            }
            return true;
        }
        return false;
    }

    public float calcularTotal() {
        float total = 0;
        for (Producto producto : this.productos) {
            total += producto.calcularPrecio();
        }
        return total;
    }

    public String factura() {
        String texto = "Productos: ";
        for (Producto producto : this.productos) {
            texto += producto.toString() + " / ";
        }
        texto += "|| Precio total: " + this.calcularTotal();
        return texto;
    }
}
