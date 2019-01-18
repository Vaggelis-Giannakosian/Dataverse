<#import "/spring.ftl" as spring />

<!doctype html>
<html lang="en" class="bg-team index">
<head>
    <#include "partials/head.ftl">

    <!-- Custom styles for this template -->
    <link href="/styles/indexPage.css" rel="stylesheet">
</head>

<body  >

<#include "partials/navbarWithLogout.ftl">


<div class="container-fluid">
    <div class="row">
        <#include "partials/sidebar.ftl">

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Welcome ${user.userFirstName!""}!</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last First</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Company</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.userFirstName!""}</td>
                    <td>${user.userLastName!""}</td>
                    <td>${user.userEmail!""}</td>
                    <td>${user.userPhoneNumber!""}</td>
                    <td>${user.userCompany!""}</td>
                    <td><a class="btn btn-primary btn-sm" href="/home/edit">Edit Profile</a></td>
                </tr>
                </tbody>
            </table>

        </main>

    </div>
</div>

<#include "partials/scripts.ftl">

</body>
</html>
