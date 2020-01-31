# Value Shark
A web application for value investors to quickly identify potential opportunities and track their portfolio.

Team members:
* Chase Tucker
* Ashlyn Morin
* Lucas Wilber
* Vik Akam
* Ran Vaknin

## Software Requirements
### Vision
We want our users - most likely value investors - to quickly identify potential investment opportunities and keep track of a portfolio of companies. This application aims to avoid the traditionally long-winded path of finding optimal investments, and to instead allow our value investor to see the information they want in one place, on a very navigable website. Users should care about our product for this reason - it decreases the time spent on searching for an investment, and increases your actual investments made on a given day while displaying the information you need to make that investment. 

### Scope
IN - Users will be able to sign up for an account with the app. Upon signing in, the user can start a portfolio by searching for companies. Upon company search, the user can view company details. The user will then able to add the company to their portfolio. The user can delete the company from their portfolio as well. On the logged in page, user will see a Prospects table, which lists detailed information on a list of companies that the IEX Cloud API sorts based on the company value. Users can additionally update the average price and number of shares per company. For the user's profile, user can sign up, retrieve their profile information, update information, and delete their account. 

OUT - This app will not allow for stock purchasing. It will not do analysis of other types of investment strategies - it is strictly for value investing. 

#### MVP
- Login, signup, maintain user profile information
- Use IEX Cloud API
- See stock info
- Save stocks
- See potential investments
- Search individual companies
- Modify portfolio (# shares, average cost)

#### Stretch goals
- Intrinsic value calculation
- Deleting an account
- Search filters (apply your own custom parameters for the prospects table)
- Real-time updates on stock prices
- Admin can create/delete user accounts

### Functional requirements
1. Splash page for user to learn about application and signup/login
2. Signup, login, other authentication needs
3. Upon login, render home page of Prospects table, search ticker bar, current portfolio
4. View detailed information about a stock
5. Add stocks to portfolio
6. Update user's relation to stock (average cost, number of shares)
7. Delete stocks from portfolio

#### Data flow
Every HTML page will contain either buttons of navigation to other pages using GET requests, or buttons of submission of information to the database using CREATE/POST/UPDATE/DELETE. For creating user info, user will CREATE their user profile information to the database. On the home page, GET requests will be made to the IEX Cloud API to obtain stock information for the prospects table. GET requests will be made to the database to retrieve user's current portfolio information. GET request will be made to a searched stock. Add to portfolio button on the details page will do CREATE request to store the stock relation to the user's portfolio. More details to come later once user stories and feature tasks are flushed out. 

### Non-functional requirements
1. Authentication
- We will be implementing Spring Security through this Spring app. 
2. Usability (HTML/CSS)
- CSS will allow our users to navigate the user in a manageable, interactive, responsive and overall enjoyable way. 
3. Testability (testing routes, databases)
- We will be creating integration tests for the routes in our Spring app. 

## Wireframe photos
logged in logged out views:
![](https://github.com/valueShark/valueShark/blob/dev/Assets/Screen%20Shot%202020-01-31%20at%2013.19.38.png?raw=true)

log in log out pages:
![](https://github.com/valueShark/valueShark/blob/dev/Assets/Screen%20Shot%202020-01-31%20at%2013.19.55.png?raw=true)

individual stock page:
![](https://github.com/valueShark/valueShark/blob/dev/Assets/Screen%20Shot%202020-01-31%20at%2013.20.06.png?raw=true)

