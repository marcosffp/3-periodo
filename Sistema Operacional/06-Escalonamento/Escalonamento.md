# Escalonamento de Processos

## Introdução
O escalonamento de processos é uma das funções fundamentais de um sistema operacional, garantindo que os processos sejam executados de maneira eficiente e justa. Como um computador geralmente possui apenas um processador, é necessário um método para decidir qual processo será executado a seguir. Essa decisão é feita pelo escalonador de CPU.

## O que é um Processo?
Um **processo** é um programa em execução, consumindo recursos como CPU e memória. Ele pode estar em três estados principais:
- **Executando**: Quando está utilizando a CPU.
- **Pronto**: Quando está aguardando para ser executado.
- **Bloqueado**: Quando está esperando por um evento externo (como uma leitura de disco).

## Tipos de Escalonamento
O escalonamento de processos pode ser classificado em diferentes categorias:
1. **Escalonamento de Longo Prazo**: Decide quais processos serão carregados na memória.
2. **Escalonamento de Curto Prazo**: Define qual processo da fila de prontos será executado pela CPU.
3. **Escalonamento de Médio Prazo**: Remove processos temporariamente da memória para otimizar a execução de outros (swapping).

## Algoritmos de Escalonamento
Diferentes algoritmos são utilizados para escolher qual processo será executado a seguir:

### 1. **FCFS (First Come, First Served)**
- **Conceito**: Processos são atendidos na ordem de chegada.
- **Exemplo**: Uma fila de pessoas no supermercado.
- **Vantagem**: Simples de implementar.
- **Desvantagem**: Pode causar tempos de espera longos.

### 2. **Round Robin (RR)**
- **Conceito**: Cada processo recebe um tempo fixo de CPU (quantum) antes de ser preemptado.
- **Exemplo**: Um jogo de tabuleiro onde cada jogador tem um tempo limite.
- **Vantagem**: Justo para todos os processos.
- **Desvantagem**: Pequenos quantums podem gerar muitas trocas de contexto.

### 3. **SJF (Shortest Job First)**
- **Conceito**: O processo mais curto é executado primeiro.
- **Exemplo**: Um caixa de supermercado priorizando quem tem menos itens.
- **Vantagem**: Minimiza o tempo médio de espera.
- **Desvantagem**: Pode causar inanição de processos longos.

### 4. **SRTF (Shortest Remaining Time First)**
- **Conceito**: Variante preemptiva do SJF.
- **Exemplo**: Um cliente novo no supermercado com menos itens tem prioridade sobre quem está no meio da compra.
- **Vantagem**: Reduz ainda mais o tempo de espera médio.
- **Desvantagem**: Difícil de prever o tempo exato de execução dos processos.

### 5. **Filas Multinível (MLQ - Multilevel Queue)**
- **Conceito**: Divide processos em filas de prioridade, cada uma com seu próprio algoritmo.
- **Exemplo**: Um hospital onde emergências são atendidas primeiro.
- **Vantagem**: Equilibra justiça e eficiência.
- **Desvantagem**: Difícil ajustar corretamente os níveis de prioridade.

### 6. **Escalonamento por Loteria**
- **Conceito**: Cada processo recebe um número de bilhetes e, a cada ciclo, um bilhete é sorteado para decidir qual processo será executado.
- **Exemplo**: Uma rifa onde quem tem mais bilhetes tem mais chances de ganhar.
- **Vantagem**: Evita inanição, pois todos têm alguma chance de serem escalonados.
- **Desvantagem**: Pode não ser justo em alguns casos.

## Troca de Contexto
Sempre que um processo é interrompido e outro começa a ser executado, ocorre uma **troca de contexto**. Isso significa salvar o estado do processo atual e carregar o estado do novo processo.
- **Quem faz a troca de contexto?** O sistema operacional.
- **Quando ocorre?**
  - Quando um processo é interrompido.
  - Quando um processo termina.
  - Quando o tempo do processo no Round Robin acaba.

## Interrupções e Timer
Uma **interrupção** ocorre quando um evento externo faz a CPU pausar o que está fazendo para executar outra tarefa.
- **Exemplo**: Atender uma ligação enquanto assiste a um filme.
- O **timer** controla o tempo que cada processo pode usar a CPU antes de ser interrompido.

## Sistemas Interativos x Batch
- **Sistemas Interativos**: Precisam de respostas rápidas (ex: um site responsivo).
- **Sistemas Batch**: Executam tarefas longas sem interação do usuário (ex: processamento de dados em servidores).

## Conclusão
O escalonamento de processos é essencial para gerenciar o tempo da CPU de forma eficiente. Diferentes algoritmos possuem vantagens e desvantagens, sendo escolhidos conforme as necessidades do sistema. O sistema operacional usa troca de contexto, interrupções e um timer para alternar entre processos de forma inteligente.

