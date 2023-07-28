package views.containers;

import javax.swing.*;

public class MyConverterView extends JFrame {
    private JPanel panel1;
    private JLabel labelName;
    private JEditorPane edtName;
    private JButton btnConverter;

    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem close;

    public MyConverterView() {
        super("Converter with Intellij");
        setContentPane(panel1);

        //Menu implement
        menuBar = new JMenuBar();
        file = new JMenu("File");
        close = new JMenuItem("Close");

        menuBar.add(file);
        file.add(close);

        setJMenuBar(menuBar);

        btnConverter.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "Bienvenido a Swing")
        );
        close.addActionListener( e ->
                newView()
        );
    }

    private void newView() {
        SwingUtilities.invokeLater( () ->{
            JFrame frame = new ExampleNewView();
            frame.setSize(500, 500);
            frame.setVisible(true);
        });
    }
}
