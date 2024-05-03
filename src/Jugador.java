import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador {

    /*Declaración de los atributos de la clase*/
    private String nombreJugador;
    private double saldo;


    /**
     * setter de nombreJugador
     * @param nombreJugador
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
     * getter del atributo saldo
     * @return el saldo actual
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * setter del atributo saldo
     * @param saldo
     */
    public void setSaldo(double saldo) {
        boolean setS=true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                if (saldo <= 10) {
                    throw new Exception();
                } else {
                    this.saldo = saldo;
                    setS=false;
                }
            } catch (InputMismatchException e){
                System.out.println("Valor inválido");
                saldo= sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Valor inválido");
                saldo= sc.nextDouble();
            }
        }while (setS);
    }

    /**
     * Constructor de la clase
     * @param nombreJugador
     * @param saldo
     */
    public Jugador(String nombreJugador, double saldo) {
        this.nombreJugador = nombreJugador;
        this.saldo = saldo;
    }

    /**
     * Función para devolver los datos en forma de cadena
     * @return los datos en forma de cadena
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
