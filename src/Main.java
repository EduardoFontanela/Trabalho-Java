import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        boolean running = true;
        while (running) {
            System.out.println(" Sistema de Gerenciamento de Hotel");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-out");
            System.out.println("4. Gerar Relatório de Ocupação");
            System.out.println("5. Gerar Histórico de Reservas");
            System.out.println("6. Ver Quartos Cadastrados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    System.out.print("Tipo do Quarto (solteiro, casal, suite): ");
                    String tipoQuarto = scanner.next();
                    System.out.print("Preço Diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(numeroQuarto, tipoQuarto, preco);
                    break;

                case 2:
                    System.out.print("Nome do Hóspede: ");
                    String nomeHospede = scanner.next();
                    System.out.print("Data de Check-in (AAAA-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.next());
                    System.out.print("Data de Check-out (AAAA-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.next());
                    System.out.print("Número do Quarto: ");
                    int numQuarto = scanner.nextInt();
                    hotel.cadastrarReserva(nomeHospede, checkIn, checkOut, numQuarto);
                    break;

                case 3:
                    System.out.print("Número do Quarto para Check-out: ");
                    int quartoCheckout = scanner.nextInt();
                    hotel.realizarCheckOut(quartoCheckout);
                    break;

                case 4:
                    hotel.gerarRelatorioOcupacao();
                    break;

                case 5:
                    System.out.print("Nome do Hóspede: ");
                    String nome = scanner.next();
                    hotel.gerarHistoricoReservas(nome);
                    break;

                case 6:
                    hotel.exibirQuartos();
                    break;

                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
