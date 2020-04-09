$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Login",
  "description": "  As user, I want to be able to log in under different roles with username and password.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login as driver",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Check"
    }
  ]
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinitions.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
});