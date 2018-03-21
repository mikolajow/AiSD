import java.io.File;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		
		quickSorrt test = new quickSorrt(new File("z2data1.csv"));
		quickSorrt test2 = new quickSorrt(new File("z2data2.csv"));
		quickSorrt odCollections = new quickSorrt(new File("z2data1.csv"));
		quickSorrt odCollections2 = new quickSorrt(new File("z2data2.csv"));
		
		Collections.sort(odCollections.getLista());
		Collections.sort(odCollections2.getLista());
		
		test.sortuj(0, (test.getLista().size() -1), 2 );
		test2.sortuj(0, (test.getLista().size() -1), 2 );
		
		
		boolean wynik = true;
		System.out.print( "Test dla listy 1 " );
		for ( int i = 0; i<test.getLista().size(); i++ ) {
			if ( ! test.getLista().get(i).equals(odCollections.getLista().get(i) ) ) {
				wynik = false;
				System.out.println( test.getLista().get(i) + "  " + odCollections.getLista().get(i) );
			}
		}//koniec for
		
		System.out.println(wynik);
		
		boolean wynik2 = true;
		System.out.print( "Test dla listy 2 " );
		for ( int i = 0; i<test2.getLista().size(); i++ ) {
			if ( ! test2.getLista().get(i).equals(odCollections2.getLista().get(i) ) ) {
				wynik = false;
				System.out.println( test2.getLista().get(i) + "  " + odCollections2.getLista().get(i) );
			}
		}//koniec for
		
		
		System.out.println(wynik2);
		
		System.out.println(" ");
		
		System.out.println("Wyniki dla pierwszych danych: ");
		System.out.println("Rozmiar = " + test.getLista().size());
		System.out.println("Wartoœæ Maxymalna = " + test.getLista().get(test.getLista().size() -1) );
		System.out.println("Wartoœæ Minimalna = " + test.getLista().get(0) );
		System.out.println("Mediana = " + test.Mediana());
		System.out.println("Histogram 1 : ");
		test.histogram(10);
		
		System.out.println(" ");
		
		System.out.println("Wyniki dla drugich danych: ");
		System.out.println("Rozmiar = " + test2.getLista().size());
		System.out.println("Wartoœæ Maxymalna = " + test2.getLista().get(test2.getLista().size() -1) );
		System.out.println("Wartoœæ Minimalna = " + test2.getLista().get(0) );
		System.out.println("Mediana = " + test2.Mediana());
		System.out.println("Histogram 2 : " );
		
		
		test2.histogram(10);
		
		System.out.println(" ");
		
		
	}//koniec main	
}//koniec klasy













