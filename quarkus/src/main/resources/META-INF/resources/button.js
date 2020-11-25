class MyComponent extends HTMLElement {

    connectedCallback() {

        this.innerHTML = `
            <button>My Button</button>
        `;

        this.querySelector('button').onclick = function test() {
            console.log("Button clicked");
        }
    }

}

customElements.define('mycustom-button', MyComponent);