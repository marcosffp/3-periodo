# 🔄 **Comunicação usando Polling (Espera ativa)**

### 👉 **Como funciona:**

1. A **CPU pergunta toda hora pro dispositivo:**
   ➡️ “Acabou? Tá pronto?”

2. Enquanto não estiver pronto, a CPU **fica parada esperando**, sem fazer mais nada.

3. Quando o status muda para **"pronto"**, a CPU:

* Lê os dados se for uma operação de **entrada**,
* Ou envia os dados se for uma operação de **saída**.

4. Depois, executa o próximo comando.

---

### ⚠️ **Desvantagem:**

* Se o dispositivo for lento (ex.: disco ou impressora), a CPU **fica presa esperando**, desperdiçando tempo e desempenho.

---

### ✔️ **Quando faz sentido usar:**

* **Teclado, mouse ou modem**, onde as operações são rápidas e precisam ser respondidas imediatamente.

---

---

# 🚦 **Comunicação usando Interrupções**

👉 **Imagem 1 que você mandou mostra exatamente isso!**

### 🔥 **Como funciona:**

1. O **driver inicia** uma operação de E/S (ex.: ler dados do disco).
2. O **dispositivo trabalha sozinho** (ler, gravar, etc.).
3. **Quando termina**, o dispositivo **dispara uma interrupção**.
4. A **CPU para o que está fazendo** e chama o **tratador de interrupções**.
5. O tratador pega os dados ou confirma a execução.
6. A CPU volta pra tarefa que estava fazendo.

---

### ✅ **Vantagem:**

* A CPU **não fica parada esperando**. Só é chamada quando precisa.

### ✅ **Desvantagem:**

* Tempo gasto para: Salvar o estado atual da CPU (registradores, contadores, etc.). Restaurar o estado da CPU e retomar o processamento anterior.

---

### 🚦 **O que a CPU faz na interrupção:**

* Verifica **qual dispositivo causou a interrupção**.
* Se era uma **entrada**, lê os dados.
* Depois, pode **iniciar a próxima operação** daquele dispositivo.

---

---

# 🧠 **Vetores de Eventos Intel x86 — (Imagem 2)**

* Toda interrupção (de hardware ou erro) tem um **número (vetor)**.
* A CPU usa esse número pra saber **qual tratador de interrupção executar.**

### ✔️ **Exemplos do que tem na tabela:**

* **Vetor 0:** Divisão por zero.
* **Vetor 14:** Page fault (erro de memória virtual).
* **Vetor 32 em diante:** Interrupções de dispositivos, como disco, teclado, etc. (interrupções mascaráveis).

---

---

# 🚀 **DMA (Acesso Direto à Memória)**

### 🔧 **Por que usar DMA?**

* Quando precisa transferir **grande volume de dados** (ex.: ler um arquivo do disco), é **ineficiente a CPU pegar byte por byte.**

### 🏗️ **Como funciona:**

1. A CPU **configura o DMA**, dizendo:
   ➡️ "Pega dados do disco e joga na memória nesse endereço."

2. O DMA **assume o controle do barramento**, pega os dados e escreve diretamente na RAM.

3. Quando termina, o DMA **gera uma interrupção**, só pra avisar:
   ➡️ "Terminei!"

---

### ✅ **Vantagem:**

* **Libera a CPU** pra fazer outras coisas.
* A CPU só entra no processo no começo (configurando) e no final (sendo avisada que terminou).

---

### ⚠️ **Cuidado:**

* Durante a transferência, a **CPU e o DMA disputam o barramento da memória**, o que pode deixar a CPU um pouco mais lenta nesse momento.

---

---

# 📊 **Tabela Comparativa Simples:**

| 🚥 **Método**   | 🏗️ **Como Funciona**              | ✅ **Vantagem**                   | ❌ **Desvantagem**                  |
| --------------- | ---------------------------------- | -------------------------------- | ---------------------------------- |
| **Polling**     | CPU pergunta toda hora se terminou | Simples                          | CPU perde tempo                    |
| **Interrupção** | Dispositivo avisa a CPU            | CPU livre enquanto espera        | Requer tratamento das interrupções |
| **DMA**         | Dispositivo envia direto pra RAM   | Super eficiente p/ grandes dados | CPU e DMA disputam o barramento    |

---

# 🎯 **Resumo das imagens:**

* **Imagem 1:** Mostra o fluxo de E/S com interrupções, onde o dispositivo avisa a CPU.
* **Imagem 2:** Mostra os vetores que ajudam a CPU a saber **qual evento ou dispositivo gerou a interrupção**.

---


