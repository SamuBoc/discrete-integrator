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
        assertTrue(hashTable.addElement("Karem","Karen es un dinosaurio pastuso y pendiente"));
        assertTrue(hashTable.addElement("OptimusPrime","Optimus es un robot gigante"));
        assertTrue(hashTable.addElement("Serpiente","Las serpientes son peligrosas"));
        assertTrue(hashTable.addElement("Permiso","Si no me das un permiso corremos peligro!"));
        assertTrue(hashTable.addElement("Karee","Karen es un dinosaurio pastuso y pendiente"));
        assertTrue(hashTable.addElement("Kares","Karen es un dinosaurio pastuso y pendiente"));
        assertTrue(hashTable.addElement("OptimusPrimes","Optimus es un robot gigante"));
        assertTrue(hashTable.addElement("Serpientes","Las serpientes son peligrosas"));
        assertTrue(hashTable.addElement("Permisos","Si no me das un permiso corremos peligro!"));
    System.out.println(hashTable.showTable()+"\n\n"+hashTable.search(3,1)+"\n\n"+ hashTable.search(7,2));


    }


    }


