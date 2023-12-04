import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame{

    public static void main(String[] args) {
        JFrame f = new JFrame("Ferramenta");

        UI l = new UI("Selector");

        ImageIcon imageIcon = new ImageIcon("FerramentaIcon.png");
        Image image = imageIcon.getImage();

        JPanel p = new JPanel();
        JLabel label = new JLabel("Select the operation to do");
        label.setSize(500,100);
        l.selector();
        label.setLayout(null);
        p.add(label);
        p.add(l.getL());
        f.add(p);
        f.setIconImage(image);

        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
