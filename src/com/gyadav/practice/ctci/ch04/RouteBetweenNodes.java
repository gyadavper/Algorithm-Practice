package com.gyadav.practice.ctci.ch04;

import com.gyadav.practice.helper.Graph;
import com.gyadav.practice.helper.Node;

import java.util.LinkedList;

public class RouteBetweenNodes {

    public boolean routeExists(Graph g, Node a, Node b) {
        LinkedList<Node> nodeQueue = new LinkedList<>();
        boolean routeExists = false;
        nodeQueue.add(a);
        while (!nodeQueue.isEmpty()) {
            Node checkNode = nodeQueue.getLast();
            for (Node n : checkNode.children) {
                if (n.visited == false) {
                    n.visited = true;
                    if (n == b) {
                        routeExists = true;
                        break;
                    }
                    nodeQueue.add(n);
                }
            }
        }
        return routeExists;
    }
}
