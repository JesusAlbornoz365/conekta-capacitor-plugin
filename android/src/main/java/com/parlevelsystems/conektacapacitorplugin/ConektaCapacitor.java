package com.parlevelsystems.conektacapacitorplugin;

import android.util.Log;

import com.getcapacitor.PluginCall;

public class ConektaCapacitor {

    private PluginCall call;

    public void setCall(PluginCall call) {
        this.call = call;
    }

    public PluginCall getCall() {
        return this.call;
    }
}
