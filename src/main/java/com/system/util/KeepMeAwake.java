package com.system.util;

import java.awt.*;
import java.util.Random;

public class KeepMeAwake {

    public static void main(String[] law) throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();
        int waitTimeInSeconds = 60;
        int elapsedTime = 0;
        int iterations = 1;
        if (law != null && law.length > 0) {
            waitTimeInSeconds = Integer.parseInt(law[0]);
            if (waitTimeInSeconds >= 60) {
                iterations = (waitTimeInSeconds / 60);
            }
        }

        while (true) {
            System.out.println(String.format("Total Wait Time: %s seconds", waitTimeInSeconds));
            for (int i = 0; i < iterations; i++) {
                robot.delay(1000 * 60);
                if (elapsedTime == 0) {
                    elapsedTime = waitTimeInSeconds - 60;
                } else {
                    elapsedTime -= 60;
                }
                System.out.println("Elapsed Time: " + elapsedTime);
            }
            int x = random.nextInt() % 640;
            int y = random.nextInt() % 480;
            robot.mouseMove(x, y);
            System.out.println("Just moved the mouse");
        }
    }
}
