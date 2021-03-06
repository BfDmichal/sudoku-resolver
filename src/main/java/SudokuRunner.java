import boardSolver.BoardCreator;
import boardSolver.Solver;
import board.SudokuBoard;
import fileReader.FileReader;

public class SudokuRunner {
    public static void main(String[] args) {
//        boolean gameFinished = false;
//        while(!gameFinished) {
//            SudokuGame theGame = new SudokuGame();
//            gameFinished = theGame.resolveSudoku();
        FileReader fileReader = new FileReader();
        SudokuBoard board = new BoardCreator().createBoard();
        fileReader.readFile(board);
        board.displayBoard();
        Solver solver = new Solver();
        solver.solveCase(board);
        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,");
        board.displayBoard();

        }
    }
