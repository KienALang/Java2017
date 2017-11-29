import javax.swing.*;
import java.util.logging.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Main extends JFrame {

    public Main() {
        initComponents();
    }

    private void initComponents() {
    	
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Linear Equation");

        headerPanel.setBackground(new Color(177, 189, 209));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addLabel("Is An Input Value a Fibonaci Number?", headerLabel, headerPanel);
        

        inputPanel.setBackground(new Color(218, 225, 237));
        inputPanel.setLayout(new GridLayout(2, 2));
        
        addLabel("Enter N:", baseValueLabel, inputPanel);
        addTextField("0", baseValueTextField, inputPanel);
        addLabel("Result", resultLabel, inputPanel);
        addTextField("Unknown", resultTextField, inputPanel);

        buttonPanel.setBackground(new Color(121, 114, 160));
        buttonPanel.setLayout(new GridLayout(1, 3));

        addButton("Check", checkBtn, buttonPanel);
        addButton("Reset", resetBtn, buttonPanel);
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
                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void addButton(String title, JButton mButton, JPanel mPanel) {
    	mButton.setFont(new Font("Arial", 1, 18));
    	mButton.setText(title);
    	mPanel.add(mButton);
    }
    
    private void addLabel(String title, JLabel mLabel, JPanel mPanel) {
    	mLabel.setFont(new Font("Arial", 1, 20)); // NOI18N
    	mLabel.setForeground(new Color(0, 0, 0));
    	mLabel.setText(title);
    	mPanel.add(mLabel);
    }
    
    private void addTextField(String title, JTextField mTextField, JPanel mPanel) {
    	mTextField.setFont(new Font("Arial", 0, 18)); // NOI18N
    	mTextField.setForeground(new Color(0, 0, 0));
    	mTextField.setText(title);
    	mPanel.add(mTextField);
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
    private JButton checkBtn = new JButton();
    private JButton exitBtn = new JButton();
    private JLabel headerLabel = new JLabel();
    private JPanel headerPanel = new JPanel();
    private JPanel inputPanel = new JPanel();
    private JButton resetBtn = new JButton();
    private JLabel resultLabel = new JLabel();
    private JTextField resultTextField = new JTextField();
    // End of variables declaration//GEN-END:variables
}