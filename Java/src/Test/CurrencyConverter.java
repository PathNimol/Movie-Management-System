package Test;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter implements ActionListener {
    JFrame frame;
    JComboBox[] currency = new JComboBox[2];
    JLabel[] labels = new JLabel[5];
    JComboBox fromCurrency, toCurrency;
    JLabel titleLbl, fromLbl, toLbl, amtFromLbl, amtToLbl;
    JButton resetBtn;
    JTextField fromTxt, toTxt;

    Font myFont = new Font("Times New Roman",Font.BOLD, 14);
    double[] exchangeRates = {0,1.0, 4000, 0.85, 110.0, 0.75};

    CurrencyConverter(){
        //Initialize frame
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 550);
        frame.setLayout(null);

        //Initialize Labels
        titleLbl = new JLabel("Currency Converter");
        Font titleFont = new Font("Segoe Print", Font.BOLD, 24);
        titleLbl.setFont(titleFont);
        titleLbl.setForeground(Color.BLUE);
        titleLbl.setBounds(55,0, 250, 75);

        fromLbl = new JLabel("From:");
        fromLbl.setFont(myFont);
        fromLbl.setBounds(50, 100, 100, 30);

        toLbl = new JLabel("To:");
        toLbl.setFont(myFont);
        toLbl.setBounds(200, 100, 100, 30);

        amtFromLbl = new JLabel("Amount To Convert:");
        amtFromLbl.setFont(myFont);
        amtFromLbl.setBounds(50, 190, 200, 30);

        amtToLbl = new JLabel("Total Amount Converted:");
        amtToLbl.setFont(myFont);
        amtToLbl.setBounds(50, 275, 200, 30);

        //Initialize ComboBox
        String[] currencies = {"","USD", "KHR", "EUR", "JPY", "GBP"};
        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setFont(myFont);
        fromCurrency.setBounds(50,130,100,40);

        toCurrency = new JComboBox<>(currencies);
        toCurrency.setFont(myFont);
        toCurrency.setBounds(200,130,100,40);

        //Initialize Text Field
        fromTxt = new JTextField();
        fromTxt.setFont(myFont);
        fromTxt.setBounds(50,225,250,40);

        toTxt = new JTextField();
        toTxt.setFont(myFont);
        toTxt.setEditable(false);
        toTxt.setBounds(50,305,250,40);

        //Initialize Buttons
        resetBtn = new JButton("Reset");
        resetBtn.setFont(myFont);
        resetBtn.addActionListener(this);
        resetBtn.setBounds(200,365,100,40);

        fromTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> convertCurrency());
                if (fromCurrency.getSelectedIndex() != toCurrency.getSelectedIndex()) {
                } else {
                    // Show error message if the same currencies are selected
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "Please choose different currencies to convert.");
                        fromTxt.setText("");
                        toTxt.setText("");
                    });
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> convertCurrency());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        // Add ActionListener to fromCurrency JComboBox
        fromCurrency.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> convertCurrency());
        });

        // Add ActionListener to toCurrency JComboBox
        toCurrency.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> convertCurrency());
        });

        //Add resources to frame
        frame.add(resetBtn);
        frame.add(amtFromLbl);
        frame.add(amtToLbl);
        frame.add(titleLbl);
        frame.add(fromLbl);
        frame.add(toLbl);
        frame.add(fromCurrency);
        frame.add(toCurrency);
        frame.add(fromTxt);
        frame.add(toTxt);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CurrencyConverter cc = new CurrencyConverter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetBtn) {
            fromTxt.setText("");
            toTxt.setText("");
            fromCurrency.setSelectedIndex(0);
            toCurrency.setSelectedIndex(0);
        }
    }

    private void convertCurrency() {
        try {
            // Get the input amount from fromTxt
            double currentAmount = Double.parseDouble(fromTxt.getText());

            // Get the selected index for the "From" currency
            int fromIndex = fromCurrency.getSelectedIndex();
            // Get the selected index for the "To" currency
            int toIndex = toCurrency.getSelectedIndex();

            double baseAmount = currentAmount / exchangeRates[fromIndex];  // Convert to USD first
            double convertedAmount = baseAmount * exchangeRates[toIndex];  // Convert from USD to target

            // Update the toTxt field outside the event processing to avoid mutation exception
            SwingUtilities.invokeLater(() -> {
                toTxt.setText(String.format("%.2f", convertedAmount)); // Formatting to 2 decimal places
            });
        } catch (NumberFormatException ex) {
            // Clear toTxt if the input is not a valid number
            SwingUtilities.invokeLater(() -> toTxt.setText(""));
        }
    }

}