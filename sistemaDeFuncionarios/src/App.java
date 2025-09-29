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
            System.out.println("3 - Promover Funcionário");
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
                case 3:
                    promoverFuncionario();
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
            int tipo = scan.nextInt();
            scan.nextLine();

            // Dados
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Férias? (true/false): ");
            boolean ferias = scan.nextBoolean();
            System.out.print("Dias de férias: ");
            int feriasDias = scan.nextInt();
            scan.nextLine();
            System.out.print("Gênero: ");
            String genero = scan.nextLine();
            System.out.print("Salário Base: ");
            double salarioBase = scan.nextDouble();
            scan.nextLine();
            System.out.print("CPF: ");
            String cpf = scan.nextLine();
            System.out.print("Registro: ");
            String registro = scan.nextLine();
            System.out.print("Vale Alimentação: ");
            double valeAlimentacao = scan.nextDouble();
            System.out.print("Vale Transporte: ");
            double valeTransporte = scan.nextDouble();
            System.out.print("Plano de Saúde? (true/false): ");
            boolean planoSaude = scan.nextBoolean();
            scan.nextLine();

            Funcionario f = null;

            if (tipo == 1) {
                f = new FuncionarioCLT(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                        valeTransporte, valeAlimentacao, planoSaude);

            } else if (tipo == 2) {
                System.out.print("Departamento: ");
                String dep = scan.nextLine();
                System.out.print("Quantidade de subordinados: ");
                int sub = scan.nextInt();
                System.out.print("Sala própria? (true/false): ");
                boolean sala = scan.nextBoolean();
                f = new Gerente(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                        valeTransporte, valeAlimentacao, planoSaude, dep, sub, sala);

            } else if (tipo == 3) {
                System.out.print("Departamento: ");
                String dep = scan.nextLine();
                System.out.print("Quantidade de subordinados: ");
                int sub = scan.nextInt();
                System.out.print("Sala própria? (true/false): ");
                boolean sala = scan.nextBoolean();
                System.out.print("Participação nos lucros: ");
                double pl = scan.nextDouble();
                System.out.print("Possui notebook? (true/false): ");
                boolean nb = scan.nextBoolean();
                System.out.print("É sócio? (true/false): ");
                boolean s = scan.nextBoolean();
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

    // Método para promover um funcionário a Diretor
    public static void promoverFuncionario() {
        listarFuncionarios();
        System.out.print("Digite o NÚMERO do funcionário para promover: ");

        try {
            int indice = scan.nextInt();
            scan.nextLine(); // Limpa o buffer

            if (indice < 1 || indice > funcionarios.size()) {
                System.out.println("Índice inválido.");
                return;
            }

            // Upcasting implícito: Funcionario é a classe pai
            Funcionario funcionarioPromovido = funcionarios.get(indice - 1);

            // 1. Verifica se já é Diretor e barra 
            if (funcionarioPromovido instanceof Diretor) {
                System.out.println(funcionarioPromovido.getNome() + " já é Diretor. Promoção não necessária.");
                return;
            }

            System.out.println("Iniciando promoção de " + funcionarioPromovido.getNome() + " para Diretor");

            // Variáveis para coletar/reaproveitar dados
            String dep = "Novo Dep.";
            int sub = 0;
            boolean sala = true;

            // Downcasting Condicional (para reaproveitar dados de Gerente)
            if (funcionarioPromovido instanceof Gerente) {
                // Downcasting para Gerente, 
                Gerente g = (Gerente) funcionarioPromovido;
                dep = g.getDepartamento();
                sub = g.getQuantidadeDeSubordinados();
                sala = g.isSalaPropria();
                System.out.println("Dados de Gerente reaproveitados: " + dep);
            } else {
                // Se for CLT puro, coletar novos dados de Gerente
                System.out.print("Novo Departamento do Diretor: ");
                dep = scan.nextLine();
                System.out.print("Quantidade de subordinados: ");
                sub = scan.nextInt();
                scan.nextLine();
            }

            // Coleta dados específicos de Diretor
            double pl = 2000.0; // PL é fixo
            System.out.print("Possui notebook? (true/false): ");
            boolean nb = scan.nextBoolean();
            scan.nextLine();
            System.out.print("É sócio? (true/false): ");
            boolean s = scan.nextBoolean();
            scan.nextLine();

            // 3. Cria a nova instância de Diretor (Downcasting dos CLT/Gerente para
            // Diretor)
            Diretor novoDiretor = new Diretor(
                    // Dados de Funcionario (acessíveis via getters da classe pai)
                    funcionarioPromovido.getNome(), funcionarioPromovido.getFeriasDias(), funcionarioPromovido.getFerias(),
                    funcionarioPromovido.getGenero(), funcionarioPromovido.getSalarioBase(), funcionarioPromovido.getCpf(),
                    funcionarioPromovido.getRegistro(),
                    // Downcasting rápido para acessar CLT getters (funciona porque é verificado no
                    // início do método)
                    ((FuncionarioCLT) funcionarioPromovido).getValeTransporte(),
                    ((FuncionarioCLT) funcionarioPromovido).getValeAlimentacao(),
                    ((FuncionarioCLT) funcionarioPromovido).getPlanoDeSaude(),
                    // Dados de Gerente
                    dep, sub, sala,
                    // Dados de Diretor
                    pl, nb, s);

            // 4. Substitui o funcionário na lista
            funcionarios.set(indice - 1, novoDiretor);
            System.out.println("-> Funcionário " + novoDiretor.getNome() + " PROMOVIDO para Diretor com sucesso!");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro na promoção.");
        }
    }
}
