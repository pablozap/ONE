public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Gerente gerente = new Gerente();
        gerente.setSalario(6000);
        gerente.setClave("sizas");
        System.out.println(gerente.iniciarSesion("siza"));
        System.out.println(gerente.getBonificacion() );


    }
}