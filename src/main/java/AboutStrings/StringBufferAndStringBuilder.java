package AboutStrings;

public class StringBufferAndStringBuilder {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Selenium");
        stringBuffer.append(" Automation");
        System.out.println(stringBuffer);

        StringBuilder stringBuilder = new StringBuilder("Appium");
        stringBuilder.append(" Automation");
        System.out.println(stringBuilder);
    }
}
