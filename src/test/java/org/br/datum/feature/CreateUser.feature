# language: pt
Funcionalidade: Criação de usuários


  Cenario: Validar se usuário é criado enviando os parametros name e job
    Dado que eu possuo a url principal da api
    Quando eu realizar uma requisicao post para criar um usuario com o name "Rafael" e o job "QA"
    Então a api deve retornar o status 201
    E a api deve retornar um json com dados do usuario criado, name "Rafael" e job "QA"