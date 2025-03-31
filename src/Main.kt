/*
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   Dylan's Maze
 * Project Author: Dylan Collins
 * GitHub Repo: https://github.com/waimea-dlcollins/Level-3-programming-assessment
 * ---------------------------------------------------------------------
 * PROJECT NOTES HERE
 * Notes: Maze game in kotlin using OOP principles, made by Dylan Collins
 * =====================================================================
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*

/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()
    val app = App()
    MainWindow(app)
}

class App {
    var playerX = 0
    var playerY = 0
    var seconds = 0
    val mazeWidth = 7
    val mazeHeight = 8
    val exitX = mazeWidth - 1
    val exitY = mazeHeight - 8

    val maze: List<List<Int>> = listOf(
        listOf(0, 1, 0, 0, 0, 1, 0),
        listOf(0, 1, 0, 1, 0, 1, 0),
        listOf(0, 1, 0, 1, 0, 1, 0),
        listOf(0, 1, 0, 1, 0, 1, 0),
        listOf(0, 1, 0, 1, 0, 1, 0),
        listOf(0, 1, 0, 1, 0, 1, 0),
        listOf(0, 1, 0, 1, 0, 1, 0),
        listOf(0, 0, 0, 1, 0, 0, 0)
    )

    private fun isWalkable(x: Int, y: Int): Boolean {
        return (x in 0 until mazeWidth && y in 0 until mazeHeight && maze[y][x] == 0)
    }

    fun movePlayer(dx: Int, dy: Int): Boolean {
        val newX = playerX + dx
        val newY = playerY + dy

        if (isWalkable(newX, newY)) {
            playerX = newX
            playerY = newY

            if (playerX == exitX && playerY == exitY) {
                gameWon()
            }
            return true
        }
        return false
    }

    private fun gameWon() {
        JOptionPane.showMessageDialog(null, "You finished the maze in $seconds seconds.")
    }
}

class MainWindow(private val app: App) : JFrame(), ActionListener {
    private lateinit var instructionsButton: JButton
    private lateinit var mazePanel: JPanel
    private lateinit var upButton: JButton
    private lateinit var downButton: JButton
    private lateinit var leftButton: JButton
    private lateinit var rightButton: JButton
    private lateinit var timerLabel: JLabel
    private lateinit var gameTimer: Timer

    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)
        isVisible = true
        updateView()
        startTimer()
    }

    private fun configureWindow() {
        title = "Dylan's Maze"
        contentPane.preferredSize = Dimension(400, 550)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = BorderLayout()
        pack()
    }

    private fun startTimer() {
        gameTimer = Timer(1000) {
            app.seconds++
            timerLabel.text = " ${app.seconds} seconds"
        }
        gameTimer.start()
    }

    private fun addControls() {
        val buttonFont = Font(Font.SANS_SERIF, Font.PLAIN, 40)
        val timerFont = Font(Font.SANS_SERIF, Font.BOLD, 20)

        // Timer display
        timerLabel = JLabel ("0 seconds",SwingConstants.CENTER)
        timerLabel.font = timerFont
        add(timerLabel, BorderLayout.NORTH)

        mazePanel = JPanel()
        mazePanel.layout = GridLayout(app.mazeHeight, app.mazeWidth)
        add(mazePanel, BorderLayout.CENTER)

        val controlPanel = JPanel()
        controlPanel.layout = FlowLayout()

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

        instructionsButton = JButton("▶")
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
        mazePanel.revalidate()
        mazePanel.repaint()
    }

    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            upButton -> if (app.movePlayer(0, -1)) updateView()
            downButton -> if (app.movePlayer(0, 1)) updateView()
            leftButton -> if (app.movePlayer(-1, 0)) updateView()
            rightButton -> if (app.movePlayer(1, 0)) updateView()
            instructionsButton -> JOptionPane.showMessageDialog(
                this,
                "use the buttons provided to complete the maze, get to the blue block to finish."
            )
        }
    }
}

