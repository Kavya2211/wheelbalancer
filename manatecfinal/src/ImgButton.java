
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

class ImgButton
extends KeyAdapter
implements MouseListener {
    static Robot robot = null;
    Image defaultImage = null;
    Image hoverImage = null;
    JButton button = null;
    ImgButton rightButton = null;
    ImgButton leftButton = null;

    public ImgButton(Image paramImage1, Image paramImage2, JButton paramJButton, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String toolTipText) {
        this.defaultImage = paramImage1;
        this.hoverImage = paramImage2;
        this.button = paramJButton;
        this.button.setIcon(new ImageIcon(this.defaultImage));
        this.button.setRolloverIcon(new ImageIcon(this.hoverImage));
        this.button.setBorder(BorderFactory.createEmptyBorder());
        this.button.setContentAreaFilled(false);
        this.button.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        this.button.addKeyListener(this);
        this.button.addMouseListener(this);
        this.button.setToolTipText(toolTipText);
    }

    public static void initRobot() {
        try {
            robot = new Robot();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Robot initialize failed");
        }
    }

    public void addRightImgButton(ImgButton paramImgButton) {
        this.rightButton = paramImgButton;
    }

    public void addLeftImgButton(ImgButton paramImgButton) {
        this.leftButton = paramImgButton;
    }

    public void select() {
        robot.mouseMove((int)this.button.getLocationOnScreen().getX() + 60, (int)this.button.getLocationOnScreen().getY() + 90);
    }

    public void requestFocus() {
        this.button.requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getKeyCode() == 39 && this.rightButton != null) {
            this.rightButton.requestFocus();
            this.rightButton.select();
        } else if (paramKeyEvent.getKeyCode() == 37 && this.leftButton != null) {
            this.leftButton.requestFocus();
            this.leftButton.select();
        } else if (paramKeyEvent.getKeyCode() == 10) {
            this.button.doClick();
        }
    }

    @Override
    public void mousePressed(MouseEvent paramMouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent paramMouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent paramMouseEvent) {
        this.requestFocus();
        this.select();
    }

    @Override
    public void mouseExited(MouseEvent paramMouseEvent) {
    }

    @Override
    public void mouseClicked(MouseEvent paramMouseEvent) {
    }
}

