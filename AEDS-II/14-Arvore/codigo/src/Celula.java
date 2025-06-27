
public class Celula<E> {
  private E item;
  private Celula<E> proximo;

  public Celula() {
    item = null;
    proximo = null;
  }

  public Celula(E item, Celula<E> proximo) {
    this.proximo = proximo;
    this.item = item;

  }

  public Celula(E item) {
    this.item = item;
    this.proximo = null;
  }

  public E getItem() {
    return item;
  }

  public void setItem(E item) {
    this.item = item;
  }

  public Celula<E> getProximo() {
    return proximo;
  }

  public void setProximo(Celula<E> proximo) {
    this.proximo = proximo;
  }

}
