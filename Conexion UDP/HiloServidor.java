import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class HiloServidor extends Thread{
    private DatagramSocket socket;
    private ArrayList<Usuario> clientes = new ArrayList<>();

    public HiloServidor(){
        try {
            socket = new DatagramSocket(25565);
            System.out.println("Servidor iniciado en el puerto 25565");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run(){
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer,buffer.length);

        while (true){
            try {
                socket.receive(dp);
                procesarDatagrama(dp);
            }catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    public void procesarDatagrama(DatagramPacket dp) {
        String contenido = new String(dp.getData(), 0, dp.getLength()).trim();
        System.out.println("Recibido: " + contenido);
        System.out.println("Puerto del paquete: " + dp.getPort());
        String[] partes = contenido.split("\\$");
        String nombre = partes[0];
        String mensaje = partes[1];

        if (mensaje.equals("hola")) {
            if (clientes.size() < 2) {
                Usuario nuevo = new Usuario(dp.getAddress(), dp.getPort(), clientes.size(), nombre);
                System.out.println("Puerto guardado en Usuario: " + nuevo.getPuerto());
                clientes.add(nuevo);
                enviarMensaje("Conectado como: " + nombre, nuevo);

                if (clientes.size() == 2) {
                    enviarMensaje("Se establecio conexion con: "+clientes.get(1).getNombre().toString(), clientes.get(0));
                    enviarMensaje("Se establecio conexion con: "+clientes.get(0).getNombre().toString(), clientes.get(1));
                }
            }
        } else {
            for (Usuario cliente : clientes) {
                if (!cliente.getNombre().equals(nombre)) {
                    enviarMensaje(nombre + ": " + mensaje, cliente);
                }
            }
        }
    }
    public void enviarMensaje(String data, Usuario destino)
    {
        byte[] msg = data.getBytes();
        DatagramPacket dp = new DatagramPacket(msg, msg.length,destino.getDireccion(),destino.getPuerto());
        try{
            socket.send(dp);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
