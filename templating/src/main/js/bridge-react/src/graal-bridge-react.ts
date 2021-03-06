import React, {ComponentType} from "react";
import ReactDOMServer from "react-dom/server";

interface Registry {
  [propName: string]: (props: string) => string
}

function renderComponent(componentType: ComponentType<any>) {
  return (props: string) => {
    let value = JSON.parse(props);
    return ReactDOMServer.renderToString(React.createElement(componentType, value));
  }
}

function renderStaticComponent(componentType: ComponentType<any>) {
  return (props: string) => {
    let value = JSON.parse(props);
    return ReactDOMServer.renderToStaticMarkup(React.createElement(componentType, value));
  }
}

export default class GraalBridgeReact {

  private readonly registry: Registry;

  constructor() {
    this.registry = {};
  }

  register(name: string, renderFunction: (props: string) => string) {
    this.registry[name] = renderFunction;
  }

  registerReact(name: string, componentType: ComponentType<any>) {
    this.register(name, renderComponent(componentType));
  }

  registerReactStatic(name: string, componentType: ComponentType<any>) {
    this.register(name, renderStaticComponent(componentType));
  }

  render(name: string, props: string): string {
    let renderFunction = this.registry[name];
    return renderFunction(props);
  }

  expose() {
    global.render = this.render.bind(this);
  }

}
