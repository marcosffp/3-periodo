## 🔥 **1. O que é um Processo?**  

Imagine que você está em um **restaurante fast-food**. Quando um cliente faz um pedido, o sistema registra o pedido, coloca na fila de preparo e, depois que o lanche está pronto, ele é entregue.  

No mundo dos sistemas operacionais:  
- **O pedido** 📄 → é um **processo** que foi criado.  
- **A cozinha** 👨‍🍳 → é o **processador (CPU)** que executa o pedido.  
- **A fila de pedidos** 📝 → é a **tabela de processos** do sistema operacional.  

Um **processo** nada mais é do que um **programa em execução**. Ele contém:  
1. **Código** (o que será executado).  
2. **Dados e variáveis** (o que ele precisa para funcionar).  
3. **Recursos** (memória, tempo de CPU, arquivos abertos etc.).  

Sempre que você **abre um programa** (um navegador, um jogo, um editor de texto), o sistema operacional cria um **processo** para ele.

---

## 🧬 **2. Criação de Processos – fork()**  

Agora que sabemos o que é um processo, vamos entender como **criar um novo processo**.  

O sistema operacional permite que um **processo "pai" gere um processo "filho"**. Para isso, ele usa a função `fork()`.  

### 🔹 **Como funciona o fork()?**  
- Quando um processo executa `fork()`, o sistema cria **uma cópia exata** dele.  
- Agora existem **dois processos**, **pai** e **filho**.  
- Ambos continuam rodando **a partir da mesma linha de código**, mas são **processos independentes**.  

### ⚡ **Como saber quem é pai e quem é filho?**  
- **O processo pai** recebe o **ID do processo filho** como retorno de `fork()`.  
- **O processo filho** recebe `0` como retorno de `fork()`.  

🔹 **Exemplo prático**  

```c
#include <stdio.h>
#include <unistd.h>  // Biblioteca para usar fork()

int main() {
    int pid = fork();  // Criando um processo filho

    if (pid > 0) {
        printf("Sou o processo PAI, meu filho tem PID = %d\n", pid);
    } else if (pid == 0) {
        printf("Sou o processo FILHO, meu PID = %d\n", getpid());
    } else {
        printf("Erro ao criar processo\n");
    }

    return 0;
}
```

### 🧐 **O que acontece ao rodar esse código?**  
1. O `fork()` é chamado.  
2. O sistema cria um **novo processo filho**.  
3. O código **continua executando** em ambos os processos.  
4. **Cada processo** verifica seu valor de `pid` para saber quem é o pai e quem é o filho.  

📌 **IMPORTANTE:** O pai pode esperar o filho terminar usando `wait()`, ou continuar executando normalmente.

---

## ☠️ **3. Processos Órfãos e Processos Zumbi**  

Agora vamos falar de dois fenômenos estranhos que podem acontecer quando um processo morre:  

### 🧩 **Processo Órfão**  
Ocorre quando um **processo pai termina antes do filho**.  

🔹 Exemplo:  
1. O processo pai cria um filho (`fork()`).  
2. O pai termina sua execução **antes** do filho.  
3. O filho fica "perdido", sem pai.  
4. O sistema operacional adota esse processo, e ele passa a ser filho do **init** (processo com ID = 1).  

📌 **Resumo:** Processo órfão = O pai morre antes do filho.

---

### 🧟‍♂️ **Processo Zumbi**  
Ocorre quando um **processo filho morre, mas seu pai não o reconhece**.  

🔹 Exemplo:  
1. O pai cria um filho (`fork()`).  
2. O filho termina sua execução **antes** do pai.  
3. O sistema mantém a entrada do filho na **tabela de processos**, esperando que o pai chame `wait()` para "recolher" o status.  
4. Se o pai nunca chamar `wait()`, o filho continua como um **zumbi**, ocupando espaço na tabela do SO.  

📌 **Solução:** O pai deve chamar `wait()` para evitar que seus filhos se tornem zumbis.

---

## 🔄 **4. Substituindo um Processo – exec()**  

Às vezes, um processo **filho** pode precisar rodar um programa **totalmente diferente** do pai. Para isso, usamos a função `exec()`.  

### 🔹 **Como funciona o exec()?**  
- Quando `exec()` é chamado, o processo **não cria um novo processo**.  
- Em vez disso, **ele substitui seu código** pelo novo programa.  

🔹 **Exemplo prático**  

```c
#include <stdio.h>
#include <unistd.h>

int main() {
    printf("Antes do exec()\n");

    execlp("ls", "ls", "-l", NULL);  // Substitui o processo atual pelo comando "ls -l"

    printf("Essa linha nunca será executada!\n");
    return 0;
}
```

### 🧐 **O que acontece?**  
1. O programa começa e imprime `"Antes do exec()"`.  
2. `execlp("ls", "ls", "-l", NULL)` é chamado.  
3. O processo é **substituído** pelo programa `ls`.  
4. A linha `"Essa linha nunca será executada!"` nunca é impressa, pois o código original foi substituído.

📌 **Resumo:** `exec()` = substitui o processo atual por outro programa.

---

## 🏆 **5. Comunicação entre Processos**  

Os processos podem se comunicar de duas formas principais:  
1. **Memória Compartilhada** – Todos os processos acessam a mesma área de memória.  
2. **Envio de Mensagens** – Um processo envia informações para outro usando mensagens.  

Exemplo de **Produtor e Consumidor**:  

```c
if (fork() != 0) {
    // Processo pai: Produtor
    send(mensagem, consumidor);
} else {
    // Processo filho: Consumidor
    receive(mensagem, produtor);
}
```

📌 **Resumo:** Comunicação entre processos é essencial para sistemas distribuídos e concorrência.

---

## 🎯 **Conclusão**  

🔹 **fork()** → Cria um novo processo filho.  
🔹 **wait()** → Faz o pai esperar o filho terminar.  
🔹 **exec()** → Substitui um processo por outro.  
🔹 **Processo órfão** → Pai morre antes do filho.  
🔹 **Processo zumbi** → Filho morre antes do pai chamá-lo.  
🔹 **Comunicação** → Memória compartilhada e envio de mensagens.  

