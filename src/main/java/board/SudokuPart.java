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

    @Override
    public String toString() {
        return lineOfElements.toString().replaceAll(",", "|")
                + "\n--------------------------";
    }
}
