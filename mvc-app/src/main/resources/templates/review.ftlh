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

            <h1>Submit a Review</h1>
            <h6>We value your feedback! Please take a moment to share your experience with our cleaning service.</h6>
          <h6>Write Review for Booking ${booking.bookingId}</h6>


        <form id="reviewForm" action="/reviews/save" method="post" onsubmit="submitReview(event)">

            <input type="hidden" name="bookingId" value="${booking.bookingId}"> 

            <label>Rating (1 - 5):</label><br>
            <select id="rating" name="rating" required>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select><br><br>

            <label>Comment:</label><br>
            <textarea  id="comment" name="comment" required></textarea><br><br>
             
            <button type="submit">Submit Review</button>
            
        </form>
           
        <h6>Thank you for helping us improve our services!</h6>

            <hr>

            <h2>Customer Reviews</h2>

          
            <#if reviews?? && reviews?size gt 0>

                <#list reviews as review>
                    <blockquote>
                        <p><strong>${review.customer.name}</strong></p>
                                <p> ${review.rating}/5</p>
                                <p>${review.comment}</p>
                                <p><small>${review.createdAt}</small></p>
                    </blockquote>
                    <hr>
                </#list>

            <#else>
                <p>No reviews yet for this service.</p>
            </#if>



        <footer>
                <p>CSC340 CleanSweep Project</p>
         </footer>
<script src="/script.js"></script>
</body>
</html>