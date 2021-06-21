package Game.world;
import Game.entities.*;
import Game.rendering.*;
import Game.rendering.textures.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TileMap {

    private static final int TILE_SIZE = 32;
    private static final int TILE_SIZE_BITS = 5; //2^n = TILE_SIZE

    private int width, height;
    private Tile[] tiles;

    private Player player;
    private ParallaxEngine parallaxEngine;

    private ArrayList<Entity> entities;





    public TileMap(String name){
        entities = new ArrayList<Entity>();
        ParallaxLayer back = new ParallaxLayer(new Texture("background1"), (int)(16 * 0.25 * -0.15));
        ParallaxLayer mid = new ParallaxLayer(new Texture("Background2"), (int)(16 * 0.25 * -0.25));
        ParallaxLayer front = new ParallaxLayer(new Texture("Background3"), (int)(16 * 0.25 * -0.55));
        this.parallaxEngine = new ParallaxEngine(back, mid, front);
        load(name);

    }

    public static int pixelsToTiles(int pixels){
        return pixels >> TILE_SIZE_BITS; // pixels / TILE_SIZE
    }

    public static int tilesToPixel (int tiles){
        return tiles << TILE_SIZE_BITS;
    }

    public void tick(){
        if(player.isMovingLeft()){
            parallaxEngine.setLeft();
        }
        else if (player.isMovingRight()){
            parallaxEngine.setRight();
        }
        if(player.isMoving()){
            parallaxEngine.move();
        }

        for(int i = 0; i < entities.size(); i++){
            entities.get(i).tick();
        }

            player.tick();


    }

    public void render(Graphics2D g, int screenWidth, int screenHight){
        int mapWidth = tilesToPixel(width);
        int mapHeight = tilesToPixel(height);
        int offsetX = (int) (screenWidth / 2 - player.getX() - TILE_SIZE);
        int offsetY = (int) (screenHight / 2 - player.getY() - TILE_SIZE);
        offsetX = Math.min(offsetX, 0);
        offsetX = Math.max(offsetX, screenWidth - mapWidth);
        offsetY = Math.min(offsetY, 0);
        offsetY = Math.max(offsetY, screenHight - mapHeight);

        int firstX = pixelsToTiles(-offsetX);
        int lastX = firstX + pixelsToTiles(screenWidth) + 1;

        int firstY = pixelsToTiles(-offsetY);
        int lastY = firstY + pixelsToTiles(screenHight) + 1;

        parallaxEngine.render(g);


        for(int y = firstY; y <= lastY; y++){
            for(int x = firstX; x <= lastX; x++){
                Tile t = getTile(x,y);
                if (t != null){
                    t.render(g, tilesToPixel(x) + offsetX,tilesToPixel(y)+ offsetY );
                }
            }
        }

        for(int i = 0; i < entities.size(); i++){
            entities.get(i).render(g, offsetX, offsetY);
        }

        player.render(g,offsetX, offsetY);


    }

    public boolean getTileCollision (int size, double oldX, double oldY, double newX, double newY, boolean vert){
        double fromX = Math.min(oldX, newX);
        double fromY = Math.min(oldY, newY);
        double toX = Math.max(oldX, newX);
        double toY = Math.max(oldY, newY);

        int fromTileX = pixelsToTiles((int)fromX);
        int fromTileY = pixelsToTiles((int)fromY);
        int toTileX = pixelsToTiles((int) toX + size - 1);
        int toTileY = pixelsToTiles((int) toY + size - 1);

        for(int y = fromTileY; y <= toTileY; y++){
            for(int x = fromTileX; x <= toTileX; x++){
                if(x < 0 || x >= width || (getTile(x,y) != null && getTile(x,y).isSolid())){
                    if(vert){
                        if(player.isFalling()){
                            player.setY(tilesToPixel(y) - size);
                            player.setCanJump(true);
                        }
                        else{
                            player.setY(tilesToPixel(y + 1));
                        }
                        player.setVelocityY(0);
                    }
                    return true;
                }
            }
        }

        return false;

    }

    public boolean getBulletCollision (int size, double oldX, double oldY, double newX, double newY, boolean vert){
        double fromX = Math.min(oldX, newX);
        double fromY = Math.min(oldY, newY);
        double toX = Math.max(oldX, newX);
        double toY = Math.max(oldY, newY);

        int fromTileX = pixelsToTiles((int)fromX);
        int fromTileY = pixelsToTiles((int)fromY);
        int toTileX = pixelsToTiles((int) toX + size - 1);
        int toTileY = pixelsToTiles((int) toY + size - 1);

        for(int y = fromTileY; y <= toTileY; y++){
            for(int x = fromTileX; x <= toTileX; x++){
                if(x < 0 || x >= width || (getTile(x,y) != null && getTile(x,y).isSolid())){
                    return true;
                }
            }
        }

        return false;

    }


    public void setTiles(int x, int y, Tile tile) {
        tiles[x + y * width] = tile;
    }

    public Tile getTile(int x, int y) {
        if(x < 0 || x >= width || y < 0 || y >= height){
            return null;
        }

            return tiles[x + y * width];
    }

    private void load(String name){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./resources/levels/" + name + ".png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.width = image.getWidth();
        this.height = image.getHeight();
        tiles = new Tile[width * height];
        int [] pixels = image.getRGB(0,0,width,height,null,0,width);
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int id = pixels[x + y * width];

                player = new Player(200, 100, this);
                new Enemy(200, 100, this);

                if (Tile.getFromID(id) != null){
                     setTiles(x, y, Tile.getFromID(id));
                }
            }
        }
    }

    public void addEntity(Entity e){
        if(!(e instanceof Player)){
            entities.add(e);
        }
    }



    public void removeEntity(Entity e){
        if(!(e instanceof Player)){
            entities.remove(e);
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Player getPlayer() {
        return player;
    }


}

