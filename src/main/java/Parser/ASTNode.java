package Parser;

import java.util.Optional;

public class ASTNode {
    public Integer startingValue;
    public Optional<Integer> endingValue;
    public Optional<Double> networkCost;

    public ASTNode(Integer startingValue,
                   Optional<Integer> endingValue,
                   Optional<Double> networkCost) {

        this.startingValue = startingValue;
        this.endingValue = endingValue;
        this.networkCost = networkCost;
    }
}
