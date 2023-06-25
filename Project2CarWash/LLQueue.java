import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * The LLQueue class contains the methods needed to implement the KQueue class
 * and represents a linked list that functions as a queue-style data structure.
 *
 * @author Caroline Lamb
 * @version 10/4/2021
 */
public class LLQueue<T> implements KQueue<T>, Iterable
{
    // Instance variable to implement the linked list as a the queue. 
    private LinkedList<T> list;

    /**
     * Constructs the queue in the form of a linked list. 
     */
    public LLQueue()
    {
        list = new LinkedList<T>();
    }

    /** Returns <code>true</code> if this queue is empty;
     *  <code>false</code> otherwise.
     **/
    public boolean isEmpty()
    {
        if ( list.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** Adds a specified object to the "back" of this queue.
     *    @param item - the object to add to the queue
     **/
    public void enqueue(T item)
    {
        list.addLast(item); 
    }

    /** Removes the element at the "front" of this queue.
     *    @returns the removed element
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T dequeue() 
    {
        // As long as the list is not empty, remove an item. 
        if (list.isEmpty())
        {
            throw new NoSuchElementException();
        }
        T item = list.remove();
        return item;
    }

    /** Returns the element at the "front" of this queue, without
     *  modifying the queue.
     *    @returns the element at the front of the queue
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T peekFront()
    {
        T element = list.peekFirst();
        return element;
    }

    /**
     * Converts items in the list into a string. 
     *
     * @return    a string representation of the list, 
     */
    public String toString()
    {
        return list.toString();
    }

    /**
     * Gets the size of the list of objects.
     * 
     * @return    the size of the list. 
     *
     */
    public int size() 
    {
        return list.size();
     }
     
    /**
     *  Creates the iterator object used in the CarWashApplication class to
     *  loop through the queue. 
     *  
     * @return  an Iterator object that takes type T. 
     */
    public Iterator<T> iterator() 
    {
        return list.iterator();
    }
}
