//Nathaniel Wiradiradja
//Ariel Matatov
//CSCI 316 Project 1

public class TokenType {
    public static final TokenType IDENTIFIER = new TokenType("IDENTIFIER");
  //public static final TokenType COMMENT = new TokenType("COMMENT"); -> May Possibly Not Need
    public static final TokenType NUMBER = new TokenType("NUMBER");
    public static final TokenType ADD_OP = new TokenType("ADD_OP");
    public static final TokenType SUB_OP = new TokenType("SUB_OP");
    public static final TokenType MUL_OP = new TokenType("MUL_OP");
    public static final TokenType DIV_OP = new TokenType("DIV_OP");
    public static final TokenType MOD_OP = new TokenType("MOD_OP");
    public static final TokenType AND_OP = new TokenType("AND_OP");
    public static final TokenType OR_OP = new TokenType("OR_OP");
    public static final TokenType NOT_OP = new TokenType("NOT_OP");
    public static final TokenType LT_OP = new TokenType("LT_OP");
    public static final TokenType LE_OP = new TokenType("LE_OP");
    public static final TokenType GT_OP = new TokenType("GT_OP");
    public static final TokenType GE_OP = new TokenType("GE_OP");
    public static final TokenType EQ_OP = new TokenType("EQ_OP");
    public static final TokenType NE_OP = new TokenType("NE_OP");
    public static final TokenType ASSIGN_OP = new TokenType("ASSIGN_OP");
    public static final TokenType UNKNOWN = new TokenType("UNKNOWN");
    public static final TokenType LPAREN = new TokenType("LPAREN");
    public static final TokenType RPAREN = new TokenType("RPAREN");
    

    

    private String name;

    private TokenType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
  

	public static TokenType valueOf(String upperCase) {
		// TODO Auto-generated method stub
		return null;
	}
}
