public class Cliente {
    public static HiloCliente hc;
    public static void main(String[] main){

        System.out.println("Arrancando");
        hc = new HiloCliente();
        hc.start();
    }
}
