import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class HiloCliente extends Thread{
    private Usuario servidor;
    private DatagramSocket socket;
    private String miNombre;
    public HiloCliente(String nombre)
    {
        this.miNombre=nombre;
        try{
            socket = new DatagramSocket();
            servidor = new Usuario(25565);
            servidor.setDireccion(InetAddress.getByName("localhost"));
        }catch (Exception e){throw new RuntimeException(e);}
    }
    @Override
    public void run(){
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        while (true) {
            try {
                socket.receive(dp);
                String mensaje = new String(dp.getData(), 0, dp.getLength()).trim();
                System.out.println(mensaje);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void enviarMensaje(String texto) {
        String data = miNombre + "$" + texto;
        byte[] msg = data.getBytes();
        DatagramPacket dp = new DatagramPacket(msg, msg.length, servidor.getDireccion(), servidor.getPuerto());
        try {
            socket.send(dp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
