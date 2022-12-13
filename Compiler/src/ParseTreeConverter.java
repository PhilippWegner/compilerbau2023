import java.util.ArrayList;

public class ParseTreeConverter {

    // create a method that gets a list of tokens and orders them into a parse tree
    // tokens consist of numbers and the operator +

    public static ArrayList<Token> convertToParseTree(ArrayList<Token> tokens) {
        // create a parse tree
        ArrayList<Token> parseTree = new ArrayList<Token>();
        // create a stack
        ArrayList<Token> stack = new ArrayList<Token>();

        // if a number follows a number, interpret them as a single number
        // else proceed as normal
        for(int i = 0; i < tokens.size(); i++) {
            if(tokens.get(i) == Token.Number){
                if(parseTree.isEmpty() || parseTree.get(parseTree.size()-1) != Token.Number) {
                    parseTree.add(Token.Number);
                }
            } else{
                parseTree.add(tokens.get(i));

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
    public static void printParseTree(ArrayList<Token> parseTree) {
        int level = 0;
        String tab = "";
        for (int i = 0; i < parseTree.size(); i++) {
            for (int j = 0; j < level; j++) {
                tab += " ";
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
