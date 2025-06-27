# 🔄 RESUMO — Caminhamentos em Árvores Binárias de Busca (ABB)

## ✅ O que é Caminhamento?

### 📌 Definição:

Caminhar pela ABB significa **visitar todos os nós** seguindo uma **ordem específica**.
Existem quatro tipos principais de caminhamento:

| Tipo          | Ordem de visita                                             | Uso típico                      |
| ------------- | ----------------------------------------------------------- | ------------------------------- |
| **Pré-ordem** | Raiz → Esquerda → Direita                                   | Serialização da árvore          |
| **Em-ordem**  | Esquerda → Raiz → Direita                                   | Ordenação crescente dos dados   |
| **Pós-ordem** | Esquerda → Direita → Raiz                                   | Destruição/liberação de memória |
| **Por nível** | Visita por camadas (nível por nível da esquerda p/ direita) | Impressão em formato "largura"  |

---

## 🧭 1. Caminhamento **Pré-Ordem**

### 🔁 Ordem: **Raiz → Esquerda → Direita**

```java
public String caminhamentoPreOrdem() {
  if (vazia()) throw new IllegalStateException("A árvore está vazia");
  return caminhamentoPreOrdem(raiz);
}

private String caminhamentoPreOrdem(No<K, V> raizArvore) {
  if (raizArvore == null) return "";
  return raizArvore.getItem().toString() + " " +
         caminhamentoPreOrdem(raizArvore.getEsquerda()) +
         caminhamentoPreOrdem(raizArvore.getDireita());
}
```

### 🧪 Exemplo (ABB):

```text
       16
      /  \
     8    23
    / \   / \
   4  11 19 27
```

### ▶️ Impressão:

`16 8 4 11 23 19 27`

---

## 🧭 2. Caminhamento **Em-Ordem**

### 🔁 Ordem: **Esquerda → Raiz → Direita**

```java
public String caminhamentoEmOrdem() {
  if (vazia()) throw new IllegalStateException("A árvore está vazia");
  return caminhamentoEmOrdem(raiz);
}

private String caminhamentoEmOrdem(No<K, V> raizArvore) {
  if (raizArvore == null) return "";
  return caminhamentoEmOrdem(raizArvore.getEsquerda()) +
         raizArvore.getItem().toString() + " " +
         caminhamentoEmOrdem(raizArvore.getDireita());
}
```

### 🧪 Exemplo (ABB):

```text
       16
      /  \
     8    23
    / \   / \
   4  11 19 27
```

### ▶️ Impressão (ordenada):

`4 8 11 16 19 23 27`

---

## 🧭 3. Caminhamento **Pós-Ordem**

### 🔁 Ordem: **Esquerda → Direita → Raiz**

```java
public String caminhamentoPosOrdem() {
  if (vazia()) throw new IllegalStateException("A árvore está vazia");
  return caminhamentoPosOrdem(raiz);
}

private String caminhamentoPosOrdem(No<K, V> raizArvore) {
  if (raizArvore == null) return "";
  return caminhamentoPosOrdem(raizArvore.getEsquerda()) +
         caminhamentoPosOrdem(raizArvore.getDireita()) +
         raizArvore.getItem().toString() + " ";
}
```

### 🧪 Exemplo (ABB):

```text
       16
      /  \
     8    23
    / \   / \
   4  11 19 27
```

### ▶️ Impressão:

`4 11 8 19 27 23 16`

---

## 🧭 4. Caminhamento **Por Nível** (ou Largura)

### 🔁 Ordem: Visita **nível a nível**, da esquerda para a direita

```java
public String caminhamentoEmNivel() {
  if (vazia()) throw new IllegalStateException("A árvore está vazia");
  return caminhamentoEmNivel(raiz);
}

private String caminhamentoEmNivel(No<K, V> raizArvore) {
  Lista<No<K, V>> fila = new Lista<>();
  String caminho = "";
  fila.inserir(raizArvore, fila.getTamanho());

  while (!fila.vazia()) {
    No<K, V> atual = fila.remover(0);
    caminho += atual.getItem().toString() + " ";

    if (atual.getEsquerda() != null)
      fila.inserir(atual.getEsquerda(), fila.getTamanho());

    if (atual.getDireita() != null)
      fila.inserir(atual.getDireita(), fila.getTamanho());
  }

  return caminho;
}
```

### 🧪 Exemplo (ABB):

```text
       16
      /  \
     8    23
    / \   / \
   4  11 19 27
```

### ▶️ Impressão:

`16 8 23 4 11 19 27`

---

## 📚 Comparativo dos Caminhamentos

| Caminhamento  | Ordem de Visita              | Saída no exemplo     |
| ------------- | ---------------------------- | -------------------- |
| **Pré-Ordem** | Raiz → Esq. → Dir.           | `16 8 4 11 23 19 27` |
| **Em-Ordem**  | Esq. → Raiz → Dir.           | `4 8 11 16 19 23 27` |
| **Pós-Ordem** | Esq. → Dir. → Raiz           | `4 11 8 19 27 23 16` |
| **Em Nível**  | Nível a nível (esq. p/ dir.) | `16 8 23 4 11 19 27` |

---

## ✅ Dicas de Uso

| Situação                                        | Caminhamento recomendado |
| ----------------------------------------------- | ------------------------ |
| Exibir elementos **ordenados**                  | ✔️ Em-Ordem              |
| **Salvar ou clonar** árvore inteira             | ✔️ Pré-Ordem             |
| **Destruir** a árvore (liberar memória pós uso) | ✔️ Pós-Ordem             |
| **Visualizar hierarquia** por camadas (níveis)  | ✔️ Em Nível (BFS)        |

---

