import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
//import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
//import javax.swing.DropMode;
import java.awt.Window.Type;
import java.awt.Font;
//import java.awt.Button;
//import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField textField;
	String result;
	String input;
	String line;
	Path path = Paths.get("cal.txt");
	Path path1 = Paths.get("temp1.txt");
	Charset  charset = Charset.forName("US-ASCII");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCalculator = new JFrame();
		frmCalculator.setType(Type.UTILITY);
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 242, 339);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(226, 11, 150, 74);
		frmCalculator.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton(".");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+".");
			}
		});
		btnNewButton.setBounds(10, 256, 50, 38);
		frmCalculator.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		button.setBounds(10, 216, 50, 38);
		frmCalculator.getContentPane().add(button);
		
		JButton button_1 = new JButton("8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		button_1.setBounds(62, 216, 50, 38);
		frmCalculator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		button_2.setBounds(114, 216, 50, 38);
		frmCalculator.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("6");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		button_3.setBounds(114, 176, 50, 38);
		frmCalculator.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		button_4.setBounds(62, 176, 50, 38);
		frmCalculator.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("4");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		button_5.setBounds(10, 176, 50, 38);
		frmCalculator.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("3");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		button_6.setBounds(114, 137, 50, 38);
		frmCalculator.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("2");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		button_7.setBounds(62, 137, 50, 38);
		frmCalculator.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("1");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
				textArea.setText("1");
			}
		});
		button_8.setBounds(10, 137, 50, 38);
		frmCalculator.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("=");
		button_9.addKeyListener(new KeyAdapter() {
			
		});
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				String userInput =textField.getText();
				System.out.println(userInput);
				input=userInput;
				result=evaluateExp(userInput);
				textField.setText(null);
				textField.setText(textField.getText()+result);
				try{
					BufferedWriter writer = Files.newBufferedWriter(path,charset);
			    	writer.append(userInput);
		        	writer.append(" = ");
		        	writer.append(result);
		        	writer.append("\n");
				}catch (Exception e1) {
			        e1.printStackTrace();
			    }
		        					
			}
			
		});
		button_9.setBounds(114, 256, 102, 38);
		frmCalculator.getContentPane().add(button_9);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==10) {
					String userInput =textField.getText();
					System.out.println(userInput);
					input=userInput;
					result=evaluateExp(userInput);
					textField.setText(null);
					textField.setText(textField.getText()+result);
				}
			}
		});
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 206, 74);
		frmCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBackspace = new JButton("\uF0E7");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace=null;
				if(textField.getText().length()>0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backSpace = str.toString();
					textField.setText(backSpace);
				}
			}
		});
		btnBackspace.setBounds(10, 96, 50, 38);
		frmCalculator.getContentPane().add(btnBackspace);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnC.setBounds(62, 96, 50, 38);
		frmCalculator.getContentPane().add(btnC);
		
		JButton btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField.setText(textField.getText()+input);
				
			}
		});
		btnM.setBounds(114, 96, 50, 38);
		frmCalculator.getContentPane().add(btnM);
		
		JButton button_13 = new JButton("+");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"+");
			}
		});
		button_13.setBounds(166, 216, 50, 38);
		frmCalculator.getContentPane().add(button_13);
		
		JButton button_15 = new JButton("-");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"-");
			}
		});
		button_15.setBounds(166, 176, 50, 38);
		frmCalculator.getContentPane().add(button_15);
		
		JButton button_16 = new JButton("/");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"/");
			}
		});
		button_16.setBounds(166, 137, 50, 38);
		frmCalculator.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("*");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"*");
			}
		});
		button_17.setBounds(166, 96, 50, 38);
		frmCalculator.getContentPane().add(button_17);
		
		JButton button_14 = new JButton("0");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"0");
				
			}
		});
		button_14.setBounds(62, 256, 50, 38);
		frmCalculator.getContentPane().add(button_14);
		
		
	}
	private String evaluateExp(String input) {
        ArrayList<Double> arrayList;
        ArrayList<String> operatorList;
        String userInput;
        String str;
        userInput = input;
        Parsing par = new Parsing(userInput);
        arrayList = par.getArray();
        operatorList = par.getOperator();
        String arr;
        arr = "";
        str = "operator";
        int x = operatorList.size();
        int l = 0;
        int q=operatorList.size();
        int p=arrayList.size();
        if (p<=q) {
            arr="Error";
        	return(arr);
        } else {
            while (l < x) {              
                if (operatorList.indexOf("/") > -1) {                   
                    str = "/";
                    arr = getResult(arrayList, operatorList, str, operatorList.indexOf("/"));                   
                } else if (operatorList.indexOf("*") > -1) {                   
                    str = "*";
                    arr = getResult(arrayList, operatorList, str, operatorList.indexOf("*"));                  
                } else if (operatorList.indexOf("+") > -1) {                    
                    str = "+";
                    arr = getResult(arrayList, operatorList, str, operatorList.indexOf("+"));                   
                } else if (operatorList.indexOf("-") > -1) {                    
                    str = "-";
                    arr = getResult(arrayList, operatorList, str, operatorList.indexOf("-"));                  
                }
                l++;               
            }
            System.out.println("Result: " + arr);
            return(arr);
        }
        
    }
public static String getResult(ArrayList<Double> mArrray,
		ArrayList<String> nOperator,String s,int l){
        double a;
        double b;
        double c;
            a = (double) mArrray.get(l);
            b = (double) mArrray.get(l + 1);
            c = getfunction(a,b,s);
            mArrray.set(l, c);
            mArrray.remove(l + 1);
            nOperator.remove(l); 
            return (Double.toString(c));
    }

public static double getfunction(double p,double q,String s){
        Operation call = new Operation();
        double r;
        if(s=="/") {
            r = call.division(p, q);
            return r;
        }else if(s=="*") {
            r = call.multiplication(p, q);
            return r;
        }else if(s=="+") {
            r = call.addition(p, q);
            return r;
        }else if(s=="-") {
            r = call.substraction(p, q);
            return r;
        }else
            return 0;
    }
}
