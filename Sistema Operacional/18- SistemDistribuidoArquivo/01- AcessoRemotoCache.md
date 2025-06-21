## 📁 Acesso remoto a arquivos e cache

### 🧠 Como o acesso acontece?

Quando você (usuário) quer abrir um arquivo **que está em outro computador (servidor)**, o sistema operacional pode agir de duas formas:

---

### ✅ **1. Acesso remoto direto (serviço remoto)**

* O arquivo **fica no servidor**.
* O seu computador **manda um pedido** (via **RPC**, que é uma chamada remota).
* O servidor **executa a ação** (ler, escrever, etc.) e **retorna o resultado**.

📌 Exemplo: você edita um arquivo no Google Docs – o documento está no servidor, você só vê o resultado.

#### ✔️ Vantagens:

* Sempre acessa a **versão mais atualizada** do arquivo.
* **Sem problemas de sincronização**, pois o servidor centraliza tudo.
* Menos risco de **conflito entre clientes**.

#### ❌ Desvantagens:

* **Desempenho mais lento**, pois cada operação exige comunicação com o servidor.
* **Alta carga na rede** (toda leitura ou escrita vai para o servidor).
* **Menor tolerância a falhas**: se o servidor estiver fora do ar, você não consegue trabalhar.

---

### ✅ **2. Acesso com cache (cópia local)**

* O arquivo (ou parte dele) é **copiado para seu computador**.
* Você acessa localmente essa cópia.
* Isso é mais rápido, mas traz problemas de **sincronização**.

📌 Exemplo: baixar um documento do Google Drive, editar offline e depois subir de novo.

#### ✔️ Vantagens:

* **Desempenho mais rápido**, pois os acessos são locais.
* **Menor uso da rede**, principalmente em leituras repetidas.
* Funciona **mesmo offline** (ex: editar durante uma viagem).

#### ❌ Desvantagens:

* Pode haver **inconsistência**: a cópia local pode ficar desatualizada em relação ao servidor.
* **Conflitos** se vários usuários editarem a mesma coisa ao mesmo tempo.
* Exige políticas de **sincronização e verificação** (mais complexidade no sistema).

---

## 📌 Problemas de Cache

Quando usamos cache (armazenamento local), aparecem alguns desafios:

1. **Onde guardar?**

   * Disco local? Memória RAM?

2. **Quando gravar de volta no servidor?**

   * Toda hora? Só no final?

3. **E se vários usuários editarem o mesmo arquivo ao mesmo tempo?**

   * Como garantir que as alterações não se sobreponham? (consistência)

---

## 🗂️ Onde guardar o cache?

### 🖴 **Disco local**

* ✅ Vantagens:

  * Resistente a falhas (se o PC desligar, os dados estão no disco)
  * Bom para arquivos grandes
* ❌ Desvantagens:

  * Mais lento do que a memória RAM
  * Precisa ter um disco

---

### 💾 **Memória local (RAM)**

* ✅ Vantagens:

  * **Muito rápido**
  * Funciona até em computadores **sem disco**
* ❌ Desvantagens:

  * Se desligar o PC, perde tudo
  * Memória limitada
  * Difícil manter sincronização com o servidor

---

## 🔄 **Políticas de Atualização da Cache**

*(Ou seja, **quando** e **como** as alterações feitas localmente são enviadas de volta ao servidor)*

Quando você usa cache para editar arquivos remotamente, **existem duas formas principais de lidar com a gravação** no servidor:

---

### 📝 **1. Write-through (gravação imediata)**

📌 **Como funciona:**
Cada vez que o usuário faz uma modificação, **essa mudança é enviada diretamente para o servidor** antes de continuar o processamento.

📌 **Exemplo prático:**
Você edita uma planilha no Excel remoto. A cada célula alterada, o sistema já envia essa alteração para o servidor.

#### ✅ Vantagens:

* Alta **segurança e confiabilidade**: o servidor sempre tem a versão mais atual.
* Evita perda de dados em caso de queda do cliente.

#### ❌ Desvantagens:

* **Mais lento**, porque cada gravação exige comunicação com o servidor.
* **Mais carga na rede**, o que pode impactar o desempenho geral.

---

### 🗂️ **2. Write-back (gravação postergada)**

📌 **Como funciona:**
As alterações feitas localmente são **guardadas na cache**, e só depois são enviadas ao servidor. Isso pode acontecer:

* Quando o arquivo é **fechado**;
* Quando um **bloco sai da cache** (substituição);
* Ou **periodicamente** (ex: a cada 30 segundos).

📌 **Exemplo prático:**
Você edita um documento no Word, mas as alterações ficam salvas localmente até você fechar o arquivo ou até o sistema decidir sincronizar.

#### ✅ Vantagens:

* **Desempenho muito melhor**: menos tráfego de rede.
* Evita gravar várias vezes a mesma coisa (por exemplo, se você ficar mudando o mesmo parágrafo).

#### ❌ Desvantagens:

* **Maior risco de perda de dados**: se o PC travar antes de enviar, as alterações somem.
* Pode causar **inconsistência**, se vários usuários editarem ao mesmo tempo.

---

Claro! Vamos **explicar com calma e de forma clara** esses dois tópicos: **políticas de atualização da cache** e **consistência do cache**, ambos essenciais para o funcionamento de sistemas de arquivos distribuídos.

---

## 🔄 **Políticas de Atualização da Cache**

*(Ou seja, **quando** e **como** as alterações feitas localmente são enviadas de volta ao servidor)*

Quando você usa cache para editar arquivos remotamente, **existem duas formas principais de lidar com a gravação** no servidor:

---

### 📝 **1. Write-through (gravação imediata)**

📌 **Como funciona:**
Cada vez que o usuário faz uma modificação, **essa mudança é enviada diretamente para o servidor** antes de continuar o processamento.

📌 **Exemplo prático:**
Você edita uma planilha no Excel remoto. A cada célula alterada, o sistema já envia essa alteração para o servidor.

#### ✅ Vantagens:

* Alta **segurança e confiabilidade**: o servidor sempre tem a versão mais atual.
* Evita perda de dados em caso de queda do cliente.

#### ❌ Desvantagens:

* **Mais lento**, porque cada gravação exige comunicação com o servidor.
* **Mais carga na rede**, o que pode impactar o desempenho geral.

---

### 🗂️ **2. Write-back (gravação postergada)**

📌 **Como funciona:**
As alterações feitas localmente são **guardadas na cache**, e só depois são enviadas ao servidor. Isso pode acontecer:

* Quando o arquivo é **fechado**;
* Quando um **bloco sai da cache** (substituição);
* Ou **periodicamente** (ex: a cada 30 segundos).

📌 **Exemplo prático:**
Você edita um documento no Word, mas as alterações ficam salvas localmente até você fechar o arquivo ou até o sistema decidir sincronizar.

#### ✅ Vantagens:

* **Desempenho muito melhor**: menos tráfego de rede.
* Evita gravar várias vezes a mesma coisa (por exemplo, se você ficar mudando o mesmo parágrafo).

#### ❌ Desvantagens:

* **Maior risco de perda de dados**: se o PC travar antes de enviar, as alterações somem.
* Pode causar **inconsistência**, se vários usuários editarem ao mesmo tempo.

---

## 📏 **Consistência do Cache**

*(Ou seja, como garantir que as cópias locais não fiquem desatualizadas ou incorretas)*

Isso é especialmente importante no **método write-back**, onde as alterações não são imediatas.

Existem duas abordagens principais:

---

### 👨‍💻 **1. Consistência iniciada pelo cliente**

📌 O próprio cliente verifica com o servidor:
"Minha cópia está atual ou já foi modificada por outro?"

🛠️ Pode fazer isso:

* A **cada acesso** ao arquivo.
* Em **intervalos de tempo**.
* **Somente ao abrir** o arquivo.

#### ✅ Vantagem:

* Mais controle por parte do cliente.

#### ❌ Desvantagem:

* Pode haver janelas de inconsistência (ex: se só verifica ao abrir, mas o arquivo muda depois).

---

### 🖥️ **2. Consistência iniciada pelo servidor**

📌 O servidor fica **monitorando quais clientes** armazenaram quais arquivos em cache, e identifica se há possíveis **conflitos** (por exemplo, dois clientes modificando o mesmo arquivo).

Se detectar conflito, ele:

* **Invalida o cache** do cliente desatualizado;
* Pode **avisar** o cliente para buscar uma nova cópia.

#### ✅ Vantagem:

* Mais eficiente para ambientes com **vários usuários acessando ao mesmo tempo**.

#### ❌ Desvantagem:

* O servidor precisa **rastrear e guardar informações sobre os clientes**, o que aumenta a complexidade.

---

## ✅ Resumo Rápido

| Estratégia            | Vantagens                         | Desvantagens                          |
| --------------------- | --------------------------------- | ------------------------------------- |
| **Write-through**     | Seguro, sempre atualizado         | Mais lento, tráfego alto na rede      |
| **Write-back**        | Rápido, menos tráfego             | Pode perder dados e causar conflito   |
| **Cliente verifica**  | Simples, cliente controla         | Pode haver inconsistência sem aviso   |
| **Servidor verifica** | Mais robusto, servidor centraliza | Complexo, exige rastreamento de cache |

---

### ✅ **1. Onde e quando os blocos de arquivos são armazenados em cache?**

**📍 Onde:**

* Em geral, no **disco local** ou na **memória RAM** do computador cliente:

  * **Disco local**: mais seguro, persiste após falhas, mas mais lento.
  * **Memória RAM**: mais rápido, ideal para estações sem disco, mas perde tudo se desligar.

**📍 Quando:**

* No momento em que o **arquivo remoto é acessado** (por leitura ou escrita), o sistema pode **copiar blocos do arquivo para o cache** local.
* Isso pode ser feito **por demanda** (on-demand) ou de forma **antecipada** (prefetching).

---

### ✅ **2. Quando as modificações são propagadas de volta para o arquivo remoto?**

Isso depende da **política de atualização da cache**:

🔸 **Write-through (gravação imediata)**:

* A **cada modificação**, o sistema **envia a alteração imediatamente para o servidor**.
* Isso garante que o servidor tenha sempre a versão mais atual.

🔸 **Write-back (gravação atrasada)**:

* As alterações **ficam temporariamente na cache local** e só são enviadas para o servidor:

  * Quando o **arquivo é fechado**;
  * Quando um **bloco é removido do cache**;
  * Ou **periodicamente** (por exemplo, a cada 30 segundos).

---

### ✅ **3. O que acontece se vários clientes armazenarem em cache o mesmo arquivo?**

Esse é um problema de **consistência de cache**.

❗ **Risco**:

* Se dois ou mais clientes editarem a mesma cópia local do arquivo sem sincronização, podem ocorrer **conflitos e sobrescritas de dados**.

📌 **Soluções:**

🔹 **Consistência iniciada pelo cliente**:

* O cliente verifica com o servidor se sua cópia ainda está atual.
* Pode fazer isso:

  * A cada acesso,
  * Em intervalos regulares,
  * Ou ao abrir o arquivo.

🔹 **Consistência iniciada pelo servidor**:

* O servidor **controla quem tem cache** de qual arquivo.
* Ele pode **invalidar as cópias desatualizadas** ou avisar os clientes para recarregarem os dados.

---

### ✅ Resumo Tabela

| Questão                                                    | Resposta resumida                                                            |
| ---------------------------------------------------------- | ---------------------------------------------------------------------------- |
| **Onde e quando o cache é feito?**                         | No disco ou na RAM; quando o arquivo é acessado                              |
| **Quando as mudanças vão para o servidor?**                | Imediatamente (write-through) ou depois (write-back: fechar, remover ou 30s) |
| **E se vários clientes tiverem o mesmo arquivo em cache?** | Pode causar conflito; usa-se consistência por cliente ou por servidor        |

---

## 🧠 Estado do Servidor

Quando falamos de **servidores em sistemas de arquivos distribuídos**, podemos classificá-los em dois tipos: **stateful (com estado)** e **stateless (sem estado)**.

---

### 🗂️ **1. Servidor com estado (Stateful)**

📌 **O que é?**
O servidor **lembra informações** sobre o que cada cliente está fazendo.

📌 **Exemplo:**

* Se você abre um arquivo e começa a editar, o servidor **guarda essa informação** (quem abriu, qual posição do cursor, etc.).

#### ✅ Vantagens:

* Pode ser **mais eficiente**: já conhece o cliente e mantém contexto.
* **Menos repetição** de dados entre as requisições.

#### ❌ Desvantagens:

* **Mais frágil**: se o servidor reiniciar ou falhar, **perde o estado** dos clientes.
* Mais difícil de tolerar falhas.

---

### 🧾 **2. Servidor sem estado (Stateless)**

📌 **O que é?**
O servidor **não guarda nada** entre uma requisição e outra. Cada pedido do cliente deve conter **todas as informações necessárias**.

📌 **Exemplo:**

* Toda vez que você salva, precisa mandar o nome do arquivo, a posição, o conteúdo, etc., porque o servidor **não lembra** da sessão anterior.

#### ✅ Vantagens:

* **Mais tolerante a falhas**: se o servidor reiniciar, não precisa restaurar nada.
* Mais simples de gerenciar.

#### ❌ Desvantagens:

* **Desempenho menor**: o cliente tem que repetir dados a todo momento.
* Mais **tráfego na rede**.

---

### 🔁 Trade-off (equilíbrio entre os dois)

* **Servidor com estado** → melhor desempenho, **pior tolerância a falhas**.
* **Servidor sem estado** → mais simples, **melhor para redes instáveis ou sistemas críticos**.

---

## 📡 Replicação

Em sistemas distribuídos, **replicação** significa **ter cópias dos mesmos arquivos em vários servidores diferentes**.

📌 **Por que fazer isso?**

* Para **aumentar a disponibilidade** (se um servidor cair, outro assume).
* Para **melhorar o desempenho** (acessar o servidor mais próximo).
* Para **balancear a carga** (vários clientes acessando diferentes réplicas).

---

### ⚠️ Desafio: **Consistência entre réplicas**

Se um cliente modifica um arquivo **em uma réplica**, **as outras precisam ser atualizadas também**.

#### ✅ O sistema precisa:

* Detectar quando um arquivo foi modificado.
* **Sincronizar as réplicas** rapidamente.
* Lidar com **conflitos** se dois clientes editarem o mesmo arquivo em servidores diferentes.

---

### 📌 Exemplo prático de replicação:

* Um mesmo arquivo está salvo em 3 servidores.
* O usuário A edita no servidor 1.
* O sistema deve **propagar essa edição** para os servidores 2 e 3.
* Caso contrário, os usuários B e C podem ver versões diferentes!

---

## ✅ Resumo Final

| Conceito                      | Definição                                            | Vantagens                                    | Desvantagens                                         |
| ----------------------------- | ---------------------------------------------------- | -------------------------------------------- | ---------------------------------------------------- |
| **Servidor com estado**       | Guarda o que cada cliente está fazendo               | Melhor desempenho                            | Mais vulnerável a falhas                             |
| **Servidor sem estado**       | Não armazena nenhuma informação entre requisições    | Mais tolerante a falhas, simples             | Desempenho menor, mais tráfego                       |
| **Replicação**                | Mesmos dados copiados em vários servidores           | Alta disponibilidade, balanceamento de carga | Risco de inconsistência entre réplicas               |
| **Consistência das réplicas** | Manter todas as cópias sincronizadas após alterações | Evita conflito de versões                    | Complexidade de controle, sincronização mais difícil |

---





