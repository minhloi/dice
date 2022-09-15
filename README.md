## Fighting Dice - Team 38 Game Project

##### Team members:
- Brett Bauman (bbauman1)
- Daniel Enriquez (denriquez12 and denriquez)
- Minh Loi (minhloi)  
- Thien Duc Phung (thphung)
- Tanner Siffren  (tanner-siffren)

### Deliverable 3 (Final)

#### 1. Executable: 
The game works completely in GUI. You can play the game with two players and view rankings. You can also pause the game by pressing ESC, restart and quit the game while playing. Note that this game only uses keyboard to navigate and data is only saved after each match. The executable file is Dice/FightingDice.jar

#### 2. How to compile: 
  - Clone the Github repo in Eclipse.
  - Import the project in Eclipse. 
  - Compile the GameEngine.java in sr/main package. 

#### 3. Unit tests:
All test cases are in [Dice/unit-test folder](https://github.com/minhloi/dice/tree/master/Dice/unit-test).

#### 4. Licenses and Credits: 
  - In-game background by bvigec: http://bvigec.deviantart.com/art/Level-background-for-a-mobile-game-355249548
  - All character sprites by gameart2d.com: http://www.gameart2d.com/freebies.html
  - Font used for titles is Sniglet: https://www.fontsquirrel.com/fonts/sniglet 
  - All other assets are created by us.  

***

### Deliverable 2

#### 1. Working code:
The game is working in text form (console). You can select menu, play games and view ranks of other players in console. All game data will be stored as binary data in database.txt file.  
###### How to compile:
- Clone the Github repo in Eclipse.
- Import the project in Eclipse.
- Compile the GameEngine.java in legacy-code/main package.

#### 2. Unit test:
All test cases are in [Dice/unit-test folder](https://github.com/minhloi/dice/tree/master/Dice/unit-test).

#### 3. Change log:
- Use case diagram now includes a Database actor.
- Product backlog is grouped into epics with priority, complexity-point and dependencies. 

***  

### Deliverable 1

#### 1. About this game:
This game is a version of turn-based game with 2 players. At each turn, each player select their strategic move, such as attack or block, before each roll their dice to determine whether their move will go through. Hence, players are required to use their tactics and luck to be able to win this game. 

#### 2. Rules:
- 1.  Each player needs to select either attack, block or special attack before every roll.
- 2.  Both players will roll their dice every turn. Whoever rolls a higer number will get an additional roll to roll for damage.
- 3.  If both players rolled same value both get to roll again.
- 4.  If the winner of the roll chooses attack then the loser of the roll takes full damage unless the loser chooses block in which case they take half of the damage rolled.
- 5.  If the winner of the roll chooses block then the loser of the roll takes half damage unless the loser chooses block in which case they take a quarter of the damage rolled.
- 6.  If the winner of the roll chooses special attack then the loser of the roll takes double the damage unless the loser chooses block in which case they take normal attack damage.
- 7.  Once a player chooses block, it goes on cooldown and is not usable for only the next turn.
- 8.  Every game each player is allowed to use a maximum of 2 special abilites.
- 9.  When a players health drops to 0 or below he loses the game and the other player wins.

#### 3. Documents:
All documents are located in Dice/document folder or see below:  
###### User stories: https://github.com/minhloi/dice/blob/master/Dice/document/user_stories.md  
###### Backlog: https://github.com/minhloi/dice/blob/master/Dice/document/backlog.md
###### Use case diagram:  
  
![alt text](https://raw.githubusercontent.com/minhloi/dice/master/Dice/document/use-case-diagram-2.png "Use case diagram")

