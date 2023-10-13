class CarrelloService {
  getCarrello() {
    restUtil.GET_request(
      "/api/carrello/1",
      new RestUtilPayLoad(this.carrOK, {}),
      new RestUtilPayLoad(this.carrKO, {})
    );
  }

  carrKO() {
    alert("Rsorse non trovate!");
  }

  carrOK(data) {
    var total = 0;
    console.log(data[0]);
    data.forEach((event) => {
      total += event.prezzo;
      const template = `
            <div class="card mb-3" style="max-width: 18rem; margin: 10px; background-color: rgb(220, 175, 106)">
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
      var divElement = document.createElement("div");
      divElement.innerHTML = template;
      document.getElementById("container").appendChild(divElement);
    });
    total += " €";
    document.getElementById("prezzo").innerHTML = total;
  }

  eliminaElemento(id) {
    console.log(id);
    this.getCarrello();
  }

  acquistaCarrello(){
    //TODO prendi da session storage ID e poi procedi all'acquisto
  }
}
let carrelloService = new CarrelloService();
