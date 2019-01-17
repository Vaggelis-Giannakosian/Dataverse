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
                                <h1 style="margin-bottom:-2%;">Register</h1>
                            </div>
                        </div>

                   <form action="/register" method="post">
                        <div class="row align-items-center form-narrow" >
                            <div class="col mt-4">
                                <@spring.bind "userRegisterForm.firstName"/>
                                <input type="text" class="form-control" name="firstName" placeholder="First Name">
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <@spring.bind "userRegisterForm.lastName"/>
                                <input type="text" class="form-control" name="lastName" placeholder="Last Name">
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                        </div>
                        <div class="row align-items-center mt-4 form-narrow">
                            <div class="col">
                                <@spring.bind "userRegisterForm.email"/>
                                <input type="email" class="form-control" name="email" placeholder="Email">
                                <#list spring.status.errorMessages as error>
                                    <span><cite> ${error} </cite></span>
                                </#list>
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <@spring.bind "userRegisterForm.company"/>
                                <input type="text" class="form-control" name="company" placeholder="Company Name">

                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <@spring.bind "userRegisterForm.phoneNumber"/>
                                <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number">
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                        </div>
                       <div class="row align-items-center form-narrow">
                           <div class="col mt-4">
                               <@spring.bind "userRegisterForm.password"/>
                                   <input type="password" class="form-control" name="password" placeholder="Password">
                               <#list spring.status.errorMessages as error>
                                   <span>${error}</span>
                               </#list>
                           </div>
                       </div>
                       <div class="row align-items-center form-narrow">
                           <div class="col mt-4">
                               <input type="password" class="form-control" name="passwordConfirm" placeholder="Confirm Password">
                           </div>
                       </div>
                        <div class="row justify-content-start mt-4 form-narrow">
                            <div class="col">
                                <button class="btn btn-primary mt-4">Submit</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>

        <#include "partials/scripts.ftl">

</body>
</html>