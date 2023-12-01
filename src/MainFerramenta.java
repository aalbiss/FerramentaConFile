import java.util.Scanner;

public class MainFerramenta {

	public static void main(String[] args) {
		Scanner KB = new Scanner(System.in);
		int selezione = 0;
		Ferramenta f = new Ferramenta();
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
				case 7:
					f.leggi();
					break;
				default:
					break;
			}
		}while(selezione!=9);



	}

}
