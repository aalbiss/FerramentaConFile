import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

class UI extends JFrame{

    private JList l;
    private String operation[] = { "Aggiungi articolo", "Visualizza ferramenta", "Acquista", "Vendi",
            "Visualizza giacenza", "Visualizza nome", "Importa file", "Fine programma"
    };

//
//    public static void main(String[] args) {
//
//        ImageIcon imageIcon = new ImageIcon("FerramentaIcon.png");
//        Image image = imageIcon.getImage();
//
//        JPanel p = new JPanel();
//        JLabel label = new JLabel("Select the operation to do");
//        label.setSize(500,100);
//        selector();
//        label.setLayout(null);
//        p.add(label);
//        p.add(l);
//        f.add(p);
//        f.setIconImage(image);
//
//        f.setSize(400,400);
//        f.setVisible(true);
//        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    }

    public UI(String title) throws HeadlessException {
        super(title);
        l = new JList(operation);
    }

    public JList getL() {
        return l;
    }

    public void setL(JList l) {
        this.l = l;
    }

    public void selector(){
        l.setSelectedIndex(2);
        l.setLayout(null);
        l.setVisible(true);
        l.setSelectedIndex(0);

        int indice = l.getSelectedIndex();
        System.out.println(indice);

    }

    public void listen(){

        l.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if(!e.getValueIsAdjusting())
                    System.out.println("Selected!");

            }
        });

    }

//    public void pannello() {
//
//        JFrame f = new JFrame("This is an example");
//
//
//        f.setVisible(true);
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.setSize(300,400);
//        f.setBackground(Color.YELLOW);
//        f.setIconImage(image);
//        f.setLocationRelativeTo(null);
//
//    }



}
