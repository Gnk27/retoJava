import java.io.IOException;
import java.util.Scanner;

public class index {

	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Bienvenido a RetoJava");
		try {
			parteUno();
			parteDos();
			System.out.println("¡Fin del RetoJava!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected static void parteUno() throws IOException {
		System.out.println("************************************");
		System.out.println("Parte 1");
		int rec_alto = 0, rec_ancho = 0;
		rec_alto = leerNumero("Ingrese alto del rectangulo (1-9):");
		rec_ancho = leerNumero("Ingrese ancho del rectangulo (1-9):");
		System.out.println("Los número ingresado son: " + rec_alto + " y " + rec_ancho);
		mostrarRectangulo(rec_alto, rec_ancho);
		return;
	}

	private static void mostrarRectangulo(int rec_alto, int rec_ancho) {
		int medio_alto = rec_alto / 2;
		int medio_ancho = rec_ancho / 2;
		int numero_imprimir = rec_ancho;
		for (int i = 0; i < rec_alto; i++) {
			for (int j = 0; j < rec_ancho; j++) {
				int lejania_alto = (i < medio_alto ? 0 + i : rec_alto - i - 1);
				int lejania_ancho = (j < medio_ancho ? 0 + j : rec_ancho - j - 1);
				System.out.print(numero_imprimir - (Math.min(lejania_alto, lejania_ancho)));
			}
			System.out.println();
		}
	}

	protected static int leerNumero(String msg) throws IOException {
		int aux;
		do {
			System.out.print(msg);
			aux = myInput.nextInt();
		} while (aux > 10 || aux < 1);
		return aux;
	}

	protected static void parteDos() throws IOException {
		System.out.println("************************************");
		System.out.println("Parte 2");
		String texto = leerCadena("Ingrese el texto para justificar:");
		justificarCadena(texto);
		return;
	}

	private static void justificarCadena(String texto) {
		int caracteres_linea = 50;
		int contador = 0;
		int total = texto.length();
		String auxiliar = texto;
		System.out.println();
		System.out.println("Texto justificado:");
		do {
			int corte_linea = Math.min(caracteres_linea, auxiliar.length());
			String linea = auxiliar.substring(0, corte_linea);
			if (linea.endsWith(" "))
				System.out.println(linea);
			else if (linea.endsWith("."))
				System.out.println(linea);
			else if (linea.endsWith(","))
				System.out.println(linea);
			else {
				do {
					corte_linea--;
					linea = auxiliar.substring(0, corte_linea);
				} while (!(linea.endsWith(" ") || linea.endsWith(".") || linea.endsWith(",")));
				do {
					// linea = linea.replaceFirst("[ ]", " ");
					// linea = linea.replaceFirst("[ ]", "°°");
					linea = linea.replaceAll("[ ]", "°°");
					if (linea.length() > 45) {
						linea = linea.replace('°', ' ');
					}
				} while (linea.length() < 51);
				linea = linea.replace('°', ' ');
				System.out.println(linea);
			}
			auxiliar = auxiliar.substring(corte_linea);
			contador += corte_linea;
		} while (contador < total);
	}

	protected static String leerCadena(String msg) throws IOException {
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner(System.in);
		entradaTeclado = entradaEscaner.nextLine();
		return entradaTeclado;
	}

}
