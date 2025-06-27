package direto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class TabelaHashReash<K, V> extends TabelaHashDireto<K, V> {

  public TabelaHashReash(int capacidade) {
    super(capacidade);
  }

  @Override
  protected int funcaoHash(K chave, int tentativas) {
    return (Math.abs(chave.hashCode() + tentativas)) % capacidade;
  }

  @Override
  public int inserir(K chave, V item) {

    int tentativas = 0;
    int posicao = funcaoHash(chave, tentativas);
    boolean inseriu = false;

    while ((tentativas < capacidade) && !inseriu) {
      if ((tabelaHash[posicao] == null) || (tabelaHash[posicao].isRemovida())) {
        tabelaHash[posicao] = new Entrada<>(chave, item);
        inseriu = true;
      } else if ((tabelaHash[posicao].getChave().equals(chave)) && !(tabelaHash[posicao].isRemovida())) {
        throw new IllegalArgumentException("O item já havia sido inserido anteriormente na tabela hash!");
      } else {
        tentativas++;
        posicao = funcaoHash(chave, tentativas);
      }
    }

    if (inseriu) {
      return posicao;
    } else {
      throw new IllegalStateException("A tabela hash está cheia: não foi possível inserir o novo elemento.");
    }
  }

  @Override
  public V pesquisar(K chave) {

    int tentativas = 0;
    int posicao = funcaoHash(chave, tentativas);

    while (tentativas < capacidade) {
      if (tabelaHash[posicao] == null) {
        throw new NoSuchElementException("Item não encontrado!");
      } else if ((tabelaHash[posicao].getChave().equals(chave)) && !(tabelaHash[posicao].isRemovida())) {
        return tabelaHash[posicao].getValor();
      } else {
        tentativas++;
        posicao = funcaoHash(chave, tentativas);
      }
    }

    throw new NoSuchElementException("Item não encontrado!");
  }

  @Override
  public V remover(K chave) {

    int tentativas = 0;
    int posicao = funcaoHash(chave, tentativas);

    while (tentativas < capacidade) {

      if (tabelaHash[posicao] == null) {
        throw new NoSuchElementException("Item não encontrado!");
      } else if ((tabelaHash[posicao].getChave().equals(chave)) && !(tabelaHash[posicao].isRemovida())) {
        tabelaHash[posicao].setRemovida(true);
        return tabelaHash[posicao].getValor();
      } else {
        tentativas++;

        posicao = funcaoHash(chave, tentativas);
      }
    }

    throw new NoSuchElementException("Item não encontrado!");
  }

  public void restaura() {
    Entrada<K, V>[] elementosValidos = coletarElementosValidos();
    limparTabela();
    reinserirElementos(elementosValidos);
  }

  @SuppressWarnings("unchecked")
  private Entrada<K, V>[] coletarElementosValidos() {
    Entrada<K, V>[] elementosTemp = (Entrada<K, V>[]) new Entrada[capacidade];
    int count = 0;
    for (int i = 0; i < capacidade; i++) {
      if (tabelaHash[i] != null && !tabelaHash[i].isRemovida()) {
        elementosTemp[count++] = tabelaHash[i];
      }
    }
    return Arrays.copyOf(elementosTemp, count);
  }

  private void limparTabela() {
    for (int i = 0; i < capacidade; i++) {
      tabelaHash[i] = null;
    }
  }

  private void reinserirElementos(Entrada<K, V>[] elementos) {
    for (int i = 0; i < elementos.length; i++) {
      Entrada<K, V> entrada = elementos[i];
      this.inserir(entrada.getChave(), entrada.getValor());
    }
  }
}
