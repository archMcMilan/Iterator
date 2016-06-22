/**
 * Created by Artem on 22.06.16.
 */
public class IteratorApp {
    public static void main(String[] args) {
        ConcreteAggreagate c=new ConcreteAggreagate();

        Iterator iterator=c.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
interface Iterator{
    boolean hasNext();
    Object next();
}

interface Aggregate{
    Iterator getIterator();
}

class ConcreteAggreagate implements Aggregate{
    String[] tasks={"Build a house","Grow up son","Grow a tree"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator{
        int index=0;

        @Override
        public boolean hasNext() {
            if(index<tasks.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(hasNext()){
                return tasks[index++];
            }
            return null;
        }
    }
}