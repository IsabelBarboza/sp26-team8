<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  <link rel="stylesheet" href="/styles.css">
</head>

<body class="profile-bg">
        <nav>
             <a href="/">Home</a>
                <a href="/profile">Profile</a>
                <a href="/my-bookings">My Bookings</a>
                <a href="/providers">Services</a>
                <a href="/logout" onclick="return confirmLogout()">Logout</a>
        </nav>

            <h1> My profile </h1>
	         <h6>Welcome to your profile page!</h6>
             <h6>Here you can edit your personal information.</h6>
               
        
                
   
            <form id="profileForm" action="/profile/update" class="profile-form" method="post">
                
                <label>Name:</label><br>
                <input type="text" id="name" name="name" value="${customer.name}" ><br><br>
                
                <label>Email:</label><br>
                <input type="email" id="email" name="email" value="${customer.email}"><br><br>

                <label>Phone Number:</label><br>
                <input type="tel" id="phone" name="phone" value="${customer.phoneNumber}" ><br><br>

                <label>Address:</label><br>
                <input type="text" id="address" name="address" value="${customer.address}"><br><br>

               

            
                <button type="submit">Update</button>

            </form>

             <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
          <script src="/script.js"></script>
</body>
</html>