package Seminar3;

public class ListRevert {
    public static void main(String[] args) {
        SingleLinkedList l = new SingleLinkedList();
        for(int i = 0; i <= 5; i++){
            l.addBack(i);
        }
        l.printList();
        l.addAfter(4, 4);
        l.printList();
        l = l.revertList();
        l.printList();
    }
}

class Node<T> {
    Node next;
    T data;
}

class SingleLinkedList<T> {
    private Node head;
    private Node tail;
    
    public SingleLinkedList revertList(){
        Node t = this.head;
        SingleLinkedList temp = new SingleLinkedList();
        if(this == null){
            return this;
        };
        while(t != null){
            temp.addFront(t.data);
            t = t.next;
        }
        return temp;
    }
    public void addFront(T data)
    {
        Node a = new Node();
        a.data = data;
        if(head == null)
        {
            head = a;
            tail = a;
        }
        else {
            a.next = head;
            head = a;
        }
    }

    public void addBack(T data) {
        Node a = new Node();
        a.data = data;
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    public void printList()
    {
        Node t = this.head;
        while (t != null)
        {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }


    public void addAfter(T prevEl, T nextEl){
        Node t = this.head;
        while (t!=null){
            if(prevEl==t.data){
                Node e = new Node();
                e.data = nextEl;
                e.next = t.next;
                t.next = e;
                t =e;
            }
            t = t.next;
        }

    }

    void delEl(T data)
    {
        if(head == null)
            return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node t = head;
        while (t.next != null) {
            if (t.next.data == data) {
                if(tail == t.next)
                {
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }
}