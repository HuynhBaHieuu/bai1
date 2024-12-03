/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myLinkedList;

/**
 *
 * @author Admin
 */
public class MyLinkedList {

    private Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println();
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void add(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        } else {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            deleteFirst();
        }
        Node temp = head;// temp: find last node to delete
        Node previous = null;// record node before temp
        while (temp.next != null) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size() - 1) {
            deleteLast();
            return;
        } else {
            Node preNodeDelete = head; // find index position to delete
            int count = 1;
//            for(int i = 1; i < index; i++){
//                preNodeDelete = preNodeDelete.next;
//            }
//            preNodeDelete.next= preNodeDelete.next.next;
            while (count < index) {
                preNodeDelete = preNodeDelete.next;
                count++;
            }
            preNodeDelete.next = preNodeDelete.next.next;
        }
    }

    public boolean search(int data) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        /*
        temp != null:  Sử dụng khi muốn cầm tất cả các node trong
        linkedLis đem ra xử lí, hay làm gì đó. Căn bản là câu lệnh
        này sẽ bốc từ node đầu tiên đến khi nào kết thúc (temp = null)
        temp.next != null: sử dụng khi muốn tìm ra cái node cuối cùng và gán nó cho temp
         */
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
        }
        return false;
    }

    public Node searchAtPosition(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void sort() {
        if (head == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current != null && current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        printList();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(0);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.printList();
        //2-1-0
        System.out.println("Lenght: " + linkedList.size());;
        System.out.println("After delete: ");
//        linkedList.deleteLast();
//        linkedList.delete(1);
//        linkedList.printList();
        linkedList.sort();
    }
}
