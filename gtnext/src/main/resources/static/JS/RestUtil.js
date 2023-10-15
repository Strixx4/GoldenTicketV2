class RestUtil {
  constructor() {}
  DELETE_request(url, restOK, restKO) {
    return fetch(url, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        Authorization: sessionStorage.getItem("loginToken"),
      },
    }).then(function (response) {
      if (response.status == 200) restOK.func(restOK.params);
      else restKO.func(restKO.params);
    });
  }

  GET_request(url, restutilOk, restutilKo) {
    return fetch(url, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: sessionStorage.getItem("loginToken"),
      },
    })
      .then(function (response) {
        if (response.status == 200) {
          return response.text();
        } else {
          restutilKo.func(restutilKo.params);
        }
      })
      .then(function (data) {
        try {
          data = JSON.parse(data);
          restutilOk.func(data, restutilOk.params);
          return data;
        } catch (e) {
          console.log(e);
        }
      });
  }
  POST_NODATI_request(url, restutilOk, restutilKo, params) {
    // console.log(body)
    return fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: sessionStorage.getItem("loginToken"),
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: JSON.stringify(params),
    }).then(function (response) {
      if (response.status === 200) {
        restutilOk.func(restutilOk.params);
      } else {
        restutilKo.func(restutilKo.params);
      }
    });
  }
  POST_request(url, restutilOk, restutilKo, params) {
    // console.log(body)
    return fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: sessionStorage.getItem("loginToken"),
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: JSON.stringify(params),
    })
      .then(function (response) {
        if (response.status === 200) {
          return response.text();
        } else {
          restutilKo.func(restutilKo.params);
        }
      })
      .then(function (data) {
        // `data` is the parsed version of the JSON returned from the above endpoint.
        try {
          data = JSON.parse(data);
          restutilOk.func(data, restutilOk.params);
          return data;
        } catch (e) {}
      });
  }

  POST_LOGIN_request(url, body, restutilOk, restutilKo) {
    // console.log("body",body)
    return fetch(url, {
      method: "POST",
      headers: {
        Authorization: "Basic " + btoa(body.username + ":" + body.password),
      },
    })
      .then(function (response) {
        if (response.status == 200) {
          const headers = response.headers;
          const customHeader = headers.get("Authorization");
          sessionStorage.setItem("loginToken", customHeader);
          return response.text();
        } else {
          restutilKo.func(restutilKo.params);
        }
      })
      .then(function (data) {
        // `data` is the parsed version of the JSON returned from the above endpoint.
        try {
          data = JSON.parse(data);

          restutilOk.func(data, restutilOk.params);
        } catch (e) {
          alert("Probemi nei dati");
        }
      });
  }
}
let restUtil = new RestUtil();
