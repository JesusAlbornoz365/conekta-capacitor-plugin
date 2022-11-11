# conekta-capacitor-plugin

Conekta Capacitor Plugin

## Install

```bash
npm install conekta-capacitor-plugin
npx cap sync
```

## API

<docgen-index>

* [`setPublicKey(...)`](#setpublickey)
* [`getPublicKey()`](#getpublickey)
* [`setLanguage(...)`](#setlanguage)
* [`getLanguage()`](#getlanguage)
* [`createToken(...)`](#createtoken)
* [`setApiVersion(...)`](#setapiversion)
* [`getApiVersion()`](#getapiversion)
* [`deviceFingerPrint()`](#devicefingerprint)
* [`getBaseUri()`](#getbaseuri)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### setPublicKey(...)

```typescript
setPublicKey(params: { key: string; }) => Promise<void>
```

| Param        | Type                          |
| ------------ | ----------------------------- |
| **`params`** | <code>{ key: string; }</code> |

--------------------


### getPublicKey()

```typescript
getPublicKey() => Promise<{ key: string; }>
```

**Returns:** <code>Promise&lt;{ key: string; }&gt;</code>

--------------------


### setLanguage(...)

```typescript
setLanguage(params: { language: string; }) => Promise<void>
```

| Param        | Type                               |
| ------------ | ---------------------------------- |
| **`params`** | <code>{ language: string; }</code> |

--------------------


### getLanguage()

```typescript
getLanguage() => Promise<{ language: string; }>
```

**Returns:** <code>Promise&lt;{ language: string; }&gt;</code>

--------------------


### createToken(...)

```typescript
createToken(card: { number: string; name: string; cvc: string; exp_month: string; exp_year: string; }) => Promise<any>
```

| Param      | Type                                                                                             |
| ---------- | ------------------------------------------------------------------------------------------------ |
| **`card`** | <code>{ number: string; name: string; cvc: string; exp_month: string; exp_year: string; }</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### setApiVersion(...)

```typescript
setApiVersion(params: { api_version: string; }) => Promise<void>
```

| Param        | Type                                  |
| ------------ | ------------------------------------- |
| **`params`** | <code>{ api_version: string; }</code> |

--------------------


### getApiVersion()

```typescript
getApiVersion() => Promise<{ api_version: string; }>
```

**Returns:** <code>Promise&lt;{ api_version: string; }&gt;</code>

--------------------


### deviceFingerPrint()

```typescript
deviceFingerPrint() => Promise<{ fingerprint: string; }>
```

**Returns:** <code>Promise&lt;{ fingerprint: string; }&gt;</code>

--------------------


### getBaseUri()

```typescript
getBaseUri() => Promise<{ uri: string; }>
```

**Returns:** <code>Promise&lt;{ uri: string; }&gt;</code>

--------------------

</docgen-api>
