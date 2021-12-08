# PROGRESS REPORT
### Open Questions ###
1) Are there free Android App templates that we can use instead of building one from scratch?
2) Are there popular or generic recommendation algorithms that we can refer to when improving our recommendations feature?
3) How do you propose we improve our application?
4) Is there an efficient way to go through our recipe data (particularly the instructions) to make them more readable? 


### What has worked ### 
We worked well as a team. Our teamwork and communication are very strong, allowing for productive meetings and collaboration. When we were not meeting in person, we all made sure to regularly communicate via Discord or GitHub. We made use of many Github features like branches to be able to work together simultaneously, coordinated and checked our code using pull requests and highlighted some issues we want to solve using the "Issues" feature. This is one of the many examples of our excellent teamwork.
We have good organization for our code, making it clear which classes belong to which layer of Clean Architecture.
Our understanding of how to implement the different features of our project has worked well. This allowed for faster and more efficient development, as we coded with a planned algorithm and structure in mind, rather than just coding for the sake of a desired result.

### Summary of work done in phase 2 ###

#### Justin: 

For Phase 2, I mainly worked on implementing more features of our code into the GUI, such as recommendations, a spinner for user to sort by interests, rating or alphabetically, an upload feature wher users can upload their own recipes and also helped to improve the aesthetics of the Android GUI. I have also added a Notification feature where a notification will appear when a user does not enter a correct input (E.g user chooses a password with of too little length). 

https://github.com/CSC207-UofT/course-project-0xta1l/pull/110 This is my most significant pull request as I have successfully moved our application from a using a TextUI to an Android App GUI. There are also many other pull requests that slowly transform the Android App into what it is now. 

The Android App GUI can be split into 7 components,  
1) AccountActivity: Contains classes that allows the user to change their personal infomation such as password and biography;  
2) Fragments: contains an upload fragment where user can upload their recipes; 
3) GenreActivity: Contains classes that allows users to select a specific genre, sort the recipes by Alphabetical, Rating or Interest, then select a specific recipe and save it or view the recipe's reviews; 
4) HomeActivity: Contains classes that display recommended recipes and allows user to view the recipe and save it or view the recipe's reviews. 
5) LoginActivity: Contains classes that allows user to login using their password and username, and also allows users to sign up if they do not have an account 
6) MyRecipeActivity: Contains classes that allows users to view their saved recipes, delete it or write a review
7) Others: Contains classes that complement the other activities. For example, the Notification class creates a message to notify the user that an exception has occurred. 
This pull request is significant as it transformed our backend code into something that can be visually represented, making it very much applicable in real life. It is much more exciting to be able to visually see the methods you implement work properly rather than just a boring textUI!

#### Amir:

For phase 2, I worked on the database and documentation of the product. For documentation, I added comments in the code improving the readability of our code. Specifically, this documentation described purposes of methods and explained variable names and what they were storing. With respect to the database, I worked on creating and writing to the realtime database that the team decided on. Below are links to important pull requests that I made and their explanations.

https://github.com/CSC207-UofT/course-project-0xta1l/pull/156

This pull request added the Create class for the database. This class allows us to write recipes and user objects to the database which is particularly useful for the creation of new recipes and user objects. I believe this is substantial as the feature allows users to update the database whenever users create new accounts or upload their own recipes. This broadens the scope of the project by adding data persistence in the form of a database (Firebase).

https://github.com/CSC207-UofT/course-project-0xta1l/actions/runs/1435900757 

Added Review Use Case and Entity class. These changes provided the basis of important functionalities our program would later implement. Some of these features allow users to create a review for a specified recipe, allows recipes to store a list of user written reviews about that specific recipe and allows users to store a list of all reviews written by a specific user. The use cases allows for retrieval of reviews by recipe and user

#### Makayla:

https://github.com/CSC207-UofT/course-project-0xta1l/pull/115 
My most significant pull request fully implemented the recommendations algorithm and made the appropriate adjustments throughout the code to allow for it.  This algorithm is the basis for what appears on the homepage of the app, it creates unique recipe recommendations based on the user’s interests and/or app interactions. 

Since phase 1, Makayla has worked to create and finalize the recommendations algorithm and worked with others to design and shape the aesthetics of the app. The recommendations feature required extensive testing to ensure it worked in all scenarios (no user interests, small number of recipes in genre, large number of wanted recommendations). The process of designing the app included choosing a colour palette (light and dark), an appropriate font size, visual/textual placements, and other similar design choices. All choices were made to keep in mind accessibility features and implementation .

#### Kai:

#### Mieko:

For phase 2, I worked on implementing the database and refactoring the code to adhere to Clean Architecture. I also improved the functionality of the genre weighting and recipe review functionalities of the program.

For refactoring, I predominantly changed parameter types to eliminate any Use Case dependencies on Gateway classes by moving the data access functionality to the Controller, which then passes in the data when it calls the Use Case. I also fixed portions of the app that made direct calls to Use Cases, which required coding new Controllers and editing the methods of pre-existing Controllers. I also cleaned up the imports for all files by removing unused imports.

For the database implementation, we initially coded and tested in a separate project file to simplify the project file structure. I was responsible for implementing the Update class, that writes to the database when an existing user or recipe's properties are updated. I also was responsible for moving the database code over from the test application into the main project, and any associated installations. Lastly, I implemented an interface in the Read method (UserDataStatus and RecipeDataStatus) that allows for the rest of the Android app to be alerted once the data from the database is fully loaded by the default Firebase asynchronous methods triggered by EventListeners.


Two main pull requests containing the changes outlined above are:

Refactoring: https://github.com/CSC207-UofT/course-project-0xta1l/pull/168

Database: https://github.com/CSC207-UofT/course-project-0xta1l/pull/153

#### Can: 

For phase 2, I worked on documentation and commenting on Use Cases, Controllers, and Presenters. I added documentation to Use Cases, Controllers, and Presenters to improve the understandability of our code. In the documentation I described what the method does, parameters and their descriptions, and what the method returns. I also created UML diagrams to show how our code works. The first UML diagram shows the pattern for creating a user. The second diagram shows the pattern for viewing a recipe. The dependency of each layer is visible on the UML diagram and the methods that should be called are shown.

My first  significant pull request was adding documentation to our code. https://github.com/CSC207-UofT/course-project-0xta1l/pull/161. It is crucial for our project for the reasons that I mentioned above. My second significant pull request is creating a recipe controller. https://github.com/CSC207-UofT/course-project-0xta1l/pull/97 . Since it helps users to create recipe from the input.


#### Jolina:

For phase 2, I worked on the recommendations system in the Android user interface by adding code to the Home page and connecting the recommendations algorithm in the backend to the interface. I did some edits to the genre browse feature and fixed the test cases. I also worked on the accessibility report.

Two significant pull requests that I have made this term are for the sorting and filtering features I implemented. For sorting, I applied the template design pattern and wrote a parent class SortRecipes and two subclasses SortByRating and SortByInterest. These classes allow our program to sort the recipes alphabetically, by rating (from highest to lowest), and by interest (user’s interests come before other genres/recipes). For filtering, I wrote a class that takes in a genre keyword and filters through a list of recipes to yield a list of recipes that are in this genre category. This feature can be seen in the “My Recipes” page in the UI, where a user can select the genre they want to filter by and then filter their collection of saved recipes.

Sorting: https://github.com/CSC207-UofT/course-project-0xta1l/pull/76

Filtering: https://github.com/CSC207-UofT/course-project-0xta1l/pull/83

#### Arpi:



