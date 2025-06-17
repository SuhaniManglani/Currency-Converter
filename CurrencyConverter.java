package Project;

import javax.swing.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Currency Converter");
        String[] currencies = {"INR", "USD", "EUR"};

        JComboBox<String> from = new JComboBox<>(currencies);
        JComboBox<String> to = new JComboBox<>(currencies);
        JTextField amount = new JTextField();
        JButton convert = new JButton("Convert");

        frame.setLayout(null);
        from.setBounds(30, 30, 100, 25);
        to.setBounds(150, 30, 100, 25);
        amount.setBounds(30, 70, 220, 25);
        convert.setBounds(90, 110, 100, 30);

        frame.add(from);
        frame.add(to);
        frame.add(amount);
        frame.add(convert);

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        convert.addActionListener(e -> {
            String f = (String) from.getSelectedItem();
            String t = (String) to.getSelectedItem();
            double a = Double.parseDouble(amount.getText());
            double r = 1;

            if (f.equals("INR") && t.equals("USD")) r = 0.012;
            else if (f.equals("INR") && t.equals("EUR")) r = 0.011;
            else if (f.equals("USD") && t.equals("INR")) r = 85.54;
            else if (f.equals("USD") && t.equals("EUR")) r = 0.92;
            else if (f.equals("EUR") && t.equals("INR")) r = 90.38;
            else if (f.equals("EUR") && t.equals("USD")) r = 1.08;

            double result = a * r;
            String output = a + " " + f + " is equal to " + result + " " + t;
            System.out.println(output);
            JOptionPane.showMessageDialog(frame, output);
        });
    }
}


