public class DoubleLinkedList25 {
    Node25 head;
    Node25 tail;
    int size;

    public DoubleLinkedList25() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa25 data) {
        Node25 newNode25 = new Node25(data);
        if (isEmpty()) {
            head = tail = newNode25;
        } else {
            head.prev = newNode25;
            newNode25.next = head;
            head = newNode25;
        }
    }

    public void addLast(Mahasiswa25 data) {
        Node25 newNode25 = new Node25(data);
        if (isEmpty()) {
            head = tail = newNode25;
        } else {
            tail.next = newNode25;
            newNode25.prev = tail;
            tail = newNode25;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa25 data) {
        Node25 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node25 newNode = new Node25(data);

        // jika current adalah tail, ndoe baru ditambahkan di akhir
        if (current == tail) {
            newNode.prev = current;
            current.next = newNode;
            tail = newNode;
            // node baru di sisipkan di tengah
        } else {
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Data behasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }

        Node25 current = head;

        while (current != null) {
            current.data.tampilInformasi();
            current = current.next;
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node25 current = tail;
        while (current != null) {
            current.data.tampilInformasi();
            current = current.prev;
        }
    }
}