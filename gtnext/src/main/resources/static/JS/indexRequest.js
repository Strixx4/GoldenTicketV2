var page = 0;
document.addEventListener('DOMContentLoaded', function () {
  popolateByUrl('/api/eventi/limit?page=0&size=8');
});

function prevDocumentPage(){
  if(--page < 0){
      page = 0;
  }
  url='/api/eventi/limit?page='+page+'&size=8';
  popolateByUrl(url)
}

function nextDocumentPage(){
url='/api/eventi/limit?page='+ (++page) +'&size=8';
popolateByUrl(url);
}

function popolateByUrl(url) {
  fetch(url)
    .then(response => response.json())
    .then(data => {
      if(data.content==""){
        prevDocumentPage();
      }
      populateHTML(data);
    });
}

function populateHTML(data) {
  var dataContainer = document.getElementById('context');
  var html = '';
  data.content.forEach(item => {
    html += '<div class="card">';
    html += '<div class="img-card">';
    html += '<img src="' + item.locandina + '" alt="Locandina" width="200px"/>';
    html += '</div>';

    html += '<div class="nome-card">';
    html += '<h1>' + item.nome + '</h1>';
    html += '</div>';

    html += '<div class="paragrafo-card">';
    html += '<p>';
    html += item.id+'<br>';
    html += item.localita.citta;
    html += item.localita.zona + '<br>';
    html += item.data;
    html += '</p></div>'
    html += '</div>';
  });
  dataContainer.innerHTML = html;
}
