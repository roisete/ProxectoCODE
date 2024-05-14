import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que crea un Jugador con nombre y saldo inicial, además de métodos como añadir
 * más saldo o consultar su info.
 */
public class Jugador {

    /*Declaración de los atributos de la clase*/
    private String nombreJugador;
    private double saldo;


    /**
     * Setter de nombreJugador
     * @param nombreJugador El nombre a añadir
     */
    public void setNombreJugador(String nombreJugador) {
        boolean setN=true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                if (nombreJugador.isEmpty()) {
                    throw new Exception();
                } else {
                    this.nombreJugador = nombreJugador;
                    setN=false;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido. Inténtelo de nuevo");
                nombreJugador=sc.nextLine();
            }
        }while(setN);
    }

    /**
     * Getter del atributo saldo
     * @return El saldo actual
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Setter del atributo saldo
     * @param saldo El saldo a añadir
     */
    public void setSaldo(double saldo) {
        Scanner sc = new Scanner(System.in);
        boolean setS=true;
        do {
            try {
                this.saldo = saldo;
                setS = false;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido");
                saldo = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Valor inválido");
                saldo = sc.nextDouble();
            }
        }while(setS);
    }

    /**
     * Constructor de la clase
     * @param nombreJugador Nombre del jugador
     * @param saldo Saldo del jugador
     */
    public Jugador(String nombreJugador, double saldo) {
        this.nombreJugador = nombreJugador;
        this.saldo = saldo;
    }

    /**
     * Función para devolver los datos en forma de cadena
     * @return Los datos en forma de cadena
     */
    @Override
    public String toString() {
        return "Jugador: "+ nombreJugador + "\nSaldo: " + saldo;
    }

    /**
     * Función para añadir más saldo a un jugador (debe ser mayor que 10)
     * @param importe El importe a añadir
     * @return El saldo total
     */
    public double masSaldo(double importe){
        Scanner sc= new Scanner(System.in);
        while(importe<5){
            System.out.println("Introduzca un importe válido: ");
            importe=sc.nextDouble();
        }
        return this.saldo+importe;
    }
}
