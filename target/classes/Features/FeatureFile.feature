Feature: Get movies release mont and year

Scenario: Print the month and year for sorted movies

Given Login with the newly created "anand.manyam07@gmail.com" and "Anand@123" credentials

When Go to the Menu 

Then click on Top Rated Movies

Then sort movies by Release Date

And Click on last movie and get the month and date


