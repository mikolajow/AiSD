package pakiet1;

import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		
		
		try( Scanner s = new Scanner(System.in) ){
			System.out.println("Wpisz nazwe pliku lub 1 jesli ma to byc plik dane.txt");
			String nazwa = s.nextLine();
			if (nazwa.equals("1")) {
				nazwa = "dane.txt";
			}//koniec if
			
			System.out.println("Wprowadz rozmiar populacji ");
			int rozmiar = s.nextInt();
			
			algorytm alg = new algorytm( nazwa , rozmiar);
			
			int czyJeszcze = 0;
			
			do {
				System.out.println("Ile iteracji ma sie wykonac?");
				int ileIteracji = s.nextInt();
				
				alg.generujNowaPopulacje(ileIteracji);
				
				System.out.println("Droga do pokonania = " + alg.getPopulacja().get(0).getDrogaDoPokonania());
				System.out.println("wyniki nowej populacji = ");
				
				for ( int i = 0; i < alg.getPopulacja().get(0).getUstawienie().length; i++ ) {
					System.out.print(alg.getPopulacja().get(0).getUstawienie()[i] + ",");
				}//koniec for - wyswietlanie ustawienia
				
				System.out.println();
				System.out.println("Czy wykonac kolejne iteracje? 0 - nie, 1 - tak ");
				
				czyJeszcze = s.nextInt();
				
			}while( czyJeszcze == 1);
			
			System.out.println("Koniec Programu");
			
		}catch (Exception e) {
			System.out.println("cos poszlo nie tak ");
			e.printStackTrace();
		}// koniec catch
		
		
	}//koniec main
}//koniec klasy


























