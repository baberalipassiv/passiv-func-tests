package common.cli;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.util.Scanner;

public class CLIExecutor {

    public static StringBuilder output = new StringBuilder();
    public static final File cliDir = initCliDir();

    private static File initCliDir(){
        String cliDir = System.getProperty("CLI_DIR");
        if(cliDir == null || cliDir.isEmpty()) {

            return null;
        }
        File file = new File(cliDir);
        return file;
    }

    private static class IOThreadHandler extends Thread {
        private InputStream inputStream;


        IOThreadHandler(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public void run() {
            Scanner br = null;
            try {
                br = new Scanner(new InputStreamReader(inputStream));
                while (br.hasNextLine()) {
                    String line = br.nextLine();
                    output.append(line
                            + System.getProperty("line.separator"));
                    //    logger.logInfo(line);
                }
            } finally {
                br.close();
            }
        }

        public StringBuilder getOutput() {
            return output;
        }
    }
}
