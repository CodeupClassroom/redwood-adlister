# Notes

## Create

What do we need

* A servlet (controller)
    * `/model/create` or `/model/new` for instance `/ads/create` or `/users/new` or
      `/users/signup`
    * `doGet` -> show a form to enter the information for your model
    * `doPost` ->
        1. Is the input valid? for instance, is the age a number?, is the username not empty?
           Is the year greater than zero?, is the date in the past or in the future? Is the 
           input a valid date?
        1. Create a new object for that model, for instance a `new User` or `new Ad`, you'll 
           get the values for your model from the request, `request.getParameter("username")`
        1. Get the right DAO for your model, if it's users you'll need the `UsersDao`, we get
            that DAO from the factory
        1. Call the `insert` method in your dao
        1. Redirect to either the view all models page or the view specific model, `/ads` (view all) or `/ads/show?id=2` (view specific one)   
* A jsp file (view)
    * Has the same name as the path, for instance if your path is `/users/create` your jsp
      is going to be saved at `webapps/users/create.jsp`

## Read

## Read all

* A servlet 
    * `/model` for instance `/ads/` or `/products`
    * doGet -> Show a list with all the models (a table, an unordered list)
        1. Get the correct DAO for your model from the DaoFactory
        1. Call the `all` method
        1. Pass the `List` returned by your DAO to the view (`request.setAttribute(...)`)
* A jsp
    * You would name your jsp as follows. For instance for ads `webapp/ads/index.jsp` or 
      `webapp/users/index.jsp`

## Read a single one

* A servlet
    * `/model/show?id=3`, for instance `/ads/show?id=3` will show the ad with ID 3
    * doGet -> Show every useful column on that table
        1. Get the correct DAO from the DaoFactory for your model
        1. Call the `findById(long id)`
        1. Pass the model returned by your method to the view (`request.setAttribute(...)`)
* A jsp
    * You would save this file in `webapp/ads/show.jsp`    


## Update

* A servlet
    * `/model/update?id=6` for instance `/users/update?id=8`
    * doGet
        * Get the correct DAO from the DAOFactory
        * Call the method `findById`
            * If the model is not found, show an error message
            * If the model is found, pass it to the view `request.setAttribute(...)`
        * Show the form to update the information
    * doPost
        * Get the correct DAO from the DAOFactory
        * Call the method `findById`
            * If the model is not found, show an error message
            * Update the model
                1. Validate the input, for instance is the title empty?
                1. use the setters to update the model with the new values coming
                   from the request: `ad.setTitle(request.getParamater("title"))`
                1. Call the method `update` in your Dao
            * Redirect to the show single one model page, for instance `/ads/show?id=7`
    
* A jsp
    The name for the jsp is usually `webapp/model/update.jsp`, for instance `webapp/ads/update.jsp`

## Delete

* A servlet
    * doPost `/model/delete?id=7` for instance `/ads/delete?id=9`
    * The process is as follows
        1. Get the correct DAO from the factory
        1. Find the model by its ID calling the method `findById`
        1. If the model is not found, notify the user
        1. Otherwise call the method `delete` in your DAO
        1. Redirect to the view all page, for instance `/ads`
