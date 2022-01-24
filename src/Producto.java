public abstract class Producto {
    private int codigo;
    private String nombre;
    private float precio;
    private int unidades;

    public Producto(int codigo, String nombre, float precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float calcularPrecio() {
        return this.getPrecio();
    }

    public boolean comprobarCantidad(int cantidad) {
        if (this.getUnidades() - cantidad < 0) {
            return false;
        } else {
            return true;
        }
    }
}
