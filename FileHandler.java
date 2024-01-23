import java.io.*;
import java.util.*;

public class FileHandler {
    private DataClassifier dataClassifier;
    private String outputPath;
    private String filePrefix;
    private boolean addMode;
    private String DEFAULT_INTEGERS_FILE_NAME = "integers.txt";
    private String DEFAULT_FLOATS_FILE_NAME = "floats.txt";
    private String DEFAULT_STRINGS_FILE_NAME = "strings.txt";

    public FileHandler(DataClassifier dataClassifier, String outputPath, String filePrefix, boolean addMode) {
        this.dataClassifier = dataClassifier;
        this.outputPath = outputPath;
        this.filePrefix = filePrefix;
        this.addMode = addMode;
    }

    public void processFiles(List<String> fileArgs) {
        for (String fileArg : fileArgs) {
            try (FileInputStream fin = new FileInputStream(fileArg);
                 InputStreamReader inr = new InputStreamReader(fin);
                 BufferedReader reader = new BufferedReader(inr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    dataClassifier.classifyLine(line);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Файл не найден: " + fileArg);
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла: " + fileArg);
            }
        }
        try {
            writeToFile(dataClassifier.getIntegers(), DEFAULT_INTEGERS_FILE_NAME);
            writeToFile(dataClassifier.getFloats(), DEFAULT_FLOATS_FILE_NAME);
            writeToFile(dataClassifier.getStrings(), DEFAULT_STRINGS_FILE_NAME);
        } catch (IOException e) {
            System.err.println("Ошибка записи результатов: " + e.getMessage());
        }
    }

    private void writeToFile(List<?> data, String fileName) throws IOException {
        if (data.isEmpty()) {
            return;
        }

        String filePath = outputPath + File.separator + filePrefix + fileName;
        try (FileOutputStream fout = new FileOutputStream(filePath, addMode);
             OutputStreamWriter outw = new OutputStreamWriter(fout);
             BufferedWriter writer = new BufferedWriter(outw)) {
            for (Object i : data) {
                writer.write(i.toString());
                writer.newLine();
            }
        }
    }
}