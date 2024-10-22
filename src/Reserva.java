import java.time.LocalDate;

public class Reserva {
    String nomeHospede;
    LocalDate dataCheckIn;
    LocalDate dataCheckOut;
    Quarto quartoReservado;

    public Reserva(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut, Quarto quartoReservado) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quartoReservado = quartoReservado;
    }

    public String toString() {
        return "Reserva de " + nomeHospede + " - Check-in: " + dataCheckIn + " - Check-out: " + dataCheckOut + " - Quarto: " + quartoReservado.numero;

    }
}
