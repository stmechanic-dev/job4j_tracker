package ru.job4j.tracker.collection.sort;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] sLeft = left.split("\\.", 2);
        String[] sRight = right.split("\\.", 2);
        int iLeft = Integer.parseInt(sLeft[0]);
        int iRight = Integer.parseInt(sRight[0]);
        return Integer.compare(iLeft, iRight);

    }
}
