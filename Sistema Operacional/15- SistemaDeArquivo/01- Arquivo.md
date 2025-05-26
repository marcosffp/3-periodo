## 🗂️ O que é um **diretório**?

* Um diretório (também chamado de **pasta**) **serve para organizar arquivos e outros diretórios**.
* Ele **contém outros arquivos** ou diretórios dentro dele, mas **não guarda dados diretamente**, como texto ou imagens.

📁 Exemplo:
Uma pasta chamada `Documentos` pode conter:

* Um arquivo `curriculo.pdf`
* Um arquivo `projeto.docx`
* Outra pasta chamada `Trabalhos`

---
## 📦 O que é um Arquivo?

**Explicação simples:**
Um **arquivo** é como uma **caixa** onde você guarda informações no computador. Pode conter **dados** (como textos, fotos, planilhas) ou **programas** (códigos e executáveis).
* Ele **não contém outros arquivos ou diretórios dentro dele**.

📄 Exemplo:

* `carta.txt`: contém um texto.
* `foto.jpg`: contém uma imagem.
* `musica.mp3`: contém um áudio.
* `reader.cc`: código-fonte de um programa.
* `a.out`: programa já compilado (executável).
---

## 🧠 Resumo com frase correta:

> "Nem todo arquivo é um diretório, mas todo diretório é um tipo especial de arquivo."

---


## 🧱 Arquivo Estruturado vs. Não Estruturado

**📚 Analogia:**

* **Estruturado**: como uma **planilha**, com células bem definidas.
* **Não estruturado**: como um **caderno em branco**, onde você escreve byte por byte.

**📌 Tecnicamente:**

* **Estruturado**: o sistema operacional entende o formato (ex: registros fixos, comum em mainframes antigos).
* **Não estruturado**: apenas uma sequência de bytes, sem formato conhecido pelo SO (como no Unix).

---

## 📑 Atributos de um Arquivo (Metadados)

São como as **etiquetas** coladas na caixa:

* Nome
* Tipo
* Tamanho
* Localização no disco
* Proteção (quem pode ler, escrever, etc.)
* Datas (criação, modificação, acesso)

---

## 🎮 Como o Usuário Interage com o Sistema de Arquivos?

**Analogia:**
Imagine uma **biblioteca**: o SO é o **bibliotecário** e você é o leitor, pedindo para criar, ler, escrever ou apagar arquivos.

### 🔧 Operações com Arquivos (Dados)

| Função     | Analogia Simples                 | O que o SO faz                                       |
| ---------- | -------------------------------- | ---------------------------------------------------- |
| `Create()` | Comprar um novo caderno          | Aloca espaço no disco e cria o descritor do arquivo  |
| `Open()`   | Abrir um livro da estante        | Verifica permissões e carrega informações na memória |
| `Read()`   | Ler o conteúdo do livro          | Copia bytes do arquivo para a memória do programa    |
| `Write()`  | Escrever no caderno              | Copia dados da memória do programa para o arquivo    |
| `Seek()`   | Virar para uma página específica | Move o ponteiro de posição no arquivo                |
| `Close()`  | Fechar o livro                   | Atualiza o estado e libera recursos                  |
| `Delete()` | Jogar o livro fora               | Libera o espaço e remove o nome do diretório         |

---

## 🏷️ Operações com Nomes e Atributos

| Função           | Analogia Simples                     | O que o SO faz tecnicamente                     |
| ---------------- | ------------------------------------ | ----------------------------------------------- |
| `HardLink()`     | Duas chaves para o mesmo armário     | Cria outro nome para os mesmos dados            |
| `SoftLink()`     | Um bilhete dizendo “olhe na caixa A” | Cria um atalho (não aponta direto aos dados)    |
| `Rename()`       | Trocar o nome do livro               | Altera o nome no diretório                      |
| `SetAttribute()` | Colar etiquetas como “confidencial”  | Altera metadados como permissões e proprietário |
| `GetAttribute()` | Ler a etiqueta                       | Retorna os metadados do arquivo                 |

---

## 🧠 Como o SO Organiza Tudo Isso?

O SO mantém **estruturas internas**, como uma **biblioteca digital** que sabe quem pegou qual livro, em qual página está, e onde o livro fica guardado.

### 📓 Tabela de Arquivos Abertos (Global)

Usada por todos os processos. Contém:

* Contador de uso (quantos processos estão usando)
* Atributos do arquivo
* Localização física no disco
* Ponteiros para dados em cache/buffer

### 👤 Tabela de Arquivos por Processo (Individual)

Cada processo tem sua tabela. Contém:

* Ponteiro para a entrada da tabela global
* Posição atual no arquivo (como uma "página marcada")
* Modo de acesso (leitura, escrita, ambos)
* Ponteiro para buffer temporário

---

