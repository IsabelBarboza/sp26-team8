<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  <link rel="stylesheet" href="/styles.css">
</head>

<body>
            <h1>Sign Up Page</h1>
            <p>Welcome! Please create an account to get started with CleanSweep.</p>
            
       <form action="/signup" method="post">

          <p>Name:
            <input type="text" name="name" required>
        </p>

        <p>Email:
            <input type="email" name="email" required>
        </p>

        <p>Phone Number:
            <input type="text" name="phoneNumber" required>
        </p>

        <p>Address:
            <input type="text" name="address" required>
        </p>

        <p>Password:
            <input type="password" name="password" required>
        </p>

    <button type="submit">Sign Up</button>

        </form>
            <br> <br> 
             <a href="/">Sign Up as customer</a>  
 
              <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
</body>
</html>