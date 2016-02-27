import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {
    private int numOfRows;
    private int numOfCols;
    private int numOfBombs;
    private int numOfFlagsRemaining;
    private Cell[][] grid;

    public Puzzle(int numOfRows, int numOfCols, int numOfBombs) {
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        this.numOfBombs = numOfBombs;
        this.numOfFlagsRemaining = this.numOfBombs; // players get one flag per bomb
        this.grid = new Cell[this.numOfRows][this.numOfCols];
        initializePuzzle();
    }

    /**
     * Generates a valid minesweeper puzzle
     */
    public void initializePuzzle() {
        int bombsToPlace = this.numOfBombs;
        Random rn = new Random();
        int generatedRow;
        int generatedCol;

        for(int i = 0; i < this.numOfBombs; i++) {
            generatedRow = rn.nextInt(this.numOfRows);
            generatedCol = rn.nextInt(this.numOfCols);

            if(!(this.grid[generatedRow][generatedCol] instanceof BombCell)) {
                bombsToPlace--;
                this.grid[generatedRow][generatedCol] = new BombCell();
            }
        }

        for(int row = 0; row < this.numOfRows; row++) {
            for(int col = 0; col < this.numOfCols; col++) {
                if(this.grid[row][col] == null) {
                    this.grid[row][col] = new NumberCell();
                }
            }
        }
    }

    public void cellSelected(int row, int col) {

    }

    public List<Cell> findAdjacentCells(Cell cell) {
        List<Cell> adjacentCells = new ArrayList<Cell>();
        return adjacentCells;
    }
}
