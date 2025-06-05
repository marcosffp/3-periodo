# 🖥️ **Visão do Programador de Aplicativos dos Dispositivos de E/S**

### 👉 **O que é isso?**

É como o **programador enxerga os dispositivos de Entrada/Saída (E/S)** quando faz um programa. Ou seja, como ele interage com teclado, disco, impressora, mouse, etc.

O programador não precisa saber como funciona o hardware interno, mas precisa entender **como o sistema operacional oferece o acesso** a esses dispositivos.

---

## 🔍 **Aspectos que o programador vê nos dispositivos:**

| ⚙️ **Aspecto**                | 🔀 **Variações**                                                                                                                                                     | 🎯 **Exemplos**                                                         |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| **Modo de transferência**     | ➡️ **Caractere** (um por um) <br> ➡️ **Bloco** (vários de uma vez)                                                                                                   | Terminal, teclado (caractere) <br> Disco, CD-ROM (bloco)                |
| **Método de acesso**          | ➡️ **Sequencial** (vai na ordem) <br> ➡️ **Aleatório** (vai direto onde quer)                                                                                        | Fita (sequencial) <br> Disco, CD-ROM (aleatório)                        |
| **Temporização**              | ➡️ **Síncrono** (espera resposta na hora) <br> ➡️ **Assíncrono** (dispositivo avisa quando termina)                                                                  | Teclado (síncrono) <br> Impressora, Disco (assíncrono)                  |
| **Compartilhamento**          | ➡️ **Dedicado** (só um usa) <br> ➡️ **Compartilhado** (vários usam)                                                                                                  | Impressora (dedicado) <br> Disco, teclado (compartilhado)               |
| **Velocidade do dispositivo** | ➡️ **Latência** (tempo de resposta) <br> ➡️ **Seek Time** (tempo de busca) <br> ➡️ **Taxa de transferência** (quanto envia/recebe) <br> ➡️ **Delay entre operações** | Varia entre SSD, HD, teclado, impressora, etc.                          |
| **Direção da E/S**            | ➡️ **Somente leitura** <br> ➡️ **Somente escrita** <br> ➡️ **Leitura e escrita**                                                                                     | CD-ROM (leitura) <br> Impressora (escrita) <br> Disco (leitura/escrita) |

---

## 📦 **Dispositivos de Bloco x Caractere**

### 🗂️ **Bloco:**

* Trabalham com **grandes blocos de dados**.
* **Discos, SSD, CD-ROM.**
* Permitem **busca, leitura e escrita**.
* Usam **E/S bruta** ou **acesso via sistema de arquivos**.
* Suportam **mapeamento de memória** (ex.: mmap).

---

### 🔡 **Caractere:**

* Trabalham com **dados unitários (caracteres, bytes)**.
* **Teclado, mouse, portas seriais.**
* Usam comandos como **get** (ler) e **put** (escrever).
* Geralmente possuem **camadas extras**, como edição de linha (backspace, setas, etc.).

---

## 🚀 **Por que usamos Buffer e Cache?**

### 🔸 **Buffer:**

* Soluciona o problema de **diferença de velocidade** entre CPU e dispositivo.
* Ex.: Receber da **rede (lento)** e gravar no **disco (rápido)**.
* Permite que o programa **não fique preso esperando** a gravação ou leitura terminar.

### 🔸 **Cache:**

* Guarda os **dados mais usados na memória** para não precisar buscar no disco toda hora.
* ✔️ Melhora o desempenho absurdamente.

---

## 📝 **Políticas de Cache:**

* **Write-through:** Grava no cache e **imediatamente no disco**.
  ✔️ Mais seguro.
* **Write-back:** Grava **só no cache** e envia para o disco depois.
  ✔️ Mais rápido, mas menos seguro em caso de queda de energia.

---

## 🔧 **Por que a maioria dos dispositivos é assíncrona?**

* Porque eles trabalham em velocidades muito diferentes da CPU.
* A CPU faz outras tarefas enquanto espera a E/S terminar (por isso é assíncrona).
* Mas as **chamadas de sistema são síncronas** — o programa só continua quando os dados chegam.
  ➡️ Por isso, o **SO faz E/S de bloqueio**.

---

## 🏗️ **Resumo do Fluxo de E/S:**

1. O programa faz um **read()** ou **write()**.
2. O SO verifica se os dados estão no **buffer/cache**.
3. Se não estiverem:

   * Envia o comando para o **driver**, que aciona o **controlador de DMA**.
   * O **DMA transfere direto do dispositivo pra memória (RAM)**.
   * Quando termina, gera uma **interrupção** para avisar a CPU.
4. O SO pega os dados do buffer e entrega pro programa.

---

## 🚀 **Tabela Comparativa Completa dos Métodos de E/S:**

| 🚥 **Método**   | 🏗️ **Funcionamento**                     | ✅ **Vantagem**                     | ❌ **Desvantagem**                          |
| --------------- | ----------------------------------------- | ---------------------------------- | ------------------------------------------ |
| **Polling**     | CPU fica perguntando se terminou          | Simples e imediato                 | CPU perde tempo se o dispositivo for lento |
| **Interrupção** | Dispositivo avisa a CPU quando termina    | CPU livre enquanto espera          | Sobrecarga de tratar interrupções          |
| **DMA**         | Dispositivo grava direto na memória (RAM) | Super eficiente p/ grandes volumes | DMA e CPU competem pelo barramento         |

---


