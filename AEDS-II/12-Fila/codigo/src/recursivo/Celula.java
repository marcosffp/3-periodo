package recursivo;
public class Celula <E> {
  
  private E item;
  private Celula<E> proximo;

  public Celula() {
    this.item = null;
    this.proximo = null;
  }

  public Celula(E item, Celula<E> proximo) {
    this.item = item;
    this.proximo = proximo;
  }

  public Celula(E item) {
    this.item = item;
    this.proximo = null;
  }

  public E getItem() {
    return item;
  }

  public Celula<E> getProximo() {
    return proximo;
  }

  public void setProximo(Celula<E> proximo) {
    this.proximo = proximo;
  }
}
