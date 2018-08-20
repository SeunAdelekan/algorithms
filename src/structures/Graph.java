package structures;

import java.util.ArrayList;
import java.util.List;

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
     * Class modelling graph nodes.
     *
     * @param <U> - the type of value held within the node.
     */
    private class Node<U> {

        private U value;
        private List<Node<U>> children;

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
