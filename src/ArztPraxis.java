public class ArztPraxis {
    private Queue wartezimmer;

    public ArztPraxis() {
        this.wartezimmer = new Queue(null, null);
    }

    public void anmelden(Patient patient) {
        wartezimmer.prioEnqueue(patient);
        System.out.println(patient.getName() + " hat sich angemeldet und wartet im Wartezimmer.");
    }


    public void aufrufen() {
        if (!wartezimmer.isEmpty()) {
            Patient patient = (Patient) wartezimmer.front();
            wartezimmer.dequeue();
            System.out.println(patient.getName() + " wird zur Behandlung aufgerufen.");
        } else {
            System.out.println("Keine Patienten im Wartezimmer.");
        }
    }
}
