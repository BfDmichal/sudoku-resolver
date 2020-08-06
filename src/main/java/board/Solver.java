package board;


public class Solver {
    public void solveCase(SudokuBoard sudokuBoard) {
        BoardOperator boardOperator = new BoardOperator();
        SudokuBoard changedBoard = sudokuBoard;
        while (!checkIsBoardSolved(sudokuBoard)) {
                sudokuBoard = boardOperator.checkRepeatsAndDelete(sudokuBoard);
        }
        System.out.println("");
        sudokuBoard.tString();

    }

    private boolean checkIsBoardSolved(SudokuBoard board) {
        return board.getBoard().stream()
                .flatMap(sudokuPart -> sudokuPart.getLineOfElements().stream())
                .allMatch(SudokuElement::elementHasNumber);
    }

}
