package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame window;
    private Container cont;
    private JPanel title, startButton, fightScene;
    private JButton button;
    private JLabel label;
    private JTextArea mainTextArea;
    private TitleScreenHandler tsHandler = new TitleScreenHandler(this);
    public final Font titlefont = new Font("Times New Roman", Font.PLAIN, 40);
    public final Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);

    public GUI() {

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
        startButton.setBounds(300, 400, 200, 100);
        startButton.setBackground(Color.black);

        button = new JButton("START");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        button.addActionListener(tsHandler);


        title.add(label);
        startButton.add(button);
        cont.add(title);
        cont.add(startButton);

    }

    public void makeFightScene() {

        title.setVisible(false);
        startButton.setVisible(false);

        fightScene = new JPanel();
        fightScene.setBounds(100, 100, 600, 250);
        fightScene.setBackground(Color.white);
        cont.add(fightScene);

        mainTextArea = new JTextArea("This is where all of the text will be displayed");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.green);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        fightScene.add(mainTextArea);

    }
}
