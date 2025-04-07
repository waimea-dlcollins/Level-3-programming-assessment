<img width="747" alt="Screenshot 2025-04-08 at 9 45 31 AM" src="https://github.com/user-attachments/assets/90b8d1b1-b66b-4781-8cc6-be3e7a4c48d5" /># Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Player X and Player Y

Player X and Player Y start positions, when starting the program for the maze game.

## Starting location

the test data for this is an integer in this case 0, 0

## Expected Test Result

my expected test result is that the location of 0, 0 which is in the top left of the maze will work and when the application is opened the player will spawn there and will start to when the game starts.

<img width="218" alt="Screenshot 2025-03-31 at 2 36 23 PM" src="https://github.com/user-attachments/assets/f92e96ff-094c-414b-b30f-3b45d1eca4e2" />

the player "block" spawned in the top left of the whole map which is what i wanted so the testing passed.

---

## Moveplayer X and Y

the X and Y need to be changed to move the player around the maze, they need to be checked as well to make sure that the player moves in the right direction when the buttons are clicked.

## The X and Y (boolean)

the test data is a boolean and i want to make sure that every time the player clicks a button that they move in the right direction that the player clicked, as its a boolean the function can either move the player (true) or not be able to move the player (false), the isWalkable function also is a boolean and helps with this.

### Test Result

<img width="287" alt="Screenshot 2025-04-01 at 9 49 27 AM" src="https://github.com/user-attachments/assets/49196111-d601-44cf-ac31-b663f38a0266" />
<img width="411" alt="Screenshot 2025-04-01 at 9 49 31 AM" src="https://github.com/user-attachments/assets/96eec593-b746-4dcd-aff4-b386cfda5f11" />



The player (red block) moves when i click one of the buttons this shows that the movePlayer function and isWalkable function and work to the level that they need to.


---


## Show message when player reaches finish

The private gameWon() function that i have made needs to be constanly checking for when the players X and Y coordinates match up with the X and Y coordinates for the finish block. This allows for the message to show up when the player reaches the finish block.

## The X and Y 

the test data is when the X and Y coordinates of the player match up with the X and Y coordinates of the finish line the gameWon() function should detect this and display the winning message.

## Test Result

<img width="609" alt="Screenshot 2025-04-08 at 9 15 56 AM" src="https://github.com/user-attachments/assets/c6eb40da-cf55-46df-8190-063bc8796d0c" />



When the player reaches the end block of the maze (finish line) the gameWon() function detects this and displays the message shown in the screenshoot above to congratulate the player on compeleting the maze.


---

## Show message introduction message when player clicks button

The private gameWon() function that i have made needs to be constanly checking for when the players X and Y coordinates match up with the X and Y coordinates for the finish block. This allows for the message to show up when the player reaches the finish block.

## If action is performed (boolean)

the test data is when the fun actionPerformed identifies that the player has clicked the introduction button to ask for help and instructions on what to do.

## Test Result

<img width="104" alt="Screenshot 2025-04-08 at 9 45 28 AM" src="https://github.com/user-attachments/assets/d597a1a3-4e6d-415b-bfef-e68eddd07dcb" />
<img width="747" alt="Screenshot 2025-04-08 at 9 45 31 AM" src="https://github.com/user-attachments/assets/2e132e00-eb00-4cf7-bfc3-e463e3d0bcdc" />

when the button shown in the screenshot above is clicked the message is shown that allows the user to understand the basics of the game which which will allow them to play the game effectively.



---

