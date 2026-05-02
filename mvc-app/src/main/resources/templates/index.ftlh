
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

    
            <h1> CleanSweep</h1>
            <hr>
            <div class="intro">
              <div class="intro-box">
                
                <p><strong>Welcome to CleanSweep!</strong></p>
                <p>Your one-stop solution for all your cleaning needs. Whether you're looking for a quick tidy-up or a deep clean, we've got you covered.</p>
                <p>Our platform connects you with trusted cleaning professionals in your area, making it easy to find the right service for your home or office.</p>
                <p>Use the navigation links to explore our services and manage your bookings.</p>

                    <a href="/providers"  class="btn btn-primary">Search services</a> 

                
              </div>
            </div>

            <hr>
            <h2>Customer Dashboard</h2>

<div class="stats-container">

    <div class="stat-box">
        <h5>Total Bookings</h5>
        <h2>${totalBookings!0}</h2>
    </div>

    <div class="stat-box">
        <h5>Active Bookings</h5>
        <h2>${activeBookings!0}</h2>
    </div>

</div>

<hr>

<h3>Active Bookings</h3>

<div class="dashboard-section">

<#assign hasActive = false>

<#if bookings?? && bookings?size gt 0>

    <#list bookings as booking>

        <#if booking.status == "ACTIVE">

            <#assign hasActive = true>

            <div class="booking-card">

                <h5>${booking.service.title}</h5>

                <p>
                    <span class="status-active">ACTIVE</span><br>
                    Date: ${booking.startDate}<br>
                    Address: ${booking.address}
                </p>

                <a href="/my-bookings" class="btn btn-sm btn-outline-primary">
                    More Details
                </a>

            </div>

        </#if>

    </#list>

    <#if !hasActive>
        <p>No active bookings.</p>
    </#if>

<#else>
    <p>No bookings yet.</p>
</#if>

</div>

 
              <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>


         <script src="/script.js"></script>
</body>
</html>