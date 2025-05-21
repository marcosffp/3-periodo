## 🧩 1. ESPAÇO DE SWAP (TROCA)

### ❓ O que é o "swap"?

**Swap** é uma parte do **disco rígido (HD/SSD)** reservada para **armazenar páginas da memória que foram removidas** da RAM.

---

### 🧠 Por que isso existe?

A memória RAM é limitada. Quando ela enche e o sistema precisa carregar uma nova página, ele precisa **escolher uma página para remover da RAM**.

Agora vem o ponto chave:

---

### 📌 Existem dois tipos de páginas:

1. **Código** (ex: instruções do programa)

   * Pode **simplesmente ser descartado**.
   * Se precisar de novo, é só recarregar do **arquivo original no disco** (o executável).

2. **Dados** (ex: variáveis, planilhas abertas, conteúdo digitado)

   * **Não pode ser descartado diretamente**, porque pode ter sido **modificado em tempo de execução**.
   * Então, precisa ser **salvo no espaço de swap**.

---

### 🎯 Swap é o “banco de reserva” da RAM

🧠 *Analogia:*
Você tem uma mochila (RAM) com espaço limitado. Se precisar colocar algo novo, tira um caderno antigo. Mas:

* Se o caderno for de exercícios em branco (código), pode deixar em casa e pegar outro igual depois.
* Se tiver anotações suas (dados), precisa guardá-lo em algum lugar antes (swap), senão perde tudo.

---

### 🗺 Onde uma página pode estar?

Uma página pode estar em:

* 📄 O sistema de arquivos (original do programa)
* 🧠 A memória física (RAM)
* 💽 O espaço de swap (dados salvos temporariamente)

👉 Por isso, a **tabela de páginas** precisa ser mais inteligente, para saber exatamente **onde está cada página.**

---

## 🧮 2. DESEMPENHO NA PAGINAÇÃO POR DEMANDA

### 🧠 Localidade

O desempenho da paginação depende do **princípio da localidade**:

* **Temporal**: se você acessou uma página, vai acessá-la de novo em breve.
* **Espacial**: se acessou uma página, vai acessar **as próximas páginas** em breve.

🔁 Isso permite manter na RAM as páginas “quentes” e remover as “frias”.

---

### ⚠️ Problema: e se o programa acessar uma nova página a cada instrução?

> Isso geraria um **page fault por instrução**.
> 👉 Isso deixaria o sistema **muito lento**.

---

### 📉 Cálculo do desempenho

Fórmula do **tempo de acesso efetivo**:

$$
T_{efetivo} = (1 - p) \cdot ma + p \cdot pf
$$

Onde:

* `p` = probabilidade de page fault
* `ma` = tempo de acesso à memória (ex: 200 ns)
* `pf` = tempo de page fault (ex: 25 ms = 25.000.000 ns)

---

### 🧪 Exemplo:

> `ma = 200 ns`
> `pf = 25.000.000 ns`
> Queremos que `Tefetivo` seja **no máximo 10% maior que 200 ns**, ou seja:

$$
T_{efetivo} = 220 \text{ ns}
$$

Montando a equação:

$$
220 = (1 - p) \cdot 200 + p \cdot 25.000.000
$$

Resolvendo:

$$
220 = 200 - 200p + 25.000.000p  
\Rightarrow 20 = p (25.000.000 - 200)  
\Rightarrow p = \frac{20}{24.999.800} \approx 8 \times 10^{-7}
$$

🔴 **Ou seja**: a taxa de page faults tem que ser **menor que 0,00008%**!
Mesmo um pequeno aumento de `p` degrada muito o desempenho.

---

## ✅ Conclusão

* O **swap** serve pra guardar **dados importantes** quando a RAM precisa liberar espaço.
* Páginas com **código** podem ser descartadas sem salvar.
* O **desempenho** depende de **minimizar page faults**, aproveitando bem o **princípio da localidade**.
* Mesmo **poucos page faults** já impactam muito o tempo de acesso efetivo.


