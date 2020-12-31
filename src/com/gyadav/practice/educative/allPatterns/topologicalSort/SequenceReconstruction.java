package com.gyadav.practice.educative.allPatterns.topologicalSort;

import java.util.*;

public class SequenceReconstruction {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0)
            return false;
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] seq : sequences) {
            for (int i = 0; i < seq.length; i++) {
                inDegree.putIfAbsent(seq[i], 0);
                graph.putIfAbsent(seq[i], new ArrayList<>());
            }
        }
        for (int[] seq : sequences) {
            for (int i = 1; i < seq.length; i++) {
                int parent = seq[i-1], child = seq[i];
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child) + 1);
            }
        }
        if (inDegree.size() != originalSeq.length)
            return false;
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }
        while (!sources.isEmpty()) {
            if (sources.size() > 1)
                return false;
            if (originalSeq[sortedOrder.size()] != sources.peek())
                return false;
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0)
                    sources.add(child);
            }
        }
        return sortedOrder.size() == originalSeq.length;
    }
}
