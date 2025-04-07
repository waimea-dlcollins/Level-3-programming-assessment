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
 whilst constantly showing the players exact location in X and Y coordinates. The player
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

    // val which contains a List<List<Int>> = listOf() which displays the layout of the maze, all the 0's are free spaces that are walkable and the 1's are walls that stop the player from continuing.
    val maze: List<List<Int>> = listOf(
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 0, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
        // ListOf 0's and 1's that display the maze
        listOf(0, 1, 0, 1, 0, 1, 0),
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
        //
        gameTimer = Timer(1000) {
            app.seconds++
            timerLabel.text = " ${app.seconds} Current Seconds"
        }
        gameTimer.start()
    }

    private fun addControls() {
        val buttonFont = Font(Font.SANS_SERIF, Font.BOLD, 40)
        val timerFont = Font(Font.SANS_SERIF, Font.BOLD, 20)
        val currentPositionFont = Font(Font.SANS_SERIF, Font.BOLD, 20)


        val headerPanel = JPanel (BorderLayout())
        headerPanel.layout = BorderLayout()

        timerLabel = JLabel ("0 Current Seconds", SwingConstants.LEFT)
        timerLabel.font = timerFont
        headerPanel.add(timerLabel, BorderLayout.WEST)

        currentPosition = JLabel("Position: (${app.playerX}, ${app.playerX})", SwingConstants.RIGHT)
        currentPosition.font = currentPositionFont
        headerPanel.add(currentPosition, BorderLayout.EAST)

        mazePanel = JPanel()
        mazePanel.layout = GridLayout(app.mazeHeight, app.mazeWidth)
        add(mazePanel, BorderLayout.CENTER)


        add(headerPanel, BorderLayout.NORTH)

        val controlPanel = JPanel()
        controlPanel.layout = FlowLayout()

        //----------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------

        upButton = JButton("↑")
        upButton.font = buttonFont
        upButton.background = Color(0, 0, 255)
        upButton.foreground = Color.BLACK
        upButton.addActionListener(this)

        downButton = JButton("↓")
        downButton.font = buttonFont
        downButton.background = Color(0, 0, 255)
        downButton.foreground = Color.BLACK
        downButton.addActionListener(this)

        leftButton = JButton("←")
        leftButton.font = buttonFont
        leftButton.background = Color(0, 0, 255)
        leftButton.foreground = Color.BLACK
        leftButton.addActionListener(this)

        rightButton = JButton("→")
        rightButton.font = buttonFont
        rightButton.background = Color(0, 0, 255)
        rightButton.foreground = Color.BLACK
        rightButton.addActionListener(this)

        instructionsButton = JButton("?")
        instructionsButton.font = buttonFont
        instructionsButton.background = Color(0, 0, 255)
        instructionsButton.foreground = Color.BLACK
        instructionsButton.addActionListener(this)

        controlPanel.add(upButton)
        controlPanel.add(downButton)
        controlPanel.add(leftButton)
        controlPanel.add(rightButton)
        controlPanel.add(instructionsButton)

        add(controlPanel, BorderLayout.SOUTH)
    }

    private fun updateView() {
        mazePanel.removeAll()

        for (y in 0 until app.mazeHeight) {
            for (x in 0 until app.mazeWidth) {
                val cellPanel = JPanel()
                if (x == app.playerX && y == app.playerY) {
                    cellPanel.background = Color.RED
                } else if (x == app.exitX && y == app.exitY) {
                    cellPanel.background = Color(0, 0, 255)
                } else if (app.maze[y][x] == 1) {
                    cellPanel.background = Color.BLACK
                } else {
                    cellPanel.background = Color.WHITE
                }
                cellPanel.preferredSize = Dimension(50, 50)
                mazePanel.add(cellPanel)
            }
        }

        currentPosition.text = "Position: (X${app.playerX}, Y${app.playerY}) "


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

