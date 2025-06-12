package chaerul.biz.id.smartlamp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import chaerul.biz.id.smartlamp.R;

public class MonitorFragment extends Fragment {
    private View view;
    private List<DataEntry> seriesData = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable updateRunnable;
    private int currentYear = 2025; // Tahun awal update
    private final int MAX_DATA = 20;

    private Set set;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_monitor, container, false);

        // ✅ Tambahkan dummy data awal biar grafik langsung muncul
        seriesData.add(new CustomDataEntry(String.valueOf(currentYear++), 10, 15, 20));

        set = Set.instantiate();
        set.data(seriesData);

        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(view.findViewById(R.id.progress_bar));

        Cartesian cartesian = AnyChart.line();
        cartesian.animation(true);
        cartesian.padding(10d, 20d, 5d, 20d);
        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                .yStroke((Stroke) null, null, null, (String) null, (String) null);
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.title("Monitoring Realtime Perangkat");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);

        // ✅ Mapping untuk 3 data
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

        // ✅ Series 1
        Line series1 = cartesian.line(series1Mapping);
        series1.name("Sensor 1");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers().type(MarkerType.CIRCLE).size(4d);
        series1.tooltip().position("right").anchor(Anchor.LEFT_CENTER).offsetX(5d).offsetY(5d);

        // ✅ Series 2
        Line series2 = cartesian.line(series2Mapping);
        series2.name("Sensor 2");

        // ✅ Series 3
        Line series3 = cartesian.line(series3Mapping);
        series3.name("Sensor 3");

        cartesian.legend().enabled(true);
        cartesian.legend().fontSize(13d);
        cartesian.legend().padding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);

        // ✅ Mulai update realtime
        startRealtimeDataUpdate();

        return view;
    }

    private void startRealtimeDataUpdate() {
        updateRunnable = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                double value = 5 + random.nextDouble() * 20;
                double value2 = 5 + random.nextDouble() * 20;
                double value3 = 5 + random.nextDouble() * 20;

                seriesData.add(new CustomDataEntry(String.valueOf(currentYear++), value, value2, value3));

                if (seriesData.size() > MAX_DATA) {
                    seriesData.remove(0);
                }

                set.data(seriesData);
                handler.postDelayed(this, 1000); // tiap 3 detik
            }
        };
        handler.postDelayed(updateRunnable, 1000); // delay pertama
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateRunnable); // stop pas fragment ditutup
    }

    private static class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }
    }
}
