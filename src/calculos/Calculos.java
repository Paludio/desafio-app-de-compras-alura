package calculos;

import java.util.List;

import compra.Compra;

public class Calculos {
  public static double somaCarrinho(List<Compra> compras) {
    return compras.stream()
        .map(Compra::getValor)
        .reduce(0.00, (e1, e2) -> e1 + e2);
  }
}