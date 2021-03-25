# Graal Javascript Renderer

![Maven Central](https://img.shields.io/maven-central/v/io.wttech.graal.templating/templating)
[![javadoc](https://javadoc.io/badge2/io.wttech.graal.templating/templating/javadoc.svg)](https://javadoc.io/doc/io.wttech.graal.templating/templating)
![npm (scoped)](https://img.shields.io/npm/v/@wttech/graal-bridge?label=%40wttech%2Fgraal-bridge%20)
![npm (scoped)](https://img.shields.io/npm/v/@wttech/graal-bridge-react?label=%40wttech%2Fgraal-bridge-react)

Library providing a full pipeline for extracting, caching and executing Javascript source code on Graal for markup generation purposes.

## Documentation

Complete description of the library together with tutorials and how to articles can be found in the link below. 

[Reference documentation](https://wttech.github.io/graal-templating)

## Modules

* templating - main part of the library. Depends mainly on Graal JS SDK. Independent of any framework.
* templating/src/main/js/bridge - JS module establishing a standard entrypoint to JS logic.
* templating/src/main/js/bridge-react - JS module establishing a standard entrypoint to React logic.
* spring-boot-starter - integration with Spring Boot including `ScriptProvider` for extracting JS source file from external server using `WebClient`.

## Example projects

There are several example projects in the `/examples` subfolder showing how to integrate Graal templating into your application.

* `hello-world-js` - processing templates located on the classpath
* `hello-world-react` - processing templates hosted on an external HTTP server
* `hello-world-ts` - rendering component markup with JS renderer on GraalVM
* `spring-boot` - treating component inner content as pebble template

## Contributing

[Contributing rules](CONTRIBUTING.md)

## Code of conduct

[Code of conduct](CODE_OF_CONDUCT.md)

## License

This project is licensed under [Apache License, Version 2.0](LICENSE).
