import java.lang.reflect.Array;
import java.net.*;
import java.io.IOException;

public class HiloServidor extends Thread{
    private boolean finHiloServidor = false;
    private DatagramSocket socket;

    private static Usuario[] usuarios = new Usuario[2];

    public HiloServidor(){
        try {
            socket = new DatagramSocket(25565);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(!finHiloServidor){
            byte[] datos = new byte[1024];
            DatagramPacket dp = new DatagramPacket(datos, datos.length);
            try {
                socket.receive(dp);
                procesarMensaje(dp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void procesarMensaje(DatagramPacket dp) {
        String msg = new String(dp.getData()).trim();
        //registrar ambos usuarios, recordar hacer un array de usuarios y establecer una verificacion inicial
        Usuario agabro = new Usuario("agabro", Main.pokemons);
        Usuario wacho = new Usuario("Wachofalse", Main.pokemons2);
        usuarios[0]=agabro;
        usuarios[1]=wacho;
        if (msg.equals("Permiso")) {
            //aca los vamos registrasndo viste
        }
    }

    public void enviarMensaje(String msg, InetAddress ip, int puerto){
        byte[] data = msg.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ip, puerto);// aca va la ip cliente y Puerto cuando averigue como
        try {
            socket.send(dp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void enviarMensajeATodos(String msg){
    }
}
