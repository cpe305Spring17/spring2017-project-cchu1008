package main.helper;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.StateBasedGame;

import main.driver.GameDriver;
import main.driver.Menu;
import main.driver.Play;
import main.driver.Setup;


public class PlayNextStateListener extends NextStateButtonListener {

  public PlayNextStateListener(int id, StateBasedGame game) {
    super(id, game);
  }
  
  @Override
  public void componentActivated(AbstractComponent source) {
    ((GameDriver)this.game).createState(((Button)source).cont, Play.ID);
    super.componentActivated(source);
    if(Menu.type){
      Setup.makeHumanVCompPlayers(this.game, ((Button)source).cont);
    }
    else{
      Setup.makeHumanVHumanPlayers(this.game);
    }
  }

}