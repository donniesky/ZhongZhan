package cn.studyjams.s1.sj35.zhongzhan.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.studyjams.s1.sj35.zhongzhan.R;

/**
 * Created by Mysim on 2016/4/26.
 */
public class DetailActivity extends AppCompatActivity{

    public static String CATALOG_THIS_IS_ME = "role";
    public static String CATALOG_CHANGE_MYSELF = "change";
    public static String CATALOG_FIGHT_MYSELF = "fight";
    public static String CATALOG_STOP_THINK = "think";
    public static String CATALOG_ONE_OF_ME = "one";

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.content)
    TextView content;

    @Bind(R.id.tag)
    TextView tag;

    @Bind(R.id.bg_img)
    ImageView bg_img;

    private String catalog;

    private String default_tip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        catalog = getIntent().getStringExtra("catalog");
        initView();
    }

    private void initView(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (catalog.equals(CATALOG_THIS_IS_ME)){
            showDetail(R.drawable.this_is_me,R.string.role,
                    R.string.this_is_me,R.string.tag_this);
            default_tip = getResources().getString(R.string.role_tip);
        }else if (catalog.equals(CATALOG_CHANGE_MYSELF)){
            showDetail(R.drawable.change_my_self,R.string.changes,
                    R.string.change_myself,R.string.change);
            default_tip = getResources().getString(R.string.change_tip);
        }else if (catalog.equals(CATALOG_FIGHT_MYSELF)){
            showDetail(R.drawable.fight_with_myself,R.string.fights,
                    R.string.fight_self,R.string.fight);
            default_tip = getResources().getString(R.string.fight_tip);
        }else if (catalog.equals(CATALOG_STOP_THINK)){
            showDetail(R.drawable.stop_thinking_anybody,R.string.think,
                    R.string.stop_think_anybody,R.string.stop);
            default_tip = getResources().getString(R.string.think_tip);
        }else if (catalog.equals(CATALOG_ONE_OF_ME)){
            showDetail(R.drawable.one_of_me,R.string.one,
                    R.string.one_of_yourself,R.string.oneself);
            default_tip = getResources().getString(R.string.one_tip);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, default_tip, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void showDetail(int imgid,int titleid,int contentid,int tagid){
        bg_img.setBackgroundResource(imgid);
        getSupportActionBar().setTitle(getResources().getString(titleid));
        content.setText(getResources().getString(contentid));
        tag.setText(getResources().getString(tagid));
    }
}
