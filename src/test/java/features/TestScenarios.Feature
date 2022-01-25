
Feature: BBC Page 

@BBCHomepage
Scenario:
Verify top navigation bar links of BBC Website
Given Initialise Driver
And Navigate to WebSite
And Verify top navigation links
And Close the browser

@DateandDay
Scenario:
Verify Correct date and date is displayed
Given Initialise Driver
And Navigate to WebSite
And Verify Day and Date is correctly displayed
And Close the browser

@NewsSection
Scenario:
Verify link of News Section
Given Initialise Driver
And Navigate to WebSite
And Navigate to News Section
And Verify News section URL
And Close the browser

@SearchResults
Scenario:
Verify Search Results on searching
Given Initialise Driver
And Navigate to WebSite
And Search in search bar
And Verify search results
And Close the browser