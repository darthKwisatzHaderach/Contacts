import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public Time(int hour, int minute, int second) {
        if (hour >= 0 & hour < 24) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException();
        }

        if (minute >= 0 & minute < 60) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException();
        }

        if (second >= 0 & second < 60) {
            this.second = second;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Time(long seconds) {
        this.hour = (int) (seconds / 3600) % 24;
        long secondsInDay = seconds % 3600;
        this.minute = (int) (secondsInDay / 60);
        this.second = (int) (secondsInDay % 60);
    }

    public static Time noon() {
        return new Time(12, 0, 0);
    }

    public static Time midnight() {
        return new Time(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        return new Time(seconds);
    }

    public static Time of(int hour, int minute, int second) {
        try {
            return new Time(hour, minute, second);
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}