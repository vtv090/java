package Game.world;

import Game.rendering.textures.Texture;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class Tile {
    private static final Texture terrain = new Texture("terrain");
    private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
    protected Texture sprite;
    protected boolean solid;
    protected int id;

    public static final Tile tile1 = new Tile(0xFFFFFFFF, new Texture(terrain, 1,1, 32));
    public static final Tile tile2 = new Tile(0xFFFF0000, new Texture(terrain, 2,1, 32));

    private Tile(int id, Texture sprite){

        this.id = id;
        this.sprite = sprite;
        solid = true;
        tileMap.put(id, this);

    }

    public void render(Graphics2D g, int x, int y){
        sprite.render(g,x,y);

    }

    public boolean isSolid() {
        return solid;
    }




    public static Tile getFromID(int id){
        return tileMap.get(id);
    }

}
