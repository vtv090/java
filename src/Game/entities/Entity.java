package Game.entities;


import Game.world.TileMap;
import Game.states.GameState;
import Game.rendering.textures.Texture;
import java.awt.*;


public abstract class Entity {

    protected  double x, y;
    public Texture texture;
    protected TileMap tileMap;

    /**
     * sets the values of the Entity
     */
    public Entity(Texture texture, double x, double y, TileMap tileMap){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.tileMap = tileMap;
        tileMap.addEntity(this);
    }

    protected Entity() {
    }

    public abstract void tick();


    /**
     * calls texture.render
     * @param g graphic witch should rendered
     */
    public void render (Graphics2D g, int offsetX, int offsetY){
        texture.render(g,x + offsetX,y + offsetY);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
