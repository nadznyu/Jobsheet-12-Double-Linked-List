import java.util.Scanner;

public class DoubleLinkedList16 {
    Node16 head;
    Node16 tail;

    public DoubleLinkedList16() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa16 data) {
        Node16 newNode16 = new Node16(data);
        if (isEmpty()) {
            head = tail = newNode16;
        } else {
            newNode16.next = head;
            head.prev = newNode16;
            head = newNode16;
        }
    }

    public void addLast(Mahasiswa16 data) {
        Node16 newNode16 = new Node16(data);
        if (isEmpty()) {
            head = tail = newNode16;
        } else {
            tail.next = newNode16;
            newNode16.prev = tail;
            tail = newNode16;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa16 data) {
        Node16 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node16 newNode16 = new Node16(data);

        //jika current adalah tail, node baru ditambahkan di akhir
        if (current == tail) {
            newNode16.prev = current;
            current.next = newNode16;
            tail = newNode16;
        } else { //node baru disisipkan di tengah
            newNode16.prev = current;
            newNode16.next = current.next;
            current.next.prev = newNode16;
            current.next = newNode16;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }

        Node16 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data berhasil dihapus.");
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data berhasil dihapus.");
    }

    static Mahasiswa16 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM  : ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama : ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK  : ");
        double ipk = Double.parseDouble(scan.nextLine());
        return new Mahasiswa16(nim, nama, kelas, ipk);

    }
}
