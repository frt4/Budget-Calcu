package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class ExpensePanel extends JPanel {

    private JButton addButton;

    public ExpensePanel(){
        this.setLayout(new FlowLayout());

        TitledBorder border = new TitledBorder("Expenses");
        this.setBorder(border);

        addButton = new JButton("+");

        this.add(addButton);
    }


}
