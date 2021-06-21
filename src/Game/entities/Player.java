package Game.entities;

import Game.world.TileMap;
import Game.input.MouseInput;
import Game.input.keyinput;
import Game.rendering.textures.Animation;
import Game.rendering.textures.Texture;


import java.awt.event.KeyEvent;


public class Player extends Mob {

    public int selectedGun;
    private int munitonGun1;
    private int munitonGun2;


    /**
     * calls Mob
     */
    public Player(double x, double y, TileMap tileMap){
        super(new Texture("bens")
                , x, y, tileMap,
                    new Animation(5,
                        new Texture("bens"), new Texture("bensruns1"), new Texture("bensruns2"), new Texture("bensruns3"), new Texture("Benleft"),
                            new Texture("Benrunsleft1"),new Texture("benrunsleft2"),new Texture("Benrunsleft3")));

        selectedGun = 1;
        munitonGun1 = 10000;
        munitonGun2 = 40;

    }

    @Override

    /**
     * decides what happend if a key is pressed
     */
    public void tick() {


        if(keyinput.isDown(KeyEvent.VK_UP)){
           jump(11);
        }
        if( keyinput.isDown(KeyEvent.VK_DOWN) ){
            dy = +10;
        }

        if(keyinput.wasReleased(KeyEvent.VK_UP) || keyinput.wasReleased(KeyEvent.VK_DOWN )) {
            dy = 0;
        }


        if(keyinput.isDown(KeyEvent.VK_LEFT)){
            dx = -2.1;

        }
        if( keyinput.isDown(KeyEvent.VK_RIGHT)){
            dx = +2.1;


        }

        if(keyinput.wasReleased(KeyEvent.VK_RIGHT) || keyinput.wasReleased(KeyEvent.VK_LEFT )) {
            dx = 0;
        }

        if(keyinput.wasReleased(KeyEvent.VK_1)) {
            selectedGun = 1;
        }

        if(keyinput.wasReleased(KeyEvent.VK_2)) {
            selectedGun = 2;
        }


        if(MouseInput.wasPressed(1) || keyinput.wasReleased(KeyEvent.VK_SPACE)){
            if (selectedGun == 1 && munitonGun1 > 0) {
                if (side.equals("left")) {
                    new Bullet(new Texture("Bullet"),(int) x, (int) y, tileMap, 2.0, "left",x,y);
                } else new Bullet(new Texture("Bullet"),(int) x + 32, (int) y, tileMap, 2.0, "right",x, y);
                munitonGun1--;
            }

            if (selectedGun == 2 && munitonGun2 > 0) {
                if (side.equals("left")) {
                    new Bullet(new Texture("Bullet1"), (int) x, (int) y, tileMap, 5.0, "left", x, y);
                } else new Bullet(new Texture("Bullet1"),(int) x + 32, (int) y, tileMap, 5.0, "right", x, y);

                munitonGun2--;
            }
        }
        



        super.tick();

    }
}
