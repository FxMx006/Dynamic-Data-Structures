public class main {
    public static void main(String[] args) {
        ArztPraxis praxis = new ArztPraxis();
        praxis.anmelden(new Patient("Patient 1", 12));
        praxis.anmelden(new Patient("Patient 2", 31));
        praxis.anmelden(new Patient("Patient 3", 20));

        praxis.aufrufen();
        praxis.aufrufen();
        praxis.aufrufen();
    }
}
