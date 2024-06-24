package gui;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField2;
    private JLabel lblResultValue;
    
    double intI;
    double intII;
    double total;
    
    OperationInterface operation;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calc window = new Calc();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Calc() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 964, 217);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.BOLD, 30));
        textField.setBounds(10, 10, 237, 73);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField2 = new JTextField();
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField2.setBounds(349, 10, 237, 73);
        frame.getContentPane().add(textField2);
        textField2.setColumns(10);
        
        lblResultValue = new JLabel("Here is the result");
        lblResultValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblResultValue.setBounds(692, 10, 248, 66);
        frame.getContentPane().add(lblResultValue);
        
        JCheckBox chckbxPlus = new JCheckBox("Plus");
        chckbxPlus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        chckbxPlus.setBounds(250, 10, 93, 21);
        frame.getContentPane().add(chckbxPlus);
        
        JCheckBox chckbxMinus = new JCheckBox("Minus");
        chckbxMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        chckbxMinus.setBounds(250, 30, 93, 21);
        frame.getContentPane().add(chckbxMinus);
        
        JCheckBox chckbxDivision = new JCheckBox("Division");
        chckbxDivision.setFont(new Font("Tahoma", Font.PLAIN, 18));
        chckbxDivision.setBounds(250, 50, 93, 21);
        frame.getContentPane().add(chckbxDivision);
        
        JCheckBox chckbxSqrt = new JCheckBox("Sqrt");
        chckbxSqrt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        chckbxSqrt.setBounds(250, 70, 93, 21);
        frame.getContentPane().add(chckbxSqrt);

        ButtonGroup checkboxesGroup = new ButtonGroup();
        checkboxesGroup.add(chckbxPlus);
        checkboxesGroup.add(chckbxMinus);
        checkboxesGroup.add(chckbxSqrt);
        checkboxesGroup.add(chckbxDivision);
        
        
        chckbxPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    operation = new Add();
            }
        });
        
        chckbxMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    operation = new Minus();
            }
        });
        chckbxDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    operation = new Division();
                
            }
        });
        chckbxSqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   operation = new Sqrt();
            }
        });
        JButton btnEql = new JButton("=");
        btnEql.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(validateInputs()) {
                   intI = Double.parseDouble(textField.getText());
                   intII = textField2.getText().isEmpty()? 0 : Double.parseDouble(textField2.getText());
            	   total = operation.calculate(intI, intII);
            	   lblResultValue.setText(Double.toString(total));}
            	else lblResultValue.setText("Here is the result");
          }
           
        });
        btnEql.setFont(new Font("Calibri", Font.PLAIN, 24));
        btnEql.setBounds(610, 25, 72, 56);
        frame.getContentPane().add(btnEql);
        
        JButton btnC = new JButton("C");
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField2.setText("");
                lblResultValue.setText("Here is the result");
                operation = null;
            }
        });
        btnC.setFont(new Font("Calibri", Font.PLAIN, 24));
        btnC.setBounds(359, 93, 225, 73);
        frame.getContentPane().add(btnC);
        
        
    }
    private boolean validateInputs() {
        if (textField.getText().isEmpty()) {
            lblResultValue.setText("Here is the result");
            return false;
        }
        return true;

    }
}
