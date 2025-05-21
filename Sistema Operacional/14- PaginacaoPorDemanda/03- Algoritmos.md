## 📌 1. **FIFO (First-In, First-Out)**

### ✔️ **Como funciona:**

Remove a página que está na memória há mais tempo, ou seja, a primeira que entrou.

### ✅ **Vantagens:**

* Fácil de implementar.
* Não requer monitoramento constante de uso das páginas.

### ❌ **Desvantagens:**

* Pode remover páginas ainda muito usadas ("páginas quentes").
* Sofre da **Anomalia de Belady**: **adicionar mais memória pode aumentar o número de page faults**, o que é contraintuitivo.

---

## 📌 2. **Aleatório**

### ✔️ **Como funciona:**

Remove uma página qualquer, escolhida aleatoriamente.

### ✅ **Vantagens:**

* Fácil de implementar.
* Surpreendentemente, tem desempenho razoável em alguns casos.

### ❌ **Desvantagens:**

* Pode remover páginas importantes.
* Não usa nenhuma informação sobre o comportamento do processo.

---

## 📌 3. **MIN (Ótimo ou OPT)**

### ✔️ **Como funciona:**

Remove a página que **será usada mais longe no futuro** (ou que **não será mais usada**).

### ✅ **Vantagens:**

* Melhor desempenho teórico possível (menor número de page faults).
* Serve como benchmark para comparar outros algoritmos.

### ❌ **Desvantagens:**

* **Impraticável na prática**, pois o sistema **não sabe o futuro**.

---

## 📌 4. **LRU (Least Recently Used)**

### ✔️ **Como funciona:**

Remove a página que **não foi usada há mais tempo**, assumindo que **se não foi usada recentemente, é menos provável que seja usada em breve**.

### ✅ **Vantagens:**

* Boa aproximação do MIN.
* Tem ótimo desempenho **se o comportamento passado for bom indicador do futuro**.
* **Não sofre da anomalia de Belady** — mais memória sempre ajuda.

### ❌ **Desvantagens:**

* **Mais complexo de implementar** (precisa rastrear o uso das páginas).
* Pode ter sobrecarga extra para manter essa informação atualizada.

---

## 🔁 Resumo comparativo

| Algoritmo | Vantagens                                    | Desvantagens                                            |
| --------- | -------------------------------------------- | ------------------------------------------------------- |
| FIFO      | Simples, fácil de implementar                | Pode remover páginas úteis, sofre da Anomalia de Belady |
| Aleatório | Simples, bom desempenho ocasional            | Não usa lógica do uso das páginas                       |
| MIN       | Desempenho ótimo                             | Não pode ser usado na prática                           |
| LRU       | Bom desempenho prático, aproximação do ótimo | Mais caro de implementar, exige controle do histórico   |

---

