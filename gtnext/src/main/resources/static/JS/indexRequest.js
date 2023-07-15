var page = 0;
document.addEventListener('DOMContentLoaded', function () {
  popolateByUrl('/api/eventi/limit?page=0&size=8');
});

function prevDocumentPage() {
  if (--page < 0) {
    page = 0;
  }
  url = '/api/eventi/limit?page=' + page + '&size=8';
  popolateByUrl(url)
}

function nextDocumentPage() {
  url = '/api/eventi/limit?page=' + (++page) + '&size=8';
  popolateByUrl(url);
}

function popolateByUrl(url) {
  fetch(url)
    .then(response => response.json())
    .then(data => {
      if (data.content == "") {
        prevDocumentPage();
      }
      populateHTML(data);
    });
}

function populateHTML(data) {
  var dataContainer = document.getElementById('context');
  var html = '';
  data.content.forEach(item => {
    html += '<div class="card mb-3" style="max-width: 540px;">';
    html += '<div class="row g-0">';
    html += '<div class="col-md-4" >';
    html += '<img src="' + item.locandina + '" class="img-fluid rounded-start"  alt="Evento">'
    html += '</div>';
    html += '<div class="col-md-8">';
    html += '<div class="card-body">';
    html += '<h5 class="card-title">' + item.nome + '</h5>';
    html += '<p class="card-text">' + item.localita.citta + ' in: ' + item.localita.zona + '</p>';
    html += '<p class="card-text"><small class="text-body-secondary">' + item.data + '</small></p>';
    html += '</div>';
    html += '</div>';
    html += '</div>';
    html += '</div>';

  });
  dataContainer.innerHTML = html;
}
