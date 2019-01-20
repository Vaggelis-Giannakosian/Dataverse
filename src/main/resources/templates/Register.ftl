<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="en" class="bg-team index">
<head>
    <#include "partials/head.ftl">

    <!-- Custom styles for this template -->
    <link href="/styles/registerPage.css" rel="stylesheet">
    <script src='https://www.google.com/recaptcha/api.js?render=6LdYHYsUAAAAAHR51TAECQsxBoKqrdN2YcNHXT1Q'></script>

</head>

<body  >

<#include "partials/navbarTop.ftl">



            <div class="container-fluid" style="margin-top: 7%;">
                <div class="row  ">
                    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                        <main class="my-form form-margin">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-md-10">
                                        <div class="card">
                                            <div class="card-header">Register</div>
                                            <div class="card-body">
                                                <form name="create-user" id="create-user" onsubmit="" action="/register" method="post">

                                                    <div class="form-group row">
                                                        <label for="firstName" class="col-md-2 col-form-label text-md-right">First Name</label>
                                                        <div class="col-md-8">
                                                            <@spring.bind "userRegisterForm.firstName"/>
                                                            <input type="text" class="form-control" value="${userRegisterForm.firstName!""}" name="firstName" placeholder="" required>
                                                            <#list spring.status.errorMessages as error>
                                                                <span class="error-message"><cite class="error-message" >${error} </cite></span>
                                                            </#list>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="lastName" class="col-md-2 col-form-label text-md-right">Last Name</label>
                                                        <div class="col-md-8">
                                                            <@spring.bind "userRegisterForm.lastName"/>
                                                            <input type="text" class="form-control" value="${userRegisterForm.lastName!""}" name="lastName" placeholder="" required>
                                                            <#list spring.status.errorMessages as error>
                                                                <span class="error-message"><cite >${error} </cite></span>
                                                            </#list>
                                                        </div>
                                                    </div>

                                                    <div class="form-group row">
                                                        <label for="email" class="col-md-2 col-form-label text-md-right">Email</label>
                                                        <div class="col-md-8">
                                                            <@spring.bind "userRegisterForm.email"/>
                                                            <input type="email" class="form-control" value="${userRegisterForm.email!""}" name="email" placeholder="" required>
                                                            <#list spring.status.errorMessages as error>
                                                                <span class="error-message"><cite > ${error} </cite></span>
                                                            </#list>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="company" class="col-md-2 col-form-label text-md-right">Company</label>
                                                        <div class="col-md-8">
                                                            <@spring.bind "userRegisterForm.company"/>
                                                            <input type="text" class="form-control" value="${userRegisterForm.company!""}" name="company" placeholder="">
                                                        </div>
                                                    </div>

                                                    <div class="form-group row">
                                                        <label for="phoneNumber" class="col-md-2 col-form-label text-md-right">Phone Number</label>
                                                        <div class="col-md-8">
                                                            <@spring.bind "userRegisterForm.phoneNumber"/>
                                                            <input type="text" class="form-control" value="${userRegisterForm.phoneNumber!""}"  name="phoneNumber" placeholder="">
                                                            <#list spring.status.errorMessages as error>
                                                                <span class="error-message"><cite >${error} </cite></span>
                                                            </#list>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="password" class="col-md-2 col-form-label text-md-right">Password</label>
                                                        <div class="col-md-8">
                                                            <@spring.bind "userRegisterForm.password"/>
                                                                <input type="password" class="form-control" id ="password" name="password" placeholder="Password" required>
                                                            <#list spring.status.errorMessages as error>
                                                                <span class="error-message"><cite >${error} </cite></span>
                                                            </#list>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="confirm_password" class="col-md-2 col-form-label text-md-right">Confirm Password</label>
                                                        <div class="col-md-8">
                                                            <input type="password" class="form-control" id ="confirm_password" name="confirm_password" placeholder="Confirm Password" required>

                                                        </div>
                                                    </div>
                                                    <div class="col-md-4 offset-md-2">
                                                        <button type="reset" class="btn btn-default">
                                                            Reset
                                                        </button>
                                                        <button type="submit" class="btn btn-primary">
                                                            Register
                                                        </button>
                                                    </div>
                                            </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </main>
                    </main>
                </div>
            </div>
<#if errorMessage?has_content >

<script>alert("${errorMessage}");</script>

</#if>
        <#include "partials/scripts.ftl">
<script>
    grecaptcha.ready(function() {
        grecaptcha.execute('6LdYHYsUAAAAAHR51TAECQsxBoKqrdN2YcNHXT1Q', {action: '/register'})
            .then(function(token) {
// Verify the token on the server.
            });
    });
</script>
</body>
</html>