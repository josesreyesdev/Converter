package views.containers;

import utils.Coins;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class ConverterView extends JFrame {
    private JPanel pane1;
    private JTextField textField;
    private JLabel labelValue;
    private JComboBox<Coins> comboCoins;
    private JButton btnConvert;

    public double dollar = 16.88;
    public double libra = 18.53;
    public double euro = 21.59;
    private double inputValue = 0.0;

    public ConverterView() {
        super("Converter");
        setContentPane(pane1);

        // Menu
        setMenu();

        // Combo Box
        comboCoins.setModel( new DefaultComboBoxModel<>(Coins.values()));

        // Button
        btnConvert.addActionListener(e -> converter());

    }

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Options");
        JMenuItem close = new JMenuItem("Close");

        menuBar.add(file);
        file.add(close);

        setJMenuBar(menuBar);

        close.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Good bye!");
            dispose();
            System.exit(0);
        });
    }

    private void converter() {
        if (isValid(textField.getText())) {
            Coins coinsSelectedItem = (Coins) comboCoins.getSelectedItem();
            switch (Objects.requireNonNull(coinsSelectedItem)) {
                case PESOS_MXN_TO_DOLLAR -> pesosToCoins(dollar);
                case PESOS_MXN_TO_LIBRAS -> pesosToCoins(libra);
                case PESOS_MXN_TO_EUROS -> pesosToCoins(euro);
                case DOLLAR_TO_PESOS_MXN -> coinsToPesos(dollar);
                case LIBRAS_TO_PESOS_MXN -> coinsToPesos(libra);
                case EUROS_TO_PESOS_MXN -> coinsToPesos(euro);
                default -> throw new IllegalArgumentException("Unexpected value: " + coinsSelectedItem);
            }
        }
    }

    private boolean isValid(String text) {
        try {
            double doubleText = Double.parseDouble(text);
            if (doubleText > 0) {
                inputValue = doubleText;
            }
            return true;
        } catch (NumberFormatException e) {
            labelValue.setText("Solo puedo recibir numeros");
            e.printStackTrace();
            return false;
        }
    }

    private void pesosToCoins(double coin) {
        double result = inputValue / coin;
        setValueLabel(result);

    }

    private void coinsToPesos(double coin) {
        double result = inputValue * coin;
        setValueLabel(result);
    }

    private void setValueLabel(double result) {
        labelValue.setText(stringFormatter(result));
    }

    private String stringFormatter(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }
}
