### Requisitos Funcionais

**RF-001**: O profissional pode cadastrar sua agenda de horários disponíveis na plataforma. (Prioridade ALTA)

**RF-002**: O cliente pode visualizar os horários disponíveis e realizar agendamentos. (Prioridade ALTA)

**RF-003**: O sistema permite que o cliente preencha uma ficha de anamnese no primeiro acesso. (Prioridade MÉDIA)

**RF-004**: O cliente deve pagar 50% do valor do serviço no momento do agendamento. (Prioridade MÉDIA)

**RF-006**: O profissional pode cadastrar, editar e remover serviços oferecidos na plataforma. (Prioridade BAIXA)

**RF-007**: O sistema deve permitir que clientes e profissionais editem seus dados cadastrais. (Prioridade MÉDIA)

**RF-009**: O profissional pode marcar um agendamento como concluído, ausente ou cancelado. (Prioridade BAIXA)

### Requisitos Não Funcionais

**RNF-003**: O sistema deve ser responsivo e acessível via dispositivos móveis. (Prioridade ALTA)

### Problema  
O principal problema identificado é a dificuldade no gerenciamento de agendamentos de horários, o que pode resultar em falhas como a não anotação de compromissos, registros incorretos ou esquecimentos. Outro ponto levantado foi a ausência de um sistema padronizado para coleta de informações essenciais dos clientes, como histórico de saúde, o que pode comprometer a personalização e segurança do atendimento.  

### Solução  
A solução proposta envolve a criação de um sistema digital de agendamento que permita aos clientes visualizar horários disponíveis e realizar reservas de forma intuitiva, garantindo maior organização. O sistema incluirá uma ficha de anamnese no primeiro acesso, possibilitando o registro de informações médicas relevantes para um atendimento mais seguro. Além disso, será implementado um modelo de pagamento antecipado de 50% do valor do serviço, com regras para reembolso em caso de cancelamento com aviso prévio, evitando prejuízos por faltas não justificadas. A plataforma será otimizada para acesso via celular, garantindo praticidade aos usuários.

### Funcionalidades Principais  

1. **Gerenciamento de Agenda**  
   - O profissional pode cadastrar, editar e excluir horários disponíveis na plataforma.  
   - O cliente pode visualizar os horários disponíveis e realizar agendamentos.  

2. **Ficha de Anamnese**  
   - No primeiro acesso, o cliente preenche uma ficha de anamnese com informações de saúde relevantes.  
   - O cliente pode editar seus dados de anamnese caso necessário.  

3. **Agendamento e Pagamento**  
   - O cliente realiza o agendamento de um horário disponível.  
   - Para confirmar a reserva, é necessário o pagamento antecipado de 50% do valor do serviço.  
   - Caso o cliente cancele com pelo menos 4 horas de antecedência, o valor antecipado é reembolsado.  
   - O profissional pode marcar um agendamento como concluído, ausente ou cancelado.  

4. **Cadastro e Perfil de Usuário**  
   - O cliente e o profissional podem se cadastrar na plataforma.  
   - Cada usuário pode editar seus dados cadastrais.  

5. **Gerenciamento de Serviços**  
   - O profissional pode cadastrar, editar e remover os serviços oferecidos (tipos de massagem, duração e valores).  

6. **Acessibilidade e Responsividade**  
   - O sistema será otimizado para dispositivos móveis, garantindo uma navegação intuitiva e eficiente.  

### Tecnologias Definidas  
- **Back-end**: Spring Boot, Java, MySQL.  
- **Front-end**: Node.js, Sastro Framework, Tailwind CSS, JavaScript.  


# Resumindo....
## **1. Problemas Identificados**  
- **Dificuldade na gestão de horários**: Anotações manuais podem ser esquecidas ou feitas de forma incorreta.  
- **Falta de um sistema padronizado**: Não há um método eficiente para coletar informações médicas dos clientes.  
- **Desistências sem aviso**: Muitos clientes faltam sem justificar, causando prejuízo e desorganização.  
- **Preferência por acesso móvel**: O sistema precisa ser otimizado para uso em smartphones.  

## **2. Solução Proposta**  
- **Sistema de agendamento online**: O cliente poderá visualizar horários disponíveis e reservar de forma simples.  
- **Ficha de anamnese digital**: No primeiro acesso, o cliente preenche uma ficha com dados relevantes para atendimento seguro.  
- **Pagamento antecipado de 50%**: Garante compromisso do cliente, com regras para reembolso em cancelamentos antecipados.  
- **Interface amigável e responsiva**: Desenvolvido para facilitar o uso, especialmente para idosos.  

## **3. Tecnologias Definidas**  
- **Back-end**: Spring Boot, Java, MySQL.  
- **Front-end**: Node.js, Sastro Framework, Tailwind CSS, JavaScript.  

## **4. Requisitos Prioritários**  
✅ Cadastro de horários e serviços pelo profissional.  
✅ Agendamento online com pagamento antecipado.  
✅ Ficha de anamnese no primeiro acesso.  
✅ Gerenciamento de usuários e serviços.  
✅ Acesso otimizado para dispositivos móveis.  


