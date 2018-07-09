package com.epam.lab.tests;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.app.droidList.DroidLinkedList;
import com.epam.lab.app.droidList.droids.BattleDroid;
import com.epam.lab.app.droidList.droids.Droid;
import com.epam.lab.app.droidList.droids.RocketDroid;
import com.epam.lab.app.droidList.droids.SuperDroid;

public class Task1_4 {
	private static DroidLinkedList<Droid> droidLinkedList;
	private static Droid firstDroid;
	private static Droid secondDroid;
	private static Droid thirdDroid;

	@BeforeClass
	public static void init() {
		droidLinkedList = new DroidLinkedList<>();
		firstDroid = new BattleDroid("1");
		secondDroid = new RocketDroid("2");
		thirdDroid = new SuperDroid("3");
	}

	@After
	public void clear() {
		droidLinkedList = new DroidLinkedList<>();
	}

	@Test
	public void testSize() {
		droidLinkedList.add(firstDroid);
		droidLinkedList.add(secondDroid);
		droidLinkedList.add(thirdDroid);
		Class<DroidLinkedList> droidLinkedListClass = DroidLinkedList.class;
		Method testMethod;
		try {
			testMethod = droidLinkedListClass.getDeclaredMethod("checkSize");
			testMethod.setAccessible(true);
			testMethod.invoke(droidLinkedList);
			assertEquals(testMethod.invoke(droidLinkedList), 3);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddingGetting() {
		droidLinkedList.add(firstDroid);
		droidLinkedList.add(secondDroid);
		droidLinkedList.add(thirdDroid);
		Droid[] input = { firstDroid, secondDroid, thirdDroid };
		Droid[] output = { droidLinkedList.get(0), droidLinkedList.get(1), droidLinkedList.get(2) };
		assertArrayEquals(input, output);
	}

	@Test
	public void testGettingNotExistingNumber() {
		droidLinkedList.add(firstDroid);
		droidLinkedList.add(secondDroid);
		assertNull(droidLinkedList.get(2));
	}

}
