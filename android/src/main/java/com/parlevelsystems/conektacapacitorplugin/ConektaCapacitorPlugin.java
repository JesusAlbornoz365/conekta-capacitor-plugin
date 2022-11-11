package com.parlevelsystems.conektacapacitorplugin;

import android.app.Activity;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import io.conekta.conektasdk.Card;
import io.conekta.conektasdk.Conekta;
import io.conekta.conektasdk.Token;

@CapacitorPlugin(name = "ConektaCapacitorPlugin")
public class ConektaCapacitorPlugin extends Plugin {

    private final ConektaCapacitor implementation = new ConektaCapacitor();

    @PluginMethod
    public  void setPublicKey(PluginCall call){
        String key = call.getString("key","");
        try{
            Conekta.setPublicKey(key);
            call.resolve();
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public  void getPublicKey(PluginCall call){
        try{
            String key = Conekta.getPublicKey();
            JSObject res = new JSObject();
            res.put("key",key);
            call.resolve(res);
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public  void setLanguage(PluginCall call){
        String language = call.getString("language","en");
        try{
            Conekta.setLanguage(language);
            call.resolve();
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public  void getLanguage(PluginCall call){
        try{
            String language = Conekta.getLanguage();
            JSObject res = new JSObject();
            res.put("language",language);
            call.resolve(res);
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public  void createToken(PluginCall call){
        JSObject remote_card = call.getData();

        if(Conekta.getPublicKey().isEmpty()){
            call.reject("Missing public key.");
            return;
        }
        // Checking minimum values
        if(!remote_card.has("number")){
            call.reject("Missing card:number param.");
            return;
        }

        if(!remote_card.has("name")){
            call.reject("Missing card:name param.");
            return;
        }

        if(!remote_card.has("cvc")){
            call.reject("Missing card:cvc param.");
            return;
        }

        if(!remote_card.has("exp_month")){
            call.reject("Missing card:exp_month param.");
            return;
        }

        if(!remote_card.has("exp_year")){
            call.reject("Missing card:exp_month param.");
            return;
        }

        String c_name, c_number, c_cvc, c_expMonth, c_expYear;

        c_name = remote_card.getString("name");
        c_number = remote_card.getString("number");
        c_cvc = remote_card.getString("cvc");
        c_expMonth = remote_card.getString("exp_month");
        c_expYear = remote_card.getString("exp_year");

        try{
            final Card card = new Card(c_name,c_number,c_cvc,c_expMonth,c_expYear);
            final Activity activity = getActivity();
            final Token token = new Token(activity);

            implementation.setCall(call);

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Conekta.collectDevice(activity);
                    token.onCreateTokenListener( new Token.CreateToken(){
                        @Override
                        public void onCreateTokenReady(JSONObject data){
                            PluginCall savedCall = implementation.getCall();

                            JSObject res = new JSObject();
                            Iterator<String> it = data.keys();
                            String key;
                            try{
                                while(it.hasNext()){
                                    key = it.next();
                                    res.put(key, data.get(key));
                                }
                            }catch (JSONException e){
                                savedCall.reject(e.getMessage(),e);
                            }finally {
                                savedCall.resolve(res);
                            }
                        }
                    });
                    token.create(card);
                }
            });
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public void setApiVersion(PluginCall call){
        try{
            String version =  call.getString("api_version","1.0.0");
            Conekta.setApiVersion(version);
            call.resolve();
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public  void getApiVersion(PluginCall call){
        try{
            String version = Conekta.getApiVersion();
            JSObject res = new JSObject();
            res.put("api_version",version);
            call.resolve(res);
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public void deviceFingerPrint(PluginCall call){
        try{
            String fingerprint = Conekta.deviceFingerPrint(getActivity());
            JSObject res = new JSObject();
            res.put("fingerprint",fingerprint);
            call.resolve(res);
        }catch(Exception err){
            call.reject(err.toString());
        }
    }

    @PluginMethod
    public void getBaseUri(PluginCall call){
        try{
            String uri = Conekta.getBaseUri();
            JSObject res = new JSObject();
            res.put("uri",uri);
            call.resolve(res);
        }catch(Exception err){
            call.reject(err.toString());
        }
    }


}
