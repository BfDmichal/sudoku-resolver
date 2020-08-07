package boardSolver;

import board.SudokuBoard;
import board.SudokuElement;
import board.SudokuPart;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardOperator {

    public SudokuBoard checkRepeatsAndDelete(SudokuBoard board) {
        for (SudokuPart part :
                board.getBoard()) {
            ArrayList<SudokuElement> allElementsInPart = part.getLineOfElements();
            Set<Integer> listToDelete = checkRepeatsInParts(allElementsInPart);
            ArrayList<SudokuElement> listToFill = chooseElementsWhichHasNotNumbers(allElementsInPart);
            deleteRepeatsFromEmptyFields(listToDelete, listToFill);
            setSinglePossibleNumberInField(allElementsInPart);
        }
        return board;
    }

    private Set<Integer> checkRepeatsInParts(ArrayList<SudokuElement> part) {
        Set<Integer> listToDelete = part.stream()
                .filter(sudokuElement -> sudokuElement.getValue() != -1)
                .map(SudokuElement::getValue)
                .collect(Collectors.toSet());
        return listToDelete;
    }

    private void deleteRepeatsFromEmptyFields(Set<Integer> duplicatedNumbers, ArrayList<SudokuElement> part) {
        for (SudokuElement element : part) {
            for (Integer number : duplicatedNumbers) {
                element.deleteFromPossibleValues(number);
            }
        }
    }

    private void setSinglePossibleNumberInField(ArrayList<SudokuElement> part) {
        for (SudokuElement element : part) {
            if (element.elementHasNotNumber())
                element.setOnlyPossibleValue();
        }
    }

    private ArrayList<SudokuElement> chooseElementsWhichHasNotNumbers(ArrayList<SudokuElement> part) {
        ArrayList<SudokuElement> changedPart;
        changedPart = part.stream()
                .filter(SudokuElement::elementHasNotNumber)
                .collect(Collectors.toCollection(ArrayList::new));
        return changedPart;
    }
}