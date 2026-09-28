import java.io.IOException;
import java.net.*;

public class HiloCliente extends Thread {
    private DatagramSocket conexion;
    private InetAddress ipServer;
    private int puerto = 25565;
    private boolean finHiloCliente;

    public HiloCliente() {
        finHiloCliente= false;
        try {
            System.out.println("Intentando conectar");
            ipServer = InetAddress.getByName("255.255.255.255");
            conexion = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {

        }enviarMensaje("Permiso");
    }

    private void procesarMensaje(DatagramPacket dp) {
        String msg = (new String(dp.getData())).trim();
        String[] mensajeCompuesto = msg.split("_");

        //aca va el mensajito de conexion je
    }

    public void enviarMensaje(String msg) {
        byte[] data = msg.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ipServer, puerto);
        try {
            conexion.send(dp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        while (!finHiloCliente) {
            byte[] data = new byte[1024];
            DatagramPacket dp = new DatagramPacket(data, data.length);
            try {
                conexion.receive(dp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            procesarMensaje(dp);
        }
    }
}