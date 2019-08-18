package tools;

public class MemoryUtil {

	public static void displayCards(int[] cards, boolean[] collectedCards) {
		System.out.print("Les cartes: ");
		for (int i = 0; i < collectedCards.length; i++) {
			System.out.print((collectedCards[i] ? cards[i] : "?") + " ");
		}
		System.out.println();
	}

}
