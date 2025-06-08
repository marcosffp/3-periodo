## 🔗 COMPARTILHAMENTO DE RECURSOS EM SISTEMAS DISTRIBUÍDOS

### 🔧 O que acontece tecnicamente:

Sistemas distribuídos permitem que múltiplos nós compartilhem recursos — sejam eles **hardware (como impressoras)**, **software (como serviços web)** ou **dados (como arquivos)**. Existem três formas principais de compartilhamento:

1. **Migração de Dados**

   * Os dados são transferidos de um sistema para outro onde a computação ocorre.
   * Ex: baixar um arquivo de um servidor remoto para seu computador.

2. **Migração de Computação**

   * A computação (código/instruções) vai até os dados estão armazenados.
   * Ex: processamento de dados diretamente no servidor que os armazena (evita tráfego de rede).

3. **Migração de Trabalho**

   * Tanto os dados quanto a computação (tarefas) são realocados.
   * Ex: sistemas em nuvem que executam partes do seu código remotamente com seus dados.

---

### 🧠 Analogia:

Pense em um escritório com vários departamentos:

* **Migração de dados** é como mandar um dossiê para outro setor.
* **Migração de computação** é como mandar um funcionário até onde o dossiê está para analisar lá mesmo.
* **Migração de trabalho** é como transferir toda a tarefa (pessoa + documentos) para outro local.

---

### ⚖️ A Troca Fundamental:

> **Objetivo:** Executar as instruções do usuário da forma mais **rápida e econômica** possível.

Mas…

🔴 *Rapidez* e *economia* geralmente estão em **conflito**:

* Trazer muitos dados pela rede (rápido?) pode ser **caro**.
* Processar remotamente (econômico?) pode ser **lento** devido à latência.

---

### ✅ Vantagens do Compartilhamento de Recursos:

* Evita duplicação de recursos caros.
* Facilita a colaboração entre usuários.
* Escalabilidade e flexibilidade para atender mais usuários.

---

### ❌ Desafios / Desvantagens:

* Exige **coordenação e sincronização** entre os nós.
* **Confiabilidade**: um ponto central pode causar falha total.
* **Segurança**: recursos distribuídos exigem controle de acesso eficaz.
* Aumenta a **complexidade** do sistema.

---

### 🧠 Observação:

O modelo cliente-servidor, muito usado para esse fim, depende fortemente de **migração de dados e computação**, e pode ser implementado com **RPC (Remote Procedure Call)** ou **RMI (Java)**.

---


