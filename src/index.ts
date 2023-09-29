import { registerPlugin } from '@capacitor/core';

import type { ConektaCapacitorPlugin } from './definitions';

const ConektaCapacitor = registerPlugin<ConektaCapacitorPlugin>(
  'ConektaCapacitorPlugin',
  {
    web: () => import('./web').then(m => new m.ConektaCapacitorPluginWeb()),
  },
);

export * from './definitions';
export { ConektaCapacitor };
