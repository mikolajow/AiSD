package pakiet1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class algorytm {
	
	private int liczbaSzaf;
	private int[][] macierz;
	private ArrayList<korytarz> populacja;
	private ArrayList<korytarz> nowaPopulacja;
	
	
	public algorytm( String nazwaPliku , int wielkoscPopulacji ) {
		
		try( BufferedReader scaner = new BufferedReader( new FileReader( new File(nazwaPliku))) ){
			String[] linia = scaner.readLine().split(",");
			int wielkosc = linia.length;
			macierz = new int[wielkosc + 1][wielkosc + 1];
			
	        for (int i = 0; i < macierz.length; i++) {
	        	macierz[i][0] = i;
	        	macierz[0][i] = i;
	        }// wypelniam pierwszy wiersz i kolumne numerami pokojow od 1 do n, 1=a
			
	        for( int j=0; j < linia.length; j++ ) {
	        	if ( linia[j].equals("x") || linia[j].equals("X") ) {
	        		macierz[1][j+1] = 0;
	        	}//koniec if
	        	else {
	        		macierz[1][j+1] = Integer.parseInt(linia[j]);
	        	}//koniec else
	        }// wypelniam pierwszya wczesniej zaczytana linie
			
	        int i = 2;
	        while ( true ) {
	        	linia = scaner.readLine().split(",");
	        	
		        for( int j = 0; j < linia.length; j++ ) {
		        	if ( linia[j].equals("x") || linia[j].equals("X")  ) {
		        		macierz[i][j+1] = 0;
		        	}//koniec if
		        	else {
		        		macierz[i][j+1] = Integer.parseInt(linia[j]);
		        	}//koniec else
		        }//koniec for
	        	i++;
	        }//koniec while
		}catch (Exception e) {
		}// koniec catch
		
        this.liczbaSzaf = macierz.length;
        populacja = new ArrayList<>();
        nowaPopulacja = new ArrayList<>();
        
        //losuje losowa populacje na starcie
        for( int i = 0; i < wielkoscPopulacji; i++ ) {
        	populacja.add(new korytarz(this.liczbaSzaf));
        }//koniec for
		
	}//koniec konstruktora
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[][] getMacierz() {
		return macierz;
	}


	public void setMacierz(int[][] macierz) {
		this.macierz = macierz;
	}
	
}//koniec klasy

























