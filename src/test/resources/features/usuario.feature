#language: pt
#encoding: UTF-8
#Author: Jardeson Santos

@regressivo @usuarios
Funcionalidade: Gerenciar Usuários
  Testes da API de Usuários do Serverest


  @cadastro
  Cenario: Cadastrar um usuário com sucesso
    Dado que tenha realizado o login com dados validos
    Dado que tenho um payload valido da API de Usuarios
    Quando envio uma requisicao do tipo POST de Usuarios
    Entao valido que recebo status 201 no response
    E armazeno o id do usuario que recebo do response de Usuarios

  @listagem
  Cenario: Listar todos os usuários
    Dado que tenha realizado o login com dados validos
    Quando envio uma requisicao do tipo GET para listar Usuarios
    Entao valido que recebo status 200 no response

  @consulta
  Cenario: Consultar um usuário por ID
    Dado que tenha realizado o login com dados validos
    Dado que tenho um payload valido da API de Usuarios
    Quando envio uma requisicao do tipo POST de Usuarios
    E armazeno o id do usuario que recebo do response de Usuarios
    Quando envio uma requisicao do tipo GET para consultar Usuario por ID
    Entao valido que recebo status 200 no response

  @alteracao
  Cenario: Alterar um usuário com sucesso
    Dado que tenha realizado o login com dados validos
    Dado que tenho um payload valido da API de Usuarios
    Quando envio uma requisicao do tipo POST de Usuarios
    E armazeno o id do usuario que recebo do response de Usuarios
    Dado que altero o campo nome do payload de Usuarios para "Nome Alterado"
    Quando envio uma requisicao do tipo PUT de Usuarios
    Entao valido que recebo status 200 no response

  @exclusao
  Cenario: Excluir um usuário com sucesso
    Dado que tenha realizado o login com dados validos
    Dado que tenho um payload valido da API de Usuarios
    Quando envio uma requisicao do tipo POST de Usuarios
    E armazeno o id do usuario que recebo do response de Usuarios
    Quando envio uma requisicao do tipo DELETE de Usuarios
    Entao valido que recebo status 200 no response
