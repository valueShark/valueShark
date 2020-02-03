# User Stories

# Stock Info

  ### User Story
    As a user, I want to be able to find information on stocks that I'm interested in, so that I can determine if I should invest in them.

  ### Feature Tasks
    -Users have access to a search function.
    -Search returns a listing of relevant results.
    -Search results link to an info page about each stock.

  ### Acceptance Tests
    -Ensure that a search for an existing stock returns that stock in search results.
    -A search for an non-existent stock should provide a useful error message.

  #### Estimate
    Large - this may take a couple days to implement.


# User Accounts

  ### User Story
    As a user, I would like to have a personal account on the site so that I can save a collection of stocks that I'm interested in for future reference.

  ### Feature Tasks
    -Users can create persistent accounts saved in the database.
    -User accounts contain a list of followed stocks.
    -Info pages for stocks have a 'follow' button which adds to the current signed-in user's follow list.

  ### Acceptance Tests
    -Ensure that a user can create a new account and still sign in after leaving the site.

  #### Estimate
    Medium - This may take about a day to implement.


# Security

  ### User Story
    As a user, I want to have control over whether or not my personal profile is viewable.

  ### Feature Tasks
    -User passwords should be hashed and salted.
    -User profiles should be not be accessible by users who aren't signed in.

  ### Acceptance Tests
    -Ensure that a user account can't be signed into with an incorrect password.
    -Ensure that a user password is not stored in plain-text anywhere.

  #### Estimate
    Small - This may take a few hours to implement.


# Clean Site

  ### User Story
    As a user, I want the site to be pleasing to look at and easy to navigate.
    As a developer, I want the site to have a professional, approachable appearance.

  ### Feature Tasks
    -Use CSS to make the site look clean and professional.
    -Use transitions and drop-downs where applicable.

  ### Acceptance Tests
    -Ensure that CSS rules are consistent accross different pages.
    -Ensure that the main features of the site are displayed prominently.

  #### Estimate
    Extra Large - This will be something that needs to be done daily as new features are added.


# Mobile Friendly

  ### User Story
    As a user, I want to be able to use the site from both my phone and my computer.

  ### Feature Tasks
    -Develop with a mobile-first approach.
    -Use responsive a design.
    -Use bootstrap, breakpoints, or something similar to make the site presentable on mobile and desktop.
  
  ### Acceptance Tests
    -Ensure that all site features are usable on both mobile and desktop.
    -Ensure that the site maintains a similar look and feel on mobile and desktop.

  #### Estimate
    Medium/Large - This will be something that needs to be done daily as new features are added.

  