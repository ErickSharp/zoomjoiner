import java.util.Date;

import javax.swing.JOptionPane;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.*;

public class ZoomJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Initiated.");
        String date = new Date().toString().substring(11, 19);
        System.out.println(date);

        int[] algebraPassword = { 73, 78, 86, 69, 82, 83, 69 };
        int[] chemistryPassword = { 66, 69, 78, 73, 78, 71 };

        switch (date) {
        case "07:15:00":
            System.out.println("Joining first period. ALGEBRA 2");
            try {
                open(new URI("https://katyisd-org.zoom.us/j/6497260523"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            enterPassword(algebraPassword, false);
            break;
        case "07:50:00":
            leaveMeeting();
            break;
        case "08:05:00":
            System.out.println("Joining second period. SPANISH 2");
            try {
                open(new URI("https://us02web.zoom.us/j/81359922770?pwd=THVHaU1IWmw0K3NKQURUaVBrcUE2Zz09"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            break;
        case "08:45:00":
            leaveMeeting();
            break;
        // case "08:55:00 CST 2021":
        // System.out.println("Joining third period.");
        // try {
        // open(new URI("https://www.example.com"));
        // } catch (URISyntaxException e) {
        // e.printStackTrace();
        // }
        // break;
        // case "09:40:00 CST 2021":
        // leaveMeeting();
        // break;
        case "10:15:00":
            System.out.println("Joining fourth period. HEALTH");
            try {
                open(new URI("https://us02web.zoom.us/j/86361386136?pwd=UjIyVDF6NU1jNFVDZ1JCTjQ4M0dwQT09"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            break;
        case "10:50:00":
            leaveMeeting();
            break;
        case "12:15:00":
            System.out.println("Joining fifth period. ENGLISH");
            try {
                open(new URI("https://katyisd-org.zoom.us/j/84871801616"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            break;
        case "12:30:00":
            leaveMeeting();
            break;
        case "12:55:00":
            System.out.println("Joining sixth period. CHEMISTRY");
            try {
                open(new URI("https://katyisd-org.zoom.us/j/81326003271"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            enterPassword(chemistryPassword, true);
            break;
        case "13:40:00":
            leaveMeeting();
            break;
        case "13:45:00":
            System.out.println("Joining seventh period. WHAP");
            try {
                open(new URI("https://katyisd-org.zoom.us/j/83894490073?pwd=MVJybUVFMytCelgxWHUvU2FPRGEvUT09"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            break;
        case "14:30:00":
            leaveMeeting();
            break;
        }
    }

    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(uri);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open browser.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Could not open browser.");
        }
    }

    public static void leaveMeeting() {
        try {
            Robot leaverRobot = new Robot();
            leaverRobot.mouseMove(1876, 1051);
            leaverRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            leaverRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void enterPassword(int[] passwordArray, boolean isFirstLetterCapitalized) {
        try {
            Robot enterRobot = new Robot();

            enterRobot.delay(10000);

            enterRobot.mouseMove(840, 480);

            enterRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            enterRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            for (int i = 0; i < passwordArray.length; i++) {
                if (isFirstLetterCapitalized && i == 0) {
                    enterRobot.keyPress(KeyEvent.VK_SHIFT);
                    enterRobot.keyPress(passwordArray[i]);
                    enterRobot.keyRelease(passwordArray[i]);
                    enterRobot.keyRelease(KeyEvent.VK_SHIFT);
                } else {
                    enterRobot.keyPress(passwordArray[i]);
                    enterRobot.keyRelease(passwordArray[i]);
                }
            }

            enterRobot.keyPress(KeyEvent.VK_ENTER);
            enterRobot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
