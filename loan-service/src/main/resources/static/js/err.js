document.querySelector(".fix1 .actions > .right").addEventListener("click", function(e) {
	location.replace("http://localhost:8000/logout");
});

document.querySelector(".fix1 .actions > .left").addEventListener("click", function(e) {
	location.replace("http://localhost:8000/menu/list");
});
