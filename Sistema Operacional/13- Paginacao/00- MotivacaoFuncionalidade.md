### 📌 **1. Regra 90/10**

> **"Processos gastam 90% do tempo acessando 10% do seu espaço na memória."**

Isso significa que, mesmo que um programa (processo) tenha muitos dados e instruções, ele normalmente usa **só uma pequena parte disso o tempo todo**.
➡️ **Então, não faz sentido carregar o processo inteiro na memória.** Carregamos **só as partes necessárias (as páginas em uso)**.

---

### 📌 **2. "Mantenha apenas as partes de um processo na memória que estão sendo realmente utilizadas."**

Isso reforça a ideia da regra acima. Para **economizar memória** e **aumentar a eficiência**, o SO carrega só o que é essencial naquele momento — o resto pode ficar guardado no disco e ser trazido conforme necessário.

---

### 📌 **3. "Páginas simplificam o problema de ajuste de fragmentos."**

Sem paginação, é difícil encontrar "buracos" (espaços vazios) na memória para alocar processos. Com a **memória dividida em páginas fixas**, você pode **encaixar cada parte do processo em qualquer lugar livre**, facilitando o gerenciamento.

---

### 📌 **4. "A memória lógica (virtual) do processo é contígua, mas as páginas não precisam ser alocadas contiguamente na memória."**

Do ponto de vista do programa, tudo parece estar junto (endereços 0, 1, 2, ...).
Mas, na realidade, o SO **espalha as páginas do processo pela memória física onde tiver espaço disponível**.
Essa abstração é o que a paginação permite.

---

### 📌 **5. "Dividindo a memória em páginas de tamanho fixo, podemos eliminar a fragmentação externa."**

**Fragmentação externa** é quando sobram pequenos espaços entre os blocos de memória que não servem pra nada.
Com páginas do **mesmo tamanho fixo**, isso **não acontece mais**, porque os espaços são sempre do mesmo tamanho.

---

### 📌 **6. "A paginação não elimina a fragmentação interna (1/2 página por processo, em média)."**

**Fragmentação interna** é quando uma página não é completamente usada.
Exemplo: se a página tem 4 KB e você só precisa de 3,5 KB, **0,5 KB fica desperdiçado**.
➡️ Em média, se perde **meia página por processo** por causa disso.

---

### 📌 **7. Qual o papel do SO (Sistema Operacional)?**

O SO tem dois papéis principais com a paginação:

#### a) **Gerenciar a tabela de páginas**

* Cada processo tem uma tabela de páginas que **liga o endereço lógico (virtual)** ao **endereço real (físico)** na memória.
* O SO mantém essa tabela atualizada.

#### b) **Traduzir endereços**

* Sempre que o processo acessa um endereço virtual, o SO (junto com o hardware de paginação) **converte esse endereço para o endereço físico** correspondente.

---
