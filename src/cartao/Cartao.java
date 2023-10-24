package cartao;

public class Cartao {
  private double limite;
  private double saldo;

  public Cartao(double limite) {
    this.limite = limite;
  }

  public double getLimite() {
    return this.limite;
  }

  public void comprar(double valor) {
    this.limite -= valor;
    this.saldo += valor;
  }

  public double getSaldo() {
    return this.saldo;
  }
}
