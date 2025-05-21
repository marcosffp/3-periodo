## 🧩 **1. Bit de Validade (v):**

* Cada entrada da **TLB** e da **tabela de páginas** tem um **bit de validade (v)**.
* Esse bit indica se a entrada é **válida (v = 1)** ou **inválida (v = 0)**.
* Quando `v = 0`, significa que:

  * A entrada **não deve ser usada**.
  * Pode estar **desatualizada** ou ser de **outro processo**.
* Isso é essencial porque:

  * **Dois processos diferentes** podem estar usando a **mesma página virtual (ex: página 5)**, mas com **conteúdo totalmente diferente**.
  * A validade garante que um processo **não leia dados incorretos de outro**.

---

## 📊 **2. Regra dos 90/10 (localidade):**

* Essa é uma observação prática do comportamento dos programas:

  > **90% dos acessos à memória ocorrem em apenas 10% do código/dados.**
* A TLB se aproveita disso:

  * Mesmo sendo pequena, **armazena as traduções mais acessadas**.
  * Isso garante **alta taxa de acertos (TLB Hit)**, mesmo com alguns erros (misses).
  * Resultado: **alto desempenho com baixo custo**.

---

## 💸 **3. Custo de acessar memória sem e com TLB:**

### 📍 **Sem TLB:**

* Cada acesso à memória **virtual** precisa:

  1. Consultar a tabela de páginas (na memória).
  2. Depois acessar o dado (também na memória).
* Isso custa:

  ```
  custo_efetivo = 2 * ma (ma = tempo de acesso à memória)
  ```

### 📍 **Com TLB:**

* Se for **TLB Hit**:

  * Só precisa acessar a memória real (TLB já fornece a tradução).
  * Custo: `ma + TLB` (tempo de consultar a TLB + memória).
* Se for **TLB Miss**:

  * Consulta à TLB falha → consulta à tabela de páginas → depois memória.
  * Custo: `2 * ma + TLB`

### ✅ **Fórmula do custo efetivo com TLB:**

```math
Custo_efetivo = (ma + TLB) * p + (2 * ma + TLB) * (1 - p)
```

* **p**: taxa de acerto da TLB (TLB Hit rate).
* Se `p` for alto (por exemplo, 0.95), o custo médio fica **bem menor**.

---

## 🧠 **4. Inicialização da memória de um processo:**

Quando um novo processo começa:

1. Ele **pede k páginas** para começar a executar.
2. Se houver **k quadros livres**, o SO aloca diretamente.

   * Se **não houver**, ele precisa **liberar quadros** de outros processos (swap, por exemplo).
3. Cada página é colocada em um quadro físico.
4. A tabela de páginas do processo é **preenchida com essas traduções**.
5. A TLB é **limpa/inicializada** (todas as entradas ficam inválidas).
6. A execução do processo começa normalmente.
7. À medida que o processo acessa páginas, a TLB vai sendo **preenchida dinamicamente**.

---

## 🔁 **5. Troca de Contexto e TLB:**

Quando o sistema troca entre dois processos (context switch):

1. O sistema **salva**:

   * Registrador da tabela de páginas.
   * (Opcionalmente) as entradas da TLB, copiando para o PCB (Bloco de Controle do Processo).
2. A **TLB é limpa** (para evitar uso de dados de outro processo).
3. O sistema carrega o novo processo:

   * Restaura o registrador da tabela de páginas.
   * (Se tiver sido salva) restaura a TLB com as entradas anteriores.

Essa troca é **crítica para segurança e consistência**, pois garante que o processo novo **não use entradas da TLB do anterior**.

---

## 🧱 **6. Paginação em Níveis:**

* Quando o **espaço de endereçamento virtual é muito grande**, a tabela de páginas pode **ficar imensa**.
* Para isso, sistemas operacionais usam **paginação em múltiplos níveis**:

  * Ao invés de uma tabela única, você tem **várias tabelas menores** encadeadas.
  * Isso **economiza memória** e é mais eficiente.
* Exemplo: sistemas de 64 bits geralmente usam **4 níveis de paginação**.

---

