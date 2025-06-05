💾 VAZÃO (THROUGHPUT) E LATÊNCIA EM DISPOSITIVOS DE ARMAZENAMENTO
❓ O que são vazão e latência?
Vazão (Throughput): Velocidade de leitura/escrita (ex: 200 MB/s ou 7000 MB/s)

Latência: Tempo de resposta entre pedido e início da operação (ex: 10 ms ou 0,1 ms)

🧠 Importância
Afetam diretamente o desempenho do sistema. Alta vazão + baixa latência = melhor performance.

💽 HDD (HARD DISK DRIVE)
⚙️ Funcionamento
Dispositivo mecânico com discos giratórios e cabeça de leitura móvel.

📉 Fatores de performance
Velocidade de rotação (5400/7200 RPM)

Seek time (tempo de busca)

Material dos discos

📈 Características
Vazão: ~200 MB/s

Latência: ~10 ms

Partes móveis → vulnerável a choques

Vida útil longa (sem limite de escritas)

⚡ SSD (SOLID STATE DRIVE)
⚙️ Funcionamento
Memória flash NAND sem partes móveis, acesso eletrônico.

📈 Características
Vazão: até 7000 MB/s

Latência: ~0,1 ms

Resistente a choques

Vida útil limitada (ciclos de escrita)

💡 Limitação
Células flash se desgastam com escritas → requer wear leveling.

🛡️ CUIDADOS COM SSD
✅ Boas práticas:
Evitar logs excessivos

Usar cache RAM quando possível

Ativar TRIM

Manter 20%+ espaço livre

Usar sistemas de arquivos otimizados (F2FS, ext4 com TRIM)

⚖️ COMPARATIVO HDD vs SSD
Característica	HDD	SSD
Tecnologia	Magnética (discos)	Flash NAND
Vazão	~200 MB/s	Até 7000 MB/s
Latência	~10 ms	~0,1 ms
Partes móveis	Sim	Não
Resistência	Baixa	Alta
Vida útil	Longa	Limitada (escritas)
Custo/GB	Baixo	Alto
🖼️ ARMAZENAMENTO DE IMAGENS
HDD
Dados armazenados como campos magnéticos em setores

Fragmentação possível

SSD
Dados armazenados como cargas elétricas em páginas/blocos

Wear leveling distribui escritas

🗑️ EXCLUSÃO DE DADOS
HDD
Só marca como livre (dados permanecem até sobrescritos)

Pode recuperar com ferramentas forenses

SSD
Marca páginas como inválidas

Requer TRIM para apagar fisicamente

Garbage collection reorganiza blocos

❗ POR QUE SSD NÃO SOBRESCREVE DIRETO?
Só escreve em páginas vazias

Precisa apagar blocos inteiros antes de reescrever

Usa garbage collection para limpar espaços inválidos

🎯 QUANDO USAR CADA UM
HDD: Armazenamento barato de grande volume

SSD: SO, aplicações críticas, performance