import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeSlot {
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isScheduled;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public TimeSlot(Date date, LocalTime startTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(2);  // Automatically add 2 hours
        this.isScheduled = false;
    }

    public boolean isAvailable() {
        return !isScheduled;
    }

    public void schedule() {
        this.isScheduled = true;
    }

    public void cancel() {
        this.isScheduled = false;
    }

    public Date getDate() { return date; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public boolean isScheduled() { return isScheduled; }

    @Override
    public String toString() {
        return String.format("%tF %s - %s",
                date,
                startTime.format(timeFormatter),
                endTime.format(timeFormatter));
    }

    // Helper method to parse time input
    public static LocalTime parseTime(String timeStr) throws DateTimeParseException {
        return LocalTime.parse(timeStr, timeFormatter);
    }
}