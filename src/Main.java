

import views.containers.ConverterView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () ->{
            JFrame frame = new ConverterView();
            frame.setSize(500, 500);
            frame.setVisible(true);
        });
    }
}