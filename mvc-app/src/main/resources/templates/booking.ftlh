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
        <section class="form">
            <h1> Booking Service</h1>
            <p>Schedule your cleaning service with ease.</p>

            <#if error??>
                <p style="color:red;">${error}</p>
            </#if>
           
            
            <form  class="booking-form" action="/book" method="post" enctype="multipart/form-data">
              
                <input type="hidden" name="serviceId" value="${serviceId!}">

                <label>Start Date:</label><br>
                <input type="datetime-local" name="startDate" required><br><br>

                <label>End Date:</label><br>
                <input type="datetime-local" name="endDate" required><br><br>

                  <label>Address:</label><br>
                <input type="text" name="address" required><br><br>

               

                <button type="submit" class="btn btn-primary">Confirm Booking</button>
                    

            </form>

            
        </section>
        
        <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
          <script src="/script.js"></script>
</body>
</html>