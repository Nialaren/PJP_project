/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import utils.IRVisitor;
import utils.JumpCounter;

/**
 *
 * @author beh01
 */
public class IfStatement extends Statement {

    private Expression condition;
    private BlockStatement thenPart, elsePart;
    private int line;
    private int column;
    private int tLabel;
    private int fLabel;

    public IfStatement(Expression condition, BlockStatement thenPart, BlockStatement elsePart, int line, int column) {
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
        this.line = line;
        this.column = column;
        this.tLabel = JumpCounter.get();
        this.fLabel = JumpCounter.get();
    }

    public int getLine(){
        return line;
    }
    public int getColumn(){
        return column;
    }

    public Expression getCondition() {
        return condition;
    }

    public BlockStatement getElsePart() {
        return elsePart;
    }

    public BlockStatement getThenPart() {
        return thenPart;
    }

    @Override
    public void accept(IRVisitor visitor) {
        condition.accept(visitor);
        thenPart.accept(visitor);
        elsePart.accept(visitor);

        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "if (" + condition.toString() + ") then " + thenPart.toString() + " else " + elsePart.toString() + " end;";
    }

    @Override
    public String getCode() {
        StringBuilder output = new StringBuilder();

        output.append(condition.getCode());
        output.append("FJMP " + this.fLabel + "\n");
        output.append(thenPart.getCode());
        
        output.append("JMP " + this.tLabel + "\n");
        output.append("LABEL " + this.fLabel + "\n");
        output.append(elsePart.getCode());
        
        output.append("LABEL " + this.tLabel + "\n");
        
        return output.toString();        
    }
}
