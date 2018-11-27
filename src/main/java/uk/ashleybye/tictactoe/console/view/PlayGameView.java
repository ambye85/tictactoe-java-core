package uk.ashleybye.tictactoe.console.view;

import uk.ashleybye.tictactoe.core.PlayerFactory;
import uk.ashleybye.tictactoe.core.TicTacToeRunner;
import uk.ashleybye.tictactoe.core.ClientInterface;
import uk.ashleybye.tictactoe.console.gameClient.ConsoleGameConfiguration;

public class PlayGameView extends View {

  private static final String RETURN_TO_MAIN_MENU = "Press ENTER to return to the main view";
  private final PlayerFactory playerFactory;
  private final ClientInterface clientInterface;

  public PlayGameView(View previousMenu, ConsoleGameConfiguration configuration, PlayerFactory playerFactory,
      ClientInterface clientInterface) {
    super(previousMenu, configuration);
    this.playerFactory = playerFactory;
    this.clientInterface = clientInterface;
  }

  @Override
  public String launch() {
    playGame();
    return "\n\n" + RETURN_TO_MAIN_MENU;
  }

  private void playGame() {
    TicTacToeRunner runner = TicTacToeRunner.create(playerFactory, configuration, clientInterface);
    runner.play();
  }

  @Override
  public View handleInput(String input) {
    return previousMenu;
  }
}
