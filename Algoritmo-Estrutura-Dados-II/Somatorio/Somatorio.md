# **📌 Propriedades do Somatório (∑)**  

### **1️⃣ Definição e Motivação**  
- O **somatório (∑)** é uma **forma abreviada de escrever a soma de uma sequência de termos**.  
- Utilizado na **análise de algoritmos** para calcular o **custo total de operações**.  

---

## **📌 2. Principais Propriedades do Somatório**  

### **1. Distributividade**  
- Permite **mover constantes para dentro ou para fora** do somatório.  
- **Fórmula:**  
  \[
  \sum c \cdot a_i = c \cdot \sum a_i
  \]
- **Exemplo:**  
  \[
  3(1 + 2 + 3) = (3 \cdot 1) + (3 \cdot 2) + (3 \cdot 3)
  \]

---

### **2. Associatividade**  
- Permite **decompor um somatório em partes menores** ou **combinar somatórios**.  
- **Fórmula:**  
  \[
  \sum (a_i + b_i) = \sum a_i + \sum b_i
  \]
- **Exemplo:**  
  \[
  (1 + 2 + 3) + (4 + 5 + 6) = (1 + 4) + (2 + 5) + (3 + 6)
  \]

---

### **3. Comutatividade**  
- Permite **reorganizar os termos dentro do somatório** sem alterar o resultado.  
- **Fórmula:**  
  \[
  \sum a_i = \sum a_{p(i)}
  \]
  Onde `p(i)` representa uma permutação dos índices.  
- **Exemplo:**  
  \[
  1 + 2 + 3 = 3 + 2 + 1
  \]

---

### **4. Propriedades da Soma de Índices**  
- **Soma dos `n` primeiros inteiros:**  
  \[
  \sum_{i=1}^{n} i = \frac{n(n+1)}{2}
  \]
- **Soma dos primeiros `n` quadrados:**  
  \[
  \sum_{i=1}^{n} i^2 = \frac{n(n+1)(2n+1)}{6}
  \]

---

### **5. Aplicação em Algoritmos**  
- **Exemplo:** Cálculo do número de comparações no **Selection Sort**.  
  \[
  \sum_{i=0}^{n-2} (n - i - 1) = \frac{n(n-1)}{2} \quad \Rightarrow O(n^2)
  \]
- Isso explica porque **Selection Sort é ineficiente para grandes listas**.

---

## **📌 3. Conclusão**
- **Somatórios são essenciais para estimar o desempenho dos algoritmos.**  
- Suas propriedades ajudam **a simplificar cálculos e obter fórmulas fechadas**.  
- **Compreender essas propriedades melhora a análise de eficiência de algoritmos.** 🚀