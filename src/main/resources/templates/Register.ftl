<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="en" class="bg-team index">
<head>
    <#include "partials/head.ftl">

    <!-- Custom styles for this template -->
    <link href="/styles/registerPage.css" rel="stylesheet">
</head>

<body  >

<#include "partials/navbarTop.ftl">



            <div class="container" style="margin-top: 7%;">
                <div class="row justify-content-center">
                    <div class="col-12 col-md-8 col-lg-8 col-xl-6">
                        <div class="row">
                            <div class="col text-center">
                                <h1 class="header-top">Register</h1>
                            </div>
                        </div>

                   <form action="/register" method="post">
                        <div class="row align-items-center form-narrow" >
                            <div class="col mt-4">
                                <label class="form-label" for="firstName">First Name</label>
                                <@spring.bind "userRegisterForm.firstName"/>
                                <input type="text" class="form-control" value="${userRegisterForm.firstName!""}" name="firstName" placeholder="First Name" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="error-message"><cite class="error-message" >${error} </cite></span>
                                </#list>
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <label class="form-label" for="lastName">Last Name</label>
                                <@spring.bind "userRegisterForm.lastName"/>
                                <input type="text" class="form-control" value="${userRegisterForm.lastName!""}" name="lastName" placeholder="Last Name" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="error-message"><cite >${error} </cite></span>
                                </#list>
                            </div>
                        </div>
                        <div class="row align-items-center mt-4 form-narrow">
                            <div class="col">
                                <label class="form-label" for="email">Email</label>
                                <@spring.bind "userRegisterForm.email"/>
                                <input type="email" class="form-control" value="${userRegisterForm.email!""}" name="email" placeholder="Email" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="error-message"><cite > ${error} </cite></span>
                                </#list>
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <label class="form-label" for="company">Company Name</label>
                                <@spring.bind "userRegisterForm.company"/>
                                <input type="text" class="form-control" value="${userRegisterForm.company!""}" name="company" placeholder="Company Name">
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow ">
                            <div class="col mt-4 ">
                                <label class="form-label" for="phoneNumber">Phone Number</label>
                                <@spring.bind "userRegisterForm.phoneNumber"/>
                                <input type="text" class="form-control" value="${userRegisterForm.phoneNumber!""}"  name="phoneNumber" placeholder="Phone Number">
                                <#list spring.status.errorMessages as error>
                                    <span class="error-message"><cite >${error} </cite></span>
                                </#list>
                            </div>
                        </div>

                       <div class="row align-items-center form-narrow">
                           <div class="col mt-4">
                               <label class="form-label" for="password">Password</label>
                               <@spring.bind "userRegisterForm.password"/>
                                   <input type="password" class="form-control" id ="password" name="password" placeholder="Password" required>
                               <#list spring.status.errorMessages as error>
                                   <span class="error-message"><cite >${error} </cite></span>
                               </#list>
                           </div>
                       </div>
                       <div class="row align-items-center form-narrow">
                           <div class="col mt-4">
                               <label class="form-label" for="confirm_password">Confirm Password</label>
                               <input type="password" class="form-control" id ="confirm_password" name="confirm_password" placeholder="Confirm Password" required>
                           </div>
                       </div>
                        <div class="row justify-content-start mt-4 form-narrow">
                            <div class="col">
                                <button class="button btn btn-primary mt-4">Submit</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
<#if errorMessage?has_content >

<script>alert("${errorMessage}");</script>

</#if>
        <#include "partials/scripts.ftl">

</body>
</html>