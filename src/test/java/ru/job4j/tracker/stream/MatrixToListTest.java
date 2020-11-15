package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void whenMatrixToList() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> result = MatrixToList.coverterMatrToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}