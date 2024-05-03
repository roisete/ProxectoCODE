import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ruleta rule = new Ruleta();
        boolean menu = true;
        Scanner sc = new Scanner(System.in);
        Jugador jug1 = new Jugador(null, 0);
        System.out.println("Introduzca su nombre: ");
        String nombre = sc.nextLine();
        jug1.setNombreJugador(nombre);
        System.out.println("Introduzca su saldo inicial (mayor de 10 créditos): ");
        double saldo = sc.nextDouble();
        jug1.setSaldo(saldo);
        System.out.println("""
                ******************************
                **  BIENVENIDO A LA RULETA  **
                ******************************""");
        /*Modelo de menú PROVISIONAL para un solo jugador*/
        do {
            System.out.println("""
                    ******************************
                    ** ------------------------ **
                    ** 1. GIRA LA RULETA! (TEMP)**
                    ** 2. Comprueba las cuotas  **
                    ** 3. Ingrese más créditos  **
                    ** 4. Info del jugador      **
                    ** 5. Salir                 **
                    ** ------------------------ **
                    ******************************""");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: /*Realizar la apuesta*/
                    boolean giro = true;
                    do {
                        rule.toSpin();
                        System.out.println("\n¿Desea girar otra vez? (N para salir)");
                        sc.nextLine();
                        String continuar = sc.nextLine();
                        if (continuar.equalsIgnoreCase("N")) {
                            giro = false;
                        }
                        System.out.println("\n-----------------------------------------------");
                    } while (giro);
                    break;
                case 2: /*Comprobar las cuotas*/
                    System.out.println("En proceso");
                    System.out.println("-----------------------------------------------");
                    break;
                case 3: /*Llamamos a masSaldo() para añadir créditos*/
                    System.out.println("Cuánto desea añadir? (Deben ser 5 créditos o más) ");
                    double importe = sc.nextDouble();
                    jug1.setSaldo(jug1.masSaldo(importe));
                    System.out.println("Ahora dispone de " + jug1.getSaldo() + " créditos.");
                    System.out.println("-----------------------------------------------");
                    break;
                case 4: /*Llama al método toString()*/
                    System.out.println(jug1);
                    System.out.println("-----------------------------------------------");
                    break;
                case 5: /*Sale del programa*/
                    System.out.println("Muchas gracias por jugar!");
                    menu = false;
                    break;
                default:
                    System.out.println("Valor inválido.");
            }
        } while (menu);
    }
}
