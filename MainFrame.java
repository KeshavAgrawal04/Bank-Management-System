import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        ImageIcon backgroundImg = new ImageIcon("images/Background.jpg");
        Image backgroundImage = backgroundImg.getImage();
        frame.setContentPane(new JPanel(){
            @Override
            public void setLayout(LayoutManager mgr) {
                super.setLayout(null);
            }

            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        });

        ImageIcon icon = new ImageIcon("images/banking-system.png");
        Image img = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);

        JLabel background = new JLabel(image);
        background.setBounds(140,50,200,200);

        JLabel name = new JLabel("Digital Banking Services");
        name.setBounds(0,250,500,50);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Monospaced",Font.BOLD,35));
        name.setForeground(Color.GREEN);

        ImageIcon pro = new ImageIcon("images/progressbar.gif");

        JLabel progress = new JLabel(pro);
        progress.setBounds(0,250,500,200);
        progress.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(progress);
        frame.add(name);
        frame.add(background);
        frame.setLayout(null);
        frame.setVisible(true);
        try {
            Thread.sleep(6000);
            frame.dispose();
            GUI gui = new GUI();
            gui.createGui();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
