package Game.rendering.ui;

import Game.rendering.textures.Texture;


public class SplashScreenDriver {

    private SplashScreen screen;

    public SplashScreenDriver(){
        screen = new SplashScreen(new Texture("loading"));
        screen.setLocationRelativeTo(null);
        screen.setMaxProgress(1000);
        screen.setVisible(true);

        for (int i = 0; i <= 1000; i++){
            for(int j = 0; j <= 50000; j++){
                String s = "ewf" + (i + j);
            }

            screen.setProgress(i);
        }
        screen.setVisible(false);
    }

}
