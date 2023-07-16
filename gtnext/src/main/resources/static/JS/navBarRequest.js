document.addEventListener('DOMContentLoaded', function () {
    popolateListCitta('/api/localita/lista');
});

function popolateListCitta(url) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            populateHTMLCitta(data);
        });
}
function stampa(){
    console.log("PORCODDIO");
}
function populateHTMLCitta(data) {
    var dataContainer = document.getElementById('listCitta');
    var html = '';
    data.forEach(item => {
        var placeholder="'/api/eventi/citta?citta="+item.citta+"&page=0&size=8'";
        var placeCitta = "'citta'";
        var placeParam="'"+item.citta+"'";
        html += `<li class="dropdown-item listItem"><button onclick="popolateByUrl(${placeholder},${placeCitta},${placeParam})">
             ${item.citta}  </button></li>`;
    });
    dataContainer.innerHTML = html;
}