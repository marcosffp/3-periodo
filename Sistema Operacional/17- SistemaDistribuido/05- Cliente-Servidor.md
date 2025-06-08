## 🖥️ MODELO CLIENTE/SERVIDOR — Comunicação Distribuída

### 🔧 O que acontece tecnicamente:

1. **Servidor**:
   É um processo (ou conjunto deles) que oferece **serviços** a outros programas.
   Exemplos de serviços:

   * Serviço de arquivos
   * Serviço de banco de dados
   * Serviço de nomes (como DNS)

2. **Cliente**:
   É um programa que usa os serviços do servidor. Ele:

   * Localiza o servidor na rede
   * Estabelece uma **conexão**
   * Envia uma **solicitação**
   * Aguarda a **resposta** do servidor

3. **Conexão**:
   O cliente precisa saber **onde está o servidor** (endereço IP + porta). Isso pode ser:

   * **Estático**: já embutido no código
   * **Dinâmico**: usando um **serviço de nomes**, como o DNS

4. **Resposta**:
   O servidor **processa a solicitação** e devolve um resultado ao cliente.

---

### 🧠 Analogia:

Imagine uma lanchonete:

* **Cliente**: você, que faz o pedido.
* **Servidor**: o atendente, que recebe seu pedido, prepara e entrega.
* **Serviço**: pode ser comida, bebida, etc.
* Você pede (requisição), o atendente serve (resposta).

---

### 📬 Como isso é implementado?

A forma mais comum é através da:

### 📡 **RPC — Remote Procedure Call (Chamada de Procedimento Remoto)**

* O cliente chama uma **função** como se estivesse local, mas na verdade ela é executada remotamente no servidor.
* O SO cuida da comunicação: empacotar dados, enviar, esperar retorno.

---

### ✅ Vantagens:

* Simplicidade para o cliente (chama como se fosse uma função local).
* Reutilização de código (muitos clientes podem usar o mesmo servidor).
* Clareza na arquitetura (divisão entre quem **pede** e quem **serve**).

---

### ❌ Desvantagens:

* Dependência do servidor: se ele falhar, o cliente não funciona.
* Comunicação pela rede pode ser lenta ou sujeita a falhas.
* Segurança e autenticação precisam ser bem implementadas.

---

### 📜 Exemplo visual (fluxo):

```
Cliente             ->       Servidor
   | Solicita dados       |
   |--------------------->|  (Ex: "Me mande o nome de usuário X")
   |                      |
   |       Processa       |
   |<---------------------|  (Ex: "O nome é Ana")
   | Recebe a resposta    |
```

---

### 🧠 Conclusão:

O modelo cliente/servidor é **a base da computação distribuída moderna**, sendo usado em:

* Sites (navegador = cliente / servidor web = servidor)
* Jogos online
* Aplicativos móveis
* Banco de dados remotos

