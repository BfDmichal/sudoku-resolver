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

    public void addElementToRow(SudokuElement element) {
        lineOfElements.add(element);
    }

//    public void checkRepeatsAndDelete() {
//        ArrayList<Integer> listToDelete = new ArrayList<>();
//        for (int i = 0; i < lineOfElements.size() - 1; i++) {
//            SudokuElement sudokuElement = lineOfElements.get(i);
//            if (sudokuElement.elementHasNumber()) {
//                listToDelete.add(sudokuElement.getValue());
//            }
//        }
//        lineOfElements = deleteFromPossibleValuesInPart(listToDelete);
//        checkPossibleValuesAndSetElementItHasOnlyOne();
////        return lineOfElements;
//    }
//
//    private ArrayList<SudokuElement> deleteFromPossibleValuesInPart(ArrayList<Integer> listToDelete) {
//        for (int i = 0; i < listToDelete.size() - 1; i++) {
//            SudokuElement sudokuElement = lineOfElements.get(i);
//            sudokuElement.deleteFromPossibleValues(listToDelete.get(i));
//        }
//        return lineOfElements;
//    }
//
//    private void checkPossibleValuesAndSetElementItHasOnlyOne() {
//        ArrayList<SudokuElement> elements = lineOfElements;
//        for (SudokuElement element :
//                elements) {
//            element.setOnlyPossibleValue();
//        }
//    }

    @Override
    public String toString() {
        return lineOfElements.toString().replaceAll(",", "|")
                + "\n--------------------------";
    }
}
