import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TokenScanner {
    public String path;

    public String input = "";

    public TokenScanner(String path) {
        this.path = path;
    }

    public void scan() {

        StringBuilder sb = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(this.path))) {
            while(scanner.hasNextLine()){
                sb.append(scanner.nextLine());
            }
        }catch (FileNotFoundException e) {
            System.err.println("File not Found");
            e.printStackTrace();
        }
        this.input = sb.toString();
    }

    public ArrayList<Token> tokenize()
    {
        ArrayList<Token> tokenArrayList = new ArrayList<>();
        for(char token : input.toCharArray())
        {
            Token t = identify(token);
            if(!t.equals(Token.Whitespace)) // Skip Whitespaces
                tokenArrayList.add(t);
        }
        return tokenArrayList;
    }
    public ArrayList<Token> tokenizeTest(){
        /* return a list of tokens for the file
        start
        555 + 5 + 5 + 5
        end
         */
        ArrayList<Token> tokenArrayList = new ArrayList<>();
        tokenArrayList.add(Token.Invalid);
        tokenArrayList.add(Token.Number);
        tokenArrayList.add(Token.Number);
        tokenArrayList.add(Token.Number);
        tokenArrayList.add(Token.Add);
        tokenArrayList.add(Token.Number);
        tokenArrayList.add(Token.Add);
        tokenArrayList.add(Token.Number);
        tokenArrayList.add(Token.Add);
        tokenArrayList.add(Token.Number);
        tokenArrayList.add(Token.End);
        return tokenArrayList;

    }

    public ArrayList<Character> split()
    {
        ArrayList<Character> chars = new ArrayList<>();

        for(char c : input.toCharArray())
        {
            if(!Character.isWhitespace(c))
            {
                chars.add(c);
            }

        }
        return chars;
    }

    private Token identify(char token) {
        return switch(token) {
            case '+' -> Token.Add;
            case '-' -> Token.Subtract;
            case '*' -> Token.Multiply;
            case '/' -> Token.Divide;
            case '(' -> Token.LeftParenthesis;
            case ')' -> Token.RightParenthesis;
            case ' ' -> Token.Whitespace;
            default -> checkForOther(token);
        };
    }

    private Token checkForOther(char token) {
        Token identifiedToken = Token.Invalid;
        if(Character.isDigit(token))
        {
            identifiedToken = Token.Number;
        } else if (Character.isAlphabetic(token)) {
            identifiedToken = Token.Letter;
        }

        return identifiedToken;
    }
}
