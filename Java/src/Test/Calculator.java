package Test;

import javax.swing.*; // Importing the Swing package for creating graphical components like buttons, text fields, labels, etc.
import java.awt.event.*; // Importing the AWT package for layout management, fonts, colors, and other basic GUI properties
import java.awt.*; // Importing the AWT event package to handle user actions like button clicks, mouse movements, or keyboard input

public class Calculator implements ActionListener {
    JFrame frame; // Create a frame for the calculator
    JTextField textField; // Create TextBox to display input and results
    JButton[] NumberButton = new JButton[10]; // Create Array of Button Numbers 0-9
    JButton[] OperatorButton = new JButton[9]; // Create Array of Button Operator
    JButton addButton, subtractButton, multiplyButton, divideButton, negButton; // Assign buttons for operators
    JButton decButton, equButton, delButton, clrButton; // Assign buttons for operation

    JPanel panel = new JPanel(); // Create a panel to hold number buttons
    Font myFont = new Font("Segoe Print", Font.BOLD, 30); // Set font style for buttons and text field
    double num1 = 0, num2 = 0, result = 0; // Declare variables for calculations
    char operator; // Declare variable to store the operator

    Calculator() {
        // Initialize and style the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application on exit
        frame.setSize(420, 550); // Set the size of the frame
        frame.setLayout(null); // Set layout to null for absolute positioning

        // Initialize the text field
        textField = new JTextField();
        textField.setFont(myFont); // Set font for text field
        textField.setBounds(50, 25, 300, 60); // Set position and size of text field
        textField.setEditable(false); // Make text field non-editable by the user
        textField.setBackground(Color.LIGHT_GRAY);

        // Initialize operator buttons
        addButton = new JButton("+"); // Button for addition
        subtractButton = new JButton("-"); // Button for subtraction
        multiplyButton = new JButton("×"); // Button for multiplication
        divideButton = new JButton("÷"); // Button for division
        decButton = new JButton("."); // Button for decimal point
        equButton = new JButton("="); // Button for equals
        delButton = new JButton("D"); // Button for delete
        clrButton = new JButton("AC"); // Button for clear
        negButton = new JButton("(-)"); // Button for negating the number

        // Assign buttons into the OperatorButton array
        OperatorButton[0] = addButton;
        OperatorButton[1] = subtractButton;
        OperatorButton[2] = multiplyButton;
        OperatorButton[3] = divideButton;
        OperatorButton[4] = decButton;
        OperatorButton[5] = equButton;
        OperatorButton[6] = delButton;
        OperatorButton[7] = clrButton;
        OperatorButton[8] = negButton;

        // Add action listeners and set font for operator buttons
        for (int i = 0; i < 9; i++) {
            OperatorButton[i].addActionListener(this); // Register action listener for buttons
            OperatorButton[i].setFont(myFont); // Set font for buttons
            OperatorButton[i].setForeground(Color.BLACK);
            OperatorButton[i].setFocusable(false); // Disable focus for buttons
            OperatorButton[i].setBackground(Color.LIGHT_GRAY);
        }

        // Initialize number buttons and set their action listeners and fonts
        for (int i = 0; i < 10; i++) {
            NumberButton[i] = new JButton(String.valueOf(i)); // Create button for number i
            NumberButton[i].addActionListener(this); // Register action listener
            NumberButton[i].setFont(myFont); // Set font for number buttons
            NumberButton[i].setForeground(Color.BLACK);
            NumberButton[i].setFocusable(false); // Disable focus for number buttons
            NumberButton[i].setBackground(Color.WHITE);
        }

        // Set bounds for function buttons at the bottom of the frame
        negButton.setBounds(50, 430, 90, 50); // Set position and size for negate button
        delButton.setBounds(150, 430, 90, 50); // Set position and size for delete button
        clrButton.setBounds(250, 430, 100, 50); // Set position and size for clear button

        // Create a panel for number buttons and set layout to GridLayout
        panel = new JPanel();
        panel.setBounds(50, 110, 300, 300); // Set position and size for the panel
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // Create a grid layout with 4 rows and 4 columns

        // Add number and operator buttons to the panel
        panel.add(NumberButton[1]); // Button 1
        panel.add(NumberButton[2]); // Button 2
        panel.add(NumberButton[3]); // Button 3
        panel.add(addButton); // Addition operator

        panel.add(NumberButton[4]); // Button 4
        panel.add(NumberButton[5]); // Button 5
        panel.add(NumberButton[6]); // Button 6
        panel.add(subtractButton); // Subtraction operator

        panel.add(NumberButton[7]); // Button 7
        panel.add(NumberButton[8]); // Button 8
        panel.add(NumberButton[9]); // Button 9
        panel.add(multiplyButton); // Multiplication operator

        panel.add(decButton); // Decimal button
        panel.add(NumberButton[0]); // Button 0
        panel.add(equButton); // Equals button
        panel.add(divideButton); // Division operator

        // Add components to the frame
        frame.add(panel); // Add the panel containing buttons
        frame.add(negButton); // Add the negate button
        frame.add(delButton); // Add the delete button
        frame.add(clrButton); // Add the clear button
        frame.add(textField); // Add the text field to the frame
        frame.setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Create an instance of the Test.Calculator
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Handle button clicks
        for (int i = 0; i < 10; i++) { // Check if number button is pressed
            if (e.getSource() == NumberButton[i]) { // If the button pressed is a number button
                textField.setText(textField.getText().concat(String.valueOf(i))); // Append number to text field
            }
        }
        // Handle decimal button press
        if (e.getSource() == decButton) {
            if (textField.getText().equals("")) {
                textField.setText("0.");
            }
            // Check if the textField already contains a decimal point
            if (!textField.getText().contains(".")) { // If no decimal point present
                textField.setText(textField.getText().concat(".")); // Append decimal point
            }
        }
        // Handle addition button press
        if (e.getSource() == addButton) {
            if(!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText()); // Store first number
                operator = '+'; // Set operator to addition
                textField.setText(""); // Clear text field
            }else{
                textField.setText("");
            }
        }
        // Handle subtraction button press
        if (e.getSource() == subtractButton) {
            if(!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText()); // Store first number for subtraction
                operator = '-'; // Set operator to subtraction
                textField.setText(""); // Clear text field
            }else{
                textField.setText("");
            }
        }

        // Handle multiplication button press
        if (e.getSource() == multiplyButton) {
            if(!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText()); // Store first number for multiplication
                operator = '×'; // Set operator to multiplication
                textField.setText(""); // Clear text field
            }else{
                textField.setText("");
            }
        }

        // Handle division button press
        if (e.getSource() == divideButton) {
            if(!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText()); // Store first number for division
                operator = '÷'; // Set operator to division
                textField.setText(""); // Clear text field
            }else {
                textField.setText("");
            }
        }

        // Handle equals button press
        if (e.getSource() == equButton) {
            if(!textField.getText().equals("")){
                num2 = Double.parseDouble(textField.getText()); // Get the second number for calculation

                // Perform calculation based on the operator
                switch (operator) {
                    case '+':
                        result = num1 + num2; // Addition
                        break;
                    case '-':
                        result = num1 - num2; // Subtraction
                        break;
                    case '×':
                        result = num1 * num2; // Multiplication
                        break;
                    case '÷':
                        if (num2 != 0) {
                            result = num1 / num2; // Division
                        } else {
                            textField.setText("Error"); // Handle division by zero
                            return;
                        }
                        break;
                }
                textField.setText(String.format("%.12g", result)); // Display the result in the text field
                num1 = result; // Store the result for further calculations
            }else {
                textField.setText("");
            }
        }

        // Handle clear button press
        if (e.getSource() == clrButton) {
            if(!textField.getText().isEmpty()){
                textField.setText(""); // Clear the text field
            }else {
                textField.setText("");
            }
        }

        // Handle delete button press
        if (e.getSource() == delButton) {
            String string = textField.getText(); // Get current text in the text field
            if (!string.isEmpty()) {
                textField.setText(string.substring(0, string.length() - 1)); // Remove the last character
            }else {
                textField.setText("");
            }
        }

        // Handle negate button press
        if (e.getSource() == negButton) {
            if (!textField.getText().isEmpty()) { // Check if the text field is not empty
                double temp = Double.parseDouble(textField.getText());
                temp *= -1; // Negate the value
                textField.setText(String.valueOf(temp)); // Update the text field with negated value
            } else {
                // Optionally, you can show an error message or do nothing
                textField.setText("0"); // Set it to zero or any default value
            }
        }
    }

}
