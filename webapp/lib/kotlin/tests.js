if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'tests'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'tests'.");
}
if (typeof this['kotlin-test'] === 'undefined') {
  throw new Error("Error loading module 'tests'. Its dependency 'kotlin-test' was not found. Please, check whether 'kotlin-test' is loaded prior to 'tests'.");
}
if (typeof this['kotlin-com.techprd.material'] === 'undefined') {
  throw new Error("Error loading module 'tests'. Its dependency 'kotlin-com.techprd.material' was not found. Please, check whether 'kotlin-com.techprd.material' is loaded prior to 'tests'.");
}
var tests = function (_, Kotlin, $module$kotlin_test, $module$kotlin_material) {
  'use strict';
  var assertEquals = $module$kotlin_test.kotlin.test.assertEquals_3m0tl5$;
  var Unit = Kotlin.kotlin.Unit;
  var Route = $module$kotlin_material.com.techprd.material.router.Route;
  var assertTrue = $module$kotlin_test.kotlin.test.assertTrue_i7pyzi$;
  var assertFails = $module$kotlin_test.kotlin.test.assertFails_o14v8n$;
  var Router = $module$kotlin_material.com.techprd.material.router.Router;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var test = $module$kotlin_test.kotlin.test.test;
  var suite = $module$kotlin_test.kotlin.test.suite;
  function RouterTest() {
    this.router_0 = new Router();
  }
  RouterTest.prototype.clearSlashes = function () {
    assertEquals(this.router_0.clearSlashes_61zpoe$('/somePath/some/'), 'somePath/some');
    assertEquals(this.router_0.clearSlashes_61zpoe$('somePath/some'), 'somePath/some');
    assertEquals(this.router_0.clearSlashes_61zpoe$('somePath/'), 'somePath');
    assertEquals(this.router_0.clearSlashes_61zpoe$('/somePath'), 'somePath');
    assertEquals(this.router_0.clearSlashes_61zpoe$('/somePath/'), 'somePath');
  };
  function RouterTest$addRoute$lambda(it) {
    return Unit;
  }
  function RouterTest$addRoute$lambda_0(this$RouterTest) {
    return function () {
      return !this$RouterTest.router_0.getRoutes().isEmpty();
    };
  }
  RouterTest.prototype.addRoute = function () {
    this.router_0.add_fflsmc$(new Route('/test', RouterTest$addRoute$lambda, null));
    assertTrue(void 0, RouterTest$addRoute$lambda_0(this));
  };
  function RouterTest$removeRoute$lambda(this$RouterTest) {
    return function () {
      return this$RouterTest.router_0.getRoutes().isEmpty();
    };
  }
  RouterTest.prototype.removeRoute = function () {
    this.router_0.remove_61zpoe$('/test');
    assertTrue(void 0, RouterTest$removeRoute$lambda(this));
  };
  function RouterTest$testNavigate$lambda(this$RouterTest) {
    return function () {
      this$RouterTest.router_0.navigate_18o3fo$('/test', 'title', null);
      return Unit;
    };
  }
  RouterTest.prototype.testNavigate = function () {
    assertFails(RouterTest$testNavigate$lambda(this));
  };
  RouterTest.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RouterTest',
    interfaces: []
  };
  var package$com = _.com || (_.com = {});
  var package$techprd = package$com.techprd || (package$com.techprd = {});
  var package$material = package$techprd.material || (package$techprd.material = {});
  var package$router = package$material.router || (package$material.router = {});
  package$router.RouterTest = RouterTest;
  suite('com.techprd.material.router', false, function () {
    suite('RouterTest', false, function () {
      test('clearSlashes', false, function () {
        return (new RouterTest()).clearSlashes();
      });
      test('addRoute', false, function () {
        return (new RouterTest()).addRoute();
      });
      test('removeRoute', false, function () {
        return (new RouterTest()).removeRoute();
      });
      test('testNavigate', false, function () {
        return (new RouterTest()).testNavigate();
      });
    });
  });
  Kotlin.defineModule('tests', _);
  return _;
}(typeof tests === 'undefined' ? {} : tests, kotlin, this['kotlin-test'], this['kotlin-com.techprd.material']);

//# sourceMappingURL=tests.js.map
