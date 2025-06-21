## 🛡️ O que é **Proteção** em Sistemas Operacionais?

### 📌 Conceito básico:

O **sistema operacional (SO)** lida com muitos **objetos**, que podem ser:

* Arquivos
* Processos
* Memória
* Dispositivos (como impressoras, HDs)
* Recursos do sistema

Esses objetos podem ser **de hardware ou software**.

---

### ✅ O problema de proteção:

A ideia é **garantir que somente processos autorizados possam acessar ou modificar esses objetos**.

> 🧠 Exemplo simples:
> Um programa comum **não pode acessar diretamente a memória do kernel**, nem **deletar arquivos de outro usuário** sem permissão.

---

## 🗂️ Como o SO organiza isso? — **Estrutura de Domínio**

### 📌 Direito de acesso:

Um **direito de acesso** é descrito assim:

```
<nome-do-objeto, conjunto-de-direitos>
```

Ou seja, define **quem pode fazer o quê** com um objeto.

> Exemplo:
>
> ```
> <arquivo.txt, {ler, escrever}>
> ```

Significa que **esse processo ou usuário** pode **ler e escrever** nesse arquivo.

---

### 📌 O que é um **domínio**?

Um **domínio** é um **conjunto de direitos de acesso**.

Cada processo (ou grupo de processos, usuários, etc.) atua **dentro de um domínio**.

> Exemplo:
>
> * Um domínio pode permitir:
>
>   * Ler arquivos
>   * Executar programas
>   * Usar a impressora

Outro domínio pode permitir apenas:

> * Ler arquivos

---

## 🔐 O que significa:

**"Define quem pode fazer o quê sobre quais objetos"**

Essa é a **base da proteção em sistemas operacionais**.

📌 **Quem** = *domínio* (usuário, grupo, processo)
📌 **Pode fazer o quê** = *ações permitidas* (ler, escrever, executar, imprimir, etc.)
📌 **Sobre quais objetos** = *arquivos, impressoras, programas, etc.*

> 💡 Exemplo:
> O usuário João (no domínio D1) pode:
>
> * Ler e escrever no arquivo `F1`
> * Executar o programa `F3`
> * Imprimir na impressora

O sistema precisa **controlar essas permissões** para garantir segurança.

---

## 🖼️ Forma 1: **Estrutura de Domínio (imagem 1)**

### ✅ Vantagens:

* Representa **visualmente por agrupamento**, fácil de ver **o que cada domínio pode fazer**.
* Ideal para **ver relações entre domínios e objetos** rapidamente.
* Mostra claramente **sobreposição de direitos** (por exemplo, `D2` e `D3` compartilhando acesso ao objeto `O4`).

### ❌ Desvantagens:

* Não mostra **todos os domínios e objetos de forma tabular**.
* Difícil de escalar para muitos domínios e objetos.
* Não é prática para **acesso automatizado ou computacional**.

---

## 📊 Forma 2: **Matriz de Acesso (imagem 2)**

### ✅ Vantagens:

* **Organizada como tabela**, facilita ver:

  * **Quem são os domínios**
  * **Quais objetos existem**
  * **Quais operações são permitidas**
* Fácil de implementar internamente no sistema operacional.
* Escala bem para um **número maior de objetos/domínios**.

### ❌ Desvantagens:

* Fica **grande e esparsa** se houver muitos domínios e objetos (muitas células vazias).
* **Visualmente menos intuitiva** para o usuário comum.
* Pode ser mais difícil perceber **agrupamentos ou sobreposições** de permissões.

---

## ✅ Comparação Final

| Característica              | Estrutura de Domínio (Imagem 1) | Matriz de Acesso (Imagem 2)       |
| --------------------------- | ------------------------------- | --------------------------------- |
| Forma                       | Gráfica, por conjuntos          | Tabela (linhas × colunas)         |
| Intuitiva para humanos      | ✅ Sim                           | ❌ Menos intuitiva                 |
| Boa para muitos objetos     | ❌ Difícil de escalar            | ✅ Escala melhor                   |
| Representa sobreposição     | ✅ Facilmente visualizado        | ❌ Mais difícil de ver             |
| Fácil para o sistema operar | ❌ Menos estruturado             | ✅ Muito mais prático internamente |

---

### 🧩 Domínio na prática (exemplo no UNIX):

* O sistema UNIX tem **dois domínios principais**:

  1. **Usuário comum**
  2. **Supervisor (ou root)**

* Cada arquivo pode ter um **bit especial chamado `setuid`**.

  * Se um programa com `setuid` for executado, o **processo herda o domínio do dono do arquivo**, não do usuário que executou.

> Exemplo:
> O comando `passwd` (para trocar senha) é executado por qualquer usuário,
> mas precisa **temporariamente de permissões de root** para alterar o arquivo de senhas.

---

## 🧠 Por que isso é importante?

* Evita **acessos não autorizados** (ex: vírus tentando mexer na memória do kernel).
* Permite **segurança entre usuários** em sistemas multiusuário.
* Garante que cada processo **só veja o que precisa ver** — princípio do **menor privilégio**.

---

## ✅ Resumo Visual

| Termo                 | Significado                                                                 |
| --------------------- | --------------------------------------------------------------------------- |
| **Objeto**            | Qualquer recurso controlado pelo sistema (arquivo, processo, memória, etc.) |
| **Direito de acesso** | O que pode ser feito com um objeto (ex: ler, escrever, executar)            |
| **Domínio**           | Conjunto de direitos de acesso atribuídos a um processo ou usuário          |
| **Proteção**          | Mecanismo para garantir que acessos só ocorram quando permitidos            |

---

