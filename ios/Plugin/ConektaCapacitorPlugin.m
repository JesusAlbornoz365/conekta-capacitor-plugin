#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(ConektaCapacitorPlugin, "ConektaCapacitorPlugin",
        CAP_PLUGIN_METHOD(setPublicKey, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(getPublicKey, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(setLanguage, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(getLanguage, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(createToken, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(setApiVersion, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(getApiVersion, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(deviceFingerPrint, CAPPluginReturnPromise);
        CAP_PLUGIN_METHOD(getBaseUri, CAPPluginReturnPromise);
)
