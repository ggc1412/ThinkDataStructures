/**
 * 
 */
package com.allendowney.thinkdast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


/**
 * @author downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

	protected List<Integer> mylist;
	protected List<Integer> list;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		mylist = new MyLinkedList<Integer>();
		mylist.addAll(list);
	}

	@Test
	public void add_E_테스트() {
		for (int i = 4; i < 20; i++) {
			mylist.add(i);
		}
		assertThat(mylist.get(18), is(new Integer(19)));
	}

	@Test
	public void add_index_테스트() {
		mylist.add(1, 5);
		System.out.println(Arrays.toString(mylist.toArray()));
		assertThat(mylist.get(1), is(new Integer(5)));
		assertThat(mylist.size(), is(4));

//		try {
//			mylist.set(-1, 0);
//			fail();
//		} catch (IndexOutOfBoundsException e) {} // good
//
//		try {
//			mylist.set(4, 0);
//			fail();
//		} catch (IndexOutOfBoundsException e) {} // good

		mylist.add(0, 6);
		System.out.println(Arrays.toString(mylist.toArray()));
		assertThat(mylist.get(0), is(6));

		mylist.add(4, 7);
		System.out.println(Arrays.toString(mylist.toArray()));
		assertThat(mylist.get(4), is(new Integer(7)));
	}

	@Test
	public void indexOf_테스트() {
		assertThat(mylist.indexOf(1), is(0));
		assertThat(mylist.indexOf(2), is(1));
		assertThat(mylist.indexOf(3), is(2));
		assertThat(mylist.indexOf(4), is(-1));
	}

	@Test
	public void indexOf_null_테스트() {
		assertThat(mylist.indexOf(null), is(-1));
		mylist.add(null);
		assertThat(mylist.indexOf(null), is(3));
	}

	@Test
	public void remove_테스트() {
		boolean flag = mylist.remove(new Integer(2));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(2));
//		System.out.println(Arrays.toString(mylist.toArray()));
		assertThat(mylist.get(1), is(new Integer(3)));


		flag = mylist.remove(new Integer(1));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(1));
		assertThat(mylist.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mylist.remove(new Integer(5));
		assertThat(flag, equalTo(false));
		assertThat(mylist.size(), is(1));
		assertThat(mylist.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mylist.remove(new Integer(3));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(0));
		//System.out.println(Arrays.toString(mal.toArray()));
	}


}
