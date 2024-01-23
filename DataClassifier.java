import java.util.*;

public class DataClassifier {
    private List<Integer> integers;
    private List<Float> floats;
    private List<String> strings;

    private int countIntegers;
    private int countFloats;
    private int countStrings;

    private float minValue;
    private float maxValue;
    private float sumNumbers;

    private int minStringLength;
    private int maxStringLength;

    public DataClassifier() {
        integers = new ArrayList<>();
        floats = new ArrayList<>();
        strings = new ArrayList<>();
        
        countIntegers = 0;
        countFloats = 0;
        countStrings = 0;
        
        minValue = Float.MAX_VALUE;
        maxValue = Float.MIN_VALUE;
        sumNumbers = 0;
        
        minStringLength = Integer.MAX_VALUE;
        maxStringLength = Integer.MIN_VALUE;
    }

    public void classifyLine(String line) {
        try {
            int intValue = Integer.parseInt(line);
            integers.add(intValue);
            countIntegers++;
            sumNumbers += intValue;
            minValue = Math.min(minValue, intValue);
            maxValue = Math.max(maxValue, intValue);
        } catch (NumberFormatException e) {
            try {
                float floatValue = Float.parseFloat(line);
                floats.add(floatValue);
                countFloats++;
                sumNumbers += floatValue;
                minValue = Math.min(minValue, floatValue);
                maxValue = Math.max(maxValue, floatValue);
            } catch (NumberFormatException ex) {
                strings.add(line);
                countStrings++;
                minStringLength = Math.min(minStringLength, line.length());
                maxStringLength = Math.max(maxStringLength, line.length());
            }
        }
    }

    public List<Integer> getIntegers() {return integers;}
    public List<Float> getFloats() {return floats;}
    public List<String> getStrings() {return strings;}
    public int getCountIntegers() {return countIntegers;}
    public int getCountFloats() {return countFloats;}
    public int getCountStrings() {return countStrings;}
    public float getMinValue() {return minValue;}
    public float getMaxValue() {return maxValue;}
    public float getSumNumbers() {return sumNumbers;}
    public int getMinStringLength() {return minStringLength;}
    public int getMaxStringLength() {return maxStringLength;}
}
