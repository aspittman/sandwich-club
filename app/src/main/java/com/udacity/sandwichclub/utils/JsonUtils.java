package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        List<Sandwich> addJson = new ArrayList<Sandwich>();

        try {
            //Creating a new JSONObject variable
            JSONObject sandwich = new JSONObject(json);

            //Creating variable for mainName and alsoKnownAs
            JSONObject sandwichParse = sandwich.getJSONObject("name");

            //Getting mainName String from Object
            String mainName = sandwichParse.getString("mainName");

            //Using list function to get array
            List<String> alsoKnownAs = jsonListArray(sandwichParse.
                    getJSONArray("alsoKnownAs"));

            //Gathering variable from name json
            String placeOfOrigin = sandwich.getString("placeOfOrigin");

            //Same as above
            String description = sandwich.getString("description");

            //Image variable
            String image = sandwich.getString("image");

            //Again using list function for variable
            List<String> ingredients = jsonListArray(sandwich.
                    getJSONArray("ingredients"));


            Sandwich setParse = new Sandwich();
            setParse.setMainName(mainName);
            setParse.setAlsoKnownAs(alsoKnownAs);
            setParse.setPlaceOfOrigin(placeOfOrigin);
            setParse.setDescription(description);
            setParse.setImage(image);
            setParse.setIngredients(ingredients);

            addJson.add(setParse);

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin,
                    description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<String> jsonListArray (JSONArray jsonArray) throws JSONException{

        List<String> jsonList = new ArrayList<>();

        if (jsonArray != null) {
            for(int i=0; i < jsonArray.length(); i++) {
                jsonList.add(jsonArray.getString(i));
            }
        }
        return jsonList;
    }

}
