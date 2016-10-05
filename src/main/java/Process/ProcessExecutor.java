package Process;

import java.io.File;
import java.io.IOException;

public class ProcessExecutor {
    public File generateGraph() throws IOException {
        File file = generateFile();
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.
                exec("ggen generate-graph lbl 10 6 0.2 | ggen add-property --edge --name"
                + " label " + "flat 0 10 > " + file.getName());

        return file;
    }

    private File generateFile() {
        return new File("generated-graph.dot");
    }
}
