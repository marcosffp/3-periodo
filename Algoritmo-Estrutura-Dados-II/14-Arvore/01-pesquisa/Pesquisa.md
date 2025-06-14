# 🔍 RESUMO FINAL — Pesquisa Sequencial vs Pesquisa Binária (com Custo de Ordenação)

## ✅ Pesquisa Sequencial

### 📌 Como funciona:

Percorre os elementos **um por um**, do início ao fim, até encontrar o procurado.

### 🧠 Código:

```java
public E pesquisar(E procurado) {
    for (int i = 0; i < this.ultimo; i++)
        if (lista[i].equals(procurado))
            return lista[i];
    throw new NoSuchElementException("Item não encontrado!");
}
```

### 📊 Complexidade:

| Caso        | Custo  |
| ----------- | ------ |
| Melhor caso | O(1)   |
| Médio caso  | O(n/2) |
| Pior caso   | O(n)   |

### ✅ Vantagens:

* Funciona com **qualquer lista**, mesmo **desordenada**
* Ideal quando os dados mudam o tempo todo

### ❌ Desvantagens:

* Ineficiente para listas muito grandes se os dados estiverem ordenados

---

## ⚡ Pesquisa Binária

### 📌 Como funciona:

Divide a lista ao meio, compara com o elemento do meio e repete o processo **somente na metade relevante**.

### ❗ Requisito:

> ⚠️ **A lista precisa estar ordenada**, senão o resultado será incorreto!

### 🧠 Código Recursivo:

```java
public E pesquisar(E procurado) {
    return pesquisar(0, this.ultimo - 1, procurado);
}

private E pesquisar(int inicio, int fim, E procurado) {
    if (inicio > fim)
        throw new NoSuchElementException("Item não encontrado!");

    int meio = (inicio + fim) / 2;
    int comparacao = procurado.compareTo(lista[meio]);

    if (comparacao == 0)
        return lista[meio];
    else if (comparacao > 0)
        return pesquisar(meio + 1, fim, procurado);
    else
        return pesquisar(inicio, meio - 1, procurado);
}
```

### 📊 Complexidade (lista ordenada):

| Caso           | Custo    |
| -------------- | -------- |
| Todos os casos | O(log n) |

---

## 💸 O Custo de Ordenar

### 🧠 Exemplo de ordenação com QuickSort:

```java
public void ordenar() {
    quicksort(0, this.ultimo - 1);
}
```

| Situação   | Custo      |
| ---------- | ---------- |
| Caso médio | O(n log n) |
| Pior caso  | O(n²)      |

🔎 **Resumo prático**:

> Se você **ordenar toda vez antes de pesquisar**, o custo total será:
> 👉 `O(n log n)` (ordenar) + `O(log n)` (pesquisar) = **O(n log n)**
> ❗ Às vezes é **mais lento que uma busca sequencial direta O(n)**

---

## 🧠 Quando Usar Cada Uma?

| Situação                       | Melhor Abordagem             |
| ------------------------------ | ---------------------------- |
| Lista **desordenada**          | Sequencial                   |
| Lista **ordenada previamente** | Binária                      |
| Lista **grande e estática**    | Binária (ordenar 1x)         |
| Lista **com muitas mudanças**  | Sequencial (evita reordenar) |

---

