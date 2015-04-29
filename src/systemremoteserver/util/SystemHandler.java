/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemremoteserver.util;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author sarath
 */
public class SystemHandler {

    Robot robot = null;
    Dimension screenSize = null;
    public int alphabets[] = new int[]{
        KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_R, 
        KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U, KeyEvent.VK_I, 
        KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_A, KeyEvent.VK_S, 
        KeyEvent.VK_D, KeyEvent.VK_F, KeyEvent.VK_G, KeyEvent.VK_H, 
        KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_Z, 
        KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_V, KeyEvent.VK_B, 
        KeyEvent.VK_N, KeyEvent.VK_M,KeyEvent.VK_TAB,KeyEvent.VK_SPACE,
        KeyEvent.VK_CONTROL, KeyEvent.VK_ALT
    };

    public SystemHandler() {
        try {
            robot = new Robot();
            screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            System.out.println(screenSize.width + "::" + screenSize.height);
        } catch (Exception e) {
            System.out.println("SystemHandler Err>>" + e);
        }
    }

    public void keyPress(int code) {
        robot.keyPress(code);
        robot.keyRelease(code);
    }

    public void keyCapsPress(int code) {
        //robot.delay(200);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.delay(100);
        robot.keyPress(code);
        robot.delay(100);
        robot.keyRelease(code);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
        
    }
    public void keyShiftPress(int code) {
        //robot.delay(200);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(100);
        robot.keyPress(code);
        robot.delay(100);
        robot.keyRelease(code);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        
    }
    public void atlCtrlDelete() {
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ALT);

    }

    public void leftArrow() {
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_LEFT);

    }

    public void rightArrow() {
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_RIGHT);

    }

    public void upArrow() {
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_UP);

    }

    public void downArrow() {
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_DOWN);

    }

    public void leftMouseClick() {
        robot.delay(200);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);

    }

    public void rightMouseClick() {
        robot.delay(200);
        robot.mousePress(MouseEvent.BUTTON3_MASK);
        robot.mouseRelease(MouseEvent.BUTTON3_MASK);

    }

    public void mouseMove(int x, int y) {

        PointerInfo a = MouseInfo.getPointerInfo();
        java.awt.Point b = a.getLocation();
        int cx = (int) b.getX();
        int cy = (int) b.getY();
        //  robot.delay(200);
        robot.mouseMove(cx + x, cy + y);
    }
}
