/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

/**
 *
 * @author SERVER
 */
public class Lexer {
    String text;
    String DIGITS= "0123456789" ;
    int pos= -1;
    char current_char;
    
   
   
  //  Token t = new Token();
    
    
    public String Token(String type,String value){
       
           if (value != null){
              String temp = type + ":" + value;
              return temp;
           }
           else{return type;}
           
       
    } 
    
    public void advance(){
       this.pos +=1;

       if (this.pos < text.length()){
            this.current_char = this.text.charAt(this.pos);
           
       }
       else{
           this.current_char='\0'; 
       }
    }
    /*
       public void startup(){
       
        this.pos =-1;
        this.current_char='\0';
        this.DIGITS= "0123456789";
        this.advance();
    }
    */
    public String make_number(){
        String num_str="";
        int dot_count=0;
        String point = DIGITS.concat(String.valueOf('.'));
        while(this.current_char != '\0' && point.contains(String.valueOf(this.current_char))){
            if(this.current_char =='.'){
                if(dot_count == 1){break;}
                dot_count +=1;
                num_str = num_str.concat(String.valueOf(this.current_char));
            }
            else{
                num_str = num_str.concat(String.valueOf(this.current_char));
                
            }
            advance();
        }
        
        if(dot_count ==0){return Token("TT_INT", num_str);  }
        else{return Token("TT_FLOAT", num_str); }
    
    }
    
    public String make_tokens(){
        String tokens="";
       
        while( this.current_char != '\0'){
           
            switch(this.current_char){
                case '\t':
                    advance();
                break;
                
                case '+':
                    tokens = tokens.concat(Token("TT_PLUS",null));
                    advance();
                    break;
                case '-':
                    tokens = tokens.concat(Token("TT_MINUS",null));
                    advance();
                    break;
                case '*':
                    tokens = tokens.concat(Token("TT_MUL",null));
                    advance();
                    break;
                case '/':
                    tokens = tokens.concat(Token("TT_DIV",null));
                    advance();
                    break;
                case '(':
                    tokens = tokens.concat(Token("TT_LPAREN",null));
                    advance();
                    break;
                case ')':
                    tokens = tokens.concat(Token("TT_RPAREN",null));
                    advance();
                    break;
                default: 
                    //char temp = this.current_char;
                   // this.advance();

                    
            }
            if(DIGITS.contains(String.valueOf(this.current_char))){
                tokens = tokens.concat(make_number());
                
            }
        }
        return tokens;
    }
    
        public String run(String texto) {
        String tokens;
        this.pos = -1;
        this.text = texto;
        advance();
        tokens = this.make_tokens();
        return tokens;
    }
}
