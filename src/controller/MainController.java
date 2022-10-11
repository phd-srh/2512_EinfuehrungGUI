package controller;

import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private boolean toggle = false;

    public MainController(MainView mainView) {
        mainView.setTextMitte("Hier hat der Controller die Kontrolle!");

        mainView.setKlichMichButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggle)
                    mainView.setTextMitte("Yeah, es hat geklickt!");
                else
                    mainView.setTextMitte("Willst du vielleicht mal klicken?");
                toggle = !toggle;
            }
        });

    }

    public static void main(String[] args) {
        new MainController( new MainView() );
    }
}
