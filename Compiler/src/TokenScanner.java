import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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

    public HashMap<Token,String> tokenize()
    {
        HashMap<Token,String> tokenArrayList = new HashMap<>();
        for(Character token : input.toCharArray())
        {
            Token tokenType = identify(token);
            if(!tokenType.equals(Token.Whitespace)) // Skip Whitespaces
                tokenArrayList.put(tokenType,token.toString());
        }
        return tokenArrayList;
    }
    public HashMap<Token,String> tokenizeTest(){
        /* return a list of tokens for the file
        start
        555 + 5 + 5 + 5
        end
         */
        HashMap<Token,String> tokenArrayList = new HashMap<>();
        tokenArrayList.put(Token.Invalid,"?");
        tokenArrayList.put(Token.Number,"5");
        tokenArrayList.put(Token.Number,"5");
        tokenArrayList.put(Token.Number,"5");
        tokenArrayList.put(Token.Add,"+");
        tokenArrayList.put(Token.Number,"5");
        tokenArrayList.put(Token.Add,"+");
        tokenArrayList.put(Token.Number,"5");
        tokenArrayList.put(Token.Add,"+");
        tokenArrayList.put(Token.Number,"5");
        tokenArrayList.put(Token.End,"end");
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
