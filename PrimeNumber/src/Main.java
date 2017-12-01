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
        setTitle("Prime Number");

        headerPanel.setBackground(new Color(255, 255, 255));
        addLabel("Prime Number Less Than Or Equals N", headerLabel, headerPanel);
        
        inputPanel.setBackground(new Color(135, 167, 219));
        inputPanel.setLayout(new GridLayout(2, 2));
        
        addLabel("Enter N:", baseValueLabel, inputPanel);
        addTextField("0", baseValueTextField, inputPanel);
        
        addLabel("Result", resultLabel, inputPanel);
        addTextField("0", resultTextField, inputPanel);

        buttonPanel.setBackground(new Color(121, 114, 160));
        buttonPanel.setLayout(new GridLayout(1, 3));
        
        addButton("Find", findBtn, buttonPanel);
        addButton("Reset", subtractBtn, buttonPanel);
        addButton("Exit", exitBtn, buttonPanel);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(inputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
            .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

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
		case "Find":
			getResult();
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
		resultTextField.setText("0");
	}

	private void getResult() {
		int n = Integer.valueOf(baseValueTextField.getText());
		String result = "";
		boolean array[] = new boolean[n+1];
		java.util.Arrays.fill(array, true); //initialize all element to true.
		
		int notExceed = (int) Math.sqrt(n);
		for (int i = 2; i <= notExceed; ++i ) {
			if (array[i]) 
				for (int k = i*i; k <= n; k += i) array[k] = false;
			}

		for (int i = 2; i <= n; ++i )
			if (array[i])
				result += ""+i+" ";
		
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
    private JLabel baseValueLabel = new JLabel();
    private JTextField baseValueTextField = new JTextField();
    private JPanel buttonPanel = new JPanel();
    private JButton exitBtn = new JButton();
    private JButton findBtn = new JButton();
    private JLabel headerLabel = new JLabel();
    private JPanel headerPanel = new JPanel();
    private JPanel inputPanel = new JPanel();
    private JLabel resultLabel = new JLabel();
    private JTextField resultTextField = new JTextField();
    private JButton subtractBtn = new JButton();
    // End of variables declaration//GEN-END:variables
}