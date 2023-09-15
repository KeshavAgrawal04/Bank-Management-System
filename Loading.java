import javax.swing.*;
import java.net.URL;

public class Loading{
    JFrame frame;
    Loading() {
        frame = new JFrame();
        frame.setSize(500,500);

        URL url = this.getClass().getResource("images/loading.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        label.setBounds(150,100,200,200);

        frame.setUndecorated(true);
        frame.setEnabled(false);
        frame.add(label);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Loading();
    }
}
