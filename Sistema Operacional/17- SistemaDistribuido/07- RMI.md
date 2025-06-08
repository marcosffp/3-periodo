## ☕ O que é **RMI (Remote Method Invocation)**?

É a forma como o Java implementa **chamada de procedimento remoto (RPC)** com objetos.
Você **chama um método** de um objeto que está **em outro computador**, como se ele estivesse local.

---

## 🛠️ Componentes principais do RMI em Java:

### 🔹 1. `Remote` (interface)

* Toda interface remota deve **estender** `java.rmi.Remote`.
* Os métodos devem declarar `throws RemoteException`.

### 🔹 2. `UnicastRemoteObject`

* Classe usada no **servidor** para permitir exportar o objeto remoto (abrir porta TCP, receber chamadas, etc).

### 🔹 3. `Naming`

* Classe que permite:

  * `bind(nome, objeto)`: servidor registra o objeto com um nome.
  * `lookup(nome)`: cliente busca o objeto remoto usando esse nome.

### 🔹 4. `rmiregistry`

* Um **servidor de nomes** que mantém o mapeamento `nome ↔ objeto`.
* Semelhante a um "DNS" para objetos Java.

### 🔹 5. `rmic`

* Gerador de código que cria os **stubs** automaticamente para cliente e servidor.

---

## 🚀 Etapas do exemplo (Hello World)

### 🔧 **1. Interface remota**

```java
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}
```

📌 Isso define o **contrato** entre cliente e servidor.

---

### 🖥️ **2. Classe do servidor**

```java
public class HelloImpl extends UnicastRemoteObject implements Hello {
    public HelloImpl() throws RemoteException {
        super(); // exporta o objeto automaticamente
    }

    public String sayHello() throws RemoteException {
        return "Hello World!";
    }
}
```

---

### 📌 **3. Main do servidor**

```java
public static void main(String[] args) {
    System.setSecurityManager(new RMISecurityManager()); // define segurança

    HelloImpl obj = new HelloImpl(); // cria o objeto remoto

    Naming.rebind("//myhost/HelloServer", obj); // registra no rmiregistry
}
```

---

### 🌐 **4. Cliente**

```java
Hello obj = (Hello) Naming.lookup("//myhost/HelloServer");
String mensagem = obj.sayHello(); // chamada remota
```

🧠 Aqui, `obj` **parece local**, mas está chamando o servidor remotamente!

---

## 🧠 Analogia:

Imagine que `sayHello()` está em um **servidor na nuvem**.

* Você (cliente) pede o "Olá" usando o nome `"HelloServer"`.
* O RMI cuida de:

  * Encontrar o objeto no servidor.
  * Mandar a requisição.
  * Receber o retorno.

---

## ✅ Resumo visual:

| Elemento              | Função                                                            |
| --------------------- | ----------------------------------------------------------------- |
| `Remote`              | Interface que define os métodos remotos                           |
| `UnicastRemoteObject` | Exporta objeto remoto no servidor (abre porta e gerencia conexão) |
| `Naming.bind`         | Registra o objeto com um nome no `rmiregistry`                    |
| `Naming.lookup`       | Cliente busca o objeto remoto                                     |
| `rmiregistry`         | “DNS” de objetos: mantém nomes e objetos exportados               |
| `rmic`                | Gera automaticamente os stubs (código de rede)                    |

---


