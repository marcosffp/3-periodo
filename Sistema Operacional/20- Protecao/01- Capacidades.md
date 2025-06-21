### 🔐 **O que são "capacidades"?**

No contexto de sistemas operacionais, **capacidade** é uma espécie de **credencial** (ou permissão) que um processo precisa ter para poder **acessar ou operar sobre um recurso** (como memória, arquivos, dispositivos, etc).

Essas capacidades são como **chaves digitais** que controlam o que um processo pode ou não fazer. Um processo só consegue usar um recurso se tiver a "chave" correta para isso.

---

### 💻 **1. seL4 Microkernel**

* **seL4** é um microkernel extremamente seguro.
* Ele **usa capacidades para controlar tudo**, como:

  * acesso à memória,
  * criação e controle de threads,
  * comunicação entre processos.
* Para cada recurso, **só dá para fazer uma operação se o processo tiver a capacidade correspondente**.
* Isso é verificado **em tempo de execução**, com um nível **formal de segurança altíssimo** (comprovado matematicamente que o sistema está seguro!).

✅ *Exemplo simples*: se um processo quiser escrever na memória, ele só poderá fazer isso se possuir a capacidade específica que permite escrever naquela região.

---

### 🌐 **2. WebAssembly (Wasm)**

* WebAssembly é usado para rodar código em navegadores ou ambientes isolados.
* Ele também segue o modelo de capacidades:

  * O módulo **não pode acessar nada do sistema** (como arquivos, rede, etc) **por padrão**.
  * **Só pode acessar se o "host" (o navegador, por exemplo) entregar uma capacidade específica.**
* Isso implementa o **princípio do menor privilégio**: cada módulo só pode fazer exatamente o que for autorizado.

✅ *Exemplo*: um jogo feito em WebAssembly não pode ler arquivos do disco do usuário, **a menos que o navegador (host) entregue uma capacidade que permita isso**.

---

### 🧠 Resumo da Ideia Central

* Em **sistemas baseados em capacidades**, **as permissões são dadas individualmente e explicitamente**, como se cada processo tivesse um conjunto de "cartões de acesso".
* Isso é diferente de simplesmente checar se o usuário é "admin" ou não.
* **Muito mais seguro**, especialmente em ambientes onde **segurança, isolamento e controle fino de acesso são críticos**.

Claro! Aqui estão as **vantagens e desvantagens** dos **Sistemas Baseados em Capacidades**, incluindo comparação com a **Matriz de Acesso**, que é outro modelo estudado na disciplina:

---

## ✅ **Vantagens dos Sistemas Baseados em Capacidades**

| Vantagem                                | Explicação                                                                                                                           |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| 🔐 **Segurança mais granular**          | Permissões são específicas por recurso e por operação. Um processo só acessa o que tiver permissão explícita.                        |
| 🧱 **Isolamento forte entre processos** | Um processo não pode acessar acidentalmente (ou maliciosamente) recursos de outro, se não tiver a capacidade correspondente.         |
| 📏 **Princípio do menor privilégio**    | O sistema força cada processo a operar com o mínimo necessário de permissões, reduzindo o impacto de falhas ou ataques.              |
| 📈 **Eficiência em sistemas modernos**  | Pode ser mais leve do que manter grandes estruturas como matrizes de acesso (principalmente em microkernels e sistemas embarcados).  |
| 🧪 **Verificações formais possíveis**   | Em sistemas como o seL4, é possível provar matematicamente que o sistema é seguro, porque o controle via capacidades é bem definido. |

---

## ❌ **Desvantagens dos Sistemas Baseados em Capacidades**

| Desvantagem                                                 | Explicação                                                                                                                                          |
| ----------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| 🔄 **Gerenciamento de capacidades pode ser complexo**       | Distribuir, revogar e controlar todas as capacidades pode ser difícil, especialmente em sistemas grandes.                                           |
| 🧾 **Auditoria pode ser mais trabalhosa**                   | É difícil saber "quem pode acessar o quê" sem rastrear todas as capacidades emitidas.                                                               |
| 🔐 **Revogação de acesso não é trivial**                    | Uma vez que uma capacidade foi entregue a um processo, retirá-la requer mecanismos adicionais (como tabelas ou wrappers).                           |
| 🧠 **Mais difícil de implementar em sistemas tradicionais** | Sistemas baseados em usuários e permissões (como UNIX/Linux) já estão estabelecidos e não usam esse modelo por padrão.                              |
| 🧪 **Pouco intuitivo para programadores comuns**            | Programadores podem ter dificuldade em entender e gerenciar capacidades corretamente, especialmente fora de ambientes específicos como WebAssembly. |

---

## 🆚 **Comparação: Capacidade vs. Matriz de Acesso**

| Critério                  | Capacidade                                  | Matriz de Acesso                           |
| ------------------------- | ------------------------------------------- | ------------------------------------------ |
| **Escalabilidade**        | Melhor para muitos objetos/processos        | Fica grande e complexa rapidamente         |
| **Revogação de acesso**   | Mais difícil (precisa rastrear capacidades) | Mais simples (remover entrada da matriz)   |
| **Verificação de acesso** | Rápida (verifica se capacidade existe)      | Pode ser lenta se a matriz for grande      |
| **Segurança**             | Muito alta se bem implementado              | Depende de como as permissões são mantidas |
| **Visibilidade**          | Difícil saber o que um processo pode fazer  | Fácil de ver quem acessa o quê             |

---