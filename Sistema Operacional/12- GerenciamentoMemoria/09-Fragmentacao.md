## 🧩 **Fragmentação Externa**

### 💡 O que é?
É quando **existe memória suficiente no total para um processo**, mas **ela está dividida em pedaços pequenos e separados**, então o processo **não consegue caber inteiro em nenhum desses pedaços**.

### 🧠 Por que isso acontece?
- Com o tempo, processos são **carregados e removidos** da memória.
- Isso deixa **"buracos" (fragmentos)** entre os processos ativos.
- Esses buracos **não são reaproveitados com eficiência**, porque são pequenos demais ou estão separados.

### 📉 Consequência:
Mesmo tendo memória livre, o sistema **não consegue alocar novos processos** grandes porque **nenhum buraco isolado é grande o suficiente**.

---

### 📏 **Regra de 50%**
- Estatística comum: para cada **2 blocos alocados**, **1 bloco se perde** em fragmentos pequenos.
- Em outras palavras: cerca de **1/3 da memória pode ficar desperdiçada** por fragmentação externa.

---

## 🔒 **Fragmentação Interna**

### 💡 O que é?
É quando **um processo ocupa um bloco maior do que precisa**, e **o espaço "sobrando" dentro do bloco não pode ser usado** por outro processo.

### 🧠 Exemplo:
- Suponha um processo que usa **8846 bytes**.
- Ele é colocado num bloco de **8848 bytes** (porque não existe um bloco menor disponível).
- Os **2 bytes que sobraram** dentro do bloco **ficam inutilizados** → isso é fragmentação interna.

---

## 🧠 Comparação rápida:

| Tipo de Fragmentação | Onde ocorre?                       | Por que ocorre?                                      | Exemplo simples                           |
|----------------------|------------------------------------|------------------------------------------------------|-------------------------------------------|
| **Externa**          | **Entre** blocos de memória        | Espaços pequenos e separados após remoção de processos | 3 blocos livres de 2KB, 3KB e 1KB — nenhum cabe um processo de 5KB |
| **Interna**          | **Dentro** de um bloco alocado     | Processo ocupa menos que o espaço reservado           | Processo de 8846B num bloco de 8848B      |

---

## 🎯 O que o sistema operacional quer?
Reduzir **ao máximo** ambos os tipos de fragmentação. Para isso, mais pra frente, técnicas como **paginação** e **segmentação** são usadas — justamente para evitar ou minimizar esses problemas.

---
