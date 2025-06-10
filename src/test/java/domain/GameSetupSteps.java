package domain;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.easymock.EasyMock;
import ui.GameSetup;
import ui.GameView;
import ui.LocaleContext;
import ui.TurnView;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameSetupSteps {

	private final IntegrationTestContext context;
	public GameSetupSteps(IntegrationTestContext context) {
		this.context = context;
	}

	@Given("a new game is started with {int} players")
	public void a_new_game_is_started_with_int_players(Integer numberOfPlayers) {
		LocaleContext.setLocale(Locale.ENGLISH);

		context.view = EasyMock.createMock(GameView.class);
		context.turnView = EasyMock.createMock(TurnView.class);

		context.view.chooseLanguage();
		EasyMock.expect(context.view.chooseNumPlayers()).andReturn(numberOfPlayers);

		EasyMock.replay(context.view);

		context.numPlayers = numberOfPlayers;
		context.gameSetup = new GameSetup(context.view, context.turnView);
		EasyMock.verify(context.view);
	}

	@Then("deck and player hands are correctly initialized")
	public void deck_and_player_hands_are_correctly_initialized() {
		LinkedList<PlayerTurn> playerTurns = context.gameSetup.getPlayerTurns();
		int correctNumExplodingKittens = context.numPlayers - 1;

		for (PlayerTurn pt : playerTurns) {
			int actualHandSize = pt.player.getHandSize();
			int expectedHandSize = GameSetup.HAND_SIZE;
			assertEquals(expectedHandSize, actualHandSize);

			Map<CardType, Integer> playerHand = pt.player.viewHand();

			assertTrue(playerHand.containsKey(CardType.DEFUSE));

			int numExplodingKittens = playerHand.getOrDefault(CardType.EXPLODING_KITTEN, 0);
			correctNumExplodingKittens -= numExplodingKittens;
		}

		correctNumExplodingKittens -= context.gameSetup.getCardCount(CardType.EXPLODING_KITTEN);
		assertEquals(correctNumExplodingKittens, 0);
	}
}
