import java.util.Scanner;

public class Main {
    public static void menuCompra() {
        System.out.println("\n 1. Añadir un producto \n 2. Visualizar precio total \n 3. Terminar pedido");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    // añadir();
                    break;
                case 2:
                    // total():
                    break;
                case 3:
                    // terminarPedido();
                    break;
                default:
                    System.out.println("El número que has introducido es incorrecto");
            }
            break;
        }
    }

    public static void menuPrincipal() {
        System.out.println("Bienvenido/a!! \n 1. Hacer pedido \n 2. Salir");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num != 2 && num != 1) {
                System.out.println("El número que has introducido es incorrecto");
            } else if (num == 2) {
                System.exit(0);
            } else {
                menuCompra();
                break;
            }
        }
    }

    public static void main (String[] args) {
        menuPrincipal();
    }
}
