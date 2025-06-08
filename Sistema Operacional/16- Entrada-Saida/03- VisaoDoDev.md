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