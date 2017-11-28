import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;
    private String expression = "0";

    public KeyListenerTester(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        expression += e.getKeyChar();
        label.setText(expression);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            label.setText("right Key keyReleased");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            label.setText("right Key keyReleased");
        }
    }

    public static void main(String[] args) {
        new KeyListenerTester("Key Listener Tester");
    }
}