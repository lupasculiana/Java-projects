package View;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CalculatorView extends JFrame {

    private JTextField firstValueField;
    private JTextField secondValueField;
    private JTextField resultField;

    private JButton totalPolinomButton;
    private JComboBox comboBox;

    public CalculatorView() {

        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 579, 385);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Calculator de polinoame");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setBounds(123, 10, 294, 45);
        this.getContentPane().add(titleLabel);

        JLabel polinomOneLabel = new JLabel("Polinom 1 :");
        polinomOneLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
        polinomOneLabel.setBounds(25, 65, 174, 45);
        this.getContentPane().add(polinomOneLabel);

        JLabel polinomTwoLabel = new JLabel("Polinom 2 :");
        polinomTwoLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
        polinomTwoLabel.setForeground(new Color(0, 0, 0));
        polinomTwoLabel.setBounds(25, 190, 162, 30);
        this.getContentPane().add(polinomTwoLabel);

        firstValueField = new JTextField();
        firstValueField.setForeground(Color.BLUE);
        firstValueField.setFont(new Font("Sitka Text", Font.PLAIN, 25));
        firstValueField.setBounds(25, 120, 215, 38);
        this.getContentPane().add(firstValueField);
        firstValueField.setColumns(10);

        secondValueField = new JTextField();
        secondValueField.setForeground(Color.BLUE);
        secondValueField.setFont(new Font("Sitka Text", Font.PLAIN, 25));
        secondValueField.setBounds(25, 227, 215, 38);
        this.getContentPane().add(secondValueField);
        secondValueField.setColumns(10);

        JLabel resultLabel = new JLabel("Rezultat :");
        resultLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 25));
        resultLabel.setBounds(309, 67, 125, 38);
        this.getContentPane().add(resultLabel);

        resultField = new JTextField();
        resultField.setForeground(Color.BLUE);
        resultField.setBounds(310, 111, 224, 56);
        this.getContentPane().add(resultField);
        resultField.setColumns(10);

        JLabel operationLabel = new JLabel("Operation :");
        operationLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
        operationLabel.setBounds(309, 200, 125, 17);
        this.getContentPane().add(operationLabel);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        comboBox.setForeground(Color.BLUE);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Add", "Substract", "Multiplication", "Division", "Derivative", "Integration"}));
        comboBox.setBounds(309, 223, 150, 45);
        this.getContentPane().add(comboBox);

        totalPolinomButton = new JButton("Get result");
        totalPolinomButton.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
        totalPolinomButton.setForeground(Color.BLUE);
        totalPolinomButton.setBounds(310, 170, 125, 21);
        this.getContentPane().add(totalPolinomButton);

        this.setVisible(true);
    }

    public String getFirstValueField() {
        return this.firstValueField.getText();
    }

    public String getSecondValueField() {
        return this.secondValueField.getText();
    }

    public void setTotalValueField(String resultField1) {
        this.resultField.setText(resultField1);
    }

    public void addCreateListener(ActionListener action) {
        this.totalPolinomButton.addActionListener(action);
    }

    public String getOperationField(){return this.comboBox.getSelectedItem().toString();}

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        this.refresh();
    }

    public void refresh() {
        this.firstValueField.setText((String)null);
        this.secondValueField.setText((String)null);
        this.resultField.setText((String)null);
    }
}

