import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LexemeAnalyzer {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/text.txt");
        Scanner sc = new Scanner(file);
        StringBuilder str = new StringBuilder();
        while (sc.hasNextLine()) {
            str.append(sc.nextLine());
            str.append(" ");
        }
        System.out.println("Line to be analyzed: " + str.toString());
        outputLexemes(str.toString());
}

    public static void outputLexemes(String s) {
        int flag = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i)) && flag == 0) {
                start = i;
                flag = 1;
                continue;
            } else if(flag == 1 && !Character.isLetterOrDigit(s.charAt(i))) {
                System.out.println(s.substring(start, i));
                if(s.charAt(i) == ' ') {
                    flag = 0;
                    continue;
                } else {
                    flag = 0;
                    System.out.println(s.charAt(i));
                }
            } else {
                continue;
            }
        }
        System.out.println(s.substring(start, s.length()));
    }
}
