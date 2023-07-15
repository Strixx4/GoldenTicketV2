var page = 0;
document.addEventListener('DOMContentLoaded', function () {
  popolateByUrl('/api/eventi/limit?page=0&size=8');
});

function prevPage() {
  if (--page < 0) {
    page = 0;
  }
  url = '/api/eventi/limit?page=' + page + '&size=8';
  popolateByUrl(url)
}

function nextPage() {
  url = '/api/eventi/limit?page=' + (++page) + '&size=8';
  popolateByUrl(url);
}

function popolateByUrl(url) {
  fetch(url)
    .then(response => response.json())
    .then(data => {
      if (data.content == "") {
        prevPage();
      }
      populateHTML(data);
    });
}

function populateHTML(data) {
  var dataContainer = document.getElementById('context');
  var html = '';
  data.content.forEach(item => {
    html += '<div class="card mb-3 containers">';
    html += '<div class="row g-0 mid-containers">';
    html += '<div class="col-md-4 prova" >';
    html += '<img src="' + item.locandina + '" class=" rounded-start"  alt="Evento">'
    html += '</div>';
    html += '<div class="col-md-8 card-containers">';
    html += '<div class="card-body">';
    html += '<h5 class="card-title">' + item.nome + '</h5>';
    html += '<p class="card-text">' + item.localita.citta + ' in: ' + item.localita.zona + '</p>';
    html += '<p class="card-text"><small class="text-body-secondary">' + item.data + '</small></p>';
    html += '<a class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="login"/>DETTAGLI</a>';
    html += '</div>';
    html += '</div>';
    html += '</div>';
    html += '</div>';

  });
  dataContainer.innerHTML = html;
}
