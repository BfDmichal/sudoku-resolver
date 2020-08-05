package board;

import java.util.Set;
import java.util.stream.Collectors;

public class BoardOperator {

    public void checkRepeatsAndDelete(SudokuBoard board) {

        for (SudokuPart part :
                board.getBoard()) {
            checkRepeatsInParts(part);

        }
    }

    private void checkRepeatsInParts(SudokuPart part) {
        Set<Integer> listToDelete = part.getLineOfElements().stream()
                .filter(sudokuElement -> sudokuElement.getValue() != 1)
                .map(SudokuElement::getValue)
                .collect(Collectors.toSet());
        deleteRepeatsFromLine(listToDelete, part);
        setSinglePossibleNumberInField(part);
    }

    private void deleteRepeatsFromLine(Set<Integer> duplicatedNumbers, SudokuPart part) {
        for (SudokuElement element :
                part.getLineOfElements()) {
            for (Integer number :
                    duplicatedNumbers) {
                element.deleteFromPossibleValues(number);
            }
        }
    }

    private void setSinglePossibleNumberInField(SudokuPart part) {
        for (SudokuElement element :
                part.getLineOfElements()) {
            element.setOnlyPossibleValue();
        }
    }
}