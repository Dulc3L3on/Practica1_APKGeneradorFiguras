
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser_Figuras extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return parser_FigurasSym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser_Figuras() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser_Figuras(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser_Figuras(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\033\000\002\002\004\000\002\002\005\000\002\002" +
    "\002\000\002\003\004\000\002\004\004\000\002\004\004" +
    "\000\002\004\004\000\002\004\004\000\002\004\004\000" +
    "\002\004\003\000\002\005\011\000\002\005\004\000\002" +
    "\006\013\000\002\006\004\000\002\007\015\000\002\007" +
    "\004\000\002\010\017\000\002\010\004\000\002\011\005" +
    "\000\002\011\005\000\002\011\005\000\002\011\005\000" +
    "\002\011\003\000\002\011\005\000\002\011\004\000\002" +
    "\012\006\000\002\012\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\125\000\006\002\uffff\013\004\001\002\000\016\003" +
    "\046\006\051\007\053\010\045\011\052\012\050\001\002" +
    "\000\010\002\uffe7\013\uffe7\014\010\001\002\000\004\002" +
    "\007\001\002\000\004\002\001\001\002\000\004\015\013" +
    "\001\002\000\006\002\uffff\013\004\001\002\000\004\002" +
    "\000\001\002\000\004\016\014\001\002\000\006\003\017" +
    "\024\016\001\002\000\006\002\uffe8\013\uffe8\001\002\000" +
    "\010\003\023\017\021\024\022\001\002\000\004\025\020" +
    "\001\002\000\006\002\ufff6\013\ufff6\001\002\000\016\020" +
    "\uffeb\021\uffeb\022\uffeb\023\uffeb\025\uffeb\026\uffeb\001\002" +
    "\000\010\003\023\017\021\024\022\001\002\000\004\026" +
    "\042\001\002\000\014\020\030\021\026\022\027\023\031" +
    "\026\025\001\002\000\010\003\023\017\021\024\022\001" +
    "\002\000\010\003\023\017\021\024\022\001\002\000\010" +
    "\003\023\017\021\024\022\001\002\000\010\003\023\017" +
    "\021\024\022\001\002\000\010\003\023\017\021\024\022" +
    "\001\002\000\016\020\uffec\021\uffec\022\uffec\023\uffec\025" +
    "\uffec\026\uffec\001\002\000\016\020\uffef\021\uffef\022\027" +
    "\023\031\025\uffef\026\uffef\001\002\000\016\020\uffed\021" +
    "\uffed\022\uffed\023\uffed\025\uffed\026\uffed\001\002\000\016" +
    "\020\uffee\021\uffee\022\027\023\031\025\uffee\026\uffee\001" +
    "\002\000\014\020\030\021\026\022\027\023\031\026\037" +
    "\001\002\000\004\004\040\001\002\000\004\025\041\001" +
    "\002\000\006\002\ufff7\013\ufff7\001\002\000\016\020\uffe9" +
    "\021\uffe9\022\uffe9\023\uffe9\025\uffe9\026\uffe9\001\002\000" +
    "\014\020\030\021\026\022\027\023\031\025\044\001\002" +
    "\000\016\020\uffea\021\uffea\022\uffea\023\uffea\025\uffea\026" +
    "\uffea\001\002\000\006\003\072\024\071\001\002\000\010" +
    "\002\ufff8\013\ufff8\014\ufff8\001\002\000\010\002\ufffe\013" +
    "\ufffe\014\ufffe\001\002\000\006\003\110\024\107\001\002" +
    "\000\006\003\055\024\054\001\002\000\006\003\072\024" +
    "\071\001\002\000\006\003\055\024\054\001\002\000\010" +
    "\003\023\017\021\024\022\001\002\000\004\025\057\001" +
    "\002\000\010\002\ufffc\013\ufffc\014\ufffc\001\002\000\010" +
    "\002\ufff4\013\ufff4\014\ufff4\001\002\000\014\020\030\021" +
    "\026\022\027\023\031\026\061\001\002\000\010\003\023" +
    "\017\021\024\022\001\002\000\014\020\030\021\026\022" +
    "\027\023\031\026\063\001\002\000\010\003\023\017\021" +
    "\024\022\001\002\000\014\020\030\021\026\022\027\023" +
    "\031\026\065\001\002\000\004\005\066\001\002\000\004" +
    "\025\067\001\002\000\010\002\ufff5\013\ufff5\014\ufff5\001" +
    "\002\000\010\002\ufffa\013\ufffa\014\ufffa\001\002\000\010" +
    "\003\023\017\021\024\022\001\002\000\004\025\073\001" +
    "\002\000\010\002\ufff2\013\ufff2\014\ufff2\001\002\000\014" +
    "\020\030\021\026\022\027\023\031\026\075\001\002\000" +
    "\010\003\023\017\021\024\022\001\002\000\014\020\030" +
    "\021\026\022\027\023\031\026\077\001\002\000\010\003" +
    "\023\017\021\024\022\001\002\000\014\020\030\021\026" +
    "\022\027\023\031\026\101\001\002\000\010\003\023\017" +
    "\021\024\022\001\002\000\014\020\030\021\026\022\027" +
    "\023\031\026\103\001\002\000\004\005\104\001\002\000" +
    "\004\025\105\001\002\000\010\002\ufff3\013\ufff3\014\ufff3" +
    "\001\002\000\010\002\ufffd\013\ufffd\014\ufffd\001\002\000" +
    "\010\003\023\017\021\024\022\001\002\000\004\025\112" +
    "\001\002\000\010\002\ufff9\013\ufff9\014\ufff9\001\002\000" +
    "\010\002\ufff0\013\ufff0\014\ufff0\001\002\000\014\020\030" +
    "\021\026\022\027\023\031\026\114\001\002\000\010\003" +
    "\023\017\021\024\022\001\002\000\014\020\030\021\026" +
    "\022\027\023\031\026\116\001\002\000\010\003\023\017" +
    "\021\024\022\001\002\000\014\020\030\021\026\022\027" +
    "\023\031\026\120\001\002\000\010\003\023\017\021\024" +
    "\022\001\002\000\014\020\030\021\026\022\027\023\031" +
    "\026\122\001\002\000\010\003\023\017\021\024\022\001" +
    "\002\000\014\020\030\021\026\022\027\023\031\026\124" +
    "\001\002\000\004\005\125\001\002\000\004\025\126\001" +
    "\002\000\010\002\ufff1\013\ufff1\014\ufff1\001\002\000\010" +
    "\002\ufffb\013\ufffb\014\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\125\000\006\002\005\003\004\001\001\000\004\004" +
    "\046\001\001\000\004\012\010\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\002\011\003" +
    "\004\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\005\014\001\001\000\002\001\001\000\004\011\023\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\011\042\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\011\035\001\001\000\004\011\034\001\001" +
    "\000\004\011\033\001\001\000\004\011\032\001\001\000" +
    "\004\011\031\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\007" +
    "\126\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\010\110\001\001\000\004\006\105\001\001\000\004\007" +
    "\067\001\001\000\004\006\055\001\001\000\004\011\057" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\061\001\001\000\002" +
    "\001\001\000\004\011\063\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\011\073\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\011\075\001\001" +
    "\000\002\001\001\000\004\011\077\001\001\000\002\001" +
    "\001\000\004\011\101\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\011\112\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\114\001\001\000\002\001\001\000\004\011\116\001\001" +
    "\000\002\001\001\000\004\011\120\001\001\000\002\001" +
    "\001\000\004\011\122\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser_Figuras$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser_Figuras$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser_Figuras$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public parser (lexer_Figuras lexer){//Esto no es necesario pues el lexer.java extiende de Scanner
        super(lexer);
    }

    protected int error_sync_size() {
		return 1;
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser_Figuras$actions {
  private final parser_Figuras parser;

  /** Constructor */
  CUP$parser_Figuras$actions(parser_Figuras parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser_Figuras$do_action_part00000000(
    int                        CUP$parser_Figuras$act_num,
    java_cup.runtime.lr_parser CUP$parser_Figuras$parser,
    java.util.Stack            CUP$parser_Figuras$stack,
    int                        CUP$parser_Figuras$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser_Figuras$result;

      /* select the action based on the action number */
      switch (CUP$parser_Figuras$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= instruccion EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)).value;
		RESULT = start_val;
              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser_Figuras$parser.done_parsing();
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // instruccion ::= graficar animar instruccion 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("instruccion",0, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-2)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // instruccion ::= 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("instruccion",0, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // graficar ::= GRAFICAR tipo 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("graficar",1, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // tipo ::= CIRCULO cuatroParam 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tipo",2, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // tipo ::= CUADRADO cuatroParam 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tipo",2, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // tipo ::= RECTANGULO cincoParam 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tipo",2, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // tipo ::= LINEA cincoParam 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tipo",2, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // tipo ::= POLIGONO seisParam 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tipo",2, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo ::= error 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tipo",2, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // tresParam ::= APER valorNumerico COMA valorNumerico COMA ANIMACION CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tresParam",3, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-6)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // tresParam ::= error CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("tresParam",3, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // cuatroParam ::= APER valorNumerico COMA valorNumerico COMA valorNumerico COMA COLOR CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("cuatroParam",4, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-8)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // cuatroParam ::= error CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("cuatroParam",4, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // cincoParam ::= APER valorNumerico COMA valorNumerico COMA valorNumerico COMA valorNumerico COMA COLOR CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("cincoParam",5, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-10)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // cincoParam ::= error CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("cincoParam",5, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // seisParam ::= APER valorNumerico COMA valorNumerico COMA valorNumerico COMA valorNumerico COMA valorNumerico COMA COLOR CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("seisParam",6, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-12)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // seisParam ::= error CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("seisParam",6, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // valorNumerico ::= valorNumerico SUM valorNumerico 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-2)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // valorNumerico ::= valorNumerico RES valorNumerico 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-2)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // valorNumerico ::= valorNumerico MULT valorNumerico 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-2)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // valorNumerico ::= valorNumerico DIV valorNumerico 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-2)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // valorNumerico ::= NUMERO 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // valorNumerico ::= APER valorNumerico CIER 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-2)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // valorNumerico ::= error COMA 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("valorNumerico",7, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-1)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // animar ::= ANIMAR OBJETO ANTERIOR tresParam 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("animar",8, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.elementAt(CUP$parser_Figuras$top-3)), ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // animar ::= 
            {
              Object RESULT =null;

              CUP$parser_Figuras$result = parser.getSymbolFactory().newSymbol("animar",8, ((java_cup.runtime.Symbol)CUP$parser_Figuras$stack.peek()), RESULT);
            }
          return CUP$parser_Figuras$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser_Figuras$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser_Figuras$do_action(
    int                        CUP$parser_Figuras$act_num,
    java_cup.runtime.lr_parser CUP$parser_Figuras$parser,
    java.util.Stack            CUP$parser_Figuras$stack,
    int                        CUP$parser_Figuras$top)
    throws java.lang.Exception
    {
              return CUP$parser_Figuras$do_action_part00000000(
                               CUP$parser_Figuras$act_num,
                               CUP$parser_Figuras$parser,
                               CUP$parser_Figuras$stack,
                               CUP$parser_Figuras$top);
    }
}

}
