package io.github.raamish.helio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity  {

    String phno=null;
    Context cont;


    public CallActivity(Context con, String text)
    {
        this.cont=con;
        this.phno=ContactFinder.getAllContacts(con,text);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("checkkk", "onCreate: ");
        makeCall();

    }

    @SuppressWarnings({"MissingPermission"})
    public boolean makeCall()
    {
        try
        {
            if(phno==null)
                return false;
            else {
                Toast.makeText(cont, phno, Toast.LENGTH_SHORT).show();

                Intent in = new Intent(Intent.ACTION_CALL);
                in.setData(Uri.parse("tel:"+phno));
                cont.startActivity(in);
                return true;
            }

        }
        catch (Exception e)
        {
            Toast.makeText(cont, "Call ActEcxp", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
