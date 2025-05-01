
1. **Endereço físico**: É o endereço real na memória RAM onde os dados ou instruções de um processo são armazenados.

2. **Endereço virtual**: É o endereço usado pelo processo, traduzido para físico pelo sistema operacional, permitindo isolamento e segurança.

3. **Segmento**: É uma porção de memória atribuída a um processo, como código, dados ou pilha, usada para facilitar a organização e o acesso.

4. **Geradores de endereços**: São responsáveis por calcular os endereços de memória usados durante a execução, podendo atuar em tempo de compilação, carregamento ou execução.

5. **Uniprogramação**: Apenas um processo reside na memória por vez, simplificando o gerenciamento, mas sem permitir multitarefa.

6. **Multiprogramação**: Vários processos compartilham a memória simultaneamente, exigindo mecanismos eficientes de proteção e alocação.

7. **Relocação**: É o ajuste de endereços de um processo para que ele possa ser carregado em qualquer parte da memória.

8. **Relocação estática**: Os endereços são ajustados uma única vez no momento do carregamento, fixando a posição do processo na memória.

9. **Relocação dinâmica**: O hardware ajusta os endereços em tempo de execução com registradores base e limite, permitindo mover processos na memória.

10. **Alocação de memória**: É a tarefa do SO de decidir onde na memória um processo será colocado, considerando os espaços livres disponíveis.

11. **Fragmentação**: É o desperdício de espaço na memória, causado por má alocação ou desalocação de processos.

12. **Fragmentação externa**: Ocorre quando há espaço total suficiente, mas espalhado em pequenos blocos que não podem ser usados por processos maiores.

13. **Fragmentação interna**: É o espaço desperdiçado dentro de um bloco de memória alocado, por não ser totalmente aproveitado pelo processo.

14. **Compactação**: Consiste em mover processos na memória para juntar espaços livres e reduzir a fragmentação externa.

15. **Swap**: É a troca temporária de processos entre memória e disco, liberando espaço na RAM para outros processos.

16. **Paginação**: Divide a memória em páginas de tamanho fixo, permitindo alocação não contígua e eliminando a fragmentação externa.





| **Tópico**                | **Relação com Gerenciamento de Memória**                          |
|--------------------------|--------------------------------------------------------------------|
| Endereço físico          | Local real na RAM.                                                |
| Endereço virtual         | Endereço usado pelo processo.                                     |
| Segmento                 | Bloco de memória de um processo.                                  |
| Geradores de endereços   | Determinam onde acessar na memória.                              |
| Uniprogramação           | Um processo por vez na memória.                                   |
| Multiprogramação         | Vários processos compartilham a memória.                         |
| Relocação                | Ajuste do processo à posição na memória.                          |
| Relocação estática       | Ajuste fixo no carregamento.                                     |
| Relocação dinâmica       | Ajuste em tempo de execução.                                     |
| Alocação de memória      | Escolha de onde colocar o processo.                              |
| Fragmentação             | Espaço desperdiçado na memória.                                   |
| Fragmentação externa     | Espaço livre não contíguo.                                        |
| Fragmentação interna     | Espaço não usado dentro do bloco.                                |
| Compactação              | Junta espaços livres.                                             |
| Swap                     | Move processos entre RAM e disco.                                |
| Paginação                | Divide memória em páginas fixas, não contíguas.                   |


