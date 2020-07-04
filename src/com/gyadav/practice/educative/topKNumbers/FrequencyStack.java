package com.gyadav.practice.educative.topKNumbers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Element {
    int number;
    int frequency;
    int sequence;

    public Element(int number, int frequency, int sequence) {
        this.number = number;
        this.frequency = frequency;
        this.sequence = sequence;
    }
}
class ElementComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        if (o1.frequency != o2.frequency)
            return o2.frequency - o1.frequency;
        return o2.sequence - o1.sequence;
    }
}
public class FrequencyStack {
    PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
    Map<Integer, Integer> freqMap = new HashMap<>();
    int sequenceNumber = 0;

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }

    public void push(int num) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        maxHeap.add(new Element(num, freqMap.get(num), sequenceNumber++));
    }

    public int pop() {
        int num = maxHeap.poll().number;
        if (freqMap.get(num) > 1)
            freqMap.put(num, freqMap.get(num) - 1);
        else
            freqMap.remove(num);
        return num;
    }
}
