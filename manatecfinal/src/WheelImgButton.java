
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class WheelImgButton extends ImgButton {
    Image displayImage = null;
    ImgButton downButton = null;
    ImgButton upButton = null;

    public WheelImgButton(Image paramImage1, Image paramImage2, Image paramImage3, JButton paramJButton, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, String toolTipText) {
        super(paramImage2, paramImage3, paramJButton, paramInt1, paramInt2, paramInt3, paramInt4, toolTipText);
        this.button.setActionCommand(paramString);
        this.displayImage = paramImage1;
    }

    public void addDownImgButton(ImgButton paramImgButton) {
        this.downButton = paramImgButton;
    }

    public void addUpImgButton(ImgButton paramImgButton) {
        this.upButton = paramImgButton;
    }
   
    @Override
    public void keyPressed(KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getKeyCode() == 39 && this.rightButton != null) {
            this.rightButton.requestFocus();
            this.rightButton.select();
        } else if (paramKeyEvent.getKeyCode() == 37 && this.leftButton != null) {
            this.leftButton.requestFocus();
            this.leftButton.select();
        } else if (paramKeyEvent.getKeyCode() == 38 && this.upButton != null) {
            this.upButton.requestFocus();
            this.upButton.select();
        } else if (paramKeyEvent.getKeyCode() == 40 && this.downButton != null) {
            this.downButton.requestFocus();
            this.downButton.select();
        } else if (paramKeyEvent.getKeyCode() == 10) {
            this.button.doClick();
            JOptionPane.showMessageDialog(null, "Wheel with "+this.button.getToolTipText()+ " selected!");
        }
    }
}

