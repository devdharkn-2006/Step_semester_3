package oop_classes_and_objects.assigment_problems;

// Key idea: instance fields are per-object, so changing hallA never affects hallB.
class ExamHall {
    String hallName;
    int seatsFilled;
}

public class ExamHallOccupancy {
    public static void main(String[] args) {
        ExamHall hallA = new ExamHall();
        hallA.hallName = "Block-3 Hall A";
        ExamHall hallB = new ExamHall();
        hallB.hallName = "Block-3 Hall B";

        for (int i = 0; i < 4; i++) {
            hallA.seatsFilled++; // only hallA is incremented
        }

        System.out.println(hallA.hallName + " seatsFilled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seatsFilled: " + hallB.seatsFilled);
    }
}
