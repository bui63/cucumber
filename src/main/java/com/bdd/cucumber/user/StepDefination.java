package com.bdd.cucumber.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StepDefination {

    RestTemplate restTemplate = new RestTemplate();

    @When("user sends POST HTTP request")
    public void user_sends_POST_HTTP_request() {

        String url =  "http://localhost" + ":" + 8081 + "/users";
        System.out.println(url);

    }

    @Then("user adds  dob {}, id {} and name{}")
    public void user_adds_dob_id_and_name(String dob, int id, String name) {

        String url =  "http://localhost" + ":" + 8081 + "/users";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("content", "application/json");

        User user = new User();
        user.setId(id);
        user.setDob(dob);
        user.setName(name);

        HttpEntity<User> entity = new HttpEntity<User>(user,headers);

        User result = restTemplate.postForObject(url, entity,User.class);
        assertNotNull(result);
    }

    @Given("user launches the application and send getById request")
    public void user_launches_the_application_and_send_getById_request() {
        String url = "http://localhost" + ":" + 8081 + "/swagger-ui.html";
        System.out.println(url);
    }

    @When("user gives id {int} to see a particular record")
    public void user_gives_id_to_see_a_particular_record(Long id) {
        String url = "http://localhost" + ":" + 8081 + "/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("content", "application/json");

        HttpEntity<Long> entity = new HttpEntity<Long>(id,headers);

        User result = restTemplate.getForObject(url, User.class, entity);
        assertNotNull(result);
    }

    @Then("user recevies the id {int}, name {}, dob {}")
    public void user_recevies_the_id_name_Rahul1_dob_25T03_993Z(Long id, String name, String dob) {
        String url = "http://localhost" + ":" + 8083 + "/employees/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("content", "application/json");

        HttpEntity<Long> entity = new HttpEntity<Long>(id,headers);

        User result = restTemplate.getForObject(url, User.class, entity);
        assertEquals(id, java.util.Optional.of(result.getId()));
        assertEquals(dob, result.getDob());
        assertEquals(name, result.getName());
    }

}
