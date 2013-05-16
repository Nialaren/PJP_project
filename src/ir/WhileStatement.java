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
public class WhileStatement extends Statement {

    private BlockStatement statement;
    private Expression condition;
    private int line;
    private int column;
    private int tLabel;
    private int fLabel;

    public WhileStatement(BlockStatement statement, Expression condition, int line, int column) {
        this.statement = statement;
        this.condition = condition;
        this.line = line;
        this.column = column;
        this.tLabel = JumpCounter.get();
        this.fLabel = JumpCounter.get();
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Expression getCondition() {
        return condition;
    }

    public BlockStatement getStatement() {
        return statement;
    }

    @Override
    public void accept(IRVisitor visitor) {
        condition.accept(visitor);
        statement.accept(visitor);
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "while (" + condition.toString() + ") do " + statement.toString() + " end;";
    }

    @Override
    public String getCode() {
        StringBuilder output = new StringBuilder();
        
        output.append("#cycle begin\n");
        output.append("LABEL " + this.tLabel + "\n");
        
        output.append(condition.getCode());
        //output.append("LOAD "+condition.getId()+"\n");
        output.append("FJMP " + this.fLabel + "\n");
        output.append(statement.getCode());

        output.append("JMP " + this.tLabel + "\n");
        output.append("LABEL " + this.fLabel + "\n");
        output.append("#cycle end\n");

        return output.toString();
    }
}
