 /*
Jack Zhang
Stopwatch Class
 */

public class Stopwatch {

    private long myStarttime;    // in milliseconds
    private long myStoptime;
    private boolean isTiming;

    public Stopwatch() {
        myStarttime = 0;
        myStoptime = 0;
        isTiming = false;
    }

    public void Start() {
        // starts the clock by getting system time
        myStarttime = System.currentTimeMillis();
        isTiming = true;
    }

    public void Stop() {
        // stops the clock by getting the system time
        if (isTiming) {
            myStoptime = System.currentTimeMillis();
            isTiming = false;
        }
    }
    
    public int getMillis() {
        // returns the millis of the current time
        return elapsedtime() % 1000;

    }
    // -------------------- Write these Methods just like getMillis()
    public int getHours() {
        // returns the hours of the current time (if not timing
        return (elapsedtime() / 3600000);
    }

    public int getMinutes() {
        // returns the minutes of the current time
        return (elapsedtime() / 60000) % 60;
    }

    public int getSeconds() {
        // returns the seconds of the current time
        return (elapsedtime() / 1000) % 60;
    }
    // ------------------------------------------------------------
    
    public String toString() {
        // returns a string of the time in hours:minutes:seconds.millis
        // this adds leading zeros (ex 02:23:09)
        int millis = getMillis();
        int hrs = getHours();
        int mins = getMinutes();
        int secs = getSeconds();
        return "" + hrs / 10 + hrs % 10 + ":" + mins / 10 + mins % 10 + ":"
                + secs / 10 + secs % 10 + "." + millis / 100 + millis / 10 % 10 + millis % 10;
    }
    
    private int elapsedtime() {
        // returns the time that has elapsed on the stop watch as an int
        if (isTiming) {
            return (int) (System.currentTimeMillis() - myStarttime);
        } else {
            return (int) (myStoptime - myStarttime);
        }
    }
}
