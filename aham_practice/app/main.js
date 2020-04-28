import Vue from 'nativescript-vue';
import router from './router'

Vue.prototype.$router = router

Vue.prototype.$goto = function (to, options) {
    var options = options || { 
        clearHistory: false, 
        backstackVisible: true, 
        transition: { 
            name: "slide",
            duration: 380,
            curve: "easeIn"
        }
    }
    this.$navigateTo(this.$router[to], options)
}


new Vue({
    render: h => h('frame', [h(router['main'])])
}).$start();