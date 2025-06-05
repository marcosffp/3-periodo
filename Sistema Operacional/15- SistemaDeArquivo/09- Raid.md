## 📌 Tema Geral: **RAID**

**RAID** significa “**Conjunto Redundante de Discos Independentes**” (em inglês: *Redundant Array of Independent Disks*).
É uma **técnica de organização de discos rígidos** para melhorar desempenho, redundância (segurança dos dados) ou ambos.

---

### 🧩 Parte 1: RAID 0

No quadro, à esquerda, temos o esquema do **RAID 0**:

📂 Ele divide os dados entre os discos.
Cada pedaço do arquivo é armazenado em um disco diferente — isso se chama **striping**.

**Exemplo da imagem:**

* Dados A1, A2, A3, A4 estão divididos entre os dois discos.
* O disco 1 tem: A1, A3
* O disco 2 tem: A2, A4

#### ✅ Vantagens:

* **Desempenho alto**: leitura e escrita são feitas em paralelo (os dois discos trabalham ao mesmo tempo).
* **Ótimo para velocidade** (ex: jogos, edição de vídeo).

#### ❌ Desvantagens:

* **Sem redundância**: se **um disco falha**, você **perde todos os dados**.
* **Não indicado para dados importantes.**

---

### 🧩 Parte 2: RAID 1

No meio da imagem temos o **RAID 1**, que funciona com **espelhamento (mirror)**:

📂 Os dados são **copiados integralmente em ambos os discos**.

**Exemplo da imagem:**

* Disco 1: A1, A2, A3, A4
* Disco 2: A1, A2, A3, A4 (espelho exato do primeiro)

#### ✅ Vantagens:

* **Alta confiabilidade**: se um disco falhar, o outro tem uma cópia completa.
* **Boa leitura**: pode ler de ambos os discos em paralelo.

#### ❌ Desvantagens:

* **Espaço desperdiçado**: só metade da capacidade total é usada.
* **Mais caro**: precisa de o dobro de discos para armazenar o mesmo volume.

---
