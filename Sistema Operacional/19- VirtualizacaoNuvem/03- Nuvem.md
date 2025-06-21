## 🌩️ **O que é a Nuvem**

Modelo que permite o acesso remoto, sob demanda, a recursos de computação (como servidores, armazenamento, redes, software), normalmente pela internet, e com pagamento conforme o uso.

* **Disponível remotamente**: acessível de qualquer lugar pela internet.
* **Pague conforme o uso**: você só paga pelo que usar (sem comprar servidor).
* **Alta escalabilidade**: você pode aumentar ou diminuir os recursos conforme precisar.
* **Infraestrutura compartilhada**: vários usuários compartilham a mesma infraestrutura física, de forma isolada.

---

## 🧱 **A pilha da Nuvem (cloud stack)**

Ela é dividida em 3 camadas principais:


## 🔹 **1. IaaS – Infrastructure as a Service (Infraestrutura como Serviço)**

### 📌 O que é:

É a **base da nuvem**. O provedor te entrega **infraestrutura bruta** (servidores, rede, armazenamento) como se fosse um "computador vazio na nuvem".

---

### 🧠 Quem usa:

* **Administradores de sistemas**

---

### 👷 O que você faz:

* Instala e configura o sistema operacional (Windows, Linux…)
* Configura segurança, redes, firewalls
* Gerencia os dados, backups, escalabilidade, etc

---

### ✅ Exemplo real (do PDF):

**Amazon EC2**:

* Você escolhe o tamanho da máquina (ex: 2 vCPUs, 1,7 GB RAM, etc.)
* Paga por hora de uso: R\$ 0,02/hora até R\$ 2,10/hora (dependendo da máquina)
* Armazenamento cobrado por GB/mês

---

### 🔧 Responsabilidades:

| Item                       | Quem gerencia |
| -------------------------- | ------------- |
| Hardware físico            | Provedor      |
| Virtualização (hypervisor) | Provedor      |
| Sistema operacional        | **Você**      |
| Aplicações                 | **Você**      |

---

### 🎯 Analogia:

> Como **alugar um terreno vazio**. Você constrói a casa, instala a água, a luz, e cuida de tudo. O terreno (infraestrutura) é seu para fazer o que quiser.

---


## 🔹 **2. PaaS – Platform as a Service (Plataforma como Serviço)**

### 📌 O que é:

Você recebe uma **plataforma pronta** para programar e implantar sua aplicação, **sem se preocupar com o sistema operacional ou servidor**.

---

### 🧠 Quem usa:

* **Desenvolvedores**

---

### 👷 O que você faz:

* Apenas sobe seu código (ex: app em Java, Node.js, Python…)
* O provedor cuida do resto: escalabilidade, deploy, atualizações
* Ideal para projetos que precisam crescer rápido sem perder tempo com infraestrutura

---

### ✅ Exemplos:

* **Heroku**
* **Google App Engine**
* **Elastic Beanstalk (AWS)**
* **Red Hat OpenShift**
* Outros: Dokku, Apprenda, Cloud Foundry, OKD

---

### 🔧 Responsabilidades:

| Item                         | Quem gerencia |
| ---------------------------- | ------------- |
| Hardware físico              | Provedor      |
| Sistema operacional          | Provedor      |
| Plataforma (Java, Node, etc) | Provedor      |
| Código da aplicação          | **Você**      |

---

### 🎯 Analogia:

> Como **alugar uma cozinha profissional** já pronta. Você só leva os ingredientes (seu código) e começa a cozinhar (programar e rodar a aplicação).

---

## 🔹 **3. SaaS – Software as a Service (Software como Serviço)**

### 📌 O que é:

São **aplicações completas**, prontas para uso. Você não precisa instalar nem configurar nada, só acessar via navegador ou app.

---

### 🧠 Quem usa:

* **Usuários finais**
* Qualquer pessoa que precisa de um serviço online (email, armazenamento, rede social, etc.)

---

### 👷 O que você faz:

* Apenas **usa** o software
* Não vê código, não mexe em servidores

---

### ✅ Exemplos (do PDF/imagens):

* Google Drive, YouTube, Netflix
* Facebook, Dropbox, Twitter
* DocuSign, JIRA, HubSpot

---

### 🔧 Responsabilidades:

| Item                    | Quem gerencia |
| ----------------------- | ------------- |
| Tudo (infra + software) | **Provedor**  |

---

### 🎯 Analogia:

> Como **pedir uma pizza pronta por app**. Você só come (usa). Não cozinha, não limpa, não instala nada.

---

## 📊 Comparação geral (resumo visual)

| Nível              | Camada   | O que você controla       | Exemplo              | Perfil do usuário     |
| ------------------ | -------- | ------------------------- | -------------------- | --------------------- |
| 🔧 Máximo controle | **IaaS** | Sistema operacional, apps | AWS EC2              | Admins/Infraestrutura |
| ⚙️ Médio controle  | **PaaS** | Só o código               | Heroku, App Engine   | Desenvolvedores       |
| ✅ Nenhum controle  | **SaaS** | Só usa                    | Google Docs, Netflix | Usuário final         |

---

## 🎯 Analogia simples

Imagina que você quer vender pizza online:

| Camada   | Analogia com pizzaria                                           |
| -------- | --------------------------------------------------------------- |
| **IaaS** | Te entregam o **forno**, gás, ingredientes. Você faz tudo.      |
| **PaaS** | Te dão a **cozinha pronta**, só precisa montar a pizza e assar. |
| **SaaS** | Você **compra a pizza pronta**. Só come.                        |

---

Se quiser, posso montar um PDF de resumo ou um mapa mental disso. Deseja?

## 💡 Resumo visual com base nas imagens

A primeira imagem (pirâmide):

* Mostra hierarquia de uso: **admin → dev → usuário**.
* SaaS está no topo, pois é o mais "pronto".
* IaaS está na base, porque exige mais conhecimento técnico.

A segunda imagem (tabelas):

* Mostra exemplos populares organizados por camada.
* Visualmente ajuda a identificar serviços e associar com o tipo de nuvem.

