import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ConektaCapacitorPlugin)
public class ConektaCapacitorPlugin: CAPPlugin {
    
    var conekta = Conekta()
    
    @objc func setPublicKey(_ call: CAPPluginCall){
        let key = call.getString("key") ?? ""
        conekta.publicKey = key
        call.resolve()
    }
    
    @objc func getPublicKey(_ call: CAPPluginCall){
        call.resolve([
            "key": conekta.publicKey ?? ""
        ])
    }
    
    @objc func setLanguage(_ call: CAPPluginCall){call.reject("Set langugage is not available for Conekta iOS")}
    @objc func getLanguage(_ call: CAPPluginCall){call.reject("Get langugage is not available for Conekta iOS")}
    
    @objc func createToken(_ call: CAPPluginCall){
        
        let c_name = call.getString("name") ?? ""
        let c_number = call.getString("number") ?? ""
        let c_cvc = call.getString("cvc") ?? ""
        let c_expMonth = call.getString("exp_month") ?? ""
        let c_expYear = call.getString("exp_year") ?? ""
        
        conekta.delegate = self.bridge?.viewController
        
        DispatchQueue.main.sync {
            self.conekta.collectDevice()
        }
        
        let card = conekta.card()
        card?.setNumber(c_number, name: c_name, cvc: c_cvc , expMonth: c_expMonth, expYear: c_expYear)
        
        
        let token = conekta.token()
        token?.card = card
        
        
        token?.create(success: { (data) -> Void in
            if let data = data as NSDictionary? as! [String:Any]? {
                call.resolve(data)
            }
        }, andError: { (error) -> Void in
            call.reject(error.debugDescription, "", error)
        })
    }
    
    @objc func setApiVersion(_ call: CAPPluginCall){call.reject("Set Api version is not available for Conekta iOS")}
    @objc func getApiVersion(_ call: CAPPluginCall){call.reject("Get Api version is not available for Conekta iOS")}
    
    @objc func deviceFingerPrint(_ call: CAPPluginCall){
        call.resolve([
            "fingerprint": conekta.deviceFingerprint() ?? ""
        ])
    }
    
    @objc func getBaseUri(_ call: CAPPluginCall){
        call.resolve([
            "uri": conekta.baseURI ?? ""
        ])
    }
    
}
