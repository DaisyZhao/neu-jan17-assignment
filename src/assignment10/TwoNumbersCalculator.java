package assignment10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Xueying Zhao
 */
public class TwoNumbersCalculator extends JFrame implements ActionListener {
    private JLabel prompt = new JLabel("  Please input two numbers and choose the operator");
    private JTextField input1 = new JTextField(10);
    private JTextField input2 = new JTextField(10);
    private String plusStr = "+";
    private String minusStr = "-";
    private String multiplyStr = "*";
    private String divideStr = "/";
    private JRadioButton plusBtn = new JRadioButton(plusStr);
    private JRadioButton minusBtn = new JRadioButton(minusStr);
    private JRadioButton multiplyBtn = new JRadioButton(multiplyStr);
    private JRadioButton divideBtn = new JRadioButton(divideStr);
    private JButton calculateBtn = new JButton("Calculate");
    private JLabel output = new JLabel("", SwingConstants.LEFT);

    public TwoNumbersCalculator() {
        setTitle("Two Numbers Calculator");
        setSize(450, 200);

        plusBtn.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(plusBtn);
        group.add(minusBtn);
        group.add(multiplyBtn);
        group.add(divideBtn);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(prompt);
        cp.add(input1);
        input1.setEditable(true);
        cp.add(plusBtn);
        cp.add(minusBtn);
        cp.add(multiplyBtn);
        cp.add(divideBtn);
        cp.add(input2);
        input2.setEditable(true);
        cp.add(calculateBtn);
        cp.add(output);
        calculateBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (input1.getText().isEmpty() || input2.getText().isEmpty()) {
            output.setText("Result: NaN");
        } else {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double result;

            if (plusBtn.isSelected()) {
                result = num1 + num2;
                output.setText(" Result: " + result);
            }
            if (minusBtn.isSelected()) {
                result = num1 - num2;
                output.setText(" Result: " + result);
            }
            if (multiplyBtn.isSelected()) {
                result = num1 * num2;
                output.setText(" Result: " + result);
            }
            if (divideBtn.isSelected()) {
                if (num2 == 0) {
                    output.setText(" Error! 0 can't be a dividend.");
                } else {
                    result = num1 / num2;
                    output.setText(" Result: " + result);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new TwoNumbersCalculator();
        frame.setVisible(true);
    }
}
