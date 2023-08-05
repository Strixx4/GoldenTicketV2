class RestUtil {
    constructor() {
    }

    DELETE_request(url, restOK, restKO) {
        return fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                //! inserisci il token
            }
        })
            .then(function (response) {
                if (response.status == 200) 
                    restOK.func(restOK.params)
                else 
                    restKO.func(restKO.params)
            }
            )
    }

    GET_request(url, restutilOk, restutilKo){
        return fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                //! 'Authorization': sessionStorage.getItem("loginToken")
            }
        })
            .then(function (response) {
                if (response.status == 200) {
                    return response.text();
                } else {
                    restutilKo.func(restutilKo.params)
                }
            }
            ).then(function (data) {
                try {
                    data = JSON.parse(data);
                    restutilOk.func(data, restutilOk.params)
                    return data
                } catch (e) {
                    alert("Dati non trovati")
                }
            })
    }

    POST_request(url, body, restutilOk, restutilKo) {
        // console.log(body)
        return fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                //!! 'Authorization': sessionStorage.getItem("loginToken")
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(body)
        }
        )
            .then(function (response) {
                if (response.status == 200) {
                    return response.text();
                } else {
                    restutilKo.func(restutilKo.params)
                }
            }

            ).then(function (data) {
                // `data` is the parsed version of the JSON returned from the above endpoint.
                try {
                    data = JSON.parse(data);
                    // { "userId": 1, "id": 1, "title": "...", "body": "..." }
                    restutilOk.func(data, restutilOk.params)
                    // console.log(data)
                    return data;
                } catch (e) {
                    alert("Dati non trovati")
                }
            })

    }
}
let restUtil = new RestUtil()