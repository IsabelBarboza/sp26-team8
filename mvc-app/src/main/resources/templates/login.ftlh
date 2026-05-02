<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  <link rel="stylesheet" href="styles.css">
  
</head>

<body class="login-bg">
            <h1>Login Page</h1>
           
            <#if error??>
                <h6 style="color:red;">${error}</h6>
            </#if>

            <form id="loginForm" action="/login" method="post">
            <label>Email:</label>
            <input type="email" name="email" placeholder="Enter email" required>

            <br><br>

            <label>Password:</label>
            <input type="password" name="password" placeholder="Enter password" required>

            <br><br>
            <button type="submit">Login</button>
            <br> <br> 

                </form>
             <h6><a href="/">Login as guest</a>  </h6>
              <h6>Don't have an account? <a href="/signup">Sign up here</a></h6>
             <br><br>
             <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
        <script src="/script.js"></script>
</body>
</html>
