public class ListElement {
        private Object content;
        private ListElement next;
        private ListElement tail;

        public ListElement(ListElement prev, Object content, ListElement next) {
            this.tail = prev;
            this.content = content;
            this.next = next;
        }

        public Object getContent() {
            return content;
        }
        public void setContent(Object content) {
            this.content = content;
        }
        public ListElement getNext() {
            return next;
        }
        public void setNext(ListElement next) {
            this.next = next;
        }
        public ListElement getTail() {
            return tail;
        }
        public void setTail(ListElement tail) {
            this.tail = tail;
        }
}

