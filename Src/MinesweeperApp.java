public class MinesweeperApp {
    private Puzzle puzzle;
    private View view;
    private Controller controller;

    public MinesweeperApp(Puzzle puzzle, View view, Controller controller) {
        this.puzzle = puzzle;
        this.view = view;
        this.controller = controller;
    }

    public static void main(String[] args) {
        int numOfRows = ConfigReader.getInstance().readVariable("rows", 10);
        int numOfCols = ConfigReader.getInstance().readVariable("cols", 10);
        int numOfBombs = ConfigReader.getInstance().readVariable("bombs", 10);

        Puzzle puzzle = new Puzzle(numOfRows, numOfCols, numOfBombs);
        View view = new CommandLineView();
        Controller controller = new Controller();
        MinesweeperApp game = new MinesweeperApp(puzzle, view, controller);
        System.out.println("Hello World!");
    }
}
