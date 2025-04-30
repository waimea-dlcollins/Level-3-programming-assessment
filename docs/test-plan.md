# Plan for Testing the Program

My test plan will consist of the player x and y starting positions, the x and y when trying to move the player across the map. Showing a message when the user makes it,
to the end of the maze (the finsih block). finally to show the introduction button when the user clicks it so they can understand what is happening and how they can beat the maze,
efficiently and effectively.
Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Player X and Player Y 

 Player X and Player Y start positions, when starting the program for the maze game.

### Starting location

the test data for this is an integer in this case 0, 0 

### Expected Test Result

my expected test result is that the location of 0, 0 which is in the top left of the maze will work and when the application is opened the player will spawn there and will start to when the game starts.

---

 ## Moveplayer X and Y

the X and Y need to be changed to move the player around the maze, they need to be checked as well to make sure that the player moves in the right direction when the buttons are clicked.

## The X and Y (boolean)

the test data is a boolean and i want to make sure that every time the player clicks a button that they move in the right direction that the player clicked, as its a boolean the function can either move the player (true) or not be able to move the player (false), the isWalkable function also is a boolean and helps with this.

### Expected Test Result

I am expecting the iswalkable funtion and the movePlayer function to identify if the player is able to move to the next space, it should either return a true or false, true meaning that the playe can move and the false meaning that the player cant move. The player could also not be able to move from things like there being a wall in the way.

---

## Show message when player reaches finish

The private gameWon() function that i have made needs to be constanly checking for when the players X and Y coordinates match up with the X and Y coordinates for the finish block. This allows for the message to show up when the player reaches the finish block.

## The X and Y 

the test data is when the X and Y coordinates of the player match up with the X and Y coordinates of the finish line the gameWon() function should detect this and display the winning message.

### Expected Test Result

When the player reaches the end block of the maze (finish line) the gameWon() function detects this and displays a message congratulating the player on finsihing the maze successfully.

---

---

## Show message introduction message when player clicks button

The private gameWon() function that i have made needs to be constanly checking for when the players X and Y coordinates match up with the X and Y coordinates for the finish block. This allows for the message to show up when the player reaches the finish block.

## If action is performed (boolean)

the test data is when the fun actionPerformed identifies that the player has clicked the introduction button to ask for help and instructions on what to do.

### Expected Test Result

When the player clicks the introduction button a message should appear showing a few sentences on the basic controls and how to complete the maze.

---
