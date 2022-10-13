package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private final JLabel textMitte;
    private final JButton klichMichButton;
    private final JButton einsButton, zweiButton, dreiButton;

    public MainView() {
        setTitle("Mein erstes GUI Programm");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout( new BorderLayout() );

        JLabel textOben = new JLabel("Hier steht hilfreicher Text!");
        textOben.setBorder( new LineBorder(Color.BLACK) );
        textOben.setBackground( Color.CYAN );
        textOben.setOpaque(true);
        add( textOben, BorderLayout.NORTH );

        textMitte = new JLabel("Das Zentrum");

        JPanel centerPanel = new JPanel( new FlowLayout() );
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add( textMitte );
        einsButton = new JButton("Eins");
        zweiButton = new JButton("Zwei");
        dreiButton = new JButton("Drei");
        centerPanel.add( einsButton );
        centerPanel.add( zweiButton );
        centerPanel.add( dreiButton );

        JPanel southPanel = new JPanel();
        southPanel.setLayout( new FlowLayout() );

        klichMichButton = new JButton("Klick mich");
        southPanel.add( klichMichButton );

        JButton exitButton = new JButton("Exit");
        southPanel.add( exitButton );

        add( southPanel, BorderLayout.SOUTH );

        // Lambda Ausdrücke
        exitButton.addActionListener(
                e -> dispose()
        );

        pack();
        setVisible(true);
    }

    public void setEinsButtonListener(ActionListener listener) {
        einsButton.addActionListener(listener);
    }
    public void setZweiButtonListener(ActionListener listener) {
        zweiButton.addActionListener(listener);
    }
    public void setDreiButtonListener(ActionListener listener) {
        dreiButton.addActionListener(listener);
    }

    public void setKlichMichButtonListener(ActionListener listener) {
        klichMichButton.addActionListener(listener);
    }

    public void setTextMitte(String text) {
        textMitte.setText(text);
    }

    public String getTextMitte() {
        return textMitte.getText();
    }
}
