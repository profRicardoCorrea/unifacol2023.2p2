package gui;

public class MainErro {
	public static void main(String[] args) {

		int[] ns = { 1, 2, 3 };

		while (true) {

			try {
				ns[1] = 5;
				System.out.println("Inteiro [0]:" + ns[0]);
				Integer.parseInt("2");
				
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Erro De Posicao de Vetor:" + e.getMessage());			
			} catch (NumberFormatException e) {
				System.out.println("O valor n pode ser convertido para inteiro:" + e.getMessage());
			}  
			finally {
				System.out.println("Final While!!!!");
			}
			System.out.println("Final Fora While!!!!");
			
		}

	}

}
