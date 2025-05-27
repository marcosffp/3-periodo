## 🔄 COMO FUNCIONAM OS DISCOS

### 📀 A estrutura física:

* Pensa num **vinil/CD/DVD** girando: o **disco rígido** é parecido, só que ao invés de músicas/imagens, ele grava **dados** usando **camadas magnéticas**.
* Esse disco tem **trilhas**: são **anéis concêntricos**, tipo as faixas de um disco de vinil.
* Cada trilha é dividida em **setores** (ou blocos). Esses setores são as **unidades mínimas de leitura/gravação**. Mesmo que você queira ler 1 bit, ele carrega o bloco todo (tipo um pacote fechado).

### 📚 Organização em "packs":

* Os discos não são só uma "camada" – eles vêm em **packs de discos empilhados** (como várias panquecas empilhadas).
* Cada "panqueca" pode gravar nos dois lados (exceto as de cima/baixo).
* O pente (leitor/escritor) possui dois conjuntos de cabeças de leitura/gravação na extremidade de cada braço.


---

## 🧭 Como ele encontra os dados?

Pra ler ou gravar algo, o disco precisa:

1. **Mover o braço** até a trilha correta (imagina uma agulha no vinil indo pra faixa certa) → isso é o **tempo de seek**.
2. Esperar o disco girar até o setor desejado passar embaixo da cabeça → isso é o **tempo de rotação**.
3. Aí sim ele lê/grava os dados.

Esses tempos juntos chamam-se **latência**.

---

## ⚙️ Overheads

* **Overhead do disco**: é o tempo que o sistema leva pra **começar** a operação (tipo o tempo que você gasta só preparando pra fazer algo).
* **Largura de banda (I/O)**: é a **velocidade de transferência** de dados uma vez que tudo começou a funcionar.
* **Latência**: O tempo necessário para iniciar a transferência de 1 byte do disco para a memória.

---

## 🧩 Como os arquivos ficam no disco?

### 🗂 Quando um arquivo é salvo no disco...

Ele **não é armazenado em uma linha contínua de dados**. O sistema operacional precisa saber **onde estão fisicamente os blocos** que compõem o arquivo no disco.

#### 🧭 Exemplo:
fileID 0, Bloco 0 → Prato 0, Cilindro 0, Setor 0  
fileID 0, Bloco 1 → Prato 4, Cilindro 3, Setor 8

Ou seja, o **bloco 0** do arquivo está em um lugar, e o **bloco 1** em outro completamente diferente.

#### 📍 Terminologia:

* **Prato**: qual "panqueca" da pilha de discos.
* **Cilindro**: a trilha que está sendo acessada em todos os pratos.
* **Setor**: a fatia específica da trilha (como uma fatia de pizza).

---

### 📌 Estrutura usada: **Descritor de Arquivo** (File Descriptor / Inode)

O descritor funciona como a **ficha técnica** do arquivo. Ele:

* Indica **onde cada bloco do arquivo está no disco**.
* Armazena **informações adicionais** como:

  * Dono
  * Permissões
  * Tamanho
  * Data de modificação
* É armazenado no próprio disco (como os **inodes** no Unix).

---

### 🎯 Três grandes preocupações de desempenho:

#### 1. 🔁 Acesso sequencial vs. aleatório

* **Sequencial**: ler os blocos em ordem (bloco 0, 1, 2, 3...).
  ➤ Desempenho ideal quando os blocos estão **fisicamente próximos**.
* **Aleatório**: acessar diretamente um bloco específico (ex: bloco 97).
  ➤ Desempenho ruim se os blocos estiverem **espalhados**.

#### 2. 🧠 Estrutura de dados para guardar os endereços dos blocos

* **Lista encadeada?**
* **Indexação?**
* **Tabela com ponteiros diretos e indiretos?**

Cada abordagem afeta o **desempenho de leitura** e a **flexibilidade** para expandir o arquivo.

#### 3. 🧱 Organização física dos arquivos no disco

* Blocos **contíguos**: acesso rápido, menos movimentação do braço do disco.
* Blocos **espalhados**: acesso lento, exige movimentação mecânica.

---

### 📊 Perfil típico de uso do sistema de arquivos:

1. A maioria dos arquivos é **pequena**.
2. A maior parte do **espaço do disco** é ocupada por arquivos **grandes**.
3. Operações de **I/O** são feitas tanto em arquivos pequenos quanto grandes.

➡️ **Consequência**:
O sistema precisa garantir:

* **Baixo custo por arquivo** (eficiência com arquivos pequenos).
* **Bom desempenho para arquivos grandes** também.


## 📁 Tipos de alocação de arquivos

Claro! Vamos por partes para explicar de forma bem didática os três principais **métodos de alocação de arquivos no disco**: **contígua, encadeada e indexada** (incluindo a indexada em múltiplos níveis). Esse conteúdo está no slide *"Sistemas de Arquivos (Parte 2)"* do Prof. Pedro Ramos.

---

## 🧱 **1. ALOCAÇÃO CONTÍGUA**

### ✅ Como funciona:

O sistema operacional mantém uma **lista ordenada de blocos livres** no disco.
Quando um novo arquivo é criado, o SO procura por um **conjunto contínuo (contíguo)** de blocos livres e os aloca de uma vez.

📦 Exemplo:
Se o arquivo precisa de 5 blocos, e há blocos livres consecutivos de 100 a 104, o arquivo será gravado do 100 ao 104.

No **descritor de arquivo**, basta armazenar:

* O bloco inicial (ex: 100)
* O tamanho (ex: 5 blocos)

---

### ✅ Vantagens:

* **Simplicidade**: fácil de implementar e entender.
* **Performance alta**: leitura sequencial rápida, poucos movimentos do braço do disco (menos seeks).

---

### ❌ Desvantagens:

* **Fragmentação externa**: com o tempo, vai ficando difícil encontrar blocos contíguos grandes.
* **Dificuldade de crescimento**: se o arquivo precisar crescer, pode não haver espaço contínuo.
* **Gerenciamento rígido**: arquivos grandes que mudam de tamanho exigem realocação.

---

### 📘 Analogia:

É como guardar um livro em uma estante: você precisa de vários espaços consecutivos livres para acomodá-lo. Se tiver só espaços soltos, não cabe.

---

## 🔗 **2. ARQUIVOS ENCADEADA**

### ✅ Como funciona:
Manter uma lista de todos os setores/blocos livres.
O sistema **mantém ponteiros dentro dos blocos** do arquivo.
No **descritor de arquivo**, há apenas o ponteiro para o **primeiro bloco**.
Suporta de forma eficiente qual tipo de acesso? Acesso sequencial, pois os blocos são lidos em ordem.

---

### ✅ Vantagens:

* **Sem fragmentação externa**: os blocos podem estar **em qualquer lugar** do disco.
* **Facilidade para crescer ou reduzir o arquivo**: é só atualizar os ponteiros.
* Ideal para **acesso sequencial** (ler os blocos em ordem).

---

### ❌ Desvantagens:

* **Acesso aleatório é ruim**: para acessar o bloco N, o sistema precisa seguir todos os ponteiros até lá.
* **Muitos seeks**: já que os blocos estão espalhados, o braço do disco pula muito.

---

### 📘 Analogia:

É como uma **caça ao tesouro**: o primeiro papel (bloco) indica onde está o segundo, o segundo aponta o terceiro e assim por diante.

---

## 🗂️ **3. ARQUIVOS INDEXADA**

### ✅ Como funciona:

É uma forma de organizar os dados de um arquivo no disco em que o Sistema Operacional (SO) mantém um índice (ou array) com ponteiros para os blocos onde estão os pedaços do arquivo.
No momento da criação do arquivo, o SO ou o usuário precisa definir o tamanho máximo que o arquivo poderá atingir (por exemplo, 100 blocos).

O SO então aloca um array com 100 posições, que servirá para armazenar os ponteiros dos blocos de dados (mas ainda não aloca os blocos de dados!).

Conforme você for gravando dados, o SO vai:

Alocar blocos de disco sob demanda;

Preencher os ponteiros no array conforme os blocos vão sendo usados.

👉 É como se fosse um **índice de livro**, apontando diretamente para os capítulos.

---

### ✅ Vantagens:

* Pouco espaço desperdiçado: como os blocos são alocados sob demanda, você só usa o que precisa.
* Acesso fácil: tanto sequencial quanto aleatório são simples de implementar — basta seguir os ponteiros.
 Por exemplo, para ler o bloco 7, é só olhar a posição 7 do array de ponteiros.

---

### ❌ Desvantagens:

* O array de ponteiros ocupa espaço no descritor de arquivo — quanto mais blocos, mais ponteiros.
* Você tem que definir um tamanho máximo de arquivo logo no início.
* Os blocos podem ficar espalhados no disco → muitos seeks (movimentos físicos do disco), o que diminui a performance.

---

### 📘 Analogia:

É como ter um **índice com marcadores de página**: cada ponteiro diz exatamente onde está cada parte do conteúdo.

---

## 🏗️ **4. ARQUIVO INDEXADA EM MÚLTIPLOS NÍVEIS (ex: UNIX BSD 4.3)**

### ✅ Como funciona:

* É um método de organização dos arquivos no disco, onde o descritor de arquivo (tipo um "cartão de referência") contém ponteiros para os blocos de dados. Esses ponteiros podem ser:

   * Diretos (vão direto ao dado),
   * Indiretos (precisam de um passo a mais), 
   * Duplamente indiretos (dois passos).

---

🧱 Estrutura do descritor (inode):
Ponteiro	Tipo	O que aponta
0 a 11	Diretos	Vão direto para blocos de dados (12 blocos diretos).
12	Indireto simples	Aponta para um bloco que contém 1024 ponteiros.
13	Indireto duplo	Aponta para um bloco que aponta para blocos com ponteiros.
14	Indireto triplo	Aponta para um bloco que aponta para blocos que apontam para outros blocos com ponteiros para os dados. (Não foi citado no seu slide, mas existe em alguns SOs modernos.)

🎯 Por que isso?
Porque arquivos pequenos podem ser acessados diretamente (rápido e simples), e arquivos grandes podem crescer sem limites pré-definidos, usando os níveis de indireção conforme a necessidade.

🧠 Analogia com biblioteca:
Imagine que você tem um armário com gavetas numeradas para guardar páginas de um livro (dados do arquivo):

📁 Os 12 primeiros ponteiros são como "atalhos" diretos para as gavetas com páginas.

🗃️ O 13º ponteiro aponta para uma gaveta com uma lista de 1024 endereços de outras gavetas com páginas (1 nível de indireção).

🧳 O 14º ponteiro aponta para uma gaveta que contém endereços de outras gavetas, que por sua vez contêm listas com os endereços finais das páginas (2 níveis de indireção).


### ✅ Vantagens:

* Simples de implementar: só adicionar ponteiros conforme o arquivo cresce.
* Arquivos pequenos são super eficientes: usam só os ponteiros diretos.
* Crescimento progressivo: você só aloca o que precisa, conforme o arquivo aumenta.

---

### ❌ Desvantagens:

* Acesso indireto é mais lento: exige vários seeks (posicionamentos) para arquivos grandes.
* Não há contiguidade: os dados ficam espalhados — ruim para leitura sequencial de grandes volumes.
* Limite prático de tamanho: depende de quantos ponteiros e níveis existem.

---

### 📘 Analogia:

Pense nos ponteiros como **índices de livros com subíndices**.
Nos arquivos pequenos você vai direto. Em arquivos grandes, precisa consultar um índice, que te leva a outro índice, e aí ao dado.

---

## 📊 Tabela Comparativa

| Método                       | Vantagens                           | Desvantagens                     | Acesso Aleatório | Acesso Sequencial |
| ---------------------------- | ----------------------------------- | -------------------------------- | ---------------- | ----------------- |
| Alocação Contígua            | Simples, leitura rápida             | Difícil de crescer, fragmentação | Ótimo            | Ótimo             |
| Alocação Encadeada           | Fácil de crescer, sem fragmentação  | Ruim para acesso aleatório       | Ruim             | Bom               |
| Alocação Indexada            | Suporta bem ambos os acessos        | Muitos ponteiros, tamanho fixo   | Bom              | Bom               |
| Indexada em Múltiplos Níveis | Suporta arquivos grandes e pequenos | Muito seeks em arquivos grandes  | Médio a ruim     | Bom               |

---
