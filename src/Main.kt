/*
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   Dylan's Maze
 * Project Author: Dylan Collins
 * GitHub Repo:    https://github.com/waimea-dlcollins/Level-3-programming-assessment#
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * Creating maze
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


    // Constants defining any key values
    var playerX = 1
    var playerY = 1
    val mazeWidth = 7
    val mazeHeight = 8


    val maze: List<List<Int>> = listOf(
        listOf(1, 1, 1, 1),
        listOf(1, 0, 0, 1),
        listOf(0, 1, 1, 1),
        listOf(1, 1, 1, 0),
        listOf(1, 0, 1, 1),
        listOf(1, 1, 0, 1),
        listOf(0, 1, 1, 0),
        listOf(1, 1, 1, 1),

        )



     val exitX = mazeWidth - 2
     val exitY = mazeWidth - 2


    fun isWalkable (x:Int, y:Int): Boolean {
        return (x in 0 until mazeWidth && y in 0 until mazeHeight)



    }

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

     fun keyPressed(e: KeyEvent) {
        when (e.keyCode)
        {
            KeyEvent.VK_UP -> if (movePlayer(0, -1)) gameWon()
            KeyEvent.VK_DOWN -> if (movePlayer(0, 1)) gameWon()
            KeyEvent.VK_LEFT -> if (movePlayer(-1, 0)) gameWon()
            KeyEvent.VK_RIGHT -> if (movePlayer(1, 0)) gameWon()

        }

    }
    fun gameWon() {
        JOptionPane.showMessageDialog(null, "You completed the maze.")
    }

}






/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {


    private lateinit var ClicksLabel: JLabel
    private lateinit var mazePanel: JPanel

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Dylans maze"
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

        val contentPanel = JPanel (BorderLayout()).apply{
            bounds = Rectangle(0,0,600,350)
        }


        ClicksLabel = JLabel("Dylan's maze").apply {
            horizontalAlignment = SwingConstants.CENTER
            bounds = Rectangle(50,10,300,30)
            font = baseFont
            add(this)
        }

         mazePanel = object :JPanel() {
            override fun paintComponent(g: Graphics) {
                g.color = Color.GREEN
                g.fillRect(app.playerX * 100 + 50, app.playerY * 100 + 150, 50, 50)

                g.color = Color.BLUE
                g.fillRect(app.exitX * 100 + 50, app.exitY * 100 + 150, 50, 50)
            }
        }.apply{
            bounds = Rectangle(50, 150, 500, 500)

            isFocusable = true
            addKeyListener(this@MainWindow)
        }
    add(mazePanel)
    }

    private fun addKeyListener(mainWindow: MainWindow) {

    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {

        }


    }


    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
     fun actionPerformed(e: ActionEvent?) {

        }





