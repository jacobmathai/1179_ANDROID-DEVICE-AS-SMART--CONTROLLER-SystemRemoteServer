/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemremoteserver.network;

import java.io.*;
import java.net.*;
import systemremoteserver.util.SystemHandler;

public class Server extends Thread {

    SystemHandler sh=new SystemHandler();
    public void run() {
        try {
            ServerSocket ser = new ServerSocket(1234);
            System.out.println("Server Waiting");
            while (true) {
                Socket soc = ser.accept();
                System.out.println(soc);
                new Child(soc).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class Child extends Thread {

        Socket csoc = null;

        public Child(Socket s) {

            csoc = s;
        }

        public void run() {

            try {
                PrintStream pr = new PrintStream(csoc.getOutputStream());
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(csoc.getInputStream()));

                while(true){
                    String msg=br.readLine();
                    if(msg.startsWith("mouse")){
                        System.out.println(msg);
                        String[] st=msg.split(":");
                        sh.mouseMove(Integer.parseInt(st[1]), Integer.parseInt(st[2]));
                        pr.println("ok");
                    }
                    else if(msg.startsWith("keyboard")){
                        System.out.println(msg);
                        String[] st=msg.split(":");
                        if(st[1].equals("shift")){
                            sh.keyShiftPress(sh.alphabets[Integer.parseInt(st[2])]);
                        }else if(st[1].equals("caps")){
                            sh.keyCapsPress(sh.alphabets[Integer.parseInt(st[2])]);
                        }else{
                            sh.keyPress(sh.alphabets[Integer.parseInt(st[1])]);
                        }
                        
                        pr.println("ok");
                    }
                    else if(msg.startsWith("numpad")){
                        System.out.println(msg);
                        pr.println("ok");
                    }
                    else if(msg.startsWith("arrow")){
                        System.out.println(msg);
                        if(msg.endsWith("left"))
                            sh.leftArrow();
                        if(msg.endsWith("right"))
                            sh.rightArrow();
                        if(msg.endsWith("up"))
                            sh.upArrow();
                        if(msg.endsWith("down"))
                            sh.downArrow();
                        
                        pr.println("ok");
                    }
                    else if(msg.startsWith("mclick")){
                        System.out.println(msg);
                        if(msg.endsWith("left"))
                            sh.leftMouseClick();
                        if(msg.endsWith("right"))
                            sh.rightMouseClick();
                        
                        pr.println("ok");
                    }

                    if(msg==null)break;
                    if(msg.equals("break"))break;
                }
                br.close();
                pr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new Server().start();
    }

}
