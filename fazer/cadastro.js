document.getElementById("formCadastro").addEventListener("submit", function (event) {
    event.preventDefault();

    var nome = document.getElementById("nome").value;
    var email = document.getElementById("email").value;
    var senha = document.getElementById("senha").value;

    var conta = {
        nomeCompleto: nome,
        email: email,
        senha: senha
    };

    axios.post("http://localhost:6789/cadastro/insert", conta)
        .then((response) => {
            console.log(response.data);
        })
        .catch((error) => {
            console.error("Erro ao enviar requisição:", error);
        });

});