const backendUrl = "";

// this function is used to register a new user
function signup() {
    const email = document.getElementById("signupEmail").value;
    const password = document.getElementById("signupPassword").value;

    fetch("/signup", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    })
    .then(res => res.json())
    .then(data => alert(data.message));
}

function login() {
    const email = document.getElementById("loginEmail").value;
    const password = document.getElementById("loginPassword").value;

    fetch("/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    })
    .then(res => res.json())
    .then(data => {
        alert(data.message);
        if (data.success) {
            window.location.href = "feed.html";
        }
    });
}

function createPost() {
    const text = document.getElementById("postText").value;

    fetch("/posts", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ text })
    })
    .then(res => res.json())
    .then(data => alert(data.message));
}

if (document.getElementById("posts")) {
    fetch("/posts")
        .then(res => res.json())
        .then(posts => {
            const div = document.getElementById("posts");
            div.innerHTML = "";
            posts.forEach(p => {
                const el = document.createElement("p");
                el.innerText = p.text;
                div.appendChild(el);
            });
        });
}
