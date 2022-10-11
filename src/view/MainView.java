package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private final JLabel textMitte;
    private final JButton klichMichButton;

    public MainView() {
        setTitle("Mein erstes GUI Programm");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout( new BorderLayout() );

        JLabel textOben = new JLabel("Hier steht hilfreicher Text!");
        textOben.setBorder( new LineBorder(Color.BLACK) );
        textOben.setBackground( Color.CYAN );
        textOben.setOpaque(true);

        textMitte = new JLabel("Das Zentrum");

        add( textOben, BorderLayout.NORTH );
        add( textMitte, BorderLayout.CENTER );

        klichMichButton = new JButton("Klick mich");
        add( klichMichButton, BorderLayout.SOUTH );

        setVisible(true);
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
