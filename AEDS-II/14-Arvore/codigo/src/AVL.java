import java.util.Comparator;

public class AVL<K, V> extends ABB<K, V> {

  public AVL(Comparator<K> comparador) {
    super(comparador);
  }

  @Override
  protected No<K, V> inserir(K chave, V item, No<K, V> raizArvore) {
    return balancear(super.inserir(chave, item, raizArvore));
  }

  @Override
  protected No<K, V> remover(K chave, No<K, V> raizArvore) {
    return balancear(super.remover(chave, raizArvore));
  }

  private No<K, V> balancear(No<K, V> raizArvore) {
    if (raizArvore != null) {
      int fatorBalanceamentoRaiz = raizArvore.getFatorBalanceamento();
      int fatorBalanceamentoFilho = 0;
      if (fatorBalanceamentoRaiz == -2) {
        fatorBalanceamentoFilho = raizArvore.getDireita().getFatorBalanceamento();
        if (fatorBalanceamentoFilho == 1) {
          raizArvore.setDireita(rotacionarDireita(raizArvore.getDireita()));
        }
        raizArvore = rotacionarEsquerda(raizArvore);
      }
      else if (fatorBalanceamentoRaiz == 2) {
        fatorBalanceamentoFilho = raizArvore.getEsquerda().getFatorBalanceamento();
        if (fatorBalanceamentoFilho == -1) {
          raizArvore.setEsquerda(rotacionarEsquerda(raizArvore.getEsquerda()));
        }
        raizArvore = rotacionarDireita(raizArvore);
      }
      else {
        raizArvore.setAltura();
      }

    }
    return raizArvore;
  }

  private No<K, V> rotacionarEsquerda(No<K, V> raizArvore) {
    No<K, V> novaRaiz = raizArvore.getDireita();
    No<K, V> virarFolha = novaRaiz.getEsquerda();
    novaRaiz.setEsquerda(raizArvore);
    raizArvore.setDireita(virarFolha);

    raizArvore.setAltura();
    novaRaiz.setAltura();
    return novaRaiz;
  }

  private No<K, V> rotacionarDireita(No<K, V> raizArvore) {
    No<K, V> novaRaiz = raizArvore.getEsquerda();
    No<K, V> virarFolha = novaRaiz.getDireita();

    novaRaiz.setDireita(raizArvore);
    raizArvore.setEsquerda(virarFolha);

    raizArvore.setAltura();
    novaRaiz.setAltura();
    return novaRaiz;
  }

}
