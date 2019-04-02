package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame window;
    private Container cont;
    private JPanel title, startButton;
    private JButton button;
    private JLabel label;
    Font titlefont = new Font("Times New Roman", Font.PLAIN,40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN,20);

    public GUI(){

    }

    public void MakeGUI() {

        window = new JFrame();
        window.setSize(850, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        cont = window.getContentPane();

        title = new JPanel();
        title.setBounds(100, 100, 600, 150);
        title.setBackground(Color.black);


        label = new JLabel("Welcome to Elder Scrolls Crawler!");
        label.setForeground(Color.white);
        label.setFont(titlefont);

        title.add(label);
        cont.add(title);

        startButton = new JPanel();
        startButton.setBounds(300,400,200,100);
        startButton.setBackground(Color.black);

        button = new JButton("START");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(normalFont);


        title.add(label);
        startButton.add(button);
        cont.add(title);
        cont.add(startButton);

    }
}
