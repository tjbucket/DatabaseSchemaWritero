import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        Scanner userInput = new Scanner(System.in);
        File inputFile;
        File outputFile;
        String tableName;
        System.out.println("Welcome to Database Schema Writero. Currently, this program only does insert statements.");
        while(true) {
            System.out.println("To begin, please input the path of the file you want to read.");
            inputFile = new File(userInput.nextLine());
            if (!inputFile.exists()) {
                System.out.println("File was not found. Please enter a new path.");
                continue;
            }
            break;
        }
        inputReader.setFile(inputFile);
        while(true) {
            System.out.println("Next, please input the path of the file you want to write the insert statement into.");
            outputFile = new File(userInput.nextLine());
            if (!outputFile.exists()) {
                System.out.println("File was not found. Please enter a new path.");
                continue;
            }
            break;
        }
        System.out.println("Finally, please input the name of the table to insert the values into.");
        tableName = userInput.nextLine();
        outputWriter.setFile(outputFile);
        outputWriter.setTableName(tableName);
        outputWriter.listHandler(inputReader.getAllLinesFromFile());
        System.out.println("Done!");



    }

}
