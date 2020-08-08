import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import './contact-form.js';

class MyView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-m);" theme="spacing">
 <vaadin-horizontal-layout>
  <vaadin-text-field placeholder="Filter By Name" clear-button-visible id="filterText"></vaadin-text-field>
  <vaadin-button id="addContactButton">
    Add contact 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; height: 100%;">
  <vaadin-grid style="height: 100%; width: 100%; flex:2; margin: var(--lumo-space-xs);" id="grid"></vaadin-grid>
  <contact-form style="flex:1;"></contact-form>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }



    static get is() {
        return 'my-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(MyView.is, MyView);

          

