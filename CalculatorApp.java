package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CalculatorApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel label;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bMulti, bDiv, bPlus, bMinus, bClear, bEquals;

	private String screenStr = "0";
	String[] operatorArray = { "*", "/", "+", "-" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp frame = new CalculatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void updateScreen() {
		label.setText(screenStr);
	}

	private void btnNumber(String num) {
		if (isLastOperator() && num.equals("0")) {
			return;
		}
		if (screenStr.equals("0")) {
			screenStr = num;
		} else {
			screenStr += num;
		}
		updateScreen();
	}

	private void btnCalc() {
		int index = -1;
		for (String str : operatorArray) {
			index = screenStr.lastIndexOf(str);
			if (index != -1)
				break;
		}
		int num1 = Integer.parseInt(screenStr.substring(0, index));
		String operator = screenStr.substring(index, index + 1);
		int num2 = Integer.parseInt(screenStr.substring(index + 1));
		int result = 0;
		switch (operator) {
			case "*": result=num1*num2; break;
			case "/": result=num1/num2; break;
			case "+": result=num1+num2; break;
			case "-": result=num1-num2; break;
		}
		screenStr = Integer.toString(result);
		updateScreen();
	}

	private void btnCalc(String operator) {
		if (screenStr.equals("0")) {
			return;
		}
		if (isLastOperator()) {
			screenStr = screenStr.substring(0, screenStr.length() - 1);
		} else if (hasOperator()) {
			return;
		}
		screenStr += operator;
		updateScreen();
	}

	private boolean isLastOperator() {
		int lastIndex = screenStr.length() - 1;
		char lastInput = screenStr.charAt(lastIndex);
		switch (lastInput) {
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		}
		return false;
	}

	private boolean hasOperator() {
		int index = -1;
		for (String str : operatorArray) {
			index = screenStr.lastIndexOf(str);
			if (index != -1)
				break;
		}
		if (-1 == index)
			return false;
		else
			return true;
	}

	private void btnClear() {
		screenStr = "0";
		updateScreen();
	}

	public CalculatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 5, 5));

		b7 = new JButton("7");
		b7.addActionListener(e -> btnNumber("7"));
		b7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b7);

		b8 = new JButton("8");
		b8.addActionListener(e -> btnNumber("8"));
		b8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b8);

		b9 = new JButton("9");
//		b9.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		b9.addActionListener(e -> btnNumber("9"));
		b9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b9);

		bMulti = new JButton("*");
		bMulti.addActionListener(e -> btnCalc("*"));
		bMulti.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bMulti);

		b4 = new JButton("4");
		b4.addActionListener(e -> btnNumber("4"));
		b4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b4);

		b5 = new JButton("5");
		b5.addActionListener(e -> btnNumber("5"));
		b5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b5);

		b6 = new JButton("6");
		b6.addActionListener(e -> btnNumber("6"));
		b6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b6);

		bDiv = new JButton("/");
		bDiv.addActionListener(e -> btnCalc("/"));
		bDiv.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bDiv);

		b1 = new JButton("1");
		b1.addActionListener(e -> btnNumber("1"));
		b1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b1);

		b2 = new JButton("2");
		b2.addActionListener(e -> btnNumber("2"));
		b2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b2);

		b3 = new JButton("3");
		b3.addActionListener(e -> btnNumber("3"));
		b3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b3);

		bPlus = new JButton("+");
		bPlus.addActionListener(e -> btnCalc("+"));
		bPlus.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bPlus);

		b0 = new JButton("0");
		b0.addActionListener(e -> btnNumber("0"));
		b0.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b0);

		bClear = new JButton("C");
		bClear.addActionListener(e -> btnClear());
		bClear.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bClear);

		bEquals = new JButton("=");
		bEquals.addActionListener(e -> btnCalc());
		bEquals.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bEquals);

		bMinus = new JButton("-");
		bMinus.addActionListener(e -> btnCalc("-"));
		bMinus.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bMinus);

		label = new JLabel(screenStr);
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		contentPane.add(label, BorderLayout.NORTH);
	}

}