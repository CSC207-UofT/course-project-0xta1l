**PROGRESS REPORT**

**Open Questions**

1) How can we effectively link a server database to the Android App?

2) How can we transition from using a local database to a server based database?

3) Are there popular or generic recommendation algorithms that we can refer to when improving our recommendations feature?

**What has worked**

1) We worked well as a team. Our teamwork and communication are very strong, allowing for productive meetings and collaboration. When we were not meeting in person, we all made sure to regularly communicate via Discord or GitHub. We made use of many Github features like branches to be able to work together simulatenously, coordinated and checked our code using pull requests and highlighted some issues we want to solve using the "Issues" feature. This is one of the many examples of our excellent teamwork.

2) We have good organization for our code, making it clear which classes belong to which layer of Clean Architecture.

3) Our understanding of how to implement the different features of our project has worked well. This allowed for faster and more efficient development, as we coded with a planned algorithm and structure in mind, rather than just coding for the sake of a desired result.

**Summary of roles**

Justin:
Worked on creating the Android Application, and implemented basic functions for the Android App. Created Entities and helped to debug/test other components of the code. Helped to create the structure for Commands using the Command Design Pattern. Plans to continue to work on the Android Application to improve the UI and user experience.

Amir:
Worked on the Review entity and its related packages such as Controllers and UseCases. This entailed creating the review entity, building constructors and methods to provide needed functionality in our project. Wrote documentation for all new classes. Also aided in creating a working SQLite database before the database switch was cemented.

Makayla:
Implemented the recommendation feature, specifically its use case and tests, to recommend a specified number of recipes depending on the user’s interest and previous behavior. Created the preview entity, to fix the overuse of recipe.getPreview() and .get(index), performing the necessary refactoring throughout the code. Makayla plans to continue improving the recommendations algorithm for phase 2 as well as assisting in the strengthening of the  connection between the android application and java code.

Kai:
Worked briefly on Review use cases, implemented a UserInfo entity with the intention of it being used in UserRequestCreateLogin which has been hardcoded, however we cannot instantiate a new entity in a controller as that is a violation of clean architecture so this did not work as planned. UserInfo was later used in the displaying of user info. Hopes to be able to help with the front end (design) of the android app.

Mieko:
Implemented the CommandTree text UI and helped debug and fix various Controllers, Use Cases, and Entities. Implemented TextUI data persistence through writing to and reading from JSON files. Also helped develop the CRC models for the extension to the project from phase 0, namely the filtering, sorting, recipe creation, and reviews. Mieko plans to be able to fix the architecture of the program to better adhere to Clean Architecture and SOLID principles. She also hopes to continue to work on the functionality of the UI to make it more intuitive.

Can:
Implemented CreateRecipe controller  that helps users to create recipes from the input. Implemented GetReview controller that has two methods which helps  to get the review based on the input. Worked on  temp_data.csv file.  Hoping to work more on the construction of the Android App.

Jolina:
Worked on refactoring the GenreViewSort class into two distinct classes for code clarity. Implemented the recipe filtering and sorting features. Applied the template design pattern into the SortRecipes class. Worked on the recommendation system and user text interface planning. Plans to help further develop the recommendation system and work on the graphic user interface.

Arpi:
Worked on incorporating a database (using SQLite) into our app. Created classes to perform basic CRUD operations . Plans to look into other database management systems (Realm, Firebase, MongoDB) that are non-relational.
