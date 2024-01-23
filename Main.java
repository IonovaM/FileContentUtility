import java.io.*;
import java.util.List;

public class Main {
    private static boolean flagShortStats = false;
    private static boolean flagFullStats = false;
    private static String outputPath = "./";
    private static String filePrefix = "";
    private static boolean addMode= false;

    private static DataClassifier dataClassifier;

    public static void main(String[] args) {
        try {
            CommandLineParser commandLineParser = new CommandLineParser(args);
            parseCommandLineArguments(commandLineParser);

            FileHandler fileHandler = new FileHandler(dataClassifier, outputPath, filePrefix, addMode);
            fileHandler.processFiles(commandLineParser.getFileArgs());

            StatisticsPrinter statisticsPrinter = new StatisticsPrinter(dataClassifier, flagShortStats, flagFullStats);
            statisticsPrinter.printStatistics();
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static boolean getFlagShortStats() {
        return flagShortStats;
    }

    public static boolean getFlagFullStats() {
        return flagFullStats;
    }

    public static String getOutputPath() {
        return outputPath;
    }

    public static String getFilePrefix() {
        return filePrefix;
    }

    public static boolean getAddMode() {
        return addMode;
    }

    private static void parseCommandLineArguments(CommandLineParser parser) {
        flagShortStats = parser.getFlagShortStats();
        flagFullStats = parser.getFlagFullStats();
        outputPath = parser.getOutputPath();
        filePrefix = parser.getFilePrefix();
        addMode = parser.getAddMode();

        dataClassifier = new DataClassifier();
    }
}