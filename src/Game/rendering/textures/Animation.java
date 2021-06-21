package Game.rendering.textures;

import java.awt.*;

public class Animation {

    private int count;
    private int index;
    private int speed = 20;
    public Texture currentFrame;
    public Texture[] frames;

    public int lifetime = 0;

    public Animation(int speed, Texture... frames){
        this.speed = speed;
        this.frames = frames;
    }

    private void nextFrameRight(){
        if(index < 1 || index > 3){
            index = 1;
        }
        currentFrame = frames[index++];
    }

    private void nextFrameLeft(){
        if(index < 5 || index > 7){
            index = 5;
        }
        currentFrame = frames[index++];
    }

    public void run(String button){
        count++;
        if(count > speed && button.equals("right")){
            count = 0;
            nextFrameRight();
        }
        if(count > speed && button.equals("left")){
            count = 0;
            nextFrameLeft();
        }
    }

    public void render(Graphics2D g, double x, double y){
        if(currentFrame != null){
            currentFrame.render(g, x, y);
        }
    }
}
