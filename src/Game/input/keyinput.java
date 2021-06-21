package Game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyinput extends KeyAdapter {

    private static final int NUM_KEYS = 256;

    private final static boolean[] keys = new boolean[NUM_KEYS];
    private static final boolean[] lastKeys = new boolean[NUM_KEYS];


    @Override
    /**
     * notice which key is pressed
     */
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    /**
     * notice which key is released
     */
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    public static void update(){
        for(int i = 0; i < NUM_KEYS; i++){
            lastKeys[i] = keys[i];
        }
    }

    /**
     * returns true if the key is pressed
     * @param keyCode which key you want to test
     */
    public static boolean isDown(int keyCode){
        return keys[keyCode];
    }

    /**
     * returns true if the key was pressed last time
     * @param keyCode which key you want to test
     */

    public static boolean wasPressed(int keyCode){
        return isDown(keyCode) && !lastKeys[keyCode];
    }

    /**
     * returns true if the key is released
     * @param keyCode which key you want to test
     */

    public static boolean wasReleased(int keyCode) {
        return !isDown(keyCode) && lastKeys[keyCode];
    }
}
