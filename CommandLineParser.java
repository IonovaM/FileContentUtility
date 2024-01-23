import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {
    private boolean flagShortStats = false;
    private boolean flagFullStats = false;
    private String outputPath = "./";
    private String filePrefix = "";
    private boolean addMode = false;
    private List<String> fileArgs = new ArrayList<>();

    public CommandLineParser(String[] args) {
        parseCommandLineArguments(args);
    }

    private void parseCommandLineArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-s":
                    flagShortStats = true;
                    break;
                case "-f":
                    flagFullStats = true;
                    break;
                case "-o":
                    outputPath = args[++i];
                    break;
                case "-p":
                    filePrefix = args[++i];
                    break;
                case "-a":
                    addMode = true;
                    break;
                default:
                    fileArgs.add(args[i]);
                    break;
            }
        }
    }

    public boolean getFlagShortStats() {return flagShortStats;}
    public boolean getFlagFullStats() {return flagFullStats;}
    public String getOutputPath() {return outputPath;}
    public String getFilePrefix() {return filePrefix;}
    public boolean getAddMode() {return addMode;}
    public List<String> getFileArgs() {return fileArgs;}
}
