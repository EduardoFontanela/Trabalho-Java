public class Quarto {
    int numero;
    String tipo;
    double precoDiario;
    boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true;
    }

    public void ocupar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - Preço Diário: R$" + precoDiario + " - Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
