import GraalBridge from 'graal-bridge-react';

import Hello from '@/Hello';

const templating = new GraalBridge();
templating.registerReact('hello', Hello);
templating.expose();
