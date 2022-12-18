# Prabhjot-Independent-Development-Assignment

For my independent development project, I will be creating the Unit Converter Project.

#  Week 4

## Reflection

This week’s plan is to complete the first stage of the Unit Converter Project from JetBrains, i.e. Standard Output. I need to give more time studying the Standard Output & other stages. I also, have to review whatever I have learnt about Kotlin from this course because it will be helping me in the later stages of this project. This week, exploring the Standard Output can be called a challenge, but it is fun to me. 

Challenge because to reach to the final stage of the project (i.e. Work on Project) I had to pass several sections of this stage which contained the theoretical part to read and questions including (MCQ + coding) 5+ problems in every practice part of sections to solve. So, this whole process to reach the final section of the stage which was the “Work on Project” was challenging for me. The fun part was the last section because it is an easy one compared to the MCQs I solved in the previous sections where I had to simply print the given statement.


**My experience this week-** 

The first stage of the project was easy and I barely took 30-35 minutes to complete this stage’s theoretical part. Some of the theory part I skipped which was very basic (in initial sections) and for some theory part, I had to pause & revise the previous notes (in final sections like literals & standard output). Though, solving the MCQ + coding problems in every practice part of sections took time which gave me great value for that time because, from those, I learnt a lot and also it gave me the opportunity to revise whatever I have learnt from this course till yet. 

     fun stage1() {
    println("145 centimeters is 1.45 meters\n" + 
        "2 miles is 3.2187 kilometers\n" +
        "5.5 inches is 139.7 millimeters\n" +
        "12 degrees Celsius is 53.6 degrees Fahrenheit\n" +
        "3 pounds is 1.360776 kilograms"
)
}

**My Progress this week-**

By the end of this week-4, I am done with stage 1 and also read the first two theory part of sections of stage 2. I [committed the code](https://github.com/nic-dgl-204-fall-2022/Prabhjot-Independent-Development-Assignment/blob/main/src/main/kotlin/stage1.kt) of stage 1 (Section- Work on project, Standard Output) in which I had to print the unit conversions lines for different physical quantities (like 145 centimetres is 1.45 meters). 

**Next week’s Plan-**

After getting a glance at the first stage and my week's plan I got an understanding that what should I have to practice more. I found loops, ranges, enum classes and lists to be challenging or the topics in which I will be invested for next weeks.
I wish to do more stages by the end of the 5th week but 2nd stage has too many sections still I try my best to complete stage 2 by the end of week 5, and also will try to reach the final section of stage 3.

## Potential ideas

Below are some potential ideas for the extension of Unit Converter Project. 

- Currency Converter- It looks similar to Unit converter project as we have to multiply and divide the numbers change the unit and the currency. But while doing the unit conversion, the number with which we mutiply or divide to the conversing number remains always constant (like 4 km*1000 = 4500, 1000 will be constant) but in currency conversion that number always changes. Therefore, this project will be challenging for me.  

- Calculator- A calculator looks simple project but I think to make it I will be implementing all the sills which I have learnt from this project like arithmetic operators for implementing calculation commands, if-else statements to tackle undefined values (like 445 divided by 0) etc. Moreover, I can add more things to it like adding sine and cosine calculating features, finding under-root and squre root values etc.

- Finance Calculator- A project which can calculate home loan, personal loan or any other loans by taking input from the users like loan amount, interset rate, pay back time etc and the program should output that what the user have to pay every month & what is the toatal interset. 

- Android App- An app which will contain currency converter, scintific calculator and the finance calculator with user interface and the app will be written with Kotlin language.

- Android App with Graph- This will be the upgrade of the above android app which will show a graph when ever user will get the output in finance calculator. 

# Week 5 

## Reflection

**My experience this week-**

The second stage of the Unit Converter project was challenging and it took a very long time to complete. I had almost given 12 to 15 hours this week to complete this stage of the project.  It took time because it contained almost 28 sections including the project code. Each section included the theory part and coding part in which some were challenging and some were very easy. Standard input, type conversion, arithmetic operations, relational operators, and getting substrings were challenging sections for me. Most of the time I got stuck in coding problems (which were metered as hard) then I had to again visit the theory part to solve that problem. To overcome these challenges, I have some plans for next week (check next week’s Plan). 

Although whatever challenges I fought to reach the final section (Work on Project- Let’s get metric) of stage 2, it was completely worth it because I didn’t take much time to complete the final section. I think all the problems I solved in the previous sections and all the theories I read in the previous sections helped me immensely in solving the final section of this stage. After completing this section, I wonder like how much I do not know and how many things are important for me to know.  

**My progress this week-**

This week I managed to complete stage 2 and started the 3rd stage (i.e., Distances). I [committed the code](https://github.com/nic-dgl-204-fall-2022/Prabhjot-Independent-Development-Assignment/blob/main/src/main/kotlin/stage2.kt) for stage 2 (Section- Work on project, Let’s get metric) in which I had to take a number input from the user. The number should be in kilometres and then I had to convert that number into meters by applying the required conversion formula for the kilometers digit. In the end, I had to print that converted meter number. For example, if a user inputs a number like 45 then the converted meter value is 4500 which will be shown to the user. To achieve this, I simply multiplied the user input number by 1000 using the arithmetic operator (i.e., *) and printed it with a string template. 


         fun main() {
               println("Enter a number of kilometers: ")
               val kilometers = readLine()!!.toInt()
               println("$kilometers kilometers is ${1000 * kilometers} meters")
               }

Other than that, I have learnt a lot from the different sections of this stage. This stage allowed me to dive deeper into different basic but important programming concepts like operators (arithmetic, relational logical etc.), string basics & templates, type conversions etc. I wondered each time how hard a problem can be made with these basic concepts and every time I solve the problems (in the practice part) I felt I got more clarity to the theory part.  

# Week 6

Last week I thought I will try to complete two stages this week but till now I had completed 2nd stage and am currently on the first two sections of 3rd stage. I think I was a bit slow this week because of stage 2 which was long & very time-consuming but will try to gain speed this week. I aim to finish two stages this week as these stages have fewer sections and I also hope to begin the final stage this week if the ‘work on project’ of the 3rd & 4th stages won’t take much time. 

To overcome some of the challenges I faced (explained in ‘My experience this week’), I will be solving the ‘Optional problems to solve’ which is in each practice part of each section. It will increase my confidence in solving difficult problems and will definitely help me in the future stages of this project. 

This week I completed stages 3/5: Distances and 4/5: Heavy duty. In 3/5: Distances module I had to convert different units of length like feet, inches, yards, centimeters and others to meters. The complete stage was easy to solve and final project code logic was also simple to crack but the only thing challenging to me was that user can input the units in any of their form like if it is Meter then user can input like “m”,”meter”, or “meters”. In 4/5: Heavy duty module the project code was moved to more advance form compared to previous stage. Now, with length I had to convert other physical units also like weight (which included grams, pounds, kilograms, milligrams, ounces etc). 
After completing these stages or reaching to the end of this course, I felt like it was fun doing these stages. Although, it feels challenging every time whenever you stuck but reaching to the end of the project with implementing whatever I had learnt till yet in a single project is one of the great experience for me. 

The last stage of this project or the final working of the project required me to add the temperature feature in it by which user will be able to convert the temperature units as well. The main objective was to convert the temperature units Kelvin, Celsius and Fahrenheit in each other or it depends on the user that from what unit – to what unit user want the conversion. 

After completing the stage 5 or the complete project I realized that how important and valuable the project based learning is. Before developing this project I am used to the conventional learning process in which you have to first go through all the documentation and learn or code all of the things in a subject. But in project based learning, the process is much simpler and fun because in it you whenever you learn things you simply learning it to implement in the project so you can see your progress in more accurate form. 
This project really helped me to understand where I stand in Kotlin development and how much more I’ve to put in to improve in this skill. This week’s process of completing stages each week to reach the final goal seemed like a journey which included all up and downs. 


# Reflection for Extension Project

I chose the extension project for my jetbrains assignement is Currency Converter project which was also one of the ideas I selected for the future development of the projects using Jetbrains Project. 

In this project I tried taking the Unit Converter project to the next level by adding the feature of currency conversion and I also tried hands on the android studio to develop an android app using the backend code. For currency conversion, first of all I required the currency exchange rates data to perform the conversion for the currencies. So, I took US dollar for the factorisation of other currencies because US dollar is the most used and powerful currencies in the world. The currency rates changes day by day with the increaments and decrements of about 0 pointers so I used this [US Dollar Exchange Rates Table](https://www.x-rates.com/table/?from=USD&amount=1) which helped me in the factorisation for different country's currencies. 

Moreover, I feteched everything in an android app. First of all I coded the xml part of it which is used to develop the user Interface for an app. The User interface section maninly contained a button, two textviews and one edittext to enter the user Input. I ended up with a beautiful user Interface which was sufficient to assist and help the user to convert their units into others. Although, I didn't used the latest technologies of Andorid Studio like JetPack Compose, new libraries and dependencies but I tried my best understand and develop a basic and working android app for my project. I took help from the [official android documentation](https://developer.android.com/docs).





