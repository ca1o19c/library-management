<br />
<p align="center">
    <img src="https://i.pinimg.com/originals/dd/64/da/dd64da585bc57cb05e5fd4d8ce873f57.png" alt="Logo" width="200">
 <br />
  <p align="center">
        library management system
      <br />
      <br />
        <img src="https://github.com/ca1o19c/library-management/actions/workflows/ci.yml/badge.svg" alt="Logo" width="200">
       <br />
    <br />
  </p>
</p>

* [Challenge](#challenge)
* [Techs](#techs)
* [How to begin](#how-to-begin)

# Devchallenge

<a href="https://devchallenge.now.sh/"> DevChallenge</a> allows you to develop your skills as a programmer! join our
<a href="https://discord.gg/yvYXhGj">community</a> o/

# Challenge

Build the backend for a library management system!

## Requirements:

### Routes:

<b>[POST] </b> /books : The route must include title, publisher, image and writers within the body of the requisition.
When registering a new bookAggregate, it must be stored inside an object in the following format:

```
{
    "id": "61c5b77b08df532632ca806d",
    "title": "Harry Potter",
    "image": "https://i.imgur.com/UH3IPXw.jpg",
    "publisher": "Rocco",
    "writers": [
        "JK Rowling"
    ],
    "updated_on": "2021-12-24T13:58:14.656",
    "created_on": "2021-12-24T09:05:15.045"
}
```

<br><br>
<b>[GET] </b> /books/ : The route must list all registered books<br><br>
<b>[PUT] </b> /books/:id: : The route must update the title, publisher, image and information of the writers of the bookAggregate
with the id present in the route parameters<br><br>
<b>[DELETE] </b> /books/:id: :The route must delete the bookAggregate with the id present in the route parameters<br>

# techs:

- Tecnologia que preferir :)

# How to begin:

1 - Use this template (by clicking Use this template) or fork this repository with the initial code<br>
2 - Read the instructions at readme.md<br>
3 - Start coding! Feel free to use whatever workflow you find most comfortable<br>
4 - Share your result with the community! #devchallenge
