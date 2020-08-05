package board;

import java.util.ArrayList;

public class SudokuBoard {
    private ArrayList<SudokuPart> board;

    public SudokuBoard() {
        this.board = new ArrayList<>();
    }

    public ArrayList<SudokuPart> getBoard() {
        return board;
    }

    public void addPartToBoard(SudokuPart sudokuPart) {
        board.add(sudokuPart);
    }

    public SudokuPart getPartByName(int name) {
        return board.get(name);
    }

    public boolean checkIsSolved() {
        boolean solve = board.stream()
                .flatMap(sudokuPart -> sudokuPart.getLineOfElements().stream())
                .anyMatch(sudokuElement -> sudokuElement.getValue() == -1);
        return solve;
    }

    public void tString() {
        for (int i = 0; i < 9; i++) {
            System.out.println(board.get(i));
        }
    }
}
