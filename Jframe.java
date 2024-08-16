import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Jframe extends JFrame {
    JLabel lblDado1, lblDado2, lblLazamientos, lblCenas;
    Dado dado1, dado2;
    Random r = new Random();
    int Lanzamientos = 0;
    int Cenas = 0;

    public Jframe() {
        setTitle("lanzemos los dados");
        setSize(600, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lblDado1 = new JLabel();
        lblDado2 = new JLabel();
        JLabel lbl1 = new JLabel();
        JLabel lbl2 = new JLabel();
        lblLazamientos = new JLabel();
        lblCenas = new JLabel();
        JButton botonIniciar = new JButton();
        JButton botonLanzar = new JButton();
        String rutaDado = "imagenes/dadoCara1.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaDado));
        dado1 = new Dado();
        dado2 = new Dado();
        lblDado1.setIcon(imgDado);
        lblDado2.setIcon(imgDado);

        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());

        lbl1.setText("Lanzamientos");
        lbl2.setText("Cenas");
        lbl1.setBounds(50 + 2 * imgDado.getIconWidth(), 10, 100, 30);
        lbl2.setBounds(160 + 2 * imgDado.getIconWidth(), 10, 100, 30);

        lblLazamientos.setText("0");
        lblLazamientos.setBackground(new Color(255, 255, 255));
        lblLazamientos.setForeground(new Color(255, 128, 0));
        lblLazamientos.setBounds(50 + 2 * imgDado.getIconWidth(), 40, 100, 80);
        lblLazamientos.setOpaque(true);
        lblLazamientos.setFont(new Font("Tahoma", 1, 72));
        lblLazamientos.setHorizontalAlignment(SwingConstants.CENTER);

        lblCenas.setText("0");
        lblCenas.setBackground(new Color(255, 255, 255));
        lblCenas.setForeground(new Color(255, 128, 0));
        lblCenas.setBounds(160 + 2 * imgDado.getIconWidth(), 40, 100, 80);
        lblCenas.setOpaque(true);
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        lblCenas.setHorizontalAlignment(SwingConstants.CENTER);

        Lanzamientos=0;
        Cenas=0;
        mostrarContadores();

        botonLanzar.setText("Lanzar");
        botonLanzar.setBounds(30, 45 + imgDado.getIconHeight(), 100, 75);
        botonLanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                botonLanzar_click(e);
            }

        });

        mostrarContadores();
        // evento//

        botonIniciar.setText("Iniciar");
        botonIniciar.setBounds(140, 45 + imgDado.getIconHeight(), 100, 75);
        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                botonIniciar_click(e);
            }

        });

        getContentPane().setLayout(null);
        getContentPane().add(lblDado1);
        getContentPane().add(lblDado2);
        getContentPane().add(lbl1);
        getContentPane().add(lbl2);
        getContentPane().add(lblLazamientos);
        getContentPane().add(lblCenas);
        getContentPane().add(botonLanzar);
        getContentPane().add(botonIniciar);
    }

    public void mostrarContadores() {
        lblLazamientos.setText(String.valueOf(Lanzamientos));
        lblCenas.setText(String.valueOf(Cenas));
    }

    private void botonIniciar_click(ActionEvent e) {
        Lanzamientos = 0;
        Cenas = 0;
        mostrarContadores();

    }

    private void botonLanzar_click(ActionEvent e) {
     dado1.lanzar(r);
     dado2.lanzar(r);
     dado1.mostrar(lblDado1);
     dado2.mostrar(lblDado2);
     Lanzamientos++;
     if(dado1.getNumero()+dado2.getNumero()>=11){
        Cenas++;
     }
     mostrarContadores();
    }
}
