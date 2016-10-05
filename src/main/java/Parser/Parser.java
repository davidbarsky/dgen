package Parser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Optional;

public class Parser {
    public ArrayList<ASTNode> parse(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<ASTNode> ast = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (nextLine.contains("digraph dag {")) {
                    continue;
                }
                if (scanner.nextLine().contains("}")) {
                    break;
                }

                ast.add(parseLine(nextLine));
            }

            return ast;
        }
    }

    public ASTNode parseLine(String string) {
        Scanner scanner = new Scanner(string);

        List<Integer> integers = new ArrayList<>();
        Iterator<Integer> integerIterator = integers.iterator();
        while (scanner.hasNextInt()) {
            integers.add(scanner.nextInt());
        }

        ASTNode node = new ASTNode(integerIterator.next(), Optional.empty(), Optional.empty());
        if (integers.size() != 0) {
            node.endingValue = Optional.of(integers.iterator().next());
        }

        while (scanner.hasNextDouble()) {
            node.networkCost = Optional.of(scanner.nextDouble());
        }

        return node;
    }
}
