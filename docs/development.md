# Development Log

The development log captures key moments in your application development:

- **Design ideas / notes** for features, UI, etc.
- **Key features** completed and working
- **Interesting bugs** and how you overcame them
- **Significant changes** to your design
- Etc.

---

## Date: 25/3/2025

Finished making the main function, added all of the necessary vars and vals for the app function, and then also created a list for the maze which is the layout of the maze and the 0's are a space, and the 1's are a wall, also has the var for the seconds for the timer which starts at 0 and runs when the program opens.

 <img width="717" alt="Screenshot 2025-04-01 at 9 21 18 AM" src="https://github.com/user-attachments/assets/08596699-7b12-43ad-a561-406e8ecee7d5" />


---

## Date: 28/3/2025
added all of the necessary functions to allow the user to play the game without issues, added the isWalkable function which checks the Y and X of the player as a int to see if the next move the player makes is a wall or a free space, as its a boolean the player is either able to walk or not able to walk, then added the move player function which move the Players X and Y by one in the desired direction they want to go. It also checks for when the Player X and Y aligns with the exit X and Y, if it returns true then the game won function runs and shows a message that states, "You finished the maze in $seconds seconds." it shows the seconds it took and congratulates you on finishing the maze.

<img width="681" alt="Screenshot 2025-04-01 at 9 10 30 AM" src="https://github.com/user-attachments/assets/933b5fec-bdb2-4558-b12e-0805de19ba5c" />

---

## Date: 28/3/2025

added of the private lateinit var's for the buttons for the maze game in the mainWindow class, and also added all of the buttons to the control panel using the  controlPanel.add() command, then added all of the code for the buttons and made sure they stay at the bottom of the window by using the  add(controlPanel, BorderLayout.SOUTH) command.

<img width="514" alt="Screenshot 2025-04-01 at 9 07 21 AM" src="https://github.com/user-attachments/assets/b23fe73e-de9c-4f0f-88a1-9556fa0bd520" />
<img width="373" alt="Screenshot 2025-04-01 at 9 07 29 AM" src="https://github.com/user-attachments/assets/52dbd55a-4c3e-46e7-8fad-8f3c0adab11a" />

---

## Date: 31/3/2025

added the function to update the view of the player every time the player makes a action (X and Y changes). Made the two for loops that constanly check the X and Y of the mazeHeight and MazeWidth. Then the if statement checks the X and Y of the player are colours it red. Also colors the finsih blue and then paints the walls (1) black and the path (0) white. cellPanel is the panel for the maze that displays everything and the dimensions are 50 for height and 50 for width. then  mazePanel.revalidate() updates the view for the maze and the mazePanel.repaint() repaints the maze. then the last function takes care of the movement. I have 5 buttons 4 of them are for movement and the last is for the instructions, it checks for actions and when the buttons are clicked the when runs and moves the player to the position and then updates the view. the last button the instructions button uses a showMessageDialog to show a message in a mini pop up the message states, "use the buttons provided to complete the maze, get to the blue block to finish.". the "this" is used to to specify the parent component which in this case is the showMessageDialog.


<img width="747" alt="Screenshot 2025-04-01 at 9 24 15 AM" src="https://github.com/user-attachments/assets/c4b9e6b3-000c-4efd-a6b2-e522efb551a5" />


---

## Date: 31/3/2025

added a timer using a private function that tracks how long it takes for the player to finish the maze and then tells the elapsed seconds when the player has completed the maze (reached the finish).

<img width="364" alt="Screenshot 2025-04-08 at 9 03 27 AM" src="https://github.com/user-attachments/assets/03606939-b5ba-4d33-a713-5c426476999a" />
<img width="402" alt="Screenshot 2025-04-08 at 9 03 21 AM" src="https://github.com/user-attachments/assets/f243a7ad-9d84-442c-9765-b6b01a25e507" />
<img width="262" alt="Screenshot 2025-04-08 at 9 04 24 AM" src="httconsps://github.com/user-attachments/assets/2c0a9b76-eac9-4e53-8f6c-e30c2c59f729" />




---
## Date: 31/3/2025

added a Position label, using a JLabel, that is displayed at the top of the app. Using the BorderLayout.NORTH for the headerPanel allows for both the timer and the current position displayed in X and Y coordinates to be positioned correctly. I made a headerpanel using val so it isnt changable and it makes sure that the timer is on the left and the current position is on the right.

<img width="553" alt="Screenshot 2025-04-08 at 9 06 07 AM" src="https://github.com/user-attachments/assets/becb0789-07d8-445c-a675-1bdd68c0c812" />
<img width="419" alt="Screenshot 2025-04-08 at 9 06 16 AM" src="https://github.com/user-attachments/assets/c5fe154b-0a1e-4e64-a44b-79acc68760f6" />
<img width="621" alt="Screenshot 2025-04-08 at 9 07 03 AM" src="https://github.com/user-attachments/assets/97e7d702-b5d4-4acc-a770-f706bd612acb" />




---


