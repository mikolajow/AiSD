import java.io.File;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		File plik = new File("z2data1.csv");
		
		czytnik qs1 = new czytnik(plik);
		
		//System.out.println("Rozmiar = "+ qs1.rozmiar());
		
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(9);
		lista.add(5);
		lista.add(8);
		lista.add(0);
		lista.add(1);
		lista.add(4);
		lista.add(3);
		lista.add(2);
		lista.add(6);
		lista.add(7);
		lista.add(5);
		lista.add(10);
		lista.add(7);
		lista.add(5);
		lista.add(2);
		lista.add(5);
		
		
		
		quickSorrt nowy = new quickSorrt(lista);
		
		
		
		System.out.println( "LISTA" );
		for ( Integer i : nowy.getLista() ) {
			System.out.print(i + "," );
		}
		System.out.println();
		
		
		/*
		
		System.out.println( "PARTYCJONUJ 1" );
		
		int q =  nowy.partycjonuj(0, lista.size() -1, 5 );
		
		for ( Integer i : nowy.getLista() ) {
			System.out.print(i + "," );
		}
		
		System.out.println();
		System.out.println( "PARTYCJONUJ 2" );
		
		nowy.partycjonuj(0, lista.size()/2 -1, 3 );
		
		for ( Integer i : nowy.getLista() ) {
			System.out.print(i + "," );
		}
		
		System.out.println();
		System.out.println( "PARTYCJONUJ 3" );
		
		nowy.partycjonuj(0, lista.size()/4 -1, 1 );
		
		for ( Integer i : nowy.getLista() ) {
			System.out.print(i + "," );
		}
		
		
		*/
		
		
		nowy.pivotOstatni(0, lista.size()-1);
		
		System.out.println( "PO" );
		System.out.println();
		for ( Integer i : nowy.getLista() ) {
			System.out.print(i + "," );
		}
		System.out.println();
		
		
		
	}//koniec main	
}//koniec klasy













