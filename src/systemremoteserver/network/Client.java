/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemremoteserver.network;

import java.io.*;
import java.net.*;

public class Client {

    Socket soc = null;
    PrintStream pr = null;
    BufferedReader br = null;

    public Client(String ip, int port) {
        try {
            soc = new Socket(ip, port);
            System.out.println("Server Found" + soc);
            pr = new PrintStream(soc.getOutputStream());
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        } catch (Exception e) {
            System.out.println("Client Copnstructor Err>>" + e);
        }
    }

    public String sendMouse(String msg) {
        String reply = null;
        try {
            pr.println("mouse:" + msg);
            reply = br.readLine();
        } catch (Exception e) {
            System.out.println("Send Mouse Err>>" + e);
        }
        return reply;
    }
    public String sendMouseClick(String msg) {
        String reply = null;
        try {
            pr.println("mclick:" + msg);
            reply = br.readLine();
        } catch (Exception e) {
            System.out.println("Send Mouse Click Err>>" + e);
        }
        return reply;
    }
    public String sendNumpad(String msg) {
        String reply = null;
        try {
            pr.println("numpad:" + msg);
            reply = br.readLine();
        } catch (Exception e) {
            System.out.println("Send Numpad Err>>" + e);
        }
        return reply;
    }

    public String sendKeyboard(String msg) {
        String reply = null;
        try {
            pr.println("keyboard:" + msg);
            reply = br.readLine();
        } catch (Exception e) {
            System.out.println("Send Keyboard Err>>" + e);
        }
        return reply;
    }

    public String sendArrow(String msg) {
        String reply = null;
        try {
            pr.println("arrow:" + msg);
            reply = br.readLine();
        } catch (Exception e) {
            System.out.println("Send Arrow Err>>" + e);
        }
        return reply;
    }

    public void sendExit() {

        try {
            pr.println("break");

        } catch (Exception e) {
            System.out.println("Send Arrow Err>>" + e);
        }

    }
    
    public static void main(String[] args) {
        Client c = new  Client("localhost", 1234);
        c.sendMouse("110:220");
        c.sendMouse("-110:220");
        c.sendMouse("110:-220");
        c.sendMouse("-110:-220");
        c.sendMouse("110:220");
        
        c.sendExit();
    }
}
