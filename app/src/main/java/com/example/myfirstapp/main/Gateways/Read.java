package com.example.myfirstapp.main.Gateways;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * This class is responsible for querying data from the database.
 */
public class Read {

    // Declare database references
    private static final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private static final DatabaseReference mRecipeRef = mRootRef.child("recipes");
    private static final DatabaseReference mUserRef = mRootRef.child("users");

    /**
     * userDataStatus and recipeDataStatus are interfaces used to transfer objects from inside the
     * onDataChange method to outside. It essentially turns an asynchronous call into a
     * synchronous one.
     */
    public interface userDataStatus {
        void userSecurityLoaded(UserSecurity userSecurity);
    }

    public interface recipeDataStatus {
        void genreLibraryLoaded(GenreLibrary genreLibrary);
    }

    /**
     * Reads User data from the database.
     *
     * @param dataStatus is the interface mentioned earlier.
     */
    public static void populateUserSecurity(final userDataStatus dataStatus) {
        // Add a listener event object to the user database reference
        mUserRef.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Populate the UserSecurity object
                UserSecurity newUserSecurity = Read.fillUserSecurity(dataSnapshot);
                dataStatus.userSecurityLoaded(newUserSecurity);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("ArpiTestApp", "Error.");
            }
        });
    }

    /**
     * Creates a UserSecurity object that contains all users.
     *
     * @param dataSnapshot is a static reference to mUserRef, which refers to the user
     *                     branch of the database
     * @return a UserSecurity object
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static UserSecurity fillUserSecurity(DataSnapshot dataSnapshot) {
        // Create empty UserSecurity object
        UserSecurity usersUserSecurity = new UserSecurity();

        // Loop through all the users in the database
        for (DataSnapshot singleUserRef : dataSnapshot.getChildren()) {

            // Add a user from the database to the UserSecurity object
            User user = ReadUser.readUser(singleUserRef);
            usersUserSecurity.addUser(user);
        }

        return usersUserSecurity;
    }

    /**
     * Reads Recipe data from the database.
     *
     * @param dataStatus
     */
    public static void populateGenreLibrary(final recipeDataStatus dataStatus) {
        // Add a listener event object to the recipe database reference
        mRecipeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Populate the GenreLibrary object
                GenreLibrary newGenreLibrary = Read.fillGenreLibrary(dataSnapshot);
                dataStatus.genreLibraryLoaded(newGenreLibrary);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("ArpiTestApp", "Error.");
            }
        });
    }

    /**
     * Creates a GenreLibrary object that contains all recipes in the database.
     *
     * @param dataSnapshot is a static reference to mRecipeRef, which refers to the
     *                     recipe branch of the database
     * @return a GenreLibrary object
     */
    private static GenreLibrary fillGenreLibrary(DataSnapshot dataSnapshot) {
        // Create empty GenreLibrary object
        GenreLibrary genreLibrary = new GenreLibrary();
        // Loop through all the recipes in the database
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Recipe recipe = ReadRecipe.readRecipe(ds);

            // Add each recipe to recipeGenreLibrary
            for (String genre : recipe.getGenre()) {
                genreLibrary.addRecipes(genre, recipe);
            }

        }
        return genreLibrary;
    }
}
