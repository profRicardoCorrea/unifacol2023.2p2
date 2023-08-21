package util;

import java.util.Random;

public class GerardorDados {
	public static String gerarNome(int tamanho) {
		int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = tamanho;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String nome = buffer.toString();

        return nome;
	}
	
	public static String gerarDocumento(int tamanho) {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 59; // letter 'z'
	    int targetStringLength = tamanho;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	   return generatedString;
	}

}
