import entity.*;
import java.util.*;

public class App {
    // Declarações estáticas no topo
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = -1; // Inicializa com um valor diferente de 0

        while (opcao != 0) {
            try {
                // Menu Principal
                System.out.println("\n======= Sistema de RH ========");
                System.out.println("1 - Criar Funcionário");
                System.out.println("2 - Listar Funcionários");
                System.out.println("3 - Promover Funcionário");
                System.out.println("4 - Excluir um Funcionário");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        try {

                            System.out.println("Escolha o tipo de Funcionário: 1-CLT, 2-Gerente, 3-Diretor");
                            int tipo = scan.nextInt();
                            scan.nextLine();

                            // Pede os dados do funcionário para o usuário.
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

                            // Variáveis com os atributos exclusivos de Gerente e Diretor
                            String departamento = "";
                            int subordinados = 0;
                            boolean salaPropria = false;
                            double participacaoLucros = 0.0;
                            boolean notebookCorporativo = false;
                            boolean socio = false;

                            if (tipo == 2 || tipo == 3) {
                                // Pede ao usuário os dados de Gerente ou Diretor
                                System.out.print("Departamento: ");
                                departamento = scan.nextLine();
                                System.out.print("Quantidade de subordinados: ");
                                subordinados = scan.nextInt();
                                System.out.print("Sala própria? (true/false): ");
                                salaPropria = scan.nextBoolean();
                                scan.nextLine();

                                if (tipo == 3) {
                                    // Dados de Diretor
                                    System.out.print("Participação nos lucros: ");
                                    participacaoLucros = scan.nextDouble();
                                    System.out.print("Possui notebook? (true/false): ");
                                    notebookCorporativo = scan.nextBoolean();
                                    System.out.print("É sócio? (true/false): ");
                                    socio = scan.nextBoolean();
                                    scan.nextLine();
                                }
                            }

                            // Chama o método de Criar o Funcionário
                            criaFuncionario(tipo, nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                                    valeTransporte, valeAlimentacao, planoSaude, departamento, subordinados,
                                    salaPropria, participacaoLucros, notebookCorporativo, socio);

                        } catch (InputMismatchException e) {
                            System.out.println("Erro!, Digite os campos novamente!");
                            scan.nextLine();
                        }
                        break;

                    case 2:
                        listarFuncionarios();
                        break;
                    case 3:
                        if (funcionarios.isEmpty()) {
                            System.out.println("Nenhum funcionário cadastrado para promover.");
                            break;
                        }

                        try {
                            // Exibe os funcionários na lista
                            listarFuncionarios();
                            System.out.print("Digite o NÚMERO do funcionário para promover: ");
                            int indice = scan.nextInt();
                            scan.nextLine();

                            int numeroFuncionario = indice - 1;

                            if (numeroFuncionario < 0 || numeroFuncionario >= funcionarios.size()) {
                                System.out.println("Índice inválido.");
                                break;
                            }

                            Funcionario funcionarioPromovido = funcionarios.get(numeroFuncionario);

                            // Pergunta ao usuário para qual cargo quer promover o funcionário
                            System.out
                                    .println("Para qual cargo deseja promover " + funcionarioPromovido.getNome() + "?");
                            System.out.println("1 - Gerente");
                            System.out.println("2 - Diretor");
                            System.out.print("Escolha: ");
                            int cargoDestino = scan.nextInt();
                            scan.nextLine();

                            // Promoção para Gerente usando o downcasting
                            if (cargoDestino == 1) {
                                if (funcionarioPromovido instanceof Gerente
                                        || funcionarioPromovido instanceof Diretor) {
                                    System.out.println(funcionarioPromovido.getNome()
                                            + " já possui cargo de liderança (Gerente/Diretor).");
                                    break;
                                }

                                System.out.println("Promovendo para Gerente...");

                                // Coleta dados específicos de Gerente
                                System.out.print("Novo Departamento: ");
                                String departamentoGerente = scan.nextLine();
                                System.out.print("Quantidade de subordinados: ");
                                int subordinadosGerente = scan.nextInt();
                                System.out.print("Sala própria? (true/false): ");
                                boolean salaPropriaGerente = scan.nextBoolean();
                                scan.nextLine();

                                promoverParaGerente(numeroFuncionario, departamentoGerente, subordinadosGerente,
                                        salaPropriaGerente);

                                // Verifica se ja é Diretor
                            } else if (cargoDestino == 2) {
                                if (funcionarioPromovido instanceof Diretor) {
                                    System.out.println(
                                            funcionarioPromovido.getNome() + " já é Diretor. Promoção não necessária.");
                                    break;
                                }

                                System.out.println("Promovendo para Diretor...");

                                String departamentoDiretor = "";
                                int subordinadosDiretor = 0;
                                boolean salaPropriaDiretor = true;

                                // Reaproveita dados de Gerente, se for o caso
                                if (funcionarioPromovido instanceof Gerente) {
                                    Gerente novoGerente = (Gerente) funcionarioPromovido;
                                    departamentoDiretor = novoGerente.getDepartamento();
                                    subordinadosDiretor = novoGerente.getQuantidadeDeSubordinados();
                                    salaPropriaDiretor = novoGerente.isSalaPropria();
                                    System.out.println("Dados de Gerente reaproveitados: " + departamentoDiretor);
                                } else {
                                    // Coleta novos dados de Gerente para CLT puro
                                    System.out.print("Novo Departamento do Diretor: ");
                                    departamentoDiretor = scan.nextLine();
                                    System.out.print("Quantidade de subordinados: ");
                                    subordinadosDiretor = scan.nextInt();
                                    scan.nextLine();
                                }

                                // Dados específicos de Diretor
                                System.out.print("Participação nos lucros (Valor Base): ");
                                double participacaoLucros = scan.nextDouble();

                                System.out.print("Possui notebook corporativo? (true/false): ");
                                boolean notebookCorporativo = scan.nextBoolean();
                                scan.nextLine();

                                System.out.print("É sócio da empresa? (true/false): ");
                                boolean socio = scan.nextBoolean();
                                scan.nextLine();

                                // Chamada do método de Diretor
                                // Assume-se que 'realizarPromocao' é o método que promove para Diretor
                                realizarPromocaoDiretor(numeroFuncionario, departamentoDiretor, subordinadosDiretor,
                                        salaPropriaDiretor, participacaoLucros, notebookCorporativo, socio);

                            } else {
                                System.out.println("Opção inválida.");
                            }

                        } catch (Exception e) {
                            System.out.println("Erro ao promover o funcionário " + e);
                        }
                        break;
                    case 4:
                        excluirFuncionario();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {

                System.out.println("Erro!!");
            }
        }
    }

    // Método de criar o funcionário
    public static void criaFuncionario(int tipo, String nome, int feriasDias, boolean ferias, String genero,
            double salarioBase, String cpf, String registro, double valeTransporte,
            double valeAlimentacao, boolean planoSaude, String departamento, int subordinados,
            boolean sala, double pl, boolean notebook, boolean socio) {
        Funcionario funcionario = null;

        // Verifica qual o tipo do Funcionario.
        if (tipo == 1) {
            funcionario = new FuncionarioCLT(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                    valeTransporte, valeAlimentacao, planoSaude);
        } else if (tipo == 2) {
            funcionario = new Gerente(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                    valeTransporte, valeAlimentacao, planoSaude, departamento, subordinados, sala);
        } else if (tipo == 3) {
            funcionario = new Diretor(nome, feriasDias, ferias, genero, salarioBase, cpf, registro,
                    valeTransporte, valeAlimentacao, planoSaude, departamento, subordinados, sala, pl, notebook, socio);
        } else {
            System.out.println("Tipo inválido! Funcionário não cadastrado.");
        }

        funcionarios.add(funcionario);
        // Exibe o nome do funcionário cadastrado
        System.out.println("Funcionário cadastrado com sucesso: " + funcionario.getNome());
    }

    // Método de listar os funcionários
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

    // Método para promover o Diretor
    public static void realizarPromocaoDiretor(int numeroFuncionario, String departamento, int subordinados,
            boolean salaPropria, double participacaoLucros, boolean notebook, boolean socio) {

        Funcionario funcionarioPromovido = funcionarios.get(numeroFuncionario);

        // Verifica se ja é um diretor
        if (funcionarioPromovido instanceof Diretor) {
            System.out.println(funcionarioPromovido.getNome() + " já é Diretor. Promoção não necessária.");
            return;
        }

        FuncionarioCLT dadosClt = (FuncionarioCLT) funcionarioPromovido;

        // Cria a nova instância de Diretor
        Diretor novoDiretor = new Diretor(
                // Dados de Funcionario
                funcionarioPromovido.getNome(), funcionarioPromovido.getFeriasDias(), funcionarioPromovido.getFerias(),
                funcionarioPromovido.getGenero(), funcionarioPromovido.getSalarioBase(), funcionarioPromovido.getCpf(),
                funcionarioPromovido.getRegistro(),
                // Dados de FuncionarioCLT
                dadosClt.getValeTransporte(), dadosClt.getValeAlimentacao(), dadosClt.getPlanoDeSaude(),
                // Dados de Gerente
                departamento, subordinados, salaPropria,
                // Dados do Diretor
                participacaoLucros, notebook, socio);

        // Substitui o funcionário na lista
        funcionarios.set(numeroFuncionario, novoDiretor);
        System.out.println(" Funcionário " + novoDiretor.getNome() + " PROMOVIDO para Diretor com sucesso!");
    }

    // Método para promover para Gerente
    public static void promoverParaGerente(int indiceFuncionario, String departamento,
            int subordinados, boolean salaPropria) {

        Funcionario funcionarioPromovido = funcionarios.get(indiceFuncionario);

        // Verifica se o funcionário ja é um diretor
        if (funcionarioPromovido instanceof Diretor) {
            System.out.println(
                    funcionarioPromovido.getNome() + "  já é um Diretor");
            return;
        }

        // Verifica se o funcionário ja é um Gerente.
        if (funcionarioPromovido instanceof Gerente) {
            System.out.println(funcionarioPromovido.getNome() + " já é Gerente");
            return;
        }

        // O funcionário Promovido é um FuncionarioCLT
        FuncionarioCLT dadosClt = (FuncionarioCLT) funcionarioPromovido;

        // Cria a nova instância de Gerente
        Gerente novoGerente = new Gerente(
                // Dados de Funcionario
                funcionarioPromovido.getNome(), dadosClt.getFeriasDias(), dadosClt.getFerias(),
                dadosClt.getGenero(), dadosClt.getSalarioBase(), dadosClt.getCpf(),
                dadosClt.getRegistro(),
                // Dados de FuncionarioCLT
                dadosClt.getValeTransporte(), dadosClt.getValeAlimentacao(), dadosClt.getPlanoDeSaude(),
                // Dados de Gerente
                departamento, subordinados, salaPropria);

        // Substitui o funcionário na lista
        funcionarios.set(indiceFuncionario, novoGerente);
        System.out.println("-> Funcionário " + novoGerente.getNome() + " PROMOVIDO para GERENTE com sucesso!");
    }

    public static void excluirFuncionario() {
        try {
            // Verifica se a lista não está vazia.
            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionário foi cadastrado.");
            } else {
                // Exibe a lista de funcionários.
                listarFuncionarios();
                System.out.println("Escolha um funcionário para excluir:");
                int posicaoFuncionario = scan.nextInt();
                scan.nextLine();
                int numeroFuncionario = posicaoFuncionario - 1;

                if (numeroFuncionario >= 0 && numeroFuncionario < funcionarios.size()) {
                    funcionarios.remove(numeroFuncionario);
                    System.out.println("Funcionário removido com sucesso!");
                } else {
                    System.out.println("Número de funcionário inválido.");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro! Tente Novamente!");
            scan.nextLine();
        }
    }
}