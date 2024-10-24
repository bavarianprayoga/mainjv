import java.util.Date;
import java.time.LocalTime;

public class TimeSlot {
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isScheduled;

    public TimeSlot(Date date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
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

    // Getters and setters
    public Date getDate() { return date; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public boolean isScheduled() { return isScheduled; }
}