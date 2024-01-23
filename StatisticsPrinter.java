public class StatisticsPrinter {
    private DataClassifier dataClassifier;
    private boolean flagShortStats;
    private boolean flagFullStats;

    public StatisticsPrinter(DataClassifier dataClassifier, boolean flagShortStats, boolean flagFullStats) {
        this.dataClassifier = dataClassifier;
        this.flagShortStats = flagShortStats;
        this.flagFullStats = flagFullStats;
    }

    public void printStatistics() {
        if (flagShortStats) {
            printShortStatistics();
        }

        if (flagFullStats) {
            printFullStatistics();
        }
    }
    
    private void printShortStatistics() {
        System.out.println("Краткая статистика:");
        System.out.println("Количество целых чисел: " + dataClassifier.getCountIntegers());
        System.out.println("Количество вещественныx чисел:" + dataClassifier.getCountFloats());
        System.out.println("Количество строк: " + dataClassifier.getCountStrings());
    }

    private void printFullStatistics() {
        System.out.println("Полная статистика:");
        System.out.println("Количество целых чисел: " + dataClassifier.getCountIntegers());
        System.out.println("Количество вещественныx чисел:" + dataClassifier.getCountFloats());
        System.out.println("Количество строк: " + dataClassifier.getCountStrings());

        if (dataClassifier.getCountFloats() > 0 || dataClassifier.getCountIntegers() > 0) {
            System.out.println("Минимальное значение: " + dataClassifier.getMinValue());
            System.out.println("Максимальное значение: " + dataClassifier.getMaxValue());
            System.out.println("Среднее значение: " + ((float) dataClassifier.getSumNumbers() / 
                (dataClassifier.getCountIntegers() + dataClassifier.getCountFloats())));
        }

        if (dataClassifier.getCountStrings() > 0) {
            System.out.println("Минимальная длина строки: " + dataClassifier.getMinStringLength());
            System.out.println("Максимальная длина строки: " + dataClassifier.getMaxStringLength());
        }
    }
}
