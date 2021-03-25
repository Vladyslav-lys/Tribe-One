package com.example.tribe.invoke;

import android.content.Context;
import android.content.Intent;

import com.example.tribe.MainActivity;

public class IntentInvoker {

    private Context context;
    private Class<?> _class;
    private Intent intent;

    public IntentInvoker(Context context, Class<?> _class) {
        this.context = context;
        this._class = _class;
        intent = new Intent(context, _class);
    }

    public void invokeAndClean() {
        if(context == null || _class == null)
            return;

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public void invoke() {
        if(context == null || _class == null)
            return;

        context.startActivity(intent);
    }

    public void invokeNoHistory() {
        if(context == null || _class == null)
            return;

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(intent);
    }
}
