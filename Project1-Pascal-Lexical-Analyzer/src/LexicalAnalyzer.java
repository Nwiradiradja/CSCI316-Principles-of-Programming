//Nathaniel Wiradiradja
//Ariel Matatov
//CSCI 316 Project 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    // Define the list of reserved words
    private static final List<String> RESERVED_WORDS = Arrays.asList(
            "and", "array", "begin", "case", "const", "div", "do", "downto", "else", "end", "file", "for", "function",
            "goto", "if", "in", "label", "mod", "nil", "not", "of", "or", "packed", "procedure", "program", "record",
            "repeat", "set", "then", "to", "type", "until", "var", "while", "with"
    );

    // Define the list of operators
    private static final List<Token> OPERATORS = Arrays.asList(
            new Token(TokenType.ADD_OP, "+"),
            new Token(TokenType.SUB_OP, "-"),
            new Token(TokenType.MUL_OP, "*"),
            new Token(TokenType.DIV_OP, "/"),
            new Token(TokenType.MOD_OP, "MOD"),
            new Token(TokenType.MOD_OP, "%"),
            new Token(TokenType.AND_OP, "and"),
            new Token(TokenType.OR_OP, "or"),
            new Token(TokenType.NOT_OP, "not"),
            new Token(TokenType.LT_OP, "<"),
            new Token(TokenType.LE_OP, "<="),
            new Token(TokenType.GT_OP, ">"),
            new Token(TokenType.GE_OP, ">="),
            new Token(TokenType.EQ_OP, "="),
            new Token(TokenType.NE_OP, "<>"),
            new Token(TokenType.ASSIGN_OP, ":="),
            new Token(TokenType.LPAREN, "("),
            new Token(TokenType.RPAREN, ")")

    );

    // Define the regular expressions for identifying tokens
    private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
  //private static final Pattern COMMENT_PATTERN = Pattern.compile("\\(\\*.*?\\*\\)"); -> May Possibly Not Need


    
    public static List<Token> tokenize(String statement) {
        List<Token> tokens = new ArrayList<>();
        while (!statement.isEmpty()) {
            Matcher matcher = null;

            // Check for whitespace
            matcher = WHITESPACE_PATTERN.matcher(statement);
            if (matcher.lookingAt()) {
                statement = statement.substring(matcher.end());
                continue;
            }
            //Check for Comment -> May possibly Not need
          /*  matcher = COMMENT_PATTERN.matcher(statement);
            if (matcher.lookingAt()) {
            	tokens.add(new Token(TokenType.COMMENT, matcher.group()));
                statement = statement.substring(matcher.end());
                continue;
            }*/
            
            // Check for reserved words or identifiers
            for (String word : RESERVED_WORDS) {
                if (statement.startsWith(word)) {
                    tokens.add(new Token(TokenType.valueOf(word.toUpperCase()), word));
                    statement = statement.substring(word.length());
                    break;
                }
            }
            if (matcher == null || !matcher.lookingAt()) {
                matcher = IDENTIFIER_PATTERN.matcher(statement);
                if (matcher.lookingAt()) {
                    tokens.add(new Token(TokenType.IDENTIFIER, matcher.group()));
                    statement = statement.substring(matcher.end());
                    continue;
                }
            }

            // Check for operators
            for (Token op : OPERATORS) {
                if (statement.startsWith(op.getLexeme())) {
                    tokens.add(op);
                    statement = statement.substring(op.getLexeme().length());
                    break;
                }
            }
            if (matcher == null || !matcher.lookingAt()) {
                // Check for numbers
                matcher = NUMBER_PATTERN.matcher(statement);
                if (matcher.lookingAt()) {
                    tokens.add(new Token(TokenType.NUMBER, matcher.group()));
                    statement = statement.substring(matcher.end());
                    continue;
                }
            }

         // If none of the above match, the token is unknown
            tokens.add(new Token(TokenType.UNKNOWN, statement.substring(0, 1)));
            statement = statement.substring(1);
            } // Add this closing bracket
            return tokens;
            }
    
    
}