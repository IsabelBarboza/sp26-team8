<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  <link rel="stylesheet" href="/styles.css">
</head>

<body >
    <nav>
            <a href="/">Home</a>
                <a href="/profile">Profile</a>
                <a href="/my-bookings">My Bookings</a>
                <a href="/providers">Services</a>
                <a href="/logout">Logout</a>
        
    </nav>

    <section class="error">
        <h1>Oops!</h1>
        <p>Sorry, the page you are looking for does not exist.</p>
        <p>
            ${errorMessage!"Unexpected error occurred"}
        </p>

       
        <a href="/">Go back to Home</a>
    </section>
            
            <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
</body>

</html>