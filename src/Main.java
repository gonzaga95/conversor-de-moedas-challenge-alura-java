import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        ConnectExchangeRateApi connectExchangeRateApi = new ConnectExchangeRateApi();

        String opcao;

        System.out.println(
                "Bem-vinde ao conversor de moedas");

        do {

            System.out.println("""
                    [1] Converter moeda
                    [2] Listar conversões
                    [9] Sair
                    """);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Escolha a moeda base para conversão");
                    System.out.println("Utilizamos o padrão de códigos de três letras para moedas" +
                            "\nUSD, EUR, BRL, CAD, ARS, RMB, etc etc");
                    var baseCode = scanner.nextLine().toUpperCase();
                    System.out.println("Insira o valor a ser convertido");
                    var amount = scanner.nextLine();
                    System.out.println("Escolha a moeda final da conversão");
                    var targetCode = scanner.nextLine().toUpperCase();
                    try {
                        MoedasDados conversao = connectExchangeRateApi.fazConversao(baseCode, targetCode, amount);
                        System.out.println(conversao.toString().replace("AMOUNT", amount));
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case "2":
                    System.out.println("Lista de conversões");
                    break;
                case "9":
                    continue;
                default:
                    System.out.println("Insira uma opção válida");
                    break;
            }
        } while (!opcao.equals("9"));
    }
}
