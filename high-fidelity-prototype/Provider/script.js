function submitReview() {
    const rating = document.getElementById("rating").value;
    const comments = document.getElementById("comments").value;

    if(rating === "" || comments === "") {
        alert("Please select a rating and write a comment before submitting.");
    } else {
        alert("Thank you! Your review has been submitted.");
        document.getElementById("reviewForm").reset();
    }
}

