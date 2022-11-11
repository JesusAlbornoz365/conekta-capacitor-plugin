import { registerPlugin } from '@capacitor/core';

import type { ConektaCapacitorPluginPlugin } from './definitions';

const ConektaCapacitorPlugin = registerPlugin<ConektaCapacitorPluginPlugin>(
  'ConektaCapacitorPlugin',
  {
    web: () => import('./web').then(m => new m.ConektaCapacitorPluginWeb()),
  },
);

export * from './definitions';
export { ConektaCapacitorPlugin };
