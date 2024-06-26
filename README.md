# Equipe de Desenvolvimento:
Arthur Mitsuo Yamamoto -> rm551283 -> Responsabilidades Materias -> (.NET, DEVOPS e IA)

Ramon Cezarino Lopez -> rm551279 -> Responsabilidades Materias -> (QA e IA)

Luigi Ye -> rm552213 -> Responsabilidades Materias -> (BANCO DE DADOS)

Enzo Lafer Gallucci -> rm551111 -> Responsabilidades Materias -> (BANCO DE DADOS)

Daniel dos Santos Araujo Faria -> rm99067 -> Responsabilidades Materias -> (MOBILE)



**Cronograma de Desenvolvimento - PharmaEaseTotem**
---

**1. Definição das Atividades e Responsabilidades:**

- **Luigi Ye**:
  - Desenvolvimento do backend para operações relacionadas aos clientes (CRUD).
- **Daniel dos Santos Araujo Faria**:
  - Desenvolvimento do backend para operações relacionadas às compras (CRUD).
- **Enzo Lafer Gallucci**:
  - Desenvolvimento do backend para operações relacionadas aos medicamentos (CRUD).
- **Ramon Cezarino Lopez**:
  - Revisão de código.
- **Arthur Mitsuo Yamamoto**:
  - Documentação e gerenciamento de projetos.

---

**2. Cronograma de Desenvolvimento:**

**Semana 1:**
- **Luigi Ye**:
  - Implementação do CRUD de clientes.
- **Daniel**:
  - Implementação do CRUD de compras.
- **Enzo**:
  - Implementação do CRUD de medicamentos.

**Semana 2:**
- **Luigi Ye**:
  - Testes e correções no CRUD de clientes.
- **Daniel**:
  - Testes e correções no CRUD de compras.
- **Enzo**:
  - Testes e correções no CRUD de medicamentos.

**Semana 3:**
- **Ramon e Arthur Mitsuo Yamamoto**:
  - Revisão de código.
- **Arthur Mitsuo Yamamoto**:
  - Preparação da documentação técnica e do cronograma.

---

## Link do vídeo:
https://www.youtube.com/watch?v=Wf4Wggnx59g


## Público-Alvo:
O público-alvo são clientes de farmácias que buscam conveniência, recomendações de medicamentos e uma experiência tecnologicamente avançada através de um totem farmacêutico de autoatendimento.

# PharmaEaseTotem-API
API do projeto PharmaEaseTotem - Facilitando o Acesso a Medicamentos


Aqui está a documentação dos endpoints da API para o projeto do totem farmacêutico de autoatendimento:

# Totem Farmacêutico de Autoatendimento - API

## Tarefas

- [ ] CRUD de Clientes
- [ ] CRUD de Compras
- [ ] CRUD de Medicamentos


## Documentação da API

### Endpoint
- [Listar Todos os Clientes](#Listar-todos-os-clientes)
- [Cadastrar Cliente](#Cadastrar-cliente)
- [Detalhes do Cliente](#Detalhes-do-cliente)
- [Apagar Cliente](#Apagar-cliente)
- [Atualizar Cliente](#Atualizar-cliente)
- [Listar Todas as Compras](#Listar-todas-as-compras)
- [Cadastrar Compra](#Cadastrar-compra)
- [Detalhes da Compra](#Detalhes-da-compra)
- [Apagar Compra](#Apagar-compra)
- [Atualizar Compra](#Atualizar-compra)
- [Listar Todos os Medicamentos](#Listar-todos-os-medicamentos)
- [Cadastrar Medicamento](#Cadastrar-medicamento)
- [Detalhes do Medicamento](#Detalhes-do-medicamento)
- [Apagar Medicamento](#Apagar-medicamento)
- [Atualizar Medicamento](#Atualizar-medicamento)

---

### Listar Todos os Clientes

`GET` /clientes

Retorna um array com todos os clientes cadastrados.

#### Exemplo de Resposta

```json
[
    {
        "id": 1,
        "nome": "João da Silva",
        "cpf": "123.456.789-00"
    }
]
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Os dados dos clientes foram retornados com sucesso |
| 401    | Acesso negado. Você deve se autenticar |

---

### Cadastrar Cliente

`POST` /clientes

Cria um novo cliente com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| Campo    | Tipo    | Obrigatório | Descrição                             |
| -------- | ------- | :---------: | ------------------------------------- |
| nome     | string  | ❌          | O nome completo do cliente            |
| cpf      | string  | ✅           | O CPF do cliente                     |

#### Exemplo da Requisição

```json
{
    "nome": "Maria Souza",
    "cpf": "987.654.321-00"
}
```

#### Exemplo da Resposta

```json
{
    "id": 2,
    "nome": "Maria Souza",
    "cpf": "987.654.321-00"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 201    | Cliente cadastrado com sucesso    |
| 400    | Dados enviados são inválidos. Verifique o corpo da requisição |
| 401    | Acesso negado. Você deve se autenticar |

---

### Detalhes do Cliente

`GET` /clientes/{id}

Retorna os detalhes do cliente com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```json
{
    "id": 1,
    "nome": "João da Silva",
    "cpf": "123.456.789-00"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Os dados do cliente foram retornados com sucesso |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe cliente com o `id` informado |

---

### Apagar Cliente

`DELETE` /clientes/{id}

Apaga o cliente com o `id` especificado no parâmetro de path.

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 204    | Cliente foi apagado com sucesso   |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe cliente com o `id` informado |

---

### Atualizar Cliente

`PUT` /clientes/{id}

Altera os dados do cliente especificado no `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

| Campo    | Tipo    | Obrigatório | Descrição                             |
| -------- | ------- | :---------: | ------------------------------------- |
| nome     | string  | ✅           | O nome completo do cliente            |
| cpf      | string  | ✅           | O CPF do cliente                     |

#### Exemplo da Requisição

```json
{
    "nome": "Maria Souza Silva",
    "cpf": "987.654.321-00"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Cliente alterado com sucesso      |
| 400    | Dados enviados são inválidos. Verifique o corpo da requisição |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe cliente com o `id` informado |

---

Com base no código fornecido, aqui está a documentação para a entidade `Compra` seguindo a estrutura fornecida:

### Listar Todas as Compras

`GET` /compras

Retorna um array com todas as compras cadastradas.

#### Exemplo de Resposta

```json
[
    {
        "id": 1,
        "idCliente": 1,
        "idRemedio": 1,
        "dataCompra": "2024-04-15T08:30:00"
    },
    {
        "id": 2,
        "idCliente": 2,
        "idRemedio": 2,
        "dataCompra": "2024-04-15T10:45:00"
    }
]
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Os dados das compras foram retornados com sucesso |
| 401    | Acesso negado. Você deve se autenticar |

---

### Cadastrar Compra

`POST` /compras

Cria uma nova compra com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| Campo         | Tipo    | Obrigatório | Descrição                              |
| ------------- | ------- | :---------: | -------------------------------------- |
| idCliente     | integer | ✅           | O ID do cliente relacionado à compra   |
| idRemedio     | integer | ✅           | O ID do remédio relacionado à compra   |
| dataCompra    | string  | ✅           | Data e hora da compra (formato ISO 8601) |

#### Exemplo da Requisição

```json
{
    "idCliente": 1,
    "idRemedio": 1,
    "dataCompra": "2024-04-15T08:30:00"
}
```

#### Exemplo da Resposta

```json
{
    "id": 3,
    "idCliente": 1,
    "idRemedio": 1,
    "dataCompra": "2024-04-15T08:30:00"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 201    | Compra cadastrada com sucesso    |
| 400    | Dados enviados são inválidos. Verifique o corpo da requisição |
| 401    | Acesso negado. Você deve se autenticar |

---

### Detalhes da Compra

`GET` /compras/{id}

Retorna os detalhes da compra com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```json
{
    "id": 1,
    "idCliente": 1,
    "idRemedio": 1,
    "dataCompra": "2024-04-15T08:30:00"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Os dados da compra foram retornados com sucesso |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe compra com o `id` informado |

---

### Apagar Compra

`DELETE` /compras/{id}

Apaga a compra com o `id` especificado no parâmetro de path.

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 204    | Compra foi apagada com sucesso   |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe compra com o `id` informado |

---

### Atualizar Compra

`PUT` /compras/{id}

Altera os dados da compra especificada no `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

| Campo         | Tipo    | Obrigatório | Descrição                              |
| ------------- | ------- | :---------: | -------------------------------------- |
| idCliente     | integer | ✅           | O ID do cliente relacionado à compra   |
| idRemedio     | integer | ✅           | O ID do remédio relacionado à compra   |
| dataCompra    | string  | ✅           | Data e hora da compra (formato ISO 8601) |

#### Exemplo da Requisição

```json
{
    "idCliente": 1,
    "idRemedio": 1,
    "dataCompra": "2024-04-15T08:30:00"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Compra alterada com sucesso      |
| 400    | Dados enviados são inválidos. Verifique o corpo da requisição |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe compra com o `id` informado |

---

### Listar Todos os Medicamentos

`GET` /medicamentos

Retorna um array com todos os medicamentos cadastrados.

#### Exemplo de Resposta

```json
[
    {
        "id": 1,
        "nome": "Paracetamol",
        "sintomaRelacionado": "Febre"
    }
]
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Os dados dos medicamentos foram retornados com sucesso |
| 401    | Acesso negado. Você deve se autenticar |

---

### Cadastrar Medicamento

`POST` /medicamentos

Cria um novo medicamento com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| Campo            | Tipo    | Obrigatório | Descrição                           |
| ---------------- | ------- | :---------: | ----------------------------------- |
| nome             | string  | ✅           | O nome do medicamento               |
| sintomaRelacionado | string  | ❌           | O sintoma relacionado ao medicamento |

#### Exemplo da Requisição

```json
{
    "nome": "Paracetamol",
    "sintomaRelacionado": "Febre"
}
```

#### Exemplo da Resposta

```json
{
    "id": 1,
    "nome": "Paracetamol",
    "sintomaRelacionado": "Febre"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 201    | Medicamento cadastrado com sucesso |
| 400    | Dados enviados são inválidos. Verifique o corpo da requisição |
| 401    | Acesso negado. Você deve se autenticar |

---

### Detalhes do Medicamento

`GET` /medicamentos/{id}

Retorna os detalhes do medicamento com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```json
{
    "id": 1,
    "nome": "Paracetamol",
    "sintomaRelacionado": "Febre"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Os dados do medicamento foram retornados com sucesso |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe medicamento com o `id` informado |

---

### Apagar Medicamento

`DELETE` /medicamentos/{id}

Apaga o medicamento com o `id` especificado no parâmetro de path.

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 204    | Medicamento foi apagado com sucesso |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe medicamento com o `id` informado |

---

### Atualizar Medicamento

`PUT` /medicamentos/{id}

Altera os dados do medicamento especificado no `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

| Campo            | Tipo    | Obrigatório | Descrição                           |
| ---------------- | ------- | :---------: | ----------------------------------- |
| nome             | string  | ✅           | O nome do medicamento               |
| sintomaRelacionado | string  | ❌           | O sintoma relacionado ao medicamento |

#### Exemplo da Requisição

```json
{
    "nome": "Paracetamol",
    "sintomaRelacionado": "Febre"
}
```

#### Códigos de Status

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Medicamento alterado com sucesso |
| 400    | Dados enviados são inválidos. Verifique o corpo da requisição |
| 401    | Acesso negado. Você deve se autenticar |
| 404    | Não existe medicamento com o `id` informado |

---

