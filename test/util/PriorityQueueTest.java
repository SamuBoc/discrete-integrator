package util;

import org.junit.Test;

import static org.junit.Assert.*;
public class PriorityQueueTest {

    private void setupScenary1() {
        testAddHashTable();
    }

    @Test
    public void testAddHashTable() {

        setupScenary1();

        PriorityQueue<Integer> sup = new PriorityQueue<>(Integer::compareTo);

            sup.offer(5);
        sup.offer(7);
        sup.offer(6);
        sup.offer(1);
        sup.offer(5);
        sup.offer(10);
        sup.offer(8);
        sup.offer(11);
        sup.offer(11);

        while(!sup.isEmpty()){

            System.out.println(sup.poll());

        }

    }

    @Test
    public String testSout(){
        String out = "";

        PriorityQueue<Integer> sup = new PriorityQueue<>(Integer::compareTo);

        sup.offer(5);
        sup.offer(7);
        sup.offer(6);
        sup.offer(1);
        sup.offer(5);
        sup.offer(10);
        sup.offer(8);
        sup.offer(11);
        sup.offer(11);

        System.out.println(sup.toString());

        return out;
    }



}
