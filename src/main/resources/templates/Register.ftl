<!doctype html>
<html lang="en" class="bg-team index">
<head>
    <#include "partials/head.ftl">

    <!-- Custom styles for this template -->
    <link href="/styles/registerPage.css" rel="stylesheet">
</head>

<body  >

<#include "partials/navbarTop.ftl">


<#--<div class="container-fluid">-->
    <#--<div class="row">-->



            <div class="container" style="margin-top: 7%;">
                <div class="row justify-content-center">
                    <div class="col-12 col-md-8 col-lg-8 col-xl-6">
                        <div class="row">
                            <div class="col text-center">
                                <h1>Register</h1>
                            </div>
                        </div>
                   <form action="/register" method="post">
                        <div class="row align-items-center form-narrow" >
                            <div class="col mt-4">
                                <input type="text" class="form-control" placeholder="First Name">
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <input type="text" class="form-control" placeholder="Last Name">
                            </div>
                        </div>
                        <div class="row align-items-center mt-4 form-narrow">
                            <div class="col">
                                <input type="email" class="form-control" placeholder="Email">
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <input type="text" class="form-control" placeholder="Company Name">
                            </div>
                        </div>
                        <div class="row align-items-center form-narrow">
                            <div class="col mt-4">
                                <input type="text" class="form-control" placeholder="Phone Number">
                            </div>
                        </div>
                        <div class="row align-items-center mt-4 form-narrow ">
                            <div class="col">
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="col">
                                <input type="password" class="form-control" placeholder="Confirm Password">
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
    <#--</div>-->
<#--</div>-->



</body>
</html>