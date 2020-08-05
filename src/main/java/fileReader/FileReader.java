package fileReader;

import board.SudokuBoard;
import board.SudokuPart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader {
    public void readFile(SudokuBoard board) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/sudoku.txt").getFile());


        try {
            Scanner scanner = new Scanner(file);
//            SudokuBoard sudokuBoard = new SudokuBoard();
            for (int i = 0; i < 9; i++) {
                SudokuPart row = board.getPartByName(i);
                for (int j = 0; j < 9; j++) {
                    int value = scanner.nextInt();
                    row.getLineOfElements().get(j).setValue(value);
                }
                if(scanner.hasNextLine()){
                scanner.nextLine();}

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
