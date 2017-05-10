package main.helper;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.Menu;

public class HumanNextStateListener extends NextStateButtonListener {

  public HumanNextStateListener(int id, StateBasedGame game) {
    super(id, game);
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    super.componentActivated(source);
    Menu.type = false;
  }

}
