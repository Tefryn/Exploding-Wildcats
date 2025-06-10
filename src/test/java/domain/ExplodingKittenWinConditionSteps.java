package domain;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.easymock.EasyMock;
import ui.TurnView;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplodingKittenWinConditionSteps {

	private final IntegrationTestContext context;

	public ExplodingKittenWinConditionSteps(IntegrationTestContext context) {
		this.context = context;
	}

	@Given("only the player who draws last has a defuse card")
	public void only_the_player_who_draws_last_has_a_defuse_card() {
		LinkedList<PlayerTurn> playerTurns = context.gameSetup.getPlayerTurns();

		for (int i = 0; i < playerTurns.size(); i++) {
			if (i == playerTurns.size() - 1) {
				continue;
			}

			Player player = playerTurns.get(i).player;
			player.removeCard(CardType.DEFUSE);
		}
	}

	@When("exploding kittens are drawn by all players without defuse")
	public void exploding_kittens_are_drawn_by_all_players_without_defuse() {
		TurnView turnView = context.gameSetup.getTurnView();
		TurnController turnController = context.gameSetup.getTurnController();
		Deck deck = context.gameSetup.getDeck();
		LinkedList<PlayerTurn> playerTurns = context.gameSetup.getPlayerTurns();

		int numToEliminate = playerTurns.size() - 1;

		// Insert exploding kittens at the top of the deck
		for (int i = 0; i < numToEliminate; i++) {
			deck.insertCardAtIndex(CardType.EXPLODING_KITTEN, 0);
		}

		// Set up EasyMock expectations for each player without a defuse
		EasyMock.reset(turnView);
		for (PlayerTurn pt : playerTurns) {
			Player player = pt.player;
			boolean hasDefuse = player.viewHand().getOrDefault(CardType.DEFUSE, 0) > 0;

			if (!hasDefuse) {
				EasyMock.expect(turnView.promptForInput()).andReturn("draw");
				turnView.displayHand(player);
				EasyMock.expectLastCall();
				turnView.showImplodingIndex(EasyMock.anyInt());
				EasyMock.expectLastCall();
				turnView.showCardDrawn(CardType.EXPLODING_KITTEN);
				EasyMock.expectLastCall();
				EasyMock.expectLastCall();
				turnView.reinsertExplodia();
				EasyMock.expectLastCall();
			}
		}
		EasyMock.replay(turnView);

		// Actually take turns
		for (PlayerTurn pt : new LinkedList<>(playerTurns)) {
			Player player = pt.player;
			boolean hasDefuse = player.viewHand().getOrDefault(CardType.DEFUSE, 0) > 0;

			if (!hasDefuse) {
				turnController.takeTurn(player);
			}
		}
	}

	@Then("one player remains and is declared the winner")
	public void one_player_remains_and_is_declared_the_winner() {
		LinkedList<PlayerTurn> remaining = context.gameSetup.getPlayerTurns();
		assertEquals(1, remaining.size());
	}
}
