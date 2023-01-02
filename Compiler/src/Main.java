import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        TokenScanner scanner = new TokenScanner("Compiler\\resources\\input.txt");
        scanner.scan();
        System.out.println("Input: "+ scanner.input+"\n");
        HashMap<Token, String> tokens = scanner.tokenizeTest();
        //System.out.println("Tokens: \n");
        ParseTreeConverter converter = new ParseTreeConverter();
        ArrayList<Token> parseTree = converter.convertToParseTree(tokens);
        converter.printParseTree(parseTree);





    }
}