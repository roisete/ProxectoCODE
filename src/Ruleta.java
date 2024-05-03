import java.util.*;
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
     * Getter de variable casilla
     * @return casilla
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
     * @return la variable color
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
     * Asigna ambas variables
     */
    public void toSpin(){
        this.setCasilla();
        this.setColor();
        System.out.printf("Ha salido el %d %s",this.getCasilla(),this.getColor());
    }
}
