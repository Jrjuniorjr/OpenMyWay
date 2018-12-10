# OpenMyWay

Como usar:

Observação 1: Trocar o simbolo '$' pelos valores desejados

Observação 2: Todos os metodos são POST, exceto o gerarRelatorioAcessos, que é metodo GET

Observação 3: Formato de data: DD/MM/YY

urls
localhost:8080/usuario/cadastrar?cpf=$&codigoIdentificacao=$&nome=$&sobrenome=$

localhost:8080/usuario/consultarPorCodigoIdentificacao?codigoIdentificacao=$

localhost:8080/usuario/consultarPorCpf?cpf=$

localhost:8080/usuario/deletarPorCodigoIdentificacao?codigoIdentificacao=$

localhost:8080/usuario/deletarPorCpf?cpf=$

localhost:8080/acesso/socilitarAcesso?codigoIdentificacao=$

localhost:8080/acesso/gerarRelatorioAcessos

localhost:8080/acesso/gerarRelatorioAcessosPorData?data=$