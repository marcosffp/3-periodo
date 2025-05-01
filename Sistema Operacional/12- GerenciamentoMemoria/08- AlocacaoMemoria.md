## 🧩 **Alocação Contígua de Memória** — o que é?

É uma forma simples de **gerenciar memória**, onde **cada processo precisa ocupar um espaço contínuo na memória**. Ou seja, o processo só pode ser colocado em um **bloco de memória livre que seja todo seguido (sem interrupções)**.

---

### 🧠 Como o SO gerencia isso?

O **Sistema Operacional (SO)** precisa:

1. **Controlar quais pedaços da memória estão livres** e quais estão ocupados.
2. Quando um **novo processo chega**, ele procura um **fragmento (espaço livre)** onde o processo possa caber.

---

## 📋 **Fragmentos**

- São **pedaços livres de memória**.
- Com o tempo, os processos entram e saem da memória, e isso vai deixando **espaços vazios de tamanhos variados** espalhados pela memória → isso é chamado de **fragmentação externa**.

---

## 🧠 Como o SO escolhe em qual fragmento colocar um processo?

Usa **políticas de alocação**, ou seja, **estratégias para decidir onde colocar o processo**. As 3 mais comuns são:

---

### 🥇 **First-Fit (Primeiro que Serve)**

- A memória é percorrida do início até achar o **primeiro fragmento onde o processo cabe**.
- A busca pode continuar do ponto onde parou na última vez (para economizar tempo).

🟢 **Vantagens**: rápido, simples.
🔴 **Desvantagens**: pode deixar fragmentos pequenos inúteis espalhados.

---

### 🧠 **Best-Fit (Melhor Encaixe)**

- O SO procura **o menor fragmento que ainda seja grande o suficiente** para o processo.
- Pode exigir percorrer a memória inteira (ou manter uma lista ordenada por tamanho).

🟢 **Vantagens**: tenta **usar o espaço com o mínimo desperdício**.
🔴 **Desvantagens**: mais lento, pode gerar muitos **fragmentos muito pequenos**.

---

### 💥 **Worst-Fit (Pior Encaixe)**

- O processo é colocado **no maior fragmento disponível**.
- A ideia é "sobrar espaço" para outros processos depois.

🟢 **Vantagens**: evita fragmentos minúsculos.
🔴 **Desvantagens**: geralmente **desperdiça mais memória** e **é menos eficiente**.

---

## 📊 Qual política é melhor?

- Em simulações, o **First-Fit e o Best-Fit** geralmente têm **melhor aproveitamento de memória** do que o Worst-Fit.
- O **First-Fit costuma ser o mais rápido**, por exigir menos procura.

---

### 🧠 Analogia:

Imagine que a memória é um **estacionamento** e cada processo é um **carro**:

- **First-Fit**: você para no **primeiro lugar disponível** onde seu carro cabe.
- **Best-Fit**: você procura o **menor espaço que caiba exatamente seu carro** (pode demorar).
- **Worst-Fit**: você procura a **vaga maior de todas**, mesmo que sobre muito espaço.

---
