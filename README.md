# Attornatus
Desafio técnico

# Informações
Project Maven
Language Java
Spring Boot 3.0.2
Packaging Jar
Version 17

### Acesso a console banco de dados:
URL: ```http://localhost:8080/h2```  
JDBC URL:: ```jdbc:h2:mem:testdb```  
User Name: ```root```  
Password: `123456`

# Endpoints
> localhost:8080/api/status

> localhost:8080/api/pessoa/salvar

> localhost:8080/api/pessoa/1

> localhost:8080/api/pessoa/listar

> localhost:8080/api/pessoa/atualizar

> localhost:8080/api/pessoa/1/enderecos

> localhost:8080/api/pessoa/1/endereco

JSON para salvar endereco:

[
{
    "logradouro": "Test 1",
    "numero": 149,
    "cep": "3323132",
    "cidade": "São Paulo",
    "principal": false
},
{
    "logradouro": "Test 2",
    "numero": 555,
    "cep": "1352312",
    "cidade": "Garulhos",
    "principal": true
}
]

JSON para salvar pessoa:

{
"codigo": 1,
  "nome": "Name test one",
  "dataNascimento": "2000-01-05"
}

{
"codigo": 2,
  "nome": "Name test two",
  "dataNascimento": "1998-05-02"
}

JSON para atualizar dados da pessoa:

{
"codigo": 1,
  "nome": "New Name",
  "dataNascimento": "1990-12-15"
}
