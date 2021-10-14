Class name: UserRequestUploadRecipeController

Responsibilities:
- Takes in recipe data and calls RecipeCreateUseCase
- Calls RecipeSaveUseCase to add uploaded recipe to User's saved recipes 
- Throws exception if missing any recipe data

Collaborators:
- RecipeCreateUseCase
- RecipeSaveUseCase
- UserInputStatusDisplay