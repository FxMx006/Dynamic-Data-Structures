public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Patient patient1 = new Patient("Patient1", false);
        Patient patient2 = new Patient("Patient2", true);
        Patient patient3 = new Patient("Patient3", false);
        Patient patient4 = new Patient("Patient4", true);

        doctor.admitPatient(patient1);
        doctor.admitPatient(patient2);
        doctor.admitPatient(patient3);
        doctor.admitPatient(patient4);

        Patient nextPatient = doctor.callPatient();
        while (nextPatient != null) {
            System.out.println("Calling patient: " + nextPatient.name);
            nextPatient = doctor.callPatient();
        }
    }
}
