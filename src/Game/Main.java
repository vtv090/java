
package Game;
import Game.rendering.ui.SplashScreenDriver;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * @ author: Van Trung Vo
 * @ Version: 1.0
 * */

public class Main {

    public static void main(String[] args){
        new SplashScreenDriver();
        final Game game = new Game();
        JFrame frame = new JFrame(Game.TITLE);
        frame.add(game);
        frame.setSize(Game.WIDTH,Game.HEIGHT);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.err.println("Exiting Game");
                game.stop();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setAutoRequestFocus(true);
        frame.setVisible(true);
        game.start();
    }
}
