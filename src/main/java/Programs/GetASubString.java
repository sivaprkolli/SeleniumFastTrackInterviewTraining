package Programs;

public class GetASubString {
    public static void main(String[] args) {
        String message = "Welcome to training program and $10k payment";
       // String text1 = dri.getText();
        int index1 = message.indexOf("$");
        System.out.println(index1);
        String subMessage = message.substring(index1);
        System.out.println(subMessage + " <-- subMessage");
        int index2 = subMessage.indexOf("k") ;
        System.out.println(index2);
        String actualMessage = subMessage.substring(0, index2);
        System.out.println(actualMessage);
        String code[] = actualMessage.split(" ");
        String otp = code[1];
        System.out.println("OTP :: " + otp.trim());

    }


    public void test(){
        String message = "Hello,You recently attempted to register a new iD Mobile account. Browser: Mobile Chrome Operating System: Android 10.0To confirm your account, let's verify your identity. Enter the following code where prompted.Verification Code: 611889";
        int index1 = message.indexOf(":");
        System.out.println(index1);
        String subMessage = message.substring(index1);
        System.out.println(subMessage);
        int index2 = subMessage.indexOf("k") ;
        System.out.println(index2);
        String actualMessage = subMessage.substring(0, index2);
        System.out.println(actualMessage);
    }
}

