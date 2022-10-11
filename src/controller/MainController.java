package controller;

import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView;
    private boolean toggle = false;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        mainView.setTextMitte("Hier hat der Controller die Kontrolle!");

        // Nutzung als funktionales Interface
        mainView.setKlichMichButtonListener( this::toggleText );
    }

    private void toggleText(ActionEvent e) {
        if (toggle)
            mainView.setTextMitte("Yeah, es hat geklickt!");
        else
            mainView.setTextMitte("Willst du vielleicht mal klicken?");
        toggle = !toggle;
    }


    public static void main(String[] args) {
        new MainController( new MainView() );
    }
}
