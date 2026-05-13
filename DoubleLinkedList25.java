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

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }

        // menampilkan yang dihapus
        System.out.println("Data berhasil dihapus.: ");
        head.data.tampilInformasi();

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }

        // menampilkan data yang dihapus
        System.out.println("Data berhasil dihapus.: ");
        tail.data.tampilInformasi();

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void removeAfter(String keyNim) {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }
        Node25 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data dengan key tidak ditemukan");
        }

        if (current.next == null) {
            System.out.println("Tidak ada node setelah data tersebeut.");
            return;
        }
        Node25 hapus = current.next;
        hapus.data.tampilInformasi();

        if (hapus == tail) {
            current.next = hapus.next;
            hapus.next.prev = current;
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }

        if (index < 0 || index >= size) {
            System.out.println("Indeks di luar batas.");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {

            Node25 current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            System.out.println("Data yang dihapus:");
            current.data.tampilInformasi();

            current.prev.next = current.next;
            current.next.prev = current.prev;

            size--;
        }
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }

        System.out.println("Data node pertama:");
        head.data.tampilInformasi();
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }

        System.out.println("Data node terakhir:");
        tail.data.tampilInformasi();
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }

        if (index < 0 || index >= size) {
            System.out.println("Indeks di luar batas.");
            return;
        }

        Node25 current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        System.out.println("Data pada indeks ke-" + index + ":");
        current.data.tampilInformasi();
    }
}