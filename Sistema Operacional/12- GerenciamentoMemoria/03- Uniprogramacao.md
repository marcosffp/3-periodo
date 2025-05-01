### 📌 **O que é Uniprogramação?**

É a forma **mais simples** de gerenciamento de memória em sistemas operacionais. Nesse modelo, **apenas um processo é executado por vez**. Não existe multitarefa real.

---

### 🧠 Agora linha por linha com analogias:

#### ● *"O SO obtém uma parte fixa da memória (em DOS, são os endereços mais altos da memória)."*

**Analogia:** pense num prédio onde o zelador (o sistema operacional) mora sempre no último andar, que é reservado só para ele.

Ou seja, uma parte **fixa da memória é sempre reservada** para o sistema operacional. O restante é o "playground" dos programas.

---

#### ● *"1 processo é executado por vez."*

Não existe concorrência de processos aqui. Só **um processo na memória**. Quando outro quiser rodar, o primeiro sai completamente e o segundo entra.

---

#### ● *"O processo é sempre carregado começando no endereço 0."*

Esse processo sempre começa do "térreo", ou seja, o início da memória disponível para ele é o **endereço 0**.

---

#### ● *"O processo é executado em uma seção contígua da memória."*

A memória usada pelo processo é **um bloco contínuo**, sem “buracos” no meio. Tipo um pedaço único de terreno, sem dividir em partes espalhadas.

---

#### ● *"O compilador pode gerar endereços físicos."*

Como o processo **sempre começa no mesmo lugar**, o compilador já pode colocar os endereços reais da memória no código, sem preocupação com relocação.

---

#### ● *"Endereço máximo = [Tamanho da Memória] - [Tamanho do SO]"*

Como o SO ocupa uma parte fixa da memória, o processo só pode usar até o limite anterior a essa área.

---

#### ● *"O SO é protegido do processo: o SO verifica os endereços usados pelo processo."*

O sistema operacional precisa se proteger. Mesmo que só haja um processo, ele **verifica se o processo não está tentando acessar** a parte reservada para ele (o SO). Isso evita falhas ou acessos indevidos.

---

### ⚠️ Observação importante:
#### *"Simples, mas não permite sobreposição de I/O e computação."*

Quando o processo está esperando uma **operação de entrada/saída** (como leitura de disco), **a CPU fica ociosa**. Ou seja: se o processo está esperando o HD, ninguém mais trabalha. Desperdício de tempo e recursos!

---

### 🔍 Resumo visual

| Característica               | Uniprogramação                         |
|-----------------------------|----------------------------------------|
| N° de processos             | 1 por vez                              |
| Uso da memória             | Bloco contínuo                         |
| Início do processo         | Endereço 0                             |
| SO                         | Fica no topo da memória                |
| Interação SO-processo      | SO monitora o processo                 |
| Eficiência                 | Baixa, pois não há paralelismo         |

---
