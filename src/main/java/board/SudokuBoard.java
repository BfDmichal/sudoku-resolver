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



    public void tString() {
        for (int i = 0; i < 9; i++) {
            System.out.println(board.get(i));
        }
    }
}
