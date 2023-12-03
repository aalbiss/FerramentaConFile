import javax.swing.*;

class UI extends JFrame{

    static JFrame f;
    static JList l;

    public static void main(String[] args) {

        f = new JFrame("Ferramenta");

        JPanel p = new JPanel();
        JLabel label = new JLabel("Select the operation to do");
        label.setSize(500,100);
        selector();
        label.setLayout(null);
        p.add(label);
        p.add(l);
        f.add(p);

        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void selector(){

        String operation[] = { "Aggiungi articolo", "Visualizza ferramenta", "Acquista", "Vendi",
                "Visualizza giacenza", "Visualizza nome", "Importa file", "Fine programma"
        };
        l =  new JList<>(operation);
        l.setSelectedIndex(2);
        l.setLayout(null);
        l.setVisible(true);


    }

//    public void pannello() {
//
//        JFrame f = new JFrame("This is an example");
//
//        ImageIcon imageIcon = new ImageIcon("FerramentaIcon.png");
//        Image image = imageIcon.getImage();
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
