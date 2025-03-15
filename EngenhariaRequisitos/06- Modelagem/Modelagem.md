## 📌 **1. O que é Engenharia de Requisitos e Modelagem?**
A Engenharia de Requisitos é a parte do desenvolvimento de software responsável por definir **o que** o sistema precisa fazer antes mesmo de começar a programação.

🔹 **Modelagem** é a técnica usada para organizar e representar essas informações, ajudando a transformar ideias em um documento claro para desenvolvedores.

🎯 **Exemplo do Mundo Real**: Imagine que você quer construir uma casa. Antes de começar, você precisa ter uma planta que detalhe os cômodos, portas, janelas e materiais. A modelagem na Engenharia de Requisitos funciona como essa planta, mas para um sistema de software.

---

## 📌 **2. Por que a Modelagem é Importante?**
- Evita mal-entendidos entre clientes e desenvolvedores.
- Ajuda a identificar problemas antes da implementação.
- Documenta tudo para futuras manutenções.

🎯 **Exemplo**: Se um cliente quer um sistema de pedidos online, mas não especifica que precisa de uma forma de pagamento digital, o software pode ser entregue sem essa função, causando problemas.

---

## 📌 **3. Tipos de Modelagem e Documentação**
Existem várias formas de representar requisitos:

### 📌 **Análise Estruturada**
Foca no **fluxo de informações** dentro do sistema. Usa modelos como:
- **Diagramas de Fluxo de Dados (DFD)** – Representam como os dados circulam no sistema.
- **Diagrama de Transição de Estado (DTE)** – Mostra como o sistema muda de estado conforme os eventos ocorrem.
- **Dicionário de Dados** – Lista e define todos os dados utilizados no sistema.

🎯 **Exemplo:** Imagine um caixa eletrônico. Um DFD pode mostrar como um saque funciona: o cliente insere o cartão → digita a senha → escolhe o valor → o sistema verifica saldo → libera o dinheiro.

---

### 📌 **Análise Orientada a Objetos**
Foca em representar **objetos do sistema**, seus relacionamentos e comportamentos. Usa modelos como:
- **Modelo de Casos de Uso** – Representa como os usuários interagem com o sistema.
- **Diagramas de Atividade** – Mostram fluxos de processos dentro do sistema.
- **Máquinas de Estado** – Representam como um objeto pode mudar seu estado ao longo do tempo.

🎯 **Exemplo:** No Instagram, um caso de uso pode ser "Postar uma foto". O usuário interage com o sistema carregando uma imagem, aplicando filtros e publicando. Esse processo pode ser representado em um **Diagrama de Caso de Uso**.

---

### 📌 **Modelagem com Linguagem Natural**
Forma mais comum e acessível de documentação, pois usa textos descritivos para detalhar requisitos.

✔️ **Vantagens**:
- Fácil de entender.
- Não precisa de diagramas complicados.

❌ **Desvantagens**:
- Pode ser ambígua e gerar mal-entendidos.

🎯 **Exemplo:** "O sistema deve permitir que o usuário edite seu perfil" – essa frase pode gerar dúvidas: O que pode ser editado? Nome? Foto? Senha? Por isso, modelos gráficos podem ajudar a esclarecer.

---

### 📌 **Modelagem com Manual do Usuário**
Usar um **manual** como documento de especificação do sistema. Pode conter:
- **Tutoriais** (passo a passo do sistema).
- **Referências** (descrição das funções).
- **Glossário** (dicionário de termos técnicos usados no sistema).

✔️ **Vantagem**: Útil e compreensível para o cliente.
❌ **Desvantagem**: Pode ser vaga ou permitir interpretações erradas.

🎯 **Exemplo:** Se um site tem um manual explicando como fazer login, esse documento pode servir para os programadores entenderem como implementar a funcionalidade corretamente.

---

## 📌 **4. Diagramas de Casos de Uso**
Uma das formas mais comuns de modelagem na Engenharia de Requisitos. Representa:
- **Atores** – Quem interage com o sistema (usuário, outro sistema, máquina).
- **Casos de Uso** – As funções que o sistema deve realizar.
- **Relacionamentos** – Conexões entre atores e casos de uso.

🎯 **Exemplo Prático**:
Imagine um sistema de biblioteca online. Podemos ter:
- **Ator:** Usuário.
- **Caso de Uso:** Reservar um livro.
- **Relacionamento:** O usuário pode solicitar a reserva de um livro.

🔹 Esse diagrama ajuda a garantir que os desenvolvedores e os clientes tenham uma visão clara do que será desenvolvido.

---

## 📌 **5. Definição de Atores**
Os atores representam entidades que interagem com o sistema. Eles podem ser:
- **Pessoas** (Ex: Cliente, Administrador).
- **Organizações** (Ex: Banco, Empresa).
- **Outros sistemas** (Ex: Sistema de Pagamento, API do Google).
- **Equipamentos** (Ex: Scanner, Sensor de presença).

🎯 **Exemplo**: Em um aplicativo de entrega como o iFood, há três atores principais:
- **Cliente** – Faz pedidos.
- **Entregador** – Recebe solicitações de entrega.
- **Restaurante** – Prepara os pedidos.

---

## 📌 **6. Como Identificar Atores?**
Algumas perguntas que ajudam a definir atores no sistema:
- Quem irá usar o sistema?
- O sistema precisa se comunicar com outro sistema?
- Algum evento acontece automaticamente?
- Quem precisa ser notificado quando algo acontece?

🎯 **Exemplo**: Em um sistema bancário, os atores podem ser:
- Cliente – Faz transações.
- Sistema de Segurança – Detecta acessos suspeitos.
- Banco Central – Regula as operações.

---

## 📌 **Conclusão**
Agora que cobrimos os principais conceitos, conseguimos entender como funciona a modelagem na Engenharia de Requisitos. Cada tipo de modelagem e documentação tem sua função específica e ajuda a garantir que o sistema atenda às necessidades dos usuários.

