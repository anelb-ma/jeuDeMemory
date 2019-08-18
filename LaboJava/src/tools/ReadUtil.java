package tools;
import java.util.Scanner;

public class ReadUtil {
	private final static Scanner kbd = new Scanner(System.in);

	public static int readInt(String msg) {
		System.out.print(msg + ": ");
		while (!kbd.hasNextInt()) {
			System.err.println("Ce n’est pas un entier !");
			kbd.next();
			System.out.print(msg + ": ");
		}
		return kbd.nextInt();
	}

	public static int readInt(String msg, int min, int max) {
		int value;
		String msgWithLimits = msg + " (" + min + " à " + max + ")";
		value = readInt(msgWithLimits);
		while (value < min || value > max) {
			System.out.println("La valeur " + value + " n’est pas dans l’intervalle [" + min + "−" + max + "]");
			value = readInt(msgWithLimits);
		}
		return value;
	}
}
