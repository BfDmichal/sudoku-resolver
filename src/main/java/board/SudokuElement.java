package board;

import java.util.ArrayList;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value = EMPTY;
    private ArrayList<Integer> possibleValues;

    public SudokuElement() {
        this.possibleValues = basicPossibleValues();
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

    public boolean elementHasNotNumber() {
        return getValue() == EMPTY;
    }

    private ArrayList<Integer> basicPossibleValues() {
        ArrayList<Integer> listWithPossibleValues = new ArrayList<>();
        if (elementHasNotNumber()) {
            for (int i = 1; i < 10; i++) {
                listWithPossibleValues.add(i);
            }
        }
        return listWithPossibleValues;
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
