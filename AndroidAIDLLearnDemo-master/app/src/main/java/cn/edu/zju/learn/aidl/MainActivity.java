package cn.edu.zju.learn.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyService myService;
    private IMyAidlInterface myAidlInterface;
    private ServiceConnection mConnection;
    private EditText edit_text;
    private EditText edit_text1;
    private int a;
    private int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text=(EditText)findViewById(R.id.editText2);
        edit_text1=(EditText)findViewById(R.id.editText3);
        mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                String key =  edit_text.getText().toString();
                int a = Integer.parseInt(key);
                String keys =  edit_text1.getText().toString();
                int b = Integer.parseInt(keys);
                myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
                try {
                    int result = myAidlInterface.add(a,b);
                    Toast.makeText(getApplicationContext(), result + "円"+ "", Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                Intent intent = new Intent(MainActivity.this,MyService.class);
                bindService(intent, mConnection, BIND_AUTO_CREATE);

            }
        });
    }


}
