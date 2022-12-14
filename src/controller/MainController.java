package controller;

import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView;
    private boolean toggle = false;

    // das müssten wir für jeden Button machen!
    public class EinsButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Juhey, die Eins wurde geklickt "+
                    this.getClass().getName());
            // laut Aufgabenbeschreibung: Text aus dem TextField soll als Bundesland ausgewählt werden
            mainView.setBundesland( mainView.getTextField() );
        }
    }

    //Der Konstruktor der Klasse MainController
    public MainController(MainView mainView) {
        this.mainView = mainView;
        mainView.setTextMitte("Hier hat der Controller die Kontrolle! ");

        // setzen der wichtigen Felder für die View
        String[] bundesländer = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};
        DefaultComboBoxModel<String> bundesländerModel = new DefaultComboBoxModel<>();
        for (String bundesland : bundesländer) bundesländerModel.addElement(bundesland);
        mainView.setBundesländerComboBoxModel(bundesländerModel);


        // (nicht mehr genutzt) dedizierte Klasse
        mainView.setEinsButtonListener( new EinsButtonActionListener() );


        // (1) Anonyme Klasse
        mainView.setZweiButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hey, Aufruf in anonymer Klasse " +
                        this.getClass().getName());
                mainView.setTextField( mainView.getBundesland() );
            }
        });


        // (2) Lambda
        mainView.setDreiButtonListener( e ->
                System.out.println("Huch, Aufruf über Lambda " +
                        this.getClass().getName())
        );



        // (3, typische Anwendung) Nutzung als funktionales Interface
        mainView.setKlickMichButtonListener( this::toggleText );
    }



    // Nachfolgende Methode hat die korrekte Signatur für
    // ActionListener: @Override void actionPerformed(ActionEvent e)
    private void toggleText(ActionEvent e) {
        if (toggle)
            mainView.setTextMitte("Yeah, es hat geklickt!");
        else
            mainView.setTextMitte("Willst du vielleicht mal klicken?");
        toggle = !toggle;
        System.out.println("Oi, Aufruf über funktionales Interface " +
                this.getClass().getName());
    }




    //Die Main-Methode
    public static void main(String[] args) {
        new MainController( new MainView() );
    }
}
