(function (_, Kotlin) {
  'use strict';
  var throwUPAE = Kotlin.throwUPAE;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var isBlank = Kotlin.kotlin.text.isBlank_gw00vp$;
  var toBoxedChar = Kotlin.toBoxedChar;
  var equals = Kotlin.equals;
  var Unit = Kotlin.kotlin.Unit;
  var Enum = Kotlin.kotlin.Enum;
  var throwISE = Kotlin.throwISE;
  RouteMode.prototype = Object.create(Enum.prototype);
  RouteMode.prototype.constructor = RouteMode;
  function MaterialApp() {
    this.router_6n5hy3$_0 = this.router_6n5hy3$_0;
    println('Initializing Kotlin Material App');
  }
  Object.defineProperty(MaterialApp.prototype, 'router', {
    get: function () {
      if (this.router_6n5hy3$_0 == null)
        return throwUPAE('router');
      return this.router_6n5hy3$_0;
    },
    set: function (router) {
      this.router_6n5hy3$_0 = router;
    }
  });
  MaterialApp.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'MaterialApp',
    interfaces: []
  };
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  function Widget(element) {
    this.element = element;
    this.data = ArrayList_init();
    this.parent = null;
    this.children = ArrayList_init();
  }
  Widget.prototype.append_mjdssc$ = function (widget) {
    this.children.add_11rb$(widget);
    widget.parent = this;
    this.element.append(widget);
    return this;
  };
  Widget.prototype.appendTo_mjdssc$ = function (widget) {
    widget.append_mjdssc$(this);
    return this;
  };
  Widget.prototype.insertBefore = function () {
    return this;
  };
  Widget.prototype.detach = function () {
    var tmp$, tmp$_0;
    (tmp$_0 = (tmp$ = this.parent) != null ? tmp$.children : null) != null ? tmp$_0.remove_11rb$(this) : null;
    this.element.remove();
  };
  Widget.prototype.siblings = function () {
    return ArrayList_init();
  };
  Widget.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Widget',
    interfaces: []
  };
  function Page(element) {
  }
  Page.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Page',
    interfaces: []
  };
  function Route(path, action, data) {
    this.path = path;
    this.action = action;
    this.data = data;
  }
  Route.prototype.execute = function () {
    this.action(this.data);
  };
  Route.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Route',
    interfaces: []
  };
  var LinkedHashMap_init = Kotlin.kotlin.collections.LinkedHashMap_init_q3lmfv$;
  function Router() {
    this.routes_0 = LinkedHashMap_init();
    this.root_0 = '/';
    this.mode_jzaeap$_0 = this.mode_jzaeap$_0;
  }
  Object.defineProperty(Router.prototype, 'mode_0', {
    get: function () {
      if (this.mode_jzaeap$_0 == null)
        return throwUPAE('mode');
      return this.mode_jzaeap$_0;
    },
    set: function (mode) {
      this.mode_jzaeap$_0 = mode;
    }
  });
  Router.prototype.getRoutes = function () {
    return this.routes_0;
  };
  Router.prototype.config_ihuumn$ = function (options) {
    this.mode_0 = options.mode;
    if (!isBlank(options.root)) {
      var other = this.clearSlashes_61zpoe$(options.root);
      this.root_0 = String.fromCharCode(47) + other + String.fromCharCode(toBoxedChar(47));
    }
    return this;
  };
  var Regex_init = Kotlin.kotlin.text.Regex_init_61zpoe$;
  Router.prototype.clearSlashes_61zpoe$ = function (path) {
    var tmp$ = Regex_init('^/').replace_x2uqeu$(path, '');
    return Regex_init('/$').replace_x2uqeu$(tmp$, '');
  };
  Router.prototype.getFragment = function () {
    var fragment;
    if (this.mode_0 === RouteMode$HISTORY_getInstance()) {
      fragment = this.clearSlashes_61zpoe$(decodeURI(window.location.pathname + window.location.search));
      var tmp$ = fragment;
      fragment = Regex_init('\\?(.*)$').replace_x2uqeu$(tmp$, '');
      if (!equals(this.root_0, '/')) {
        var tmp$_0 = fragment;
        fragment = Regex_init(this.root_0).replace_x2uqeu$(tmp$_0, '');
      }
    }
     else {
      var $receiver = window.location.href.match('#(.*)$');
      var match = $receiver != null ? $receiver : [];
      fragment = !(match.length === 0) ? match[1] : '';
    }
    return this.clearSlashes_61zpoe$(fragment);
  };
  Router.prototype.add_fflsmc$ = function (route) {
    var $receiver = this.routes_0;
    var key = route.path;
    $receiver.put_xwzc9p$(key, route);
    return this;
  };
  Router.prototype.remove_61zpoe$ = function (routeKey) {
    this.routes_0.remove_11rb$(routeKey);
    return this;
  };
  Router.prototype.flush = function () {
    this.routes_0.clear();
    this.root_0 = '/';
    this.mode_0 = RouteMode$HISTORY_getInstance();
    return this;
  };
  Router.prototype.execute_61zpoe$ = function (routeKey) {
    var route = this.routes_0.get_11rb$(routeKey);
    route != null ? (route.execute(), Unit) : null;
    return this;
  };
  function Router$listen$lambda(closure$router) {
    return function (it) {
      var path = closure$router.getFragment();
      return closure$router.navigate_18o3fo$(path, path, null);
    };
  }
  Router.prototype.listen = function () {
    var router = this;
    window.onhashchange = Router$listen$lambda(router);
    return this;
  };
  var IllegalStateException_init = Kotlin.kotlin.IllegalStateException_init_pdl1vj$;
  Router.prototype.navigate_18o3fo$ = function (path, title, data) {
    if (title === void 0)
      title = '';
    var route = this.routes_0.get_11rb$(path);
    if (route != null) {
      if (data != null)
        route.data = data;
      if (this.mode_0 === RouteMode$HISTORY_getInstance()) {
        window.history.pushState(route.data, title, this.root_0 + this.clearSlashes_61zpoe$(route.path));
        route.execute();
      }
       else {
        var tmp$ = window.location;
        var tmp$_0 = window.location.href;
        tmp$.href = Regex_init('#(.*)$').replace_x2uqeu$(tmp$_0, '') + '#' + route.path;
        route.execute();
      }
    }
     else {
      throw IllegalStateException_init(('There is no route configured for path: ' + path).toString());
    }
    return this;
  };
  Router.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Router',
    interfaces: []
  };
  function RouteOption(mode, root) {
    this.mode = mode;
    this.root = root;
  }
  RouteOption.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RouteOption',
    interfaces: []
  };
  function RouteMode(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function RouteMode_initFields() {
    RouteMode_initFields = function () {
    };
    RouteMode$HISTORY_instance = new RouteMode('HISTORY', 0);
    RouteMode$HASH_instance = new RouteMode('HASH', 1);
  }
  var RouteMode$HISTORY_instance;
  function RouteMode$HISTORY_getInstance() {
    RouteMode_initFields();
    return RouteMode$HISTORY_instance;
  }
  var RouteMode$HASH_instance;
  function RouteMode$HASH_getInstance() {
    RouteMode_initFields();
    return RouteMode$HASH_instance;
  }
  RouteMode.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RouteMode',
    interfaces: [Enum]
  };
  function RouteMode$values() {
    return [RouteMode$HISTORY_getInstance(), RouteMode$HASH_getInstance()];
  }
  RouteMode.values = RouteMode$values;
  function RouteMode$valueOf(name) {
    switch (name) {
      case 'HISTORY':
        return RouteMode$HISTORY_getInstance();
      case 'HASH':
        return RouteMode$HASH_getInstance();
      default:throwISE('No enum constant com.techprd.material.router.RouteMode.' + name);
    }
  }
  RouteMode.valueOf_61zpoe$ = RouteMode$valueOf;
  var package$com = _.com || (_.com = {});
  var package$techprd = package$com.techprd || (package$com.techprd = {});
  var package$material = package$techprd.material || (package$techprd.material = {});
  package$material.MaterialApp = MaterialApp;
  package$material.Widget = Widget;
  var package$components = package$material.components || (package$material.components = {});
  package$components.Page = Page;
  var package$router = package$material.router || (package$material.router = {});
  package$router.Route = Route;
  package$router.Router = Router;
  package$router.RouteOption = RouteOption;
  Object.defineProperty(RouteMode, 'HISTORY', {
    get: RouteMode$HISTORY_getInstance
  });
  Object.defineProperty(RouteMode, 'HASH', {
    get: RouteMode$HASH_getInstance
  });
  package$router.RouteMode = RouteMode;
  Kotlin.defineModule('kotlin-com.techprd.material', _);
  return _;
}(module.exports, require('kotlin')));

//# sourceMappingURL=kotlin-com.techprd.material.js.map
