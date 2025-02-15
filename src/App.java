import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] digitButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];

    JButton addButton, subButton, multButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;

    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, results = 0;
    char operator;

    App(){
        //Adding the Frame
        frame = new JFrame("Calculator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,550);
        frame.setLayout(null);

        //Adding TextFields
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //Adding Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;        
        functionButtons[1] = subButton;        
        functionButtons[2] = multButton;        
        functionButtons[3] = divButton;        
        functionButtons[4] = decButton;        
        functionButtons[5] = eqButton;        
        functionButtons[6] = delButton;        
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        
        for(int i = 0; i < 9 ; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10 ; i++){
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
            digitButtons[i].setFont(myFont);
            digitButtons[i].setFocusable(false);
        }

        negButton.setBounds(0, 430, 150,50);
        delButton.setBounds(140, 430, 150,50);
        clrButton.setBounds(290, 430, 150,50);

        //Adding panels
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        panel.add(digitButtons[1]);
        panel.add(digitButtons[2]);
        panel.add(digitButtons[3]);
        panel.add(addButton);
        panel.add(digitButtons[4]);
        panel.add(digitButtons[5]);
        panel.add(digitButtons[6]);
        panel.add(subButton);
        panel.add(digitButtons[7]);
        panel.add(digitButtons[8]);
        panel.add(digitButtons[9]);
        panel.add(multButton);
        panel.add(decButton);
        panel.add(digitButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        //Adding elements to frame
        frame.add(negButton);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);

        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
       App calcApp = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i = 0; i < 10; i++){
        if (e.getSource() == digitButtons[i]) {
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
       }
       if (e.getSource() == decButton) {
        textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }
        if (e.getSource() == eqButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    results = num1 + num2;
                    break;
                case '-':
                    results = num1 - num2;
                    break;
                case '*':
                    results = num1 * num2;
                    break;
                case '/':
                    results = num1 / num2;
                    break;
            
                default:
                    break;
            }

            textField.setText(String.valueOf(results));
            num1 = results;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String deletion =textField.getText();
            textField.setText("");

            for (int i = 0; i < deletion.length()-1; i++) {
                textField.setText(textField.getText()+deletion.charAt(i));

            }
            
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }

}
