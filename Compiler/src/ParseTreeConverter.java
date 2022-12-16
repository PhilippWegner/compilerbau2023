import java.util.ArrayList;

public class ParseTreeConverter {

    // create a method that gets a list of tokens and orders them into a parse tree
    // tokens consist of numbers and the operator +

    public  ArrayList<Token> convertToParseTree(ArrayList<Token> tokens) {
        // create a parse tree
        ArrayList<Token> parseTree = new ArrayList<Token>();
        // create a stack
        ArrayList<Token> stack = new ArrayList<Token>();
        // check if the tokens contains Token.Invalid
        if (tokens.contains(Token.Invalid)) {
            // if it does, return an error Message
            System.out.println("Error: Invalid Token");
            return null;
        }
        for (int i= 0; i < tokens.size(); i++){
            Token currentToken = tokens.get(i);
            if (currentToken == Token.Start){
                parseTree.add(Token.Start);
            } else if (currentToken == Token.End) {
                parseTree.add(Token.End);
            } else if (currentToken == Token.Number) {
                if (tokens.get(i + 1) == Token.Add) {
                    parseTree.add(Token.Number);
                }
            } else if (currentToken == Token.Add) {
                if (tokens.get(i + 1) == Token.Number) {
                    parseTree.add(Token.Add);
                }
            }
        }

        return parseTree;
    }

    /* create a method that outputs the parse tree in the following format
            number
            /    \
        number    +
                /   \
            number   *
                    /   \
                number   number

    */
    public void printParseTree(ArrayList<Token> parseTree) {
        int level = 0;
        String tab = "";
        if (parseTree == null) {
            System.out.println("Error: Equation is invalid");
            return;
        }
        for (int i = 0; i < parseTree.size(); i++) {
            tab += " ";

            if (parseTree.get(i) == Token.Start){
                System.out.println(tab + "start");
                System.out.println(tab + "  |");
            }
            if (parseTree.get(i) == Token.End){
                System.out.println(tab + "end");
            }
            if (parseTree.get(i) == Token.Number) {
                System.out.println(tab + "  number");
            }
            if (parseTree.get(i) == Token.Add) {
                System.out.println(tab + "  /  \\");
                System.out.println(tab + "number add");
                System.out.println(tab + "        \\");
            }
            level++;
        }
    }
}
