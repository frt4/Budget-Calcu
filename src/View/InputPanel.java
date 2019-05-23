package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InputPanel extends JPanel{
    private ArrayList<JTextField> prompts;
    private ArrayList<JTextField> inputs;

    public InputPanel() {
        this.setLayout(new FlowLayout());

        prompts = new ArrayList<>();
        inputs = new ArrayList<>();
    }

    public void addInput(String text, double amount){
        JTextField prompt = new JTextField(text);
        prompt.setEditable(false);
        prompt.setPreferredSize(new Dimension(50, 20));
        prompts.add(prompt);

        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(200, 20));

        this.add(prompt);
        this.add(input);
    }
}
