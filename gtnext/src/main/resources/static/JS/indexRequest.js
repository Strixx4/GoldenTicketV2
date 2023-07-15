document.addEventListener('DOMContentLoaded', function() {
  fetch('/api/eventi/limit')
  .then(response => response.json())
  .then(data => {
    populateHTML(data);
  });
});



  function populateHTML(data) {
    var dataContainer = document.getElementById('context');
  
    var html = '';
    data.forEach(item => {
      html += '<div class="card">';
      html += '<div class="img-card">';
      html += '<img src="' + item.locandina + '" alt="Locandina" width="200px"/>';
      html += '</div>';

      html += '<div class="nome-card">';
      html += '<h1>' + item.nome + '</h1>';
      html += '</div>';

      html += '<div class="paragrafo-card">';
      html += '<p>';
      html +=   item.localita.citta ;
      html +=   item.localita.zona +'<br>';
      html +=  item.data ;
      html += '</p></div>'
      html += '</div>';
    });
  
    // Inserisci il codice HTML manipolato nel tuo contenitore
    dataContainer.innerHTML = html;
  }
  