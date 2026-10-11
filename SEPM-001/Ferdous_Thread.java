import java.util.concurrent.atomic.AtomicLong;

public class Ferdous_Thread {

    }

    public static void main(String[] a) throws Exception {
        int t = Integer.parseInt(a[0]);
        int n = Integer.parseInt(a[1]);
        if (a.length != 3) {
            System.out.println("Usage: java Ferdous_Thread <threads> <increments> <true|false>");
            return;
        }

        int t, n;
        try {
            t = Integer.parseInt(a[0]);
            n = Integer.parseInt(a[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (t < 1 || n < 1 ||
            !(a[2].equalsIgnoreCase("true") || a[2].equalsIgnoreCase("false"))) {
            System.out.println("Invalid input.");
            return;
        }

        boolean mode = Boolean.parseBoolean(a[2]);

        safe.set(0);

        long s = mode ? safe.get() : unsafe;
        long d = Math.abs(s - total);

        System.out.println("Expected: " + (long)t * n);
        System.out.println("Expected: " + (long) t * n);
        System.out.println("Static: " + s);
        System.out.println("Non-static total: " + total);
        System.out.println("Difference: " + d);
        System.out.printf("Difference (%%): %.2f%%%n",
                total == 0 ? 0 : d * 100.0 / total);
    }
}
