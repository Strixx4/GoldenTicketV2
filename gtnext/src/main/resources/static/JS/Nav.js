function NavBar(home) {
  const token = sessionStorage.getItem("loginToken");
  //* Home
  var html = `<nav class="navbar navbar-expand-lg bg-black navbar-dark text-white">
		<div class="container-fluid">
			<span class="navbar-brand" >GTNext</span>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="index">Home</a>
					</li>`;
  //* DropDown
  if (home) {
    html += `<li class="nav-item dropdown">
						<span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
							aria-expanded="false" id="localitaDD">
							Località
					</span>
						<ul class="dropdown-menu" id="listCitta">
						</ul>
					</li>
					<li class="nav-item dropdown">
						<span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
							aria-expanded="false" id="tipologiaDD">
							Tipologia
					</span>
						<ul class="dropdown-menu" id="listTipologia">
						</ul>
					</li>`;
  }
  //* Aggiungo acquisti e chart
  if (token != null && token.length > 0) {
    html += `<li class="nav-item dropdown"> 
				<a class="nav-link active" aria-current="page" href="/carrello">Carrello</a>
	 		</li>
			 <li class="nav-item dropdown"> 
			 <a class="nav-link active" aria-current="page" href="/acquisti">Acquisti</a>
		  </li>`;
  }
  html += `</ul>`;
  //* Bottone logout/login
  html += `
					<button class="btn btn-outline-white broTTone text-white" onclick="readLogin()">`;
  if (token == null || token === "") {
    html += `Login`;
  } else {
    html += `Logout`;
  }
  html += `				</button>
				
			</div>
		</div>
	</nav>`;
  document.write(html);
}
