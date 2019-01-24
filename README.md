# OpenMyWay


Obs: Formato de data: DD-MM-YYYY

Usuario:

{
Atributos: id, cpf, codigoIdentificacao, nome, sobrenome, tipoPessoa, acessos;

}

Obs: tipoPessoa deve ser apenas Convidado se for um usuario.


IntegranteUniversidade:

{
Atributos: id, cpf, codigoIdentificacao, nome, sobrenome, tipoPessoa, acessos, matricula;

}

Obs: tipoPessoa deve ser Aluno, Professor ou Funcionario se for um IntegranteUniversidade.

Acesso:

{
Atributos: id, tipoAcesso, usuario, data, hora;

}

Obs: Um IntegranteUniversidade é um Usuario.

#URL

localhost:8080/

#METODOS POSTS:

#Cadastrar um usuario

usuario/cadastrarUsuario

Formato JSON:

{

	"cpf":"xxxxx",
	"codigoIdentificacao":"xxxxx",
	"nome":"xxxxx",
	"sobrenome":"xxxxx",
	"tipoPessoa":"Convidado"
	
}

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou CONFLICT com texto(se o usuario já existe).

#Cadastar um integrante da universidade

usuario/cadastrarIntegranteUniversidade

Formato JSON:

{

	"cpf":"xxxxx",
	"codigoIdentificacao":"xxxxx",
	"nome":"xxxxx",
	"sobrenome":"xxxxx",
	"tipoPessoa":"xxxxx",
	"matricula":"xxxxx"
	
}

Obs: tipoPessoa deve ser Aluno, Professor ou Funcionario na funcionalidade de cadastar um integrante da universidade.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou CONFLICT com texto(se o usuario já existe).

#METODOS PUT:

#Alterar um usuario

usuario/alterarUsuario

Formato JSON:

{

	"cpf":"xxxxx",
	"codigoIdentificacao":"xxxxx",
	"nome":"xxxxx",
	"sobrenome":"xxxxx",
	"tipoPessoa":"Convidado",
	
}


Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos).

#Alterar um integrante da universidade

usuario/alterarIntegranteUniversidade

Formato JSON:

{

	"cpf":"xxxxx",
	"codigoIdentificacao":"xxxxx",
	"nome":"xxxxx",
	"sobrenome":"xxxxx",
	"tipoPessoa":"xxxxx",
	
}

Obs: tipoPessoa deve ser Aluno, Professor ou Funcionario na funcionalidade de alterar um integrante da universidade.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos).

#METODOS DELETE:

#Deletar um usuario por cpf

usuario/deletarPorCpf

Passar pelo Header apenas o cpf(key: cpf).

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

#Deletar um usuario por codigo de identificacao

usuario/deletarPorCodigoIdentificacao

Passar pelo Header apenas o codigo de identificacao(key: codigoIdentificacao).

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

#METODOS GET:

#Consultar um usuario por cpf

usuario/consultarPorCpf/xxxxx

Obs: No lugar de xxxxx, substituir por cpf.

Retorno: OK com o usuario, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

#Consultar um usuario por codigo de identificacao

usuario/consultarPorCodigoIdentificacao/xxxxx

Obs: No lugar de xxxxx, substituir por codigo de identificacao.

Retorno: OK com o usuario, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

#Gerar relatorio de acessos de um usuario por cpf

usuario/gerarRelatorioAcessosPorCpf/xxxxx

Obs: No lugar de xxxxx, substituir por cpf.

Retorno: OK com uma lista de acessos, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe), NOT_FOUND com texto(se a lista tiver vazia).

#Gerar relatorio de acessos de um usuario por codigo de identificacao

usuario/gerarRelatorioAcessosPorCodigoIdentificacao/xxxxx

Obs: No lugar de xxxxx, substituir por codigo de identificacao.

Retorno: OK com uma lista de acessos, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe), NOT_FOUND com texto(se a lista tiver vazia).

#Solicitar acesso de entrada

acesso/solicitarAcessoEntrada/xxxxx

Obs: No lugar de xxxxx, substituir por codigo de identificacao.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe).

#Solicitar acesso de saida

acesso/solicitarAcessoSaida/xxxxx

Obs: No lugar de xxxxx, substituir por codigo de identificacao.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe).

#Gerar relatorio de todos os acessos

acesso/gerarRelatorioAcessos

Retorno: OK com uma lista de acessos ou NOT_FOUND(se a lista tiver vazia).

#Gerar relatorio de acessos por data

acesso/gerarRelatorioAcessosPorData/xxxxx

Obs: No lugar de xxxxx, substituir por data.

Obs: Formato da data: DD-MM-YYYY

Retorno: OK com uma lista de acessos ou NOT_FOUND(se a lista tiver vazia).

#Gerar relatorio de acessos por data e hora

acesso/gerarRelatorioAcessosPorDataEHora/xxxxx/xxxxx

Obs: Obs: No lugar do primeiro xxxxx, substituir por data. No lugar do segundo xxxxx, substituir por hora.

Obs: Formato da data: DD-MM-YYYY

oBS: Formato da hora: HH:MM:SS

Retorno: OK com uma lista de acessos ou NOT_FOUND(se a lista tiver vazia).