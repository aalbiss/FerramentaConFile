import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ferramenta {

	private ArrayList<Articolo> ferramenta;
	File nomeFile = new File("Prodotti.csv");

	public Ferramenta() {
		ferramenta = new ArrayList<Articolo>();
	}

	public void addArticolo() {
		Scanner KB = new Scanner(System.in);
		Articolo a = new Articolo();
		int cA;
		String nome;
		double quantita;
		System.out.println("Inserire il codice dell'articolo");
		cA = KB.nextInt();
		KB.nextLine();
		for (Articolo articolo : ferramenta) {
			while(cA==articolo.getCodiceArticolo()) {
				System.out.println("Esiste già questo un articolo con questo codice\nReinserire");
				cA = KB.nextInt();
				KB.nextLine();
			}
		}
		a.setCodiceArticolo(cA);

		System.out.println("Inserire il nome dell'articolo");
		nome = KB.nextLine();
		a.setNomeArticolo(nome);

		do {
			System.out.println("Inserire quantità dell'articolo");
			quantita = KB.nextDouble();
			KB.nextLine();
			if(quantita<0) {
				System.out.println("Inserire una quantità maggiore o uguale a 0");
			}
		}while(quantita<0);
		a.setGiacenza(quantita);
		ferramenta.add(a);
	}

	public void acquisto() {
		if(!ferramenta.isEmpty()) {
			Scanner KB = new Scanner(System.in);
			int cA;
			double quantita = 0;
			System.out.println("Inserire il codice dell'articolo");
			cA = KB.nextInt();
			KB.nextLine();
			System.out.println("Inserire quantità dell'articolo appena comprato");
			quantita = KB.nextDouble();
			KB.nextLine();
			for (Articolo articolo : ferramenta) {
				while(quantita<0){
					System.out.println("Inserire quantità dell'articolo appena comprato");
					quantita = KB.nextDouble();
					KB.nextLine();
					if(quantita<0) {
						System.out.println("Inserire una quantità maggiore o uguale a 0");
					}
				}
			}

			double giacenza = 0;

			for (Articolo articolo : ferramenta) {
				if(cA == articolo.getCodiceArticolo()){
					giacenza = articolo.getGiacenza();
					articolo.setGiacenza(giacenza+quantita);
				}
			}
			System.out.println("Sono appena stati comprati " + quantita + " oggetti" );
		}else {
			System.out.println("Non ci sono oggetti da comprare, aggiungerne uno nuovo");
		}



	}

	public void vendita() {
		if(!ferramenta.isEmpty()) {
			Scanner KB = new Scanner(System.in);
			int cA;
			double quantita = 0;
			System.out.println("Inserire il codice dell'articolo");
			cA = KB.nextInt();
			KB.nextLine();

			System.out.println("Inserire quantità dell'articolo appena comprato");
			quantita = KB.nextDouble();
			KB.nextLine();
			for (Articolo articolo : ferramenta) {

				while(quantita<0) {
					System.out.println("Inserire quantità dell'articolo appena venduto");
					quantita = KB.nextDouble();
					KB.nextLine();
					if(quantita<0) {
						System.out.println("Inserire una quantità maggiore o uguale a 0");
					}
				}

			}

			double giacenza = 0;

			for (Articolo articolo : ferramenta) {
				if(cA == articolo.getCodiceArticolo()){
					giacenza = articolo.getGiacenza();
					articolo.setGiacenza(giacenza-quantita);
				}
			}
			System.out.println("Sono appena stati comprati " + quantita + " oggetti" );
		}else {
			System.out.println("Non ci sono oggetti da vendere");
		}

	}

	public double giacenza() {
		double s = 0;
		if(!ferramenta.isEmpty()) {
			Scanner KB = new Scanner(System.in);
			int cA = 0;
			System.out.println("Inserisci il codice dell'articolo per visualizzare la sua giacenza: ");
			cA = KB.nextInt();
			for (Articolo articolo : ferramenta) {
				while(cA!=articolo.getCodiceArticolo()) {
					System.out.println("Non esiste un prodotto con questo articolo\nReinserire");
					cA = KB.nextInt();
					KB.nextLine();
				}
			}
			for (Articolo articolo : ferramenta) {
				if(cA==articolo.getCodiceArticolo()) {
					s = articolo.getGiacenza();
				}
			}

		}else {
			s = -1;
		}
		return s;
	}

	public String getNomeArt() {
		String s = "";
		if(!ferramenta.isEmpty()) {
			Scanner KB = new Scanner(System.in);
			int cA = 0;
			System.out.println("Inserisci il codice dell'articolo per visualizzare il nome: ");
			cA = KB.nextInt();
			for (Articolo articolo : ferramenta) {
				while(cA!=articolo.getCodiceArticolo()) {
					System.out.println("Non esiste un prodotto con questo articolo\nReinserire");
					cA = KB.nextInt();
					KB.nextLine();
				}
			}
			for (Articolo articolo : ferramenta) {
				if(cA==articolo.getCodiceArticolo()) {
					s = articolo.getNomeArticolo();
				}
			}

		}else {
			s = "Non esiste un prodotto con questo codice";
		}
		return s;
	}

	public void dimensione() {
		System.out.println("Gli oggetti contenuti della ferramenta sono: " + ferramenta.size());
	}

	public void stampa() {
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for (Articolo articolo : ferramenta) {
			articolo.visualizza();
		}
		System.out.println("--------------------------------------------------------");
	}

	//	If you want to manually import a file comment this lines
	public void inizializzaFile() {
		try {
			FileWriter fw = new FileWriter(nomeFile);
			PrintWriter pw = new PrintWriter(fw);

			pw.print("Codice" + ";");
			pw.print("Nome" + ";");
			pw.println("Giacenza");

			fw.close();
			pw.close();

		}catch (IOException e){
			System.out.println("Eccezione " + e);
		}
	}

	//	If you want to manually import a file comment this lines
	public boolean emptyFile(){

		boolean empty = true;

		try {
			FileInputStream fin = new FileInputStream(nomeFile);
			Scanner in = new Scanner(fin);
			int k = 0;
			if (in.hasNextLine()){
				empty = false;
			}

		} catch (IOException e) {
			System.out.println("Eccezione " + e);
		}

		return empty;

	}

	//	If you want to manually import a file uncomment this lines
//	public void scrivi(){
//
//		try {
//			FileWriter fw = new FileWriter(nomeFile);
//			PrintWriter pw = new PrintWriter(fw);
//
//			pw.print("Codice" + ";");
//			pw.print("Nome" + ";");
//			pw.println("Giacenza");
//
//			for (Articolo articolo : ferramenta) {
//				pw.print(articolo.getCodiceArticolo() + ";");
//				pw.print(articolo.getNomeArticolo() + ";");
//				pw.println(articolo.getGiacenza());
//			}
//
//			fw.close();
//			pw.close();
//
//		} catch (IOException e) {
//			System.out.println("Eccezione " + e);
//		}
//
//	}

//	If you want to manually import a file comment this lines
	public void scrivi(){

		try {
			FileWriter fw = new FileWriter(nomeFile,true);
			PrintWriter pw = new PrintWriter(fw);

			pw.print(ferramenta.get(ferramenta.size()-1).getCodiceArticolo() + ";");
			pw.print(ferramenta.get(ferramenta.size()-1).getNomeArticolo() + ";");
			pw.println(ferramenta.get(ferramenta.size()-1).getGiacenza());

			fw.close();
			pw.close();

		}catch (IOException e){
			System.out.println("Eccezione " + e);
		}

	}

	public void leggi(){

		try {
			FileInputStream fin = new FileInputStream(nomeFile);
			Scanner in = new Scanner(fin);
			int k = 0;
			while (in.hasNextLine()){
				Articolo a = new Articolo();
				String word = in.nextLine();
				String articoli[] =  word.split(";");

				if(k>0){
					a.setCodiceArticolo(Integer.parseInt(articoli[0]));
					a.setNomeArticolo(articoli[1]);
					a.setGiacenza(Double.parseDouble(articoli[2]));
					ferramenta.add(a);
				}
				k++;

			}

		} catch (IOException e) {
			System.out.println("Eccezione " + e);
		}

		System.out.println("File importato");

	}

}
