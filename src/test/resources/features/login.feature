#language: pt
#encoding: UTF-8
#Author: Jardeson Santos


@regressivo @login
Funcionalidade: Realizar Login
  Testes da API de Login

  @payloadValido
  Cenario: Realizar login com sucesso
    Dado que tenho um payload valido da API de Login
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 200 no response
    E armazeno o token que recebo do response de Login

  @payloadInvalido
  Esquema do Cenario: <id>
    Dado que tenho um payload invalido da API de Login
      | email    | <email>    |
      | password | <password> |
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status no response
      | status | <status> |
    E valido que a mensagem de erro
      | mensagem | <mensagem> |


    Exemplos:
      | id                                | email              | password | status | mensagem                   |
      | Realizar login com email invalido | invalido@email.com | teste    | 400    | Email e/ou senha inválidos |
      | Realizar login com senha invalida | fulano@qa.com      | 12345    | 401    | Email e/ou senha inválidos |



