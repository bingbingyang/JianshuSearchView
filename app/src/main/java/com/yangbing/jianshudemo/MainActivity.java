package com.yangbing.jianshudemo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Window;
import android.widget.RelativeLayout;
public class MainActivity extends AppCompatActivity {
    private SearchView mSearchView;
    private Drawable headBg ;
    private RecyclerView rv;
    private RelativeLayout  rlHead;
    private int scrollY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        mSearchView= (SearchView) findViewById(R.id.activity_main_searchview);
        rlHead = (RelativeLayout) findViewById(R.id.activity_main_rlhead);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new SimpleAdapter());
        headBg = rlHead.getBackground().mutate();//获取head的背景drawable
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                float fraction = calcFraction(dy);
                setBackgoundAlpha(fraction);
            }
        });

    }



    private float calcFraction(int dy){
        float imgHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
        float toolbarHeight = rlHead.getHeight();
        float maxHeight = imgHeight - toolbarHeight;
        scrollY += dy;
        if(scrollY>maxHeight){
            mSearchView.startAnimation(SearchView.SCROLL_HEAD_BOTTOM);
        }
        if(scrollY==0){
            mSearchView.startAnimation(SearchView.SCROLL_HEAD_TOP);
        }
        if (scrollY >= maxHeight) {
            return 1.0f;

        } else if (scrollY <= 0) {
            return 0f;
        } else {
            return scrollY/maxHeight;
        }
    }


    private void  setBackgoundAlpha(float fraction){
        //背景只需要设置透明度，255是全不透明
        headBg.setAlpha((int) (fraction*255));
    }



}
