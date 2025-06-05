### ⚙️ **FCFS (First-Come, First-Served)**

**O que é:**
Atende as requisições na ordem em que chegam, como uma fila FIFO.

#### ✔️ Vantagens:

* **Simples de implementar:** lógica direta, baseada em fila.
* **Justo:** atende por ordem de chegada, sem priorização.

#### ❌ Desvantagens:

* **Alto tempo de espera médio:** se uma requisição longa chega primeiro, as outras esperam muito (efeito comboio).
* **Ruim para sistemas interativos:** requisições curtas podem esperar muito se vierem após longas.

---

### ⚙️ **SSTF (Shortest Seek Time First)**

**O que é:**
Atende a requisição mais próxima da posição atual da cabeça do disco, minimizando o tempo de busca.

#### ✔️ Vantagens:

* **Melhor desempenho médio que FCFS:** reduz o tempo médio de movimentação da cabeça.
* **Mais eficiente em situações com muitas requisições espalhadas.**

#### ❌ Desvantagens:

* **Starvation (fome):** requisições distantes podem nunca ser atendidas.
* **Maior complexidade:** exige cálculo contínuo da distância entre cabeça e requisições.

---

### ⚙️ **SCAN (Elevator Algorithm)**

**O que é:**
A cabeça do disco se move em uma direção atendendo todas as requisições no caminho. Ao chegar ao final do disco, inverte o sentido e repete o processo (por isso, chamado de "elevador").

#### ✔️ Vantagens:

* **Melhor que FCFS e SSTF em geral:** menor tempo de espera médio.
* **Movimento previsível:** útil em sistemas com muitas requisições em lote.
* **Evita starvation:** atende requisições de forma mais uniforme.

#### ❌ Desvantagens:

* **Tempo de espera para requisições recém-chegadas:** uma requisição pode ter que esperar a cabeça retornar.
* **Desempenho depende da distribuição das requisições.**
* **Sobrecarga de inversão de direção:** causa pequeno atraso.
* **Implementação mais complexa que FCFS.**

---

### ⚙️ **LOOK**

**O que é:**
Variação do SCAN. A cabeça do disco se move na direção das requisições, mas **só até a última requisição naquela direção** (sem ir até o fim do disco), depois inverte o movimento.

#### ✔️ Vantagens:

* **Evita movimento desnecessário:** não percorre trilhas vazias.
* **Tempo de espera médio ainda menor que o SCAN.**
* **Mesmas vantagens do SCAN:** previsibilidade, sem starvation, boa performance geral.

#### ❌ Desvantagens:

* **Ainda pode causar espera para requisições recém-chegadas.**
* **Implementação complexa:** exige controle dinâmico da direção e da fila de requisições.

---

### ⚙️ **C-SCAN (Circular SCAN)**

**O que é:**
Semelhante ao SCAN, mas ao chegar ao final do disco, a cabeça **volta direto ao início sem atender requisições no caminho de volta**, mantendo o movimento em um único sentido circular.

#### ✔️ Vantagens:

* **Tempo de espera mais uniforme:** requisições não são "penalizadas" por estarem do outro lado da direção atual.
* **Evita starvation:** mantém atendimento cíclico e justo.
* **Performance previsível:** boa para sistemas com carga constante de requisições.

#### ❌ Desvantagens:

* **Movimentos de retorno sem atender requisições:** pode gerar tempo ocioso.
* **Implementação mais complexa que SCAN e LOOK.**

---

### ⚙️ **C-LOOK (Circular LOOK)**

**O que é:**
Variação do C-SCAN. A cabeça do disco vai até a última requisição na direção atual, **sem ir até o fim do disco**, e retorna direto ao início da fila.

#### ✔️ Vantagens:

* **Mesmas vantagens do C-SCAN**, com menor movimentação da cabeça.
* **Economiza tempo e energia:** evita varredura em trilhas sem requisições.
* **Mantém tempo de espera uniforme e evita starvation.**

#### ❌ Desvantagens:

* **Implementação complexa:** exige ordenação dinâmica das requisições e controle preciso do movimento.
* **Retorno direto ainda pode gerar inatividade.**

---

