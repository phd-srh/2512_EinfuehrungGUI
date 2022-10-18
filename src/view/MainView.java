package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private final JLabel textMitte;
    private final JButton klickMichButton;
    private final JButton einsButton, zweiButton, dreiButton;
    private final JCheckBox checkBox;
    private final JTextField textField;
    private final JRadioButton radiobuttonM, radiobuttonW, radiobuttonD;
    private final JComboBox<String> bundesländerComboBox;

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

        JPanel centerPanel = new JPanel( new GridLayout(8,2) );
        centerPanel.setBorder( new EmptyBorder(5,5,5,5) );
        add(centerPanel, BorderLayout.CENTER);

        textMitte = new JLabel("Das Zentrum");
        centerPanel.add( textMitte );
        centerPanel.add( new JLabel() );

        centerPanel.add( new JLabel("Checkbox") );
        checkBox = new JCheckBox("Einchecken?");
        centerPanel.add( checkBox );

        centerPanel.add( new JLabel("TextField") );
        textField = new JTextField();
        textField.setColumns(30);
        textField.setText("Beispielstext");
        centerPanel.add( textField );

        centerPanel.add( new JLabel("Radiobuttons") );

        JPanel radioPanel = new JPanel( new FlowLayout() );
        radiobuttonM = new JRadioButton("Männlich");
        radiobuttonW = new JRadioButton("Weiblich");
        radiobuttonD = new JRadioButton("Diverse");
        radiobuttonM.setSelected(true);
        radioPanel.add(radiobuttonM);
        radioPanel.add(radiobuttonW);
        radioPanel.add(radiobuttonD);
        centerPanel.add( radioPanel );
        ButtonGroup bg = new ButtonGroup();
        bg.add(radiobuttonM);
        bg.add(radiobuttonW);
        bg.add(radiobuttonD);

        centerPanel.add( new JLabel("Kombobox") );
        bundesländerComboBox = new JComboBox<>();
        centerPanel.add(bundesländerComboBox);

        einsButton = new JButton("Eins");
        zweiButton = new JButton("Zwei");
        dreiButton = new JButton("Drei");
        centerPanel.add( new JLabel("Ein Button") );
        centerPanel.add( einsButton );
        centerPanel.add( new JLabel("Zwei Button") );
        centerPanel.add( zweiButton );
        centerPanel.add( new JLabel("Drei Button") );
        centerPanel.add( dreiButton );

        JPanel southPanel = new JPanel();
        southPanel.setLayout( new FlowLayout() );

        klickMichButton = new JButton("Klick mich");
        southPanel.add(klickMichButton);

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

    public void setKlickMichButtonListener(ActionListener listener) {
        klickMichButton.addActionListener(listener);
    }


    public void setTextMitte(String text) {
        textMitte.setText(text);
    }

    public String getTextMitte() {
        return textMitte.getText();
    }

    public void setCheckBox(boolean wert){
        checkBox.setSelected(wert);
    }

    public boolean isCheckBox() {
        return checkBox.isSelected();
    }

    public void setTextField(String text){
        textField.setText(text);
    }

    public String getTextField() {
        return textField.getText();
    }

    public void setGeschlecht(char geschlecht) {
        if(geschlecht  == 'M' | geschlecht == 'm'){
            radiobuttonM.setSelected(true);
        }
        if(geschlecht  == 'W' | geschlecht == 'w'){
            radiobuttonW.setSelected(true);
        }
        if(geschlecht  == 'D' | geschlecht == 'd'){
            radiobuttonD.setSelected(true);
        }
    }
    public char getGeschlecht (){
        if(radiobuttonM.isSelected()){
            return 'm';
        }
        else if(radiobuttonW.isSelected()){
            return 'w';
        }
        else {
            return 'd';
        }
    }

    public void setBundesländerComboBoxModel(DefaultComboBoxModel<String> bundesländerComboBoxModel) {
        bundesländerComboBox.setModel(bundesländerComboBoxModel);
    }


    public void setBundesland(String bundesland) {
        for (int i = 0; i < bundesländerComboBox.getItemCount(); i++ ) {
            if (bundesländerComboBox.getItemAt(i).equals(bundesland)){
                bundesländerComboBox.setSelectedIndex(i);
                return;
            }
        }
        bundesländerComboBox.addItem(bundesland);
        bundesländerComboBox.setSelectedIndex(bundesländerComboBox.getItemCount()-1);
    }

    public String getBundesland (){
        return (String) bundesländerComboBox.getSelectedItem();
    }

}