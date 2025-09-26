import entity.*;
import java.util.*;

public class App {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("======= Sistema de RH ========");
            System.out.println("1 - Criar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    criaFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // Método para criar funcionário
    public static void criaFuncionario() {
        try {
            System.out.println("Escolha o tipo de Funcionário: 1-CLT, 2-Gerente, 3-Diretor");
            int tipo = scan.nextInt(); scan.nextLine();

            // Dados comuns
            System.out.print("Nome: "); String nome = scan.nextLine();
            System.out.print("Férias? (true/false): "); boolean ferias = scan.nextBoolean();
            System.out.print("Dias de férias: "); int feriasDias = scan.nextInt(); scan.nextLine();
            System.out.print("Gênero: "); String genero = scan.nextLine();
            System.out.print("Salário Base: "); double salarioBase = scan.nextDouble(); scan.nextLine();
            System.out.print("CPF: "); String cpf = scan.nextLine();
            System.out.print("Registro: "); String registro = scan.nextLine();
            System.out.print("Vale Alimentação: "); double valeAlimentacao = scan.nextDouble();
            System.out.print("Vale Transporte: "); double valeTransporte = scan.nextDouble();
            System.out.print("Plano de Saúde? (true/false): "); boolean planoSaude = scan.nextBoolean();
            scan.nextLine();

            Funcionario f = null;

            if (tipo == 1) {
                f = new FuncionarioCLT(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                        valeTransporte, valeAlimentacao, planoSaude);

            } else if (tipo == 2) {
                System.out.print("Departamento: "); String dep = scan.nextLine();
                System.out.print("Quantidade de subordinados: "); int sub = scan.nextInt();
                System.out.print("Sala própria? (true/false): "); boolean sala = scan.nextBoolean();
                f = new Gerente(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                        valeTransporte, valeAlimentacao, planoSaude, dep, sub, sala);

            } else if (tipo == 3) {
                System.out.print("Departamento: "); String dep = scan.nextLine();
                System.out.print("Quantidade de subordinados: "); int sub = scan.nextInt();
                System.out.print("Sala própria? (true/false): "); boolean sala = scan.nextBoolean();
                System.out.print("Participação nos lucros: "); double pl = scan.nextDouble();
                System.out.print("Possui notebook? (true/false): "); boolean nb = scan.nextBoolean();
                System.out.print("É sócio? (true/false): "); boolean s = scan.nextBoolean();
                f = new Diretor(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                        valeTransporte, valeAlimentacao, planoSaude, dep, sub, sala, pl, nb, s);
            } else {
                System.out.println("Tipo inválido!");
            }

            if (f != null) {
                funcionarios.add(f);
                System.out.println("Funcionário cadastrado com sucesso: " + f.getNome());
            }

        } catch (Exception e) {
            System.out.println("Erro no cadastro!");
            scan.nextLine();
        }
    }

    // Método para listar funcionários
    public static void listarFuncionarios() {
        System.out.println("======= Lista de Funcionários =======");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            int contador = 1;
            for (Funcionario f : funcionarios) {
                System.out.println("Funcionário " + contador + ":");
                System.out.println(f.toString());
                System.out.println("----------------------------");
                contador++;
            }
        }
    }
}
