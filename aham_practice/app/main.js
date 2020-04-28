import Vue from 'nativescript-vue';

// import App from './components/App';
import Main from './components/Main';
// Uncommment the following to see NativeScript-Vue output logs
// Vue.config.silent = false;


new Vue({
    render:h => h('frame', [h(Main)])
}).$start();