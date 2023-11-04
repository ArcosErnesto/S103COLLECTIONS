package n1ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println("***Print list***");

		System.out.println(list);

		List<Integer> reverseList = new ArrayList<Integer>();

		ListIterator<Integer> it = list.listIterator(list.size());

		while (it.hasPrevious()) {
			Integer num = it.previous();

			reverseList.add(num);
		}

		System.out.println("***Print reverse list***");

		System.out.println(reverseList);

	}

}
