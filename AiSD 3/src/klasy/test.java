package klasy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<quickSort> qs = new ArrayList<>();
		
		//dla pierwszych danych 3 elementy
		quickSort test1 = new quickSort(new File("z3data11.csv"));	
		quickSort test2 = new quickSort(new File("z3data11.csv"));
		quickSort test3 = new quickSort(new File("z3data11.csv"));
		
		//dla drugich danych 3 elementy
		quickSort test4 = new quickSort(new File("z3data12.csv"));
		quickSort test5 = new quickSort(new File("z3data12.csv"));
		quickSort test6 = new quickSort(new File("z3data12.csv"));
		
		//dla trzecich danych 3 elementy
		quickSort test7 = new quickSort(new File("z3data13.csv"));
		quickSort test8 = new quickSort(new File("z3data13.csv"));
		quickSort test9 = new quickSort(new File("z3data13.csv"));
		//dla pierwszych danych 3 elementy
		quickSort test10 = new quickSort(new File("z3data21.csv"));
		quickSort test11 = new quickSort(new File("z3data21.csv"));
		quickSort test12= new quickSort(new File("z3data21.csv"));
		
		//dla drugich danych 3 elementy
		quickSort test13 = new quickSort(new File("z3data22.csv"));
		quickSort test14 = new quickSort(new File("z3data22.csv"));
		quickSort test15 = new quickSort(new File("z3data22.csv"));
		
		//dla trzecich danych 3 elementy
		quickSort test16 = new quickSort(new File("z3data23.csv"));
		quickSort test17 = new quickSort(new File("z3data23.csv"));
		quickSort test18 = new quickSort(new File("z3data23.csv"));
		//dla pierwszych danych 3 elementy
		quickSort test19 = new quickSort(new File("z3data31.csv"));
		quickSort test20 = new quickSort(new File("z3data31.csv"));
		quickSort test21 = new quickSort(new File("z3data31.csv"));
		
		//dla drugich danych 3 elementy
		quickSort test22 = new quickSort(new File("z3data32.csv"));
		quickSort test23 = new quickSort(new File("z3data32.csv"));
		quickSort test24 = new quickSort(new File("z3data32.csv"));
		
		//dla trzecich danych 3 elementy
		quickSort test25 = new quickSort(new File("z3data33.csv"));
		quickSort test26 = new quickSort(new File("z3data33.csv"));
		quickSort test27 = new quickSort(new File("z3data33.csv"));
		
		qs.add(test1);
		qs.add(test2);
		qs.add(test3);
		qs.add(test4);
		qs.add(test5);
		qs.add(test6);
		qs.add(test7);
		qs.add(test8);
		qs.add(test9);
		
		qs.add(test10);
		qs.add(test11);
		qs.add(test12);
		qs.add(test13);
		qs.add(test14);
		qs.add(test15);
		qs.add(test16);
		qs.add(test17);
		qs.add(test18);
		
		qs.add(test19);
		qs.add(test20);
		qs.add(test21);
		qs.add(test22);
		qs.add(test23);
		qs.add(test24);
		qs.add(test25);
		qs.add(test26);
		qs.add(test27);
		
		
		test1.sortuj(0, test1.getLista().size()-1, 1);
		test2.sortuj(0, test2.getLista().size()-1, 2);		
		test3.sortuj(0, test3.getLista().size()-1, 3);
		
		test4.sortuj(0, test4.getLista().size()-1, 1);
		test5.sortuj(0, test5.getLista().size()-1, 2);
		test6.sortuj(0, test6.getLista().size()-1, 3);

		test7.sortuj(0, test7.getLista().size()-1, 1);
		test8.sortuj(0, test8.getLista().size()-1, 2);
		test9.sortuj(0, test9.getLista().size()-1, 3);
		
		test10.sortuj(0, test10.getLista().size()-1, 1);
		test11.sortuj(0, test11.getLista().size()-1, 2);
		test12.sortuj(0, test12.getLista().size()-1, 3);
		
		test13.sortuj(0, test13.getLista().size()-1, 1);
		test14.sortuj(0, test14.getLista().size()-1, 2);
		test15.sortuj(0, test15.getLista().size()-1, 3);

		test16.sortuj(0, test16.getLista().size()-1, 1);
		test17.sortuj(0, test17.getLista().size()-1, 2);
		test18.sortuj(0, test18.getLista().size()-1, 3);
		
		test19.sortuj(0, test19.getLista().size()-1, 1);
		test20.sortuj(0, test20.getLista().size()-1, 2);
		test21.sortuj(0, test21.getLista().size()-1, 3);
		
		test22.sortuj(0, test22.getLista().size()-1, 1);
		test23.sortuj(0, test23.getLista().size()-1, 2);
		test24.sortuj(0, test24.getLista().size()-1, 3);

		test25.sortuj(0, test25.getLista().size()-1, 1);
		test26.sortuj(0, test26.getLista().size()-1, 2);
		test27.sortuj(0, test27.getLista().size()-1, 3);
		

		
		
		
		
		
		
		//System.out.printf("%10d %10s %d", 22 , "banan" ,3 );
		
		System.out.printf( "%-20s %-20s %-20s %-20s %-20s  ",  "nazwa pliku" , "liczebnosc zbioru" , "metoda pivota" , "max wysokoœæ stosu"  , "liczba zamian" );
		for ( quickSort q : qs ) {
			System.out.println("");
			System.out.printf( "%-20s %-20d %-20s %-20d %-20d ", q.getPlik().getName() ,   q.getLista().size() , q.getWersja() , q.getMaxWyokoscStosu() , q.getLiczbaZamian() );
		}// koniec for
		
		
		
		/*
		//TESTY DLA QUICK SORTA
		
		System.out.println();
		quickSort test444 = new quickSort(new File("z3data11.csv"));
		quickSort test222 = new quickSort(new File("z3data22.csv"));
		quickSort odCollections = new quickSort(new File("z3data11.csv"));
		quickSort odCollections2 = new quickSort(new File("z3data22.csv"));
		
		Collections.sort(odCollections.getLista());
		Collections.sort(odCollections2.getLista());
		
		test444.sortuj(0, test444.getLista().size()-1, 2);
		test222.sortuj(0, (test222.getLista().size() -1), 2 );
		
		//TESTY
		
		
		boolean wynik = true;
		System.out.print( "Test dla listy 1 " );
		for ( int i = 0; i<test444.getLista().size(); i++ ) {
			if ( ! test444.getLista().get(i).equals(odCollections.getLista().get(i) ) ) {
				wynik = false;
				System.out.println( test444.getLista().get(i) + "  " + odCollections.getLista().get(i) );
			}
		}//koniec for
		
		System.out.println(wynik);
		
		boolean wynik2 = true;
		System.out.print( "Test dla listy 2 " );
		for ( int i = 0; i<test222.getLista().size(); i++ ) {
			if ( ! test222.getLista().get(i).equals(odCollections2.getLista().get(i) ) ) {
				wynik = false;
				System.out.println( test222.getLista().get(i) + "  " + odCollections2.getLista().get(i) );
			}
		}//koniec for
		
		
		System.out.println(wynik2);
		*/
		
		
		
		
		
	}//koniec main
}//koniec klasy




































