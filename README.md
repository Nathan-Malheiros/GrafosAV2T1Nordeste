# Resolução de Problemas com Grafos - Região Nordeste

Trabalho prático desenvolvido para a disciplina de Teoria dos Grafos, orientado pelo **Prof. Me. Ricardo Carubbi**. O projeto consiste na modelagem das fronteiras terrestres dos estados do Nordeste brasileiro e na aplicação de algoritmos de busca (DFS e BFS).

## 👥 Equipe
* Nathan
* Marcos
* Julia

## 📋 Sobre o Projeto
O programa utiliza a biblioteca `algs4` para representar os estados como vértices e suas fronteiras como arestas. A partir de um estado de origem e um de destino, o sistema realiza buscas para identificar conectividade, caminhos e a ordem de exploração dos algoritmos.

### Estados Mapeados (Ordem Alfabética)
0: AL | 1: BA | 2: CE | 3: MA | 4: PB | 5: PE | 6: PI | 7: RN | 8: SE

## 🛠️ Funcionalidades
O programa responde a seis perguntas fundamentais:
1. É possível chegar do estado X ao estado Y?
2. Qual o caminho encontrado pela **DFS** (Busca em Profundidade)?
3. Qual o caminho encontrado pela **BFS** (Busca em Largura)?
4. Quais estados são alcançáveis a partir da origem?
5. Qual a ordem de visitação da **DFS**?
6. Qual a ordem de visitação da **BFS**?

## 📂 Estrutura de Pastas
```text
trabalho-bfs-dfs/
├── data/
│   ├── nordeste.txt   # Definição do Grafo (V, E e Arestas)
│   └── input.txt      # Siglas de Origem e Destino (Ex: CE BA)
└── src/
    ├── Main.java             # Ponto de entrada do programa
    ├── Graph.java            # Estrutura do Grafo
    ├── DepthFirstPaths.java  # Algoritmo DFS (com registro de ordem)
    ├── BreadthFirstPaths.java# Algoritmo BFS (com registro de ordem)
    └── ... (demais dependências da algs4)