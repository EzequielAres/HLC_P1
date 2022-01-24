import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void seleccionarProductoPerecedero(ProductoPerecedero[] perecederos, ProductoImperecedero[] imperecederos, Carrito carrito) {
        for (ProductoPerecedero producto : perecederos) {
            System.out.println(producto);
        }
        System.out.println("Seleccione el producto:");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int codigo = sc.nextInt();
            for (ProductoPerecedero producto : perecederos) {
                if (producto.getCodigo() == codigo) {
                    System.out.println("Seleccione las unidades deseadas:");
                    int unidades = sc.nextInt();
                    if (carrito.añadirProducto(producto, unidades)) {
                        menuCompra(perecederos, imperecederos, carrito);
                    }
                }
            }
            System.out.println("El producto no existe o no disponemos de las unidades introducidas");
            continue;
        }
    }

    public static void seleccionarProductoImperecedero(ProductoPerecedero[] perecederos, ProductoImperecedero[] imperecederos, Carrito carrito) {
        for (ProductoImperecedero producto : imperecederos) {
            System.out.println(producto);
        }
        System.out.println("Seleccione el producto:");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int codigo = sc.nextInt();
            for (ProductoImperecedero producto : imperecederos) {
                if (producto.getCodigo() == codigo) {
                    System.out.println("Seleccione las unidades deseadas:");
                    int unidades = sc.nextInt();
                    if (carrito.añadirProducto(producto, unidades)) {
                        menuCompra(perecederos, imperecederos, carrito);
                    }
                }
            }
            System.out.println("El producto no existe o no disponemos de las unidades introducidas");
            continue;
        }
    }

    public static void menuCompra(ProductoPerecedero[] perecederos, ProductoImperecedero[] imperecederos, Carrito carrito) {
        System.out.println("\n 1. Añadir un producto \n 2. Visualizar precio total \n 3. Terminar pedido");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Seleccione si quiere añadir un producto perecedero o imperecedero");
                    sc.nextLine();
                    while (true) {
                        String eleccion = sc.nextLine();
                        switch (eleccion) {
                            case "perecedero":
                                seleccionarProductoPerecedero(perecederos, imperecederos, carrito);
                                continue;
                            case "imperecedero":
                                seleccionarProductoImperecedero(perecederos, imperecederos, carrito);
                                continue;
                            default:
                                System.out.println("Error en la selección, vuelva a introducir el tipo de producto que desea");
                                continue;
                        }
                    }
                case 2:
                    if (carrito.getProductos().size() != 0) {
                        System.out.println("Total: " + carrito.calcularTotal());
                        continue;
                    } else {
                        System.out.println("El carrito está vacío");
                        continue;
                    }
                case 3:
                    if (carrito.getProductos().size() != 0) {
                        System.out.println(carrito.factura());
                        System.out.println("");
                        menuPrincipal(perecederos, imperecederos);
                    } else {
                        System.out.println("El carrito está vacío");
                        continue;
                    }
                default:
                    System.out.println("El número que has introducido es incorrecto");
            }
            break;
        }
    }

    public static void menuPrincipal(ProductoPerecedero[] perecederos, ProductoImperecedero[] imperecederos) {
        Carrito carrito = new Carrito();

        System.out.println("Bienvenido/a!! \n 1. Hacer pedido \n 2. Salir");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num != 2 && num != 1) {
                System.out.println("El número que has introducido es incorrecto");
            } else if (num == 2) {
                System.exit(0);
            } else {
                menuCompra(perecederos, imperecederos, carrito);
                break;
            }
        }
    }

    public static void main (String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        File archivoPerecederos = new File("src/perecederos.json");
        ProductoPerecedero[] perecederos = mapper.readValue(archivoPerecederos, ProductoPerecedero[].class);

        File archivoImperecederos = new File("src/imperecederos.json");
        ProductoImperecedero[] imperecederos = mapper.readValue(archivoImperecederos, ProductoImperecedero[].class);

        menuPrincipal(perecederos, imperecederos);
    }
}
