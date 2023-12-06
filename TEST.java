public class TEST {
    //-------------------------------LinkedLists----------------------------------------
    public class List implements ListInterface {
        private ListElement anchor;
        private ListElement current;
        //private ListElement prev;

        @Override
        public boolean isEmpty() {
            return anchor == null;
        }

        @Override
        public boolean hasAccess() {
            return current != null;
        }

        @Override
        public void next() {
            if (!isEmpty() && hasAccess() && current.getNext() != null) {
                current = current.getNext();
            } else {
                current = null;
            }
        }

        @Override
        public void toFirst() {
            if (!isEmpty()) {
                current = anchor;
            }
        }

        @Override
        public void toLast() {
            if (!isEmpty()) {
                while (current.getNext() != null) {
                    current = current.getNext();
                }
            }
        }

        @Override
        public Object getObject() {
            if (hasAccess()) {
                return current.getContent();
            } else {
                return null;
            }
        }

        @Override
        public void setObject(Object pObject) {
            if (hasAccess() && pObject != null) {
                current.setContent(pObject);
            }
        }

        @Override
        public void append(Object pObject) {
            if (pObject != null) {
                if (isEmpty()) {
                    anchor = new ListElement(pObject, null);
                } else {
                    ListElement temp = anchor;
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(new ListElement(pObject, null));
                }
            }
        }

        @Override
        public void insert(Object pObject) {
            if (pObject != null) {
                if (this.isEmpty()) {
                    anchor = new ListElement(pObject, null);
                } else if (this.hasAccess()) {
                    ListElement temp = new ListElement(pObject, current);
                    if (current == anchor) {
                        anchor = temp;
                    } else {
                        ListElement prev = anchor;
                        while (prev.getNext() != current) {
                            prev = prev.getNext();
                        }
                        prev.setNext(temp);
                    }
                    current = temp;
                }
            }
        }


        @Override
        public void concat(List pList) {
            if (pList != null && !pList.isEmpty()) {
                if (isEmpty()) {
                    anchor = pList.anchor;
                } else {
                    ListElement temp = anchor;
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(pList.anchor);
                }
            }
        }


        @Override
        public void remove() {
            if (this.hasAccess()) {
                if (current == anchor) {
                    anchor = anchor.getNext();
                } else {
                    ListElement temp = anchor;
                    while (temp.getNext() != current) {
                        temp = temp.getNext();
                    }
                    temp.setNext(current.getNext());
                }
                if (current.getNext() != null) {
                    current = current.getNext();
                } else {
                    current = null;
                }
            }
        }
    }
//-----------------------------------DoubleLinked--------------------------------------
@Override
public void insert(Object pObject) {
    if (pObject != null) {
        if (isEmpty()) {
            anchor = new ListElement(pObject, null, null);
            current = anchor;
        } else {
            ListElement temp = new ListElement(pObject, current, current.getPrev());
            if (current.getPrev() != null) {
                current.getPrev().setNext(temp);
            }
            current.setPrev(temp);
            current = temp;
            if (current.getPrev() == null) {
                anchor = current;
            }
        }
    }
}

    @Override
    public void remove() {
        if (hasAccess()) {
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            }
            if (current.getNext() != null) {
                current.getNext().setPrev(current.getPrev());
            }
            if (current == anchor) {
                anchor = current.getNext();
            }
            current = current.getNext();
        }
    }

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
