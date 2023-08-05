function NavBar() {
    var html=`<nav class="navbar navbar-expand-lg bg-black navbar-dark text-white">
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
					</li>
					<li class="nav-item dropdown">
						<span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
							aria-expanded="false">
							Località
					</span>
						<ul class="dropdown-menu" id="listCitta">
							<!--<li><a class="dropdown-item" href="#">Action</a></li>-->
						</ul>
					</li>
					<li class="nav-item dropdown">
						<span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
							aria-expanded="false">
							Tipologia
					</span>
						<ul class="dropdown-menu" id="listTipologia">
							<!--<li><a class="dropdown-item" href="#">Action</a></li>-->
						</ul>
					</li>
				</ul>
				
					<button class="btn btn-outline-success broTTone text-white" onclick="redLogin()">Log</button>
				
			</div>
		</div>
	</nav>`;
    document.write(html)
}