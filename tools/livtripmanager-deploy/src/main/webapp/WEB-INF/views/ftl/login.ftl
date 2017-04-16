[#escape x as x?html]
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LivTrip后台登录系统</title>
    <link rel="stylesheet" href="${base}/resources/style/normalize.css">
    <link rel="stylesheet" href="${base}/resources/style/login.css" media="screen" type="text/css" />
</head>

<body>
<section class="login-form-wrap">
    <h1>LivTrip</h1>
    <form class="login-form" action="POST" action="backend/admin/loginProcess.do">
        <label>
            <input type="email" name="userName" required placeholder="Email">
        </label>
        <label>
            <input type="password" name="password" required placeholder="Password">
        </label>
        <input type="submit" value="Login">
    </form>
    <h5><a href="#">Forgot password</a></h5>
</section>
<div style="text-align:center;clear:both">

</div>
</body>
</html>

</body>

</html>
[/#escape]