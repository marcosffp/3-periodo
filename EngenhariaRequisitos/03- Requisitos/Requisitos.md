# Resumo sobre Requisitos de Software

#### **1. O que é um Requisito?**  
- Qualquer característica externa observada por um usuário, comprador ou cliente.  
- Característica que um produto deve possuir para ser aceito.  

#### **2. Níveis de Declaração de Requisitos**  
- **Cliente**: Declaração mais abstrata.  
- **Desenvolvedor**: Declaração mais detalhada.  
- A falta de distinção entre os níveis pode gerar falhas no projeto.  

#### **3. Dificuldades na Obtenção de Requisitos**  
- Clientes podem não entender os processos de desenvolvimento.  
- Especialistas podem não tornar requisitos explícitos.  
- Problemas de comunicação podem gerar diferenças entre o que é pedido, entendido, projetado e entregue.  

#### **4. Importância dos Requisitos**  
- Definir precisamente o que construir é a parte mais difícil do desenvolvimento.  
- Erros nessa fase podem causar:  
  - Perda de vidas  
  - Prejuízos financeiros  
  - Atrasos  
  - Baixa qualidade  

#### **5. Custo de Correção de Erros**  
- O custo de correção aumenta quanto mais tarde o erro é descoberto.  
- Erros em requisitos são os mais caros quando descobertos pelo usuário final.  

#### **6. Engenharia de Requisitos**  
- Conjunto de técnicas para levantar, detalhar, documentar e validar requisitos.  
- Requisitos bem gerenciados reduzem riscos e melhoram a qualidade do software.  

#### **7. Características de um Bom Requisito**  
- **Completo**: Descreve toda a funcionalidade.  
- **Correto**: Reflete exatamente a necessidade do sistema.  
- **Exequível**: Pode ser implementado.  
- **Priorizado**: Indica sua importância (essencial, desejável, opcional).  
- **Modificável**: Pode ser alterado de forma fácil e consistente.  
- **Preciso**: Sem ambiguidades, compreensível por todos.  
- **Verificável**: Pode ser testado.  
- **Rastreável**: Pode-se determinar sua origem e impacto.  

#### **8. Tipos de Requisitos**  
##### **8.1 Funcionais**  
- Relacionados à funcionalidade do software.  
- Exemplo: "O jogador deve escolher o tipo de arma para o ataque."  

##### **8.2 Não-Funcionais**  
- Relacionados ao ambiente tecnológico e restrições do sistema.  
- Exemplos:  
  - **Segurança**: Controle de acesso.  
  - **Desempenho**: Tempo de resposta, carga simultânea.  
  - **Confiabilidade**: Backup, tolerância a falhas.  
  - **Portabilidade**: Compatibilidade com diferentes sistemas.  
  - **Legais**: Normas e regulamentações aplicáveis.  

#### **9. Como Identificar Requisitos?**  
- Avaliar a viabilidade do sistema.  
- Identificar os participantes do processo.  
- Definir o ambiente tecnológico necessário.  
- Escolher métodos de coleta de requisitos (entrevistas, reuniões, questionários, observação).  
- Criar cenários para facilitar o entendimento.  
- Evitar requisitos ambíguos e confusos.  

Aqui está um resumo claro e objetivo da matéria, mantendo todos os conceitos essenciais:  

---

## **Tipos de Requisitos**  

### **1. Requisitos Funcionais**  
São diretamente ligados às funcionalidades do sistema, descrevendo o que ele deve fazer para atender às necessidades do usuário.  
**Exemplo:** O professor deve cadastrar as avaliações da disciplina.  

### **2. Requisitos Não Funcionais**  
Relacionam-se ao ambiente tecnológico e às restrições do sistema, como desempenho, segurança e usabilidade.  
**Exemplos:**  
- A consulta no sistema de biblioteca não deve demorar mais de 30 segundos.  
- O sistema deve suportar até 100 usuários simultâneos.  

---

## **Ambiguidade e Clareza nos Requisitos**  

### **Requisitos Imprecisos**  
São requisitos vagos ou ambíguos que dificultam a implementação e a validação.  
**Exemplo:** "O sistema deve enviar relatórios mensalmente ou quando requisitado" (não especifica quem requisita, nem como).  

### **Como escrever um requisito claro?**  
- **Definir o tipo de usuário:** Exemplo: "O engenheiro de teste..."  
- **Descrever o resultado esperado:** "...simula..."  
- **Especificar o objeto do requisito:** "...erros de componente..."  
- **Incluir as condições de operação:** "...utilizando as funções de teste QQ e TT."  

---

## **Erros Comuns em Requisitos**  

1. **Incompletos:** Exemplo: "O sistema deve acompanhar os projetos." (Falta detalhamento sobre como e quais informações).  
2. **Múltiplos:** Exemplo: "O sistema deve manter dados sobre compras, vendas e estoque, além de registrar comissão de vendedores." (Deveria ser separado em requisitos específicos).  

---

## **Classificação dos Requisitos Não Funcionais**  

### **1. Requisitos de Produto**  
Definem como o produto deve se comportar.  
**Exemplo:** [RNF001] Toda consulta por código de barras deve retornar em até 5 segundos.  

### **2. Requisitos Organizacionais**  
Relacionam-se às políticas e processos internos da empresa.  
**Exemplo:** [RNF002] Todos os relatórios devem seguir o padrão XYZ-00.  

### **3. Requisitos Externos**  
Vêm de fatores externos ao sistema, como legislação e integração com outros sistemas.  
**Exemplo:** [RNF003] A tributação dos produtos deve ser de 15% no Estado do RJ.  

---

## **Como Tornar um Requisito Verificável?**  

Requisitos devem ser escritos de forma que possam ser testados e validados.  

### **Exemplos de Requisitos Inverificáveis e Como Corrigi-los:**  

- **Inverificável:** "O banco de dados deve ser flexível."  
- **Verificável:** "O banco de dados deve possuir oito campos por registro."  

- **Inverificável:** "O sistema CE deve processar depósitos rapidamente."  
- **Verificável:** "O sistema CE deve escanear os dados do usuário em até 2 segundos."  

---

## **Palavras Ambíguas e Como Substituí-las**  

| **Termo Ambíguo** | **Solução** |  
|-------------------|------------|  
| Amigável | Definir número máximo de passos, lista de funcionalidades específicas |  
| Portável | Especificar sistemas operacionais compatíveis e requisitos mínimos |  
| Pequeno | Determinar dimensões ou espaço em bytes |  
| Flexível | Definir variáveis que podem ser alteradas e funções configuráveis |  
