
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JPanel;

class SplitWeightPanel
extends JPanel {
    Image[] spoke = null;
    Image[] s = null;
    Image[] sover = null;
    Image bgSplitWeight = null;
    JButton[] sButton = null;
    WheelImgButton[] iButtons = null;
    String directory = "resources/";
    Point2D[] point = null;
    int i = 3;
    int imageIndex = 0;

    public SplitWeightPanel() {
        int j;
        this.setSize(800, 600);
        this.setLayout(null);
        this.spoke = new Image[10];
        this.s = new Image[10];
        this.sover = new Image[10];
        this.sButton = new JButton[10];
        this.iButtons = new WheelImgButton[10];
        this.point = new Point2D[10];
        this.point[0] = new Point2D.Double(158.0, 38.0);
        this.point[1] = new Point2D.Double(104.0, 133.0);
        this.point[2] = new Point2D.Double(84.0, 229.0);
        this.point[3] = new Point2D.Double(106.0, 326.0);
        this.point[4] = new Point2D.Double(168.0, 424.0);
        this.point[5] = new Point2D.Double(540.0, 40.0);
        this.point[6] = new Point2D.Double(598.0, 136.0);
        this.point[7] = new Point2D.Double(614.0, 231.0);
        this.point[8] = new Point2D.Double(598.0, 327.0);
        this.point[9] = new Point2D.Double(525.0, 424.0);
        this.initImages(this.spoke, "B spok", ".png");
        this.initImages(this.s, "S", ".png");
        this.initImages(this.sover, "S", " over.png");
        this.bgSplitWeight = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "BG_SPLITWEIGHT.jpg"));
        for (j = 0; j < 10; ++j) {
            this.sButton[j] = new JButton();
            this.iButtons[j] = new WheelImgButton(this.spoke[j], this.s[j], this.sover[j], this.sButton[j], (int)this.point[j].getX(), (int)this.point[j].getY(), 95, 95, "" + j, "Spokes " + (j + 3));
            this.iButtons[j].button.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                    SplitWeightPanel.this.imageIndex = Integer.parseInt(paramAnonymousActionEvent.getActionCommand());
                    SplitWeightPanel.this.repaint();
                }
            });
            this.add(this.iButtons[j].button);
        }
        this.iButtons[0].addDownImgButton(this.iButtons[1]);
        for (j = 1; j < 9; ++j) {
            this.iButtons[j].addDownImgButton(this.iButtons[j + 1]);
            this.iButtons[j].addUpImgButton(this.iButtons[j - 1]);
        }
        this.iButtons[9].addUpImgButton(this.iButtons[8]);
        for (j = 0; j < 10; ++j) {
            if (j < 5) {
                this.iButtons[j].addRightImgButton(this.iButtons[j + 5]);
                continue;
            }
            this.iButtons[j].addLeftImgButton(this.iButtons[j - 5]);
        }
        this.iButtons[0].requestFocus();
    }

    public void initSelection() {
        this.iButtons[0].select();
    }

    @Override
    protected void paintComponent(Graphics paramGraphics) {
        super.paintComponent(paramGraphics);
        paramGraphics.drawImage(this.bgSplitWeight, 0, 0, this);
        paramGraphics.drawImage(this.iButtons[this.imageIndex].displayImage, 244, 119, this);
    }

    void initImages(Image[] paramArrayOfImage, String paramString1, String paramString2) {
        int j = 3;
        for (int k = 0; k < 10; ++k) {
            paramArrayOfImage[k] = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + paramString1 + j + paramString2));
            ++j;
        }
    }

}

