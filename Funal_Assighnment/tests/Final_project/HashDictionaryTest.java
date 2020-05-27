package Final_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashDictionaryTest {

        @Test
        void test1(){
            HashDictionary D=new HashDictionary();
            D.set("Apple","تفاحة");
            D.set("Book","كتاب");
            D.set("tree","شجرة");
            assertEquals(D.get("Apple"),"تفاحة");
            assertEquals(D.get("Book"),"كتاب");
            assertEquals(D.get("tree"),"شجرة");
        }
        @Test
        void test2(){
           HashDictionary D=new HashDictionary();
            D.set(8,"تفاحة");
            D.set(5,9);
            D.set(7,8);
            assertEquals(D.get(8),"تفاحة");
            assertEquals(D.get(5),9);
            assertEquals(D.get(7),8);
        }
        @Test
        void test3(){
            /**
             * test set function when you insert a key which is already exist
             * it will return the value of this key
             */
            HashDictionary D=new HashDictionary();
            D.set(8,9);
            assertEquals(D.set(8,7),9);
        }
        @Test
        void test4(){
            /**
             * test remove function
             */
           HashDictionary D=new HashDictionary();
            D.set(8,9);
            assertEquals(D.get(8),9);
            D.remove(8);
            assertEquals(D.get(8),null);
        }
        @Test
        void test5(){
            /**
             * test remove function
             */
            HashDictionary D=new HashDictionary();
            D.set(8,9);
            assertEquals(D.get(8),9);
            D.remove(8);
            assertEquals(D.get(8),null);
        }
        @Test
        void test6(){
            /**
             * test isEmpty function
             */
            HashDictionary D=new HashDictionary();
            D.set(8,9);
            assertEquals(D.isEmpty(),false);
            assertEquals(D.get(8),9);
            D.remove(8);
            assertEquals(D.isEmpty(),true);
        }

}