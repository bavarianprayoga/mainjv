import java.util.*;
import java.time.LocalTime;

public class StudyRoomManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static List<StudyRoom> studyRooms = new ArrayList<>();
    private static List<StudyGroup> studyGroups = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    createStudyGroup();
                    break;
                case 2:
                    viewStudyGroups();
                    break;
                case 3:
                    addStudentToGroup();
                    break;
                case 4:
                    removeStudentFromGroup();
                    break;
                case 5:
                    createStudyRoom();
                    break;
                case 6:
                    viewStudyRooms();
                    break;
                case 7:
                    deleteStudyRoom();
                    break;
                case 8:
                    reserveRoom();
                    break;
                case 9:
                    System.out.println("Thank you for using Study Room Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Study Room Management System ===");
        System.out.println("\n=== Study Group ===");
        System.out.println("1. Create Study Group");
        System.out.println("2. View Study Groups");
        System.out.println("3. Add Student to Group");
        System.out.println("4. Remove Student from Group");
        System.out.println("\n=== Study Room ===");
        System.out.println("5. Create Study Room");
        System.out.println("6. View Study Rooms");
        System.out.println("7. Delete Study Room");
        System.out.println("8. Reserve Room");
        System.out.println("\n");
        System.out.println("9. Exit");
        System.out.println("===================================");
    }

    private static void createStudyGroup() {
        System.out.println("\n=== Create Study Group ===");
        String groupName = getStringInput("Enter group name: ");
        StudyGroup group = new StudyGroup(groupName);

        System.out.println("Initial students can be added using the 'Add Student to Group' option.");
        studyGroups.add(group);
        System.out.println("Study group created successfully! Group ID: " + group.getGroupId());
    }

    private static void createStudyRoom() {
        StudyRoom room = new StudyRoom();
        studyRooms.add(room);
        System.out.println("Study room created successfully! Room ID: " + room.getRoomId());
    }

    private static void viewStudyGroups() {
        System.out.println("\n=== Study Groups ===");
        if (studyGroups.isEmpty()) {
            System.out.println("No study groups available.");
            return;
        }

        for (StudyGroup group : studyGroups) {
            System.out.println("\nGroup ID: " + group.getGroupId());
            System.out.println("Group Name: " + group.getGroupName());
            System.out.println("Members (" + group.getMembers().size() + "/" + StudyRoom.MAX_CAPACITY + "):");
            for (Student student : group.getMembers()) {
                System.out.println("- " + student.getName() + " (ID: " + student.getStudentId() + ")");
            }

            StudyRoom currentRoom = group.getCurrentRoom();
            if (currentRoom != null) {
                System.out.println("Current Room: " + currentRoom.getRoomId());
            }
        }
    }

    private static void viewStudyRooms() {
        System.out.println("\n=== Study Rooms ===");
        if (studyRooms.isEmpty()) {
            System.out.println("No study rooms available.");
            return;
        }

        for (StudyRoom room : studyRooms) {
            System.out.println("\nRoom ID: " + room.getRoomId());
            System.out.println("Status: " + (room.isOccupied() ? "Occupied" : "Available"));

            TimeSlot currentSlot = room.getCurrentTimeSlot();
            if (currentSlot != null) {
                System.out.println("Current Booking: " + currentSlot.getStartTime() + " - " + currentSlot.getEndTime());
            }
        }
    }

    private static void deleteStudyRoom() {
        viewStudyRooms();
        if (studyRooms.isEmpty()) {
            return;
        }

        int roomId = getIntInput("\nEnter room ID to delete: ");
        StudyRoom roomToDelete = findRoom(roomId);

        if (roomToDelete != null) {
            if (roomToDelete.isOccupied()) {
                System.out.println("Cannot delete room - it is currently occupied!");
            } else {
                studyRooms.remove(roomToDelete);
                System.out.println("Study room deleted successfully!");
            }
        } else {
            System.out.println("Room not found!");
        }
    }

    private static void reserveRoom() {
        if (studyGroups.isEmpty() || studyRooms.isEmpty()) {
            System.out.println("Need both study groups and rooms to make a reservation!");
            return;
        }

        System.out.println("\n=== Reserve Room ===");
        viewStudyGroups();
        int groupId = getIntInput("Enter group ID: ");
        StudyGroup group = findGroup(groupId);

        if (group == null) {
            System.out.println("Group not found!");
            return;
        }

        viewStudyRooms();
        int roomId = getIntInput("Enter room ID: ");
        StudyRoom room = findRoom(roomId);

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        // Simple time slot creation for demonstration
        Date today = new Date();
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        TimeSlot timeSlot = new TimeSlot(today, startTime, endTime);

        if (group.reserveRoom(room, timeSlot)) {
            System.out.println("Room reserved successfully!");
        } else {
            System.out.println("Failed to reserve room - it might be occupied!");
        }
    }

    private static void addStudentToGroup() {
        viewStudyGroups();
        if (studyGroups.isEmpty()) {
            System.out.println("No study groups available.");
            return;
        }

        int groupId = getIntInput("Enter group ID: ");
        StudyGroup group = findGroup(groupId);

        if (group == null) {
            System.out.println("Group not found!");
            return;
        }

        if (group.getMembers().size() >= StudyRoom.MAX_CAPACITY) {
            System.out.println("Group is at maximum capacity!");
            return;
        }

        int studentAmount = getIntInput("Enter student amount: ");

        for (int i = 0; i < studentAmount; i++) {
            System.out.println("\n Student " + (i + 1) + ": ");
            int studentId = getIntInput("Enter student ID: ");
            String studentName = getStringInput("Enter student name: ");

            Student student = new Student(studentId, studentName);
            if (group.addMember(student)) {
                System.out.println("Student added successfully!");
            } else {
                System.out.println("Failed to add student - they might already be in the group!");
            }
        }
    }

    private static void removeStudentFromGroup() {
        viewStudyGroups();
        if (studyGroups.isEmpty()) {
            return;
        }

        int groupId = getIntInput("Enter group ID: ");
        StudyGroup group = findGroup(groupId);

        if (group == null) {
            System.out.println("Group not found!");
            return;
        }

        int studentId = getIntInput("Enter student ID to remove: ");
        Student studentToRemove = null;

        for (Student student : group.getMembers()) {
            if (student.getStudentId() == studentId) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null && group.removeMember(studentToRemove)) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found in this group!");
        }
    }

    private static StudyRoom findRoom(int roomId) {
        for (StudyRoom room : studyRooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    private static StudyGroup findGroup(int groupId) {
        for (StudyGroup group : studyGroups) {
            if (group.getGroupId() == groupId) {
                return group;
            }
        }
        return null;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Please enter a positive number!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}