import GraalBridge from 'graal-bridge';

function renderHelloWorld(props: string): string {
  const name = props ? props : 'World';
  return "Hello " + name + "!";
}

const templating = new GraalBridge();
templating.register('hello', renderHelloWorld);
templating.expose();
