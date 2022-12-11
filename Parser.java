import java.util.ArrayList;

public class Parser {
	
	
	
	
	public int pointer;
	public ArrayList<Token> parsing; //= new ArrayList<Token>();
	

	 Parser (ArrayList<Token> tokens) {
		 parsing = tokens;
		 pointer = 0;
		
		 
		 Token value = parsing.get(pointer);
		 //program starter -> “begin”
		 if(value.lexeme.equals("begin")) {
			 getNextToken();
			 
			 checkStatement();
		 	}else {syntaxError(currentToken(),"line 22");}
		
		 }

	 public  String getNextToken() {
		 if(pointer<parsing.size()-1) {
			 ++pointer;
			 return parsing.get(pointer).lexeme; 
			}
		 else return "end of code";
	 }
	 
	 public String currentToken() {
		 return parsing.get(pointer).lexeme;
	 }
	 
	 public void checkStatement() {
		String current = currentToken(); 
		if(current.equals("word_dec")||current.equals("number_dec")||current.equals("decimal_dec")||current.equals("yorn_dec")) {
			getNextToken();
			
			checkVar();
		}else if(current.equals("variable")) {
			
			checkVar();
		}else if(current.equals("{")){
			
			checkBlock();
		}else if(current.equals("while_loop")) {
			
			checkWhile();
		}else if(current.equals("if")) {
			
			checkSwitch();
		}else if(current.equals("function_dec")) {
			
			checkFunction();
		}else {syntaxError(current,"line 58");}
	 }
	 
	 
	 public void checkVar() {
		 if(currentToken().equals("variable")) {
			 getNextToken();
			 if(currentToken().equals(";")) {
				 getNextToken();
				 checkStatement();
			 }else if(currentToken().equals("=")) {
				 getNextToken();
				 checkExpression();
			 }else syntaxError(currentToken(),"line 72");
		 }
	 }
	 
	 public void checkFunction() {
		 if(currentToken().equals("function_dec")) {
			 getNextToken();
			 if(currentToken().equals("variable")) {
				 getNextToken();
				 if(currentToken().equals("(")) {
					 getNextToken();
					 checkParameter();
					 if(currentToken().equals(")")) {
						 getNextToken();
						 checkBlock();
					 }else if( currentToken().equals(",")) {
				 			getNextToken();
				 			checkParameter();
			 		}else syntaxError(currentToken(),"line 90");
			 	}else syntaxError(currentToken(),"line 92");
		 	}else syntaxError(currentToken(),"line 93");
		 }
	 } 
	 
	 public void checkBlock() {
		 if(currentToken().equals("{")) {
			String current =  getNextToken();
			if(current.equals("word_dec")||current.equals("number_dec")||current.equals("decimal_dec")||current.equals("yorn_dec")) {
				getNextToken();
				checkVar(); 
			
			if(current.equals("while_loop")|| current.equals("variable") || current.equals("if")) {
				 checkStatement();
				 if(currentToken().equals(";")) {
					 getNextToken();
					 checkStatement();
				 } 
				 if (currentToken().equals("}")) {
					 getNextToken();
				 } else syntaxError(currentToken(),"line 116");
			 }
		 }
		 }
		 }	
	 
	
	 public void checkWhile() {
		if(currentToken().equals("while_loop")) {
			getNextToken();
			if( currentToken().equals("(")) {
				getNextToken();
				checkBool();
				if(currentToken().equals(")")) {
					getNextToken();
					checkBlock();
				} else { syntaxError(currentToken(),"line 133");}
			} else {syntaxError(currentToken(),"line 134");}
		}else {syntaxError(currentToken(),"line 135");} 
	 }
	 
	 public void checkSwitch() {
		 if(currentToken().equals("if")) {
			 getNextToken();
			 if(currentToken().equals("(")) {
				 getNextToken();
				 checkBool();
				 if(currentToken().equals(")")) {
					 getNextToken();
					checkBlock();
					 if(currentToken().equals("else")) {
						 getNextToken();
						checkBlock();
					 }
				 }else {syntaxError(currentToken(),"line 154");}
			 }else {syntaxError(currentToken(),"line 155");}
		 
		 }else {syntaxError(currentToken(),"line 159");}
		 
	 }
	 
	 
	 public void checkExpression() {
		 
		 checkTerm();
		 if(currentToken().equals("*")||currentToken().equals("/")||currentToken().equals("%")) {
			 getNextToken();
		checkTerm();
		 }
	 }
	 
	 public void checkTerm() {
		 
		 checkFactor();
		 if(currentToken().equals("+")||currentToken().equals("-")) {
			 getNextToken();
			checkFactor();
		 }
	 }
	 
	 public void checkFactor() {
		 if(currentToken().equals("variable")|| currentToken().equals("number_lit") 
					||currentToken().equals("decimal_lit")||currentToken().equals("yorn_lit")
					||currentToken().equals("word_lit")) {
				getNextToken();
				if (currentToken().equals(";")) getNextToken();
			
			 
		 }else if (currentToken().equals("(")){
			 getNextToken();
			checkExpression();
			 if(currentToken().equals(")")) {
				 getNextToken();
			 } else syntaxError(currentToken(),"line 194");
		 } else syntaxError(currentToken(),"line 195");
	 }
	 
	 public  void checkBool() {
		
		 checkOr();
		 if (currentToken().equals("&&")) {
			 getNextToken();
			checkOr();
		 }
	 }
	
	 public  void checkOr() {
		
		 checkEqual();
		if(currentToken().equals("||")) {
			getNextToken();
		checkEqual();
		}
	 }
	 
	 public  void checkEqual() {
		 
		 checkBoolValue();
		 
		 if(currentToken().equals("==")|| currentToken().equals("!=")) {
			 getNextToken();
			 
			 checkBoolValue();
		 }else if(currentToken().equals("=")) {
			 syntaxError(currentToken(), "line 227");
		 }
	 }
	 
	public  void checkBoolValue() {
		
		checkBoolExp();
		if(currentToken().equals(">=") || currentToken().equals(">") || currentToken().equals("<=")
		|| currentToken().equals("<")) {
			getNextToken();
			
			checkBoolExp();
		} 
			
	}
	
	public  void checkBoolExp() {
		
		checkBoolTerm();
		if(currentToken().equals("*")|| currentToken().equals("/")||currentToken().equals("%")) {
			getNextToken();
			
			checkBoolTerm();
		} 
	}
	
	public  void checkBoolTerm() {
		
		checkBoolFactor();
		if (currentToken().equals("+")||currentToken().equals("-")) {
			getNextToken();
			
			checkBoolFactor();
		}
	}
	
	public  void checkBoolFactor() {
		if(currentToken().equals("variable")|| currentToken().equals("number_lit") 
				||currentToken().equals("decimal_lit")||currentToken().equals("yorn_lit")
				|| currentToken().equals("word_lit")) {
			getNextToken();
		}
		else if(currentToken().equals("(")) {
			
			checkBoolExp();
				if(currentToken().equals(")")) {
					getNextToken();
				}else syntaxError(currentToken(), "line 274");
			}else syntaxError(currentToken(), "line 275");
		}
	
	public  void checkParameter() {
		String current = currentToken(); 
		if(current.equals("string_dec")||current.equals("nat_dec")||
				current.equals("real_dec")||current.equals("bool_dec")||
				current.equals("char_dec")) {
			getNextToken();
			if(currentToken().equals("variable")) {
				getNextToken();
				
			
		}else syntaxError(currentToken(),"line 282");	
	}

	}
	 public  void syntaxError(String token, String line) {
		 System.out.println("oh noooo syntax error at: " +token + 
				 " {pointer: " + pointer+"}" + "{line: " +line+ "}");
	 }


	 

}