import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProductoPerecedero extends Producto {
    private Date caducidad;

    @JsonCreator
    public ProductoPerecedero( @JsonProperty("codigo") int codigo, @JsonProperty("nombre") String nombre, @JsonProperty("precio") float precio,
                               @JsonProperty("unidades") int unidades, @JsonProperty("caducidad") String caducidad) throws ParseException {
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
        long days = TimeUnit.MILLISECONDS.toDays(diffInMilies);
        //long diff = TimeUnit.DAYS.convert(diffInMilies, TimeUnit.MILLISECONDS);
        switch ((int) days) {
            case 3:
                return Math.round((this.getPrecio() - (this.getPrecio() / 2)) * 100.0f) / 100.0f;
            case 2:
                return Math.round((this.getPrecio() - (this.getPrecio() / 3)) * 100.0f) / 100.0f;
            case 1:
                return Math.round((this.getPrecio() - (this.getPrecio() / 4)) * 100.0f) / 100.0f;
            default:
                return this.getPrecio();
        }
    }

    @Override
    public String toString() {
        return super.getCodigo() + ", " + super.getNombre() + ", " + this.calcularPrecio();
    }
}
