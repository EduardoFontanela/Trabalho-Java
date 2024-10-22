import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List<Quarto> quartos = new ArrayList<>();
    List<Reserva> reservas = new ArrayList<>();

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quarto novoQuarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(novoQuarto);
        System.out.println("Quarto " + numero + " cadastrado com sucesso!");
    }

    public void cadastrarReserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto != null && quarto.disponivel) {
            Reserva novaReserva = new Reserva(nomeHospede, checkIn, checkOut, quarto);
            reservas.add(novaReserva);
            quarto.ocupar();
            System.out.println("Reserva realizada com sucesso para " + nomeHospede + " no quarto " + numeroQuarto);
        } else {
            System.out.println("Quarto não disponível ou não encontrado.");
        }
    }
    public void realizarCheckOut(int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto != null && !quarto.disponivel) {
            quarto.liberar();
            System.out.println("Check-out realizado com sucesso para o quarto " + numeroQuarto);
        } else {
            System.out.println("Quarto não está ocupado ou não encontrado.");
        }
    }

    public void exibirQuartos() {
        System.out.println("Lista de Quartos Cadastrados:");
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            for (Quarto quarto : quartos) {
                System.out.println(quarto);
            }
        }
    }

    private Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numero) {
                return quarto;
            }
        }
        return null;
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        boolean ocupacaoEncontrada = false;
        for (Reserva reserva : reservas) {
            if (!reserva.quartoReservado.disponivel) {
                System.out.println(reserva);
                ocupacaoEncontrada = true;
            }
        }
        if (!ocupacaoEncontrada) {
            System.out.println("Nenhum quarto ocupado no momento.");
        }
    }

    public void gerarHistoricoReservas(String nomeHospede) {
        System.out.println("Histórico de Reservas de " + nomeHospede + ":");
        boolean reservaEncontrada = false;
        for (Reserva reserva : reservas) {
            if (reserva.nomeHospede.equalsIgnoreCase(nomeHospede)) {
                System.out.println(reserva);
                reservaEncontrada = true;
            }
        }
        if (!reservaEncontrada) {
            System.out.println("Nenhuma reserva encontrada para " + nomeHospede);
        }
    }
}
