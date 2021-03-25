# Graal Javascript renderer

Javascript execution entrypoint with React support.

## Usage

Add dependency to `package.json`.

```json
"dependencies": {
  "@wttech/graal-bridge": "1.0.0"
},
```

Inside the script import React components, register them and expose the render function.

```js
// import the Graal templating bridge
import GraalBridgeReact from '@wttech/graal-bridge-react';

// import React components 
import ComponentA from 'ComponentA';
import ComponentB from 'ComponentB';

const templating = new TemplatingBridge();

// register React components
// render ComponentA with additional markup for rehydration
templating.registerReact('componentA', ComponentA);
// render ComponentB without the additional markup
templating.registerReactStatic('componentB', ComponentB);

// exposse the render function to be invoked by the Markuply engine
templating.expose();
```

## License

Graal templating bridge is licensed under [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
