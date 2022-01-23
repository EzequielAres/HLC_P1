public class ProductoImperecedero extends Producto {
    int descuento;

    public ProductoImperecedero(int codigo, String nombre, float precio, int unidades, int descuento) {
        super(codigo, nombre, precio, unidades);
        this.descuento = descuento;
    }

    public int getDecuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float calcularPrecio() {
        return this.getPrecio() - ((this.getPrecio() * this.getDecuento()) / 100);
    }

    @Override
    public String toString() {
        return super.getCodigo() + ", " + super.getNombre() + ", " + this.calcularPrecio();
    }
}
