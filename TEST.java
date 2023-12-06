public class TEST {
    //-------------------------------AlterSortieren----------------------------------------
    public void prioEnqueue(Patient patient) {
        if (patient == null) {
            return;
        }
        Node newNode = new Node(patient, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            if (patient.getAge() < ((Patient) head.getContent()).getAge()) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node current = head;
                while (current.getNext() != null && ((Patient) current.getNext().getContent()).getAge() < patient.getAge()) {
                    current = current.getNext();
                }
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                if (newNode.getNext() == null) {
                    tail = newNode;
                }
            }
        }
    }
    public class Patient {
        private String name;
        private int age;

        public Patient(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
    public class ArztPraxis {
        private Queue wartezimmer;
        public ArztPraxis() {
            this.wartezimmer = new Queue(null, null);
        }
        public void anmelden(Patient patient) {
            wartezimmer.prioEnqueue(patient);
            System.out.println(patient.getName() + " ist im Wartezimmer.");
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


        //-------------------------------NamenPrio----------------------------------------
        public void prioEnqueue(Object object) {
            if (object == null || !(object instanceof Patient)) {
                return;
            }
            Patient newPatient = (Patient) object;
            Node newNode = new Node(newPatient, null, null);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                if (newPatient.isPrivatelyInsured()) {
                    // Insert the new patient after the last privately insured patient
                    Node current = head;
                    while (current.getNext() != null && ((Patient) current.getNext().getContent()).isPrivatelyInsured()) {
                        current = current.getNext();
                    }
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    if (newNode.getNext() == null) {
                        tail = newNode;
                    }
                } else {
                    // Append the new patient at the end of the queue
                    tail.setNext(newNode);
                    tail = newNode;
                }
            }
        }
    }
}
