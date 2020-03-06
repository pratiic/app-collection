import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
class Calculator extends JFrame implements ActionListener { 


    JFrame f;

    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonEquals, buttonClear, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonDot;
    JTextField t;
    JPanel p;

     Calculator() {
        f = new JFrame();
        f.setSize(350, 300);

        t = new JTextField();
        t.setPreferredSize(new Dimension(350, 35));
        t.setEditable(false);

        p = new JPanel();


        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");


        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("x");
        buttonDivide = new JButton("/");
        buttonClear = new JButton("C");
        buttonDot = new JButton(".");
        buttonEquals = new JButton("=");

        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(buttonPlus);
        p.add(button4);
        p.add(button5);
        p.add(button6);
        p.add(buttonMinus);
        p.add(button7);
        p.add(button8);
        p.add(button9);
        p.add(buttonDivide);
        p.add(buttonDot);
        p.add(button0);
        p.add(buttonClear);
        p.add(buttonMultiply);
        

        p.setVisible(true);
        p.setLayout(new GridLayout(4, 4));


        f.add(t, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);
        f.add(buttonEquals, BorderLayout.SOUTH);
        f.setVisible(true);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonEquals.addActionListener(this);


     }

     public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        if (e.getSource() == buttonClear) {
            t.setText("");
            //System.out.println("...");
        } else if (e.getSource() == buttonEquals) {
            t.setText(calculate(t.getText()));
        } else {
            t.setText(t.getText() + value);
        }
     }

     public String calculate(String expression) {
        double result = 0;
        String operandFirst = "";
        String operandSecond = "";
        String operator = "";

        char[] arr = expression.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
                if (operator == "") {
                    operandFirst += arr[i];
                } else {
                    operandSecond += arr[i];
                }
            }

            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                operator += arr[i];
            }
        }

        if (operator.equals("+")) {
            result = (Double.parseDouble(operandFirst) + Double.parseDouble(operandSecond));
        }

        else if (operator.equals("-")) {
            result = (Double.parseDouble(operandFirst) - Double.parseDouble(operandSecond));
        }

        else if (operator.equals("/")) {
            result = (Double.parseDouble(operandFirst) / Double.parseDouble(operandSecond));
        }

        else {
            result = (Double.parseDouble(operandFirst) * Double.parseDouble(operandSecond));          
        }

        return operandFirst + operator + operandSecond + "=" + result;

     }

    public static void main(String[] args) {
        //Calculator c = new Calculator();
        Welcome w = new Welcome();  
    } 
} 

