if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'main'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'main'.");
}
if (typeof this['kotlin-com.techprd.material'] === 'undefined') {
  throw new Error("Error loading module 'main'. Its dependency 'kotlin-com.techprd.material' was not found. Please, check whether 'kotlin-com.techprd.material' is loaded prior to 'main'.");
}
var main = function (_, Kotlin, $module$kotlin_material) {
  'use strict';
  var ensureNotNull = Kotlin.ensureNotNull;
  var Widget = $module$kotlin_material.com.techprd.material.Widget;
  var MaterialApp = $module$kotlin_material.com.techprd.material.MaterialApp;
  function main(args) {
    var el = document.createElement('DIV');
    el.appendChild(document.createTextNode('Hello World!!'));
    ensureNotNull(document.body).appendChild(el);
    new Widget(el);
    var materialApp = new MaterialApp();
  }
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('main', _);
  return _;
}(typeof main === 'undefined' ? {} : main, kotlin, this['kotlin-com.techprd.material']);

//# sourceMappingURL=main.js.map
