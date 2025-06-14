# 🌳 RESUMO sobre o `balancear(...)` em Árvores AVL — Explicação Visual, Técnica e Didática

## 🧠 Como pensar nisso?

Imagine que uma **árvore AVL** é como uma **balança** de dois pratos (esquerda e direita).

Sempre que você **insere ou remove um nó**, ela pode **ficar torta**.

👉 O método `balancear` verifica se está torta e, se estiver, **aplica rotações** para equilibrar.

---

## 🔧 O que o método faz, passo a passo?

### 1️⃣ Só entra se a árvore existir

```java
if (raizArvore != null) {
```

Se a raiz (ou subárvore) for nula, não tem o que balancear.

---

### 2️⃣ Calcula o **fator de balanceamento**

```java
fatorBalanceamento = raizArvore.getFatorBalanceamento();
```

Esse valor é:
**altura(esquerda) - altura(direita)**

| Valor do Fator (`FB`) | Significado                 |
| --------------------- | --------------------------- |
| `0`, `+1`, `-1`       | A árvore está equilibrada ✅ |
| `+2`                  | Torta para a ESQUERDA ❌     |
| `-2`                  | Torta para a DIREITA ❌      |

---

## 🔁 CASO 1 — Desbalanceada para a **esquerda** (`FB == +2`)

```java
if (fatorBalanceamento == 2) {
    fatorBalanceamentoFilho = raizArvore.getEsquerda().getFatorBalanceamento();

    if (fatorBalanceamentoFilho == -1)
        raizArvore.setEsquerda(rotacionarEsquerda(raizArvore.getEsquerda())); // Corrige o joelho torto (filho)

    raizArvore = rotacionarDireita(raizArvore); // Corrige a raiz
}
```

### 🧠 Metáfora:

Se o lado esquerdo está **muito pesado**, gire para a **direita**.
Mas se tiver um “**joelho torto**” (filho inclinado ao lado oposto), **corrija o filho primeiro**.

### 🌳 Exemplos:

**🔄 Simples à Direita:**

ANTES:

```
    10
   /
  5
 /
2
```

DEPOIS:

```
    5
   / \
  2  10
```

**🔁 Dupla (Esquerda-Direita):**

ANTES:

```
    10
   /
  5
   \
    6
```

1. Gira 5 para a esquerda:

```
    10
   /
  6
 /
5
```

2. Gira 10 para a direita:

```
    6
   / \
  5  10
```

---

## 🔁 CASO 2 — Desbalanceada para a **direita** (`FB == -2`)

```java
else if (fatorBalanceamento == -2) {
    fatorBalanceamentoFilho = raizArvore.getDireita().getFatorBalanceamento();

    if (fatorBalanceamentoFilho == 1)
        raizArvore.setDireita(rotacionarDireita(raizArvore.getDireita())); // Corrige o joelho torto (filho)

    raizArvore = rotacionarEsquerda(raizArvore); // Corrige a raiz
}
```

### 🧠 Metáfora:

Se o lado direito está **muito pesado**, gire para a **esquerda**.
Mas se o filho estiver “torto para o outro lado”, **corrija ele primeiro**.

### 🌳 Exemplos:

**🔄 Simples à Esquerda:**

ANTES:

```
  2
   \
    5
     \
     10
```

DEPOIS:

```
    5
   / \
  2  10
```

**🔁 Dupla (Direita-Esquerda):**

ANTES:

```
  2
   \
    5
   /
  4
```

1. Gira 5 para a direita:

```
  2
   \
    4
     \
      5
```

2. Gira 2 para a esquerda:

```
    4
   / \
  2   5
```

---

## ✅ CASO 3 — Se já estiver balanceada

```java
else
    raizArvore.setAltura();
```

> Nenhuma rotação é feita. Apenas atualiza a **altura correta** da árvore.

---

## 🔚 Finalização do método

```java
return raizArvore;
```

> Retorna a nova raiz da subárvore, com ou sem rotação aplicada.

---

# ⚙️ Como funcionam as rotações?

### 🔸 `rotacionarDireita(p)`

```java
No<K, V> u = p.getEsquerda();
No<K, V> temp = u.getDireita();

p.setEsquerda(temp);
u.setDireita(p);
p.setAltura();
u.setAltura();
return u;
```

> O filho da esquerda **sobe**, o pai **desce para a direita**.

---

### 🔸 `rotacionarEsquerda(p)`

```java
No<K, V> z = p.getDireita();
No<K, V> temp = z.getEsquerda();

p.setDireita(temp);
z.setEsquerda(p);
p.setAltura();
z.setAltura();
return z;
```

> O filho da direita **sobe**, o pai **desce para a esquerda**.

---

# 📊 TABELA DE DECISÃO — Qual rotação usar?

| Situação da árvore | Condição no código           | Tipo de rotação                                   |
| ------------------ | ---------------------------- | ------------------------------------------------- |
| Simples à direita  | `FB == +2 && filho.FB >= 0`  | `rotacionarDireita(raiz)`                         |
| Dupla (Esq-Dir)    | `FB == +2 && filho.FB == -1` | `rotacionarEsquerda(filho) + rotacionarDireita()` |
| Simples à esquerda | `FB == -2 && filho.FB <= 0`  | `rotacionarEsquerda(raiz)`                        |
| Dupla (Dir-Esq)    | `FB == -2 && filho.FB == +1` | `rotacionarDireita(filho) + rotacionarEsquerda()` |
| Árvore balanceada  | `-1 ≤ FB ≤ 1`                | Apenas `setAltura()`                              |

---

## 💡 Dica visual:

* 🌲 **Dois nós enfileirados**? → Rotação simples
* 🦵 **"Joelho torto"** (forma de L)? → Rotação dupla

---

