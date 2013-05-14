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

/**
 *
 * @author beh01
 */
public class TypeChecking implements IRVisitor{

    @Override
    public void visit(AssigmentStatement st) {
        String varType, expressionType;
        varType = st.getVariable().getType();
        expressionType = st.getExpression().getType();
        
        if(!varType.matches("ERROR") && !expressionType.matches("ERROR"))
        {
            if((varType.matches("FLOAT") || varType.matches("INTEGER")) && (expressionType.matches("FLOAT")|| expressionType.matches("INTEGER")))
            {
                
            }
            else if(!varType.matches(expressionType)){
                    MyError.addError(new MyError( 0,0, "Bad assingment of variable: "+ st.getVariable().getName() + ".\n Expected: " + varType +"\n Found: " + expressionType +"\n"));
                }
        }
    }

    @Override
    public void visit(BinaryExpression exp) {
        String left = exp.getLeft().getType(), right= exp.getRight().getType();
        if(!left.matches("ERROR") && !right.matches("ERROR"))
        {
            switch(exp.getOperator())
            {
                case "||"   :break;
                case "&&"   :break;
                case "=="   :break;
                case "!="   :break;
                case ">"    :break;
                case "<"    :break;
                case ">="   :break;  
                case "<="   :break;
                case "+"    :break;
                case "-"    :break;
                case "*"    :break;
                case "/"    :break;
                case "."    :break;
                case "%"    :break;
                default : exp.setType("ERROR"); break;
                
            }
            /*if((left.matches("FLOAT") || left.matches("INTEGER")) && (right.matches("FLOAT")|| right.matches("INTEGER")))
            {
                exp.setType("FLOAT");
            }
            else if(!left.matches(right)){
                MyError.addError(new MyError( 0,0, "Bad assingment of variable: "+ st.getVariable().getName() + ".\n Expected: " + varType +"\n Found: " + expressionType +"\n"));
            }
            else
            {
                exp.setType(left);
            }*/
        }
    }

    public void visit(BlockStatement st) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visit(ConditionalExpression exp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visit(IfStatement st) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(Literal exp) {
        exp.setType(FindType(exp.getValue()));
    }

    public void visit(PrintStatement st) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visit(ReadStatement st) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visit(UnaryExpression exp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(Variable exp) {
        
    }

    public void visit(WhileStatement st) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String FindType(Object obj)
    {
        switch(obj.getClass().getName())
        {
            case "java.lang.Integer" : return "INTEGER";
            case "java.lang.Double" : return "DOUBLE";
            case "java.lang.Boolean" : return "BOOLEAN";
            case "java.lang.String" : return "STRING";
            default : return "ERROR";
        }
    }
}
