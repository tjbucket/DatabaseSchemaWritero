
import java.io.*;
import java.util.List;

public class OutputWriter {

    private File file;
    private String tableName;

    public void listHandler (List<String> lines){
        outputToFile("INSERT INTO " + tableName + " ", false);
        for (int i = 0; i < lines.size(); i++) {
            outputToFile(convertToValues(lines.get(i)), false);
            if (i == 0){
                outputToFile(" VALUES ", false);
            }
            if (i != lines.size()-1 && i > 0){
                outputToFile(",",true);
            } else if (i == lines.size()-1) {
                outputToFile(";", false);
            }
        }
    }

    public void outputToFile(String string, boolean newLineNeeded){
        try(FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter writer = new BufferedWriter(fileWriter)){

            writer.append(string);

            if (newLineNeeded) {
                writer.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String convertToValues(String line) {
        String[] strings = line.split("\\|");
        StringBuilder valueStarter = new StringBuilder("(");
        for (int i = 0; i < strings.length; i++) {
            valueStarter.append(strings[i]);
            if (i < strings.length-1){
                valueStarter.append(",");
            }
        }
        valueStarter.append(")");
        return valueStarter.toString();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
