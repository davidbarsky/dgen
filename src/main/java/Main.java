import Parser.Parser;
import Parser.ASTNode;
import Process.ProcessExecutor;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String... args) {
        ProcessExecutor processExecutor = new ProcessExecutor();
        Parser parser = new Parser();

        ASTNode node = parser.parseLine("2 -> 3\t [label=8.234240]");
        System.out.println(node.endingValue);
        System.out.println(node.startingValue);
        System.out.println(node.networkCost);
    }
}
