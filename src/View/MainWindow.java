package View;

import Model.Budget;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private IncomePanel incomePanel;
    private ExpensePanel expensePanel;
    private EstimatedPanel estimatedPanel;

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

        estimatedPanel = new EstimatedPanel();
        this.add(estimatedPanel);

        this.pack();
        this.setVisible(true);
    }

    private void updateWindow() {
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
    }


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

        public double getIncome() {
            return Double.parseDouble(incomeInput.getText());
        }
    }

    public class InputPanel extends JPanel{
        private ArrayList<JTextField> prompts;
        private ArrayList<JTextField> inputs;

        public InputPanel() {
            this.setLayout(new GridLayout(0, 2));

            prompts = new ArrayList<>();
            inputs = new ArrayList<>();
        }

        public void addInput(){
            JTextField prompt = new JTextField();
            prompt.setPreferredSize(new Dimension(50, 20));
            prompts.add(prompt);

            JTextField input = new JTextField();
            input.setPreferredSize(new Dimension(200, 20));
            input.setHorizontalAlignment(SwingConstants.RIGHT);
            input.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    estimatedPanel.updateOutput(incomePanel.getIncome(), prompts, inputs);
                }
            });

            inputs.add(input);

            this.add(prompt);
            this.add(input);
        }
    }

    public class ButtonPanel extends JPanel {
        private JButton addButton;
        private InputPanel inputPanel;

        public ButtonPanel(InputPanel inputp) {
            this.inputPanel = inputp;

            this.setLayout(new GridLayout(0, 2));

            addButton = new JButton("+");
            addButton.setPreferredSize(new Dimension(25,25));

            addButton.setAlignmentY(JButton.CENTER);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inputPanel.addInput();
                    updateWindow();
                }
            });

            this.add(addButton);
        }
    }

    public class ExpensePanel extends JPanel {
        private InputPanel inputPanel;
        private ButtonPanel buttonPanel;

        public ExpensePanel(){
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            TitledBorder border = new TitledBorder("Expenses");
            this.setBorder(border);

            inputPanel = new InputPanel();
            this.add(inputPanel);

            buttonPanel = new ButtonPanel(inputPanel);

            this.add(buttonPanel);
        }
    }
    public class EstimatedPanel extends JPanel {
        private JTextField total;
        private JTextField prompt;

        public EstimatedPanel() {
            prompt = new JTextField("Remaining:");
            prompt.setEditable(false);
            prompt.setBorder(BorderFactory.createEmptyBorder());
            prompt.setPreferredSize(new Dimension(75, 20));

            this.add(prompt);

            total = new JTextField("0.00");
            total.setEditable(false);
            total.setBorder(BorderFactory.createEmptyBorder());
            total.setPreferredSize(new Dimension(75, 20));
            this.add(total);
        }

        public void updateOutput(double income, ArrayList<JTextField> names,ArrayList<JTextField> expenses){
            Budget budget = new Budget();

            budget.setIncome(income);

            for (int i = 0; i < names.size(); i++) {
                budget.addExpense(names.get(i).getText(), Double.parseDouble(expenses.get(i).getText()));
            }

            total.setText(Double.toString(budget.calcBudget()));
            updateWindow();
        }
    }

}
