import java.io.File;
import java.util.Scanner;

public class MainFerramenta {

	public static void main(String[] args) {

		Scanner KB = new Scanner(System.in);
		int selezione = 0;
		Ferramenta f = new Ferramenta();

		File nomeFile = new File("Prodotti.csv");

		//If you want to manually import a file comment this lines and also check other files and in this file from row	48
		if(f.emptyFile() && !nomeFile.isDirectory()){
			f.inizializzaFile();
		}
		if(!f.emptyFile()){
			f.leggi();
		}
		//---------------------------

		do {
			Utility.selezione();
			selezione = KB.nextInt();
			switch (selezione) {
				case 1:
					f.addArticolo();
					f.scrivi();
					break;
				case 2:
					f.stampa();
					break;
				case 3:
					f.acquisto();
					f.scrivi();
					break;
				case 4:
					f.vendita();
					f.scrivi();
					break;
				case 5:
					System.out.println(f.giacenza());
					break;
				case 6:
					System.out.println(f.getNomeArt());
					break;
//				case 7:
//					f.leggi();				//Uncomment this file for manually import file
//					break;
				default:
					System.out.println("Selezione non valida, reinserire");
					break;
			}
		}while(selezione!=9);



	}

}
