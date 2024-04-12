import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ruleta rule = new Ruleta();
        rule.rellenar();
        boolean menu=true;
        Scanner sc = new Scanner(System.in);
        /*Modelo provisional de creación de jugador*/
        System.out.println("Introduzca su nombre: ");
        String nombre= sc.nextLine();
        System.out.println("Introduzca su saldo inicial: ");
        double saldo= sc.nextDouble();
        Jugador jug1 = new Jugador(nombre, saldo);
        System.out.println("""
                            ******************************
                            **  BIENVENIDO A LA RULETA  **
                            ******************************""");
        /*Modelo de menú PROVISIONAL para un solo jugador*/
        do{
            System.out.println("""
                    ******************************
                    ** ------------------------ **
                    ** 1. JUEGA!                **
                    ** 2. Comprueba las cuotas  **
                    ** 3. Ingrese más créditos  **
                    ** 4. Info del jugador      **
                    ** 5. Salir                 **
                    ** ------------------------ **
                    ******************************""");
            int opcion= sc.nextInt();
            switch(opcion){
                case 1: /*Realizar la apuesta*/
                    rule.toSpin();
                    System.out.println("\n-----------------------------------------------");
                    break;
                case 2: /*Comprobar las cuotas*/
                    System.out.println("En proceso");
                    System.out.println("-----------------------------------------------");
                    break;
                case 3: /*Llamamos a masSaldo() para añadir créditos*/
                    System.out.println("Cuánto desea añadir? (Deben ser 5 créditos o más) ");
                    double importe= sc.nextDouble();
                    jug1.setSaldo(jug1.masSaldo(importe));
                    System.out.println("Ahora dispone de "+jug1.getSaldo()+" créditos.");
                    System.out.println("-----------------------------------------------");
                    break;
                case 4: /*Llama al método toString()*/
                    System.out.println(jug1.toString());
                    System.out.println("-----------------------------------------------");
                    break;
                case 5: /*Sale del programa*/
                    System.out.println("Muchas gracias por jugar!");
                    menu=false;
                    break;
                default:
                    System.out.println("Valor inválido.");
            }
        }while(menu);
    }
}
