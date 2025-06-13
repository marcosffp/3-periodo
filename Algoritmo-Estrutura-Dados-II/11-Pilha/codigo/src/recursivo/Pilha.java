package recursivo;

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
		concatenar(pilha, pilha.topo);
	}

	private void concatenar(Pilha<E> pilha, Celula<E> celula) {
		if (celula == pilha.fundo) {
			return;
		}
		concatenar(pilha, celula.getProximo());
		this.empilhar(celula.getItem());
	}

	/*
	 * Implemente a função public int obterNumeroItens(), que retorna o número de
	 * itens da pilha.
	 */
	public int obterNumeroItens() {
		return obterNumeroItens(topo);
	}


	private int obterNumeroItens(Celula<E> aux) {
		if (aux == fundo) {
			return 0;
		} else {
			return 1 + obterNumeroItens(aux.getProximo());
		}
	}

	/*
	 * Implemente o método public void inverter(), capaz de inverter a pilha.
	 */
	public void inverter() {
		Pilha<E> pilhaAux = new Pilha<>();
		inverter(topo, pilhaAux);
		topo = pilhaAux.topo;
		fundo = pilhaAux.fundo;
	}

	private void inverter(Celula<E> aux, Pilha<E> pilhaAux) {
		if (aux == fundo) {
			return;
		}
		pilhaAux.empilhar(aux.getItem());
		inverter(aux.getProximo(), pilhaAux);
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
		return ehPalindromo(pilha, palavra,0);
	}

	private boolean ehPalindromo(Pilha<Character> pilha, String palavra, int i) {
		if (pilha.vazia()) {
			return true;
		} else {
			if (pilha.desempilhar() == palavra.charAt(i)) {
				return ehPalindromo(pilha, palavra, i + 1);
			} else {
				return false;
			}
		}
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
		return verificarExistencia(topo, item);
	}

	private boolean verificarExistencia(Celula<E> aux, E item) {
		if (aux == fundo) {
			return false;
		} else {
			if (aux.getItem().equals(item)) {
				return true;
			}
			return verificarExistencia(aux.getProximo(), item);
		}
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
		return obterNumItensAFrente(topo, item);
	}

	private int obterNumItensAFrente(Celula<E> aux, E item) {
		if (aux == fundo) {
			throw new NoSuchElementException("Item não encontrado na pilha.");
		} else {
			if (!aux.getItem().equals(item)) {
				return 1 + obterNumItensAFrente(aux.getProximo(), item);
			} else {
				return 0;
			}
		}
	}

	/*
	 * Implemente a função public Pilha<E> copiar(), capaz de criar e retornar uma
	 * cópia exata da pilha. Acrescente à assinatura desse método as exceções que
	 * forem
	 * necessárias.
	 */
	public Pilha<E> copiar() {
		if (vazia()) {
			throw new NoSuchElementException("A pilha está vazia, não é possível copiar.");
		}
		Pilha<E> copia = new Pilha<>();
		copiar(topo, copia);
		return copia;
	}

	private void copiar(Celula<E> aux, Pilha<E> copia) {
		if (aux == fundo) {
			return;
		}
		copiar(aux.getProximo(), copia);
		copia.empilhar(aux.getItem());
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
		return obterNumItensAtras(this.topo, item, false);
	}

	private int obterNumItensAtras(Celula<E> aux, E item, boolean achou) {
		if (aux == fundo) {
			if (!achou) {
				throw new NoSuchElementException("Item não encontrado na pilha.");
			}
			return 0;
		}
		if (!achou) {
			if (aux.getItem().equals(item)) {
				return obterNumItensAtras(aux.getProximo(), item, true);
			} else {
				return obterNumItensAtras(aux.getProximo(), item, false);
			}
		} else {
			return 1 + obterNumItensAtras(aux.getProximo(), item, true);
		}
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
		subPilha = subPilhaRecursiva(topo, subPilha, numItens, 0);
		subPilha.inverter();
		return subPilha;
	}
	private Pilha<E> subPilhaRecursiva(Celula<E> aux, Pilha<E> subPilha, int numItens, int count) {
		if (aux == fundo || count == numItens) {
			return subPilha;
		}
		subPilha.empilhar(aux.getItem());
		return subPilhaRecursiva(aux.getProximo(), subPilha, numItens, count + 1);
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