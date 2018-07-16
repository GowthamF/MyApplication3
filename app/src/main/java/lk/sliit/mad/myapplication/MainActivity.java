package lk.sliit.mad.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2,drawingImageView;
    TextView textView1,textView2;
    LinearLayout l1,l2,l3,l4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void path(View view) {
        imageView1=findViewById(R.id.audit);
        imageView2=findViewById(R.id.posit);
        textView1=findViewById(R.id.textView3);
        textView2=findViewById(R.id.textView4);
        l1=findViewById(R.id.auditl1);
        l2=findViewById(R.id.post1);
        l3=findViewById(R.id.post2);
        l4=findViewById(R.id.post3);
        int array1[]=new int[2];
        int array[]=new int[2];
        int array2[]=new int[2];
        int array3[]=new int[2];
        l1.getLocationOnScreen(array);
        l2.getLocationOnScreen(array1);
        l3.getLocationOnScreen(array2);
        l4.getLocationOnScreen(array3);

        float x=array[0];
        float y=array[1];
        float x1=array1[0];
        float y1=array1[1];
        float x2=array2[0];
        float y2=array2[1];
        float x3=array3[0];
        float y3=array3[1];



        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float dpi=displayMetrics.densityDpi;
        float dp=displayMetrics.density;
        float xdpi=displayMetrics.xdpi;
        float ydpi=displayMetrics.ydpi;
        int screenwidth=displayMetrics.widthPixels;
        int screenheight=displayMetrics.heightPixels;
        drawingImageView = (ImageView) this.findViewById(R.id.drawing);
        Bitmap bitmap;
        bitmap = Bitmap.createBitmap(screenwidth,screenheight,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        drawingImageView.setImageBitmap(bitmap);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // paint.setColor(Color.BLACK);
        paint.setShader(new LinearGradient(0, 0, 5,5, Color.BLUE, Color.WHITE, Shader.TileMode.REPEAT));
        paint.setStrokeWidth(5);
      // Path p=new Path();

       //p.moveTo(x,y);
      // p.lineTo(x1,y1);
        //320dpi
        canvas.drawLine(x+25,y+35,x1+25,y1+35,paint);
        canvas.drawLine(x1+25,y1+35,x2+25,y2+35,paint);
        canvas.drawLine(x2+25,y2+35,x3+25,y3+35,paint);
        //420dpi
      //  canvas.drawLine(x+10,y-70,x1+10,y1-70,paint);
       // canvas.drawLine(x1+10,y1-70,x2+10,y2-70,paint);
       // canvas.drawLine(x2+10,y2-70,x3+10,y3-70,paint);

      // canvas.drawPath(p,paint);

        textView1.setText("Start X "+x+"Start Y "+y+" "+dp);
        textView2.setText("Stop X "+x1+"Stop Y "+y1);
    }
}
