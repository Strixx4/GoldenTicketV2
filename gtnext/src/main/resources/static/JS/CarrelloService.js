class CarrelloService {
  listaElementi = [];
  getCarrello() {
    restUtil.GET_request(
      "/api/carrello/" + sessionStorage.getItem("id"),
      new RestUtilPayLoad(this.carrOK, {}),
      new RestUtilPayLoad(this.carrKO, {})
    );
  }

  carrKO() {
    alert("Rsorse non trovate!");
  }

  carrOK(data) {
    var total = 0;
    var template = "";
    document.getElementById("container").innerHTML = "";
    this.listaElementi = [];
    data.forEach((event) => {
      this.listaElementi.push(event.id);
      total += event.prezzo;
      template += `
              <div class="card mb-3" style="max-width: 18rem; margin: 10px; ">
                  <div class="card-header">${event.evento.nome}</div>
                  <div class="card-body">
                      <p>Tipologia: ${event.evento.tipologia}</p>
                      <p>Identificativo: ${event.identificativo}</p>
                      <p>Prezzo: ${event.prezzo}</p>
                      <div class="d-grid gap-2">
                          <button class="btn" type="button" style="background-color: rgba(0, 0, 0); color: bisque"
                          onclick="carrelloService.eliminaElemento(${event.id})">
                              Elimina</button>
                      </div>
                  </div>
            </div>
        `;
    });
    total += " €";
    document.getElementById("container").innerHTML = template;
    document.getElementById("prezzo").innerHTML = total;
  }

  eliminaElemento(id) {
    restUtil.DELETE_request(
      "/api/carrello/" +
        sessionStorage.getItem("id") +
        "/elimina?bigliettoId=" +
        id,
      new RestUtilPayLoad(this.eliminaOk, {}),
      new RestUtilPayLoad(this.eliminaKo, {})
    );
  }
  eliminaOk() {
    alert("Elemento eliminato");
    carrelloService.getCarrello();
  }
  eliminaKo() {
    alert("Elemento non eliminato");
  }
  acquistaCarrello() {
    const body = { ids: this.listaElementi };
    restUtil.POST_request(
      "/api/acquisto/acquista",
      new RestUtilPayLoad(this.acquistaOK, {}),
      new RestUtilPayLoad(this.acquistaKO, {}),
      body
    );
  }
  acquistaOK() {
    document.location.href = "/acquisti";
  }
  acquistaKO() {
    alert("Transizione non riuscita")
  }
}
let carrelloService = new CarrelloService();
