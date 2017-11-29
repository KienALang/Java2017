package com.kien;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.logging.*;

@SuppressWarnings("serial")
public class UserInterface extends JFrame {

	public UserInterface() {
		initComponents();
		this.setFont(new Font("Arial", 1, 20));
	}

	private void initComponents() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				formKeyPressed(evt);
			}
		});

		expressionPanel.setBackground(new Color(255, 255, 255));

		expressionLabel.setFont(new Font("Arial", 0, 48));
		expressionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		expressionLabel.setText("0");
		expressionLabel.setVerticalAlignment(SwingConstants.BOTTOM);

		GroupLayout expressionPanelLayout = new GroupLayout(expressionPanel);
		expressionPanel.setLayout(expressionPanelLayout);
		expressionPanelLayout
				.setHorizontalGroup(expressionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(expressionLabel, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE));
		expressionPanelLayout.setVerticalGroup(expressionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(expressionLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE));

		cleanerPanel.setBackground(new Color(25, 26, 50));
		cleanerPanel.setLayout(new GridLayout(1, 3));

		addButton("Backspace", backspaceBtn, cleanerPanel);
		addButton("CE", ceBtn, cleanerPanel);
		addButton("C", cBtn, cleanerPanel);

		numberPanel.setBackground(new Color(100, 20, 49));
		numberPanel.setLayout(new GridLayout(4, 6));

		addButton("MC", mcBtn, numberPanel);
		addButton("7", sevenBtn, numberPanel);
		addButton("8", eightBtn, numberPanel);
		addButton("9", nineBtn, numberPanel);

		addButton("/", devideBtn, numberPanel);
		addButton("sqrt", sqrtBtn, numberPanel);
		addButton("MR", mrBtn, numberPanel);

		addButton("4", fourBtn, numberPanel);
		addButton("5", fiveBtn, numberPanel);
		addButton("6", sixBtn, numberPanel);

		addButton("*", mulBtn, numberPanel);
		addButton("%", percentBtn, numberPanel);
		addButton("MS", msBtn, numberPanel);

		addButton("1", oneBtn, numberPanel);
		addButton("2", twoBtn, numberPanel);
		addButton("3", threeBtn, numberPanel);

		addButton("-", minusBtn, numberPanel);
		addButton("1/x", oneofXBtn, numberPanel);
		addButton("M+", mPlusBtn, numberPanel);

		addButton("0", zeroBtn, numberPanel);
		addButton("+/-", plusMinusBtn, numberPanel);
		addButton(".", dotBtn, numberPanel);
		addButton("+", plusBtn, numberPanel);
		addButton("=", equalBtn, numberPanel);

		fileMenu.setText("File");

		open.setText("Open");
		fileMenu.add(open);

		exit.setText("Exit");
		fileMenu.add(exit);

		close.setText("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		fileMenu.add(close);

		menuBar.add(fileMenu);

		optionMenu.setText("Option");

		calculatorMenu.setText("Calculator");

		standard.setText("Standard");
		calculatorMenu.add(standard);

		scientific.setText("Scientific");
		calculatorMenu.add(scientific);

		programmer.setText("Programmer");
		calculatorMenu.add(programmer);

		optionMenu.add(calculatorMenu);

		moneyConverter.setText("Money Converter");
		optionMenu.add(moneyConverter);

		menuBar.add(optionMenu);

		setJMenuBar(menuBar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(expressionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(cleanerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(numberPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(expressionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cleanerPanel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(numberPanel, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)));

		pack();
	}

	private String expression = "0";

	private void formKeyPressed(KeyEvent evt) {
		if (isNumpadKey(evt))
			updateExpression(String.valueOf(evt.getKeyChar()));
		if (isBackspaceKey(evt))
			deleteLastCharacter();
		if (isEqualsOrEnterKey(evt))
			 getResult();
	}

	private void getResult() {
		PostfixCalculator mPostfix = new PostfixCalculator(expression);
		expression = mPostfix.getResult();
		expressionLabel.setText(expression);
	}

	private boolean isEqualsOrEnterKey(KeyEvent evt) {
		return evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyChar() == '=';
	}

	private boolean isBackspaceKey(KeyEvent evt) {
		return evt.getKeyCode() == KeyEvent.VK_BACK_SPACE;
	}

	private void updateExpression(String mKeyChar) {
		if (expression.equals("0"))
			expression = "";
		if (expression.length() < 17)
			expression += mKeyChar;
		expressionLabel.setText(expression);
	}

	private boolean isNumpadKey(KeyEvent evt) {
		char keyChar = evt.getKeyChar();
		if ("0123456789./*-+%".indexOf(keyChar) > -1)
			return true;
		return false;
	}

	private void addButton(String btnTitle, JButton mBtn, JPanel mPanel) {
		mBtn.setFont(new Font("Arial", 1, 20));
		mBtn.setText(btnTitle);
		mBtn.setFocusable(false);
		mBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if ("0123456789./*-+%".indexOf(btnTitle) > -1)
					updateExpression(btnTitle);
				if (btnTitle.equals("Backspace"))
					deleteLastCharacter();
				if (btnTitle.equals("C"))
					clearExpression();
				if (btnTitle.equals("Enter") || btnTitle.equals("="))
					getResult();
			}

			
		});
		mPanel.add(mBtn);
	}
	
	private void deleteLastCharacter() {
		if (expression.length() > 0) {
			expression = expression.substring(0, expression.length()-1);			
		}
		
		if (expression.length() == 0)
			expression = "0";
		expressionLabel.setText(expression);
	}
	
	private void clearExpression() {
		expression = "0";
		expressionLabel.setText(expression);
	}

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new UserInterface().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton backspaceBtn = new JButton();
	private JButton cBtn = new JButton();
	private JMenu calculatorMenu = new JMenu();
	private JButton ceBtn = new JButton();
	private JPanel cleanerPanel = new JPanel();
	private JMenuItem close = new JMenuItem();
	private JButton devideBtn = new JButton();
	private JButton dotBtn = new JButton();
	private JButton eightBtn = new JButton();
	private JButton equalBtn = new JButton();
	private JMenuItem exit = new JMenuItem();
	private JLabel expressionLabel = new JLabel();
	private JPanel expressionPanel = new JPanel();
	private JMenu fileMenu = new JMenu();
	private JButton fiveBtn = new JButton();
	private JButton fourBtn = new JButton();
	private JButton mPlusBtn = new JButton();
	private JButton mcBtn = new JButton();
	private JMenuBar menuBar = new JMenuBar();
	private JButton minusBtn = new JButton();
	private JMenuItem moneyConverter = new JMenuItem();
	private JButton mrBtn = new JButton();
	private JButton msBtn = new JButton();
	private JButton mulBtn = new JButton();
	private JButton nineBtn = new JButton();
	private JPanel numberPanel = new JPanel();
	private JButton oneBtn = new JButton();
	private JButton oneofXBtn = new JButton();
	private JMenuItem open = new JMenuItem();
	private JMenu optionMenu = new JMenu();
	private JButton percentBtn = new JButton();
	private JButton plusBtn = new JButton();
	private JButton plusMinusBtn = new JButton();
	private JCheckBoxMenuItem programmer = new JCheckBoxMenuItem();
	private JCheckBoxMenuItem scientific = new JCheckBoxMenuItem();
	private JCheckBoxMenuItem standard = new JCheckBoxMenuItem();
	private JButton sevenBtn = new JButton();
	private JButton sixBtn = new JButton();
	private JButton sqrtBtn = new JButton();
	private JButton threeBtn = new JButton();
	private JButton twoBtn = new JButton();
	private JButton zeroBtn = new JButton();
	// End of variables declaration//GEN-END:variables
}