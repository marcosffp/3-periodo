### ⚙️ O que são “endereços” no contexto de memória?

Quando um programa é executado, ele precisa acessar **instruções** e **dados** que estão armazenados na memória. Cada posição na memória tem um **endereço**, como se fosse o número de uma casa numa rua.

Agora, a grande pergunta é: **como o programa sabe qual endereço usar?** É aqui que entram as **3 abordagens** de geração de endereços:

---

## 🧱 1. **Tempo de compilação** (endereço fixo)
**Analogia:** imagine que você vai construir uma casa e o engenheiro já te dá a planta dizendo “essa casa vai ficar exatamente no lote 100 da rua A”. Sem margem pra mudança.

- O **compilador** (ferramenta que transforma seu código em algo que o computador entende) já define os endereços exatos com base em uma posição fixa, tipo "comece no endereço 1000".
- Quando o programa é carregado, ele **sempre** vai para o mesmo lugar da memória.
- O **sistema operacional não faz nada** quanto à posição do processo.

👉 **Problema:** se outro programa quiser usar o mesmo espaço, vai dar conflito.

---

## 🛠️ 2. **Tempo de carregamento** (endereço estático, mas flexível)
**Analogia:** você constrói uma casa modular e, na hora da mudança, o caminhão decide onde no lote do condomínio ela será montada. Mas depois que foi colocada lá, não muda mais.

- O **compilador** gera endereços **relativos** (ex: “comece do início do lote”).
- O **sistema operacional**, na hora de carregar o processo na memória, escolhe onde ele vai começar.
- Esses endereços são **ajustados** para a posição real no momento do carregamento.
- Depois disso, o processo **não pode mais se mover** na memória.

👉 Mais flexível que o anterior, mas ainda com limitações.

---

## 🧳 3. **Tempo de execução** (endereços virtuais)
**Analogia:** você viaja com seu GPS usando endereços virtuais. Não importa onde a cidade real colocou as ruas — o GPS traduz o que você vê para o que realmente está lá.

- O compilador usa **endereços virtuais**.
- O **sistema operacional + hardware (MMU)** traduz esses endereços para **endereços físicos reais** conforme necessário.
- Isso permite mover o processo de lugar durante a execução, criar memória virtual, etc.

👉 **Super flexível!** Essa é a base da **memória virtual** moderna.

---

### 🌐 Resumindo:
| Abordagem               | Endereço Gerado         | Papel do SO                 | Flexibilidade |
|------------------------|-------------------------|-----------------------------|---------------|
| Tempo de compilação    | Físico fixo             | Nenhum                      | Nenhuma       |
| Tempo de carregamento  | Relativo (ajustado na hora) | Define onde o processo vai | Média         |
| Tempo de execução      | Virtual (traduzido em tempo real) | Traduz e realoca          | Alta          |

