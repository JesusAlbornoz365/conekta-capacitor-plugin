import { WebPlugin } from '@capacitor/core';

import type { ConektaCapacitorPluginPlugin } from './definitions';

export class ConektaCapacitorPluginWeb
  extends WebPlugin
  implements ConektaCapacitorPluginPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
