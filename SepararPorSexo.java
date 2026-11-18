import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SepararPorSexo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //listas
        List<String> grupoMasculino = new ArrayList<>();
        List<String> grupoFeminino = new ArrayList<>();
        List<String> grupoOutros = new ArrayList<>();

        System.out.println("=== SISTEMA DE SEPARAÇÃO POR SEXO ===");
        System.out.println("Digite 'sair' a qualquer momento no nome para encerrar e ver o resultado.\n");

        while (true) {
            //ler nome
            System.out.print("Digite o nome da pessoa: ");
            String nome = scanner.nextLine().trim();

            //cond. parada
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            //evitar nomes vazios
            if (nome.isEmpty()) {
                System.out.println("O nome não pode ser vazio. Tente novamente.\n");
                continue;
            }

            //ler sexo
            System.out.print("Digite o sexo (M/F ou outro): ");
            String sexo = scanner.nextLine().trim().toUpperCase();

            //separar
            if (sexo.equals("M") || sexo.equals("MASCULINO")) {
                grupoMasculino.add(nome);
                System.out.println("-> " + nome + " adicionado ao grupo Masculino.\n");
            } else if (sexo.equals("F") || sexo.equals("FEMININO")) {
                grupoFeminino.add(nome);
                System.out.println("-> " + nome + " adicionado ao grupo Feminino.\n");
            } else {
                grupoOutros.add(nome + " (" + sexo + ")");
                System.out.println("-> " + nome + " adicionado ao grupo Outros/Não especificado.\n");
            }
        }

        //exibir result.
        System.out.println("\n========================================");
        System.out.println("         RELATÓRIO DE GRUPOS            ");
        System.out.println("========================================");
        
        exibirGrupo("MASCULINO", grupoMasculino);
        exibirGrupo("FEMININO", grupoFeminino);
        
        if (!grupoOutros.isEmpty()) {
            exibirGrupo("OUTROS / NÃO ESPECIFICADOS", grupoOutros);
        }

        System.out.println("\nPrograma encerrado. Bons estudos!");
        scanner.close();
    }

    private static void exibirGrupo(String nomeGrupo, List<String> pessoas) {
        System.out.println("\n--- Grupo " + nomeGrupo + " (" + pessoas.size() + " pessoa(s)) ---");
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada neste grupo.");
        } else {
            for (String pessoa : pessoas) {
                System.out.println("- " + pessoa);
            }
        }
    }
}