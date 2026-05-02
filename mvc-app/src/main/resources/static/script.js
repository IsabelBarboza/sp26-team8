document.addEventListener("DOMContentLoaded", function () {

 
    const reviewForm = document.getElementById("reviewForm");
    if (reviewForm) {
        reviewForm.addEventListener("submit", function (event) {
            event.preventDefault();
            const rating = document.getElementById("rating").value;
            const comment = document.getElementById("comment").value.trim();
            if (!rating || comment === "") {
                alert("Please fill all fields.");
                return;
            }
            alert("Review submitted!");
            reviewForm.submit();
        });
    }

    
    const loginForm = document.getElementById("loginForm");

    if (loginForm) {
        loginForm.addEventListener("submit", function (event) {
            const email = document.querySelector("input[name='email']").value.trim();
            const password = document.querySelector("input[name='password']").value.trim();
            if (email === "" || password === "") {
                alert("Please fill in all fields.");
                event.preventDefault();
                return;
            }
            if (!email.includes("@")) {
                alert("Please enter a valid email.");
                event.preventDefault();
                return;
            }
            if (password.length < 4) {
                alert("Password must be at least 4 characters.");
                event.preventDefault();
                return;
            }
            alert("Logging in...");
        });
    }

});

function confirmLogout() {
    return confirm("Are you sure you want to log out?");
}