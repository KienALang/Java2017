import java.awt.*;

public class AllFrameComponent extends Frame {	

	public static void main(String[] args) {

		AllFrameComponent f = new AllFrameComponent();
		f.setTitle("Welcome Kenny");
		f.setBounds(200,500,700,700);
		f.setLayout(new FlowLayout());
		f.add(new Button("OK"));
		f.add(new Button("Cancel"));

		f.add(new Label("This is Label"));
		f.add(new TextField(7));
		f.add(new TextArea(5,30));

		f.add(new Checkbox("Sport"));
		f.add(new Checkbox("Music"));
		f.add(new Checkbox("Travel"));

		CheckboxGroup chkboxGroup = new CheckboxGroup();

		f.add(new Checkbox("Female", chkboxGroup, false));
		f.add(new Checkbox("Male", chkboxGroup, true));

		Choice choice = new Choice();
		choice.addItem("Sport");
		choice.addItem("Music");
		choice.addItem("Travel");
		f.add(choice);

		List list = new List(3, false);
		list.add("Music");
		list.add("Travel");
		list.add("Game");
		list.add("Telen");
		f.add(list);

		f.setVisible(true);
	}	
}