import javax.swing.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Main extends JFrame {

    public Main() {
        initComponents();
    }

    private void initComponents() {
    	
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setTitle("Change Background color");

        headerPanel.setBackground(new Color(177, 189, 209));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addLabel("Change The Background Color Program", headerLabel, headerPanel);
        
        buttonPanel.setBackground(new Color(121, 114, 160));
        buttonPanel.setLayout(new GridLayout(1, 4));

        addButton("Green", greenBtn, buttonPanel);
        addButton("Blue", blueBtn, buttonPanel);
        addButton("Red", redBtn, buttonPanel);
        addButton("Exit", exitBtn, buttonPanel);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void addButton(String title, JButton mButton, JPanel mPanel) {
    	mButton.setFont(new Font("Arial", 1, 18));
    	mButton.setText(title);
    	mButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent evt) {
				addButtonAction(title);
			}
		});
    	mPanel.add(mButton);
    }
    
    private void addButtonAction(String title) {
    	switch(title) {
    	case "Green":
    		this.getContentPane().setBackground(Color.GREEN);
    		break;
    	case "Red":
    		this.getContentPane().setBackground(Color.RED);
    		break;
    	case "Blue":
    		this.getContentPane().setBackground(Color.BLUE);
    		break;
    	case "Exit":
    		this.dispose();
    		break;
    	}
    }
    private void addLabel(String title, JLabel mLabel, JPanel mPanel) {
    	mLabel.setFont(new Font("Arial", 1, 20)); // NOI18N
    	mLabel.setForeground(new Color(0, 0, 0));
    	mLabel.setText(title);
    	mPanel.add(mLabel);
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
    
    private JButton redBtn = new JButton();
    private JPanel buttonPanel = new JPanel();
    private JButton greenBtn = new JButton();
    private JButton exitBtn = new JButton();
    private JLabel headerLabel = new JLabel();
    private JPanel headerPanel = new JPanel();
    private JButton blueBtn = new JButton();
}