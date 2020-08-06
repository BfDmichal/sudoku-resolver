package board;

import java.util.ArrayList;

public class BoardCreator {
    SudokuBoard sudokuBoard;
    public SudokuBoard createBoard() {
         sudokuBoard = new SudokuBoard();
        for (int i = 0; i < 9; i++) {
            SudokuPart sudokuPart = new SudokuPart(i);
            for (int j = 0; j < 9; j++) {
                SudokuElement sudokuElement = new SudokuElement();
                sudokuPart.addElementToRow(sudokuElement);
            }
            sudokuBoard.addPartToBoard(sudokuPart);
        }
        addElementToColumn(sudokuBoard);
        addSquaresToBoard(sudokuBoard);
        return sudokuBoard;
    }

    private void addElementToColumn(SudokuBoard sudokuBoard) {
        for (int i = 0; i < 9; i++) {
            SudokuPart sudokuColumn = new SudokuPart(i + 9);
            for (int j = 0; j < 9; j++) {
                SudokuPart sudokuPart = sudokuBoard.getBoard().get(j);
                SudokuElement sudokuElement = sudokuPart.getLineOfElements().get(i);
                sudokuColumn.addElementToRow(sudokuElement);
            }
            sudokuBoard.addPartToBoard(sudokuColumn);
        }
    }

    private void addSquaresToBoard(SudokuBoard sudokuBoard) {
        ArrayList<SudokuPart> squares = createSquares(sudokuBoard);
        for (int j = 0; j < 9; j++) {
            SudokuPart row = sudokuBoard.getBoard().get(j);
            divideRowsToSquares(row, squares);
        }
    }

    private ArrayList<SudokuPart> createSquares(SudokuBoard sudokuBoard) {
        ArrayList<SudokuPart> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            SudokuPart sudokuSquare = new SudokuPart(i + 19);
            sudokuBoard.addPartToBoard(sudokuSquare);
            squares.add(sudokuSquare);
        }
        return squares;
    }

    private void divideRowsToSquares(SudokuPart row, ArrayList<SudokuPart> squares) {
        if (row.getName() < 3) {
            elementsAddToSquares(row,squares.get(0), squares.get(1), squares.get(2));
        } else if (row.getName() < 6) {
            elementsAddToSquares(row, squares.get(3), squares.get(4), squares.get(5));
        } else {
            elementsAddToSquares(row, squares.get(6), squares.get(7), squares.get(8));
        }
    }

    private void elementsAddToSquares(SudokuPart sudokuPart,SudokuPart square1,SudokuPart square2,SudokuPart square3){
        for (int j = 0; j < 3; j++) {
            square1.addElementToRow(sudokuPart.getLineOfElements().get(j));
            square2.addElementToRow(sudokuPart.getLineOfElements().get(j + 3));
            square3.addElementToRow(sudokuPart.getLineOfElements().get(j + 6));
        }
    }
}

