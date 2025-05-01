## 🎯 **Objetivos da Documentação de Casos de Uso**

A documentação dos casos de uso tem como finalidade:
- Detalhar **interações entre sistema e usuários**
- **Delimitar o escopo** de cada caso de uso
- Registrar **considerações importantes**, como regras de negócio, requisitos não funcionais e fluxos alternativos
- **Apoiar o desenvolvimento, validação, testes e documentação**

> 📌 *Exemplo*: No caso de uso "Realizar Pedido", é importante registrar o que acontece quando há falha no pagamento.

---

## 📝 **Elementos de um Caso de Uso (Formato Expandido)**

A UML **não obriga um modelo padrão**, mas recomenda-se um formato com os seguintes campos:

| Campo                  | Finalidade |
|------------------------|------------|
| **Nome**               | Começa com verbo (ex: "Registrar Pedido") |
| **Identificador**      | Código único |
| **Importância**        | Prioridade no sistema |
| **Ator Primário**      | Quem inicia a interação |
| **Atores Secundários** | Participam, mas não iniciam |
| **Pré-condições**      | O que deve ser verdade antes de iniciar |
| **Fluxo Principal**    | Caminho "feliz", sem erros |
| **Fluxos Alternativos**| Variações válidas |
| **Fluxos de Exceção**  | Situações de erro |
| **Pós-condições**      | Estado final esperado |
| **Regras de Negócio**  | Regras aplicadas no caso |
| **Notas de Implementação / Histórico** | Anotações técnicas e revisões |

---

## 🔄 **Fluxo Principal**
É o caminho "normal" e ideal de execução.

> 🧾 *Exemplo – Cancelar Pedido:*
1. Operador recebe solicitação de cancelamento  
2. Informa o ID do pedido  
3. Solicita a busca  
4. Sistema exibe o pedido  
5. Operador confirma o cancelamento  
6. Sistema marca como cancelado  
7. Sistema solicita reembolso ao sistema contábil  
8. Crédito é realizado  
9. Caso de uso encerrado

**Dicas:**
- Use voz ativa (sujeito + verbo)
- Não descreva *como* o sistema faz, e sim *o que* acontece

---

## 🔁 **Fluxos Alternativos**
Descrevem **variações válidas** do fluxo principal.

> 🧾 *Exemplo:* Se no passo 5 do fluxo principal o pedido já tiver sido enviado, o sistema pode negar o cancelamento e oferecer contato com suporte.

**Formato:**
- **Condição de início**
- **Passos alternativos**
- **Retorno ao fluxo principal** (se houver)

---

## ❌ **Fluxos de Exceção**
Representam **falhas ou erros inesperados**.

> 🧾 *Exemplo:* O sistema contábil está offline e não é possível reembolsar.

---

## ✅ **Pré e Pós-Condições**

| Tipo | Definição | Exemplo |
|------|-----------|---------|
| **Pré-condição** | Deve ser verdadeiro antes do início | Usuário autenticado |
| **Pós-condição** | Deve ser verdadeiro ao final | Pedido salvo e enviado ao setor de despacho |

---

## 💡 **Boas Práticas**

- Nomeie casos de uso com **verbo no infinitivo**: *"Emitir Nota Fiscal", "Pesquisar Produto"*
- Use linguagem **neutra quanto à interface** (nada de “botão”, “tela”, “popup”)
  > Errado: “Usuário clica no botão ‘Enviar’”  
  > Correto: “Usuário solicita o envio do pedido”
- Evite **detalhes técnicos e algorítmicos**
- Mantenha todos os casos de uso **no mesmo nível de abstração**
- **Não confunda passos com casos de uso completos**

> ❌ *Erro comum:* Tratar “ordenar lista de despesas” como um caso de uso.  
> ✅ *Correto:* Isso é um passo dentro de “Gerar Fatura de Cartão”.

---

## 🧑‍🤝‍🧑 **Público-Alvo da Documentação**

- **Usuários** → entender o comportamento
- **Clientes** → validar fluxos e aprovar
- **Arquitetos e Designers** → identificar funcionalidades relevantes
- **Desenvolvedores** → entender o que implementar
- **Testadores** → gerar casos de teste
- **Gerentes** → planejar entregas e sprints
- **Documentalistas** → criar manuais de usuário

---

## 🔄 **Relação com Outras Atividades**
- **Validação de requisitos**
- **Planejamento de iterações**
- **Base para testes funcionais**
- **Geração de documentação técnica e de usuário**

---

