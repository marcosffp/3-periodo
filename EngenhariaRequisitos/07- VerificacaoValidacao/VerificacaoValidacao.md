## 📌 **1. Verificação vs. Validação**

| Conceito       | Definição                                                                 | Exemplo                                                                 |
|----------------|---------------------------------------------------------------------------|-------------------------------------------------------------------------|
| **Verificação** | "Estamos construindo o produto de maneira certa?" (em relação a padrões e modelos). | Verificar se um requisito atende aos critérios SMART.                  |
| **Validação**  | "Estamos construindo o produto certo?" (em relação às necessidades do cliente).    | Validar com o cliente se um protótipo reflete suas expectativas.       |

> **Fonte**: Julio Cesar Leite.

---

## 🎯 **2. Objetivos da Validação de Requisitos**

- **Garantir** que:
  - O analista compreendeu corretamente os requisitos do cliente.
  - Os requisitos definem o sistema desejado pelo cliente.
  - As representações dos requisitos (textos, modelos, tabelas) são consistentes.
  - A especificação tem qualidade e está em conformidade com padrões organizacionais.

> **Exemplo**: Um requisito como "O sistema deve processar pedidos em menos de 2 segundos" deve ser claro, mensurável e validado com o cliente.

---

## 🔍 **3. Critérios SMART para Requisitos**

| Critério       | Descrição                                  | Exemplo de Requisito Válido            |
|----------------|-------------------------------------------|----------------------------------------|
| **Specific**   | Específico e claro.                       | "O sistema deve autenticar usuários via login e senha." |
| **Measurable** | Mensurável.                               | "O tempo de resposta deve ser ≤ 3 segundos." |
| **Attainable** | Alcançável com os recursos disponíveis.   | "Integrar com API de pagamento XYZ."   |
| **Realizable** | Viável tecnicamente.                      | "Usar criptografia AES-256 para dados sensíveis." |
| **Traceable**  | Rastreável à origem.                      | "Requisito R01: Atendendo à demanda do cliente X." |

---

## 🛠️ **4. Técnicas de Validação de Requisitos**

| Técnica                        | Descrição                                                                 | Exemplo                                                                 |
|--------------------------------|---------------------------------------------------------------------------|-------------------------------------------------------------------------|
| **Revisões de Requisitos**     | Análise manual por um grupo de revisores (stakeholders).                  | Identificar inconsistências em um documento de requisitos.              |
| **Prototipação**               | Uso de modelos para validar interpretações.                               | Protótipo de uma tela de login para validar fluxo com o usuário.        |
| **Validação do Modelo**        | Verificação de modelos de análise (ex: diagramas UML).                    | Validar um diagrama de casos de uso com o cliente.                      |
| **Testes de Aceitação**        | Desenvolver testes para validar requisitos.                               | Testar se o sistema processa 100 transações por segundo.                |
| **Análise Automatizada**       | Uso de ferramentas CASE para verificar consistência.                      | Ferramenta como IBM DOORS para rastrear requisitos.                     |

---

## 🔎 **5. Revisões de Requisitos: O que Procurar?**

- **Erros de conteúdo ou interpretação**: Ex: "O sistema deve armazenar dados indefinidamente" (impreciso).
- **Falta de clareza**: Ex: "O sistema deve ser rápido" (não mensurável).
- **Inconsistências**: Ex: Um requisito exige login, outro diz que o sistema é aberto.
- **Requisitos não-alcançáveis**: Ex: "Processar 1 milhão de transações em 1ms" (inviável).

> **Dica**: Envolva clientes, desenvolvedores e especialistas na revisão.

---

## ⚖️ **6. Vantagens e Desvantagens da Prototipação**

| **Vantagens**                          | **Desvantagens**                          |
|----------------------------------------|-------------------------------------------|
| Visualização clara das interpretações. | Risco de o usuário focar em detalhes cosméticos. |
| Identificação rápida de erros.         | Protótipos podem ser limitados tecnicamente. |

> **Exemplo**: Um protótipo de app de e-commerce pode validar o fluxo de compra, mas o usuário pode criticar cores em vez de funcionalidades.

---

## 📝 **7. Verificação de Requisitos com Critérios de Qualidade**

- **Verificabilidade**: O requisito é testável?  
  Ex: "O sistema deve ser seguro" ❌ vs. "O sistema deve usar SSL" ✅.
- **Compreensibilidade**: É claro para todos?  
  Ex: "O sistema deve suportar ‘N’ usuários" (defina ‘N’).
- **Rastreabilidade**: Pode ser vinculado à sua origem?  
  Ex: "Requisito R02: Baseado na entrevista com o cliente em 10/05/2024."
- **Adaptabilidade**: Pode ser modificado sem impactar outros requisitos?  
  Ex: Modularizar requisitos de pagamento para facilitar atualizações.

---

## 🧠 **8. Dica Final**

> "Requisitos que não podem ser validados **não são requisitos**."  
> — Fonte: Aula 7, página 12.

Use **testes de aceitação** para garantir que cada requisito seja verificável e alinhado com as expectativas do cliente.

--- 
