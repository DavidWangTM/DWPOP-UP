package tm.davidwang.dwpop_up;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

/**
 * Created by DavidWang on 15/10/30.
 */
public class DWPOPView extends LinearLayout {

    private final Spring mSpring = SpringSystem
            .create()
            .createSpring()
            .addListener(new ExampleSpringListener());
    private View addview;
    private double qcTension = 20;
    private double qcFriction = 4;
    private int move_y = 0;

    public DWPOPView(Context context) {
        super(context);

    }

    public DWPOPView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(){
        setVisibility(View.GONE);
        mSpring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(1, 5));
        mSpring.setEndValue(1);
    }

    public void setAdapterView(View view){
        this.addView(view);
        this.addview = view;
        init();
        mSpring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(qcTension, qcFriction));
    }

    public void setAdapterView(View view,double qcTension,double qcFriction){
        this.addView(view);
        this.addview = view;
        init();
        mSpring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(qcTension,qcFriction));
    }

    public void showanimation(){
        if (mSpring.getEndValue() == 0){
            mSpring.setEndValue(1);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    setVisibility(View.GONE);
                }
            }, 200);
        }else {
            setVisibility(View.VISIBLE);
            mSpring.setEndValue(0);
        }

    }

    private class ExampleSpringListener implements SpringListener {

        @Override
        public void onSpringUpdate(Spring spring) {
            double CurrentValue = spring.getCurrentValue();
            float mappedValue = (float) SpringUtil.mapValueFromRangeToRange(CurrentValue, 0, 1, 1, -move_y);
            addview.setTranslationY(mappedValue);
        }

        @Override
        public void onSpringAtRest(Spring spring) {

        }

        @Override
        public void onSpringActivate(Spring spring) {

        }

        @Override
        public void onSpringEndStateChange(Spring spring) {

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        move_y  = getHeight();
    }
}
