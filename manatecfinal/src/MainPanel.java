
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JPanel;

class MainPanel
extends JPanel {
    Image welcomeScreen = null;
    Image car2 = null;
    Image bus2 = null;
    Image option4 = null;
    Image setting3 = null;
    Image help2 = null;
    Image car2Rollover = null;
    Image bus2Rollover = null;
    Image option4Rollover = null;
    Image setting3Rollover = null;
    Image help2Rollover = null;
    JButton carButton = new JButton();
    JButton busButton = new JButton();
    JButton optionButton = new JButton();
    JButton settingButton = new JButton();
    JButton helpButton = new JButton();
    ImgButton carImgButton = null;
    ImgButton busImgButton = null;
    ImgButton optionImgButton = null;
    ImgButton settingImgButton = null;
    ImgButton helpImgButton = null;
    String directory = "resources/";

    MainPanel() {
        ImgButton.initRobot();
        this.setSize(800, 600);
        this.setLayout(null);
        this.welcomeScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "Welcomescreen_Premium.jpg"));
        this.car2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "car2.png"));
        this.bus2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "bus2.png"));
        this.option4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "option4.png"));
        this.setting3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "setting3.png"));
        this.help2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "help2.png"));
        this.car2Rollover = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "car over.png"));
        this.bus2Rollover = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "bus over.png"));
        this.option4Rollover = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "option over.png"));
        this.setting3Rollover = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "setting over.png"));
        this.help2Rollover = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.directory + "help over.png"));
        this.carImgButton = new ImgButton(this.car2, this.car2Rollover, this.carButton, 70, 440, 134, 135, "car");
        this.busImgButton = new ImgButton(this.bus2, this.bus2Rollover, this.busButton, 204, 440, 134, 135, "bus");
        this.optionImgButton = new ImgButton(this.option4, this.option4Rollover, this.optionButton, 338, 440, 134, 135, "option");
        this.settingImgButton = new ImgButton(this.setting3, this.setting3Rollover, this.settingButton, 472, 440, 134, 135, "setting");
        this.helpImgButton = new ImgButton(this.help2, this.help2Rollover, this.helpButton, 606, 440, 134, 135, "help");
        this.carImgButton.addRightImgButton(this.busImgButton);
        this.busImgButton.addRightImgButton(this.optionImgButton);
        this.optionImgButton.addRightImgButton(this.settingImgButton);
        this.settingImgButton.addRightImgButton(this.helpImgButton);
        this.busImgButton.addLeftImgButton(this.carImgButton);
        this.optionImgButton.addLeftImgButton(this.busImgButton);
        this.settingImgButton.addLeftImgButton(this.optionImgButton);
        this.helpImgButton.addLeftImgButton(this.settingImgButton);
        this.add(this.carImgButton.button);
        this.add(this.busImgButton.button);
        this.add(this.optionImgButton.button);
        this.add(this.settingImgButton.button);
        this.add(this.helpImgButton.button);
        this.carImgButton.button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
            
                SplitWeight localSplitWeight = new SplitWeight();
                localSplitWeight.setVisible(true);
                localSplitWeight.setDefaultCloseOperation(1);
                localSplitWeight.setResizable(false);
                localSplitWeight.initSelection();
            }
        });
        this.carImgButton.requestFocus();
    }

    public void initSelection() {
        this.carImgButton.select();
    }

    @Override
    protected void paintComponent(Graphics paramGraphics) {
        super.paintComponent(paramGraphics);
        paramGraphics.drawImage(this.welcomeScreen, 0, 0, this);
    }

}

