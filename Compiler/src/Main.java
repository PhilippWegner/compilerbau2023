import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TokenScanner scanner = new TokenScanner("resources/input.txt");
        scanner.scan();
        System.out.println("Input: "+ scanner.input+"\n");
        ArrayList<Token> tokens = scanner.tokenize();

        System.out.println("Tokens: \n");
        for(Token t : tokens)
        {
            System.out.println(t);
        }

        System.out.println("Tokens: \n");
        ArrayList<Character> chars =scanner.split();
        for(Character c : chars)
        {
            System.out.println(c);
        }
    }
}