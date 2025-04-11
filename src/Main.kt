/*
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name: Dylan's Maze
 * Project Author: Dylan Collins
 * GitHub Repo: https://github.com/waimea-dlcollins/Level-3-programming-assessment
 * ---------------------------------------------------------------------
 * PROJECT NOTES HERE
 * Notes: Maze game in kotlin using OOP principles, made by Dylan Collins
 * =====================================================================
 */


/* This program challenges the user to find their way throughout the maze,
 while being timed throughout their journey,
 whilst constantly showing the players exact location in X and Y coordinates. The player also only has a visivility of 1
 which makes the game signficantly harder for the player to navigate the maze and find the finish. The player
 can challenge themselves to get a new high score with the built-in timer and can also
 click the infomation button in the bottom right of the app to find out how to play.
 */


// imports com.formdev.flatlaf.FlatDarkLaf
import com.formdev.flatlaf.FlatDarkLaf
// imports java.awt.*
import java.awt.*
// imports java.awt.event.*
import java.awt.event.*
//imports javax.swing.*
import javax.swing.*
// imports kotlin.math.abs
import kotlin.math.abs


/**
 * Launch the application
 */

// function for main
fun main() {
    // sets up FlatDarkLaf
    FlatDarkLaf.setup()
    // initiates "app"
    val app = App()
    // initiates the MainWindow of the "app"
    MainWindow(app)
}
// turns "app" into a class
class App {
    // var that contains the Player X coordinate
    var playerX = 0
    // var that contains the Player Y coordinate
    var playerY = 0
    // var that contains the time that the timer starts at, in this context 0
    var seconds = 0
    // val that contains the mazeWidth which is 7
    val mazeWidth = 7
    // val that contains the mazeHeight, which is 8
    val mazeHeight = 8
    // val that contains the Exit X coordinate which is -1
    val exitX = mazeWidth - 1
    // val that contains the Exit Y coordinate which is - 8
    val exitY = mazeHeight - 8
    // val that contains the distance of visibility the player can see
    val playerVisibility = 1

    // val which contains a List<List<Int>> = listOf() which displays the layout of the maze, all the 0's are free spaces that are walkable and the 1's are walls that stop the player from continuing.
    val maze: List<List<Int>> = listOf(
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 0, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0 , 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 0, 0, 1, 0, 0, 0)
    )

    // a private function that checks if the next X and Y coordinate is avaiable for the player to move to, it either returns a true or a false
    private fun isWalkable(x: Int, y: Int): Boolean {
    // checks if the coordinates given ( X and Y) and withing the bounds of the maze layout and whether the corresponding cell is available
        return (x in 0 until mazeWidth && y in 0 until mazeHeight && maze[y][x] == 0)
    }
    // a non-private function that enables the player to move, it stores the dX and dY which is the previous X and Y coordinates and then if the next spot is available it adds dX and yX with the newX and newY
    fun movingPlayer(dx: Int, dy: Int): Boolean {
        // val that adds the newX to the playerX and then also adds the dx
        val newX = playerX + dx
        // val that adds the newY to the playerY and then also adds the dy
        val newY = playerY + dy
        // if isWalkable is true then this if statement allows the player to move by displaying the newX and newY coordinates of the player
        if (isWalkable(newX, newY)) {
            playerX = newX
            playerY = newY
        // if statement that is constanly checking the playerX and PlayerY coordinates for when they reach the coordinates of the finish
            if (playerX == exitX && playerY == exitY) {
                gameWon()
            }
            // returns true if they make it to the finish
            return true
        }
        // returns false if they haven't made it to the finsih line yet
        return false
    }
        // if the isWalkable if statement returns true then this private function named gameWon creates a JOptionPane and displays a message that states ""You finished the maze in $seconds seconds."
    private fun gameWon() {
        // displays the message using JOptionPane.showMessageDialog also has a parentComponent of "null"
        JOptionPane.showMessageDialog(null, "You finished the maze in $seconds seconds.")
    }
}
// initiates the MainWindow class, has parmarters of app which is a private val, Has a JFrame and has a ActionListener
class MainWindow (private val app: App) : JFrame(), ActionListener {
    // a private lateinit var for the instructionsButton which uses JButton
    private lateinit var instructionsButton: JButton
    // a private lateinit var for the mazePanel which uses JPanel
    private lateinit var mazePanel: JPanel
    // a private lateinit var for the upButton which uses JButton
    private lateinit var upButton: JButton
    // a private lateinit var for the downButton which uses JButton
    private lateinit var downButton: JButton
    // a private lateinit var for the leftButton which uses JButton
    private lateinit var leftButton: JButton
    // a private lateinit var for the rightButton which uses JButton
    private lateinit var rightButton: JButton
    // a private lateinit var for the timerLabel which uses JLabel
    private lateinit var timerLabel: JLabel
    // a private lateinit var for the gameTimer which uses "Timer"
    private lateinit var gameTimer: Timer
    // a private lateinit var for the currentPosition which uses JLabel
    private lateinit var currentPosition: JLabel


    // init is used to initialize the properties of the classes
    init {
        // configureWindow() for configuring the window
        configureWindow()
    // addControls for adding the controls for the game
        addControls()
    // setLocationRelativeTo(null) to set the relative location to nothing
        setLocationRelativeTo(null)
    // isVisible = true to make sure things are visible
        isVisible = true
    // updateView() to be constanly updating the view
        updateView()
    // startTimer() to start the timer when the window opens
        startTimer()
    }
// private function that condigures the window the maze game it played in.
    private fun configureWindow() {
        // titile is "Dylan's Maze"
        title = "Dylan's Maze"
    // initialize the preferredsize of the window
        contentPane.preferredSize = Dimension(400, 600)
    // initialize the exit_on_close when the user closes the window so it doesn't stay open.
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    // makes it so the window cant be resizable
        isResizable = false
    // makes the layour of the window borderlayout()
        layout = BorderLayout()
    // packs everything together
        pack()
    }
// private function that starts the timer built into the program
    private fun startTimer() {
        // "game timer" that has a delay of 1000 milliseconds so it chnages every second
        gameTimer = Timer(1000) {
            // adds seconds to the app
            app.seconds++
            // "timerLabel.text" gets the current seconds from the app and then displays them
            timerLabel.text = " ${app.seconds} Current Seconds"
        }
    // tells the game timer to start
        gameTimer.start()
    }
    // private function for adding the controls of the game
    private fun addControls() {
        // a val for the button font
        val buttonFont = Font(Font.SANS_SERIF, Font.BOLD, 40)
    // a val for the timer font
        val timerFont = Font(Font.SANS_SERIF, Font.BOLD, 20)
    // a val for the currentposition font
        val currentPositionFont = Font(Font.SANS_SERIF, Font.BOLD, 20)

    // val for the headerPanel, headerPanel is a JPanel, and it has a borderlayout()
        val headerPanel = JPanel (BorderLayout())
    // the layout for the headerPanel "BorderLayout"
        headerPanel.layout = BorderLayout()
    // the timer label, displayed using a JLabel, shows the current seconds and has SwingConstants of left
        timerLabel = JLabel ("0 Current Seconds", SwingConstants.LEFT)
    // the font of the timerlabel
        timerLabel.font = timerFont
    // adds the timer label to the headerPanel with the BorderLayout.WEST
        headerPanel.add(timerLabel, BorderLayout.WEST)
    // the currentposition label that uses JLabel, shows the current position of the player in X and Y coordinates, and has SwingConstants.RIGHT
        currentPosition = JLabel("Position: (${app.playerX}, ${app.playerX})", SwingConstants.RIGHT)
    //  adds the currentposition font to the currentposition
        currentPosition.font = currentPositionFont
    // adds the currentposition to the headerPanel with the borderlayout.east
        headerPanel.add(currentPosition, BorderLayout.EAST)
    // initiates mazePanel, is a JPanel()
        mazePanel = JPanel()
    // initiates the layour of the mazeHeight and the mazeWidth, using a grid layout
        mazePanel.layout = GridLayout(app.mazeHeight, app.mazeWidth)
    // adds the mazepanel to the borderlayout.center
        add(mazePanel, BorderLayout.CENTER)
    // adds headerpanel to the borderlayout.north
        add(headerPanel, BorderLayout.NORTH)
    // val that initiates the control, using JPanel
        val controlPanel = JPanel()
    // makes the control lauout a Flowlayout so it isn't in a fixed position
        controlPanel.layout = FlowLayout()

        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------
    // initiates up button using JButton, displays "↑"
        upButton = JButton("↑")
    // makes the font of the upbutton buttonfont
        upButton.font = buttonFont
    // sets the up button background color to blue
        upButton.background = Color(0, 0, 255)
    // sets the upbutton foreground to black
        upButton.foreground = Color.BLACK
    // adds the  ActionListener "this" to the upbutton
        upButton.addActionListener(this)

    // initiates down button using JButton, displays "↓"
        downButton = JButton("↓")
    // makes the font of the down button buttonfont
        downButton.font = buttonFont
    // sets the background color of the downbutton to blue
        downButton.background = Color(0, 0, 255)
    // sets the downbutton foreground color to BLACK
        downButton.foreground = Color.BLACK
    // adds the ActionListener "this" to the downbutton
        downButton.addActionListener(this)

    // initiates leftbutton using JButton, displays "←"
        leftButton = JButton("←")
    // makes the font of the left button the left button font
        leftButton.font = buttonFont
    // makes the background color of the leftbutton to blue
        leftButton.background = Color(0, 0, 255)
    // makes the foreground color of the leftbutton to BLACK
        leftButton.foreground = Color.BLACK
    // adds the ActionListener "this" to the leftbutton
        leftButton.addActionListener(this)

    // initiates rightbutton using JButton, displays "→"
        rightButton = JButton("→")
    // makes the font of the righbutton button font
        rightButton.font = buttonFont
    // makes the background color of the rightbutton blue
        rightButton.background = Color(0, 0, 255)
    // makes the color of the rightbutton foreground to BLACK
        rightButton.foreground = Color.BLACK
    // adds the ActionListener "this" to the rightbutton
        rightButton.addActionListener(this)

    // initiates instructionsButton using JButton, displays "?"
        instructionsButton = JButton("?")
    // makes the font of instructionsButton button font
        instructionsButton.font = buttonFont
    // makes the background color of instructionsButton to blue
        instructionsButton.background = Color(0, 0, 255)
    // makes the foreground color of the instructionsButton to black
        instructionsButton.foreground = Color.BLACK
    // adds the ActionListener "this" to the instructionsButton
        instructionsButton.addActionListener(this)

    // adds the upbuttonn to the control panel
        controlPanel.add(upButton)
    // adds the down button to the control panel
        controlPanel.add(downButton)
    // adds the left button to the control panel
        controlPanel.add(leftButton)
    // adds the righbutton to the control panel
        controlPanel.add(rightButton)
    // adds the instructionsButton to the control panel
        controlPanel.add(instructionsButton)
    // makes the borderlayout of the control panel to south
        add(controlPanel, BorderLayout.SOUTH)
    }
    // private function that updates the view of the game constantly
    private fun updateView() {
    // removes all the previous panels before adding the new ones
        mazePanel.removeAll()
    // for loop that keeps going until the maximum height of the maze is reached
        for (y in 0 until app.mazeHeight) {
    // for loop that keeps going until the maximum width of the maze is reached
            for (x in 0 until app.mazeWidth) {
                // val that initiates the playerpanel, using JPanel
                val jPanel = JPanel()
                // val the initiates the ispanelVisble, using JPanel
                val ispanelVisble =
                    // abs is used to be able to calcuate the absolute value of the expression x and y of the player,
                    // the app stores the playerX and the playerY and the playerVisibility which is set to 1
                    abs(x - app.playerX ) + abs( y- app.playerY) <= app.playerVisibility
                // if the panel is visible the code runs if no the last else runs and makes the tiles black unless they,
                // are in the raidus of the player's visibility of 1
                if (ispanelVisble)
                // if statement that is constanly checking the X and Y coordinates of the player using
                    if (x == app.playerX && y == app.playerY) {
                        // makes the cell panel background color red (the player)
                        jPanel.background = Color.RED
                        // else if that is checking for the exit Y and exit X coordinates for when the player reaches the finish
                    } else if (x == app.exitX && y == app.exitY) {
                        // makes the background for the finish line the color blue
                        jPanel.background = Color(0, 0, 255)
                        // else if that identifies 1's as walls
                    } else if (app.maze[y][x] == 1) {
                        // colors them black so the player can identify if the panel is a wall or a walkable panel
                        jPanel.background = Color.BLACK
                        // else that makes all the panels that aren't the finish line or a wall walkable panels by coloring,
                        // them white, so the player can identify that they are walkable
                    } else {
                        // colors the background of the walkable panels white
                        jPanel.background = Color.WHITE
                        // else that is in charge of making the walkable panels that aren't in the visibility raidus of the player black,
                        // so that the player can see them
                    } else {
                        // colors these walkable panels that aren't in the visibility radius of the player to the color black so that they,
                        // cant be seen
                    jPanel.background = Color.BLACK
            }
                // makes the jPanel preferredsize to the dimensions of 50 for width and 50 for height
                jPanel.preferredSize = Dimension(50, 50)
                // adds jPanel to the mazePanel
                mazePanel.add(jPanel)
            }
        }
        // displays the current position of the player in X and Y coordinates so the player can see where they are, displayed in text
        currentPosition.text = "Position: (X${app.playerX}, Y${app.playerY}) "

        // revalidates the mazepanel
        mazePanel.revalidate()
        mazePanel.repaint()
    }

    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            upButton -> if (app.movingPlayer(0, -1)) updateView()
            downButton -> if (app.movingPlayer(0, 1)) updateView()
            leftButton -> if (app.movingPlayer(-1, 0)) updateView()
            rightButton -> if (app.movingPlayer(1, 0)) updateView()
            instructionsButton -> JOptionPane.showMessageDialog(
                this,
                "use the buttons provided at the bottom of the app to complete the maze. As you can see in the top right and left there is a timer and your current position displayed in X and Y coordinates, you are also being timed so challenege yourself to get a highscore and get to the blue block to finish the maze."
            )
        }
    }
}

