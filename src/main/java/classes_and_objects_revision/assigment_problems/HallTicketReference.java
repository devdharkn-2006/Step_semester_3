package classes_and_objects_revision.assigment_problems;

class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketReference {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        // Key idea: assigning an object variable copies the reference, not the object,
        // so both names point at the same ticket and a change through one shows in the other.
        HallTicket copy = priya;
        copy.seatNumber = 45;
        // A new object with equal field values is still a different object, so == is false.
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
