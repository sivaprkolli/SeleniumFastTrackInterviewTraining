package JavaPrograms;

public class ReverseAString {

    public static void main(String[] args) {
        String tool = "Selenium";
        String reverse = "";

        String mobileTool = "Appium";
        char c[] = mobileTool.toCharArray();

        for(int i=tool.length()-1; i>=0; i--){
            reverse = reverse + tool.charAt(i);
        }

        for(int j=c.length -1 ; j>=0; j--){
            System.out.println(c[j]);
        }
        System.out.println("reverse :: " + reverse);
    }
}
