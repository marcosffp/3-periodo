package direto;

import java.util.NoSuchElementException;

public class TabelaHashAreaReserva<K, V> extends TabelaHashDireto<K, V> {

  private static final double PORCENTAGEM_AREA_RESERVADA = 0.3;

  public TabelaHashAreaReserva(int capacidade) {
    super(capacidade);
  }

  @Override
  protected int funcaoHash(K chave, int tentativas) {
    return (Math.abs(chave.hashCode() + tentativas)) % tamanhoTabelaHash();
  }

  private int tamanhoTabelaHash() {
    return capacidade - ((int) (capacidade * PORCENTAGEM_AREA_RESERVADA));
  }

  @Override
  public int inserir(K chave, V item) {
    int posicao = funcaoHash(chave, 0);
    if ((tabelaHash[posicao] == null) || (tabelaHash[posicao].isRemovida())) {
      tabelaHash[posicao] = new Entrada<>(chave, item);
      return posicao;
    } else if ((tabelaHash[posicao].getChave().equals(chave)) && !(tabelaHash[posicao].isRemovida())) {
      throw new IllegalArgumentException("O item já havia sido inserido anteriormente na tabela hash!");
    } else {
      return inserirNaAreaReserva(chave, item);
    }
  }

  private int inserirNaAreaReserva(K chave, V item) {
    int inicio = tamanhoTabelaHash();
    int fim = capacidade;

    for (int i = inicio; i < fim; i++) {
      if (tabelaHash[i] == null || tabelaHash[i].isRemovida()) {
        tabelaHash[i] = new Entrada<>(chave, item);
        return i;
      }
    }

    throw new IllegalStateException("Área reservada cheia. Não é possível inserir o item.");
  }

  @Override
  public V pesquisar(K chave) {
    int posicao = funcaoHash(chave, 0);

    if (tabelaHash[posicao] != null &&
        !tabelaHash[posicao].isRemovida() &&
        tabelaHash[posicao].getChave().equals(chave)) {
      return tabelaHash[posicao].getValor();
    }
    int inicioReserva = tamanhoTabelaHash();
    for (int i = inicioReserva; i < capacidade; i++) {
      if (tabelaHash[i] != null &&
          !tabelaHash[i].isRemovida() &&
          tabelaHash[i].getChave().equals(chave)) {
        return tabelaHash[i].getValor();
      }
    }
    throw new NoSuchElementException("Item não encontrado!");
  }

  @Override
  public V remover(K chave) {
    int posicao = funcaoHash(chave, 0);

    if (tabelaHash[posicao] != null &&
        !tabelaHash[posicao].isRemovida() &&
        tabelaHash[posicao].getChave().equals(chave)) {

      tabelaHash[posicao].setRemovida(true);
      return tabelaHash[posicao].getValor();
    }

    int inicioReserva = tamanhoTabelaHash();
    for (int i = inicioReserva; i < capacidade; i++) {
      if (tabelaHash[i] != null &&
          !tabelaHash[i].isRemovida() &&
          tabelaHash[i].getChave().equals(chave)) {

        tabelaHash[i].setRemovida(true);
        return tabelaHash[i].getValor();
      }
    }

    throw new NoSuchElementException("Item não encontrado!");
  }
}
