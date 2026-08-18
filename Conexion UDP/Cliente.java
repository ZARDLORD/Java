import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Ingresa tu nombre:");
        String nombre = read.nextLine();

        HiloCliente cliente = new HiloCliente(nombre);
        cliente.start();

        cliente.enviarMensaje("hola");

        while (true) {
            String mensaje = read.nextLine();
            cliente.enviarMensaje(mensaje);
        }
    }
}
