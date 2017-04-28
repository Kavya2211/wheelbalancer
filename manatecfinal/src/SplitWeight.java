
import java.awt.Component;
import javax.swing.JFrame;

class SplitWeight
extends JFrame {
    SplitWeightPanel splitWeightPanel;

    public SplitWeight() {
        this.setSize(800, 600);
        this.splitWeightPanel = new SplitWeightPanel();
        this.add(this.splitWeightPanel);
    }

    public void initSelection() {
        this.splitWeightPanel.initSelection();
    }
}

