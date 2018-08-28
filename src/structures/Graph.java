package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Graph data structure implementation utilizing adjacency
 * lists.
 *
 * @param <T> - the type of value held by each node within the graph.
 */
public class Graph<T> {

    Graph() {
        this.nodes = new ArrayList<>();
    }

    private List<Node<T>> nodes;

    public List<Node<T>> getNodes() {
        return nodes;
    }

    /**
     * Depth first search algorithm implementation.
     *
     * @param node - current node being searched.
     * @param value - value being searched for.
     * @return Node - result node if one exists and null otherwise.
     */
    public Node<T> DFS(final Node<T> node, final T value) {
        if (node != null) {
            node.visited = true;

            if (node.getValue() == value) {
                return node;
            }

            for (Node<T> branchNode : node.getChildren()) {
                Node<T> res = DFS(branchNode, value);

                if (res != null) {
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * Searches the current graph using breadth first search.
     *
     * @param node - current node being searched.
     * @param value - value being searched for.
     * @return
     */
    public Node<T> BFS(final Node<T> node, final T value) {
        final List<Node<T>> queue = new LinkedList<>();

        if (node != null) {
            node.visited = true;
        }
        queue.add(node);

        while (!queue.isEmpty()) {
            Node<T> neighbour = queue.remove(0);

            if (neighbour.getValue() == value) {
                return neighbour;
            }

            for (Node<T> n : neighbour.getChildren()) {
                if (!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
        return null;
    }

    /**
     * Class modelling graph nodes.
     *
     * @param <U> - the type of value held within the node.
     */
    private class Node<U> {

        private U value;
        private List<Node<U>> children;
        private boolean visited = false;

        void addChild(final Node<U> node) {
            children.add(node);
        }

        List<Node<U>> getChildren() {
            return children;
        }

        U getValue() {
            return value;
        }
    }
}
