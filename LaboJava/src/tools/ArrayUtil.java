package tools;
import java.util.Random;

public class ArrayUtil {
	
	public static void shuffle(int[] array) {
		int index, temp;
		Random random = new Random();
		
		for (int i = array.length-1; i > 0; i--) 
		{
			index = random.nextInt(i + 1);
			swap(array, i, index);
		 	}
	}

	public static void swap(int[] array, int pos1, int pos2) {
		int savedValue = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = savedValue;
	}

}
