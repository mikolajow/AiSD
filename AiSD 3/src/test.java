import java.io.File;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		quickSort test = new quickSort(new File("z3data11.csv"));
		quickSort test2 = new quickSort(new File("z3data22.csv"));
		quickSort odCollections = new quickSort(new File("z3data11.csv"));
		quickSort odCollections2 = new quickSort(new File("z3data22.csv"));
		
		Collections.sort(odCollections.getLista());
		Collections.sort(odCollections2.getLista());
		
		test.sortuj(0, (test.getLista().size() -1),  1);
		test2.sortuj(0, (test.getLista().size() -1), 1 );
		
		//TESTY
		
		
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
		
		
		
		
		
		
	}//koniec main
}//koniec klasy




































