package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;


public class US05_StepDefs {

    String query="select bc.name,count(*)\n" +
            "    from book_categories as bc\n" +
            "        join books b\n" +
            "            on bc.id = b.book_category_id\n" +
            "        join book_borrow bb\n" +
            "            on b.id = bb.book_id\n" +
            "group by name\n" +
            "order by 2 desc ;";

    String  mostPopularBookGenre;


    @Given("Establish the database connection")
    public void establish_the_database_connection() {
       DB_Util.createConnection();

    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {

        DB_Util.runQuery(query);
        List<String> rowDataAsList = DB_Util.getRowDataAsList(1);
        mostPopularBookGenre = rowDataAsList.get(0);
    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String bookName) {

        Assert.assertEquals(mostPopularBookGenre,bookName);
        System.out.println("AssertEquals? " + (mostPopularBookGenre.equals(bookName) ? "Pass" : "Failed"));


    }

}
