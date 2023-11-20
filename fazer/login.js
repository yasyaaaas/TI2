document.getElementById("formLogin").addEventListener("submit", function (event) {
    event.preventDefault();

    var email = document.getElementById("loginEmail").value;
    var senha = document.getElementById("loginSenha").value;

    var loginData = {
        email: email,
        senha: senha
    };

    axios.post("http://localhost:6789/login", loginData)
        .then((response) => {
            if (response.data.success) {
                console.log("Login bem-sucedido!");
                // Redirecionar ou executar ações após o login bem-sucedido.
            } else {
                console.log("Credenciais inválidas. Verifique seu email e senha.");
            }
        })
        .catch((error) => {
            console.error("Erro ao enviar requisição:", error);
        });
});
