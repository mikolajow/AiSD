package pakiet_1;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Apostezjon test = new Apostezjon();
		ArrayList<String> miasta = new ArrayList<>();
		
		miasta.add( 	"Angmar"	);
		miasta.add( 	"Gondolin"	);
		miasta.add( 	"Isengard"	);
		miasta.add( 	"Rivendell"	);
		
		miasta.add( 	"Bree"		);
		miasta.add( 	"Trondheim"		);
		miasta.add( 	"Lusitania"		);
		miasta.add( 	"Roke"		);
		
		miasta.add( 	"Atuan"		);
		miasta.add( 	"Selidor"		);
		miasta.add( 	"Havnor"		);
		miasta.add( 	"Gont"		);
		
		
		try ( Scanner s = new Scanner(System.in) ){
			System.out.println("Podaj Stacjê Pocz¹tkow¹");
		 	String poczatek = s.nextLine();
		 	System.out.println("Podaj Stacjê Koñcow¹");
			String koniec = s.nextLine();
			
			if ( miasta.contains(poczatek) && miasta.contains(koniec) ) {
				test.szukajPolaczenia(poczatek, koniec);
			}else throw new Exception();
		}catch ( Exception e) {
			System.out.println("podano z³e dane");
		}//koniec try-catch
		
		
		
		
		//test.szukajPolaczenia( "Lusitania", "Bree");
		//test.szukajPolaczenia( "Bree", "Selidor");
		//test.szukajPolaczenia( "Isengard", "banan");
		
		/*
		System.out.println(test.getMapa().get("Atuan").get("Selidor"));
		System.out.println(test.getMapa().get("Havnor").get("Gont"));
		System.out.println(test.getMapa().get("Gont").get("Bree"));
		
		System.out.println(test.getMapa().get("Bree").get("Rivendell"));
		System.out.println(test.getMapa().get("Lusitania").get("Rivendell"));
		System.out.println(test.getMapa().get("Isengard").get("Rivendell"));
		*/
	}//koniec main
}//koniec klasy test


/* MIASTA:

Angmar
Gondolin
Isengard
Rivendell
Bree

Trondheim
Lusitania

Roke
Atuan
Selidor
Havnor
Gont

*/






















