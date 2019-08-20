package com.company;
import java.util.Scanner;
import java.io.IOException;
import java.text.Normalizer;

public class Main {

    public static void retorno () throws IOException {
        System.out.println("\nPressione Enter para retornar.");
        System.in.read();
    }

    public static String textoPuro (String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^a-zA-Z]+", "");
        return texto;
    }

    public static void cifraCesar (int op, String texto){
        texto = textoPuro(texto);
        texto = texto.toUpperCase();
        StringBuilder textoCesar = new StringBuilder();
        int chave = 3;

        for(int letra=0; letra < texto.length(); letra++) {
            if (op == 1 ){
                int letraCifradaASCII = ((int) texto.charAt(letra)) + chave;

                if (((int) texto.charAt(letra) + chave) > 90) {
                    letraCifradaASCII -= 26;
                } else if (((int) texto.charAt(letra) + chave) < 65) {
                    letraCifradaASCII += 26;
                }

                textoCesar.append( (char)letraCifradaASCII );
            } else if (op == 2 ) {
                int letraDecifradaASCII = ((int) textoCesar.charAt(letra)) - chave;

                if (((int) texto.charAt(letra) - chave) > 90) {
                    letraDecifradaASCII -= 26;
                } else if (((int) texto.charAt(letra) - chave) < 65) {
                    letraDecifradaASCII += 26;
                }

                textoCesar.append( (char)letraDecifradaASCII );
            }
        }
        System.out.println("Texto processado: " + textoCesar.toString());
    }

    public static void main(String[] args) throws IOException {
        int op = 1;
        try {
            do {
                Scanner numerico = new Scanner(System.in);

                System.out.println("*** Cifra de Cesar! Padrao de rotacao = 3 ***\n");
                System.out.println("- Insira 1 para criptografar um texto;\n- Insira 2 para descriptografar um texto;");
                System.out.println("- Insira 0 para sair.");
                op = numerico.nextInt();

                Scanner teclado = new Scanner(System.in);

                System.out.print("Informe o texto: ");
                String texto = teclado.nextLine();

                cifraCesar(op, texto);

                retorno();
            } while (op != 0);
        } catch (RuntimeException e) {
            System.out.println("\nOpcao incorreta!");
            System.out.println("Execute o programa novamente e insira uma opcao valida.");
        }
    }
}
