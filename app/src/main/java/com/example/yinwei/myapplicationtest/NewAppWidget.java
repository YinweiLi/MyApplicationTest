package com.example.yinwei.myapplicationtest;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {


    private Timer timer = new Timer();
    private  int[] appWidgetIds;
    private AppWidgetManager appWidgetManager;
    private Context context;
    private final static int UPDATE = 1;
    private int time = 0;


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
             // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            this.appWidgetManager = appWidgetManager;
            this.appWidgetIds = appWidgetIds;
            this.context = context;
            timer = new Timer();
            timer.schedule(timerTask,0,2000);

            //updateAppWidget(context, appWidgetManager, appWidgetId);
            //去掉这个函数是好使得
        }


    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created


    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled



    }

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE:
                    int n = appWidgetIds.length;
                    for(int j=0;j<n;j++){
                        int appWidgetId = appWidgetIds[j];
                        RemoteViews views = new RemoteViews(context.getPackageName(),
                                R.layout.new_app_widget);
                        //！！！！！！之前没有变是因为RemoteView这句话绑定错对象了
                        //！！！！！！应该绑定和本widget对应的那个xml文件

                        //使用setViewText方法更新TextView

                        views.setTextViewText(R.id.appwidget_text,String.valueOf(time));
                        appWidgetManager.updateAppWidget(appWidgetId,views);

                    }
                    break;
            }
            super.handleMessage(msg);
        }

    };

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            time++;
            Message message = new Message();
            message.what = UPDATE;
            handler.sendMessage(message);
        }
    };
}
//在写widget的时候遇到了一些问题
/*
*    First：按照书上的例子写出来之后，程序是可以在桌面添加一个widget组件了，但是里面的内容一直不变
*，很是费解
*    最致命的原因是RemoteView的问题，本例子的思想是，在update()里设置一个定时器，在定时器里定时的
*    用handler来执行任务[handler：处理者管理者]，在handler中循环到所有的已经添加了的widget，每个
*    widget用RemoteView来设置内容，此处需要注意的是，构造RemoteView对象的时候，第二个参数是与当
*    前widget对应的那个layout中的xml文件ID，书上的对应的就是main，容易误导，而本实例中的是
*    R.layout.new_app_widget，下面设置setTextViewText()也是那个xml里面的控件id
*    Second：在修改调试的过程中，修改了好多地方，曾以为有一些自建的重写的函数可以不用写，但是不写的
*后果是更新的时候会出现桌面组件异常
*   AndroidStudio右击自建的widget里面包含三个文件，分别是.java\.xml\info.xml，例子中的是NewAppWidget.java
*   new_app_widget.xml\new_app_widget_info.xml[info=information：信息]，并且会自动的在manifest里面注册
*   receiver，窗口小工具的控件内容格式布局都是在.xml里面的和一个activity的xml一样，info.xml里面是一些设置信息
*   大小，拉伸属性，更新时间等，而且在.java中会自动生成需要重写的函数，[里面重写的updateAppWidget()函数是
*   怎么用]例子里用的是appWidgetManager来管理widget的内容的
*
*
*
*/