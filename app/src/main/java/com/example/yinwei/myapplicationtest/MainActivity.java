package com.example.yinwei.myapplicationtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity {
    TextView myTextView;
    TextView textView4TestContextMenu;
    int i = 0;
    //i用来计数，点击函数会用他来改变textview的值
    Bitmap bitmap;
    ImageView imageView;
    float bigger_X = (float) 1.5;
    float bigger_Y = (float) 1.5;
    float smaller_X =(float) 0.9;
    float smaller_Y = (float) 0.9;
    float rotate_R = 10;
    float rotate_L = -10;
    //ContextMenu contextMenu;

    //public void rigester(){
      //  this.registerForContextMenu(myTextView);
    //}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件的获取，方式：findViewById
        final EditText phoneNumber = (EditText) findViewById(R.id.ET_PhoneNumber);
        final EditText passWord = (EditText) findViewById(R.id.ET_PassWord);
        myTextView = (TextView) findViewById(R.id.textView1);
        Button b = (Button) findViewById(R.id.button);

        textView4TestContextMenu = (TextView)findViewById(R.id.textView2);
        registerForContextMenu(textView4TestContextMenu);
        //rigester();
//        this.registerForContextMenu(myTextView);
        //为什么长按textview我的菜单不出现???????????????
        //Button按钮的点击事件监听器，功能：改变textview里的内容
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "welcome to android world!";
                if (i % 2 == 1) {
                    str = "myandroid";
                    i++;
                } else {
                    str = "what the fuck!";
                    i++;
                }
//                Toast.makeText(MainActivity.this, "someQuestion", Toast.LENGTH_LONG).show();
                myTextView.setText(str);


            }
        });
        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,WindowsOSActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        //EditText的状态改变监听事件，功能：改变textview里的内容
        //***遇到函数实现出错问题，函数名字错了
        phoneNumber.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event) {
                myTextView.setText(phoneNumber.getText());
                return false;
            }
        });
        passWord.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event) {
                myTextView.setText(passWord.getText());
                return false;
            }
        });
        //获取xml元素
        //创建bitmap对象，并指定资源
        //用bitmap来设置imageView
        imageView = (ImageView) findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.image_1);
        imageView.setImageBitmap(bitmap);
        //指定四个功能button与四个功能相连
        Button setBigger = (Button)findViewById(R.id.button2);
        Button setSmaller = (Button)findViewById(R.id.button3);
        Button turnRight = (Button)findViewById(R.id.button4);
        Button turnLeft = (Button)findViewById(R.id.button5);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigger_X = bigger_Y = smaller_Y = smaller_X = 1;
                rotate_R = rotate_L = 0;
                zoomoutImageView(1,1);
            }
        });
        //给button添加点击事件
        setBigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"图片正在放大",Toast.LENGTH_SHORT).show();
                if(bigger_X != 1.5 || bigger_Y != 1.5){
                    bigger_X = smaller_X;
                    bigger_Y = smaller_Y;
                }
                bigger_X += 0.1;
                bigger_Y += 0.1;
                smaller_X = bigger_X;
                smaller_Y = bigger_Y;
                if(bigger_X >= 2 || bigger_Y >= 2){
                    bigger_X = bigger_Y = smaller_Y = smaller_X = 1;
                }
                zoomoutImageView(bigger_X,bigger_Y);
            }
        });
        setSmaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"图片正在缩小",Toast.LENGTH_SHORT).show();
                if(smaller_X != 0.9 || smaller_Y != 0.9){
                    smaller_X = bigger_X;
                    smaller_Y = bigger_Y;

                }
                smaller_X -= 0.1;
                smaller_Y -= 0.1;
                bigger_X = smaller_X;
                bigger_Y = smaller_Y;
                if(smaller_X <= 0.2 || smaller_Y <= 0.2){
                    bigger_X = bigger_Y = smaller_Y = smaller_X = 1;
                }
                zoominImageView(smaller_X,smaller_Y);
            }
        });
        turnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"图片正在右转",Toast.LENGTH_SHORT).show();
                if(rotate_R != 10) {
                    rotate_R = rotate_L;
                }
                rotate_R += 10;
                rotate_L = rotate_R;
                rotateRightImageView(rotate_R);
            }
        });
        turnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"图片正在左转",Toast.LENGTH_SHORT).show();
                if(rotate_L != -10) {
                    rotate_L = rotate_R;
                }
                rotate_L -= 10;
                rotate_R = rotate_L;
                rotateLeftImageView(rotate_L);
            }
        });
    }

    private int zoomoutImageView(float width,float height){
        //把传的参数拿进来放入新的变量
        float scaleWidth = width;
        float scaleHeight = height;
        //得到位图的宽高
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        try {
            //使用Matrix来记录图片信息-图片缩放的比例
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth,scaleHeight);

//        int bmp_X;
//        int bmp_Y;
//        bitmap.getPixel(bmp_X,bmp_Y);
//            int[] location = new int[2];
//            imageView.getLocationInWindow(location);
            Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,
                    matrix,true);
            imageView.setImageBitmap(resizeBmp);
        }
        catch (Exception e){
            Toast.makeText(this,"放大异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {
            //
        }
        return 0;
    }
    private int zoominImageView(float width,float height){
        //把传的参数拿进来放入新的变量
        float scaleWidth = width;
        float scaleHeight = height;
        //得到位图的宽高
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        try {
            //使用Matrix来记录图片信息-图片缩放的比例
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth,scaleHeight);

//        int bmp_X;
//        int bmp_Y;
//        bitmap.getPixel(bmp_X,bmp_Y);
//            int[] location = new int[2];
//            imageView.getLocationInWindow(location);
            Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,
                    matrix,true);
            imageView.setImageBitmap(resizeBmp);
        }
        catch (Exception e){
            Toast.makeText(this,"缩小异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {
            //
        }
        return 0;
    }
    private int rotateLeftImageView(float degree){
        //得到位图的宽高
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        try {
            //使用Matrix来记录图片信息-图片缩放的比例
            Matrix matrix = new Matrix();
            matrix.postScale(1,1);
            matrix.setRotate(degree);
//        int bmp_X;
//        int bmp_Y;
//        bitmap.getPixel(bmp_X,bmp_Y);
//            int[] location = new int[2];
//            imageView.getLocationInWindow(location);
            Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,
                    matrix,true);
            imageView.setImageBitmap(resizeBmp);
        }
        catch (Exception e){
            Toast.makeText(this,"左转异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {
            //
        }
        return 0;
    }
    private int rotateRightImageView(float degree){
        //得到位图的宽高
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        try {
            //使用Matrix来记录图片信息-图片缩放的比例
            Matrix matrix = new Matrix();
            matrix.postScale(1,1);
            matrix.setRotate(degree);
//        int bmp_X;
//        int bmp_Y;
//        bitmap.getPixel(bmp_X,bmp_Y);
//            int[] location = new int[2];
//            imageView.getLocationInWindow(location);
            Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,
                    matrix,true);
            imageView.setImageBitmap(resizeBmp);
        }
        catch (Exception e){
            Toast.makeText(this,"右转异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {
            //
        }
        return 0;
    }

    public void OnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo){
        super.onCreateContextMenu(contextMenu,view,contextMenuInfo);
        if(view == textView4TestContextMenu){
            contextMenu.setHeaderIcon(R.drawable.image_1);
            contextMenu.setHeaderTitle("FirstMenu");
            contextMenu.add(1,0,0,"M1");
            contextMenu.add(1,1,1,"M2");
            contextMenu.add(1,2,2,"M3");

//            SubMenu subMenu2 = contextMenu.addSubMenu("Menu2");
//            subMenu2.setHeaderIcon(R.drawable.image_1);
//            subMenu2.setHeaderTitle("SecondMenu");
//            subMenu2.add(1,0,0,"M2_1");
//            subMenu2.add(1,1,1,"M2_2");
//            subMenu2.add(1,2,2,"M2_3");
//            subMenu2.setGroupCheckable(1,true,true);
//
//            SubMenu subMenu3 = subMenu2.addSubMenu("Menu3");
//            subMenu3.setHeaderIcon(R.drawable.image_1);
//            subMenu3.setHeaderTitle("SecondMenu");
//            subMenu3.add(1,0,0,"M3_1");
//            subMenu3.add(1,1,1,"M3_2");
//            subMenu3.add(1,2,2,"M3_3");
//            subMenu3.setGroupCheckable(1,true,true);


        }


    }

}


