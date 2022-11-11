import { WebPlugin } from '@capacitor/core';

import type { ConektaCapacitorPlugin } from './definitions';

export class ConektaCapacitorPluginWeb
  extends WebPlugin
  implements ConektaCapacitorPlugin
{
  async setPublicKey(params: { key: string }): Promise<void> {
    console.log('setPublicKey', params);
  }
  async getPublicKey(): Promise<{ key: string }> {
    console.log('getPublicKey');
    return { key: ''};
  }
  async setLanguage(params: { language: string }): Promise<void> {
    console.log("setLanguage", params);
  }
  async getLanguage(): Promise<{ language: string }> {
    return { language: ''};
  }
  async createToken(card: { number: string, name: string, cvc: string, exp_month: string, exp_year: string }): Promise<any> {
    console.log("createToken", card);
  }
  async setApiVersion(params: { api_version: string }): Promise<void> {
    console.log("setApiVersion", params);
  }
  async getApiVersion(): Promise<{ api_version: string }> {
    return { api_version: ''};
  }
  async deviceFingerPrint(): Promise<{ fingerprint: string }> {
    return { fingerprint: ''};
  }
  async getBaseUri(): Promise<{ uri: string }> {
    return {uri: ''};
  }
}
