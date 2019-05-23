package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

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

        this.add(prompt);
        this.add(input);
    }
}
