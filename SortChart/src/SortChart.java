import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortChart {

    public static int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arraySizes = {5000, 10000, 20000, 30000};

        List<Double> xData = new ArrayList<>();
        List<Double> insertionSortTimes = new ArrayList<>();
        List<Double> selectionSortTimes = new ArrayList<>();

        for (int size : arraySizes) {
            xData.add((double) size);

            long insertionSortTotalTime = 0;
            long selectionSortTotalTime = 0;

            for (int i = 0; i< 10; i++) {
                int[] arr = randomArray(size);

                long startTime = System.nanoTime();
                insertionSort(arr);
                long endTime = System.nanoTime();
                insertionSortTotalTime += (endTime - startTime);

                startTime = System.nanoTime();
                selectionSort(arr);
                endTime = System.nanoTime();
                selectionSortTotalTime += (endTime - startTime);
            }

            insertionSortTimes.add((double) insertionSortTotalTime / 10 / 1000000);
            selectionSortTimes.add((double) selectionSortTotalTime / 10 / 1000000);
        }

        XYChart chart = new XYChartBuilder()
                .width(600)
                .height(400)
                .title("Algo Race")
                .xAxisTitle("Array Size")
                .yAxisTitle("Time")
                .build();

        XYSeries insertionSeries = chart.addSeries("Insertion Sort", xData, insertionSortTimes);
        insertionSeries.setMarker(SeriesMarkers.CIRCLE);

        XYSeries selectionSeries = chart.addSeries("Selection Sort", xData, selectionSortTimes);
        selectionSeries.setMarker(SeriesMarkers.SQUARE);

        new SwingWrapper<>(chart).displayChart();
    }
}