## 🧹 O que é **Compactação**?

É uma técnica usada para **resolver o problema da fragmentação externa**.

A ideia é **mover os processos na memória para juntar os espaços livres em um único bloco grande e contíguo**, permitindo que novos processos sejam alocados com mais facilidade.

---

## 🧠 Explicando cada pergunta do slide:

---

### 📦 **“O QUANTO DE MEMÓRIA É MOVIDO?”**

- Depende da quantidade de processos e fragmentos existentes.
- O sistema precisa **copiar processos inteiros de um local da memória para outro**.
- Quanto mais processos houver e mais espalhados eles estiverem, **mais memória será movida** → isso pode ser **caro e demorado**.

---

### 📏 **“QUAL O TAMANHO MÁXIMO DO BLOCO QUE É CRIADO?”**

- A compactação tem como objetivo **criar o maior bloco livre possível**.
- Esse bloco resultante é o **somatório dos espaços vazios que estavam fragmentados**.
- Isso melhora a chance de alocar um processo grande de uma só vez.

---

### ❓ **“… HÁ OUTRA ALTERNATIVA?”**

Sim! Uma alternativa à compactação é usar **paginação ou segmentação**, que permitem:

- Dividir a memória em partes menores (páginas ou segmentos).
- Evitar a necessidade de alocar memória de forma contígua.
- **Eliminar ou reduzir drasticamente a fragmentação externa**, sem precisar mover processos.

---

### 🔄 **“O PROCESSO QUE FAZ I/O, PRECISA FICAR NA MEMÓRIA?”**

- Sim. Processos que estão executando **operações de entrada/saída (I/O)** geralmente **não podem ser movidos**.
- Isso acontece porque eles estão esperando resposta de um dispositivo externo (ex: disco, impressora), e movê-los pode **quebrar a referência de memória** que esses dispositivos usam.

---

### 🕒 **“QUANDO COMPACTAR?”**

- Compactar só deve ser feito quando **realmente necessário**, porque é **uma operação cara** (em tempo e recursos).
- Um momento típico é quando:
  - Um **processo grande está esperando para ser carregado**, mas **não há espaço contíguo suficiente**, mesmo que haja espaço total livre.
  - Ou quando um processo retorna do **swap** (memória secundária) e **não cabe mais no mesmo lugar**.

---

## 🧠 Resumo:

| Pergunta                    | Resposta Curta                                                                 |
|----------------------------|---------------------------------------------------------------------------------|
| Quanto é movido?           | Depende da quantidade e posição dos processos (pode ser muita memória).         |
| Tamanho do bloco criado?   | É o total de espaço livre somado, formando um **único bloco contíguo**.         |
| Há alternativa?            | Sim! **Paginação** e **segmentação** evitam a necessidade de compactar.        |
| Processo com I/O pode sair?| **Não**, pois está ligado a dispositivos externos e pode causar problemas.     |
| Quando compactar?          | **Somente quando necessário**, especialmente ao **retirar processos do swap**. |

---

