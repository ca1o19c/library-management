
# Movie CRUD - :coffee:

> Repositório de Estudo

:arrow_right: API para consolidar o meu aprendizado sobre CRUDs

## API Reference

#### Get all movies

```http
  GET /v1/movies
```

| Parameter | Type     | Description                     |
| :-------- | :------- | :------------------------------ |
| `size`    | `int`    | quantity per page (5)           |
| `page`    | `int`    | choose page (0)                 |
| `sort`    | `string` | sort page  (**desc** or **asc**)|

#### Create movie

```http
  POST /v1/movies
```

| Parameter | Type     | Description                     |
| :-------- | :------- | :------------------------------ |
| `name`    | `string` | **Required**. movie name        |


#### Get movie

```http
  GET /v1/movies/${id}
```

| Parameter | Type     | Description                        |
| :-------- | :------- | :--------------------------------- |
| `id`      | `string` | **Required**. Id of movie to fetch |

#### Get movie

```http
  GET /v1/movies/${name}
```

| Parameter | Type     | Description                        |
| :-------- | :------- | :--------------------------------- |
| `name`    | `string` | **Required**. Id of movie to fetch |


#### Put movie

```http
  PUT /v1/movies/${id}
```

| Parameter | Type     | Description                         |
| :-------- | :------- | :---------------------------------- |
| `id`      | `string` | **Required**. Id of movie to fetch  |
| `name`    | `string` | **Required**. New name to change    | 

#### Delete movie

```http
  DELETE /v1/movies/${id}
```

| Parameter | Type     | Description                         |
| :-------- | :------- | :---------------------------------- |
| `id`      | `string` | **Required**. Id of movie to delete |

