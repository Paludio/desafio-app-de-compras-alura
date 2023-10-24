package compra;

public class Compra implements Comparable<Compra> {
  private double valor;
  private String descricao;

  public Compra (double valor, String descricao) {
    this.valor = valor;
    this.descricao = descricao;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public double getValor() {
    return this.valor;
  }

  @Override
  public int compareTo(Compra arg0) {
    return Double.compare(this.valor, arg0.valor);
  }

  @Override
  public String toString() {
    return String.format("%s - R$ %.2f", descricao, valor);
  }
}
