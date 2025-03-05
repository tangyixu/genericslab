package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Tiffany Tang
 */
public class LinkedListTests {

    @Test
    public void emptyListTest() {
        LinkedList<Integer> lI = new LinkedList();
        LinkedList<String> lS = new LinkedList();
        assertEquals(0, lI.size());
        assertEquals(0, lS.size());
    }

    @Test
    public void listAddSize10Nums() {
        LinkedList<String> lS = new LinkedList();
        LinkedList<Integer> lI = new LinkedList();
        for (int i = 0; i < 10; i++) {
            lS.add(Integer.toString(i));
            lI.add(i);
        }
        assertEquals(10, lS.size());
        assertEquals(10, lI.size());
    }

    @Test
    public void listGetSeveral() {
        LinkedList<String> lS = new LinkedList();
        LinkedList<Integer> lI = new LinkedList();
        String[] elements = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        int[] integers = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < elements.length; i++) {
            lS.add(elements[i]);
            lI.add(integers[i]);

        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], lS.get(i));
            assertEquals(elements[i], lI.get(i));
        }
    }

    @Test
    public void listGetEmpty() {
        LinkedList<String> l = new LinkedList();
        l.add("");
        assertEquals("", l.get(0));
    }

    @Test
    public void listGetOOB() {
        LinkedList<String> lS = new LinkedList();
        LinkedList<Integer> lI = new LinkedList();
        lS.add("hello!");
        lS.add("goodbye!");
        lS.add("huh?");
        lI.add(1);
        lI.add(2);
        lI.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.get(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.get(3);
        });

    }

    @Test
    public void listRemoveSome() {
        LinkedList<String> lS = new LinkedList();
        LinkedList<Integer> lI = new LinkedList();

        lS.add("!");
        lS.add("@");
        lS.add(".");
        lS.add("#");
        lS.add("&");
        lI.add(5);
        lI.add(8);
        lI.add(7);
        lI.add(1);
        lI.add(9);

        assertEquals(7, lI.remove(2));
        assertEquals(8, lI.get(1));
        assertEquals(1, lI.get(2));

        assertEquals(5, lI.remove(0));
        assertEquals(8, lI.get(0));

        assertEquals(9, lI.remove(2));
        assertEquals(1, lI.get(1));

        assertEquals(".", lS.remove(2));
        assertEquals("@", lS.get(1));
        assertEquals("#", lS.get(2));

        assertEquals("!", lS.remove(0));
        assertEquals("@", lS.get(0));

        assertEquals("&", lS.remove(2));
        assertEquals("#", lS.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedList<String> lS = new LinkedList();
        LinkedList<Integer> lI = new LinkedList();
        lS.add("A");
        lS.add("B");
        lS.add("C");
        lI.add(5);
        lI.add(8);
        lI.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lS.remove(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lI.remove(3);
        });
    }
}
