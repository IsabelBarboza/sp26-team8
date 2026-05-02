<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  <link rel="stylesheet" href="/styles.css">
</head>

<body>
        <nav>   
                 <a href="/">Home</a>
                <a href="/profile">Profile</a>
                <a href="/my-bookings">My Bookings</a>
                <a href="/providers">Services</a>
                <a href="/logout" onclick="return confirmLogout()">Logout</a>
                
        </nav>


        <#if booking??>
        <h1>Booking Confirmed</h1>
        <h6>Service: ${booking.service.title}</h6>
        <h6>Date: ${booking.startDate}</h6>
        <h6>Address: ${booking.address}</h6>
        <h6>Duration:  ${booking.hours?string("0.##")} hours</h6>
        <h6>Total Price: $${booking.totalPrice}</h6>



        </#if>

        
        <br><br>
         <h6><a href="/my-bookings">View My Bookings</a></h6>
          <br>
          <br>
        <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
         <script src="/script.js"></script>
</body>
</html>