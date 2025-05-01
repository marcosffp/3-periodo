### 🔧 **Engenharia de Requisitos – Etapas**
O processo de requisitos envolve quatro grandes etapas:
1. **Elicitação**
2. **Modelagem**
3. **Verificação**
4. **Validação**

---

### 🧠 **Modelagem de Requisitos**
A modelagem serve para **representar, organizar e armazenar os requisitos** identificados na elicitação. Um modelo ajuda a entender o sistema e a se comunicar melhor com todas as partes envolvidas.

> **Exemplo:** em vez de apenas anotar que o sistema deve “permitir reservas”, podemos criar um **caso de uso "Reservar Livro"** ligado ao ator “Usuário”.

---

### 🧾 **Documentação de Requisitos**
A documentação transforma o que foi modelado em algo compreensível e reutilizável. Existem várias formas:

#### 1. **Análise Estruturada**
Foca no **fluxo de informações** e controle:
- **Diagramas de Fluxo de Dados (DFDs)**
- **Diagrama de Transição de Estado (DTE)**
- **Dicionário de Dados**

> **Exemplo:** um DFD pode mostrar o caminho de uma requisição de empréstimo de livro, desde o pedido do usuário até o banco de dados.

#### 2. **Análise Orientada a Objetos**
Foca nos **conceitos do domínio** (objetos) e seus comportamentos:
- **Casos de Uso**
- **Diagramas de Atividade**
- **Máquinas de Estado**

> **Exemplo:** no sistema de biblioteca, objetos como “Livro”, “Usuário” e “Reserva” se relacionam com ações específicas.

#### 3. **Linguagem Natural**
Forma mais comum, mas suscetível a ambiguidade.

> Vantagem: todos entendem.  
> Desvantagem: interpretações dúbias.

#### 4. **Modelos Conceituais (como Casos de Uso)**
- Baseado na interação usuário ↔ sistema
- Muito usados para **organizar requisitos em unidades lógicas**
  
> **Exemplo:** "Reservar Livro" é um caso de uso que ajuda a agrupar funcionalidades relacionadas à reserva.

#### 5. **Manual do Usuário como Especificação**
Usa tutoriais, glossários e referências funcionais como forma de documentar o sistema.

> **Exemplo:** além de explicar como usar o sistema, o manual define requisitos funcionais (“clique aqui para reservar um livro”).

---

### 🌐 **Visão Geral do Sistema (Contexto)**
Define os **limites do sistema** e quem interage com ele (atores externos). Uma má definição de contexto leva a **requisitos incompletos** ou **erros não detectados**.

> **Exemplo visual:** um diagrama onde o sistema está no centro e atores como “Usuário”, “Sistema de Pagamento” e “Biblioteca Externa” estão conectados por linhas de comunicação.

---

### 🎭 **Diagramas de Casos de Uso**
Esses diagramas mostram:
- **Atores**: usuários, máquinas, outros sistemas
- **Casos de Uso**: ações que o sistema realiza
- **Relacionamentos**: como os atores interagem com o sistema

> **Exemplo:**  
> - Ator: *Usuário*  
> - Caso de Uso: *Reservar Livro*  
> - Conexão: linha entre o ator e o caso de uso

---

### 🧍 **O que é um Ator?**
- Representa **papéis** (não pessoas específicas).
- Pode ser uma **pessoa, organização, outro sistema ou equipamento**.

> **Exemplo:** “João” pode ser um **Gerente** e também um **Correntista** – dois papéis (dois atores).

#### 🛠️ **Categorias de Atores**:
- Pessoas: Ex. Correntista
- Organizações: Ex. Agência de Impostos
- Sistemas: Ex. Sistema de Estoque
- Equipamentos: Ex. Sensor de Presença

---

### 🎯 **Por que Identificar Atores?**
- Ajuda a **definir o contexto**
- Mostra **quem interage** com o sistema e **por que**
- Direciona o levantamento completo dos requisitos

> **Exemplo prático de perguntas para identificar atores:**
- Quem vai usar o sistema?
- O sistema precisa informar alguém?
- Precisa de dados de outro sistema?

---
