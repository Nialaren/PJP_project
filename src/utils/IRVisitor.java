/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

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
public interface  IRVisitor {
    public void visit(AssigmentStatement st);
    public void visit(BinaryExpression exp);
    public void visit(BlockStatement st);
    public void visit(ConditionalExpression exp);
    public void visit(IfStatement st);
    public void visit(Literal exp);
    public void visit(PrintStatement st);
    public void visit(ReadStatement st);
    public void visit(UnaryExpression exp);
    public void visit(Variable exp);
    public void visit(WhileStatement st);
}
