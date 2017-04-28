import java.awt.Component;
import javax.swing.JFrame;

class MainScreen
extends JFrame {
    MainPanel mainPanel;

    public MainScreen() {
        this.setSize(800, 600);
        this.mainPanel = new MainPanel();
        this.add(this.mainPanel);
    }

    public void initSelection() {
        this.mainPanel.initSelection();
    }
}
