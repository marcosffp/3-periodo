## 📁 NOMES E DIRETÓRIOS — Como o SO organiza arquivos

---

### 🧭 **Motivação: Como acessar arquivos no disco?**

* O **sistema operacional usa identificadores numéricos**.
* O **usuário prefere nomes textuais** (ex: `trabalho.docx`, `musica.mp3`).
* Por isso, o SO mantém uma **estrutura chamada diretório**, que **mapeia nomes → descritores de arquivos** (como se fosse um índice).

---


## 🧱 ESTRUTURAS DE DIRETÓRIOS

### 1️⃣ **Diretório de Nível Único**

📦 Um único diretório para **todo o sistema**.

* Todos os arquivos estão no **mesmo "caixote"**.
* Nomes precisam ser **únicos globalmente**.
* Simples, mas **impraticável com muitos usuários**.

🔍 **Analogia**: Como um **depósito onde tudo é jogado junto** — se dois arquivos tiverem o mesmo nome, conflito!

---

### 2️⃣ **Diretório de 2 Níveis**

👤 Cada **usuário tem seu próprio diretório**.

* Dentro do seu espaço, os nomes devem ser únicos.
* Facilita separação, mas ainda **sem subdiretórios**.

🔍 **Analogia**: Cada pessoa tem uma **gaveta nomeada**, mas dentro dela não pode ter pastas.

---

### 🌳 **Diretórios Multinível (hierárquicos)**

📂 Diretórios dentro de diretórios (estrutura em **árvore**).

* **Padrão moderno (Unix, Windows, etc.)**
* Existe um **diretório raiz `/`**.
* Cada diretório contém **pares `<nome, descritor>`**, podendo referenciar **arquivos ou outros diretórios**.
* Exemplo de **caminho (lookup)**: `/home/ana/projetos/tcc.tex`
* Diretórios são armazenados no disco como arquivos, com um bit especial no arquivo descritor.

🔍 **Analogia**: Como um **sistema de pastas** em um computador com várias subpastas organizadas por tema.

---

## 🔗 LINKS — Nomeação Referencial

### 🪢 **Hardlink (link rígido)**

🧱 Cria **outra entrada** no diretório apontando **para o mesmo arquivo físico**.

* Ambos os nomes apontam para o **mesmo descritor (i-node)**.
* Arquivo só é removido quando **todos os hardlinks são deletados**.
* ❌ Problema: **não são permitidos para diretórios**, para evitar **ciclos**.

🔍 **Analogia**: Dois **nomes diferentes para a mesma casa** — apagar uma placa (nome) não destrói a casa (arquivo).

---

### 🪄 **Softlink (link simbólico)**

🧾 Cria um **atalho textual** que aponta para o **nome de outro arquivo**.

* Se o alvo for deletado, o link simbólico **vira “quebrado”**.
* ✅ Usado também para diretórios.
* ❌ Pode causar **loops infinitos** (se mal utilizados).
* Solução: Limitar o número de links percorridos.

🔍 **Analogia**: Um **bilhete** que diz “vá para a casa da Ana” — se a casa da Ana for demolida, o bilhete não ajuda.

---

## 🛠️ OPERAÇÕES EM DIRETÓRIOS

| Operação         | O que faz                                                             |
| ---------------- | --------------------------------------------------------------------- |
| 🔍 **Buscar**    | Localiza o descritor de um arquivo (ex: `open("foto.jpg")`)           |
| 🆕 **Criar**     | Adiciona nova entrada `<nome, descritor>` ao diretório                |
| 🗑️ **Excluir**  | Remove o nome do diretório e libera espaço se for o último hardlink   |
| 📃 **Listar**    | Exibe todos os arquivos do diretório (ex: `ls` no UNIX)               |
| 🔁 **Renomear**  | Muda o nome do arquivo no diretório                                   |
| 🌐 **Percorrer** | Caminhar pela árvore de diretórios (ex: comandos `cd`, `ls -R`, etc.) |

---

## 🧮 QUAL O LIMITE ASSINTÓTICO DESSAS OPERAÇÕES?

➡️ Depende da **estrutura de dados usada para armazenar o diretório**:

* Se for uma **lista simples**, então **O(N)**.
* Se for **árvore balanceada** (como em sistemas modernos), pode ser **O(log N)**.
* Busca + ordenação pode dar **O(N log N)**.

🧠 **Resposta mais comum** para *busca simples*: **a) O(N)**.

---

## 🔐 PROTEÇÃO E ACESSO

### 🎫 **Listas de Acesso (ACL - Windows)**

* Lista por arquivo com **usuário + tipo de acesso (r/w/x)**.
* Flexível, mas **difícil de escalar** com muitos usuários.

### 🧱 **Bits de Acesso (UNIX)**

* Três grupos: **owner (u), group (g), others (o)**.
* Três tipos: **read (r), write (w), execute (x)**.
* Representação binária: `rwxr-x---` → `111101000`

O sistema operacional usa permissões de acesso (como no Unix: owner, group, others) com três tipos: leitura (r), escrita (w) e execução (x), controlando o que cada usuário pode fazer com arquivos compartilhados.

* **r** = read (leitura): pode ver o conteúdo do diretório (listar arquivos).
* **w** = write (escrita): pode criar, renomear ou deletar arquivos dentro do diretório.
* **x** = execute (execução): pode **entrar no diretório** (acessar arquivos e subpastas dentro dele).

---

## ✅ CONCLUSÃO (Resumo Final)

| Conceito              | O que é                                             | Analogia                                     |
| --------------------- | --------------------------------------------------- | -------------------------------------------- |
| Diretório             | Mapeia nomes para descritores de arquivos           | Índice de uma estante                        |
| Hardlink              | Outro nome para o mesmo arquivo físico              | Duas placas na mesma casa                    |
| Softlink              | Ponteiro para o nome de outro arquivo               | Bilhete com instrução de onde encontrar algo |
| Diretórios multinível | Estrutura em árvore com pastas e subpastas          | Pastas dentro de pastas                      |
| Operações             | Criar, deletar, buscar, listar, renomear, percorrer | Usar um explorador de arquivos gráfico       |
| Proteção              | Controle de acesso via ACL (Windows) ou bits (UNIX) | Chave ou senha para cada pasta               |

---

## 1. Estrutura de diretórios: normalmente é uma **árvore**

* O sistema de arquivos tradicional organiza diretórios numa estrutura **em árvore**.
* Isso significa que:

  * Cada diretório tem **um único "pai"** (exceto a raiz `/`).
  * Não existem ciclos (não dá pra voltar para o mesmo diretório passando por caminhos diferentes).
  * Isso facilita operações como listar, copiar e deletar pastas recursivamente.

---

## 2. O que é um **grafo** no contexto de diretórios?

* Um **grafo** é uma estrutura onde os nós (diretórios) podem ter **mais de um pai** e podem existir **ciclos** (loops).
* Se a estrutura de diretórios for um grafo, isso quer dizer que:

  * Um diretório pode ser acessado por caminhos diferentes (não só por um caminho único).
  * Pode haver ciclos, ou seja, você pode voltar a um diretório passando por uma sequência de links/diretórios.

---

## 3. Consequências de uma estrutura de diretórios ser um grafo

### a) Ciclos infinitos

* Programas que fazem navegação recursiva (como `ls -R`, `cp -r`, `rm -r`, backups) podem entrar em **loop infinito** ao percorrer diretórios.
* Por exemplo, ao tentar apagar uma pasta que tem links simbólicos circulares, o processo pode não terminar ou travar.

### b) Complexidade para o sistema

* O sistema de arquivos e as ferramentas precisam manter controle extra para evitar processar o mesmo diretório várias vezes.
* Isso implica mais overhead para detectar ciclos.

### c) Dificuldade para o usuário

* Pode ser confuso saber onde um arquivo ou diretório realmente “está”, já que pode existir em vários caminhos diferentes.
* Apagar ou modificar pode afetar outros lugares inesperados.

---

## 4. Como o Linux/Unix lida com isso?

* **Hardlinks para diretórios são proibidos** para evitar ciclos.
* **Softlinks podem criar ciclos**, por isso ferramentas que percorrem diretórios precisam detectar ciclos e evitar repetir caminhos.
* Algumas ferramentas têm opções para seguir ou não seguir links simbólicos.

---

## 5. Resumo

| Estrutura | Característica                                         | Problema Principal                     |
| --------- | ------------------------------------------------------ | -------------------------------------- |
| Árvore    | Sem ciclos, único caminho para cada diretório          | Fácil de navegar e gerenciar           |
| Grafo     | Pode ter ciclos e múltiplos caminhos para um diretório | Pode causar loops infinitos e confusão |

---


