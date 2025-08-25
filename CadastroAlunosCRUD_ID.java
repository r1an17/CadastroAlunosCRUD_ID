import java.util.ArrayList;
import java.util.Scanner;

//Classe Aluno
class Aluno {
    int id;//ID sequencial fixo
    String nome;
    int idade;
    double nota;

    //Construtor
    Aluno(int id, String nome, int idade, double nota) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    //Método para exibir os dados do aluno
    void exibir() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Nota: " + nota);
    }
}

//Classe principal
public class CadastroAlunosCRUD_ID {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        int contadorId = 0;//Controla IDs sequenciais

        int opcao;
        do {
            System.out.println("-- MENU --");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Editar aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();//Quebra de linha

            switch (opcao) {
                case 1://Cadastro
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();

                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();
                    sc.nextLine();

                    listaAlunos.add(new Aluno(contadorId, nome, idade, nota));
                    System.out.println("Aluno cadastrado com sucesso! (ID: " + contadorId + ")");
                    contadorId++;
                    break;

                case 2://Lista
                    System.out.println("\n=== Lista de Alunos ===");
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (Aluno a : listaAlunos) {
                            a.exibir();
                        }
                    }
                    break;

                case 3://Lista
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno para editar.");
                    } else {
                        System.out.print("Digite o ID do aluno que deseja editar: ");
                        int idEditar = sc.nextInt();
                        sc.nextLine();

                        Aluno encontrado = null;
                        for (Aluno a : listaAlunos) {
                            if (a.id == idEditar) {
                                encontrado = a;
                                break;
                            }
                        }

                        if (encontrado != null) {
                            System.out.print("Novo nome (" + encontrado.nome + "): ");
                            String novoNome = sc.nextLine();
                            if (!novoNome.isEmpty()) encontrado.nome = novoNome;

                            System.out.print("Nova idade (" + encontrado.idade + "): ");
                            String novaIdadeStr = sc.nextLine();
                            if (!novaIdadeStr.isEmpty()) encontrado.idade = Integer.parseInt(novaIdadeStr);

                            System.out.print("Nova nota (" + encontrado.nota + "): ");
                            String novaNotaStr = sc.nextLine();
                            if (!novaNotaStr.isEmpty()) encontrado.nota = Double.parseDouble(novaNotaStr);

                            System.out.println("Aluno atualizado com sucesso!");
                        } else {
                            System.out.println("ID não encontrado!");
                        }
                    }
                    break;

                case 4://Remover
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno para remover.");
                    } else {
                        System.out.print("Digite o ID do aluno que deseja remover: ");
                        int idRemover = sc.nextInt();
                        sc.nextLine();

                        Aluno encontrado = null;
                        for (Aluno a : listaAlunos) {
                            if (a.id == idRemover) {
                                encontrado = a;
                                break;
                            }
                        }

                        if (encontrado != null) {
                            listaAlunos.remove(encontrado);
                            System.out.println("🗑️ Aluno removido com sucesso!");
                        } else {
                            System.out.println("❌ ID não encontrado!");
                        }
                    }
                    break;

                case 5://Sair
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        sc.close();
    }
}