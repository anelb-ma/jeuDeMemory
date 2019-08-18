import java.util.*;

import tools.ArrayUtil;
import tools.MemoryUtil;
import tools.ReadUtil;


public class Solution {
	
	public static int[] initCards(int n) {
		int cards[]= new int[2*n];
		int nbrValeur=n;
		int val,posCards;
		posCards=0;
		boolean ifExiste=false;
		
		while(nbrValeur!=0 && posCards<cards.length) {
			Random rand = new Random();
			val= rand.nextInt(n-1+1)+1;
			
			for(int i=0;i<cards.length;i++) {
				if(cards[i]==val) {
					ifExiste=true;
					break;
				}
			}
			
			if(ifExiste==false) {
				cards[posCards]=val;
				cards[posCards+1]=val;
				nbrValeur--;
				posCards=+2;
				
			}
		}
		
		return cards;
	}
	
	public static int askPosition(int[] cards, boolean[] collectedCards) {
		//création des variable local
		int pos;
		boolean etat=false;
		//récupération de postion pour la première fois
		Scanner Clavier = new Scanner(System.in);
		System.out.println("Veuillez entrer une position");
		pos= Clavier.nextInt();
		
		//première verification
		if(pos<cards.length && pos > 0) {
			if(collectedCards[pos]==false) {
				etat =true;
			}
		}
		
		//boucle dans le cas ou la position est fausse
		while(etat==false) {
			System.out.println("Position est fausse, veuillez saisir une nouvelle position");
			pos= Clavier.nextInt();
			
			if(pos<cards.length && pos > 0) {
				if(collectedCards[pos]==false) {
					etat =true;
				}
			}
			
		}
		
		//return la position après verification que l'état égale true
		return pos;
	}
	
	public static boolean checkAndCollect(int[] cards, boolean[] collectedCards, int pos1, int pos2) {
		//création d'une exception dans le cas de deux positions identiques
		if(pos1==pos2) {
			throw new IllegalArgumentException(
						"Impossible de faire le traitement vue les deux positions ont une valeur identique égale "+ pos1);
		}
		
		//verification que les positions sont bien dans l'intervalle
		if(pos1>=0 && pos2>=0 && pos1< cards.length && pos2< cards.length) {
			//est ce que les deux positions sont deja collecter
			if(collectedCards[pos1]==true && collectedCards[pos2]==true) {
				return false;
			}
			else {
				//verification que les deux valeurs dans la pos1 & la pos2 sont identiques
				if(cards[pos1]==cards[pos2]) {
					collectedCards[pos1]=true;
					collectedCards[pos2]=true;
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
	
	
	public static boolean isGameOver(boolean[] collectedCards) {
		boolean isWin = true;
		
		for(int i=0; i<collectedCards.length; i++) {
			if(collectedCards[i]==false) {
				isWin= false;
				break;
			}
		}
		return isWin;
	}
	
	
	public static int playMemory(int n) {
		int cards[] = new int[2*n];
		boolean collectedCards[] = new boolean[2*n];
		Scanner Clavier = new Scanner(System.in);
		//initier 1
		cards =initCards(n);
		
		for(int i=0;i<collectedCards.length; i++) {
			collectedCards[i]=false;
		}
		
		//melanger 2
		ArrayUtil.shuffle(cards);
		
		//display 3/1
		MemoryUtil.displayCards(cards,collectedCards);
		
		System.out.println("Entrer la premiere valeur");
		int pos1=Clavier.nextInt();
		

		System.out.println("Entrer la dexuième valeur");
		int pos2=Clavier.nextInt();
		
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(initCards(5)));

	}

}
