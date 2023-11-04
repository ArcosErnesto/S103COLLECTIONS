package n1ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArrayList<Month> arrayMonth = new ArrayList<Month>();

		arrayMonth.add(new Month("Enero"));
		arrayMonth.add(new Month("Febrero"));
		arrayMonth.add(new Month("Marzo"));
		arrayMonth.add(new Month("Abril"));
		arrayMonth.add(new Month("Mayo"));
		arrayMonth.add(new Month("Junio"));
		arrayMonth.add(new Month("Julio"));
		arrayMonth.add(new Month("Septiembre"));
		arrayMonth.add(new Month("Octubre"));
		arrayMonth.add(new Month("Noviembre"));
		arrayMonth.add(new Month("Diciembre"));

		System.out.println("***Lista sin agosto***");

		for (Month month : arrayMonth) {
			System.out.println(month.getName());
		}

		arrayMonth.add(7, new Month("Agosto"));

		System.out.println("***Bucle for sobre ArrayList***");

		for (Month month : arrayMonth) {
			System.out.println(month.getName());
		}

		System.out.println("***Bucle for sobre HashSet***");

		HashSet<Month> setMonth = new HashSet<Month>(arrayMonth);

		for (Month month : setMonth) {
			System.out.println(month.getName());
		}

		System.out.println("***Iterador sobre HashSet***");

		Iterator<Month> it = setMonth.iterator();

		while (it.hasNext()) {
			Month month = it.next();

			System.out.println(month.getName());
		}
	}

}
