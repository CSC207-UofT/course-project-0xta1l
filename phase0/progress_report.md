Specification


CRC Model


Scenario Walk-through

A user interested in cooking food is able to create an account in our Recipe Application. He can change his profile picture, username, password, age, biography and indicate a list of food genres he is interested in. The user is able to find and save various recipes that he likes and share the recipe with his friends.


Skeleton Program
A user creates an account: This will call UserRequestCreateLoginUser method which will call UseCreate to create a User and add it into our global library USERSECURITY.

A user browses genres: This will call UserRequestBrowse browseGenres method which will call GenreViewSort to sort genres based on a User's interests and returns a list of sorted genres. The genres will come from our global dataset of genres, GENRELIBRARY.

A user selects genres: This will call UserRequestBrowse browseGenreRecipes method which will return a list of recipe previews. 

A user views recipes from our dataset of recipes: This will call UserRequestRecipeView which will call RecipeDisplay that shows the recipe to the user. The user can then choose the recipe.

A user saves recipes: This will call UserRequestSaveRecipe which will take the recipe the user has chosen and call RecipeSave to save the recipe into the user's list of saved recipes. 

A user views saved recipes: This will call UserRequestBrowse which will call browseSavedRecipes method that will return the list of saved recipe previews. 



Open questions our group is struggling with:

1. Currently, we have a recipe dataset and a user dataset that stores all the recipes and usersHow do we store data about recipes and users? How do we add new recipes and new users to the GenreLibrary and UserSecurity datasets?

HOW TO STORE DATA
Two “entities” are actually constants that keep track of every entity that has been created
How does clean architecture work with database on the outside, if having a base of users is integral to the program??

Does having Recipe as an entity (and also User) mean that we would have 500 classes? -> TUESDAY MEETING TOO
RecipeSave seems tiny??
Use exceptions to verify input data rather than ambiguous boolean
How do we store recipes? Database? Each recipe is a subclass?
Add getReviews for a recipe (displays all reviews made about this recipe)
Add getReviews for a user (displays all reviews a user has made, about different recipes)



What has worked well so far with our design:


Each group member's summary (what they worked on + what they plan on working next):



