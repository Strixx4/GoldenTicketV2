class AcquistiService {
  getAcquisti() {
    restUtil.GET_request(
      "/api/acquisto/" + sessionStorage.getItem("id"),
      new RestUtilPayLoad(this.acqOK, {}),
      new RestUtilPayLoad(this.acqKO, {})
    );
  }

  acqKO() {
    alert("Rsorse non trovate!");
  }

  acqOK(data) {
    var template = "";
    document.getElementById("container").innerHTML = "";
    data.forEach((event) => {
      template += `
                <div class="card mb-3" style="max-width: 18rem; margin: 10px; ">
                    <div class="card-header">${event.evento.nome}</div>
                    <div class="card-body">
                        <p>Tipologia: ${event.evento.tipologia}</p>
                        <p>Identificativo: ${event.identificativo}</p>
                        <p>Data: ${event.evento.data}</p>
                        <p>Data acquisto: ${event.data_acquisto}</p>
                        <p>Prezzo: ${event.prezzo}</p>
                    </div>
              </div>
          `;
    });
    document.getElementById("container").innerHTML = template;
  }
}
let acquistiService = new AcquistiService();
