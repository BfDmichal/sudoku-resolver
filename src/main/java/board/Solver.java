package board;



public class Solver {
    public static void solveCase(SudokuBoard sudokuBoard){
        while (!sudokuBoard.checkIsSolved()){
        for (int i = 0; i < 27; i++) {
            SudokuPart sudokuPart = sudokuBoard.getPartByName(i);
//            sudokuPart.checkRepeatsAndDelete();
        }
        }
    }
}
