package structures;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    Graph() {
        this.nodes = new ArrayList<>();
    }

    private List<Node<T>> nodes;

    public List<Node<T>> getNodes() {
        return nodes;
    }

    private class Node<U> {

        private U value;
        private List<Node<U>> children;
    }
}
