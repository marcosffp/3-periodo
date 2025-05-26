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

