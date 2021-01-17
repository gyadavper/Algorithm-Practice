package com.gyadav.practice.ctci.ch10;

public class SearchSortedArrayUnknownSize702 {
    public static int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while (reader.get(end) != Integer.MAX_VALUE) {
            if (target > reader.get(end)) {
                start = end;
                end = end * 2;
            } else {
                break;
            }
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target)
                return mid;
            if (reader.get(mid) > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[]{1,0,3,5,9,12});
        System.out.println(SearchSortedArrayUnknownSize702.search(reader, 9));
        //System.out.println(SearchSortedArrayUnknownSize702.search(reader, 11));
        //reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
        //System.out.println(SearchSortedArrayUnknownSize702.search(reader, 15));
        //System.out.println(SearchSortedArrayUnknownSize702.search(reader, 200));
    }
}
class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}