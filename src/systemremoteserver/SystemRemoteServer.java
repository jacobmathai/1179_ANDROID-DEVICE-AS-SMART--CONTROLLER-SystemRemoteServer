/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package systemremoteserver;

import java.awt.event.KeyEvent;
import systemremoteserver.util.SystemHandler;

/**
 *
 * @author sarath
 */
public class SystemRemoteServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SystemHandler sh=new SystemHandler();
        sh.atlCtrlDelete();
        
       sh.mouseMove(100,200);
       sh.mouseMove(200,100);
       sh.mouseMove(200,200);
       sh.mouseMove(100,100);
       
       // sh.rightMouseClick();
    }
    
}
