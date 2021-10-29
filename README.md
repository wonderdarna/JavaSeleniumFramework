# angelo.manangan
# email : gilomanangan20@gmail.com

1. <b>What other possible scenarios would you suggest for testing the Jupiter Toys application?</b> <br>
  •	Check if the navigation bar is displaying on all pages<br>
  •	Check if the footer is displaying on all pages<br>
  •	Check if the user is navigated to Shop Page after clicking Start Shopping button on Homepage<br>
  •	Check if there’s a number next to the Cart Nav Menu which is based on the number of items that you added to your cart.<br>
  •	Check if the images display according to the label of the toys on the Shop Page<br>
  •	Check if the number next to the Cart Nav Menu increases when the user clicks the buy button of any Toys<br>
  •	Check if the Login modal is displayed after clicking the Login Nav Menu<br>
  •	Check if the user is unable to login if there are unpopulated fields<br>
  •	Check if the user is unable to login if he/she enters incorrect login details<br>
  •	 Check if the user can login if all the details entered are correct.<br>
  •	Check if error message is displayed if it enters incorrect login or there are unpopulated fields<br>
  •	Check if the header message in Contact page changes when all the fields are populated or not<br>
  •	Check if the there’s a message on Cart Page when the user’s cart is empty<br>
  •	Check if there’s a link for checkout and for continue shopping on Cart page if the user has an item added to his/her cart.<br>
  •	Check if the message on Cart page contains the total number of items that the user added to his/her cart.<br>
  •	Check if the subtotal and the total are being changed when the user changes the quantity of each products, he/she added to his/her cart<br>
  •	Check if the decimal value of Subtotal and Total displays up to Hundredths place on Cart Page <br>
  •	Check if the Delete button is displaying for each items that the user added<br>
  •	 Check if the item is being removed when the user clicks the red button under the Actions column on Cart Page<br>
  •	 Check if all the items are being removed when the user clicks the Empty Cart button<br>
  •	 Check if the error messages are displaying when the user doesn’t populate all the required fields on Checkout page<br>
  •	 Check if the success message is displaying when the user populated all the required fields on Checkout page<br>

2. <b>Jupiter Toys is expected to grow and expand its offering into books, tech, and modern art. We are expecting the of tests will grow to a very large number.</b><br>
  
    •	What approaches could you used to reduce overall execution time? <br>
      1.	If the automation testing is still not present in the Project, I suggest investing on this approach.<br>
      2.	If automation testing is already applied in a project. I suggest to research on how to implement parallel execution into the automation tool that you’re using.<br>
      3.	Avoid creating automated script to all Test cases that only run once. This will help to reduce the number of test scripts you need to execute.<br>
      4.	When creating automated scripts, use wait smartly. Avoid using Thread.Sleep() to your script unless you needed it.<br>
      5.  Additional to item #3 use explicit wait instead of using implicit wait<br>
      6.	Apply CI/CD to your Automation Testing approach for you to be able to automate other processes. Use these sample devops tools Git, Jenkins, Docker etc...<br>
      7.	Use headless running on your automation tests. This is very helpful when you’re doing another task.<br>
      8.	Avoid running all your scripts across all browsers if its not needed<br>
      9.	Avoid generating screenshots to all the steps of your scripts as this will leads to increasing the size of your automation framework.<br>
      10.	Optimize all test cases that your need to automate first and identify if there are redundant steps for each test case.<br>
      11.	Use API Testing instead of GUI Testing if it’s not require as this will reduce lots of execution time.<br>
  
   •	How will your framework cater for this?<br>
      1.	First choose a right automation tool<br>
      2.	I used TestNG to my automation framework as it provides parallel execution.<br>
      3.	I used Maven project so that I can easily integrate my framework into CI/CD.<br>
      4.	I avoided adding Thead.Sleep() into my framework as it adds additional time on executing my scripts.<br>
      5.	As for wait, I applied explicit wait to the methods that are commonly used. So that I don't need to write another lines of codes everytime I need to use Explicit wait.<br>
      6.	As for running my all my tests in headless mode, I could just add another capability this "add_argument("--headless")" to my Chromedriver.<br>
      7.	I could just use TestNG's capabality to group my test scripts when I need to run some of them across different browsers.<br>
      8.	I added and used TakeShot method under my AfterMethod method. It will only takescreenshot if the script's exeuction result is failed. Also if my lead wants to take a screenshot to every important steps I can just call this method.<br>
      9.	If I need to automate my scripts for API Testing I can just add the dependecy for RestAssured into my Maven.<br>
      

3. <b>Describe when to use a BDD approach to automation and when NOT to use BDD</b><br>

      BDD approach is very helpful when it comes to documenting, reviewing and maintaining all your automated scripts as it is written in English language.
A team with non-technical members can benefit from this approach since it provides a common language between the business and developers.
If all the members have enough technical knowledge to understand how the automation tools work and operate, then there is no need for BDD.
