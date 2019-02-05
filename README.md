# OpenMyWay


Obs: Formato de data: DD-MM-YYYY

Usuario:

{

Atributos: id, cpf, codigoIdentificacao, nome, sobrenome, tipoUsuario, acessos;

}

Obs: tipoUsuario deve ser apenas Convidado se for um usuario.


IntegranteUniversidade:

{

Atributos: id, cpf, codigoIdentificacao, nome, sobrenome, tipoUsuario, acessos, matricula;

}

Obs: tipoUsuario deve ser Aluno, Professor ou Funcionario se for um IntegranteUniversidade.

Acesso:

{

Atributos: id, tipoAcesso, usuario, data, hora;

}

Obs: Um IntegranteUniversidade é um Usuario.

#URL

https://openmyway.herokuapp.com/

#METODOS POST:

#Cadastrar um usuario

usuario/cadastrarUsuario

Formato JSON:

{

	"cpf":String,
	"codigoIdentificacao":String,
	"nome":String,
	"sobrenome":String
	
}

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou CONFLICT com texto(se o usuario já existe).

#Cadastar um integrante da universidade

usuario/cadastrarIntegranteUniversidade

Formato JSON:

{

	"cpf":String,
	"codigoIdentificacao":String,
	"nome":String,
	"sobrenome":String,
	"tipoUsuario":String,
	"matricula":String
	
}

Obs: tipoUsuario deve ser Aluno, Professor ou Funcionario.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou CONFLICT com texto(se o usuario já existe).

#METODOS PUT:

#Alterar um usuario

usuario/alterarUsuario

Formato JSON:

{
	
	"id":Integer,
	"cpf":String,
	"codigoIdentificacao":String,
	"nome":String,
	"sobrenome":String
	
}


Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos).

#Alterar um integrante da universidade

usuario/alterarIntegranteUniversidade

Formato JSON:

{

	"id":Integer,
	"cpf":String,
	"codigoIdentificacao":String,
	"nome":String,
	"sobrenome":String,
	"tipoUsuario":String,
	"matricula":String
	
}

Obs: tipoUsuario deve ser Aluno, Professor ou Funcionario.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos).

#METODOS DELETE:

#Deletar um usuario por cpf

usuario/deletarPorCpf/String

Obs: No lugar do String, substituir por cpf.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

#Deletar um usuario por codigo de identificacao

usuario/deletarPorCodigoIdentificacao/String

Obs: No lugar do String, substituir por codigoIdentificacao.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

#METODOS GET:

#Consultar um usuario por cpf

usuario/consultarPorCpf/String

Obs: No lugar do String, substituir por cpf.

Retorno: OK com o usuario, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

Obs: Um usuario tem uma lista de acessos e acessos tem usuario, mas para essa funcionalidade, acesso tem um usuario e este usuario ta null (para evitar looping na hora de exibição).

#Consultar um usuario por codigo de identificacao

usuario/consultarPorCodigoIdentificacao/String

Obs: No lugar do String, substituir por codigoIdentificacao.

Retorno: OK com o usuario, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos) ou NOT_FOUND com texto(se o usuario não existe).

Obs: Um usuario tem uma lista de acessos e acessos tem usuario, mas para essa funcionalidade, acesso tem um usuario e este usuario ta null (para evitar looping na hora de exibição).

#Listar todos os usuarios

usuario/listarUsuarios

Retorno: OK com a lista de usuarios ou NOT_FOUND com a lista de usuarios vazia.

Obs: Um usuario tem uma lista de acessos e acessos tem usuario, mas para essa funcionalidade, acesso tem um usuario e este usuario ta null (para evitar looping na hora de exibição).

#Gerar relatorio de acessos de um usuario por cpf

usuario/gerarRelatorioAcessosPorCpf/String

Obs: No lugar do String, substituir por cpf.

Retorno: OK com um usuario(que por sua vez tem uma lista de acessos), NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe), NOT_FOUND com a lista de usuarios vazia.

Obs: Um usuario tem uma lista de acessos e acessos tem usuario, mas para essa funcionalidade, acesso tem um usuario e este usuario ta null (para evitar looping na hora de exibição).

#Gerar relatorio de acessos de um usuario por codigo de identificacao

usuario/gerarRelatorioAcessosPorCodigoIdentificacao/String

Obs: No lugar do String, substituir por codigoIdentificacao.

Retorno: OK com um usuario(que por sua vez tem uma lista de acessos), NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe), NOT_FOUND com a lista de usuarios vazia.

Obs: Um usuario tem uma lista de acessos e acessos tem usuario, mas para essa funcionalidade, acesso tem um usuario e este usuario ta null (para evitar looping na hora de exibição).

#Solicitar acesso de entrada

acesso/solicitarAcessoEntrada/String

Obs: No lugar do String, substituir por codigoIdentificacao.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe).

#Solicitar acesso de saida

acesso/solicitarAcessoSaida/String

Obs: No lugar do String, substituir por codigoIdentificacao.

Retorno: OK com texto, NOT_ACCEPTABLE com texto(se os parametros passados não estiverem certos), NOT_FOUND com texto(se o usuario não existe).

#Gerar relatorio de todos os acessos

acesso/gerarRelatorioAcessos

Retorno: OK com uma lista de acessos ou NOT_FOUND com a lista de acessos vazia.

Obs: Um acesso tem um usuario e um usuario tem uma lista de acessos, mas para essa funcionalidade, usuario tem a lista de acessos e esta lista de acessos ta null (para evitar looping na hora de exibição).

#Gerar relatorio de acessos por data

acesso/gerarRelatorioAcessosPorData/String

Obs: No lugar do String, substituir por data.

Obs: Formato da data: DD-MM-YYYY

Retorno: OK com uma lista de acessos ou NOT_FOUND com a lista de acessos vazia.

Obs: Um acesso tem um usuario e um usuario tem uma lista de acessos, mas para essa funcionalidade, usuario tem a lista de acessos e esta lista de acessos ta null (para evitar looping na hora de exibição).

#Gerar relatorio de acessos por data e hora

acesso/gerarRelatorioAcessosPorDataEHora/String/String

Obs: No lugar do primeiro String, substituir por data. No lugar do segundo String, substituir por hora.

Obs: Formato da data: DD-MM-YYYY

Obs: Formato da hora: HH:MM:SS

Retorno: OK com uma lista de acessos ou NOT_FOUND com a lista de acessos vazia.

Obs: Um acesso tem um usuario e um usuario tem uma lista de acessos, mas para essa funcionalidade, usuario tem a lista de acessos e esta lista de acessos ta null (para evitar looping na hora de exibição).
