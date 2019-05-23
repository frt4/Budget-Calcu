package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExpensePanel extends JPanel {
    private JFrame mainWindow;
    private InputPanel inputPanel;
    private ButtonPanel buttonPanel;

    public ExpensePanel(JFrame mw){
        this.mainWindow = mw;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        TitledBorder border = new TitledBorder("Expenses");
        this.setBorder(border);

        inputPanel = new InputPanel();
        this.add(inputPanel);

        buttonPanel = new ButtonPanel(inputPanel, mainWindow);

        this.add(buttonPanel);

    }


}
