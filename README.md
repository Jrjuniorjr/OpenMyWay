# OpenMyWay


Como usar:

Observação 2: Todos os metodos são POST, exceto o gerarRelatorioAcessos, que é metodo GET

Observação 3: Formato de data: DD-MM-YY

URLS

Metodos GET

localhost:8080/consultarPorCodigoIdentificacao/codigoIdentificacaoPassado

localhost:8080/usuario/consultarPorCpf/cpfPassado

localhost:8080/gerarRelatorioAcessosPorCodigoIdentificacao/codigoIdentificacaoPassado

localhost:8080/gerarRelatorioAcessosPorCpf/cpfPassado

localhost:8080/solicitarAcessoEntrada/codigoIdentificacaoPassado

localhost:8080/solicitarAcessoSaida/codigoIdentificacaoPassado

localhost:8080/gerarRelatorioAcessos

localhost:8080/gerarRelatorioAcessosPorData/dataPassada

Post

localhost:8080/usuario/cadastrar?cpf=cpfPassado&codigoIdentificacao=codigoIdentificacaoPassado&nome=nomePassado&sobrenome=sobrenomePassado

localhost:8080/usuario/deletarPorCodigoIdentificacao?codigoIdentificacao=codigoIdentificacaoPassado

localhost:8080/usuario/deletarPorCpf?cpfPassado



