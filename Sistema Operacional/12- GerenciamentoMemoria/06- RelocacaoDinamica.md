### 🔁 **O que é Relocação Dinâmica?**

É uma técnica onde **o endereço lógico (ou virtual)** gerado por um processo **não é diretamente o endereço físico** usado na memória RAM. Em vez disso, ele **passa por uma conversão feita em tempo de execução** por hardware, usando dois registradores:

1. **Registrador de Relocação (Base)**: armazena o **endereço base** onde o processo começa na memória física.
2. **Registrador de Limite**: define até onde o processo pode acessar a memória (proteção contra acessos indevidos).

---

### 🔍 Como funciona o diagrama?

1. **A CPU gera um endereço lógico** (ex: "posição 50").
2. **Esse endereço lógico é somado ao valor do registrador base** para calcular o endereço físico real (ex: base = 1000 → físico = 1050).
3. **O endereço lógico também é comparado com o registrador limite**:
   - Se o valor for **maior ou igual ao limite**, é um erro → ocorre uma **trap** (interrupção) de "erro de endereço".
   - Se for válido, o acesso à memória física acontece normalmente.

---

### 🤔 Por que isso facilita mover processos?

Porque o processo **não sabe onde está na memória física** — ele só usa endereços lógicos. O SO pode:

- Mover o processo na memória **sem alterar o código**;
- Basta **atualizar os valores dos registradores base e limite**, e tudo continua funcionando.

---

### ✅ Vantagens

- Permite mover ou expandir processos facilmente.
- Simples no hardware (apenas soma e comparação).
- Maior proteção e isolamento de processos.

### ❌ Desvantagens

- A cada acesso à memória, o hardware precisa fazer a soma → pode ser um pouco mais lento.
- **Não permite compartilhamento de código** entre processos (como bibliotecas comuns).
- **Limita a multiprogramação**: todos os processos precisam estar completamente na RAM.

---
