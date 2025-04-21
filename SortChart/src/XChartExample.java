import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;
import java.util.Arrays;
import java.util.List;

public class XChartExample {
    public static void main(String[] args) {
        // Sample Data
        List<Double> xData = Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> yData = Arrays.asList(0.0, 1.0, 4.0, 9.0, 6.0, 20.0);

        // Create Chart
        XYChart chart = new XYChartBuilder()
                .width(600)
                .height(400)
                .title("Simple XChart Example")
                .xAxisTitle("X Axis")
                .yAxisTitle("Y Axis")
                .build();

        // Add series
        XYSeries series = chart.addSeries("y = x^2", xData, yData);
        series.setMarker(SeriesMarkers.CIRCLE);

        // Show the chart
        new SwingWrapper<>(chart).displayChart();
    }
}
