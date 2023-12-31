package four;

import javax.swing.*;
import javax.swing.border.Border; // Import the Border class
import java.awt.*;

public class ConnectFour extends JFrame {

    static final int GRID_ROWS = 6;
    static final int GRID_COLUMNS = 7;
    static final Color BASE_COLOR = new Color(0xf1dac4);
    static final Color WIN_COLOR = new Color(0x474973);
    private static boolean p1Turn = true;
    static final String PLAYER_1_MOVE = "X";
    static final String PLAYER_2_MOVE = "O";
    static final int MAX_INDEX = 3; // Imaginary array 4x4 for checking vertical and diagonal wins

    public ConnectFour() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Connect Four");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS, 5, 5)); // Added gap between cells
        panel.setBackground(BASE_COLOR); // Set the base color for the game board
        Border border = BorderFactory.createLineBorder(new Color(0xf1dac4), 6); // Create a black border
        panel.setBorder(border); // Set the border for the panel

        createCells(panel);

        ButtonReset resetButton = new ButtonReset("RESET");
        resetButton.setFont(new Font("Tahoma", Font.BOLD, 18)); // Increased font size
        resetButton.setForeground(new Color(0xf1dac4));
        resetButton.setBackground(new Color(0x474973)); // Changed reset button color

        add(panel);
        add(resetButton);
        setVisible(true);
    }

    Cell[][] cellGrid = Cell.cellGrid;

    public static boolean isP1Turn() {
        return p1Turn;
    }

    public static void setP1Turn(boolean p1Turn) {
        ConnectFour.p1Turn = p1Turn;
    }

    private void createCells(JPanel panel) {
        for (int row = GRID_ROWS; row > 0; row--) {
            for (char col = 'A'; col <= 'G'; col++) {
                String text = "" + col + row;
                Cell c = new Cell(text);
                cellGrid[row - 1][col - 65] = c;
                c.setFont(new Font("Tahoma", Font.BOLD, 35)); // Increased cell font size
                c.setBackground(BASE_COLOR); // Set the base color for cells
                panel.add(c);
            }
        }
    }

    static boolean isVertWin(Cell[][] cells, int col, String move) {
        boolean isVertWin = false;
        for (int i = 0; i < MAX_INDEX; i++) {
            if (cells[i][col].getText().equals(move) && cells[i + 1][col].getText().equals(move) &&
                    cells[i + 2][col].getText().equals(move) && cells[i + 3][col].getText().equals(move)) {
                isVertWin = true;
                cells[i][col].setBackground(WIN_COLOR);
                cells[i + 1][col].setBackground(WIN_COLOR);
                cells[i + 2][col].setBackground(WIN_COLOR);
                cells[i + 3][col].setBackground(WIN_COLOR);
            }
        }
        return isVertWin;
    }

    static boolean isHorWin(Cell[][] cells, int row, String move) {
        boolean isHorWin = false;
        for (int j = 0; j <= MAX_INDEX; j++) {
            if (cells[row][j].getText().equals(move) && cells[row][j + 1].getText().equals(move) &&
                    cells[row][j + 2].getText().equals(move) && cells[row][j + 3].getText().equals(move)) {
                isHorWin = true;
                cells[row][j].setBackground(WIN_COLOR);
                cells[row][j + 1].setBackground(WIN_COLOR);
                cells[row][j + 2].setBackground(WIN_COLOR);
                cells[row][j + 3].setBackground(WIN_COLOR);
            }
        }
        return isHorWin;
    }

    static boolean isPosDiagWin(Cell[][] cells, String move) {
        boolean isPosDiagWin = false;
        for (int i = 0; i < MAX_INDEX; i++) {
            for (int j = 0; j <= MAX_INDEX; j++) {
                if (cells[i][j].getText().equals(move) && cells[i + 1][j + 1].getText().equals(move) &&
                        cells[i + 2][j + 2].getText().equals(move) && cells[i + 3][j + 3].getText().equals(move)) {
                    isPosDiagWin = true;
                    cells[i][j].setBackground(WIN_COLOR);
                    cells[i + 1][j + 1].setBackground(WIN_COLOR);
                    cells[i + 2][j + 2].setBackground(WIN_COLOR);
                    cells[i + 3][j + 3].setBackground(WIN_COLOR);
                }
            }
        }
        return isPosDiagWin;
    }

    static boolean isNegDiagWin(Cell[][] cells, String move) {
        boolean isNegDiagWin = false;
        for (int i = 0; i < MAX_INDEX; i++) {
            for (int j = MAX_INDEX; j < GRID_COLUMNS; j++) {
                if (cells[i][j].getText().equals(move) && cells[i + 1][j - 1].getText().equals(move) &&
                        cells[i + 2][j - 2].getText().equals(move) && cells[i + 3][j - 3].getText().equals(move)) {
                    isNegDiagWin = true;
                    cells[i][j].setBackground(WIN_COLOR);
                    cells[i + 1][j - 1].setBackground(WIN_COLOR);
                    cells[i + 2][j - 2].setBackground(WIN_COLOR);
                    cells[i + 3][j - 3].setBackground(WIN_COLOR);
                }
            }
        }
        return isNegDiagWin;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConnectFour::new);
    }
}
