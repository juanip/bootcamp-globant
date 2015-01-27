POST products/new

  Creates a new product and returns it.
  Response format: JSON.

  Parameters:
    json:
      description    The description of the new product.
      price          The price of the new product.

  Example request:
    POST http://example.com/products/new 
    content-type: application/json
    { "description" : "a new product", "price" : 42 }

  Example result:
    {
      "id" : 3,
      "description" : "a new product",
      "price" : 42.0
    }



GET products

  Returns a collection of products.
  Response format: JSON.
  
  Parameters:
    none

  Example request:
    GET http://example.com/products

  Example result:
    [
      {
        "id" : 0,
        "description" : "My product",
        "price" : 42.0
      },
      {
        "id" : 1,
        "description" : "Another product",
        "price" : 67.0
      },
      {
        "id" : 2,
        "description" : "A blue product",
        "price" : 73.0
      }
    ]



GET products/{id}

  Returns data for the product with the given id.
  Response format: JSON.

  Parameters:
    id        The id of the product for which to return results for.

  Example request:
    GET http://example.com/products/2

  Example result:
    {
      "id" : 2,
      "description" : "A blue product",
      "price" : 73.0
    }



POST cart/new

  Creates a new shopping-cart and returns it.
  Response format: JSON.

  Parameters:
    none

  Example request:
    POST http://example.com/cart/new

  Example result:
    {
      "id" : 2,
      "productList" : [],
      "totalPrice" : 0.0,
      "creditCard" : null,
      "open" : true
    }



POST cart/{id}/add

  Adds a product to the shopping-cart with the given id and returns the shopping-cart.
  Response format: JSON.

  Parameters:
    id        The id of the shopping-cart for which to return results for.
    json:
      id      The id of the product.

  Example request:
    POST http://example.com/cart/2/add 
    content-type: application/json
    { "id" : 2 }

  Example result:
    {
      "id" : 2,
      "productList" : [
        {
          "id" : 1,
          "description" : "Another product",
          "price" : 67.0
        },
        {
          "id" : 0,
          "description" : "My product",
          "price" : 42.0
        },
        {
          "id" : 2,
          "description" : "A blue product",
          "price" : 73.0
        }
      ],
      "totalPrice" : 182.0,
      "creditCard" : null,
      "open" : true
    }



GET cart/{id}

  Returns data for the shopping-cart with the given id.
  Response format: JSON.

  Parameters:
    id        The id of the shopping-cart for which to return results for.       

  Example request:
    GET http://example.com/cart/2

  Example result:
    {
      "id" : 2,
      "productList" : [
        {
          "id" : 1,
          "description" : "Another product",
          "price" : 67.0
        },
        {
          "id" : 0,
          "description" : "My product",
          "price" : 42.0
        }
      ],
      "totalPrice" : 109.0,
      "creditCard" : null,
      "open" : true
    }



GET cart/{id}/products

  Returns the products added in the shopping-cart with the given id.
  Response format: JSON.

  Parameters:
    id        The id of the shopping-cart for which to return results for.

  Example request:
    GET http://example.com/cart/2/products

  Example result:
    [
      {
        "id" : 1,
        "description" : "Another product",
        "price" : 67.0
      },
      {
        "id" : 0,
        "description" : "My product",
        "price" : 42.0
      }
    ]



POST cart/{id}/payment

  Performs the payment for the shopping-cart with the given id and returns the shopping-cart.
  Response format: JSON.

  Parameters:
    id        The id of the shopping-cart for which to return results for.
      json:
        number      The credit card number.
        client      The full name of the client.

  Example request:
    POST http://example.com/cart/2/payment 
    content-type: application/json
    { "number" : "1234 5678 9012 3456", "client" : "Juan Perez" }

  Example result:
    {
      "id" : 2,
      "productList" : [
        {
          "id" : 1,
          "description" : "Another product",
          "price" : 67.0
        },
        {
          "id" : 0,
          "description" : "My product",
          "price" : 42.0
        },
        {
          "id" : 2,
          "description" : "A blue product",
          "price" : 73.0
        }
      ],
      "totalPrice" : 182.0,
      "creditCard" : {
        "number" : "1234 5678 9012 3456",
        "client" : "Juan Perez"
      },
      "open" : false
    }