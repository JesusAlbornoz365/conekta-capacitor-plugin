export interface ConektaCapacitorPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
