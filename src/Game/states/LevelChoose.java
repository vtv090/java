package Game.states;

import Game.Game;
import Game.input.*;
import Game.rendering.ui.Button;
import Game.utils.Fonts;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class LevelChoose implements State {

    private Button[] options; // 0, 1, 2
    private int currentSelection;

    /**
     * creates the wanted Menu (Hardcode)
     */
    @Override
    public void init() {

        options = new Button[3];
        options[0] = new Button("Level 1", 200 + 0 * 80,
                new Font("Arial", Font.PLAIN,32), new Font("Arial", Font.BOLD,48),
                Color.GRAY, Color.WHITE);
        options[1] = new Button("Level 2", 200 + 1 * 80,
                new Font("Arial", Font.PLAIN,32), new Font("Arial", Font.BOLD,48),
                Color.GRAY, Color.WHITE);
        options[2] = new Button("Back", 200 + 2 * 80,
                new Font("Arial", Font.PLAIN,32), new Font("Arial", Font.BOLD,48),
                Color.GRAY, Color.WHITE);


    }

    public void enter(){}

    /**
     * for deciding what you want to do
     * @param stateManager
     */

    public void tick(StateManager stateManager){


        if(keyinput.wasPressed(KeyEvent.VK_UP) || keyinput.wasPressed(KeyEvent.VK_W)){
            currentSelection--;
            if(currentSelection < 0 ){
                currentSelection = options.length - 1;
            }
        }

        if(keyinput.wasPressed(KeyEvent.VK_DOWN) || keyinput.wasPressed(KeyEvent.VK_S)){
            currentSelection++;
            if(currentSelection >= options.length ){
                currentSelection = 0;
            }
        }

        boolean clicked = false;
        for(int i = 0; i < options.length; i++){
            if(options[i].intersects(new Rectangle(MouseInput.getX(),MouseInput.getY(),1,1))){
                currentSelection = i;
                clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
            }
        }

        if(clicked || keyinput.wasPressed(KeyEvent.VK_ENTER)){
            select(stateManager);
        }
    }

    /**
     * Decide what hapened if something get clicked
     * @param stateManager
     */
    private void select(StateManager stateManager){
        switch (currentSelection){
            case 0:
                stateManager.setState("level1");
                break;
            case 1:
                stateManager.setState("level12");
                break;
            case 2:

                stateManager.setState("menu");
                break;

        }
    }

    public void render(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Game.WIDTH, Game.HEIGHT);
        Fonts.drawString(g, new Font("Arial", Font.BOLD, 72), Color.MAGENTA, "NiteFort", 80);

        for(int i = 0; i < options.length; i++){
            if (i == currentSelection){
                options[i].setSelected(true);
            }
            else {
                options[i].setSelected(false);
            }
            options[i].render(g);
        }
    }

    @Override
    public void exit() {

    }

    @Override
    public String getName() {
        return "LevelChoose";
    }
}
