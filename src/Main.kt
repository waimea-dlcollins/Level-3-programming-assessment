/*
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   Dylan's Maze
 * Project Author: Dylan Collins
 * GitHub Repo:    https://github.com/waimea-dlcollins/Level-3-programming-assessment#
 * ---------------------------------------------------------------------
 * PROJECT NOTES HERE
 * Notes: maze game in kotlin using OPP principles, made by Dylan Collins
 * =====================================================================
 */



import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*
import java.awt.event.KeyEvent



/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model
}


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {




    var playerX = 1
    var playerY = 1
    // stores the maze Width
    val mazeWidth = 7
    // stores the maze height
    val mazeHeight = 8
    val locationY = "Y"
    val locationX = "X"


// list of the maze layout, displayed in 1s and 0s
    val maze: List<List<Int>> = listOf(
        listOf(1, 1, 1, 1),
        listOf(1, 0, 0, 1),
        listOf(1, 1, 1, 1),
        listOf(1, 1, 1, 0),
        listOf(1, 0, 1, 1),
        listOf(1, 1, 0, 1),
        listOf(0, 1, 1, 0),
        listOf(1, 1, 1, 1),

        )



    // stores exitX mazeWidth
     val exitX = mazeWidth - 2
    // stores exitY mazeWidth
     val exitY = mazeWidth - 2

// function that checks if the next location is walkable, x is an integer so is y and the function is a boolean
    fun isWalkable (x:Int, y:Int): Boolean {
        return (x in 0 until mazeWidth && y in 0 until mazeHeight)



    }
// function that allows the player to move throughout the maze
    fun movePlayer(dx: Int, dy: Int): Boolean {
        val newX = playerX + dx
        val newY = playerY + dy

        if(isWalkable(newX, newY)) {
            playerX = newX
            playerY = newY

            if (playerX == exitX && playerY == exitY) {
                return true
            }
            return false
        }

        return true
    }
// function that checks for key presses to allow the user to move through the maze
     fun keyPressed(e: KeyEvent) {
        when (e.keyCode)
        {
            KeyEvent.VK_UP -> if (movePlayer(0, -1)) gameWon()
            KeyEvent.VK_DOWN -> if (movePlayer(0, 1)) gameWon()
            KeyEvent.VK_LEFT -> if (movePlayer(-1, 0)) gameWon()
            KeyEvent.VK_RIGHT -> if (movePlayer(1, 0)) gameWon()

        }

    }
    // function that is constantly checking the user has "won" the game
    fun gameWon() {
        JOptionPane.showMessageDialog(null, "You completed the maze.")
    }

}





/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passed as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {


    private lateinit var topleftPanel: JPanel
    private lateinit var topmiddlePanel: JPanel
    private lateinit var toprightPanel: JPanel
    private lateinit var middleleftPanel: JPanel
    private lateinit var middlemiddlePanel: JPanel
    private lateinit var middlerightPanel: JPanel
    private lateinit var bottomleftPanel: JPanel
    private lateinit var bottommiddlePanel: JPanel
    private lateinit var bottomrightPanel: JPanel

    private lateinit var upButton: JButton
    private lateinit var downButton: JButton
    private lateinit var leftButton: JButton
    private lateinit var rightButton: JButton
    private lateinit var introductionButton: JButton





    /**
     * Configure the UI and display it
     */
    init {
        configureMaze()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureMaze() {
        title = "Dylan's maze"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)
        val buttonFont = Font(Font.SANS_SERIF, Font.PLAIN, 40)



        topleftPanel = JPanel()
        topleftPanel.bounds = Rectangle(10, 50, 200, 50)
        topleftPanel.font = baseFont
        add(topleftPanel)

        topmiddlePanel = JPanel()
        topmiddlePanel.bounds = Rectangle(10, 60, 200, 50)
        topmiddlePanel.font = baseFont
        add(topmiddlePanel)

        toprightPanel = JPanel()
        toprightPanel.bounds = Rectangle(10, 70, 200, 50)
        toprightPanel.font = baseFont
        add(toprightPanel)

        middleleftPanel = JPanel()
        middleleftPanel.bounds = Rectangle(10, 80, 200, 50)
        middleleftPanel.font = baseFont
        add(middleleftPanel)

        middlemiddlePanel = JPanel()
        middlemiddlePanel.bounds = Rectangle(10, 90, 200, 50)
        middlemiddlePanel.font = baseFont
        add(middlemiddlePanel)

        middlerightPanel = JPanel()
        middlerightPanel.bounds = Rectangle(10, 100, 200, 50)
        middlerightPanel.font = baseFont
        add(middlerightPanel)

        bottomleftPanel = JPanel()
        bottomleftPanel.bounds = Rectangle(10, 110, 200, 50)
        bottomleftPanel.font = baseFont
        add(bottomleftPanel)

        bottommiddlePanel = JPanel()
        bottommiddlePanel.bounds = Rectangle(10, 120, 200, 50)
        bottommiddlePanel.font = baseFont
        add(bottommiddlePanel)

        bottomrightPanel = JPanel()
        bottomrightPanel.bounds = Rectangle(10, 130, 200, 50)
        bottomrightPanel.font = baseFont
        add(bottomrightPanel)

//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------

        upButton = JButton("↑")
        upButton.bounds = Rectangle(150, 221, 100, 50)
        upButton.font = buttonFont
        upButton.background = Color(128, 128, 128)
        upButton.addActionListener(this)
        add(upButton)
        downButton = JButton("↓")
        downButton.bounds = Rectangle(150, 280, 100, 50)
        downButton.font = buttonFont
        downButton.background = Color(128, 128, 128)
        downButton.addActionListener(this)
        add(downButton)


        leftButton = JButton("←")
        leftButton.bounds = Rectangle(40, 250, 100, 50)
        leftButton.font = buttonFont
        leftButton.background = Color(128, 128, 128)
        leftButton.addActionListener(this)
        add(leftButton)


        rightButton = JButton("→")
        rightButton.bounds = Rectangle(250, 250, 100, 50)
        rightButton.font = buttonFont
        rightButton.background = Color(128, 128, 128)
        rightButton.addActionListener(this)
        add(rightButton)

        introductionButton = JButton("▶")
        introductionButton.bounds = Rectangle(410, 250, 50, 50)
        introductionButton.font = buttonFont
        introductionButton.background = Color(128, 128, 128)
        introductionButton.addActionListener(this)
        add(introductionButton)
    }




    private fun addKeyListener(mainWindow: MainWindow) {

    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            upButton -> {
                updateView()
            }
            leftButton -> {
                updateView()
            }
            rightButton -> {
                updateView()
            }
            leftButton -> {
                updateView()
            }
        }
    }
}


    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
     fun actionPerformed(e: ActionEvent?) {

        }





