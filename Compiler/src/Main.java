import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TokenScanner scanner = new TokenScanner("C:\\Users\\Dominik\\IdeaProjects\\compilerbau2023\\Compiler\\resources\\input.txt");
        scanner.scan();
        System.out.println("Input: "+ scanner.input+"\n");
        ArrayList<Token> tokens = scanner.tokenize();
        System.out.println("Tokens: \n");

        for(Token t : tokens)
        {
            System.out.println(t);
        }

    }
}