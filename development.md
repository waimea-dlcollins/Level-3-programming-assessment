<img width="726" alt="Screenshot 2025-04-04 at 12 41 39 PM" src="https://github.com/user-attachments/assets/6015fdc2-5c20-4a77-83d7-d60a6510ac0f" /># Development Log

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

![image](https://github.com/user-attachments/assets/1eaf4200-4783-4835-b1a4-0bd26a0bb6e4)

---

## Date: 28/3/2025
added all of the necessary functions to allow the user to play the game without issues, added the isWalkable function which checks the Y and X of the player as a int to see if the next move the player makes is a wall or a free space, as its a boolean the player is either able to walk or not able to walk, then added the move player function which move the Players X and Y by one in the desired direction they want to go. It also checks for when the Player X and Y aligns with the exit X and Y, if it returns true then the game won function runs and shows a message that states, "You finished the maze in $seconds seconds." it shows the seconds it took and congratulates you on finishing the maze.

<img width="681" alt="Screenshot 2025-04-01 at 9 10 30 AM" src="https://github.com/user-attachments/assets/933b5fec-bdb2-4558-b12e-0805de19ba5c" />
<img width="288" alt="Screenshot 2025-04-04 at 12 38 57 PM" src="https://github.com/user-attachments/assets/ef14691c-1a21-4e89-b5c0-0e1123a54775" />
<img width="297" alt="Screenshot 2025-04-04 at 12 39 01 PM" src="https://github.com/user-attachments/assets/1977bd6a-4ec9-45c4-b7f4-cfaee573e1b3" />
<img width="421" alt="Screenshot 2025-04-04 at 12 39 21 PM" src="https://github.com/user-attachments/assets/0ffab6c9-511b-48bf-8ed9-f048f14c08e0" />

---

## Date: 28/3/2025

added of the private lateinit var's for the buttons for the maze game in the mainWindow class, and also added all of the buttons to the control panel using the  controlPanel.add() command, then added all of the code for the buttons and made sure they stay at the bottom of the window by using the  add(controlPanel, BorderLayout.SOUTH) command.
<img width="514" alt="Screenshot 2025-04-01 at 9 07 21 AM" src="https://github.com/user-attachments/assets/b23fe73e-de9c-4f0f-88a1-9556fa0bd520" />
<img width="373" alt="Screenshot 2025-04-01 at 9 07 29 AM" src="https://github.com/user-attachments/assets/52dbd55a-4c3e-46e7-8fad-8f3c0adab11a" />
<img width="449" alt="Screenshot 2025-04-04 at 12 40 32 PM" src="https://github.com/user-attachments/assets/da67ec9e-5779-460d-872b-7ca7c3e3da61" />


---

## Date: 31/3/2025

added the function to update the view of the player every time the player makes a action (X and Y changes). Made the two for loops that constanly check the X and Y of the mazeHeight and MazeWidth. Then the if statement checks the X and Y of the player are colours it red. Also colors the finsih blue and then paints the walls (1) black and the path (0) white. cellPanel is the panel for the maze that displays everything and the dimensions are 50 for height and 50 for width. then  mazePanel.revalidate() updates the view for the maze and the mazePanel.repaint() repaints the maze. then the last function takes care of the movement. I have 5 buttons 4 of them are for movement and the last is for the instructions, it checks for actions and when the buttons are clicked the when runs and moves the player to the position and then updates the view. the last button the instructions button uses a showMessageDialog to show a message in a mini pop up the message states, "use the buttons provided to complete the maze, get to the blue block to finish.". the "this" is used to to specify the parent component which in this case is the showMessageDialog.


<img width="747" alt="Screenshot 2025-04-01 at 9 24 15 AM" src="https://github.com/user-attachments/assets/c4b9e6b3-000c-4efd-a6b2-e522efb551a5" />
<img width="726" alt="Screenshot 2025-04-04 at 12 41 39 PM" src="https://github.com/user-attachments/assets/89eb968b-c928-4042-8ba9-dd2ca81f406d" />


---

## Date: 4/4/2025

Added a current location Jlabel that shows the curren X and Y coordinates that you are currently at on the map. This allows the player of the game to see their current location that they are at throughout the maze by looking at the top of their screen.

<img width="663" alt="Screenshot 2025-04-04 at 12 43 34 PM" src="https://github.com/user-attachments/assets/c5d7cb57-d17f-4303-a944-fe93611358fc" />
<img width="444" alt="Screenshot 2025-04-04 at 12 43 41 PM" src="https://github.com/user-attachments/assets/6742be0d-14f3-4500-bbf1-2136c8e97e78" />
<img width="280" alt="Screenshot 2025-04-04 at 12 43 51 PM" src="https://github.com/user-attachments/assets/421b81cb-c730-4833-9568-a3db293f5eb1" />
<img width="197" alt="Screenshot 2025-04-04 at 12 47 56 PM" src="https://github.com/user-attachments/assets/6f3d0dc4-a87e-43cf-8466-65af31cd49be" />





---


