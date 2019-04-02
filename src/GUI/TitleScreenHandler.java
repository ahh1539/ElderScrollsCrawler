package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.*;

public class TitleScreenHandler implements ActionListener {

    private GUI gui;

    public TitleScreenHandler(GUI gui){
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.makeFightScene();
    }
}
