(function(window) {
    var DEBUG = true;
    var callbacks = {};
    var guid = 0;
    var ua = navigator.userAgent;
    // TODO 精确性待改进
    var ANDROID = /android/i.test(ua);
    var IOS = /iphone|ipad/i.test(ua);
    var WP = /windows phone/i.test(ua);
    //ANDROID = 0; IOS = 1;

    /**
     * 方便在各个平台中看到完整的 log
     */
    function log() {
        if (DEBUG) {
            console.log.call(console, Array.prototype.join.call(arguments, ' '));
        }
    }

    /**
     * 平台相关的 Web 与 Native 单向通信方法
     */
    function invoke(cmd) {
        log('invoke', cmd);

        if (ANDROID) {
            prompt(cmd);
        }
        else if (IOS) {
            location.href = 'ttpod://' + cmd;
        }
        else if (WP) {
            // TODO ...
        }
    }

    var TTPodBridge = {
        call: function(action,param,callback) {
            log('call', JSON.stringify(param));

            var input = {};
            input.action = action;
            input.token = ++guid;
            input.params = JSON.parse(param);
            callbacks[input.token] = callback;

            invoke(JSON.stringify(input));
        },

        callByNative: function(opt) {
            log('callByNative', JSON.stringify(opt));
            var action = opt.action||'';
            var callback = callbacks[opt.token];
            var ret = opt.ret || {};
            var params = opt.params || '';

            // Native 主动调用 Web
            if (action) {
                log('callByNative script', action);
                try {
                    if(opt.token){
                        invoke(JSON.stringify({
                            token: opt.token,
                            ret: eval(action)
                        }));
                    } else {
                        eval(action);
                    }

                } catch (e) {
                    console.error(e);
                }
            }
            // Web 主动调用 Native，Native 被动的响应
            else if (callback) {
                callback(ret);
                try {
                    delete callback;
                    log(callbacks);
                } catch (e) {
                    console.error(e);
                }
            }

        }
    };

    window.TTPodBridge = TTPodBridge;
    window.__log = log;
})(window);





<script type="text/javascript" src="js/TTPodBridge.js"></script>
    <script type="text/javascript">
        $('#entry_button').on('click',function() {
          TTPodBridge.goto startActivity();
        });
    </script>