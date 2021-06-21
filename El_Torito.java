
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;


public class El_Torito extends JFrame implements ActionListener   {

    JButton[] button;
    String[] value ={"Silence", "Adieu", "Mort", "Melancholia", "Confusion", "Horrible", "Wrong","Wrong","Wrong",
                      "Wrong","Wrong"};
    Random rand= new Random();
    String v;
    int score=0;
    int times=0;
    JLabel y= new JLabel();

    public El_Torito()
    {

        setTitle("El_Torito");

        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,5));

        button = new JButton[20];
        int i = 0;
        while (i< button.length) {
            button[i]=new JButton();
            panel1.add(button[i]);
            button[i].addActionListener(this);
            i++;
        }
        this.add(y, BorderLayout.NORTH);
        this.add(panel1, BorderLayout.CENTER);

        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new El_Torito();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton jButton : button) {
            if (e.getSource() != jButton) {
                continue;
            }
            times++;
            for (int j = 0; j < 20; j++) {
                v = value[rand.nextInt(value.length)];
                jButton.setText(v);
            }

            if (!v.equals("Mort") && !v.equals("Adieu") && !v.equals("Silence") && !v.equals("Confusion")
                    && !v.equals("Melancholia") && !v.equals("Horrible")) {
            }

            else {

        score++;
    }

            if (times != 6) {
                continue;
            }
            Arrays.stream(button).forEach(button -> {
                button.setEnabled(false);
                y.setText("You score " + score);
            });
        }
    }
}