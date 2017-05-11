package main.helper;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;

public abstract class NextStateButtonListener implements ComponentListener {
  public boolean on = true;
  public int id;
  public StateBasedGame game;
  
  public NextStateButtonListener(int id, StateBasedGame game){
    this.id = id;
    this.game = game;
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    this.on = false;
    source.setAcceptingInput(this.on);
    this.game.enterState(this.id);
  }

}