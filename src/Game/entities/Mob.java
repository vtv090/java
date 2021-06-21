package Game.entities;


import Game.world.TileMap;
import Game.input.keyinput;
import Game.rendering.textures.Animation;
import Game.rendering.textures.Texture;


import java.awt.*;
import java.awt.event.KeyEvent;

public class Mob extends Entity {

    public double dx,dy;
    protected double maxDY;
    protected double gravity;
    protected  boolean falling;
    protected boolean canJump;
    protected boolean moving;
    protected Animation anime;
    protected int counter = 0;
    protected String side = "right";
    public double livepoints;



    /**
     * sets the values of entity
     */

    public Mob (Texture texture, double x, double y, TileMap tileMap, Animation anime){
        super(texture, x, y, tileMap);
        this.anime = anime;
        gravity = 0.5;
        maxDY = 7;
        livepoints = 100;
    }

    public Mob(Texture texture, double x, double y, TileMap tileMap){
        super(texture, x, y, tileMap);
    }

    @Override
    /**
     * calls move and fall method
     */
    public void tick() {
        if(dy > 0){
            falling = true;
        }
        else if(dy < 0){
            falling = false;
        }
        move();
        fall();
        if(dx != 0){
            moving=true;
        }
        else{
            moving =false;
        }
        if(moving){
            if (keyinput.isDown(KeyEvent.VK_LEFT)) {
                side = "left";
                anime.run(side);
            }

            if (keyinput.isDown(KeyEvent.VK_RIGHT)) {
                side = "right";
                anime.run(side);
            }

        }



    }

    @Override
    public void render(Graphics2D g,int offsetX, int offsetY) {

        if(moving){
            anime.render(g, x + offsetX, y + offsetY);
            counter = 100000;
        }
        else if(counter < 10000) {
            super.render(g, offsetX, offsetY);
            counter++;
        }
        else{
            anime.render(g, x + offsetX, y + offsetY);
        }
    }


    /**
     * let the mob move in the right direction
     */

    public void move(){
        boolean horiz = tileMap.getTileCollision(texture.getWidth(), x, y, x+dx, y, false);
        boolean vert = tileMap.getTileCollision(texture.getWidth(), x, y, x, y + dy, true);
        if(!horiz){
            x += dx;
        }
        if(!vert){
            y += dy;
        }

    }



    /**
     * designs the falling after a jump
     */
    protected void fall() {

            dy += gravity;
            if (dy > maxDY) dy = maxDY;
            livepoints = livepoints - 1;



    }

    /**
     * let the mob jump
     * @param jumpHeight how high should he jump?
     */

    protected  void jump (double jumpHeight){
        if(canJump){
            dy -= jumpHeight;
            canJump = false;
        }
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isMovingLeft(){
        return dx < 0;
    }

    public boolean isMovingRight(){
        return dx > 0;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setVelocityY(double dy){
        this.dy = dy;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }
}
