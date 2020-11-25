class MyComponent extends HTMLElement {

    connectedCallback() {
        this.init();
    }

    async init() {
        const serv = await fetch('http://localhost:8080/quarkus/json');
        const json = await serv.json();
        const { age, name } = json;
        this.innerText = `Hi ${name}, age is: ${age}`;
    }

}

customElements.define('mycustom-client', MyComponent);