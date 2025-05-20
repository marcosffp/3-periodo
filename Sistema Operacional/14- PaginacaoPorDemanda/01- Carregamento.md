## 🧩 Quando uma página é carregada na memória?

Existem **quatro formas principais**:

---

### 🟢 1. **No início do processo**

* Carrega **todas** as páginas logo no começo.
* Nesse caso, o **espaço de endereço virtual (total que o processo pode usar)** precisa **caber totalmente na memória RAM**.

🧠 *Limitação:* só funciona bem para programas pequenos, pois não aproveita os benefícios da paginação sob demanda.

---

### 🟡 2. **Overlays** (método antigo)

* O **programador** decide quais partes (páginas) do programa devem ser carregadas ou removidas manualmente.
* Isso permite que o programa tenha **mais dados do que caberia na RAM**, mas...

⚠️ **Problemas**:

* Difícil de implementar.
* Muito propenso a **erros humanos**.

🧠 *Exemplo prático:* como tentar manualmente escolher quais livros você leva na mochila dependendo da aula — fácil esquecer algum.

---

### 🔵 3. **Paginação sob demanda (on-demand paging)**

> 🎯 *A forma mais usada hoje em dia.*

Existem **duas variações**:

#### 🔹 a) **Aviso do processo (teórico, pouco usado)**

O processo informa ao sistema operacional **antes de usar** uma página e **depois que terminou de usar**.

* Isso exige que o **programador colabore**, então é raro em sistemas reais.

---

#### 🔹 b) **Paginação sob demanda real (automática)**

> O **SO carrega a página automaticamente** na **primeira vez que ela for usada (referenciada)**.

🧠 *Analogia:* Você só traz um livro da estante quando começa a estudar aquele assunto.

### O que acontece nessa hora?

1. O processo tenta acessar a página.
2. A página **não está na RAM**.
3. Ocorre um **page fault** (interrupção).
4. O sistema:

   * Verifica se o endereço é válido.
   * Escolhe uma página para remover da memória (substituição).
   * Começa a carregar a nova página do disco.
   * Enquanto isso, **o processo é pausado** e a CPU pode ser usada por outro.
   * Quando o carregamento termina, o SO:

     * Atualiza a tabela de páginas (bit de validade = 1).
     * Retoma o processo de onde parou.

---

### 🔴 4. **Pré-paginação (pre-paging)**

> O sistema operacional tenta **adivinhar** quais páginas serão necessárias **no futuro** e as carrega **antes de serem usadas**.

🧠 *Analogia:* Você coloca na mochila os livros que **acha que vai usar**.

✅ Se acertar:

* O processo roda mais rápido (menos page faults).
  ❌ Se errar:
* Pode tirar páginas importantes da memória e causar mais atrasos.
* É difícil acertar por causa das **bifurcações (ifs, loops, etc.) no código**.

---

## 🧠 Por que o programa completo precisa estar no disco?

Mesmo que nem tudo vá pra RAM de uma vez, **todo o programa (ou quase todo)** precisa estar no disco. Isso porque:

* Quando o SO vê que uma página está faltando na RAM (bit de validade = 0), ele precisa saber **onde buscá-la**.
* Assim, o disco funciona como **a fonte oficial** de onde as páginas vêm.

---

## 🔄 O que acontece em um Page Fault (resumo passo a passo)

1. Instrução tenta acessar uma página que não está na RAM.
2. Interrupção: page fault.
3. SO verifica se o endereço é válido.
4. Se for:

   * Escolhe uma página para remover (FIFO, LRU etc.).
   * Invalida a antiga na tabela.
   * Começa a carregar a nova do disco.
   * Muda para outro processo enquanto carrega.
   * Quando termina, recebe outra interrupção avisando.
   * Atualiza a tabela.
   * Retoma o processo original.

🔁 *Por que trocar de processo?*
Enquanto espera a página vir do disco, a CPU ficaria **ociosa**. Trocar para outro processo mantém o sistema **eficiente**.

---

