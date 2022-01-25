package bjpublic.chap13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddPerformanceTest {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		int range = 100000;
		
		// ArrayList add
		long startTime = System.nanoTime();
		
		for (int i = 0; i < range; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList add: " + duration);
		
		// LinkedList add
		startTime = System.nanoTime();
		
		for (int i = 0; i < range; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);
	}
}
