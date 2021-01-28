# Hello World React example

Simplest example rendering text content with React code on GraalVM.

To check if code is in fact working: `./gradlew :examples:hello-world-react:test`.

Important elements:
* HelloWorldRenderer.java - class configuring and using `JavascriptRenderer` to execute the .js file.
* js/src/Hello.jsx - HelloWorld React component definition
* js/src/index.js - registering React components and globally exposing the render function
* package.json - defines local dependency on 'graal-bridge-react'. In your project use the npm package '@wttech/graal-bridge-react'.
* webpack.config.js - minimal configuration for a webpack / React project. Aliases for resolving 'react' and 'react-dom' are defined to battle issues related to how peer dependencies of local dependencies are handled.
* HelloWorldRendererTest.java - testing the React component logic in Java
