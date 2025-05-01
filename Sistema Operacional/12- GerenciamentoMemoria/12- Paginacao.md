## 📦 **Paginação: motivação e funcionalidades**

Paginação é uma técnica de gerenciamento de memória que resolve vários problemas da **alocação contígua**, especialmente a **fragmentação externa**.

---

### 📌 **1. Regra 90/10**

> “Processos gastam 90% do tempo acessando 10% do seu espaço na memória”

Isso significa que, em geral, **a maior parte do tempo o processo usa apenas uma pequena parte da memória** que ele pediu. Essa parte ativa é chamada de **conjunto de trabalho**.

✅ **Conclusão**: só precisamos **manter na RAM as partes que estão realmente sendo usadas**, e o resto pode ficar no disco (swap). A paginação torna isso possível.

---

### 📌 **2. Páginas ajudam com fragmentação**

> “Páginas simplificam o problema de ajuste de fragmentos”

- A memória é dividida em **blocos de tamanho fixo**, chamados de **páginas** (na memória virtual) e **molduras (frames)** (na memória física).
- Como são fixos, **não existe fragmentação externa** (não sobra espaço entre os blocos).
  
📌 Fragmentação externa = resolvida!

---

### 📌 **3. Memória virtual é contígua, mas física não precisa ser**

> “A memória lógica (virtual) do processo é contígua, mas as páginas não precisam ser alocadas contiguamente na memória”

- Para o **programa**, parece que ele tem uma memória contínua (ex: de 0 a 1000).
- Mas na realidade, **essas partes estão espalhadas pela memória física**.
- O sistema operacional faz a **tradução de endereços**, ligando os blocos virtuais aos blocos físicos corretos.

---

### 📌 **4. Elimina a fragmentação externa**

> “Dividindo a memória em páginas de tamanho fixo, podemos eliminar a fragmentação externa”

- Como não precisamos encaixar blocos variáveis em buracos irregulares, **não sobra espaço entre os blocos**.
- Cada página cabe certinho num frame.

---

### 📌 **5. Mas ainda há fragmentação interna**

> “A paginação não elimina a fragmentação interna (1/2 página por processo, em média)”

- Como os **últimos bytes de uma página** nem sempre são totalmente usados, pode sobrar espaço **dentro** das páginas.
- Em média, essa perda é de **metade de uma página por processo**.

---

## 🧠 Papel do Sistema Operacional na Paginação

> “Gerenciar a tabela de páginas”  
> “Traduzir endereços das páginas para endereços físicos”

O SO precisa:

- Manter uma **tabela de páginas** para cada processo.
- Quando um processo acessa um endereço virtual, o SO (com ajuda do hardware) **converte esse endereço para o endereço físico correspondente**, usando a tabela.

---

## ⚙️ Hardware de Paginação

> “Como encontrar endereços quando as páginas não estão alocadas contiguamente em memória?”

O hardware usa um componente chamado **MMU (Memory Management Unit)** para:

1. **Dividir o endereço virtual** em:
   - Número da página
   - Deslocamento dentro da página
2. Usar o número da página para **olhar na tabela** e descobrir onde está a moldura correspondente.
3. **Combinar a moldura com o deslocamento** para formar o endereço físico.

---

## 🎯 Resumo:

| Conceito                       | Explicação curta                                                            |
|-------------------------------|-----------------------------------------------------------------------------|
| **Regra 90/10**               | Processos usam só parte da memória, então não precisa carregar tudo.       |
| **Sem fragmentação externa**  | Páginas são do mesmo tamanho, então encaixam direitinho.                   |
| **Com fragmentação interna**  | Parte da última página pode sobrar (em média, ½ página por processo).       |
| **Memória virtual contígua**  | Para o processo, tudo parece contínuo, mesmo que esteja espalhado.         |
| **Papel do SO**               | Gerencia a tabela de páginas e faz a conversão dos endereços.              |
| **Papel do hardware (MMU)**   | Converte endereços virtuais em físicos automaticamente e com rapidez.      |

---
