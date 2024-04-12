import java.util.*;
public class Ruleta {
    private int [] ruleta;
    private final int TAMANHO=37;
    private int casilla;
    private String color;

    /**
     * Constructor de ruleta
     */
    public Ruleta() {
        this.ruleta= new int[TAMANHO];
    }

    /**
     * Rellena la ruleta
     */
    public void rellenar (){
        int cont = 0;
        for (int i = 0; i < this.ruleta.length; i++) {
            this.ruleta[i]=cont;
            cont++;
        }
    }

    public int getCasilla() {
        return casilla;
    }


    public void setCasilla() {
        Random r= new Random();
        this.casilla = r.nextInt(0,37);
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        int[] conjNegro={2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
        for (int i = 0; i < conjNegro.length; i++) {
            if (this.getCasilla()==conjNegro[i]){
                this.color="Negro";
                break;
            } else if (this.getCasilla()==0) {
                this.color="Verde";
                break;
            } else{
                this.color="Rojo";
            }
        }
    }

    public void toSpin(){
        this.setCasilla();
        this.setColor();
        System.out.printf("Ha salido el %d %s",this.getCasilla(),this.getColor());
    }
}
