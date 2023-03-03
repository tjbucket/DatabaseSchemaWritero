import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        Scanner userInput = new Scanner(System.in);
        File inputFile;
        File outputFile;
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


    }
    
}
