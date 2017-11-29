import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main() {
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Operator Example");

		headerPanel.setBackground(new Color(255, 255, 255));

		addLabel("Operator Example", headerLabel, headerPanel);

		inputPanel.setBackground(new Color(135, 167, 219));
		inputPanel.setLayout(new GridLayout(3, 2));

		addLabel("Base Value", baseValueLabel, inputPanel);
		addTextField("0", baseValueTextField, inputPanel);

		addLabel("Second Value", secondValueLabel, inputPanel);
		addTextField("0", secondValueTextField, inputPanel);

		addLabel("Result", resultLabel, inputPanel);
		addTextField("0", resultTextField, inputPanel);

		buttonPanel.setBackground(new Color(121, 114, 160));
		buttonPanel.setLayout(new GridLayout(1, 4));

		addButton("Add", addBtn, buttonPanel);
		addButton("Subtract", subtractBtn, buttonPanel);
		addButton("Multiple", multiBtn, buttonPanel);
		addButton("Divide", divideBtn, buttonPanel);

		buttonPanel1.setBackground(new Color(121, 114, 160));
		buttonPanel1.setLayout(new GridLayout(1, 2));

		addButton("Exit", exitBtn, buttonPanel1);
		addButton("Reset", resetBtn, buttonPanel1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(inputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
				.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(buttonPanel1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(18, 18, Short.MAX_VALUE).addComponent(buttonPanel1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));

		pack();
	}

	private void addLabel(String title, JLabel mLabel, JPanel mPanel) {
		mLabel.setFont(new Font("Arial", 1, 20)); // NOI18N
		mLabel.setForeground(new Color(0, 0, 0));
		mLabel.setText(title);
		mPanel.add(mLabel);
	}

	private void addTextField(String title, JTextField mTextField, JPanel mPanel) {
		mTextField.setText(title);
		mTextField.setFont(new Font("Arial", 0, 20));
		mPanel.add(mTextField);
	}

	private void addButton(String title, JButton mButton, JPanel mPanel) {
		mButton.setText(title);
		mButton.setFont(new Font("Arial", 0, 20));
		mButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addButtonActionEvent(title);
			}
		});
		mPanel.add(mButton);
	}

	private void addButtonActionEvent(String btnTitle) {
		switch (btnTitle) {
		case "Add":
			getResult("+");
			break;
		case "Subtract":
			getResult("-");
			break;
		case "Divide":
			getResult("/");
			break;
		case "Multiple":
			getResult("*");
			break;

		case "Reset":
			resetTextField();
			break;
		case "Exit":
			dispose();
			break;

		default:
			break;
		}
	}

	private void resetTextField() {
		baseValueTextField.setText("0");
		secondValueTextField.setText("0");
		resultTextField.setText("0");
	}

	private void getResult(String oper) {
		double a = Double.valueOf(baseValueTextField.getText());
		double b = Double.valueOf(secondValueTextField.getText());
		
		String result = null;
		switch (oper) {
		case "+":
			result = String.valueOf(a+b);
			break;
		case "-":
			result = String.valueOf(a-b);
			break;
		case "*":
			result = String.valueOf(a*b);
			break;
		case "/":
			result = String.valueOf(a/b);
			break;
		}

		resultTextField.setText(result);

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
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton addBtn = new JButton();
	private JLabel baseValueLabel = new JLabel();
	private JTextField baseValueTextField = new JTextField();
	private JPanel buttonPanel = new JPanel();
	private JPanel buttonPanel1 = new JPanel();
	private JButton divideBtn = new JButton();
	private JButton exitBtn = new JButton();
	private JLabel headerLabel = new JLabel();
	private JPanel headerPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JButton multiBtn = new JButton();
	private JButton resetBtn = new JButton();
	private JLabel resultLabel = new JLabel();
	private JTextField resultTextField = new JTextField();
	private JLabel secondValueLabel = new JLabel();
	private JTextField secondValueTextField = new JTextField();
	private JButton subtractBtn = new JButton();
	// End of variables declaration//GEN-END:variables
}