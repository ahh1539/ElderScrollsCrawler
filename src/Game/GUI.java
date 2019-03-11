package Game;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame window;
    private Container cont;
    private JPanel title, startButton;
    private JButton button;
    private JLabel label;
    Font titlefont = new Font("Times New Roman", Font.PLAIN,32);

    public GUI(){

    }

    public void MakeGUI() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        cont = window.getContentPane();

        title = new JPanel();
        title.setBounds(100, 100, 600, 150);
        title.setBackground(Color.black);
        cont.add(title);

        label = new JLabel("Welcome to Elder Scrolls Crawler!");
        label.setForeground(Color.white);
        label.setFont(titlefont);

        title.add(label);
        cont.add(title);

        startButton = new JPanel();
        startButton.setBounds(300,400,200,100);
        startButton.setBackground(Color.blue);

        button = new JButton("START GAME");
        button.setBackground(Color.black);
        button.setForeground(Color.white);

        startButton.add(button);
        cont.add(startButton);

    }
}
