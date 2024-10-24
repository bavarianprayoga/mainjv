import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private final int groupId;
    private final String groupName;
    private List<Student> members;
    private StudyRoom currentRoom;
    private static int nextId = 1;

    public StudyGroup(String groupName) {
        this.groupId = nextId++;
        this.groupName = groupName;
        this.members = new ArrayList<>();
    }

    public boolean addMember(Student student) {
        if (members.size() < StudyRoom.MAX_CAPACITY && !members.contains(student)) {
            members.add(student);
            return true;
        }
        return false;
    }

    public boolean removeMember(Student student) {
        return members.remove(student);
    }

    public boolean reserveRoom(StudyRoom room, TimeSlot timeSlot) {
        if (room.reserve(timeSlot)) {
            if (currentRoom != null) {
                currentRoom.release();
            }
            this.currentRoom = room;
            return true;
        }
        return false;
    }

    // Getters
    public int getGroupId() { return groupId; }
    public String getGroupName() { return groupName; }
    public List<Student> getMembers() { return new ArrayList<>(members); }
    public StudyRoom getCurrentRoom() { return currentRoom; }
}