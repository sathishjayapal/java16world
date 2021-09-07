package me.sathish;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingSample {
    private static Logger logger = Logger.getLogger("me.sathish.package");
    private static FileHandler fh;
    private static FileHandler ch;

    static {
        try {
            fh = new FileHandler("mylog.txt");
            ch = new FileHandler("Secondfile.txt");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Logging file is not found");
        }
    }

    public static void main(String[] args) {
        int start = 5;
        int counter = 0;
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
        for (int i = 0; i < start; i++) {
            if (i == 3) {
                logger.addHandler(ch);
                logger.setLevel(Level.ALL);
            }
            logger.log(Level.SEVERE, "This is the counter " + counter++);
        }

    }
}
