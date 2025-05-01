### 💡 **O que é “relocação”?**

Relocação é o processo de **ajustar os endereços de memória de um programa** dependendo de onde ele for carregado na RAM. Isso é necessário porque, com **vários processos em execução**, não dá pra garantir que todos começarão no endereço 0 da memória.

---

### 📍 Parte 1: "Coloque o SO na memória mais alta"

**Analogia:** imagine a memória como um prédio. O **sistema operacional mora sempre nos andares de cima** (endereços mais altos) e deixa os andares de baixo para os hóspedes (os processos).

Isso garante que:
- O SO fica isolado e protegido.
- O espaço restante pode ser alocado para os processos dos usuários.

---

### 📍 Parte 2: "Em tempo de compilação/ligação o processo começa em 0..."

O código do programa **foi feito para começar no endereço 0**, pois o compilador não sabe ainda onde ele será colocado na memória.

Mas...

---

### 📍 Parte 3: "Novo processo é carregado alocando um segmento contíguo de memória no qual o processo cabe"

No momento de carregar o processo, o sistema operacional escolhe **um lugar livre da RAM** que seja grande o suficiente e o coloca lá **todo de uma vez (contíguo)**.

---

### 📍 Parte 4: "Endereço base e endereço limite"

- **Endereço base** = onde o processo *realmente* começa na memória.
- **Endereço limite** = até onde ele pode acessar.

👉 Isso cria um “cercadinho” para o processo. Ele só pode acessar a memória dentro dessa faixa.

---

### 📍 Relocação Estática

Aqui o nome do jogo é: **ajustar endereços uma única vez no carregamento**.

**Como funciona:**
1. O código foi feito pra começar no 0.
2. O SO decide que ele vai ficar, por exemplo, no endereço 2000.
3. O SO **soma 2000 a todos os endereços** do processo (durante o carregamento).
4. Pronto! O processo agora roda como se tivesse começado em 0, mas na prática está rodando a partir do endereço 2000.

---

### ⚠️ *"Uma vez que o processo é atribuído a um lugar na memória e começa a executar, o SO não pode movê-lo."*

**Por quê?**

Porque **os endereços já foram todos ajustados**. Se mover o processo, **tudo quebraria**, pois os endereços dentro dele apontariam para lugares errados da RAM.

---

### 🎯 Resumo visual:

| Conceito                | Explicação                                                                 |
|------------------------|----------------------------------------------------------------------------|
| **Relocação Estática** | Ajuste fixo de endereços na hora do carregamento                          |
| **Base/Limite**        | Faixa permitida de acesso para o processo                                 |
| **SO na memória alta** | Protege o sistema e separa memória para processos                         |
| **Não pode mover depois** | Porque os endereços já foram "traduzidos" para o local original carregado |

---
