export {};

declare global {
    namespace NodeJS {
        interface Global {
            render: (name: string, props: string) => string
        }
    }
}
