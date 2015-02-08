package galaxys5.bsru.bankreaper.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by CS on 8/2/2558.
 */
public class MyAlertDialog {

    private AlertDialog.Builder objAlert;


    public void answer(Context context) {
        objAlert = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.danger);
        objAlert.setTitle("กดคำตอบดิเฮ้ย");
        objAlert.setMessage("แน่ะยังไม่กด");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        objAlert.show();

    }

}//main
