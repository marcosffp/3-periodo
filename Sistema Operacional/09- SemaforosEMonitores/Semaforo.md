# 📚 Sincronização com Semáforos — Guia Completo

## 🧠 Por que sincronização é importante?

Quando **vários processos ou threads** acessam **recursos compartilhados** (arquivos, variáveis, impressoras), pode dar **ruim** se acessarem ao mesmo tempo → surgem **condições de corrida**.

### Exemplo simples:
> Duas pessoas editando a mesma planilha ao mesmo tempo, sem combinar. Uma pode sobrescrever o que a outra fez. 🧨

### Para evitar isso, usamos **mecanismos de sincronização**, como:

- 🔴 **Semáforos**

---

## 📌 O que é um semáforo?

Um **semáforo** é uma **variável inteira** que funciona como **sinalizador de acesso** a recursos compartilhados.

### Tipos de Semáforo:

- **Binário**: só pode ser `0` ou `1` (tipo **cadeado** — trancado ou destrancado)
- **Contador**: pode ter valores maiores → útil para limitar acesso simultâneo (ex: estacionamento com 5 vagas)

---

## 🧰 Como funciona um semáforo?

Duas operações principais (atômicas):

- `wait()` ou `P()` → tenta entrar (decrementa o valor)
  - Se o valor ficar menor que 0 → a thread **bloqueia**
- `signal()` ou `V()` → libera o recurso (incrementa o valor)
  - Se tiver thread esperando → **acorda uma**

---

## 🧪 Exemplo com semáforo binário:

```c
semáforo mutex = 1;

Processo {
    wait(mutex);    // pega a chave
    x = x + 1;      // usa o recurso
    signal(mutex);  // devolve a chave
}
```

> 🔐 Aqui, só um processo por vez entra na seção crítica

---

## 🧱 Estrutura do Semáforo (classe):

```cpp
class Semaphore {
public:
  void Wait(Process P);
  void Signal();
private:
  int valor;
  Queue Q; // fila de processos
}

Semaphore(int val) {
  valor = val;
  Q = vazio;
}
```

### ✅ O valor representa:

| Valor        | Significado                                        |
|--------------|----------------------------------------------------|
| `> 0`        | Tem acesso disponível                              |
| `== 0`       | Último recurso foi usado, mas ninguém está esperando |
| `< 0`        | Tem processo bloqueado esperando na fila `Q`       |

---

## ⚙️ Detalhes do funcionamento:

### `Wait(Process P)`

```cpp
valor = valor - 1;
if (valor < 0) {
    adicionar P a Q;
    P->bloquear();
}
```

- Sempre decrementa o valor
- Se `valor < 0`, o processo **entra na fila e bloqueia**

---

### `Signal()`

```cpp
valor = valor + 1;
if (valor <= 0) {
    remover P de Q;
    acordar(P);
}
```

- Sempre incrementa
- Se `valor <= 0` → acorda uma thread esperando

---

## 📌 Exemplo passo a passo:

### Situação:
```cpp
P1: S.Wait();
P2: S.Wait();
P1: S.Wait();
P2: S.Signal();
P2: S.Signal();
P2: S.Signal();
```

```makefile
VALOR = 2
FILA = VAZIA
```

### Passos:

1️⃣ `P1: S.Wait();`  
→ valor = 2 → 1 → P1 continua

2️⃣ `P2: S.Wait();`  
→ valor = 1 → 0 → P2 continua

3️⃣ `P1: S.Wait();`  
→ valor = 0 → -1 → **P1 bloqueia**  
→ FILA = `[P1]`

4️⃣ `P2: S.Signal();`  
→ valor = -1 → 0 → **acorda P1**  
→ FILA = vazia

5️⃣ `P2: S.Signal();`  
→ valor = 0 → 1

6️⃣ `P2: S.Signal();`  
→ valor = 1 → 2

---

## 🔄 Semáforo vs Lock

| Comparativo                | Semáforo                                     | Lock (mutex)                            |
|----------------------------|----------------------------------------------|-----------------------------------------|
| Acessos simultâneos        | ✅ Pode controlar (valor > 1)                | ❌ Apenas 1 processo por vez            |
| Desbloqueio de outros      | ✅ Pode acordar outras threads              | ❌ Só quem pegou o lock pode liberar    |
| Flexibilidade              | ✅ Alta                                      | ❌ Limitado                             |
| Facilidade de uso          | ❌ Complexo                                  | ✅ Simples                              |
| Propensão a erro           | ❌ Alta (exige cuidado)                      | ✅ Menor                                |

---

## ✅ Por que usar semáforo?

**Flexibilidade maior:**

- Permite múltiplos acessos simultâneos (ex: valor = 3)
- Pode sincronizar eventos diferentes
- Pode acordar outras threads (Signal() sem ser dono)

### ⚠️ Mas exige cuidado:

- Esquecer um `Signal()` → deadlock
- `Signal()` a mais → erros de concorrência
- `Signal()` antes do `Wait()` → acorda "fantasma"
- Pode causar starvation, deadlocks...

---

## 🔒 Por que Locks são mais seguros contra erros?

### ✅ Vantagens:

1. **Mais simples** de usar:
```c
lock(L);
// seção crítica
unlock(L);
```

2. **Menos risco de bugs** (sem contador ou fila)

3. **Automáticos** em linguagens modernas:
```python
with lock:
    # código seguro
```
```java
synchronized (obj) {
    // código seguro
}
```

4. **Evita erros de ordem** (tipo Signal antes de Wait)

---

## 🧰 Exemplo prático: sincronizar tarefas

### Objetivo: só preparar café **depois** de ter comprado o café **e** a xícara

```cpp
Semaphore temCafe = 0;
Semaphore temXicara = 0;
```

### Threads:

🔹 **Thread A**: Comprar café
```cpp
// comprar café
temCafe.Signal();
```

🔹 **Thread B**: Comprar xícara
```cpp
// comprar xícara
temXicara.Signal();
```

🔹 **Thread C**: Preparar café
```cpp
temCafe.Wait();     // espera café
temXicara.Wait();   // espera xícara
// preparar café
```

### 🧠 Conclusão:

| Thread         | O que faz             | Quando pode rodar                  |
|----------------|------------------------|-------------------------------------|
| Comprar Café   | `temCafe.Signal()`     | A qualquer momento                 |
| Comprar Xícara | `temXicara.Signal()`   | A qualquer momento                 |
| Preparar Café  | `Wait()` nos dois      | Só depois dos dois Signal()        |

---

## ❓ E se não souber a ordem das execuções?

👉 O escalonador do sistema é imprevisível. Você **não consegue garantir manualmente** quem roda primeiro.

### ✅ Semáforo resolve:

```cpp
temCafe.Wait();    // C espera A
temXicara.Wait();  // C espera B
```

- Se C rodar antes de A ou B → **bloqueia**
- Quando A faz `Signal()`, libera `temCafe`
- Quando B faz `Signal()`, libera `temXicara`
- C só continua quando ambos forem liberados

---

### 🧪 Exemplo de output:

```text
[Thread C] esperando café...
[Thread A] comprou café
[Thread C] esperando xícara...
[Thread B] comprou xícara
[Thread C] preparando café!
```

---
