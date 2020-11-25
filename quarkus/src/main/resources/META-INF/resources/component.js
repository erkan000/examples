class MyComponent extends HTMLElement {

    connectedCallback() {
        console.log('Custom element added to page.');
        this.innerHTML = `
            <h2> Hi ${this.getAttribute('param')} !</h2>
        `;
    }

}

customElements.define('mycustom-text', MyComponent);