public class Flujo {
    public static void main(String[] args) {
        System.out.println("Inicio de Main");
        metodo1();
        System.out.println("Fin de Main");
    }
    private static void metodo1(){
        System.out.println("Inicio de metodo1");
        try {
            metodo2();
        }catch (MyException me){
            me.printStackTrace();
        }

        System.out.println("Fin de metodo1");
    }
    private static void metodo2(){
        System.out.println("Inicio de metodo2");
        throw new MyException("Mi excepcion fue lanzada");
    }
}
