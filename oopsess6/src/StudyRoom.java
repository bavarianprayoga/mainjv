public class StudyRoom {
    private int roomId;
    public static final int MAX_CAPACITY = 10;
    private boolean isOccupied;
    private TimeSlot currentTimeSlot;
    private static int nextId = 1;

    public StudyRoom() {
        this.roomId = nextId++;
        this.isOccupied = false;
    }

    public boolean reserve(TimeSlot timeSlot) {
        if (!isOccupied && timeSlot.isAvailable()) {
            this.currentTimeSlot = timeSlot;
            this.isOccupied = true;
            timeSlot.schedule();
            return true;
        }
        return false;
    }

    public void release() {
        if (currentTimeSlot != null) {
            currentTimeSlot.cancel();
            currentTimeSlot = null;
        }
        isOccupied = false;
    }

    public boolean checkAvailability() {
        return !isOccupied;
    }

    // Getters
    public int getRoomId() { return roomId; }
    public boolean isOccupied() { return isOccupied; }
    public TimeSlot getCurrentTimeSlot() { return currentTimeSlot; }
}