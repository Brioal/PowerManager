package com.brioal.poswermanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(true);
        setContentView(R.layout.activity_main);
        if (!ShellUtils.checkRootPermission()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("本软件只能在获取Root权限之后使用,确认退出吗?");
            builder.setTitle("未获取Root权限");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    MainActivity.this.finish();
                }


            });
            builder.create().show();
        }
    }

    //关机
    public void ShutDown(View view) {
        ShellUtils.execCommand("reboot -p", true);
    }

    //重启
    public void Reboot(View view) {
        ShellUtils.execCommand("reboot", true);
    }

    //快速重启
    public void FastReboot(View view) {
        ShellUtils.execCommand("busybox killall system_server", true);
    }

    //Rec
    public void Recovery(View view) {
        ShellUtils.execCommand("reboot recovery", true);

    }

    //fastboot
    public void FastBoot(View view) {
        ShellUtils.execCommand("reboot bootloader", true);

    }

}
