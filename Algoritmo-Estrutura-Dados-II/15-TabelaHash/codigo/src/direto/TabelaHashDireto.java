package direto;

public abstract class TabelaHashDireto<K, V> implements IMapeamento<K, V> {

  protected Entrada<K, V>[] tabelaHash;
  protected int capacidade;

  @SuppressWarnings("unchecked")
  public TabelaHashDireto(int capacidade) {

    this.capacidade = capacidade;
    tabelaHash = (Entrada<K, V>[]) new Entrada[this.capacidade];

    for (int i = 0; i < this.capacidade; i++)
      tabelaHash[i] = null;
  }

  protected abstract int funcaoHash(K chave, int tentativas);

  public abstract int inserir(K chave, V item);

  public abstract V pesquisar(K chave);

  public abstract V remover(K chave);

  @Override
  public int tamanho() {
    int tamanho = 0;
    for (int i = 0; i < capacidade; i++) {
      if ((tabelaHash[i] != null) && !(tabelaHash[i].isRemovida())) {
        tamanho++;
      }
    }
    return tamanho;
  }

  @Override
  public String toString() {
    return percorrer();
  }

  @Override
  public String percorrer() {

    String conteudo = "";
    for (int i = 0; i < capacidade; i++) {
      conteudo += ("Posição[" + i + "]: ");
      if ((tabelaHash[i] == null) || (tabelaHash[i].isRemovida())) {
        conteudo += "vazia\n";
      } else {
        conteudo += tabelaHash[i] + "\n";
      }
    }
    return conteudo;
  }

}
