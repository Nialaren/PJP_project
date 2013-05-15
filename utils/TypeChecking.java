/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import utils.IRVisitor;
import ir.AssigmentStatement;
import ir.BinaryExpression;
import ir.BlockStatement;
import ir.ConditionalExpression;
import ir.IfStatement;
import ir.Literal;
import ir.PrintStatement;
import ir.ReadStatement;
import ir.UnaryExpression;
import ir.Variable;
import ir.WhileStatement;


public class TypeChecking implements IRVisitor{
   
    @Override
    public void visit(AssigmentStatement st) {
        String varType, expressionType;
        varType = st.getVariable().getType();
        expressionType = st.getExpression().getType();
        
        if(!varType.matches("ERROR") && !expressionType.matches("ERROR"))
        {
            if((varType.matches("FLOAT") || varType.matches("INT")) && (expressionType.matches("FLOAT")|| expressionType.matches("INT")))
            {}
            else if(!varType.matches(expressionType)){
                    MyError.addError(new MyError( st.getLine(),st.getColumn(), "Bad assingment of variable: "+ st.getVariable().getName() + ".\n Expected: " + varType +"\n Found: " + expressionType +"\n"));
                }
        }
    }
   
    @Override
    public void visit(BinaryExpression exp) {
        final String left = exp.getLeft().getType(), right= exp.getRight().getType();
        if(!left.matches("ERROR") && !right.matches("ERROR"))
        {
            if(left.matches(right) && left.matches("BOOLEAN"))
            {
                switch(exp.getOperator())
                {
                    case "||"   :exp.setType("BOOLEAN"); break;
                    case "&&"   :exp.setType("BOOLEAN"); break;
                    case "=="   :exp.setType("BOOLEAN"); break;
                    case "!="   :exp.setType("BOOLEAN"); break;
                    case ">"    :exp.setType("BOOLEAN"); break;
                    case "<"    :exp.setType("BOOLEAN"); break;
                    default     :exp.setType("ERROR");   break;       
                }
            }
            else if(left.matches(right) && left.matches("STRING"))
            {
               switch(exp.getOperator())
                {
                    case "."    :exp.setType("STRING"); break;
                    case "=="   :exp.setType("BOOLEAN"); break;
                    case "!="   :exp.setType("BOOLEAN"); break;
                    case ">"    :exp.setType("BOOLEAN"); break;
                    case "<"    :exp.setType("BOOLEAN"); break;
                    case "<="   :exp.setType("BOOLEAN"); break;
                    case ">="   :exp.setType("BOOLEAN"); break;
                    default     :exp.setType("ERROR");   break;       
                } 
            }
            else if(left.matches(right) && left.matches("INT"))
            {
                switch(exp.getOperator())
                {
                    case "%"    :exp.setType("INT"); break;
                    case "=="   :exp.setType("BOOLEAN"); break;
                    case "!="   :exp.setType("BOOLEAN"); break;
                    case ">"    :exp.setType("BOOLEAN"); break;
                    case "<"    :exp.setType("BOOLEAN"); break;
                    case "<="   :exp.setType("BOOLEAN"); break;
                    case ">="   :exp.setType("BOOLEAN"); break;
                    case "+"    :exp.setType("INT"); break;
                    case "-"    :exp.setType("INT"); break;
                    case "/"    :exp.setType("INT"); break;
                    case "*"    :exp.setType("INT"); break;
                    default     :exp.setType("ERROR");   break;       
                } 
            }
            else if((left.matches("FLOAT") || left.matches("INT")) && (right.matches("FLOAT")|| right.matches("INT")))
            {
                switch(exp.getOperator())
                {
                    case "=="   :exp.setType("BOOLEAN"); break;
                    case "!="   :exp.setType("BOOLEAN"); break;
                    case ">"    :exp.setType("BOOLEAN"); break;
                    case "<"    :exp.setType("BOOLEAN"); break;
                    case "<="   :exp.setType("BOOLEAN"); break;
                    case ">="   :exp.setType("BOOLEAN"); break;
                    case "+"    :exp.setType("FLOAT"); break;
                    case "-"    :exp.setType("FLOAT"); break;
                    case "/"    :exp.setType("FLOAT"); break;
                    case "*"    :exp.setType("FLOAT"); break;
                    default     :exp.setType("ERROR");   break;       
                } 
            }
            else
            {
                exp.setType("ERROR");
                MyError.addError(new MyError( exp.getLine(),exp.getColumn(), "You cant count: "+ left + " " + exp.getOperator() +" " + right));
            }
                
        }
        else
            exp.setType("ERROR");
    }
   
    @Override
    public void visit(BlockStatement st) {
        // Nothing to do
    }
   
    @Override
    public void visit(ConditionalExpression exp) {
        String cond = exp.getCondition().getType();
        String left = exp.getLeft().getType();
        String right = exp.getRight().getType();
        
        if(!cond.matches("ERROR") && !cond.matches("ERROR") && !cond.matches("ERROR"))
        {
            if(cond.matches("BOOLEAN"))
            {
                if(left.matches(right))
                    exp.setType(left);
                else if((left.matches("FLOAT") || left.matches("INT")) && (right.matches("FLOAT")|| right.matches("INT")))
                    exp.setType("FLOAT");
                else
                {
                    exp.setType("ERROR");
                    MyError.addError(new MyError( exp.getLine(),exp.getColumn(), "Different type in results of ? operator.\n Expected: "+ left +"\n Found: "+ right));
                }
            }
            else
            {
                exp.setType("ERROR");
                MyError.addError(new MyError( exp.getLine(),exp.getColumn(), "Bad ? condition expression.\n Expected: BOOLEAN\n Found: "+ cond));
            }
        }
        else
            exp.setType("ERROR");
    }
   
    @Override
    public void visit(IfStatement st) {
        String cond = st.getCondition().getType();
        if(!cond.matches("ERROR"))
            if(cond.matches("BOOLEAN")){}
            else
                MyError.addError(new MyError( st.getLine(),st.getColumn(), "Bad IF condition expression.\n Expected: BOOLEAN\n Found: "+ cond)); 
    }

    @Override
    public void visit(Literal exp) {
        String type = FindType(exp.getValue());
        exp.setType(type);
    }

    @Override
    public void visit(PrintStatement st) {
        //NOTHING TO DO
    }

    @Override
    public void visit(ReadStatement st) {
        //NOTHING TO DO
    }

    @Override
    public void visit(UnaryExpression exp) {
        String type = exp.getExpression().getType();
        if(!type.matches("ERROR"))
        {
            if((type.matches("INT") || type.matches("FLOAT")) && exp.getOperator().matches("-"))
                exp.setType(type);
            else if(type.matches("BOOLEAN")&& exp.getOperator().matches("!"))
                exp.setType(type);
            else
            {
                exp.setType("ERROR");
                MyError.addError(new MyError( exp.getLine(),exp.getColumn(), "You cant do: "+ exp.getOperator() + " " + type));
            }
        }
        else
            exp.setType("ERROR");
    }

    @Override
    public void visit(Variable exp) {
        
    }

    @Override
    public void visit(WhileStatement st) {
        String cond = st.getCondition().getType();
        if(!cond.matches("ERROR"))
            if(cond.matches("BOOLEAN")){}
            else
                MyError.addError(new MyError( st.getLine(),st.getColumn(), "Bad WHILE condition expression.\n Expected: BOOLEAN\n Found: "+ cond));
    }

    private String FindType(Object obj)
    {
        switch(obj.getClass().getName())
        {
            case "java.lang.Integer" : return "INT";
            case "java.lang.Double" : return "DOUBLE";
            case "java.lang.Boolean" : return "BOOLEAN";
            case "java.lang.String" : return "STRING";
            default : return "ERROR";
        }
    }
    
    public static String FindOperator(String operator)
    {
        switch(operator)
        {
            case "=="   : return "eq";
            case "!="   : return "eq\nnot";
            case ">"    : return "gt";
            case "<"    : return "lt";
            //case "<="   :exp.setType("BOOLEAN"); break;
            //case ">="   :exp.setType("BOOLEAN"); break;
            case "+"    : return "add";
            case "-"    : return "sub";
            case "/"    : return "div";
            case "*"    : return "mul";
            case "%"    : return "mod";
            case "."    : return "concat";
            default     : return "error";
        }
    }
}
