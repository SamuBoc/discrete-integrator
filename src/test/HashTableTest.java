package util;

import org.junit.Test;

import static org.junit.Assert.*;


public class HashTableTest {

    private void setupScenary1() {
    }

    @Test
    public void testAddHashTable() {
        setupScenary1();


    HashTable<String,String> hashTable=new HashTable<>();

    assertTrue(hashTable.addElement("Karen","Karen es un dinosaurio pastuso y pendiente"));
    System.out.println(hashTable.showTable());


    }


    }


