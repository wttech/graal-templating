interface Registry {
  [propName: string]: (props: string) => string
}

export default class GraalBridge {

  private readonly registry: Registry;

  constructor() {
    this.registry = {};
  }

  register(name: string, renderFunction: (props: string) => string) {
    this.registry[name] = renderFunction;
  }

  render(name: string, props: string): string {
    let renderFunction = this.registry[name];
    return renderFunction(props);
  }

  expose() {
    global.render = this.render.bind(this);
  }

}
