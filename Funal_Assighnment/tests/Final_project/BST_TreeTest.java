package Final_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BST_TreeTest {
    @Test
    void test1(){
        BST_Tree t=new BST_Tree();
        Binary_TreeNode root=new Binary_TreeNode(null);
        root=t.insert(root,5);
        root=t.insert(root,6);
        root=t.insert(root,4);
        root=t.insert(root,1);
        assertEquals(root.element,5);
        assertEquals(root.left.element,4);
        assertEquals(root.right.element,6);
        assertEquals(root.left.left.element,1);
    }
    @Test
    void test2(){
        /**
         * test isValidBST() function
         */
        BST_Tree t=new BST_Tree();
        Binary_TreeNode root=new Binary_TreeNode(null);
        root=t.insert(root,5);
        root=t.insert(root,6);
        root=t.insert(root,4);
        root=t.insert(root,1);
        assertTrue(t.isValidBST(root));
    }
    @Test
    void test3(){
        /**
         * test isValidBST() function
         * but this time i will make an invalid root to test if it throw false or not
         */
        Binary_TreeNode root=new Binary_TreeNode(null);
        BST_Tree t=new BST_Tree();
        root.element=5;
        Binary_TreeNode new_node1=new Binary_TreeNode(8);
        root.left=new_node1;
        Binary_TreeNode new_node2=new Binary_TreeNode(4);
        root.right=new_node2;
        /**
        here we make an inValid BST and pass the root to the isValid()
         the function's result false
         */
        assertFalse(t.isValidBST(root));
    }
    @Test
    void test4(){
        /**
         * test sumRange function
         */
        BST_Tree t=new BST_Tree();
        Binary_TreeNode root=new Binary_TreeNode(null);
        root=t.insert(root,5);
        root=t.insert(root,6);
        root=t.insert(root,4);
        root=t.insert(root,1);
        assertEquals(t.sumRange(root,1,6),16);
        assertEquals(t.sumRange(root,5,5),5);
        assertEquals(t.sumRange(root,10,15),0);
    }
    @Test
    void test_throw_exception(){
        /**
         * test sumRange function
         * function will throw exception if param(low)>param(high)
         */
        BST_Tree t=new BST_Tree();
        Binary_TreeNode root=new Binary_TreeNode(null);
        root=t.insert(root,5);
        root=t.insert(root,6);
        root=t.insert(root,4);
        root=t.insert(root,1);
        Binary_TreeNode finalRoot = root;
        assertThrows(RuntimeException.class,()->{t.sumRange(finalRoot,7,6);});
        }
    @Test
    void test5(){
        /**
        test nexSmallerNumber function
         arr:  is the array that will be passed to the faunction
         required_arr:  is the valid output array
         */
        BST_Tree t=new BST_Tree();
        int[]arr=new int[]{ 10, 9, 2, 7, 6, 1, 2 };
        int[]required_arr=new int[]{1, 2, 5, 4, 5, -1, -1 };
        assertArrayEquals(t.nextSmallerNumber(arr),required_arr);

    }
    @Test
    void test6(){
        /**
         test nexSmallerNumber function
         arr:  is the array that will be passed to the faunction
         required_arr:  is the valid output array
         */
        BST_Tree t=new BST_Tree();
        int[]arr=new int[]{1,2,3,4,5,2,0};
        int[]required_arr=new int[]{6,6,5,5,5,6,-1};
        assertArrayEquals(t.nextSmallerNumber(arr),required_arr);
    }
    @Test
    void test7(){
        /**
         test nexSmallerNumber function
         arr:  is the array that will be passed to the faunction
         required_arr:  is the valid output array
         */
        BST_Tree t=new BST_Tree();
        int[]arr=new int[]{1,2,3,4,5,6,7};
        int[]required_arr=new int[]{-1,-1,-1,-1,-1,-1,-1};
        assertArrayEquals(t.nextSmallerNumber(arr),required_arr);
    }
}