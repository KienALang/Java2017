import javax.swing.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main() {
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Item Event");

		headerPanel.setBackground(new Color(177, 189, 209));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel("Item Event Example", headerLabel, headerPanel);

		groupPanel.setBackground(new Color(222, 230, 242));
		groupPanel.setLayout(new GridLayout(1, 2));

		addCheckBox("Male", maleRadioBtn);
		addCheckBox("Female", femaleRadioBtn);

		choicePanel.setBackground(new Color(230, 239, 201));
		choicePanel.setLayout(new GridLayout(1, 2));

		choice.add("Item 1");
		choice.add("Item 2");
		choice.add("Item 3");
		choice.add("Item 4");
		choice.add("Item 5");
		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				resultLabel.setText(choice.getSelectedItem());

			}
		});

		choicePanel.add(choice);

		list.add("Hello");
		list.add("Hi");
		list.add("Greeting");
		list.add("Nice to meet you");
		list.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				resultLabel.setText(list.getSelectedItem());

			}
		});

		choicePanel.add(list);

		resultPanel.setBackground(new Color(0, 239, 201));
		resultPanel.setLayout(new GridLayout(1, 2));

		addLabel("The item is displayed here.", resultLabel, resultPanel);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(headerPanel, 600, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(groupPanel, 600, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(choicePanel, 600, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(resultPanel, 600, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(groupPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(choicePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(resultPanel,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void addCheckBox(String title, JRadioButton mRadioBtn) {
		mRadioBtn.setFont(new Font("Arial", 1, 18));
		mRadioBtn.setText(title);
		mRadioBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				addButtonAction(title);
			}
		});

		group.add(mRadioBtn);
		groupPanel.add(mRadioBtn);
	}

	private void addButtonAction(String title) {
		switch (title) {
		case "Male":
			resultLabel.setText("Male radio button was selected!");
			break;
		case "Female":
			resultLabel.setText("Female radio button was selected!");
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

	private ButtonGroup group = new ButtonGroup();
	private JRadioButton maleRadioBtn = new JRadioButton();
	private JRadioButton femaleRadioBtn = new JRadioButton();
	private JLabel headerLabel = new JLabel();
	private JPanel headerPanel = new JPanel();
	private JPanel groupPanel = new JPanel();
	private Choice choice = new Choice();
	private JPanel choicePanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private JLabel resultLabel = new JLabel();
	private List list = new List();
}