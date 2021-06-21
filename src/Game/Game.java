package Game;

import Game.input.MouseInput;
import Game.input.keyinput;
import Game.states.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
/*
 * @ author: Van Trung Vo
 * @ Version: 1.0
 * */
public class Game extends Canvas implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "Game";
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 4 * 3;


    private boolean running;

    private StateManager stateManager;

    public static Game  INSTANCE;


    public Game(){
        addKeyListener(new keyinput());
        MouseInput mi = new MouseInput();
        addMouseListener(mi);
        addMouseMotionListener(mi);
        stateManager = new StateManager();

        stateManager.addState(new MenuState());
        stateManager.addState(new GameState());
        stateManager.addState(new GameState2());
        stateManager.addState(new LevelChoose());


        INSTANCE = this;
    }

    private void tick(){
    	stateManager.tick();
    }

    /**
     * creates the Window where you have the Animations and the game
     */
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(- 0, - 0);

        g2d.setColor(Color.BLACK);

        g2d.fillRect(0,0,WIDTH, HEIGHT);
        stateManager.render(g2d);

        g.dispose();
        bs.show();
    }

    /**
     * sets running to true
     */
    protected void start(){
        if (running) return;
        running = true;
        new Thread(this, "GameMain-Thread").start();
    }

    /**
     * sets running to false
     */
    public void stop(){
        if(!running) return;
        running = false;
    }

    @Override
    /**
     * runs the animation, game
     */
    public void run() {
        double target = 60.0;
        double nsPerTick = 1000000000.0 / target;
        double unprocessed = 0.0;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int fps = 0;
        int tps = 0;
        boolean canRender = false;


        while (running){
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;

            if(unprocessed >= 1.0){
                tick();
                keyinput.update();
                MouseInput.update();
                unprocessed--;
                tps++;
                canRender = true;
            } else {canRender = false;}

            try {
                Thread.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            if (canRender){
                render();
                fps++;
            }

            if(System.currentTimeMillis() - 1000 > timer){
                timer += 1000;
                fps = 0;
                tps = 0;
            }
        }

        System.exit(0);


    }


}
