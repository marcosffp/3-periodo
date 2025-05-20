# 🧠 RESUMO COMPLETO – TRADUÇÃO DE ENDEREÇOS COM PAGINAÇÃO (ACESSO POR PALAVRA)

---

## 📌 Objetivo do mecanismo de paginação

A **paginação** é uma técnica de gerenciamento de memória que permite que um processo veja a memória como um espaço contíguo, mesmo que os dados estejam **fisicamente dispersos**. Ela:

* Evita **fragmentação externa**
* Permite o uso de mais memória virtual que física (com swap)
* Facilita a realocação de processos

---

## 📐 Parâmetros de arquitetura do exemplo

| Item                    | Valor                    | Explicação                                       |
| ----------------------- | ------------------------ | ------------------------------------------------ |
| Memória física total    | 256 bytes ou 64 palavras | Espaço físico disponível na RAM                  |
| Unidade de acesso       | Palavra (4 bytes)        | A CPU lê/grava palavras, não bytes               |
| Tamanho da página       | 16 bytes = 4 palavras    | Unidades fixas da memória virtual/física         |
| Quantidade de páginas   | 256 ÷ 16 = 16            | 16 páginas virtuais / 16 quadros físicos         |
| Bits para endereçamento | log₂(256) = 8 bits       | 256 posições → 8 bits necessários para endereçar |

---

## 🧱 Estrutura do endereço virtual (com palavras)

O endereço virtual (VA) é dividido em duas partes:

```
[ p | d ]
```

| Parte | Bits | Significado                                                       |
| ----- | ---- | ----------------------------------------------------------------- |
| `p`   | 4    | Número da página virtual (0 a 15)                                 |
| `d`   | 2    | Offset (0 a 3) → posição da palavra na página (4 palavras/página) |

> ⚠️ Neste caso, cada página tem 4 palavras → 2 bits são suficientes para o deslocamento.

---

## 🔢 Etapas para tradução do endereço (VA → PA)

1. **Receber o endereço virtual (VA)**
   Exemplo: VA = 10 (palavra de número 10)

2. **Calcular número da página virtual**

   $$
   \text{página} = \left\lfloor \frac{\text{VA}}{\text{tamanho da página (em palavras)}} \right\rfloor
   $$

   Se página = 4 palavras:

   $$
   \left\lfloor \frac{10}{4} \right\rfloor = 2
   $$

3. **Calcular o deslocamento (offset)**

   $$
   \text{offset} = \text{VA} \mod \text{tamanho da página}
   $$

   $$
   \text{offset} = 10 \mod 4 = 2
   $$

4. **Consultar a Tabela de Páginas (Page Table)**
   Exemplo: Página virtual 2 está no quadro físico 7

5. **Calcular o endereço físico (PA)**

   $$
   \text{PA} = (\text{quadro físico}) \times (\text{palavras por quadro}) + \text{offset}
   $$

   $$
   \text{PA} = 7 \times 4 + 2 = 30
   $$

6. **Representação binária (opcional)**

   * VA (10) → `00001010`

     * Página: `0010`
     * Offset: `10`
   * PA (30) → `00011110`

---

## 🧮 Exemplo completo (usando palavras de 4 bytes)

### Dados:

* Memória física: 256 bytes = 64 palavras
* Tamanho da página: 16 bytes = 4 palavras
* VA (virtual address) = 37 (palavra de número 37)
* Tabela de páginas: página 9 → quadro 4

### Etapas:

1. Página: ⌊37 ÷ 4⌋ = 9
2. Offset: 37 mod 4 = 1
3. Quadro físico da página 9 = 4
4. Endereço físico = 4 × 4 + 1 = **17**
5. VA (binário): `00100101` → página `1001`, offset `01`
6. PA (binário): `00010001`

---

## 🧭 Tabela de páginas de exemplo

| Página virtual | Quadro físico |
| -------------- | ------------- |
| 0              | 2             |
| 1              | 6             |
| 2              | 11            |
| 3              | 9             |
| 9              | 4             |

---

## 📘 Conceitos importantes

| Conceito                          | Aplicação                                                |
| --------------------------------- | -------------------------------------------------------- |
| Memória virtual contígua          | O processo vê os endereços como um bloco contínuo        |
| Mapeamento flexível               | Página 2 pode estar no quadro 11, por exemplo            |
| Fragmentação externa evitada      | Quadros são fixos → sem espaços desperdiçados entre eles |
| Fragmentação interna pode existir | Se nem toda a página for usada                           |
| TLB                               | Acelera a consulta à tabela de páginas                   |
| Page fault                        | Ocorre se a página não estiver na memória física         |

---

## 🧮 Comparativo: byte vs. palavra

| Acesso por... | Exemplo VA | Tamanho da página | Interpretação do VA    |
| ------------- | ---------- | ----------------- | ---------------------- |
| Byte          | 156        | 16 bytes          | VA = número do byte    |
| Palavra (4B)  | 39         | 4 palavras (16B)  | VA = número da palavra |

> Ao trabalhar com **palavras**, todos os endereços (VA, offset, PA) são contados em **palavras**.

---

## ✅ Conclusão

A **tradução de endereços** com paginação (por palavra):

1. **Divide** o endereço virtual em: página + offset
2. **Consulta** a tabela de páginas
3. **Calcula** o endereço físico
4. Pode ser representada em binário para análise de bits
5. É base para técnicas como **memória virtual**, **swap**, e **proteção de processos**

---

