package Assignments;
class SList <T> {
    Link<T> link = new Link<>(null);
    public SListIterator iterator() {
        return new SListIterator(link);
    }
    public String toString() {
        if (link.data == null) {
            return "list is empty";
        }
        SListIterator<T> listIterator = new SListIterator<T>(link);
        String str = link.data.toString();
        while (listIterator.hasNext()) {
            str = str + "->" + listIterator.next();
        }
        return str;
    }
}
class Link<T> {
    T data;
    Link next;
    Link(T data) {
        new Link(data,null);
    }
    Link(T data, Link<T> next) {
        this.data = data;
        this.next = next;
    }
}
class SListIterator<T> {
    Link<T> list;
    SListIterator(Link<T> list) {
        this.list = list;
    }
    public void insert(T data) {
        if(list.data == null) {
            list.data = data;
            //list.next = null;
        }
        else {
            //System.out.println(data);
            list.next = new Link(data,null);
            list = list.next;
        }
    }
    public boolean hasNext() {
        if(list.next != null) {
            return true;
        }
        return false;
    }
    public T next() {
        T currData = list.data;
        list = list.next;
        return list.data;
    }
}
public class Assignment10 {
    public static void main(String[] args) {
        SList<Integer> list = new SList<Integer>();
        SListIterator<Integer> iterator = list.iterator();
        iterator.insert(1);
        iterator.insert(2);
        iterator.insert(3);
        iterator.insert(4);
        iterator.insert(5);
        System.out.println(list);
    }
}

