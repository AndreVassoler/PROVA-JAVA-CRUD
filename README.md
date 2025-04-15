
#### Listar todas as pessoas
- **GET** `/pessoas`


#### Criar nova pessoa
- **POST** `/pessoas`


#### Atualizar pessoa
- **PUT** `/pessoas/{id}`

#### Deletar pessoa
- **DELETE** `/pessoas/{id}`


### Trabalhos

#### Listar todos os trabalhos
- **GET** `/trabalhos`


#### Buscar trabalho por ID
- **GET** `/trabalhos/{id}`


#### Criar novo trabalho
- **POST** `/trabalhos`

#### Atualizar trabalho
- **PUT** `/trabalhos/{id}`


#### Deletar trabalho
- **DELETE** `/trabalhos/{id}`


## Exemplos de Objetos

### PessoaDTO
```json
{
    "nome": "João Silva",
    "cpf": "123.456.789-00"
}
```

### TrabalhoDTO
```json
{
    "id": 1,
    "cargo": "Desenvolvedor Java",
    "empresa": "Tech Solutions",
    "salario": 5000.00,
    "pessoaId": 1
}
```


