import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*Creación de la ruleta y el jugador*/
        Ruleta rule = new Ruleta();
        boolean menu = true;
        Scanner sc = new Scanner(System.in);
        Jugador jug1 = new Jugador(null, 0);
        System.out.println("Introduzca su nombre: ");
        String nombre = sc.nextLine();
        jug1.setNombreJugador(nombre);
        System.out.println("Introduzca su saldo inicial");
        double saldo = sc.nextDouble();
        jug1.setSaldo(saldo);
        System.out.println("""
                ******************************
                **  BIENVENIDO A LA RULETA  **
                ******************************""");
        /*Menú para un solo Jugador*/
        do {
            System.out.println("""
                    ******************************
                    ** ------------------------ **
                    ** 1. Apostar               **
                    ** 2. Comprueba las cuotas  **
                    ** 3. Ingrese más créditos  **
                    ** 4. Info del jugador      **
                    ** 5. Salir                 **
                    ** ------------------------ **
                    ******************************""");
            int opcion = sc.nextInt();
            /*Si el jugador no dispone de saldo irá directamente a la opción de ingresar créditos*/
            if (jug1.getSaldo()<=0){
                System.out.println("Debe añadir créditos");
                opcion=3;
            }
            switch (opcion) {
                case 1: /*Realizar la apuesta*/
                    boolean giro = true;
                    do {
                        rule.toSpin(); /*Gira la ruleta*/
                        double ganancia= apuesta(jug1.getSaldo(), rule.getCasilla(), rule.getColor()); /*Se llama al método apuesta()*/
                        System.out.printf("Ha salido el %d %s\n", rule.getCasilla(),rule.getColor());
                        if(ganancia<0){
                            System.out.println("¡Más suerte la próxima vez!");
                        }else{
                            System.out.printf("¡Enhorabuena! Ha ganado "+ganancia+" créditos\n");
                        }
                        jug1.setSaldo(jug1.getSaldo()+ganancia); /*Se añade o quita el saldo al jugador*/
                        System.out.println("¿Desea girar otra vez? (N para salir)");
                        sc.nextLine();
                        String continuar = sc.nextLine();
                        if (continuar.equalsIgnoreCase("N")) {
                            giro = false;
                        }
                        System.out.println("\n-----------------------------------------------");
                    } while (giro);
                    break;
                case 2: /*Comprobar las cuotas*/
                    System.out.println("""
                            NÚMERO = 36X
                            COLOR  =  2X
                            TERCIO =  3X
                            MITAD  =  2X""");
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

    /**
     * Método para realizar una apuesta
     * @param saldo El saldo actual (para no apostar más que el saldo)
     * @param casilla La casilla que ha salido
     * @param color El color de la casilla que ha salido
     * @return La ganancia generada con esa apuesta
     * @throws InputMismatchException Salta si no se introduce un número
     */
   public static double apuesta(double saldo, int casilla, String color) throws InputMismatchException{
        Scanner sc = new Scanner(System.in);
        double apuesta;
        System.out.println("""
                           Seleccione su apuesta
                           0. Numero
                           1. Rojo
                           2. Negro
                           3. Primer tercio
                           4. Segundo tercio
                           5. Tercer tercio
                           6. Primera mitad
                           7. Segunda mitad
                           """);
        int seleccion = sc.nextInt();
       do{
           System.out.println("¿Cuanto quiere apostar? (Valor dentro del saldo)");
           apuesta = sc.nextDouble();
       }while (apuesta <=0 || apuesta>saldo);
        switch (seleccion) {
            case 0 -> {
                int numRule;
                System.out.println("Seleccione la casilla por la que quiere apostar:");
                numRule = sc.nextInt();
                if (casilla == numRule) {
                    apuesta = (apuesta * 36) - apuesta;
                }else{
                    apuesta= apuesta *(-1);
                }
            }
            case 1 -> {
                if (color.equals("Rojo")) {
                    apuesta = (apuesta * 2) - apuesta;
                }else{
                    apuesta= apuesta *(-1);
                }
            }
            case 2 -> {
                if (color.equals("Negro")) {
                    apuesta = (apuesta * 2) - apuesta;
                }else{
                    apuesta= apuesta *(-1);
                }
            }
            case 3 -> {
                if (casilla<13 && casilla != 0) {
                    apuesta = (apuesta * 3) - apuesta;
                }else{
                    apuesta=apuesta *(-1);
                }
            }
            case 4 -> {
                if (casilla>13 && casilla < 24) {
                    apuesta = (apuesta * 3) - apuesta;
                }else{
                    apuesta=apuesta *(-1);
                }
            }
            case 5 -> {
                if (casilla > 24) {
                    apuesta = (apuesta * 3) - apuesta;
                }else{
                    apuesta=apuesta *(-1);
                }
            }
            case 6 -> {
                if (casilla > 18) {
                    apuesta = (apuesta * 2) - apuesta;
                }else{
                    apuesta= apuesta *(-1);
                }
            }
            case 7 -> {
                if (casilla < 19) {
                    apuesta = (apuesta * 2) - apuesta;
                }else{
                    apuesta=apuesta *(-1);
                }
            }
            default ->
                System.out.println("Apuesta inválida.");
        }
        return apuesta;
   }
}
