public class ListaV<E> {

    private final E[] lista;
    private final int primeiro;
    private int ultimo;

    @SuppressWarnings("unchecked")
    public ListaV(int tamanho) {

        lista = (E[]) new Object[tamanho];
        this.primeiro = this.ultimo = 0;
    }

    public boolean vazia() {

        return (this.primeiro == this.ultimo);
    }

    public boolean cheia() {

        return (this.ultimo == this.lista.length);
    }

    public void inserir(E novo, int posicao) {

        if (cheia())
            throw new IllegalStateException("Não foi possível inserir o item na lista: "
                    + "a lista está cheia!");

        if ((posicao < 0) || (posicao > this.ultimo))
            throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
                    + "a posição informada é inválida!");

        for (int i = this.ultimo; i > posicao; i--)
            lista[i] = lista[i - 1];

        lista[posicao] = novo;

        this.ultimo++;
    }

    public E remover(int posicao) {

        E removido;

        if (vazia())
            throw new IllegalStateException("Não foi possível remover o item da lista: "
                    + "a lista está vazia!");

        if ((posicao < 0) || (posicao >= this.ultimo))
            throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: "
                    + "a posição informada é inválida!");

        removido = lista[posicao];

        this.ultimo--;

        for (int i = posicao; i < this.ultimo; i++)
            lista[i] = lista[i + 1];

        return removido;
    }
}