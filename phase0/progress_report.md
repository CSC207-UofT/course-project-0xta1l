**Specification**

Our project domain is a recipe organizer program that allows users to discover new recipes, build their own collection
of recipes, and review recipes. Additionally, users may upload their own recipes if they wish, which other users can interact with.

**CRC Model**


The CRC cards are sorted into their respective layers of the Clean Architecture model. The responsibilities of each 
class are outlined in the "Responsibilities" section, and dependencies of each are outlined in the "Collaborators" 
section of each card. 

The Presenter CRC cards are ListDisplay and RecipeDisplay. Both presenters are responsible for formatting and printing 
data to the screen. ListDisplay prints lists of genres and lists of recipes. RecipeDisplay prints recipes. The presenters 
do not depend on any other classes, as they are called with the data to be printed included as an argument. 

The UI CRC cards are CreateLoginUI and ViewUI. Both UI classes are responsible for printing the available commands to 
the user, taking in user commands, and executing user commands by calling on the necessary controllers. CreateLoginUI 
currently only handles user account creation in the Skeleton Program, but will additionally handle users logging in the 
final program. ViewUI handles all other commands a user can execute, which are all to view lists of genres, lists of 
recipes, individual recipes, or user profiles.

The Controller CRC cards are UserRequestBrowse, UserRequestCreateLogin, UserRequestCreateReview, UserRequestRecipeView, 
UserRequestSaveRecipe and UserRequestUploadRecipe. 
Each controller takes in input from the UI, throws exceptions if the input is incorrect and then calls on the 
necessary Use Cases to execute their respective function. 
UserRequestBrowse handles any instance where the user requests to view a list of items, which can either be a list of genres, a list of recipes, or a list of reviews. 
UserRequestCreateLogin handles when a user either wants to login or create a new User, which occurs at the beginning of the program. 
UserRequestCreateReview handles when a user wants to create a Review for a recipe, UserRequestSaveRecipe handles when a 
user wants to save a recipe to their saved recipes, and UserRequestUploadRecipe handles when a user inputs recipe data 
that they wish to be added to the recipe database.

The Use Case CRC cards are GenreViewSort, GetRecipe, GetReview, RecipeCreate, RecipeReviewAdd, RecipeSave, UserCreate, UserLogin, and UserViewEdit. Each Use Case calls on the necessary Entities and Constants to either obtain data or update parameters.
GenreViewSort handles viewing a list of genres and sorting it. 
GetRecipe handles getting a recipe from the database. 
GetReview handles getting a review from either a user or a recipe. 
RecipeCreate handles creating a new Recipe entity and adding it to the database. 
RecipeReviewAdd adds a review to a recipe and to the user who made the review. 
UserCreate handles creating a new User entity and adding it to the database.
UserLogin handles checking if a user can log in by confirming that the username and password entered match. 
UserViewEdit handles both getting and editing a user's profile details. 

The Entity CRC cards are GenreLibrary, Recipe, Review, User, and UserSecurity.
GenreLibrary and UserSecurity are both entities defining the structure of how data obtained from the database of recipes and users, respectively, are stored for use while the program is running.
GenreLibrary and UserSecurity also both store instances of other entities (Recipe and User, respectively), once they have been created.
Recipe, Review, and User all stores information regarding one individual recipe, review, or user, respectively.


Currently, all aspects related to Recipe creation and Reviews have not been coded in our Skeleton model, but are outlined in the CRC model.

**Brief Scenario Walk-through**

A user interested in cooking food is able to create an account in our Recipe Application. He can change his profile
picture, username, password, age, biography and indicate a list of food genres he is interested in. The user is able to
find and save various recipes that he likes and share the recipe with his friends.

**Brief Description of the Skeleton Program:**


A user creates an account: This will call UserRequestCreateLoginUser method which will call UseCreate to create a 
User and add it into our global library USERSECURITY.

A user browses genres: This will call UserRequestBrowse browseGenres method which will call GenreViewSort to sort 
genres based on a User's interests and returns a list of sorted genres. The genres will come from our global dataset 
of genres, GENRELIBRARY.

A user selects genres: This will call UserRequestBrowse browseGenreRecipes method which will return a list of recipe 
previews. 

A user views recipes from our dataset of recipes: This will call UserRequestRecipeView which will call RecipeDisplay 
that shows the recipe to the user. The user can then choose the recipe.

A user saves recipes: This will call UserRequestSaveRecipe which will take the recipe the user has chosen and call 
RecipeSave to save the recipe into the user's list of saved recipes. 

A user views saved recipes: This will call UserRequestBrowse which will call browseSavedRecipes method that will 
return the list of saved recipe previews. 

**Open questions our group is struggling with:**

1. Currently, we have a recipe dataset and a user dataset, both of which are CSV files, that store all the recipes and 
users. How do we add new recipes and new users to these datasets?
2. How does clean architecture work with the database on the outside, if having a base of users and a base of recipes 
is integral to the program?
3. Is there criteria to how large a class is? Is it okay if a class has one method?
4. How do we effectively handle Exceptions? 
5. How do we design an effective UI, if we want to make an app with a GUI?

**What has worked well so far with our design:**

In our design, we have emphasized the SOLID principles, especially the Single-responsibility Principle, the 
Open-Closed Principle, and the Dependency Inversion Principle. For the 
Single-responsibility Principle, our entities, use cases, and controllers/presenters each have a single responsibility 
and do not overlap with other classes. For example, the use case UserCreate only handles user creation and its only 
reason to change is if we wanted to add another method for creating users. For the Open-Closed Principle, all of our 
classes are closed for modification, but they can each be extended. For example, the GenreViewSort class includes 
a method for sorting the recipes of a specific genre by the alphabet or by rating and this method is not open for 
modification; though, we can extend this class by adding new methods for sorting. For the Dependency Inversion 
Principle, every level of our code (ex. Entities, Use Cases, etc.) uses the same level or the level below it. For 
example, the use cases only interact with other use cases or entities. 

Another thing that has worked well so far with our design is the use of csv files for our datasets. Instead of creating 
an instance of an entity for every recipe and user (resulting in hundreds of entity instances), we created csv files to
represent our recipe and user datasets. In each csv file, every line expresses a single user or recipe. This way, it is
much easier to store, add, delete, change, and overall manage users and recipes.

One of our good design choices includes the structure of a hash map within a hashmap. For example, in the GenreLibrary
class, the attribute ListOfAllRecipes has type HashMap<String, HashMap<Integer, Recipe>>, where each genre key contains
a hashmap that contains the recipe and its ID. The reason for this inner hashmap is that this makes it easier to
reference the actual recipe entity by calling its ID in the hashmap, instead of using a list of recipe IDs where we
would then need to loop through a list of recipes to search for the matching recipe of the recipe ID. This way, we can
also improve runtime efficiency.

**Each group member's summary (what they worked on + what they plan on working next):**

Amir: Amir has worked on writing code for controllers and presenters as well as writing test cases for the User entity.
He plans on updating code for the controllers/presenters and pitching in for the user interface.

Arpi: Arpi has worked on writing the specification, the code for the GetRecipe use case, part of the code for the Recipe entity,
and converting the GenreLibrary dataset into csv format. They plan on expanding use cases to create more functions for the user.

Can: Can has worked on the RecipeSave use case and writing test cases. He plans on working on more use cases and
writing tests.

Jolina: Jolina has worked on writing the specification, the code for GenreViewSort and UserCreate, and writing test
cases for the userCreate method. She plans on working on more use cases and helping with the interface.

Justin: Justin has worked on writing code for the entities, the datasets, the scenario walkthrough, and writing test
cases for everyone. He plans on creating more scenario walkthroughs and learning about the Android Studio.

Kai: Kai has worked on controllers and editing use cases. He plans on working on user interface and writing more test
cases.

Makayla: Makayla has worked on the CRC model and the progress report. She plans on curating discussions around obstacles
and helping with presenters.

Mieko: Mieko has worked on the CRC model, the CRC model summary, and writing code for the presenters and UI. She plans on establishing a
larger database and working more on user interface. 


