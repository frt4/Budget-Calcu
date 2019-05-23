package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton addButton;
    private JButton submitButton;
    private InputPanel inputPanel;
    private JFrame mainWindow;

    public ButtonPanel(InputPanel inputp, JFrame mw) {
        this.inputPanel = inputp;
        this.mainWindow = mw;

        this.setLayout(new GridLayout(0, 2));

        addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(25,25));

        addButton.setAlignmentY(JButton.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPanel.addInput();
                SwingUtilities.updateComponentTreeUI(mainWindow);
                mainWindow.pack();
            }
        });

        submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(addButton);
        this.add(submitButton);
    }
}
