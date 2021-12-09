### Specification ###
Our project domain is a recipe organizer program that allows users to discover new recipes, build their own collection of recipes, and interact with the recipes.

Each recipe is composed of a recipe title, a brief description, ingredients, instructions, and an estimated preptime. Recipes are sorted into various ‘genres’ (categories). Some example genres: Jamaican food, Mexican food, Vegetarian, Dessert, Breakfast, Summer, Fruit). A recipe must belong to at least one genre, and can (and often will!) belong to more than a single genre. Additionally, there is a genre called “all” that contains every single recipe stored in the program.

Users can create personal accounts that consist of a unique login (unique username and password) and display information (display picture and display name). After making an account, users can interact with recipes in various ways. They can create a personal collection of recipes by saving them (similar to how you can save songs on Spotify or save posts on Instagram/Facebook). Users can also review recipes by rating the recipe out of 5 stars and leaving an optional comment. Finally, users can upload their own recipes for other users to view and interact with.

For extended functionality from phase 1, we have implemented a recommendation system where upon login users will be notified of new recipes to try out. These recommended recipes are automatic and based on user-to-recipe interactions. For example, if a user has been saving a lot of Japanese recipes into their recipe collection, they are more likely to receive Japanese recipes in their recommendations! We have also implemented a feature that allows users to filter recipes by inputting a genre keyword as well as sort recipes alphabetically, by interest, or by rating (highest to lowest).


### Major Design Decisions ###

**Command Tree:**

During phase 1, the group made a number of major design decisions; one of which was the decision on the technique of implementing commands for the text user interface. We decided that applying the Command Design Pattern was right as it was simple and intuitive. To do this, we implemented a CommandTree which acted as a tree where each node stores a Command. Unfortunately, we ran into an issue where some of the commands required additional input which caused the program to work incorrectly. To solve this, we created subclasses of Command called RecipeCommand which accepted more parameters to account for these issues. This decision was a difficult one to make as it increased the complexity of the inheritance and execution structure. The creation of subclasses allowed a more fluid user experience which increases the usability of our program.

During phase 2, the group removed the Command design pattern implementation. Initially, we were intending to use it for the user interfaces, with each executable command being stored in a CommandTree. Each possible command would be stored in a node, and each node would be connected to other nodes if the commands could be executed after each other, creating paths of commands. We ended up removing this from the final project because the Android App GUI was able to mimic the restrictive structure of the CommandTree (ie. users can only execute specific commands at certain times) by having different buttons on different pages of the app. Each page acted like a branch of the CommandTree, and thus the TextUI became obsolete and the Command pattern was not needed for our final project. Our implementation of the command design pattern for our text interface can still be checked out in the TextUI branch.

**Database:**

In phase 1, we attempted to use MySQL as the primary database management system for our app because it was recommended by various sites as the most popular DBMS for Android apps. However, because of our inexperience, MySQL had a few key shortcomings that we were unable to foresee. The first issue was that MySQL only stored data locally. This is fine for most Android apps that only need local storage, but our app aimed to connect users around the world through shared recipes and reviews. We needed a way to store data in a way that was accessible to all client devices. The second issue was that MySQL is a relational DBMS. Most of our entity objects are stored more intuitively as JSON objects, as many of their attributes do not fit nicely in tables and rows. While this was not impossible to overcome, it forced us to design relatively complex database schemas to store our data. Ultimately, our plan to use MySQL fell through and we instead resorted to local JSON and CSV files to store data.

In phase 2, we decided to use Google Firebase Realtime Database as our DBMS of choice. There were a number of reasons.

- Cloud Storage: all of our data is stored on the cloud. This was important to us because it allowed our app to do what it was made to do: connect users through food.

- Non-Relational: Realtime Database is a non-relational database that stores data in the form of a JSON tree. This was really useful because it meant our Recipe, User, and Review objects could be directly converted to JSON and stored. Even though there was still some additional code needed to read from the database, this convenience saved us from having to write a lot more boilerplate code. Additionally, the JSON tree allowed us to nest objects (i.e a Recipe object could store a list of Review objects) which more closely aligns with the structure of our entity objects, saving us from having to design a more complicated schema.

- Little backend code required: compared to the large amount of work normally required for developing the database side of an app, it was relatively easy to create a Firebase project and connect our app to the project database.This meant no server set-up code was required — just a few additions to the gradle files of our program.

- Highly compatible with Android: Firebase projects support Android and makes it simple to connect apps to a project. Additionally, Android studio has a Firebase assistant built into its tools, which made it even easier to connect our app to the project database. There is a lot of Android specific documentation on the Firebase website for both Java and Kotlin, which ended up being very useful.


**Presenters:**

A design decision during phase 1 of the project was to remove the Presenter classes. The Presenter classes were originally used to print data to the Command Line (for the Text UI). However, they were ultimately replaced by Android App fragments and activities, each presenting text and data to the user with TextViews and buttons.

**Controllers and Use Cases:**

We also decided to return the entity type of whatever controllers’ and use cases’ methods which created something. For example, if we had a use case RecipeCreate; it would return a Recipe as it is creating one. This was done in order to show the user that the entity was successfully created.

**Recommendation Feature:**

Another design choice from phase 1 was in the architecture of the recommendation feature. Our aim was to create a function that returns a list of recommended recipes based on the user’s previous activity and preferences. Until we made the decision to use recursion, this method’s implementation was complex, error-filled, and full of code smells. In using recursion, our method’s overall length decreased and it became easier to debug and fix bugs. While still keeping the essential components, shortening the code improved readability, reduced smelliness, and meant that our code adhered more strongly to SOLID principles. As a result, it will be significantly easier to modify and expand this code going forward, reducing the amount of maintenance required and tedious refactoring required. This design choice has produced a great yield and should help our future code tremendously.

**Preview Entity:**

The initial design of the Recipe entity included two methods, Recipe.getPreview() and Recipe.getFull(), that provided either a subset of a recipe’s attributes or all of them. While both of these methods were important, we found that Recipe.getPreview() was used much more frequently than expected due to our design decision to display recipe previews to the user when they are browsing. This decision meant that most processing and displaying of recipes would not be done with the full recipe entity but using the .getPreview() method. Due to our app’s central purpose being the manipulation of the recipe entity, this call is done in almost every class that alters the recipe or uses it’s information. While this did not create issues in the compilation of our code, it did create issues in readability. The method returns a subset of the recipe’s attributes in an ArrayList, making a call to the appropriate get function for each attribute. This creates many lines of Recipe.get(index) throughout our code, all of which bear no meaning to someone reading the code unless they have the return list memorized. Communication is crucial when working in a large group and so by creating a linked preview entity and subsequent getter methods, the .get(index) methods can be replaced with more meaningful calls that serve the same purpose.


### Clean Architecture ###

Our project adheres to Clean Architecture by clearly sectioning off each layer of classes into Entities, Use Cases, Controllers, Presenters, and UI (Commands). Entities only interact with other Entities; Use Cases interact with other Use Cases and Entities; Controllers interact with Use Cases and Gateways; and the UI interacts with Gateways and Controllers.
A scenario walkthrough for our program would be a user wanting to create an account, viewing the recipes in the Chinese genre, and viewing one of the recipes and its reviews before saving it. The user then would log on again later after trying out the recipe, find the recipe in their saved recipes, and add their own review.

The Dependency Rule is consistently followed when interacting with details in the outer layer, as Use Cases and Entities function without the use of Controllers or classes in outer layers. This is best seen in the  Android App UI. As per Clean Architecture, the main structure of our code consisting of Entities, Use Cases, Controllers, and Presenters functions independently of the UI. This allows for our UI to be changed without needing to make changes to the rest of the program.

A violation that currently exists, that we were unable to successfully remove, is that some of our Entities get used and imported by some Controllers and GUI for data retrieval, meaning that these classes are not restricted to only being used by the adjacent Use Case layer. This occurs because we chose to have Use Cases create and return data in Entities instead of returning ArrayLists of data to make it clear what the data being returned consists of. We are unsure of how to fix this violation while maintaining the clarity of the data.


### SOLID Design Principles ###

Throughout phase 2, we have made decisions about our code with the SOLID principles in mind. For some principles, their application and our ability to adhere was more apparent than others. Hence, these principles were emphasized in code, specifically the Single-responsibility, Open-Closed, and Dependency Inversion principles. For the Single-responsibility principle, we ensured that each class only has one responsibility and therefore one reason to change. This can be seen in the RecipeSave use case which is only responsible for saving a recipe and so it’s only reason to change is if we wanted to change the way a recipe is saved. For the Open-Closed principle, classes such as RecipeCreate which contain methods for the ways a recipe can be created are closed for modification but open for extension in the addition of new methods to add recipes.

Throughout our code the Dependency Inversion principle is fulfilled as every level of our code (Entities, Use Cases, Controllers, etc.) only interacts with classes within its level or directly below it. For example, the UserRequestSaveRecipe controller only interacts with the RecipeSave use case. In all honesty, this is the principle we have struggled to adhere to the most. We often found ourselves instantiating entities in our controllers before realizing the improper structure and correcting it. There are still instances of this in our code, for example the User Entity is imported in the UserRequestBrowse Controller, but given more time we might have been able to resolve this break of principle.

We were also mindful of the Liskov Substitution principle, ensuring that any subclasses we created could be substituted by their base class and still operate without bugs. Due to our design choices, our code has very little subclassing, so this principle, while not applicable everywhere, was only considered when we created the SortRecipe abstract class. Our code adheres to the principle as the subclasses, SortByInterests and SortByRating, can be substituted for one another when using the overridden .sort() method they both implement. As previously mentioned, we use little subclassing and so our code does not contain any complex interfaces that need to be separated to adhere to the Interface Segregation principle.

### Packaging Strategies ###

Due to the size of our project and the magnitude of the tasks we wanted to accomplish we focused more on organization than encapsulation. Our main program at present is divided into various packages: Gateways, Controllers, UseCases, and Entities. In structure this is most similar to Packaging by Layer. Packaging by layer emphasizes our observation of Clean Architecture. This is because classes from other packages must be imported in from other layers, so violations of Clean Architecture can be easily identified by the packages, and therefore the layers, of classes being imported.

For our Android Application, our GUI code has many packages, fragments, accountActivity, genreActivity, myRecipeActivity, homeActivity and loginActivity. We adopted a packaging strategy based on feature, by grouping code together based on common functionality. This packaging strategy allows for easy code navigation since all items needed for a task are in the same package and results in packages with high modularity and minimal coupling between packages.


### Design Patterns Implemented ###

Our group has mainly implemented the template design pattern for phase 2.

**Template Design Pattern**

The template design pattern organizes an abstract base class, which is the skeleton of an algorithm, and client subclasses that derive from the base class. The skeleton is the main structure of the algorithm and enforces the required steps as well as their ordering for the algorithm. The subclasses can extend or replace some of these steps in the skeleton for customization. The template method design pattern is useful when two or more components have similar qualities and a system can be put in place to reuse implementations. This way, we can avoid duplicate code and improve the efficiency of the program.

In our program, we created a parent class called SortRecipes and subclasses called SortByInterest and SortByRating that can sort recipes by interest and rating, respectively. There is a sorting method in the parent class that sorts recipes alphabetically and enforces the main structure of the algorithm. This method is then overloaded in SortByInterest and overridden in SortByRating. 

This design pattern was beneficial to our code because part of the functionality of our app is being able to sort and view recipes by a variety of metrics. Having one parent SortRecipes class allows for other classes, particularly the Controllers and GUI classes, to implement the sorting feature without relying on the actual mechanism of sorting.


### Data Persistence ###

We have robustly implemented data persistence of our Android App GUI via a non-relational realtime database using Firebase. We are able to read and fetch data from our database. We are also able to write data to our database, so any user activity in our application will be recorded in our database. For example, if the user were to save a recipe, the recipe will be saved in the users saved recipe list, which will be recorded to our database. If the user were to close the app, reopen it, and log in again, they would still be able to access the saved recipe.

Read more about Firebase in the Major Design Decisions section.


### Summary of Testing ###

For the testing of our program, we have chosen to test the main features of our program, mainly the Use Cases and Entities. We tested them to ensure that the main functionalities of our program are running as intended.
 
These functionalities for Use Cases include the filtering/sorting of our recipes by genre, interest and rating, saving recipes and creating reviews and users. We also tested the basic features of the our 2 main entities, User and GenreLibrary to ensure that our base code is accurately coded. 

The database we chose to use, Firebase, is a cloud-hosted database, so we could not effectively use JUnit for testing. Thus, all database testing was done by running code and checking to see if the real-time database matched the expected outcome.

App GUI testing was also unable to be conducted via JUnit, so we instead brainstormed possible user interaction pathways and then executed them to ensure they functioned as expected.

By ensuring that our main functionalities are accurately coded via testing, this allows us to robustly implement other parts of the code, mainly the controllers and the Android App GUI without constantly changing the methods in Use Cases/Entities.


### Future Works ###

While the main features of our program have been implemented, there is always room for improvement! If we were to continue working on our application in the future, we intend to more rigorously implement the Universal Design Pattern by refining the visuals of our application (font/image size) to improve the user experience. In the future, we also plan to implement a feature to allow users to directly upload their recipe with their chosen image. 

We also plan to improve our current features to ensure a higher quality user experience. This would include validating new recipes before they are added to the database, to prevent spam recipes from flooding the app. We also hope to add a search feature, wherein users can enter keywords to find recipes, such as ingredients. This would help diversify the methods that users find recipes, as they are currently restricted to viewing their personal recommendations or browsing genres of recipes.

Furthermore, we intend to create interaction between users, where users can add each other as friends. Similar to Instagram's story feature, we will create a video/photo feed where users can share their videos/photos of the food they have made to their friends. Users can also directly share recipes with their friends! We also intend to create a global feed that displays random users' shared photos/videos, similar to the explore feature in Instagram. These photos/videos will mostly be about recipes that the user is interested in. These features will not only promote existing recipes, they will also introduce new different types of recipes to users and encourage them to cook, create and upload their own personal recipes/food. 

Lastly, we could have a feature where professional cooks can upload cooking tutorials and recipes in our app to teach the general audience how to cook various types of food from a professional standpoint. This could serve as a more practical way for users to learn how to cook rather than simply following a recipe.




