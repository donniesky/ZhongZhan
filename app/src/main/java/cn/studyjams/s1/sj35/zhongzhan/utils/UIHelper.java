package cn.studyjams.s1.sj35.zhongzhan.utils;

import android.content.Context;
import android.content.Intent;

import cn.studyjams.s1.sj35.zhongzhan.ui.activity.DetailActivity;

/**
 * Created by Mysim on 2016/4/26.
 */
public class UIHelper {

    public static void startDetailActivity(Context context,String catalog){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("catalog",catalog);
        context.startActivity(intent);
    }

}
