## 📡 O que é RPC (Remote Procedure Call)?

É uma técnica que permite que **um programa (cliente)** execute **uma função que está em outro computador (servidor)** como se ela fosse local.

> É como chamar `soma(2, 3)` — mas em vez de rodar localmente, essa função roda em outro computador, e o resultado volta pela rede.

---

## 🔧 Como funciona internamente?

### 1. **Stub do Cliente** (lado do cliente)

É como um “representante local” da função remota. Ele faz:

```
criar mensagem
enviar mensagem
aguardar resposta
desempacotar resposta
retornar resultado
```

💡 A mensagem enviada contém:

* Nome da função
* Parâmetros
* Endereço para resposta

---

### 2. **Stub do Servidor** (lado do servidor)

Esse é o “receptor” da chamada, que recebe o pedido e executa a função de verdade:

```
criar loop de threads
esperar por um comando
descompactar parâmetros
chamar procedimento
criar resposta com resultado(s)
enviar resposta
(loop continua para novas chamadas)
```

---

## 🌀 **1. O que é o “loop” no servidor RPC?**

O **loop** é uma estrutura que **deixa o servidor constantemente escutando por novas requisições**.

### 🔁 Analogia:

Imagine uma central de atendimento:

* Você tem um atendente (thread).
* Ele fica o dia todo no telefone, esperando ligações.
* Cada vez que um cliente liga, o atendente **atende, responde** e **volta a esperar por outro cliente**.

No RPC, esse “atendente” é uma **thread em loop**, que:

1. Espera uma mensagem chegar.
2. Processa a requisição.
3. Envia a resposta.
4. Volta a esperar por outra requisição.

---

## 🧵 **2. Por que usar threads?**

Imagine que **vários clientes** estão chamando funções remotas **ao mesmo tempo**. Se o servidor usar **apenas uma thread**, ele só conseguiria atender **um por vez** — os outros teriam que **esperar em fila**, o que seria lento.

### ✨ Usar threads permite:

* Atender **múltiplos clientes simultaneamente**.
* Cada requisição pode ser tratada em **paralelo**.
* Aproveitar melhor o **processamento multi-core**.

---

## 🔧 Como funciona na prática:

1. O servidor tem **uma thread principal** que escuta (loop).
2. Ao receber uma requisição:

   * Ele **cria uma nova thread** (ou usa uma thread de um *pool*).
   * Essa thread **executa o procedimento** e envia a resposta.
3. A thread principal **continua escutando**.

---

## 📜 Exemplo visual do servidor RPC:

```java
while (true) {                        // loop principal
   mensagem = aguardar_mensagem();
   new Thread(() -> {                // nova thread para cada cliente
      dados = desempacotar(mensagem);
      resultado = executar(dados);
      enviar_resposta(resultado);
   }).start();
}
```

---

## ✅ Resumo

| Conceito    | Por quê?                                               |
| ----------- | ------------------------------------------------------ |
| Loop        | Para o servidor **nunca parar de escutar** requisições |
| Thread      | Para **atender vários clientes ao mesmo tempo**        |
| Sem threads | Só um cliente por vez → lento e ineficiente            |
| Com threads | Vários procedimentos remotos em execução simultânea    |

---


### 🔁 Fluxo Completo RPC:

```text
Cliente                                 Servidor
   |                                        |
[ stub ] ---(chamada)--------------------> [ stub ]
   |     nome + parâmetros                 |
   |                                executa função
   | <--------------resultado------------- |
[ stub ]     resposta com dados            |
   |                                        |
```

---

## 🧠 Analogia:

Imagine que você quer saber o saldo da sua conta bancária:

1. Você (cliente) preenche um formulário com seu número de conta.
2. Entrega a um atendente (stub do cliente).
3. Ele envia essa requisição ao servidor bancário.
4. O servidor recebe, processa, pega o saldo (stub do servidor).
5. Manda a resposta de volta.
6. Você recebe o papel com o valor.

---

## 🧩 O que é incluído na **mensagem RPC**?

* 📛 Nome do procedimento (ex: `consultarSaldo`)
* 🔢 Parâmetros (ex: número da conta)
* ✅ Resultado (ex: saldo R\$ 245,00)
* 📬 Endereço de retorno (pra onde o servidor envia a resposta)

---

## 📍 Sobre a **vinculação** (binding):

Antes de fazer a chamada, o cliente precisa **descobrir onde está o servidor**.

### Pode ser:

* 🔒 **Estática**: embutida no código (endereço IP fixo).
* 🔄 **Dinâmica**: feita em tempo de execução usando um **serviço de nomes** (como um DNS ou um rmiregistry no Java RMI).

## 🌍 O que é **IP (Internet Protocol Address)**?

**IP** é o **endereço único de um dispositivo na internet ou rede local**.

### 📦 Exemplo de endereço IP:

* IPv4: `192.168.0.1` ou `142.250.190.78`
* IPv6: `2001:0db8:85a3:0000:0000:8a2e:0370:7334` (novo padrão)

### 🧠 Analogia:

Pense no IP como o **número da sua casa**.

* Para alguém te enviar uma carta (dados), ele precisa saber **onde você mora** (endereço IP).

---

## 🌐 O que é **DNS (Domain Name System)?**

**DNS** é um “catálogo” da internet que **traduza nomes de sites para endereços IP**.

### 📲 Exemplo:

Você digita no navegador:

```
www.google.com
```

O computador **pergunta ao DNS**:

> “Qual o IP desse nome?”

E o DNS responde:

```
142.250.190.78
```

Aí sim, seu navegador consegue se conectar ao servidor do Google.

---

## 🧠 Analogia real:

### Sem DNS:

Você teria que decorar números como `172.217.29.238` para acessar sites. 😓

### Com DNS:

Você só precisa lembrar "google.com", "youtube.com", etc. — o DNS faz a conversão automaticamente. 😄

---

## 🔧 Como funciona tecnicamente:

1. Você digita `www.exemplo.com`.
2. Seu computador envia uma requisição DNS perguntando o IP desse nome.
3. O servidor DNS responde com o endereço IP correspondente.
4. Agora seu computador **sabe para onde enviar os pacotes** de dados.

---

## ✅ Resumo

| Conceito | Função                                                |
| -------- | ----------------------------------------------------- |
| **IP**   | Endereço numérico de um dispositivo na rede/internet  |
| **DNS**  | Sistema que traduz nomes de domínio para endereços IP |



---

## ☕ Exemplo prático em Java RMI:

1. **Servidor**:

   * Define uma interface (ex: `Hello`)
   * Implementa o método (ex: `sayHello()`)
   * Registra o objeto com um nome (`Naming.rebind(...)`)

2. **Cliente**:

   * Localiza o servidor (`Naming.lookup(...)`)
   * Chama o método remoto (`sayHello()`)

Tudo isso funciona porque **o stub do cliente e do servidor foram gerados automaticamente (via `rmic`)**.

---

## ✅ Resumo Final:

| Elemento         | Função                                                   |
| ---------------- | -------------------------------------------------------- |
| RPC              | Chama função remota como se fosse local                  |
| Stub do Cliente  | Prepara a chamada e envia                                |
| Stub do Servidor | Recebe, executa e devolve a resposta                     |
| Mensagem         | Contém nome, parâmetros, endereço de retorno e resultado |
| Binding          | Liga cliente ↔ servidor (estático ou dinâmico via nomes) |

---

