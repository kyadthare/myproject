##Prototype URL:
http://careprovider.mybluemix.net. 

##Project Description
The ‘Care Provider Search’ application is designed as a prototype that implements the care provider search functionality, as of now, but can be scalable and robust enough to be an enterprise level application. This will serve the caseworkers in the Human Services department as well as parents to search for care providers in their vicinity based on provider name, provider type and star rating.
####Key Features
* Responsive UI is used to build front end. So this application can be accessible from multiple devices - laptop, tablet, mobile phone etc.
* In addition to search based on name, type etc, it allows to search providers within a radius from a given city.
* Provider locations are marked in the google map which can be shown/hidden (default = hidden)
* Results can be sorted in either ascending or descending order based on name, type, city or star rating
* Pagination is provided to control display of large number of result sets.
* When a change is committed to master branch in the Github, application is rebuilt and deployed to Bluemix automatically by Travis CI service.
* During every build JUnits are run by Travis CI automatically.

####Known issues/constraints
* If vicinity is specified in the search criteria for example '10 miles from Aberdeen', and result set is too large, it takes about a minute to fetch results. Since we don't know the exact requirement of 'search providers in the vicinity', we have used driving distance between the two cities and not the physical distance (which is faster). We have some ideas to improve, but since it is a POC, not implemented.
* Since we have used Bluemix's free plan (Turtle) for DB service, this allows only 4 concurrent connections. So this may hit performance when more number of people access the application.

This application is built using latest open source technologies to demonstrate IBM Curam Implementation team’s capability. The GitHub is used as a source code management and version control tool which hosts the application codebase (Code Repository). The GitHub is configured with the Travis CI tool which integrates the application code and deploys on cloud based PaaS environment seamlessly. Application is accessible from a publicly available URL. 
    
Following sections describe the Research and Software Development Life cycle followed in this project with implications from the best practices followed in the IBM Labs.

##Application Setup guide:
The ‘Care Provider Search’ App has been deployed already in PaaS environment at  IBM Bluemix. You can access the application by clicking on the URL: http://careprovider.mybluemix.net. 

##Deployment Instructions
###Development environment:
Install the GIT. Refer https://www.atlassian.com/git/tutorials/install-git/ for help.

Code repository can be found at https://github.com/kyadthare/myproject .  

Clone the repository using command line command: 

git clone https://github.com/kyadthare/myproject.git   <your-directory>

Download  EGit Plug-in for eclipse and import  this repository and create local branch. Build and launch the application on the localhost at URL: http://localhost:8080/CareProvider. This requires appserver such as Tomcat to be configured.

###Configure IBM Bluemix cloud platform

Get Bluemix account at https://console.ng.bluemix.net/registration/

Create CareProviderSearch app using Bluemix UI. Refer https://hub.jazz.net/tutorials/jazzeditorjava/ for help.

Create new ElephantSQL service and bind to CareProviderSearch app. Instructions to create application and bind service can be found in the below URL.

https://www.ibm.com/blogs/bluemix/2015/11/postgresql-database-with-elephantsql-on-bluemix/

###Continuous Integration and Deployment to Bluemix
Sign in to Travis CI with your GitHub account, accepting the GitHub access permissions. Enable Travis CI for the 'myproject'  repository (needs admin privilege). Refer https://docs.travis-ci.com/user/getting-started/ for more details.

.travis.yml file is included in the code repository which contains instructions to build the application when a change is committed to the master branch and deploy the application on Bluemix using Cloud Foundry.

Database connection details and Bluemix login details are specified as environment variable in .travis.yml file and values are stored as environment variable in Travis CI for the security reasons.

manifest.yml file contains details about .war file path, domain, application name, memory to be allocated in Bluemix, no of instances etc.

After successful deployment, application can be accessed at http://careprovider.mybluemix.net/
##Research and Design Ideation phase:
We spent first week of the project in identifying the functional needs of the customer by going through the vendor Challenge specification and listing out all the needs of the customer. We overlooked the needs of the client and prioritized the requirements as per the functionality and criticality of the requirement. We cross referred our requirement data within our team so that all of us are clear on the understanding of the functional and technical needs of the client.

Post requirement analysis, we had couple of brainstorming sessions among our team members to bring the best out of us in creating a scalable and robust software application. The session was focused on identifying the best open-source technologies available in the market, which will heed to the client request by making the application scalable, robust, and loosely coupled between each layer which makes the code development process easier and the code to be maintainable.

After finalizing the technology stack to be used for the project, we then planned the execution of the project. The lead assigned the project responsibilities among the individuals by knowing their strengths in each technology. After coming up with a rough estimate, we planned to execute the project in 8 weeks of time which included a contingency period of 1 week. We have also decided to track all the project status through daily stand-up meetings and measured the project completion status on every week end.

The next section will list out the frameworks used in this project followed by the key features of the technology which justifies the selection of the framework over other technologies.
##Frameworks and Libraries Used
####Front End
* AngularJS
* Bootstrap CSS
* HTML5 and CSS3
* Google Maps Javascript API

####Back End
* Spring, Hibernate
* Thymeleaf
* Google Map DistanceMatrix API

####Database
* ElephantSQL - PostgreSQL as service

####Source Control, CI and build tool
* GitHub
* Travis CI
* Maven

####PaaS/Cloud
* IBM Bluemix

####Automated Test
* Selenium
* JUnit

##Research

###AngularJS
AngularJS is an open source MVC JavaScript Framework maintained by Google that provides a great platform to build websites rapidly. There are thousands of websites built using this framework such as Netflix, JetBlue and Weather.com to name a few. Our selection of AngularJS over other frameworks is because of the following reason:

* AngularJS is a powerful JavaScript based development framework which allows the developers to write client side application (using JavaScript) in a clean MVC (Model View Controller) way.
* Application written in AngularJS is cross-browser compliant. AngularJS automatically handles JavaScript code suitable for each browser.
* AngularJS libraries have in-built directives, filters, routing, services etc. available which makes the development easier.
* AngularJS supports two-way data binding which synchronizes data between model and view components instantaneously without adding any event listeners on every key stroke to the input fields.

Overall, AngularJS is a framework to build large scale and high performance web application while keeping them as easy-to-maintain.

###Bootstrap 
Bootstrap is the most popular open source front end web framework for developing responsive, mobile-first web sites. It contains a variety of standard pre-built design templates for typography, forms, navigation, buttons, and many other interface components. Bootstrap's 12 column grid based classes paves way for constructing responsive CSS that adjusts to phones, tablets, and desktops and is compatible with all modern browsers.

###Spring and Hibernate
We selected Spring and Hibernate for web back end logic due to their wide spread usage in the large enterprise applications. Spring Framework allows developers to develop scalable and reliable applications. Hibernate is ORM(Object Relational Mapper) framework that takes care of the boilerplate code to access database and allows the developer to concentrate on business logic. 

###PostgreSQL 
PostgreSQL has been selected for back end as this is open source database which is highly scalable and relational database management system. This provides almost all features that any vendor specific relational database provides such as Oracle or DB2. This also supports object relationship mapping. In addition to this, PostgreSQL is hosted on many cloud platforms.

###Travis CI 
Travis CI was our obvious choice for continuous integration as this being very popular continuous integration service that integrates with GitHub repository. Configuring build and deployment is very easy in Travis CI as it requires one configuration file i.e. .travis.yml. Add few lines of instructions for building, testing and deploying, rest is taken care by Travis! Build results are reported on project site as well as via email notification.

###Bluemix
Fast growing cloud platform as a service, IBM’s Bluemix is one of the top PaaS for building, running and managing apps and services. Bluemix hosts hundreds of services including IBM Watson and Weather.com. With three integrated deployment models - public, local and dedicated, Bluemix can be used in small business to large enterprises that need additional security.  
##List of Artifacts
The client side artifacts are listed below:

![folderstructure](https://cloud.githubusercontent.com/assets/24270380/21314863/3e134c26-c61f-11e6-9856-2d5944501b2e.PNG)

The server side artifacts are listed below:

![folderstructure1](https://cloud.githubusercontent.com/assets/24270380/21314889/6adc9d48-c61f-11e6-8fb1-45720717af35.PNG)

##Issue Reporting:

Despite working towards building a quality product with zero errors, we may end up with having some errors and feature improvements from our clients/users of the application. If there is any defect found in the application or a request for feature enhancement, we encourage our users/clients to report the same under our GitHub code repository portal. 

Please follow the below steps to report bugs/ feature enhancements to the application:

1)	Go to the GitHub Code repository of the application and click on the issues tab in the page. Alternatively, you can directly go to the issues tab by clicking on the below URL: https://github.com/kyadthare/myproject/issues

2)	Click on New Issue button on the top right corner of the page.

3)	In the Issue form, please provide a valid title to the issue which you are going to report.

4)	Kindly elaborate the steps to reproduce the bug and attach screen shots for the same. This will help us to quickly identify the issue and work on rectifying the same.

5)	Once the issue is resolved, we will close the issue with proper status which will trigger a mail to the user who has reported the mail.

6)	Then the user can validate the application again and provide feedback on the response.

##References:

1)	https://angularjs.org/ - for AngularJS framework.

2)	http://getbootstrap.com/ - for Bootstrap framework.

3)	http://www.w3schools.com/ - for AngularJS, Bootstrap, HTML and CSS fundamentals.

4)	https://spring.io/ - for Spring framework.

5)	http://hibernate.org/ - for Hibernate framework.

6)	http://www.seleniumhq.org/ - for selenium web driver automated testing framework.

7) https://travis-ci.org/ - for Travis Continuous Integration

8) https://www.ibm.com/blogs/bluemix/2015/11/postgresql-database-with-elephantsql-on-bluemix/ - for ElephantSQL service in Bluemix
