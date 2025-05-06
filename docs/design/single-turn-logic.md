This file should contain the rough algorithm for a single turn of game.

### General Workflow
0. Called from gameController...
1. Inform player X that it is their turn
2. Display player hand
3. While turn not over ask player for action
   1. play card - check if viable, remove card(s), and call corresponding CardController
   2. get card info - call CardController info method?
   3. draw card (end turn) - draw card form deck, check if exploding/imploding kitten & handle, or add to hand
4. End turn and return to controller

### Turn Controller Class
#### Functions
 - Constructor()
 - HandleInput(): void
   - prompts user for input / action (e.g. play card, draw card, get info for card)
   - call corresponding helper method
 

 - playCard(Card? enum?): void
   - calls corresponding CardController action() method.
   - removes card from hand
   - calls CardController afterPlay() method to either discard or reinsert card
   - return


 - getCardInfo(Card? enum?): void
   - Calls corresponding CardController getInfo() method.
   - return

 
 - endPlayerTurn(): void
   - call deck.drawCard()?
   - check card type/enum
     - if exploding/imploding kitten, check hand and call corresponding CardController action()
     - if inert, add to hand
   - return / end turn
   

 - skipPlayerTurn(): void
   - ends player turn without drawing card
   - used for skip and attack cards
 

 - ???

#### Questions
 - Will we have 1 turn controller and pass in the player object, or will we have n total turn controllers i.e. 1 for each player?