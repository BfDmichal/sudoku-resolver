package board;

import java.util.ArrayList;

public class SudokuElement {
    private final int name;
    public static final int EMPTY = -1;
    private int value = EMPTY;
    private ArrayList<Integer> possibleValues;

    public SudokuElement(int name) {
        this.name = name;
        this.possibleValues = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void deleteFromPossibleValues(int value) {
        possibleValues.remove(value);
    }

    public boolean elementHasNumber() {
        return getValue() != -1;
    }

//    private ArrayList<Integer> basicPossibleValues() {
//        if (!elementHasNumber()) {
//            for (int i = 1; i < 9; i++) {
//                possibleValues.add(i);
//            }
//        }
//        return possibleValues;
//    }
    public void setOnlyPossibleValue(){
        if(possibleValues.size()==1){
            value= possibleValues.get(0);
        }
    }

    @Override
    public String toString() {
        return value + "";
    }
}
