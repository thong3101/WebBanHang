<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
        <footer class="footer">
            <div class="grid">
                <div class="grid__row">
                    <div class="grid__col2-4">
                        <h3 class="footer__heading">Chăm sóc khách hàng</h3>
                        <ul class="footer-list">
                            <li class="footer-item">
                                <a href="" class="footer-item__link">Trung Tâm Trợ Giúp</a>
                            </li>
                            <li class="footer-item">
                                <a href="" class="footer-item__link">Duong-Shop Mail</a>
                            </li>
                            <li class="footer-item">
                                <a href="" class="footer-item__link">Hướng dẫn mua hàng</a>
                            </li>
                        </ul>
                    </div>


                    <div class="grid__col2-4">
                        <h3 class="footer__heading">Giới thiệu</h3>
                       <ul class="footer-list">
                            <li class="footer-item">
                                <a href="" class="footer-item__link">Giới thiệu</a>
                            </li>
                            <li class="footer-item">
                                <a href="" class="footer-item__link">Tuyển dụng</a>
                            </li>
                            <li class="footer-item">
                                <a href="" class="footer-item__link">Điều khoản</a>
                            </li>
                        </ul>

                    </div>

                    
                    <div class="grid__col2-4">
                        <h3 class="footer__heading">Theo dõi</h3>
                        <ul class="footer-list">
                            <li class="footer-item">
                                <a href="https://www.facebook.com/profile.php?id=100034504785160" class="footer-item__link">
                                    <i class="footer-item__icon fab fa-facebook"></i>
                                    Facebook
                                </a>
                            </li>
                            <li class="footer-item">
                                <a href="" class="footer-item__link">
                                    <i class="footer-item__icon fab fa-instagram"></i>
                                    instagram
                                </a>
                            </li>
                            <li class="footer-item">
                                <a href="" class="footer-item__link">
                                    <i class="footer-item__icon fab fa-linkedin"></i>
                                    Linkeding
                                </a>
                            </li>
                        </ul>
                    </div>


                    <div class="grid__col2-4">
                        <h3 class="footer__heading">Vào cữa hàng trên ứng dụng</h3>
                        <div class="footer__download">
                            <img src="${url}/assets/img/QAcode.png" alt="Download QR" class="footer__dowload-qr">
                            <div class="footer__download-apps">
                                <a href="">
                                    <img src="${url}/assets/img/googlePlay.png" alt="DownLoad GooglePlay" class="footer__dowload-app-img">
                                </a>
                                <a href="">
                                <img src="${url}/assets/img/appStort.png" alt="Download AppStore" class="footer__dowload-app-img">
                                </a>
                                
                            </div>
                        </div>
                    </div>
                    
                </div>   
            </div>

            <div class="footer__bottom">
                <div class="grid">
                    <p class="footer__text">© 2021 - Bản quyền thuộc về Công ty TNHH DuongPee</p>
                </div>
            </div>
        </footer>
        
<!-- Start of Async Drift Code -->
<script>
"use strict";

!function() {
  var t = window.driftt = window.drift = window.driftt || [];
  if (!t.init) {
    if (t.invoked) return void (window.console && console.error && console.error("Drift snippet included twice."));
    t.invoked = !0, t.methods = [ "identify", "config", "track", "reset", "debug", "show", "ping", "page", "hide", "off", "on" ], 
    t.factory = function(e) {
      return function() {
        var n = Array.prototype.slice.call(arguments);
        return n.unshift(e), t.push(n), t;
      };
    }, t.methods.forEach(function(e) {
      t[e] = t.factory(e);
    }), t.load = function(t) {
      var e = 3e5, n = Math.ceil(new Date() / e) * e, o = document.createElement("script");
      o.type = "text/javascript", o.async = !0, o.crossorigin = "anonymous", o.src = "https://js.driftt.com/include/" + n + "/" + t + ".js";
      var i = document.getElementsByTagName("script")[0];
      i.parentNode.insertBefore(o, i);
    };
  }
}();
drift.SNIPPET_VERSION = '0.3.1';
drift.load('t22zzi6sth4z');
</script>
<!-- End of Async Drift Code -->