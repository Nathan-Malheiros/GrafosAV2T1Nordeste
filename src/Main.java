import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Dicionario de Estados (Ordem Alfabética Rigorosa)
        String[] siglas = { "AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE" };
        Map<String, Integer> siglaParaId = new HashMap<>();
        for (int i = 0; i < siglas.length; i++) {
            siglaParaId.put(siglas[i], i);
        }

        // 2. Leitura dos Arquivos
        // Carrega o grafo do arquivo nordeste.txt
        In inGrafo = new In("data/nordeste.txt");
        Graph G = new Graph(inGrafo);

        // Carrega origem e destino do arquivo input.txt
        In inParam = new In("data/input.txt");
        if (!inParam.hasNextLine()) {
            StdOut.println("Erro: Arquivo input.txt vazio.");
            return;
        }

        String origemStr = inParam.readString().toUpperCase();
        String destinoStr = inParam.readString().toUpperCase();

        // Converte siglas para IDs numéricos para os algoritmos
        int s = siglaParaId.get(origemStr);
        int t = siglaParaId.get(destinoStr);

        DepthFirstPaths dfs = new DepthFirstPaths(G, s);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        // 4. Exibicão dos Resultados (Formatada conforme o Trabalho)
        StdOut.println("========================================");
        StdOut.println("RESULTADOS: " + origemStr + " -> " + destinoStr);
        StdOut.println("========================================");

        // Pergunta 1: Conectividade
        StdOut.println("1. Alcancavel? " + (dfs.hasPathTo(t) ? "Sim" : "Não"));

        // Pergunta 2: Caminho DFS
        imprimirCaminho("2. Caminho DFS", dfs.pathTo(t), siglas);

        // Pergunta 3: Caminho BFS
        imprimirCaminho("3. Caminho BFS", bfs.pathTo(t), siglas);

        // Pergunta 4: Estados alcancaveis a partir de X
        StdOut.print("4. Alcancaveis de " + origemStr + ": ");
        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.print(siglas[v] + " ");
            }
        }
        StdOut.println();

        // Pergunta 5: Ordem de Visita DFS
        imprimirSequencia("5. Ordem de visita DFS", dfs.getVisitOrder(), siglas);

        // Pergunta 6: Ordem de Visita BFS
        imprimirSequencia("6. Ordem de visita BFS", bfs.getVisitOrder(), siglas);

        StdOut.println("========================================");
    }

    // Método auxiliar para imprimir caminhos (P2 e P3)
    private static void imprimirCaminho(String label, Iterable<Integer> path, String[] nomes) {
        StdOut.print(label + ": ");
        if (path == null) {
            StdOut.println("Não existe caminho.");
        } else {
            boolean first = true;
            for (int v : path) {
                if (!first)
                    StdOut.print(" -> ");
                StdOut.print(nomes[v]);
                first = false;
            }
            StdOut.println();
        }
    }

    // Método auxiliar para imprimir ordens de visita (P5 e P6)
    private static void imprimirSequencia(String label, Iterable<Integer> order, String[] nomes) {
        StdOut.print(label + ": ");
        if (order == null) {
            StdOut.println("N/A");
        } else {
            for (int v : order) {
                StdOut.print(nomes[v] + " ");
            }
            StdOut.println();
        }
    }
}