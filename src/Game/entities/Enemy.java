package Game.entities;

import Game.world.TileMap;
import Game.rendering.textures.Animation;
import Game.rendering.textures.Texture;

import java.awt.*;

public class Enemy extends Entity {

    protected double livepoints;
    private double dx, dy;

    public Enemy(double x, double y, TileMap tileMap){
        super(new Texture("neb"), x,y,tileMap);

        this.livepoints = 100;
    }

    public void setposition(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setLivepoints(double livepoints){
        this.livepoints = livepoints;
    }

    @Override
    public void tick() {
        if(true){
            setposition(x+0.1, y);
        }

    }

    public void render(Graphics2D g, int offsetX, int offsetY) {
            super.render(g, offsetX, offsetY);
    }

}
