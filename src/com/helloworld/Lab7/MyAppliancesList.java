package OOP.Lab7_8;


import java.util.*;


public class MyAppliancesList implements List<ElectricalAppliances> {
    private Node head;
    private Node tail;
    private int size;

    class Node {
        private ElectricalAppliances data;
        private Node next;

        Node(ElectricalAppliances elem, Node next) {
            data = elem;
            this.next = next;
        }

        ElectricalAppliances getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    public MyAppliancesList() {
        head = tail = null;
        size = 0;
    }

    public MyAppliancesList(ElectricalAppliances appliance) {
        add(appliance);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node currentElement = head;
        for (int i = 0; i < size; i++) {
            if (currentElement.data == o) {
                return true;
            }
            currentElement = currentElement.getNext();
        }
        return false;
    }

    @Override
    public Iterator<ElectricalAppliances> iterator() {
        return new Iterator<ElectricalAppliances>() {
            private Node currentElement = head;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return currentElement.next != null;
            }

            @Override
            public ElectricalAppliances next() throws NoSuchElementException {
                if (index == 0) {
                    index++;
                    return currentElement.getData();
                } else if (index == size()) {
                    throw new NoSuchElementException();
                } else {
                    index++;
                    currentElement = currentElement.getNext();
                }
                return currentElement.getData();
            }
        };
    }

    @Override
    public ElectricalAppliances[] toArray() {
        ElectricalAppliances[] arr = new ElectricalAppliances[size];
        Node currentElement = head;
        for (int i = 0; i < size; i++) {
            arr[i] = currentElement.getData();
            currentElement = currentElement.getNext();
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(ElectricalAppliances appliance) {
        if (!contains(appliance)) {
            Node node = new Node(appliance, null);
            if (size == 0) {
                head = tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node previous = null;
        Node currentElement = head;
        int i = 0;
        int count = 0;
        for (; i < size; i++) {
            if (currentElement.data == o) {
                if (currentElement == head) {
                    head = currentElement.getNext();
                    currentElement = head;
                    count++;
                    continue;
                }
                if (currentElement == tail) {
                    tail = null;
                    count++;
                    break;
                } else {
                    previous.next = currentElement.getNext();
                    count++;
                }
            }
            previous = currentElement;
            currentElement = currentElement.getNext();
        }
        size -= count;
        return count != 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int subSize = 0;
        for (Object element : c) {
            if (contains((ElectricalAppliances) element)) {
                subSize++;
            }
        }
        return subSize == size();
    }

    @Override
    public boolean addAll(Collection collection) {
        for (Object appliance : collection) {
            add((ElectricalAppliances) appliance);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends ElectricalAppliances> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (contains((ElectricalAppliances) o)) {
                remove((ElectricalAppliances) o);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node currentElement = head;
        for (int i = 0; i < size(); i++) {
            boolean flag = false;
            for (Object o : c) {
                if (!c.contains(currentElement.getData())) {
                    flag = true;
                }
            }
            if (flag) {
                remove(currentElement.data);
            }
            currentElement = currentElement.getNext();
        }
        return true;
    }

    @Override
    public void clear() {
        Node currentElement = head;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (head == tail) {
                head = tail = null;
            }
            head = currentElement.getNext();
            currentElement = head;
            count++;
        }
        size -= count;
    }

    @Override
    public ElectricalAppliances get(int index) throws IndexOutOfBoundsException {
        if (0 < index || index < size()) {
            Node currentElement = gotoIndex(index);
            return currentElement.getData();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ElectricalAppliances set(int index, ElectricalAppliances element) {
        Node currentElement = gotoIndex(index);
        currentElement.data = element;
        return currentElement.getData();

    }

    @Override
    public void add(int index, ElectricalAppliances element) {
        if (index == 0) {
            head = new Node(element, head);
        }
        if (index == size - 1) {
            Node newElement = new Node(element, null);
            tail.setNext(newElement);
            tail = newElement;
        }
        Node currentElement = straightGoing(index);
        Node nextElement = straightGoing(index + 1);
        Node newElement = new Node(element, nextElement);
        currentElement.setNext(newElement);
    }

    @Override
    public ElectricalAppliances remove(int index) {
        Node currentElement = gotoIndex(index);
        currentElement = currentElement.next;
        currentElement.next = null;
        size--;
        return currentElement.getData();
    }

    @Override
    public int indexOf(Object o) throws NullPointerException {
        Node currentElement = head;
        for (int i = 0; i < size; i++) {
            if (currentElement.getData() != null) {
                if (currentElement.data == o) {
                    return i;
                }
                currentElement = currentElement.next;
            } else {
                throw new NullPointerException();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node currentElement = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (currentElement.data == o) {
                index = i;
            }
            currentElement = currentElement.next;
        }
        return index;
    }

    @Override
    public ListIterator<ElectricalAppliances> listIterator() {
        return new ListIterator<ElectricalAppliances>() {
            private Node currentElement = head;
            private Node previous = null;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return currentElement.getNext() != null;
            }

            @Override
            public ElectricalAppliances next() throws NoSuchElementException {
                if (index == 0) {
                    index++;
                    return currentElement.getData();
                } else if (index == size()) {
                    throw new NoSuchElementException();
                } else {
                    index++;
                    previous = currentElement;
                    currentElement = currentElement.next;
                    return currentElement.getData();
                }
            }

            @Override
            public boolean hasPrevious() {
                return previous != null;
            }

            @Override
            public ElectricalAppliances previous() throws NoSuchElementException {
                if (index > 1) {
                    index--;
                    currentElement = previous;
                    previous = gotoIndex(index - 2);
                    return currentElement.getData();
                } else {
                    currentElement = head;
                    previous = null;
                    index = 0;
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                if (currentElement == head) {
                    head = currentElement.next;
                    currentElement = head;
                } else if (currentElement == tail) {
                    tail = null;

                } else {
                    previous.next = currentElement.next;
                }
                size--;
            }

            @Override
            public void set(ElectricalAppliances appliance) {
                currentElement.data = appliance;
            }

            @Override
            public void add(ElectricalAppliances appliance) {
                Node node = new Node(appliance, null);
                if (size == 0) {
                    head = tail = node;
                } else {
                    tail.setNext(node);
                    tail = node;
                }
                size++;
            }
        };
    }

    @Override
    public ListIterator<ElectricalAppliances> listIterator(int i) {
        return new ListIterator<ElectricalAppliances>() {
            private Node currentElement = gotoIndex(i);
            private Node previous = gotoIndex(i - 1);
            private int index = i;

            @Override
            public boolean hasNext() {
                return currentElement.next != null;
            }

            @Override
            public ElectricalAppliances next() throws NoSuchElementException {
                if (index == 0) {
                    index++;
                    return currentElement.getData();
                } else if (index == size()) {
                    throw new NoSuchElementException();
                } else {
                    index++;
                    previous = currentElement;
                    currentElement = currentElement.next;
                    return currentElement.getData();
                }
            }

            @Override
            public boolean hasPrevious() {
                return gotoIndex(index - 1) != null;
            }

            @Override
            public ElectricalAppliances previous() throws NoSuchElementException {
                if (index > 1) {
                    index -= 1;
                    currentElement = previous;
                    previous = gotoIndex(index - 2);
                    return currentElement.getData();
                }
                throw new NoSuchElementException();
            }


            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                if (currentElement == head) {
                    head = currentElement.next;
                    currentElement = head;
                } else if (currentElement == tail) {
                    tail = null;
                } else {
                    previous.next = currentElement.getNext();
                }
                size--;
            }

            @Override
            public void set(ElectricalAppliances appliance) {
                currentElement.data = appliance;
            }

            @Override
            public void add(ElectricalAppliances appliance) {
                Node node = new Node(appliance, null);
                if (size == 0) {
                    head = tail = node;
                } else {
                    tail.setNext(node);
                    tail = node;
                }
                size++;
            }
        };
    }

    @Override
    public List<ElectricalAppliances> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node straightGoing(int indexOfElement) {
        Node currentElement = head;
        for (int i = 0; i < indexOfElement; i++) {
            currentElement = currentElement.next;
        }
        return currentElement;
    }


    private Node gotoIndex(int index) {
        Node currentElement;
        currentElement = straightGoing(index);
        return currentElement;
    }

    @Override
    public String toString() {
        Node currentElement = head;
        StringBuilder result = new StringBuilder("[");
        if (size == 0) {
            return "[]";
        }
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result.append(currentElement.getData().toString());
                result.append("]");
                currentElement = currentElement.next;
                continue;
            }
            result.append(currentElement.getData().toString());
            result.append(", ");
            currentElement = currentElement.next;
        }
        return result.toString();
    }
}