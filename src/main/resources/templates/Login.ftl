<!DOCTYPE html>
<html lang="en">
<head>
    <#include "partials/head.ftl">

    <link rel="stylesheet" href="/styles/signin.css">

    <!-- Custom styles for this template -->

</head>

<body class="text-center">

<form class="form-signin" name="my-form" onsubmit="return validform()" action="/login" method="POST">
    <img class="mb-4" src="/styles/square_logo.png" alt="" width="111" height="">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input name="username" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

</body>
</html>
