import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int escolha;
        Scanner input = new Scanner(System.in);
        String nomeFicheiro = "";
        
        do {
            apresentarMenu();
            escolha = input.nextInt();
            input.nextLine(); // Consume the newline character left after nextInt()
            
            switch (escolha) {
                case 1:
                    nomeFicheiro = gravarFicheiro(input, nomeFicheiro);
                    break;
                case 2:
                    lerFicheiro(input, nomeFicheiro);
                    break;
                case 3:
                    encriptarFicheiro(input);
                    break;
                case 4:
                    desencriptarFicheiro(input);
                    break;
                default:
                    break;
            }
        } while (escolha != 0);

        input.close();
    }

    private static void apresentarMenu() {
        System.out.println("1 - Gravar Ficheiro");
        System.out.println("2 - Ler Ficheiro");
        System.out.println("3 - Encriptar Ficheiro");
        System.out.println("4 - Desencriptar Ficheiro");
        System.out.println("0 - terminar");
    }

    public static String gravarFicheiro(Scanner in, String nomeFicheiro) {
        String linha;
        System.out.println("Introduza o nome, com o caminho completo, do ficheiro:");
        nomeFicheiro = in.nextLine();
        
        try {
            FileWriter myWriter = new FileWriter(nomeFicheiro);
            System.out.println("Introduza o texto a gravar no ficheiro (ENTER para terminar)");
            do {
                linha = in.nextLine();
                myWriter.write(linha + "\n");
            } while (!linha.isEmpty());
            myWriter.close();
            System.out.println("Ficheiro gravado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: Ocorreu um problema ao escrever o ficheiro '" + nomeFicheiro + "'");
        }
        return nomeFicheiro;
    }

    public static void lerFicheiro(Scanner in, String nomeFicheiro) {
        String linha;
        
        try {
            Scanner sc = new Scanner(new File(nomeFicheiro)); // import java.io.File;
            while (sc.hasNextLine()) {
                linha = sc.nextLine();
                System.out.println(linha);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Erro: o ficheiro '" + nomeFicheiro + "' não foi encontrado!\n");
        }
    }

    private static void encriptarFicheiro(Scanner in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encriptarFicheiro'");
    }

    private static void desencriptarFicheiro(Scanner in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desencriptarFicheiro'");
    }
}
