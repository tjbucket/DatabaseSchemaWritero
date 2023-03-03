import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    private File file;

    public List<String> getAllLinesFromFile(){
        List<String> lines = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
