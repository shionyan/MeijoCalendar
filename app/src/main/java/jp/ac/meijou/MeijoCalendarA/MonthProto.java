package jp.ac.meijou.MeijoCalendarA;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalDate;

import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

import jp.ac.meijou.MeijoCalendarA.databinding.ActivityMonthProtoBinding;

public class MonthProto extends AppCompatActivity {

    private ActivityMonthProtoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        AndroidThreeTen.init(this);

        binding = ActivityMonthProtoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.monthProtoCalenderView.setDate(new Date().getTime());

        binding.monthProtoCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                LocalDate ld = org.threeten.bp.LocalDate.of(year, month, dayOfMonth);
                org.threeten.bp.temporal.WeekFields wf = org.threeten.bp.temporal.WeekFields.of(Locale.getDefault());
                int weekOfYear = ld.get(wf.weekOfYear());


            }
        });
    }
}