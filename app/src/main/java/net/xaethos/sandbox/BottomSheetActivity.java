package net.xaethos.sandbox;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.OnSheetDismissedListener;

public class BottomSheetActivity extends FragmentActivity implements View.OnClickListener {

    private static final int[] COUNTS = {1, 2, 6};
    private int countIndex = 0;

    private ViewGroup mLipsumContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_sheet_2);

        final BottomSheetLayout bottomSheetLayout =
                (BottomSheetLayout) findViewById(R.id.bottomsheet);

        bottomSheetLayout.showWithSheetView(LayoutInflater.from(this)
                        .inflate(R.layout.bottom_sheet, bottomSheetLayout, false),
                null,
                new OnSheetDismissedListener() {

                    @Override
                    public void onDismissed(BottomSheetLayout bottomSheetLayout) {
                        finish();
                    }
                });

        mLipsumContainer = (ViewGroup) findViewById(R.id.container_lipsum);

        findViewById(android.R.id.button1).setOnClickListener(this);
        findViewById(android.R.id.button2).setOnClickListener(this);

        changeCount();
    }

    @Override
    public void onClick(View v) {
        changeCount();
    }

    private void changeCount() {
        final int count = COUNTS[countIndex++ % COUNTS.length];

        mLipsumContainer.removeAllViews();
        for (int i = 0; i < count; ++i) {
            TextView lipsum = new TextView(this);
            lipsum.setText(R.string.lipsum);
            mLipsumContainer.addView(lipsum);
        }
    }
}
