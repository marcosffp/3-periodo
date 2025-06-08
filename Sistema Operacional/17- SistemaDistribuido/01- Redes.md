## 🌐 CONCEITOS FUNDAMENTAIS DE REDES

---

## 🧭 **Objetivo das Redes**

### 🔧 O que acontece tecnicamente:

* As redes têm como propósito **fornecer passagem de mensagens** de forma:

  * **Eficiente** (rápido)
  * **Correta** (sem erros)
  * **Robusta** (com tolerância a falhas)
* Conectam **dois ou mais nós (computadores)** para que troquem dados.

---

## 🧠 Analogia:

Pense em uma **estrada**:

* **Carros** = pacotes de dados
* **Estrada** = meio físico de rede
* **Polícia rodoviária** = switches/roteadores que controlam o tráfego
* Assim como o trânsito pode congestionar, **a rede pode ficar lenta ou sobrecarregada**.

---

## 🌍 Tipos de Rede

### 📡 **LAN (Local Area Network)**

* Rede **local**, como dentro de uma empresa ou escola.
* Alta velocidade, baixa latência.
* **Tecnologias comuns**: Ethernet.
* **Mídia física**: par trançado, cabo coaxial, fibra óptica.
* **Velocidade típica**: de **10 Mb/s** a **400 Gb/s**.

### 🌐 **WAN (Wide Area Network)**

* Rede **ampla**, como a Internet.
* Conecta dispositivos por **longas distâncias**.
* **Mais lenta e menos confiável** que LAN.
* **Mídia física**: satélite, cabo de operadoras, 5G.
* **Velocidade**: de **2 Mb/s** (Bluetooth) até **40 Gb/s** (Wi-Fi 7).

---

## 🌐 **Princípios de Comunicação em Rede**

### 🧩 1. **Pacotes — A unidade básica de dados na rede**

> “Os dados enviados para a rede são divididos em ‘pacotes’, a unidade básica de transmissão da rede.”

#### ✅ O que significa:

* Quando você manda uma mensagem, um vídeo ou qualquer dado pela rede, **o conteúdo não é enviado de uma vez**.
* Ele é **quebrado em partes menores chamadas *pacotes*** (ou *frames*).
* Cada pacote viaja **independentemente** até o destino.

#### 🧠 Analogia:

Imagine que você quer enviar um livro pelo correio.
Você **não manda o livro inteiro de uma vez**, mas **página por página**. No destino, alguém **reconstrói o livro**.

---

### 🚦 2. **Pontos de comutação controlam o tráfego**

> “Os computadores nos pontos de comutação controlam o fluxo de pacotes.”

#### ✅ O que significa:

* **Switches e roteadores** (os “nós” ou *pontos de comutação*) **decidem para onde cada pacote vai**.
* Eles analisam o destino do pacote e **encaminham ele corretamente**, como um guarda de trânsito.

#### 🧠 Analogia:

> **Carros / Estrada / Polícia**

| Elemento real    | Analogia na rede     |
| ---------------- | -------------------- |
| Carros           | Pacotes              |
| Estradas         | Fios, cabos, Wi-Fi   |
| Polícia (guarda) | Switches, roteadores |

---

### ⚠️ 3. **Recursos compartilhados geram contenção (congestionamento)**

> “Os recursos compartilhados podem levar à contenção (congestionamentos).”

#### ✅ O que significa:

* Como **muitos dispositivos compartilham os mesmos caminhos** (links de rede, roteadores...), eles **podem competir pelo uso**.
* Isso pode gerar **lentidão**, **perda de pacotes** ou **espera**.

#### 🧠 Analogias:

* **Nodo compartilhado = Shopping center**
  *Muitas pessoas tentando entrar/sair ao mesmo tempo pelo mesmo lugar.*
* **Link compartilhado = Ponte**
  *A ponte só deixa passar uma quantidade limitada de carros. Se tiver muito tráfego, forma fila.*

---

## 📜 **Protocolos de Comunicação**

> “Protocolo: um conjunto de regras de comunicação que são acordadas por todas as partes”

#### ✅ O que significa:

* **Protocolo** é o conjunto de **regras que todos os dispositivos seguem para conseguir conversar**.
* Define como:

  * Os pacotes são formatados
  * Como os erros são detectados e corrigidos
  * Quem fala primeiro, quem responde, etc.

📌 **Sem protocolo**, dois dispositivos podem até estar conectados, mas **não vão se entender** (como pessoas falando idiomas diferentes).

---

## 🧱 **Pilha de Protocolos — Estrutura em Camadas**

> “O software de rede é estruturado em camadas”

#### ✅ O que significa:

* A comunicação na rede é dividida em **camadas**, como um sanduíche:

  * Cada camada **tem uma função específica**.
  * Cada camada **se comunica com sua equivalente do outro lado**, como:

    * Transporte ↔ Transporte
    * Rede ↔ Rede
    * Física ↔ Física

#### 🧠 Analogia:

Pense em uma empresa de correio com departamentos:

| Camada da pilha | Equivalente no correio               |
| --------------- | ------------------------------------ |
| Aplicação       | Pessoa escrevendo a carta            |
| Transporte      | Departamento que verifica o endereço |
| Rede            | Setor que decide a rota de entrega   |
| Enlace          | Motoboy levando a carta localmente   |
| Física          | As ruas por onde o motoboy passa     |

---

## 🌍 Exemplo: Modelo OSI (ISO)

> “Exemplo: Organização Internacional de Padrões/Interconexão de Sistemas Abertos (ISO/OSI)

### 🧭 O que essa imagem mostra?

Ela mostra **três máquinas (A, B e C)** se comunicando usando a **pilha de protocolos ISO/OSI**, com destaque para:

* A → origem da comunicação
* C → destino
* B → intermediário (roteador ou switch de rede)

---

## 📦 🧱 O que são essas camadas?

### Conforme explicado no seu PDF:

| Camada             | Função (resumida)                                                        |
| ------------------ | ------------------------------------------------------------------------ |
| **Application**    | Interface com o usuário final (e-mail, navegador, FTP etc.)              |
| **Presentation**   | Formata dados, converte codificação (ex: ASCII → UTF-8)                  |
| **Session**        | Cria e gerencia sessões de comunicação                                   |
| **Transport**      | Entrega fim a fim confiável (ex: TCP)                                    |
| **Network**        | Define rotas entre redes (endereços IP)                                  |
| **Data Link Ctrl** | Comunicação direta entre nós vizinhos (endereços MAC, controle de erros) |
| **Physical**       | Meio físico: bits elétricos, ondas, fios                                 |

---

## 🔁 O que significa “Virtual peer-to-peer connection”?

Significa que **cada camada se comunica logicamente com sua equivalente do outro lado**, embora os dados passem por todas as camadas inferiores.
Ou seja:

* A **camada de aplicação** da máquina A *“fala”* com a da máquina C
* A de transporte com a de transporte
* A de rede com a de rede, e assim por diante

⚠️ **Mas fisicamente**, os dados passam por **todas as camadas**, descendo na A, indo pela rede (B), e subindo na C.

---

## 🧭 Explicação da comunicação:

1. 🖥️ **Máquina A**:

   * Um programa (como navegador) gera uma mensagem.
   * A mensagem **desce pela pilha de protocolos**, ganhando cabeçalhos em cada camada.
   * Sai pela camada física (ex: cabo, Wi-Fi) em direção à rede.

2. 🔄 **Máquina B** (intermediária, como um **roteador**):

   * Só interpreta até a **camada de rede**.
   * Decide o melhor caminho e **reencaminha o pacote** para a próxima etapa (ex: para a máquina C).

3. 🖥️ **Máquina C**:

   * Recebe os sinais pela camada física.
   * **Sobe pelas camadas**, removendo os cabeçalhos em cada uma.
   * O dado final chega ao programa de destino (ex: navegador, e-mail).

---

## 🧠 Analogia Real:

Pense em uma carta sendo enviada:

* Você escreve o conteúdo (Aplicação)
* Coloca num envelope com idioma (Presentation)
* Escolhe forma de envio (Session)
* Anexa código de rastreio (Transporte)
* Define rota de entrega (Rede)
* Entrega no correio local (Enlace)
* Vai pelo caminhão/correios (Físico)

O carteiro (nó B) **não lê a carta**, só **encaminha com base no endereço**.

---

# 📦 **1. Pilha de protocolos de rede TCP/IP**


### 🔧 O que mostra essa imagem?

Ela mostra que, embora o **modelo ISO/OSI tenha 7 camadas**, a **pilha TCP/IP — que é a usada na Internet — tem menos camadas** (por simplicidade e eficiência). As camadas do modelo TCP/IP correspondem aproximadamente assim:

| Camada TCP/IP       | Equivalente ISO/OSI                             | Exemplos (da imagem)                          |
| ------------------- | ----------------------------------------------- | --------------------------------------------- |
| **Aplicação**       | Camadas 5 a 7 (Aplicação, Sessão, Apresentação) | HTTP, FTP, SMTP, Telnet, DNS, SNMP            |
| **Transporte**      | Camada 4                                        | **TCP**, **UDP**                              |
| **Internet (Rede)** | Camada 3                                        | **IP**                                        |
| **Acesso à rede**   | Camadas 1 e 2                                   | IEEE 802.x, X.25 (Ethernet, Wi-Fi, DSL, etc.) |

---

## 🔁 Protocolos destacados:

* **TCP**: Protocolo de transporte confiável. Garante que os pacotes cheguem em ordem e sem erros.
* **UDP**: Mais rápido, mas **não confiável** (não garante entrega nem ordem). Usado para vídeo ao vivo, jogos, etc.
* **IP**: Responsável pelo endereçamento e roteamento dos pacotes na Internet.
* **HTTP, FTP, SMTP**: Protocolos de aplicação — os que os usuários realmente usam.

---

## 🧠 Analogia:

Imagine que você envia várias caixas (dados) por correio:

* **TCP** verifica se todas chegaram e na ordem certa.
* **UDP** só joga as caixas para frente — se sumirem, paciência.
* **IP** define o endereço do destinatário.
* **Aplicação** é o conteúdo dentro da caixa.

---

# 🧱 **2. Estrutura do Pacote Ethernet (nível físico/enlace)**


### 📦 O que contém um pacote Ethernet?

| Campo (em bytes)       | Função                                            |
| ---------------------- | ------------------------------------------------- |
| `7` **Preamble**       | Ajuda a sincronizar o receptor (início do pacote) |
| `1` **SFD**            | Início efetivo da moldura (Start Frame Delimiter) |
| `6` **Destino**        | Endereço MAC do receptor                          |
| `6` **Origem**         | Endereço MAC de quem enviou                       |
| `2` **Tamanho**        | Tamanho do campo de dados                         |
| `0-1500` **Dados**     | Inclui dados + cabeçalhos das camadas superiores  |
| `0-46` **Padding**     | Preenchimento se os dados forem curtos demais     |
| `4` **Checksum (FCS)** | Verificação de erros (Frame Check Sequence)       |

> ⚠️ O segmento de dados inclui os **cabeçalhos das camadas superiores** (como TCP, IP, e dados da aplicação), empacotados dentro do campo "Data".

---

### 🧠 O que isso significa?

* Quando você envia algo (ex: uma página web), ela é dividida em pacotes.
* Cada pacote carrega:

  * os **dados reais** (ex: conteúdo da página),
  * e **informações de controle** (endereços, verificação, sequência etc).
* Mesmo que os pacotes cheguem **fora de ordem**, o protocolo **TCP no destino reordena**.

---

### 🔄 Como funciona a entrega:

1. Aplicação cria a mensagem.
2. TCP divide em segmentos.
3. IP rotula com endereços.
4. Ethernet empacota com endereços MAC e checksum.
5. O pacote é transmitido fisicamente (via cabo, Wi-Fi, etc).
6. No destino, as camadas removem os “envelopes” e entregam à aplicação.

---

## ✅ Conclusão

> A pilha TCP/IP é **mais enxuta** que a ISO/OSI e é **usada na prática** (como na Internet).
>
> Já o **pacote Ethernet** mostra como os dados viajam **fisicamente pela rede**, encapsulando cabeçalhos das camadas superiores junto com o conteúdo útil.


