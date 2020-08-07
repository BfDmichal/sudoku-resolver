package boardSolver;


import board.SudokuBoard;
import board.SudokuElement;

public class Solver {
    public void solveCase(SudokuBoard sudokuBoard) {
        BoardOperator boardOperator = new BoardOperator();
        while (!checkIsBoardSolved(sudokuBoard)) {
            sudokuBoard = boardOperator.checkRepeatsAndDelete(sudokuBoard);
        }
    }

    private boolean checkIsBoardSolved(SudokuBoard board) {
        return board.getBoard().stream()
                .flatMap(sudokuPart -> sudokuPart.getLineOfElements().stream())
                .allMatch(SudokuElement::elementHasNumber);
    }

}
