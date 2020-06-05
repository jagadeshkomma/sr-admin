<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!doctype html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- Remove Tap Highlight on Windows Phone IE -->
  <meta name="msapplication-tap-highlight" content="no"/>

  <link rel="icon" type="image/png" href="${contextPath}/img/favicon-16x16.png" sizes="16x16">
  <link rel="icon" type="image/png" href="${contextPath}/img/favicon-32x32.png" sizes="32x32">
  <title>SR ADMIN - Login</title>
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="${contextPath}/bower_components/uikit/css/uikit.almost-flat.min.css"/>
  <link rel="stylesheet" href="${contextPath}/css/login_page.min.css" />
</head>
<body class="login_page login_page_v2">

    <div class="uk-container uk-container-center">
        <div class="md-card">
            <div class="md-card-content padding-reset">
                <div class="uk-grid uk-grid-collapse">
                    <div class="uk-width-large-2-3 uk-hidden-medium uk-hidden-small">
                        <div class="login_page_info uk-height-1-1" style="background-image: url('${contextPath}/img/others/sabri-tuzcu-331970.jpg')">
                            <div class="info_content">
                                <h1 class="heading_b">Login Page Header</h1>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam aut culpa cumque eaque earum error esse exercitationem fuga, fugiat harum perferendis praesentium quasi qui, repellendus sapiente, suscipit totam! Eaque, excepturi!
                                <p>
                                    <a class="md-btn md-btn-success md-btn-small md-btn-wave" href="javascript:void(0)">More info</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="uk-width-large-1-3 uk-width-medium-2-3 uk-container-center">
                        <div class="login_page_forms">
                            <div id="login_card">
                                <div id="login_form">
                                    <div class="login_heading">
                                        <div class="user_avatar"></div>
                                    </div>
                                    <c:url var="loginUrl" value="/login" />
                                    <form action="${loginUrl}" method="post" class="form-horizontal">
                                        <div class="uk-form-row">
                                            <label for="login_username">Username</label>
                                            <input class="md-input" type="text" id="login_username" name="username" />
                                        </div>
                                        <div class="uk-form-row">
                                            <label for="login_password">Password</label>
                                            <input class="md-input" type="password" id="login_password" name="password" />
                                        </div>
                                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                        <div class="uk-margin-medium-top">
                                        	<input type="submit" class="md-btn md-btn-primary md-btn-block md-btn-large" value="Sign In">
                                           <!--  <a href="index.html" class="md-btn md-btn-primary md-btn-block md-btn-large">Sign In</a> -->
                                        </div>
                                        <div class="uk-grid uk-grid-width-1-3 uk-grid-small uk-margin-top" data-uk-grid-margin>
                                            <div><a href="#" class="md-btn md-btn-block md-btn-facebook" data-uk-tooltip="{pos:'bottom'}" title="Sign in with Facebook"><i class="uk-icon-facebook uk-margin-remove"></i></a></div>
                                            <div><a href="#" class="md-btn md-btn-block md-btn-twitter" data-uk-tooltip="{pos:'bottom'}" title="Sign in with Twitter"><i class="uk-icon-twitter uk-margin-remove"></i></a></div>
                                            <div><a href="#" class="md-btn md-btn-block md-btn-gplus" data-uk-tooltip="{pos:'bottom'}" title="Sign in with Google+"><i class="uk-icon-google-plus uk-margin-remove"></i></a></div>
                                        </div>
                                        <!-- <div class="uk-margin-top">
                                            <a href="#" id="login_help_show" class="uk-float-right">Need help?</a>
                                            <span class="icheck-inline">
                                                <input type="checkbox" name="login_page_stay_signed" id="login_page_stay_signed" data-md-icheck />
                                                <label for="login_page_stay_signed" class="inline-label">Stay signed in</label>
                                            </span>
                                        </div> -->
                                    </form>
                                </div>
                                <div class="uk-position-relative" id="login_help" style="display: none">
                                    <button type="button" class="uk-position-top-right uk-close uk-margin-right back_to_login"></button>
                                    <h2 class="heading_b uk-text-success">Can't log in?</h2>
                                    <p>Here’s the info to get you back in to your account as quickly as possible.</p>
                                    <p>First, try the easiest thing: if you remember your password but it isn’t working, make sure that Caps Lock is turned off, and that your username is spelled correctly, and then try again.</p>
                                    <p>If your password still isn’t working, it’s time to <a href="#" id="password_reset_show">reset your password</a>.</p>
                                </div>
                               <%--  <div id="login_password_reset" style="display: none">
                                    <button type="button" class="uk-position-top-right uk-close uk-margin-right back_to_login"></button>
                                    <h2 class="heading_a uk-margin-large-bottom">Reset password</h2>
                                    <form>
                                        <div class="uk-form-row">
                                            <label for="login_email_reset">Your email address</label>
                                            <input class="md-input" type="text" id="login_email_reset" name="login_email_reset" />
                                        </div>
                                        <div class="uk-margin-medium-top">
                                            <a href="index.html" class="md-btn md-btn-primary md-btn-block">Reset password</a>
                                        </div>
                                    </form>
                                </div>
                                <div id="register_form" style="display: none">
                                    <button type="button" class="uk-position-top-right uk-close uk-margin-right back_to_login"></button>
                                    <h2 class="heading_a uk-margin-medium-bottom">Create an account</h2>
                                    <form>
                                        <div class="uk-form-row">
                                            <label for="register_username">Username</label>
                                            <input class="md-input" type="text" id="register_username" name="register_username" />
                                        </div>
                                        <div class="uk-form-row">
                                            <label for="register_password">Password</label>
                                            <input class="md-input" type="password" id="register_password" name="register_password" />
                                        </div>
                                        <div class="uk-form-row">
                                            <label for="register_password_repeat">Repeat Password</label>
                                            <input class="md-input" type="password" id="register_password_repeat" name="register_password_repeat" />
                                        </div>
                                        <div class="uk-form-row">
                                            <label for="register_email">E-mail</label>
                                            <input class="md-input" type="text" id="register_email" name="register_email" />
                                        </div>
                                        <div class="uk-margin-medium-top">
                                            <a href="index.html" class="md-btn md-btn-primary md-btn-block md-btn-large">Sign Up</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="uk-margin-top uk-text-center">
                                <a href="#" id="signup_form_show">Create an account</a>
                            </div> --%>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

  <script src="${contextPath}/js/common.min.js"></script>
  <script src="${contextPath}/js/uikit_custom.min.js"></script>
  <script src="${contextPath}/js/altair_admin_common.min.js"></script>
  <script src="${contextPath}/js/pages/login.min.js"></script>
   
</body>

</html>