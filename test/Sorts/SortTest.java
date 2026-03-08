package Sorts;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] arr);
    }

    static Stream<SortAlgorithm> algorithms() {
        return Stream.of(
                Sort::insertionSort,
                Sort::selectionSort,
                Sort::heapSort
        );
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldSortSimpleArray(SortAlgorithm algorithm) {
        int[] arr = {5, 2, 8, 1, 3};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{1,2,3,5,8}, arr);
    }

    // -----------------------------
    // Edge cases
    // -----------------------------

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldHandleEmptyArray(SortAlgorithm algorithm) {
        int[] arr = {};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{}, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldHandleSingleElement(SortAlgorithm algorithm) {
        int[] arr = {42};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{42}, arr);
    }

    // -----------------------------
    // Already sorted input
    // -----------------------------

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldHandleAlreadySortedArray(SortAlgorithm algorithm) {
        int[] arr = {1,2,3,4,5};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    // -----------------------------
    // Reverse order
    // -----------------------------

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldSortReverseArray(SortAlgorithm algorithm) {
        int[] arr = {5,4,3,2,1};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    // -----------------------------
    // Duplicates
    // -----------------------------

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldHandleDuplicates(SortAlgorithm algorithm) {
        int[] arr = {4,2,4,1,2,3,1};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{1,1,2,2,3,4,4}, arr);
    }

    // -----------------------------
    // Negative numbers
    // -----------------------------

    @ParameterizedTest
    @MethodSource("algorithms")
    void shouldHandleNegativeNumbers(SortAlgorithm algorithm) {
        int[] arr = {3,-1,7,-5,2};

        algorithm.sort(arr);

        assertArrayEquals(new int[]{-5,-1,2,3,7}, arr);
    }

    // -----------------------------
    // Randomized correctness test
    // -----------------------------

    @ParameterizedTest
    @MethodSource("algorithms")
    void randomizedSortingTest(SortAlgorithm algorithm) {

        Random random = new Random();

        int[] arr = random.ints(100, -1000, 1000).toArray();
        int[] expected = arr.clone();

        Arrays.sort(expected);

        algorithm.sort(arr);

        assertArrayEquals(expected, arr);
    }


}