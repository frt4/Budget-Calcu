package View;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private IncomePanel incomePanel;
    private ExpensePanel expensePanel;

    public MainWindow() {
        this.setTitle("Budget Calculator");
        // set to box layout
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // center the window on open
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);


        incomePanel = new IncomePanel();
        this.add(incomePanel);

        expensePanel = new ExpensePanel();
        this.add(expensePanel);

        this.pack();
        this.setVisible(true);
    }


}
