# language: pt
Funcionalidade: Consulta de usuários

  Cenario: Validar se a consulta de apenas um usuário retorna os dados corretos
    Dado que eu possuo um usuário criado
    E e que eu possuo a url principal da api
    Quando eu realizar uma requisição get para obter os dados do usuário com id "2"
    Então a api deve retornar o status 200
    E a api deve retornar um json com dados do usuario, id "2", email "janet.weaver@reqres.in", firt name "Janet" last name "Weaver"