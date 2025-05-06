This file should contain the rough algorithm for the main game loop.

### General Workflow
0. called after GameSetup finished...
1. Create n players and add to some list field
2. Instantiate a normal deck
3. Deal a hand to each player (1 defuse + 6/7 random)
4. Add exploding/imploding kitten cards to deck
5. Randomly choose one character to start
6. Start game loop - iterate until game over
   1. Start player turn - delegate to turnController 
   2. turnController does its thing
   3. returns to GameController
   4. Check how many players are left
      1. if no winning condition, continue
      2. if winning condition, end game
   5. Go to next turn (may be same or next player)
7. End game procedure

### Game Controller Class
#### Functions:
 - Constructor()


 - initiateTurn(): void
   - call turn controller for corresponding player


 - endGame(): void


 - nextTurn(): void
   - goes to next player or continues with same player if they have more turns


 - setNextPlayerTurns(count: int): void
   - adds additional turns to the next player (specifically for the attack card)


 - removePlayer(index: int): void
   - remove player from players
 
#### Fields:
 - Player[] players: circular list/order of players, contains amount of turns left
   - by default each value is 1, and drawing a card will decrement the count
   - once count is 0 move on
   - attack cards will increase the number of player turns