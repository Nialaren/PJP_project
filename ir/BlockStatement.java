/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ir;

import java.util.ArrayList;
import java.util.List;
import utils.IRVisitor;

/**
 *
 * @author beh01
 */
public class BlockStatement extends Statement {
    List<Statement> statements = new ArrayList<Statement>();

    public BlockStatement() {
    }

    public List<Statement> getStatements() {
        
        return statements;
        
    }

    @Override
    public void accept(IRVisitor visitor) {
        for(Statement s : statements) s.accept(visitor);
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder("{\n");
        for(Statement s : statements) sb.append(s.toString()).append("\n");
        sb.append("}\n");
        return sb.toString();
    }


    
}
