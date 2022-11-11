import { registerPlugin } from '@capacitor/core';

import type { ConektaCapacitorPlugin } from './definitions';

const ConektaCapacitorPlugin = registerPlugin<ConektaCapacitorPlugin>(
  'ConektaCapacitorPlugin',
  {
    web: () => import('./web').then(m => new m.ConektaCapacitorPluginWeb()),
  },
);

export * from './definitions';
export { ConektaCapacitorPlugin };
