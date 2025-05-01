## 💾 O que é **Swap**?

**Swap** é uma técnica em que o sistema operacional **move um processo da memória RAM para o disco rígido (HD ou SSD)**, liberando espaço na RAM para outros processos.

- Quando o processo for necessário novamente, ele é **recarregado na memória**.

---

## 🧠 Por que o swap é usado?

- Porque a **memória RAM é limitada**.
- Quando muitos processos estão ativos ao mesmo tempo e **não há RAM suficiente**, o sistema pode "trocar" processos menos usados para o disco, **liberando memória para outros processos** mais urgentes.

---

## 🔁 Comportamento com diferentes tipos de relocação:

### 🧱 **Relocação Estática**
- O processo **deve voltar exatamente para o mesmo lugar da memória**.
- Se aquele espaço estiver ocupado, o SO **tem que esperar ou mover outros processos**, o que complica e **exige mais tempo e recursos**.

### 🧊 **Relocação Dinâmica**
- O SO **pode carregar o processo em qualquer lugar livre da memória**.
- Basta atualizar os registradores de **base e limite** com a nova posição.
- **Muito mais flexível** e eficiente para usar junto com swap.

---

## ⏱️ Swap e Escalonamento de CPU

- O escalonador da CPU precisa escolher **processos prontos para executar**.
- Se um processo está no **disco (em swap)**, ele **não pode ser executado imediatamente**.
- Resultado: o **swap atrasa o escalonamento**, porque **tem que recarregar o processo antes que ele rode**.

Isso causa **latência** (demora) e pode **degradar o desempenho do sistema** se usado em excesso.

---

## 🧹 Compactar só quando um processo sair do swap?

Sim! A ideia é:

- Só realizar a **compactação** (mover processos para juntar espaço) **quando um processo vindo do disco (swap)** precisa entrar na memória e **não há espaço contíguo suficiente**.
- Como **compactar é uma operação cara** (demorada), o SO **evita fazer isso o tempo todo**.

---

## 🧠 Resumo didático:

| Conceito                        | Explicação simples                                                                 |
|--------------------------------|------------------------------------------------------------------------------------|
| **Swap**                       | Processo vai para o disco para liberar memória.                                   |
| **Retorno do swap**            | Processo volta para a RAM quando precisa ser executado.                           |
| **Relocação Estática**         | Processo só pode voltar para o mesmo lugar.                                       |
| **Relocação Dinâmica**         | Processo pode voltar para qualquer lugar, desde que atualize os registradores.    |
| **Impacto no escalonamento**   | Swap atrasa a escolha de processos prontos, pois precisa recarregar da memória.   |
| **Quando compactar?**          | Apenas quando for necessário para permitir o retorno de um processo do swap.      |

