# springTransactional


Insere novo registro : 

POST http://localhost:8080/demo/add?idUser=0&userName=leandro2&email=leandro.prates@gmail.com&bairro=lauzane&cep=01020-000&endereco=Avenida Paulista 1205&idEndereco=0

Insere usando transacao Spring 

POST http://localhost:8080/demo/add/comtransacao?idUser=0&userName=leandro2&email=leandro.prates@gmail.com&bairro=lauzane&cep=01020-000&endereco=Avenida Paulista 1205&idEndereco=0

Retorna por ID 

GET http://localhost:8080/demo/id/13

Retorna Tudo 

GET http://localhost:8080/demo/all


