package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> data;

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .withData(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        var tmp = new ArrayList<Integer>();
        for (var n : data) {
            tmp.add(fun.apply(n));
        }
        return EasyStream.of(tmp);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        var tmp = new ArrayList<Integer>();
        for (var n : data) {
            if (fun.test(n)) {
                tmp.add(n);
            }
        }
        return EasyStream.of(tmp);
    }

    public List<Integer> collect() {
        return data;
    }

    public static class Builder {
        private EasyStream newEasyStream;

        public Builder() {
            newEasyStream = new EasyStream();
        }

        public Builder withData(List<Integer> list) {
            newEasyStream.data = list;
            return this;
        }

        public EasyStream build() {
            return newEasyStream;
        }
    }
}
