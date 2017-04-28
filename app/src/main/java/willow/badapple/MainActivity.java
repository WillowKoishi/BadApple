package willow.badapple;

import android.app.*;
import android.content.*;
import android.os.*;
import java.io.*;
import android.widget.*;
import android.media.*;
import android.view.*;

public class MainActivity extends Activity 
{String a,b;
int c=0;
EditText et;
MediaPlayer mp;
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	b=readAssetsTxt(this,"");
	mp=new MediaPlayer().create(this,R.raw.ba);
		try
		{mp.prepare();
		}
		catch (IOException e)
		{}
		catch (IllegalStateException e)
		{}
		
		t = (TextView)this.findViewById(R.id.mainTextView1);
	et=(EditText)this.findViewById(R.id.mainEditText1);
		
    }
	public static String readAssetsTxt(Context context,String fileName){
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open("badapple6.txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
			return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "读取错误，请检查文件名";
    }
	Handler h=new Handler(){

		@Override
		public void handleMessage(Message msg)
		{
			// TODO: Implement this method
			super.handleMessage(msg);
		}
		
	};
	Runnable r=new Runnable(){

		@Override
		public void run()
		{//h.postDelayed(r,200);
		
		//a="";
		//for(int i=0;i<=29;i++)
		//{a=a+b.substring(i*80+c*2400,i*80+c*2400+81);}
		
		//t.setText(a);
		int hh=Integer.valueOf(et.getText().toString(),10);
		if(c<=6560){
		t.setText(b.substring(c*hh,(c+1)*hh)+"\n"+c+"/"+"6560");
		}
		c=c+1;
			h.postDelayed(r,16);
			// TODO: Implement this method
			h.sendEmptyMessage(0);
		}

		
	};

	@Override
	protected void onPause()
	{
		// TODO: Implement this method
		super.onPause();
		//mp.pause();
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		mp.stop();
		mp.reset();
	}
	public void iii(View v){
		mp.start();
		h.postDelayed(r,1);
	}
}
