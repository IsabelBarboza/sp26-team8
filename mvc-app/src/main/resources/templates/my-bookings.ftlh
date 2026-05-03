
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
<br> <br> 

<h1>Your Recent Bookings</h1>
<h6>Manage your bookings and leave reviews for completed services.</h6>
<hr>
<div class="bookings-container">
  
<#if bookings?? && bookings?size gt 0>

    <#list bookings as booking>
    
      <div class="booking-card">

        <div class="booking-info">
        <p><strong>${booking.service.title}</strong></p>
        <p>Description: ${booking.service.description}</p>
        <p>Date: ${booking.startDate}</p>
        <p>Address: ${booking.address}</p>
        <p>Duration:  ${booking.hours?string("0.##")} hours</p>
        <p>Total: $${booking.totalPrice!0}</p>
         <p>
        <strong>Status:</strong>
        <#if booking.status == "ACTIVE">
            <span  style="color:green;">ACTIVE</span>
        <#elseif booking.status == "CANCELLED">
            <span style="color:red;">CANCELLED</span>
            <#elseif booking.status == "COMPLETED">
        <span style="color:blue;">COMPLETED</span>
        </#if>
          </p>

         <a href="/reviews/new?bookingId=${booking.bookingId}"> Leave Review</a>
          <br><br>
          <#if booking.status == "ACTIVE">
                        <a href="/booking/cancel?bookingId=${booking.bookingId}">Cancel</a>
                        
            </#if>

          </div>
            <img src="/images/${booking.service.serviceId}.jpg" class="service-img">
            
      </div>

     </#list>

      <#else>
          <p>No bookings yet</p>
      </#if>
</div>

<hr>


              <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
          <script src="/script.js"></script>
</body>
</html>