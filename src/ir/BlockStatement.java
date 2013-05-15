package ir;

import java.util.ArrayList;
import java.util.List;
import utils.IRVisitor;

/**
 *
 * @author beh01
 */
public class BlockStatement extends Statement {

    List<Statement> statements = new ArrayList<>();

    public BlockStatement() {
    }

    /**
     * returns list of sub statements
     * @return List statements
     */
    public List<Statement> getStatements() {

        return statements;

    }

    /**
     * Implementation of design pattern Visitor to provide Type Checking
     *
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        for (Statement s : statements) {
            s.accept(visitor);
        }
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        for (Statement s : statements) {
            sb.append(s.toString()).append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    /**
     * Returns assembly code
     *
     * @return String
     */
    @Override
    public String getCode() {
        StringBuilder sb = new StringBuilder("\n");

        for (Statement s : statements) {
            sb.append(s.getCode());
            
            //System.out.println(statements);
        }

        sb.append("\n");

        return sb.toString();
    }
}
