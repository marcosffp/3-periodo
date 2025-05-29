## 📌 **1. O que é um Diagrama de Atividades?**

É um diagrama UML que **modela fluxos de processos ou algoritmos**, mostrando a sequência de ações, decisões e paralelismos em um sistema. Foca nos aspectos **dinâmicos** e é especialmente útil para representar **regras de negócio complexas**.

### ✅ **Finalidade**:
- Detalhar processos de negócio.
- Representar fluxos de trabalho (workflows).
- Complementar casos de uso com visão de fluxo.
- Facilitar a comunicação entre técnicos e usuários.

> **Exemplo**: Fluxo de aprovação de um empréstimo bancário, desde a solicitação até a liberação.

---

## 🔍 **2. Componentes Principais**

| Elemento               | Descrição                                                                 | Símbolo/Exemplo                          |
|------------------------|---------------------------------------------------------------------------|------------------------------------------|
| **Estado Inicial**     | Ponto de partida do fluxo.                                               | ⚫ (Círculo preto sólido)                |
| **Ação/Atividade**     | Passo do processo (representado por verbo no infinitivo).                | "Verificar limite de crédito"            |
| **Decisão (Ramificação)** | Ponto com múltiplas saídas condicionais (usando `[condição]`).          | `[saldo >= valor]` → "Aprovar" ou "Negar" |
| **Barra de Sincronização** | Inicia (bifurcação) ou finaliza (junção) fluxos paralelos.              | ─┃━ (Barra grossa horizontal)           |
| **Raia (Swim Lane)**   | Divide atividades por responsável (ex: departamento, ator).              | Colunas com títulos como "Cliente", "Sistema" |
| **Estado Final**       | Fim do processo (pode haver múltiplos).                                  | ⚪◎ (Círculo com ponto interno)          |

---

## 🔄 **3. Tipos de Fluxos**

### 🔸 **Sequencial**
- Ações executadas em ordem linear.
- **Exemplo**:  
  `Cadastrar cliente → Validar CPF → Salvar dados`.

### 🔸 **Condicional (Ramificação)**
- Usa **pontos de decisão** com condições.  
  - **Regra**: Apenas um caminho é seguido.  
  - `[else]` cobre casos não previstos.  

> **Exemplo**:  
> ```
> [nota >= 7] → "Aprovar aluno"  
> [else] → "Exigir prova final"
> ```

### 🔸 **Paralelo**
- Ações simultâneas iniciadas por uma **barra de bifurcação** e sincronizadas por uma **barra de junção**.  
- **Exemplo**:  
  ```
  Bifurcação → "Emitir boleto" (fluxo 1)  
             → "Enviar e-mail" (fluxo 2)  
  Junção (ambos devem concluir) → "Finalizar venda"
  ```

---

## 🏊 **4. Raias de Natação (Swim Lanes)**
Divide o diagrama por **agentes responsáveis**, clarificando quem executa cada ação.

### 🧩 **Exemplo Prático**:
| **Seguradora**       | **Oficina**          | **Segurado**         |
|-----------------------|----------------------|----------------------|
| "Avaliar danos"       | "Consertar veículo"  | "Acionar seguro"     |
| "Depositar indenização" | "Cobrar franquia"   | "Pagar franquia"     |

---

## 🛠️ **5. Quando Usar?**
- **Detalhar casos de uso**: Ex: Fluxo alternativo de "Esqueci minha senha".  
- **Processos com paralelismo**: Ex: Sistema de pagamento que atualiza estoque e envia notificação ao mesmo tempo.  
- **Regras complexas**: Ex: Cálculo de média escolar com múltiplas condições (`[faltas > 25%] → "Reprovar"`).

> **Atenção**: Não substitui a descrição textual de casos de uso, mas a complementa!

---

## 📝 **6. Exemplo Completo: Inscrição em Disciplina**

```mermaid
flowchart TD
    A[⚫ Estado Inicial] --> B[Verificar limite de inscrições]
    B --> C{[dentro do limite?]}
    C -->|Sim| D[Inscrever aluno]
    C -->|Não| E[Adicionar à lista de espera]
    D --> F[Informar sistema de pagamento]
    E --> G[Notificar aluno sobre lista]
    F --> H[⚪ Estado Final]
    G --> H
```

**Condições**:  
- `[dentro do limite]`: Vagas disponíveis.  
- `[else]`: Lista de espera.  

---

## 🧠 **7. Dicas de Modelagem**
1. **Verbos no infinitivo**: "Calcular média", não "Cálculo da média".  
2. **Evite loops infinitos**: Se não há estado final, deixe claro que o processo é cíclico (ex: "Monitorar temperatura").  
3. **Use raias** para processos multi-atores (ex: "Cliente", "Sistema", "Backoffice").  

---

## ⚠️ **8. Armadilhas Comuns**
- **Sobrecarregar o diagrama**: Muitas decisões paralelas podem torná-lo ilegível.  
- **Condições ambíguas**: Evite `[sistema rápido]`; prefira `[tempo < 2 segundos]`.  

---
