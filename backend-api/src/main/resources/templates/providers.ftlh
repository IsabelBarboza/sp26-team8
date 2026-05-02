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
                <a href="/logout">Logout</a>
        </nav>
       
            <h1> Cleaning Services</h1>
	         <h6>Find trusted cleaning professionals in your area.</h6>
             <h6>Browse through our list of experienced providers to find the perfect match for your cleaning needs.</h6>
         <hr>

          <form action="/providers" method="get">
            <input type="text" name="keyword" placeholder="Search services...">
            <input type="number" step="0.01" name="maxPrice" placeholder="Max price">
            <button type="submit">Search</button>
        </form>

         <div class="container">

            <#list services as service>
            <div class="card">

             <p>${service.title}</p>

             <p>Description: ${service.description}</p>

              <p>Price per hour: $${service.price}</p>

             <p>Status:${service.status}</p>
    
             
             <a href="/booking?serviceId=${service.serviceId}">Book Now</a>

             <img src="/images/${service.serviceId}.jpg" class="service-img">
            </div>
            </#list>
       
        </div>
   
         <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
</body>
</html>