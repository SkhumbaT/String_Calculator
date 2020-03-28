import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

public class Calculator {


    public static void main(String[] args) throws Exception {
        out.println (add(""));
        out.println (add("1"));
        out.println (add("1,1"));
        out.println (add("1,2,3,4"));
        out.println (add("1\n2,3"));
        out.println (add("//;\n1;2"));
        out.println (add("//4\n142"));
        out.println (add("-1,-2,3,4"));
        out.println (add("1000,1,2"));
        out.println (add ("//;\n1000;1;2;"));
        out.println (add("//;;%;;\n1;2"));
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static int getSum(String numbers) throws Exception {
        int sum = 0;
        String [] numberArr = getSplittedString(numbers);
        if(numberArr.length > 1) {
            for(String s: numberArr) {
                if(toInt(s) <= 999){
                    sum += toInt(s);
                }
            }
            return sum;
        }
        return toInt(numbers);
    }

    private static String [] getSplittedString(String numbers) {
        String splitter = "";
    if (numbers.startsWith ("//")) {
        splitter = numbers.substring (2, 3);
        numbers = numbers.substring (numbers.indexOf ("\n") + 1);

    } else {
               splitter = ",|\n";
   }
    return numbers.split (splitter);
}

    private static boolean Validation(String numbers) throws Exception {
        String[] numberArr = getSplittedString (numbers);
        boolean exceptions = true;
        StringBuilder Stringerror = new StringBuilder ( );
        try {
            for (int i = 0; i < numberArr.length; i++) {
                if (toInt (numberArr[i]) < 0) {
                    Stringerror.append (numberArr[i]).append (",");
                    exceptions = false;
                }
            }
            if (!exceptions) {
                Stringerror = new StringBuilder (Stringerror.substring (0, Stringerror.length ( ) - 1));
                throw new Exception ("ERROR: negatives not allowed " + Stringerror);
            }
                Pattern sPattern = Pattern.compile ("//;\n1000;1;2;");
                Matcher sMatcher = sPattern.matcher (numbers);
                if (sMatcher.matches ( )) {
                    throw new Exception ("ERROR: invalid input");
                }
            } catch (Exception e) {
                out.println (e);
            }
            return exceptions;
        }

    public static int add(String numbers) throws Exception {
        if(numbers.isEmpty()) {return 0;}
        Validation (numbers);

        return getSum (numbers);
    }

}