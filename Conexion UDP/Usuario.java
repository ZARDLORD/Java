import java.net.InetAddress;

public class Usuario {
    private InetAddress direccion;
    private int nUsuario;
    private int puerto;
    private String nombre;
    // Constructor para el servidor (cuando se registra un cliente)
    public Usuario(InetAddress direccion,  int puerto,int nUsuario, String nombre) {
        this.direccion = direccion;
        this.nUsuario = nUsuario;
        this.puerto = puerto;
        this.nombre = nombre;
    }
    // Constructor para el cliente (solo necesita el puerto del servidor)
    public Usuario(int puerto) {
        this.puerto = puerto;
    }

    public InetAddress getDireccion() { return direccion; }
    public void setDireccion(InetAddress direccion) { this.direccion = direccion; }
    public int getPuerto() { return puerto; }
    public void setPuerto(int puerto) { this.puerto = puerto; }
    public int getNUsuario() { return nUsuario; }
    public String getNombre() { return nombre; }
}
