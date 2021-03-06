import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/////////////////////////////////////////////////////////////////////////////
// Semester:         CS400 Spring 2018
// PROJECT:          cs400_p2_201801
// FILES:            TestSearchTree.java
//                   SearchTreeADT.java
//                   BalancedSearchTree.java
//
// USER:             deppeler
//
// Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
// Bugs:             no known bugs, but not complete either
//
// 2018 Feb 8, 2018 5:13:18 PM TestSearchTree.java 
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * @author 
 *
 */
public class TestSearchTree {

	SearchTreeADT<String> stringTree = null;
	SearchTreeADT<Integer> iTree = null;
	String expected = null;
	String actual = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Used for setting up static tables and info you might need for the class
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Run before EACH TEST so new BSTs
		stringTree = new BalancedSearchTree<String>();
		iTree = new BalancedSearchTree<Integer>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Tear down everything after class
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Close out test specific variables
	}

	@Test
	public void test01_isEmpty_on_empty_tree() {
		expected = "true";
		actual = "" + stringTree.isEmpty();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}

	@Test
	public void test02_ascending_order_on_empty_tree() {
		expected = "";
		actual = stringTree.inAscendingOrder();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}

	@Test
	/** tests that the height of an empty tree is 0 */
	public void test03_height_on_empty_tree() {
		expected = "0";
		actual = "" + stringTree.height();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}

	@Test
	public void test04_isEmpty_after_one_insert() {
		stringTree.insert("1");
		expected = "false";
		actual = "" + stringTree.isEmpty();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}

	@Test
	/** tests that the ascending order after inserting A item is "A," */
	public void test05_ascending_order_after_one_insert() {
		stringTree.insert("A");
		expected = "A,";
		actual = stringTree.inAscendingOrder();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}

	@Test
	/** tests that the height after inserting A is 1 */
	public void test06_height_after_one_insert() {
		stringTree.insert("A");
		expected = "1";
		actual = "" + stringTree.height();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}

	@Test
	/** tests that the height after inserting A and B and deleting A is 1 */
	public void test07_height_after_two_insert_and_one_delete() {
		stringTree.insert("A");
		stringTree.insert("B");
		stringTree.delete("A");
		expected = "1";
		actual = "" + stringTree.height();
		if (! expected.equals(actual))
			fail("expected: "+expected+ " actual: "+actual);
	}
	
	//Wants at least 6 new usefull tests that tell us about if
	//the search tree is working correctly

}

