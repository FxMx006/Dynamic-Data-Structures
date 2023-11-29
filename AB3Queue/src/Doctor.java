import java.util.LinkedList;
import java.util.Queue;

class Doctor {
    Queue<Patient> waitingRoom = new LinkedList<>();

    public void admitPatient(Patient patient) {
        if (patient.isPrivate) {
            Queue<Patient> tempQueue = new LinkedList<>();
            while (!waitingRoom.isEmpty() && waitingRoom.peek().isPrivate) {
                tempQueue.add(waitingRoom.poll());
            }
            waitingRoom.add(patient);
            while (!tempQueue.isEmpty()) {
                waitingRoom.add(tempQueue.poll());
            }
        } else {
            waitingRoom.add(patient);
        }
    }

    public Patient callPatient() {
        return waitingRoom.poll();
    }
}
