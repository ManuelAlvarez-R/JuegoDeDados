import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {
    private int numero;

    // constructor//
    public Dado() {
    }

    // metodos//
    public void lanzar(Random r) {
        this.numero = r.nextInt(6) + 1;
    }

    public void mostrar(JLabel lblDado) {
        lblDado.setIcon(new ImageIcon(getClass().getResource("/imagenes/dadoCara" +String.valueOf(numero) + ".jpg")));
    }

    public int getNumero() {
        return numero;
    }
}