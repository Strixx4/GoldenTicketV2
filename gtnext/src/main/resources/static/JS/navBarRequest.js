document.addEventListener('DOMContentLoaded', function () {
    popolateListCitta('/api/localita/listacitta');
    popolateListTipologia('api/eventi/listatipologia');
});

function popolateListCitta(url) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            populateHTMLCitta(data);
        });
}
function popolateListTipologia(url) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            populateHTMLTipologia(data);
        });
}
function populateHTMLCitta(data) {
    var dataContainer = document.getElementById('listCitta');
    var html = '';
    data.forEach(item => {
        var placeholder="'/api/eventi/citta?citta="+item.citta+"&page=0&size=8'";
        var placeCitta = "'citta'";
        var placeParam="'"+item.citta+"'";
        html += `<li class="dropdown-item listItem">
                <button onclick="popolateByUrl(${placeholder},${placeCitta},${placeParam})">
                ${item.citta}  
                </button></li>`;
    });
    dataContainer.innerHTML = html;
}
function populateHTMLTipologia(data) {
    var dataContainer = document.getElementById('listTipologia');
    var html = '';
    data.forEach(item => {
        var placeholder="'/api/eventi/tipologia?tipologia="+item.tipologia+"&page=0&size=8'";
        var placeTip = "'tipologia'";
        var placeParam="'"+item.tipologia+"'";
        html += `<li class="dropdown-item listItem">
                <button onclick="popolateByUrl(${placeholder},${placeTip},${placeParam})">
                ${item.tipologia}  
                </button></li>`;
    });
    dataContainer.innerHTML = html;
}