import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	/*
	 * Implemente o método public void concatenar (Pilha<E> pilha), capaz de
	 * concatenar, ao final da pilha original, a pilha passada como parâmetro.
	 */
	public void concatenar(Pilha<E> pilha) {
		if (pilha.vazia()) {
			return;
		}
		Pilha<E> pilhaAux = new Pilha<E>();
		Celula<E> aux = pilha.topo;
		while (aux != pilha.fundo) {
			pilhaAux.empilhar(aux.getItem());
			aux = aux.getProximo();
		}
		while (!pilhaAux.vazia()) {
			this.empilhar(pilhaAux.desempilhar());
		}
	}

	/*
	 * Implemente a função public int obterNumeroItens(), que retorna o número de
	 * itens da pilha.
	 */
	public int obterNumeroItens() {
		int count = 0;
		Celula<E> aux = topo;
		while (aux != fundo) {
			count++;
			aux = aux.getProximo();
		}
		return count;
	}

	/*
	 * Implemente o método public void inverter(), capaz de inverter a pilha.
	 */
	public void inverter() {
		Pilha<E> pilhaAux = new Pilha<E>();
		while (!this.vazia()) {
			pilhaAux.empilhar(this.desempilhar());
		}
		this.topo = pilhaAux.topo;
		this.fundo = pilhaAux.fundo;
	}

	/*
	 * mplemente, em Java, um programa que receba como entrada uma String e indique
	 * se essa
	 * String corresponde a um palíndromo. Palíndromos são palavras, grupos de
	 * palavras ou
	 * versos em que o sentido é o mesmo, quer se leia da esquerda para a direita ou
	 * da direita
	 * para a esquerda. São exemplos de palíndromos: “reviver”, “radar”, “arara”,
	 * “Acaiaca”, “A
	 * grama é amarga”, “Ame o poema”, “Socorram-me em Marrocos”, etc. Utilize
	 * obrigatoriamente uma pilha implementada por meio de células, como a
	 * implementada
	 * durante as aulas teóricas, para a resolução desse exercício.
	 */

	public boolean ehPalindromo(String str) {
		String palavra = str.replaceAll("[^a-zA-Z]", "").toUpperCase();
		Pilha<Character> pilha = new Pilha<>();
		for (int i = 0; i < palavra.length(); i++) {
			pilha.empilhar(palavra.charAt(i));
		}
		int i = 0;
		while (!pilha.vazia()) {
			if (pilha.desempilhar() != palavra.charAt(i)) {
				return false;
			}
			i++;
		}
		return true;
	}

	/*
	 * Implemente o método public boolean verificarExistencia(E item), que
	 * verifica a existência, na pilha, de item correspondente àquele que foi passado
	 * como
	 * parâmetro para esse método. Essa correspondência deve basear-se no(s)
	 * critério(s)
	 * empregado(s) na implementação do método de comparação do item. Se o item for
	 * localizado na pilha, esse método deve retornar true. Caso contrário, esse
	 * método deve
	 * retornar false.
	 */
	public boolean verificarExistencia(E item) {
		Celula<E> aux = topo;
		while (aux != fundo) {
			if (aux.getItem().equals(item)) {
				return true;
			}
			aux = aux.getProximo();
		}
		return false;
	}

	/*
	 * Implemente o método public int obterNumItensAFrente(E item)
	 * throws Exception, que retorna o número de itens que estão localizados, na
	 * pilha, a
	 * frente do item correspondente àquele que foi passado como parâmetro para esse
	 * método.
	 * Essa correspondência deve basear-se no(s) critério(s) empregado(s) na
	 * implementação do
	 * método de comparação do item. Se o item não for localizado na pilha, esse
	 * método deve
	 * lançar uma exceção
	 */
	public int obterNumItensAFrente(E item) throws Exception {
		Celula<E> aux = topo;
		int count = 0;
		while (aux != fundo) {
			if (aux.getItem().equals(item)) {
				return count;
			}
			count++;
			aux = aux.getProximo();
		}
		throw new Exception("Item não encontrado na pilha.");
	}

	/*
	 * Implemente a função public pilha<E> copiar(), capaz de criar e retornar uma
	 * cópia exata da pilha. Acrescente à assinatura desse método as exceções que
	 * forem
	 * necessárias.
	 */
	public Pilha<E> copiar() {
		if (vazia()) {
			throw new NoSuchElementException("A pilha está vazia, não é possível copiar.");
		}
		Pilha<E> copia = new Pilha<>();
		Celula<E> aux = topo;
		while (aux != fundo) {
			copia.empilhar(aux.getItem());
			aux = aux.getProximo();
		}
		copia.inverter();
		return copia;
	}

	/*
	 * QUESTÃO EXTRA: Implemente o método public int obterNumItensAtras (E item),
	 * que retorna o número de itens que estão localizados, na pilha, atrás do item
	 * correspondente àquele que foi passado como parâmetro para esse método.
	 * Essa correspondência deve basear-se no(s) critério(s) empregado(s) na
	 * implementação do
	 * método de comparação do item. Se o item não for localizado na pilha, esse
	 * método deve
	 * lançar uma exceção.
	 */
	public int obterNumItensAtras(E item) {
		Celula<E> aux = topo;
		boolean encontrado = false;

		while (aux != fundo && !encontrado) {
			if (aux.getItem().equals(item)) {
				encontrado = true;
			}
			aux = aux.getProximo();
		}

		if (!encontrado) {
			throw new NoSuchElementException("Item não encontrado na pilha.");
		}
		int atras = 0;
		while (aux != fundo) {
			atras++;
			aux = aux.getProximo();
		}
		return atras;
	}

	/*
	 * Implemente o método public Pilha<E> subPilha(int numItens), que retorna uma
	 * subpilha contendo os primeiros numItens itens da pilha original. Se a pilha
	 * não contiver numItens itens, esse método deve lançar uma exceção.
	 */
public Pilha<E> subPilha(int numItens) {
		if (numItens < 0) {
			throw new IllegalArgumentException("Número de itens não pode ser negativo.");
		}
		if (numItens > obterNumeroItens()) {
			throw new NoSuchElementException("A pilha não contém itens suficientes para criar uma subpilha.");
		}

		Pilha<E> subPilha = new Pilha<>();
		Celula<E> aux = topo;
		int count = 0;

		while (aux != fundo && count < numItens) {
			subPilha.empilhar(aux.getItem());
			aux = aux.getProximo();
			count++;
		}
		subPilha.inverter(); 

		return subPilha;
	}

	public static void main(String[] args) {
		Pilha<Integer> pilha1 = new Pilha<>();
		pilha1.empilhar(1);
		pilha1.empilhar(2);
		pilha1.empilhar(3);

		Pilha<Integer> pilha2 = new Pilha<>();
		pilha2.empilhar(4);
		pilha2.empilhar(5);
		pilha2.empilhar(6);

		System.out.println("\n== Pilha 1 antes da concatenação ==");
		pilha1.imprimir();
		System.out.println("\n== Pilha 2 antes da concatenação ==");
		pilha2.imprimir();
		pilha1.concatenar(pilha2);
		System.out.println("\n== Pilha 1 após a concatenação com Pilha 2 ==");
		pilha1.imprimir();

		System.out.println("\n== Número de itens na Pilha 1 ==");
		System.out.println("Número de itens na Pilha 1: " + pilha1.obterNumeroItens());

		System.out.println("\n== Invertendo Pilha 1 ==");
		pilha1.inverter();
		pilha1.imprimir();

		System.out.println("\n== Verificando se 'arara' é um palíndromo ==");
		System.out.println("É palíndromo? " + pilha1.ehPalindromo("arara"));
		System.out.println("\n== Verificando se 'Socorram-me em Marrocos' é um palíndromo ==");
		System.out.println("É palíndromo? " + pilha1.ehPalindromo("Socorram-me em Marrocos"));

		System.out.println("\n== Verificando se o número 2 existe na Pilha 1 ==");
		System.out.println("O número 2 existe na Pilha 1? " + pilha1.verificarExistencia(2));
		System.out.println("\n== Verificando se o número 7 existe na Pilha 1 ==");
		System.out.println("O número 7 existe na Pilha 1? " + pilha1.verificarExistencia(7));

		try {
			System.out.println("\n== Número de itens a frente do número 2 na Pilha 1 ==");
			System.out.println("Número de itens a frente do número 2: " + pilha1.obterNumItensAFrente(2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Pilha<Integer> copiaPilha = pilha1.copiar();
		System.out.println("\n== Cópia da Pilha 1 ==");
		copiaPilha.imprimir();

		try {
			System.out.println("\n== Número de itens atrás do número 2 na Pilha 1 ==");
			System.out.println("Número de itens atrás do número 2: " + pilha1.obterNumItensAtras(2));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n== Subpilha com 3 itens da Pilha 1 ==");
			Pilha<Integer> subPilha = pilha1.subPilha(3);
			subPilha.imprimir();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void imprimir() {
		Celula<E> aux = topo;
		while (aux != fundo) {
			E elemento = aux.getItem();
			System.out.print(elemento + " ");
			aux = aux.getProximo();
		}
		System.out.println();
	}

}