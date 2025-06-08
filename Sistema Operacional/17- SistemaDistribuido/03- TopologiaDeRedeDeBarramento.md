
# TOPOÇOGIAS DE REDE DE BARRAMENTO
* Todos os nós estão **conectados a um único cabo (barramento)**.
* Esse cabo é **compartilhado** por todos os dispositivos.

## 🚌 1. **Barramento Linear**

### 🔧 O que é:

* Todos os nós estão **conectados a um único cabo compartilhado**.
* Apenas **um nó transmite por vez** (evita colisões).

### ✅ Vantagens:

* **Simples e barato**.
* **Tolerante à falha de nós individuais**.

### ❌ Desvantagens:

* Se o **cabo quebrar**, a rede para.
* Pode ter **colisões de dados**.

### 📌 Era comum em redes Ethernet antigas.

---

## 🚌🔄 2. **Barramento em Anel**

### 🔧 O que é:

* Parecido com barramento linear, **mas em forma circular**.

### ✅ e ❌:

* Mesmo funcionamento, vantagens e desvantagens do barramento linear.
* Apenas muda o formato físico (circular em vez de linear).

---

## ✅ RESUMO VISUAL:

| Topologia                 | Saltos | Custo | Tolerância a falhas         | Uso comum               |
| ------------------------- | ------ | ----- | --------------------------- | ----------------------- |
| Totalmente Conectada      | 1      | Alto  | Alta                        | Raro em prática         |
| Parcialmente Conectada    | Vários | Médio | Baixa (1 falha pode isolar) | WANs, Internet          |
| Árvore                    | Vários | Médio | Baixa                       | Redes corporativas      |
| Estrela                   | 2      | Baixo | Baixa (ponto central)       | LANs                    |
| Anel Unidirecional        | n-1    | Baixo | Baixa                       | Redes simples           |
| Anel Bidirecional         | n/2    | Médio | Média                       | Redes tolerantes        |
| Anel Duplamente Conectado | n/4    | Alto  | Alta                        | Redes de missão crítica |
| Barramento Linear         | 1      | Baixo | Média                       | LANs antigas            |
| Barramento em Anel        | 1      | Baixo | Média                       | Mesma do linear         |

---