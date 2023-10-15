class CarrelloService {
  carrelloList = [];
  template = "Non ci sono elementi"
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
    
    this.carrelloList = [];
    var total = 0;
    console.log(data[0]);
    data.forEach((event) => {
      total += event.prezzo;
      template = `
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
            
        `;
      this.carrelloList.push(event.id);
      var divElement = document.createElement("div");
      divElement.innerHTML = template;
      document.getElementById("container").appendChild(divElement);
    });
    total += " €";
    document.getElementById("prezzo").innerHTML = total;
  }

  eliminaElemento(id) {
    restUtil.DELETE_request(
      "/api/carrello/" + sessionStorage.getItem("id") + "/elimina?bigliettoId=" + id,
      new RestUtilPayLoad(this.eliminaOk, {}),
      new RestUtilPayLoad(this.eliminaKo, {})
    );
  }
  eliminaOk() {
    alert("Elemento eliminato");
    this.getCarrello();
  }
  eliminaKo() {
    alert("Elemento non eliminato");
  }
  acquistaCarrello() {
    //TODO prendi da session storage ID e poi procedi all'acquisto
  }
}
let carrelloService = new CarrelloService();
