# Hello World JS example

Simplest example rendering text content with JS code on GraalVM.

To check if code is in fact working: `./gradlew :examples:hello-world-js:test`.

Important elements:
* HelloWorldRenderer.java - class configuring and using `JavascriptRenderer` to execute the .js file.
* js/src/index.js - registering custom rendering logic and globally exposing the render function
* package.json - defines local dependency on 'graal-bridge'. In your project use the npm package '@wttech/graal-bridge'.
* webpack.config.js - minimal configuration for a webpack project.
* HelloWorldRendererTest.java - testing the JS logic in Java
