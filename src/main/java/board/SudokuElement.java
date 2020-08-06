package board;

import java.util.ArrayList;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value = EMPTY;
    private ArrayList<Integer> possibleValues;

    public SudokuElement() {
        this.possibleValues = new ArrayList<>();
        basicPossibleValues();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void deleteFromPossibleValues(Integer value) {
        possibleValues.remove(value);
    }

    public boolean elementHasNumber() {
        return getValue() != EMPTY;
    }

    private void basicPossibleValues() {
        if (!elementHasNumber()) {
            for (int i = 1; i < 10; i++) {
                possibleValues.add(i);
            }
        }
    }

    public void setOnlyPossibleValue() {
        if (this.possibleValues.size() == 1) {
            value = possibleValues.get(0);
        }
    }

    @Override
    public String toString() {
        return value + "";
    }
}
