import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProductoPerecedero extends Producto {
    private Date caducidad;

    public ProductoPerecedero(int codigo, String nombre, float precio, int unidades, String caducidad) throws ParseException {
        super(codigo, nombre, precio, unidades);
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.caducidad = formato.parse(caducidad);
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public float calcularPrecio() {
        Date fechaActual = new Date();
        long diffInMilies = Math.abs(fechaActual.getTime() - this.getCaducidad().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMilies, TimeUnit.MILLISECONDS);
        switch ((int) diff) {
            case -3:
                return this.getPrecio() - (this.getPrecio() / 2);
            case -2:
                return this.getPrecio() - (this.getPrecio() / 3);
            case -1:
                return this.getPrecio() - (this.getPrecio() / 4);
            default:
                return this.getPrecio();
        }
    }

    @Override
    public String toString() {
        return super.getCodigo() + ", " + super.getNombre() + ", " + this.calcularPrecio();
    }
}
