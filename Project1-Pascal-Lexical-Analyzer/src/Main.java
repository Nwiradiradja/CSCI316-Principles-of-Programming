//Nathaniel Wiradiradja
//Ariel Matatov
//CSCI 316 Project 1

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Read input from file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Nate\\eclipse-workspace\\316Project1\\src\\code.txt"));
            String input = "";
            String line;
            while ((line = reader.readLine()) != null) {
                input += line + "\n";
            }

            // Tokenize input
            List<Token> tokens = LexicalAnalyzer.tokenize(input);

            // Print tokens
            for (Token token : tokens) {
                System.out.println("Next Token is: " + token.getType() + ", Next Lexeme is: " + token.getLexeme());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
