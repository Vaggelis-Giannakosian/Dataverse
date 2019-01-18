<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="en" class="bg-team index">
<head>
    <#include "partials/head.ftl">

    <!-- Custom styles for this template -->
    <link href="/styles/registerPage.css" rel="stylesheet">
</head>

<body  >

<#include "partials/navbarWithLogout.ftl">


<div class="container-fluid">
    <div class="row">
        <#include "partials/sidebar.ftl">

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Edit Profile</h1>
            </div>
            <form action="/home/edit" method="post">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Company</th>
                    <th scope="col">Password</th>
                    <th scope="col">Confirm Password</th>
                    <td scope="col"></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <@spring.bind "userRegisterForm.firstName"/>
                    <td><input class="form-control"  type="text" name="firstName" value="${userRegisterForm.firstName!""}" required></td>
                    <#list spring.status.errorMessages as error>
                        <span class="error-message"><cite class="error-message" >${error} </cite></span>
                    </#list>
                    <@spring.bind "userRegisterForm.lastName"/>
                    <td><input class="form-control" type="text" name="lastName" value="${userRegisterForm.lastName!""}" required></td>
                    <#list spring.status.errorMessages as error>
                        <span class="error-message"><cite class="error-message" >${error} </cite></span>
                    </#list>
                    <@spring.bind "userRegisterForm.email"/>
                    <td><input class="form-control" type="email" name="email" value="${userRegisterForm.email!""}" required></td>
                    <#list spring.status.errorMessages as error>
                        <span class="error-message"><cite class="error-message" >${error} </cite></span>
                    </#list>
                    <@spring.bind "userRegisterForm.phoneNumber"/>
                    <td><input class="form-control" type="text"  name="phoneNumber" value="${userRegisterForm.phoneNumber!""}"></td>
                    <#list spring.status.errorMessages as error>
                        <span class="error-message"><cite class="error-message" >${error} </cite></span>
                    </#list>
                    <@spring.bind "userRegisterForm.company"/>
                    <td><input class="form-control" type="text" name="company" value="${userRegisterForm.company!""}"></td>
                    <#list spring.status.errorMessages as error>
                        <span class="error-message"><cite class="error-message" >${error} </cite></span>
                    </#list>
                    <@spring.bind "userRegisterForm.password"/>
                    <td><input class="form-control" id="password" type="password" name="password" value="${userRegisterForm.password!""}" required></td>
                    <#list spring.status.errorMessages as error>
                        <span class="error-message"><cite class="error-message" >${error} </cite></span>
                    </#list>
                    <@spring.bind "userRegisterForm.firstName"/>
                    <td><input class="form-control" id="confirm_password" type="password" name="" value="${userRegisterForm.password!""}" required></td>
                    <td><button class="btn btn-success btn-sm" type="submit">Update Profile</button></td>
                </tr>
                </tbody>
            </table>
            </form>
        </main>

    </div>
</div>
<#if error?has_content >

<script>alert("${error}");</script>

</#if>

<#include "partials/scripts.ftl">

</body>
</html>
