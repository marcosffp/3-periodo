## 🔧 **Componentes da Arquitetura de E/S**

### 1️⃣ **Barramento do Sistema**

* É como uma "estrada" que liga a CPU, memória e os dispositivos.
* Todos os dispositivos se comunicam com a CPU através dele.
* Exemplos de barramento: **PCI, USB, SATA, etc.**

---

### 2️⃣ **Porta do Dispositivo**

Cada dispositivo tem uma "porta" composta por **4 registradores**, que são como pequenas memórias para controle da comunicação:

* **Status:** informa se o dispositivo está **ocupado**, **pronto** ou com **erro**.
* **Controle:** onde a CPU envia comandos, tipo "comece a ler" ou "gravar dados".
* **Entrada de Dados:** dados **vindo do dispositivo para a CPU**.
* **Saída de Dados:** dados **saindo da CPU para o dispositivo**.

---

### 3️⃣ **Controlador**

* É como um "tradutor" entre o barramento e o dispositivo.
* Recebe comandos da CPU pelo barramento, **transforma em ações específicas** (ler, gravar, movimentar, etc.) e faz a transferência de dados entre o dispositivo e a memória.
* Exemplo: O controlador de disco entende como buscar setores no disco físico.

---

### 4️⃣ **O Dispositivo em Si**

* Pode ser qualquer equipamento conectado:

  * **Tradicionais:** disco, impressora, teclado, mouse, monitor, etc.
  * **Não tradicionais:** joystick, braços robóticos, sistemas de aviões, sistemas automotivos (injeção eletrônica), etc.

---

## 📊 Ligação com as imagens:
* ✔️ Primeira imagem (barramento PCI):
Mostra como a CPU, memória e dispositivos (discos, teclado, placa de vídeo, portas paralelas e seriais) se interconectam através do barramento PCI e outros barramentos (IDE, SCSI).

Cada componente tem seu controlador específico.

* ✔️ Segunda imagem (visão do kernel):
Mostra a relação entre hardware (controladores e dispositivos) e software (drivers, kernel e aplicações).

O kernel faz a ponte entre o hardware e o software, gerenciando E/S com a ajuda dos drivers e do subsistema de E/S.

* ✔️ Terceira imagem — Tabela de I/O Address Range (Portas de E/S)
Essa tabela mostra os endereços de entrada e saída (I/O ports) que a CPU usa para se comunicar com os dispositivos.

Cada dispositivo tem um intervalo de endereços hexadecimal, que são como "caixinhas" onde a CPU envia comandos ou lê dados.

- 👉 Atenção:
Não tem nada a ver com portas de rede (ex.: porta 80, 443).

São portas de hardware, usadas para comunicação interna entre CPU e dispositivos.

- ✔️ Exemplos da tabela:
000-00F: Controlador de DMA

020-021: Controlador de Interrupção

320-32F: Controlador de Disco

3F8-3FF: Porta serial (COM1)

- 👉 Quando a CPU quer falar com o disco, ela envia comandos para o endereço 320-32F, onde está o controlador do disco.


## ✅ **Resumo bem direto:**

A CPU **não fala diretamente** com o dispositivo. Ela usa o **barramento**, que se conecta a um **controlador**. Esse controlador entende os comandos e lida diretamente com o **dispositivo**, usando os **registradores da porta** para enviar e receber dados ou controlar o estado da operação.

---


