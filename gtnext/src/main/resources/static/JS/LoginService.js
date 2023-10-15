class LoginService {
  constructor() {}
  resetField() {
    document.getElementById("userInput").innerHTML = "Username";
    document.getElementById("pwdInput").innerHTML = "Password";
  }
  submitCredentials() {
    var username = document.getElementById("userInput").value;
    var password = document.getElementById("pwdInput").value;
    var body = { username: username, password: password };
    restUtil.POST_LOGIN_request(
      "api/auth/signin",
      body,
      new RestUtilPayLoad(this.loginOk, {}),
      new RestUtilPayLoad(this.loginKo, {})
    );
  }

  loginOk(data, params) {
    sessionStorage.setItem("id", data.id);
    sessionStorage.setItem("nominativo", data.nominativo);
    sessionStorage.setItem("username", data.username);
    document.location.href = "/";
  }

  loginKo(params) {
    alert("Errore: Username o password errati!");
    resetField();
  }

  logout(){
    sessionStorage.setItem("loginToken", "");
    sessionStorage.setItem("idUser", "");
    sessionStorage.setItem("nominativo", "");
    sessionStorage.setItem("username", "");
    document.location.href = "/";
  }
}
let loginService = new LoginService();
