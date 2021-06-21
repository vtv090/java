package Game.states;

import java.awt.*;

public interface State {

    public void init();
    public void enter();
    public void tick(StateManager stateManager);
    public void render(Graphics2D g);
    public void exit ();
    public String getName();
}
