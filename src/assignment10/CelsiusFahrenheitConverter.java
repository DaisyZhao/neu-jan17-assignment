package assignment10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Xueying Zhao
 */
public class CelsiusFahrenheitConverter extends JFrame implements ActionListener {
    private JLabel prompt = new JLabel("Enter Celsius or Fahrenheit temperature, click Convert button");
    private JTextField inputC = new JTextField(10);
    private JTextField inputF = new JTextField(10);
    private JLabel celsiusLable = new JLabel("Celsius or ", SwingConstants.LEFT);
    private JLabel fahrenheitLable = new JLabel("Fahrenheit", SwingConstants.LEFT);
    private JLabel output = new JLabel("", SwingConstants.LEFT);
    ;
    private JButton convertTemp = new JButton("Convert");
    private String previousInputC = "";
    private String previousInputF = "";

    public CelsiusFahrenheitConverter() {
        setTitle("Celsius and Fahrenheit Converter");
        setSize(450, 200);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(prompt);
        cp.add(inputC);
        inputC.setEditable(true);
        cp.add(celsiusLable);
        cp.add(inputF);
        inputF.setEditable(true);
        cp.add(fahrenheitLable);
        cp.add(convertTemp);
        cp.add(output);
        convertTemp.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (inputC.getText().equals(previousInputC) && inputF.getText().equals(previousInputF)) {
            output.setText("");
        } else {
            if (inputC.getText().isEmpty() || inputF.getText().isEmpty()) {
                output.setText("");
            }
            if (!inputC.getText().equals(previousInputC)) {
                double tc = Double.parseDouble(inputC.getText().trim());
                double tf = (9.0 / 5.0) * tc + 32.0;
                output.setText(String.format("%.2f", tf) + " Fahrenheit");
                previousInputC = inputC.getText();
            } else if (!inputF.getText().equals(previousInputF)) {
                double tf = Double.parseDouble(inputF.getText().trim());
                double tc = (tf - 32.0) / (9.0 / 5.0);
                output.setText(String.format("%.2f", tc) + " Celsius");
                previousInputF = inputF.getText();
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new CelsiusFahrenheitConverter();
        f.setVisible(true);
    }
}
