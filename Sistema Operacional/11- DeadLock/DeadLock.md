
# 🌐 Deadlock: Conceitos, Análise e Soluções

## 🧠 O que é Deadlock?

Deadlock ocorre quando **um conjunto de processos fica permanentemente bloqueado**, esperando por recursos que nunca serão liberados, pois estão sendo segurados por outros processos também em espera.

---

## 📊 Grafo de Alocação de Recursos

### Componentes:

- **P** = Processo (nó circular)
- **R** = Recurso (nó quadrado)
- **Aresta P → R**: o processo **solicitou** o recurso.
- **Aresta R → P**: o recurso **foi alocado** ao processo.

### Ciclos:

- **Instância única por recurso**:
  - Um **ciclo** no grafo implica **deadlock**.
- **Múltiplas instâncias por recurso**:
  - Um **ciclo pode ou não** significar deadlock.
  - É necessário um **algoritmo de detecção** mais elaborado (ex: variação do algoritmo de segurança de Banker).

---

## 🧱 Condições de Coffman (necessárias para deadlock)

1. **Mutual Exclusion (Exclusão Mútua)**  
   Recursos não compartilháveis.
2. **Hold and Wait (Espera por Recursos)**  
   Processo segura recursos enquanto espera por outros.
3. **No Preemption (Não-preempção)**  
   Recursos só são liberados voluntariamente.
4. **Circular Wait (Espera Circular)**  
   Existe uma cadeia circular de processos, cada um esperando por um recurso do próximo.

### 🎯 Dica de Prova:
> Deadlock **só ocorre se as 4 condições estiverem presentes simultaneamente**. Prevenir **uma** delas já evita o deadlock.

---

## 🚫 Estratégias de Prevenção

### 1. Eliminar *Hold and Wait*:
- Exigir que processos requisitem **todos os recursos de uma vez**.
- Contras: **baixa utilização** de recursos.

### 2. Eliminar *No Preemption*:
- Permitir que o sistema **force liberação** de recursos (preempção).
- Ex: suspender processo e realocar seus recursos.

### 3. Eliminar *Circular Wait*:
- Impor **ordem numérica** global para requisição de recursos.
- Processo só pode requisitar recurso de número maior que os que já possui.

---

## 🔍 Estratégias de Detecção

### Para múltiplas instâncias:
- Versão modificada do algoritmo do **banqueiro de Dijkstra**.
- Entrada: estado atual de alocação, requisições pendentes e recursos disponíveis.
- Saída: conjunto de processos que **podem terminar** (safe), e aqueles que **não podem** (em deadlock).

### Exemplo de detecção (pseudo):

```plaintext
Available = [3, 2, 2]
Allocation = [
  [0, 1, 0],  // P0
  [2, 0, 0],  // P1
  ...
]
Need = [
  [7, 4, 3],  // P0
  [1, 2, 2],  // P1
  ...
]
```

Algoritmo simula liberação de recursos e verifica se todos os processos podem finalizar. Se algum ficar para trás com necessidades não atendíveis, está em **deadlock**.

---

## ♻️ Recuperação de Deadlock

1. **Abortar processos**
   - Todos os envolvidos.
   - Um por vez, até sair do deadlock.

2. **Preempção de recursos**
   - Forçar liberação.
   - Requer rollback e tratamento de consistência.

3. **Rollback**
   - Voltar processo a um estado seguro anterior.
   - Requer pontos de salvamento (*checkpoints*).

---

## ⚠️ Deadlock vs Starvation

| Característica       | Deadlock                               | Starvation                              |
|----------------------|-----------------------------------------|------------------------------------------|
| Causa                | Espera circular e bloqueio mútuo       | Falta de justiça na alocação (prioridade) |
| Resolução            | Algoritmos específicos de detecção     | Escalonamento justo (ex: aging)           |
| Tempo de espera      | Infinito                               | Infinito (mas ainda com recursos livres)  |

---

## 🧪 Exemplos Clássicos

### 💡 Exemplo 1: Deadlock com instância única

```plaintext
P1 → R1 → P2 → R2 → P1
```

- P1 espera por R1 (alocado a P2), e P2 espera por R2 (alocado a P1).
- **Ciclo detectado** → deadlock.

---

### 💡 Exemplo 2: Vários processos e múltiplas instâncias

- Suponha 5 processos, 3 tipos de recursos (A, B, C).
- Use o algoritmo de detecção (semelhante ao do banqueiro) para identificar se é possível executar todos os processos com os recursos disponíveis.
- Se algum processo **não conseguir recursos mesmo após todas as liberações possíveis**, ele está em **deadlock**.

---

## 🛡️ Estratégia do Banqueiro (Banker's Algorithm)

- **Evita deadlock**.
- Só aprova requisições se o sistema permanecer em **estado seguro**.
- Um estado é **seguro** se existe uma sequência de execução que permite que **todos os processos completem** suas tarefas.

### Passos:
1. Simula a requisição.
2. Verifica se o sistema continua em estado seguro.
3. Se sim, aprova. Se não, nega.

---

## 📝 Dicas Finais para Prova

- **Memorize as 4 condições de Coffman**.
- **Saiba interpretar grafos de alocação** (ciclo = deadlock em instância única).
- Pratique **algoritmos com múltiplas instâncias** (uso de matrizes).
- Saiba diferenciar **prevenção**, **detecção** e **recuperação**.
- Deadlock = bloqueio mútuo permanente.  
  Starvation = processos ignorados por priorização.

