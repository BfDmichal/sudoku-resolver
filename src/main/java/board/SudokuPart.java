package board;

import java.util.ArrayList;

public class SudokuPart {
    private final int name;
    private ArrayList<SudokuElement> lineOfElements;

    public SudokuPart(int name) {
        this.name = name;
        this.lineOfElements = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public ArrayList<SudokuElement> getLineOfElements() {
        return lineOfElements;
    }
    public void addElementToRow(SudokuElement element){
        lineOfElements.add(element);
    }

    public ArrayList<SudokuElement> checkRepeatsAndDelete() {
        ArrayList<Integer> listToDelete = new ArrayList<>();
        for (int i = 0; i < lineOfElements.size() - 1; i++) {
            SudokuElement sudokuElement = lineOfElements.get(i);
            if (sudokuElement.getValue() != -1) {
                listToDelete.add(sudokuElement.getValue());
            }
        }
        lineOfElements = deleteFromRow(listToDelete);
        return lineOfElements;
    }

    private ArrayList<SudokuElement> deleteFromRow(ArrayList<Integer> listToDelete) {
        for (int i = 0; i < listToDelete.size() - 1; i++) {
            SudokuElement sudokuElement = lineOfElements.get(i);
            sudokuElement.deleteFromPossibleValues(listToDelete.get(i));
        }
        return lineOfElements;
    }

    @Override
    public String toString() {
        return  lineOfElements.toString().replaceAll(",","|")
        + "\n--------------------------";
    }
}
