Claro, Marcos! Aqui vai um resumo **rico em conceitos e exemplos** do conteúdo da *Aula 7 – Casos de Uso e Relacionamentos*:

---

## 📌 **1. O que é um Diagrama de Casos de Uso?**

É um **diagrama de alto nível** que mostra **como os usuários (atores)** interagem com o sistema. Serve para descrever **funcionalidades do sistema** do ponto de vista do usuário, facilitando o entendimento entre desenvolvedores, analistas e clientes.

### ✅ Finalidade:
- **Levantamento de requisitos**
- **Delimitação do escopo do sistema**
- **Comunicação com usuários e especialistas do domínio**
- Ajuda a obter o "aceite" do cliente nas fases iniciais do projeto

---

## 👤 **2. Componentes dos Casos de Uso**

| Elemento        | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Ator**         | Quem interage com o sistema. Pode ser pessoa, outro sistema ou equipamento. |
| **Caso de Uso**  | Funcionalidade do sistema acionada por um ator.                          |
| **Relacionamento** | Ligações entre atores e casos de uso ou entre casos de uso.             |

### 🧾 Exemplo:
```
Ator: Usuário
Caso de Uso: Reservar Livro
Relação: Linha conectando ambos no diagrama
```

---

## 🗣️ **3. O que é um Caso de Uso?**
É um **cenário** que modela o **diálogo entre um ator e o sistema**. Ele:
- Começa com um **verbo**: "Cadastrar Cliente", "Emitir Relatório"
- Pode criar, modificar, consultar ou excluir dados
- Representa uma **ação com valor para o usuário**

> **Exemplo**: Caso de uso “Realizar Transferência” descreve as etapas que o sistema segue quando o cliente solicita a transferência de valores.

---

## 🎯 **4. Como identificar Casos de Uso?**

### ✔️ Método por Atores:
1. Identifique os atores.
2. Descubra quais processos eles iniciam ou participam.

### ✔️ Método por Eventos:
1. Identifique eventos externos.
2. Relacione esses eventos com atores e casos de uso.

> **Exemplo prático**:  
> Ator: Cliente  
> Evento: Solicita extrato  
> Caso de uso: "Obter Extrato"

---

## 🔗 **5. Relacionamentos entre Casos de Uso**

### 🔸 Associação
- Conecta um ator a um caso de uso.

> Ex: Cliente — Fazer Pedido

---

### 🔸 Generalização
- Um ator ou caso de uso **herda comportamentos** de outro.

> Exemplo:  
> - Ator: Funcionário ← Vendedor  
> - Caso de uso: Registrar Negócio ← Registrar negócio com limite excedido

---

### 🔸 Inclusão (**«include»**)
- Um caso de uso é **sempre executado** como parte de outro.
- Evita duplicação de lógica comum.

> **Exemplo bancário**:  
> Casos de uso como “Obter Extrato” e “Realizar Saque” incluem o caso “Fornecer Identificação”.

📌 Notação:
```
Cliente → Realizar Saque → «include» Fornecer Identificação
```

---

### 🔸 Extensão (**«extend»**)
- Representa **comportamento opcional ou exceções**.
- Só ocorre sob certas condições.

> Exemplo:  
> Caso base: “Efetuar Aplicação”  
> Extensão: “Programar Data Futura” → executado apenas se o cliente desejar.

📌 Notação:
```
Cliente → Efetuar Aplicação
        ↑
«extend» Programar Data Futura
```

---

## 🧠 **6. Diferença entre «include» e «extend»**

| Característica             | «include»                        | «extend»                          |
|----------------------------|----------------------------------|-----------------------------------|
| Executado sempre?          | Sim                              | Não – depende de uma condição     |
| Independência?             | Não pode ser executado sozinho   | Pode ser executado separadamente  |
| Finalidade                 | Reutilização, modularização      | Comportamento opcional/exceção    |

Include é todo para parte, Extend é parte para todo.

---

