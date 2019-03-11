package Game;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame window;
    private Container cont;
    private JPanel title;
    private JButton button;
    private JLabel label;
    Font titlefont = new Font("Times New Roman", Font.BOLD,90);

    public GUI(){

    }

    public void MakeGUI() {

        window = new JFrame();
        window.setSize(900, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        cont = window.getContentPane();

        title = new JPanel();
        title.setBounds(100, 100, 600, 100);
        title.setForeground(Color.white);
        cont.add(title);

        label = new JLabel();
        label.setBackground(Color.BLACK);
        label.setText("Welcome to Elder Scrolls Crawler!");
        title.add(label);

        button = new JButton();
        button.setText("Play");

    }
}
