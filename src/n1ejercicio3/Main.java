package n1ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String readFile = "src\\n1ejercicio3\\countries.txt";
		String writeFile = "src\\n1ejercicio3\\classification.txt";
		HashMap<String, String> answers = new HashMap<String, String>();
		String userName;
		int points = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {
			String line = br.readLine();
			while (line != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String country = parts[0].trim();
					String captial = parts[1].trim();
					answers.put(country, captial);
				}
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de lectura del archivo.");
			e.printStackTrace();
		}

		ArrayList<String> capitals = new ArrayList<String>(answers.values());

		System.out.println("****ACIERTE LA CAPTITAL***\n");
		System.out.println("Introduzca su nombre:");
		userName = sc.nextLine();
		System.out.println("\nHola " + userName
				+ ", a continuación te preguntaremos la capital de 10 países. ¿Cuántas serás capaz de acertar?\n");

		for (int i = 1; i <= 10; i++) {
			String randomCapital = getCapital(capitals);
			String country = getCountry(answers, randomCapital);

			System.out.println("Pregunta n.º " + (i) + ": ¿Cuál es la capital de " + country + "?");
			String answer = sc.nextLine();

			if (answer.equalsIgnoreCase(randomCapital)) {
				System.out.println("¡Respuesta correcta! Has conseguido un punto.");
				points++;
			} else {
				System.out.println("Respuesta incorrecta. La capital es " + randomCapital);
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter((writeFile)))) {
			bw.write(userName + ", has conseguido " + points + " puntos.");
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error al escribir en archivo.");
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(writeFile))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de lectura del archivo.");
			e.printStackTrace();
		}

	}

	public static String getCapital(ArrayList<String> capitals) {
		Random random = new Random();
		int randomIndex = random.nextInt(capitals.size());
		String randomCaptital = capitals.get(randomIndex);
		capitals.remove(randomIndex);
		return randomCaptital;
	}

	public static String getCountry(HashMap<String, String> answers, String randomCapital) {
		for (Map.Entry<String, String> entry : answers.entrySet()) {
			if (entry.getValue().equalsIgnoreCase(randomCapital)) {
				return entry.getKey();
			}
		}
		return null;
	}

}