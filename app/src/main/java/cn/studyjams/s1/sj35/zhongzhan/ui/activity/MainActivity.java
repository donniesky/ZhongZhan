package cn.studyjams.s1.sj35.zhongzhan.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.studyjams.s1.sj35.zhongzhan.R;
import cn.studyjams.s1.sj35.zhongzhan.utils.UIHelper;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    @OnClick({R.id.this_is_me,R.id.change_self,R.id.fight_self,
            R.id.stop_thinking,R.id.one_of_self})
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.this_is_me:
                UIHelper.startDetailActivity(MainActivity.this,DetailActivity.CATALOG_THIS_IS_ME);
                break;
            case R.id.change_self:
                UIHelper.startDetailActivity(MainActivity.this,DetailActivity.CATALOG_CHANGE_MYSELF);
                break;
            case R.id.fight_self:
                UIHelper.startDetailActivity(MainActivity.this,DetailActivity.CATALOG_FIGHT_MYSELF);
                break;
            case R.id.stop_thinking:
                UIHelper.startDetailActivity(MainActivity.this,DetailActivity.CATALOG_STOP_THINK);
                break;
            case R.id.one_of_self:
                UIHelper.startDetailActivity(MainActivity.this,DetailActivity.CATALOG_ONE_OF_ME);
                break;
        }
    }
}
