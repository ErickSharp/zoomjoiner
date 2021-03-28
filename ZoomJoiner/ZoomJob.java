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
        String time = new Date().toString().substring(11, 19);
        String date = new Date().toString().substring(0, 3);
        System.out.println(time + " " + date);

        // Takes in each character as ASCII capital letter codes.
        int[] testPassword = {  };
        int[] testPasswordTwo = {  };

        if (date != "Sat" && date != "Sun") {
            switch (time) {
            case "07:15:00":
                System.out.println("Joining first period.");
                try {
                    open(new URI("https://example.com"));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                enterPassword(algebraPassword, false);
                break;
            case "07:50:00":
                leaveMeeting();
                break;
            case "08:05:00":
                System.out.println("Joining second period.");
                try {
                    open(new URI("https://example.com"));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case "08:40:00":
                leaveMeeting();
                break;
            case "08:55:00":
            System.out.println("Joining third period.");
            try {
            open(new URI("https://www.example.com"));
            } catch (URISyntaxException e) {
            e.printStackTrace();
            }
            break;
            case "09:40:00":
            leaveMeeting();
            break;
            case "10:15:00":
                System.out.println("Joining fourth period.");
                try {
                    open(new URI("https://example.com"));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case "10:40:00":
                leaveMeeting();
                break;
            case "12:15:00":
                System.out.println("Joining fifth period.");
                try {
                    open(new URI("https://example.com"));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case "12:30:00":
                leaveMeeting();
                break;
            case "12:55:00":
                System.out.println("Joining sixth period.");
                try {
                    open(new URI("https://example.com"));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                enterPassword(chemistryPassword, true);
                break;
            case "13:40:00":
                leaveMeeting();
                break;
            case "13:45:00":
                System.out.println("Joining seventh period.");
                try {
                    open(new URI("https://example.com"));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case "14:35:00":
                leaveMeeting();
                break;
            }
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

            leaverRobot.keyPress(KeyEvent.VK_ALT);
            leaverRobot.keyPress(KeyEvent.VK_F4);
            leaverRobot.keyRelease(KeyEvent.VK_ALT);
            leaverRobot.keyRelease(KeyEvent.VK_F4);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void enterPassword(int[] passwordArray, boolean isFirstLetterCapitalized) {
        try {
            Robot enterRobot = new Robot();
            enterRobot.delay(10000);

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
