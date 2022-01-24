import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoImperecedero extends Producto {
    int descuento;

    @JsonCreator
    public ProductoImperecedero(@JsonProperty("codigo") int codigo, @JsonProperty("nombre") String nombre, @JsonProperty("precio") float precio,
                                @JsonProperty("unidades") int unidades, @JsonProperty("descuento") int descuento) {
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
