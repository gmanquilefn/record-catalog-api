package cl.gfmn.catalog.util;

import java.util.Random;

public class Utils {

    /**
     * Method that generates a random interspersed code
     * @param length of the code, must be even
     * @return code string
     */
    public static String generateInterspersedCode(int length) {

        if (length % 2 != 0) {
            throw new IllegalArgumentException("Length must be even for interspersed digit and character pattern");
        }

        StringBuilder code = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length / 2; i++) {
            code.append((char) ('A' + random.nextInt(26)));
            code.append(random.nextInt(10));
        }

        return code.toString();
    }
}
