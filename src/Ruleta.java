import java.util.*;

/**
 * Clase que representa a la ruleta de un casino, con sus casillas con color respectivo, además
 * de un método para "girarla"
 */
public class Ruleta {
    private String [] ruleta = {"Verde","Rojo","Negro","Rojo","Negro","Rojo","Negro","Rojo","Negro","Rojo",
            "Negro","Negro","Rojo","Negro","Rojo","Negro","Rojo","Negro","Rojo",
            "Rojo","Negro","Rojo","Negro","Rojo","Negro","Rojo","Negro","Rojo",
            "Negro","Negro","Rojo","Negro","Rojo","Negro","Rojo","Negro","Rojo"};
    private int casilla;
    private String color;

    /**
     * Constructor de ruleta
     */
    public Ruleta() {
    }

    /**
     * Getter del atributo casilla
     * @return La casilla
     */
    public int getCasilla() {
        return casilla;
    }

    /**
     * Setter de casilla
     */
    public void setCasilla() {
        Random r= new Random();
        this.casilla = r.nextInt(0,37);
    }

    /**
     * Getter de variable color
     * @return La variable color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter de variable color
     */
    public void setColor() {
        this.color = this.ruleta[getCasilla()];
    }

    /**
     * Asigna ambas variables ("gira la ruleta")
     */
    public void toSpin(){
        this.setCasilla();
        this.setColor();
    }
}
