package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class IncomePanel extends JPanel{
    private JTextField income;
    private JTextField incomeInput;

    public IncomePanel() {
        this.setLayout(new FlowLayout());

        TitledBorder border = new TitledBorder("Income");
        this.setBorder(border);

        income = new JTextField("Income:");
        income.setEditable(false);
        income.setBorder(BorderFactory.createEmptyBorder());
        income.setPreferredSize(new Dimension(50, 20));

        incomeInput = new JTextField();
        incomeInput.setPreferredSize(new Dimension(200, 20));
        incomeInput.setHorizontalAlignment(SwingConstants.RIGHT);

        this.add(income);
        this.add(incomeInput);
    }
}
