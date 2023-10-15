class IndexService {
  constructor() {}
  aggiungi(idEvento, idUser) {
    var body = { idEvento: idEvento };
    restUtil.POST_request(
      "api/carrello/" + idUser + "/aggiungi",
      new RestUtilPayLoad(this.aggiungiOK, {}),
      new RestUtilPayLoad(this.aggiungiKO, {}),
      body
    );
  }
  aggiungiOK() {
    alert("Elemento aggiunto");
  }
  aggiungiKO() {
    alert("Elemento non aggiunto");
  }
}
let indexService = new IndexService();
