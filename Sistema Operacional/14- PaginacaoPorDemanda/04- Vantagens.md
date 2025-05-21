## ✅ **Resumo — Vantagens da Paginação Sob Demanda**

1. **Endereço virtual maior que o físico**

   * Permite que os programas usem mais memória **virtual** do que a quantidade real de memória **física** disponível.
   * Ideal para rodar processos grandes mesmo com pouca RAM.

2. **Execução parcial na memória**

   * O processo **não precisa estar totalmente carregado** na memória para começar a rodar.
   * Apenas **as páginas necessárias no momento** (ex: código inicial) são carregadas.

3. **Inicialização mais rápida**

   * Como não é necessário carregar tudo de uma vez, o **tempo de inicialização do processo diminui**.

4. **Compartilhamento de memória eficiente**

   * **Páginas comuns** entre processos (ex: bibliotecas compartilhadas) podem ser **usadas por vários processos**, economizando memória.
   * Também **facilita a troca de contexto**, pois menos dados precisam ser movidos.

5. **Melhor desempenho com bom algoritmo de substituição**

   * Se o sistema usar um **algoritmo inteligente para decidir quais páginas manter na memória**, o número de **page faults** (faltas de página) será menor.
   * Isso mantém o desempenho do sistema alto, mesmo com muitos processos ativos.

---

## 📌 O que é **Paginação Sob Demanda**?

É uma técnica em que as **páginas de memória só são carregadas quando realmente são usadas**.

* Exemplo: se uma função no código nunca for chamada, suas páginas **nunca serão carregadas na memória**.
* Isso economiza RAM e **permite que mais processos rodem ao mesmo tempo.**

---

