package Game.entities;

import Game.world.TileMap;


import Game.rendering.textures.Texture;

import java.awt.*;
import java.awt.event.KeyEvent;

import Game.input.MouseInput;


public class Bullet extends Entity {


    /**
     * calls Mob
     */
    public double dx ,dy ;
    private boolean left;
    public double damage;
    private String side;
    public int Playerx, Playery;
    double VektorX;
    double VektorY;



    public Bullet(Texture texture, double x, double y, TileMap tileMap, double damage, String side, double Playerx, double Playery){
        super(texture, x, y, tileMap);
        this.damage = damage;
        this.side = side;
        this.Playerx = (int)Playerx;
        this.Playery = (int)Playery;
        VektorX = 320 - MouseInput.getX();
        VektorY = 240 - MouseInput.getY();
    }

    public void tick() {
            dy =- getVektorX(VektorX, VektorY)*3;
            dx =- getVektorY(VektorX, VektorY)*3;

        move();

    }

    public double getVektorY(double VektorX, double VektorY){
        double VektorLength;

        VektorLength = Math.sqrt((VektorX * VektorX) + (VektorY * VektorY));
        return (1/VektorLength) * VektorX;


    }

    public double getVektorX(double VektorX, double VektorY){
        double VektorLength;
        VektorLength = Math.sqrt((VektorX * VektorX) + (VektorY * VektorY));
        return (1/VektorLength) * VektorY;

    }



    public void render(Graphics2D g, int offsetX, int offsetY) {

            super.render(g, offsetX + (int)dx, offsetY + (int)dy + 10);

    }




    public void move(){
        boolean horiz = tileMap.getBulletCollision(texture.getWidth(), x, y, x+dx, y, false);
        boolean vert = tileMap.getBulletCollision(texture.getWidth(), x, y, x, y + dy, true);
        if(!horiz){
            x += dx;
            y += dy;
        }
        if(!vert){
            y += dy;
            x += dx;
        }
        if(horiz){
            tileMap.removeEntity(this);
        }

        if(vert){
            tileMap.removeEntity(this);
        }
    }




}
