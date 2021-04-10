package edu.coen390.androidapp.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.examapp.R;
import com.google.gson.Gson;

import edu.coen390.androidapp.Model.Course;
import edu.coen390.androidapp.Model.Invigilator;
import edu.coen390.androidapp.Model.Professor;
import edu.coen390.androidapp.Model.User;
import edu.coen390.androidapp.Model.UserType;

public class SharedPreferenceHelper {
    /**
     * The SharedPreferences object for data storage.
     */
    private SharedPreferences sharedPreferences;

    /**
     * The context from Activities for accessing SharedPreferences files.
     */
    private Context context;

    /**
     * Constructor used to create a SharePreferenceHelper object
     *
     * @param context The context from the executing Activity.
     */
    public SharedPreferenceHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.courses_file), Context.MODE_PRIVATE);
    }

    /**
     * Saves the Course passed as a parameter to SharePreferences file.
     *
     * @param course The Course object to be saved.
     */
    public void saveProfile(Course course) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(course);
        editor.putString(course.getCode(), json);
        editor.commit();
    }

    /**
     * Gets the Course from the SharedPreferences file.
     *
     * @return The Course object.
     */
    public Course getProfile(Course course) {
        String json = sharedPreferences.getString(course.getCode(), "");
        if (!json.equals("")) {
            Gson gson = new Gson();
            return gson.fromJson(json, Course.class);
        } else {
            return null;
        }
    }


    public void saveUser(User user, UserType userType) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        User currentUser = null;
        if(userType == UserType.INVIGILATOR){
            currentUser = (Invigilator) user;
            editor.putString("UserType", "Invigilator");
        }else if(userType == UserType.PROFESSOR){
            currentUser = (Professor) user;
            editor.putString("UserType", "Professor");
        }
        String json = gson.toJson(currentUser);

        editor.putString("User", json);
        editor.apply();
    }


    public void saveInvigilator(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("Invigilator", json);
        editor.apply();
    }

    //doesn't work when just returning a user
    public User getUser() {
       String json = sharedPreferences.getString("User", "");
       String userType = sharedPreferences.getString("UserType","" );

          if(  !json.equals("") && !userType.equals("") ) {
              Gson gson = new Gson();
              if (userType.equals("Invigilator")) {
                  return gson.fromJson(json, Invigilator.class);
              } else if (userType.equals("Professor")) {
                  return gson.fromJson(json, Professor.class);
              }
              return null;
          }
      else {
      return null;
        }
}


    public Invigilator getInvigilator () {
        String json = sharedPreferences.getString("Invigilator", "");
        if(!json.equals("")){
            Gson gson = new Gson();
            return gson.fromJson(json, Invigilator.class);
            } else {
                return null;
            }
        }

    public Professor getProfessor () {
        String json = sharedPreferences.getString("Professor", "");
        if(!json.equals("")){
            Gson gson = new Gson();
            return gson.fromJson(json, Professor.class);
        } else {
            return null;
        }
    }


}