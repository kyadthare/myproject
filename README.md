##Project Description
The ‘Care Provider Search’ App designed as a prototype that implements the care provider search functionality, as of now, but designed to be scalable and robust enough to be an enterprise level application, that will serve the caseworkers in the Human Services department. The prototype allows the case workers and parents to search for care providers in their vicinity based on provider name, provider type and star rating.

The prototype is built using latest open source technologies to demonstrate IBM Curam Implementation team’s capability. The GitHub is used as a source code management and version control tool which hosts the application codebase (Code Repository). The GitHub is configured with the Travis CI tool which integrates the application code and deploys the application on cloud based PaaS environment seamlessly. The application can be accessed through a publicly available URL. 
    
Following sections describe the Research and Software Development Life cycle followed in this project with implications from the best practices followed in the IBM Labs.

##Application Setup guide:
The ‘Care Provider Search’ App has been deployed already in PaaS environment at  IBM Bluemix. You can access the application by clicking on the url: http://careprovider.mybluemix.net. 

##Deployment Instructions
###Development environment:
Install the GIT. Refer https://www.atlassian.com/git/tutorials/install-git/ for help.

Code repository can be found at https://github.com/kyadthare/myproject .  

Clone the repository using command line command: git clone https://github.com/kyadthare/myproject.git   <your-directory>

Download  EGit Plug-in for eclipse and import  this repository and create local branch Build and launch the application on the localhost at url http://localhost:8080/CareProvider 

###Configure IBM Bluemix cloud platform

Get Bluemix account at https://console.ng.bluemix.net/registration/

Create CareProviderSearch app using Bluemix UI. Refer https://hub.jazz.net/tutorials/jazzeditorjava/ for help.

Create new ElephantSQL service and bind to CareProviderSearch app. Instructions to create application and bind service can be found in the below URL.
https://www.ibm.com/blogs/bluemix/2015/11/postgresql-database-with-elephantsql-on-bluemix/

###Continuous Integration and Deployment to Bluemix
Sign in to Travis CI with your GitHub account, accepting the GitHub access permissions. Enable Travis CI for the above mentioned repository(needs admin privilege). Refer https://docs.travis-ci.com/user/getting-started/ for more details.

.travis.yml file is included in the code repository which contains instructions to build the application when a change is committed to the master branch and deploy the application on Bluemix using CloudFoundry.

Database connection details and Bluemix login details are specified as environment variable in .travis.yml file. and values are stored as environment variable in Travis CI for the security reasons.
manifest.yml file contains details about.war file path, domain, appliation name, memory to be allocated in Bluemix, no of instances etc.

After successful deployment, application can be accessed at http://careprovider.mybluemix.net/
##Research and Design Ideation phase:
We spent first week of the project in identifying the functional needs of the customer by going through the vendor Challenge specification and listing out all the needs of the customer. We overlooked the needs of the client and prioritized the requirements as per the functionality and criticality of the requirement. We cross referred our requirement data within our team so that all of us are clear on the understanding of the functional and technical needs of the client.

Post requirement analysis, we had couple of brainstorming session among our team to bring the best out of us in creating a scalable and robust software application. The session was focused on identifying the best open-source technologies available in the market, which will heed to the client request by making the application scalable, robust, and loosely coupled between each layer which makes the code development process easier and the code to be maintainable.

After finalizing the technology stack to be used for the project, we then planned the execution of the project. The lead assigned the project responsibilities among the individuals by knowing their strengths in each technology. After coming up with a rough estimate, we planned to execute the project in 8 weeks of time which included a contingency period of 1 week. We have also decided to track all the project status through daily stand-up meetings and measured the project completion status on every week end.

The next section will list out the frameworks used in this project followed by the key features of the technology which justifies the selection of the framework over other technologies.
##Frameworks and Libraries Used
####Front End
* AngularJS.
* Bootstrap CSS
* HTML5 and CSS3
* Google Maps Javascript API

####Back End
* Spring, Hibernate
* Thymeleaf
* Google Map Geocode API

####Database
* PostgresSQL, ElephantSQL service

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
AngularJS is an open source MVC JavaScript Framework maintained by google, that provides a great platform to build websites rapidly. There are thousands of websites built using this framework such as Netflix, JetBlue, Weather.com to name a few. Our selection of AngularJS over other frameworks are because of the following reason:

* AngularJS is a powerful JavaScript based development framework which allows the developers to write client side application (using JavaScript) in a clean MVC (Model View Controller) way.
* Application written in AngularJS is cross-browser compliant. AngularJS automatically handles JavaScript code suitable for each browser.
* AngularJS libraries has in-built directives, filters, routing, services etc. available which makes the development easier.
* AngularJS supports two-way data binding which synchronizes data between model and view components instantaneously without adding any event listeners on every key stroke to the input fields.
Overall, AngularJS is a framework to build large scale and high performance web application while keeping them as easy-to-maintain.

###Bootstrap 
Bootstrap is the most popular open source front end web framework for developing responsive, mobile-first web sites. It contains a variety of standard pre-built design templates for typography, forms, navigation, buttons, and many other interface components. Bootstrap's 12 column grid based classes paves way for constructing responsive CSS that adjusts to phones, tablets, and desktops and is compatible with all modern browsers.

###Spring and Hibernate
We selected Spring and Hibernate for web back end logic due to their wide spread usage in the large enterprise applications. Spring Framework allows developers to develop scalable and reliable applications. Hibernate is ORM(Object Relational Mapper) framework that takes care of the boilerplate code to access database and allows the developer to concentrate on business logic. 

###PostgresSQL 
PostgresSQL has been selected for back end as this is open source database which is highly scalable and relational database management system This provides almost all features that any vendor specific relational database provides such as Oracle or DB2. This also supports object relationship mapping. In addition to this, PostgresSQL is hosted on many cloud platforms.

###Travis CI 
Travis CI was our obvious choice for CI as this being very popular continuous integration service that integrates with GitHub repository and very easy to set up with just one configuration file travis.yml. Add few lines of instructions for building, testing and deploying, rest is taken care by Travis! Build results are reported on project site as well as via email notification.

###Bluemix
Fast growing cloud platform as a service, IBM’s Bluemix is one of the top PaaS for building, running and managing apps and services. Bluemix hosts hundreds of services including IBM Watson and Weather.com. With three integrated deployment models - public, local and dedicated, Bluemix can be used in small business to large enterprises that need additional security.  
##List of Artifacts
The client side artifacts are listed below:

![folderstructure](https://cloud.githubusercontent.com/assets/24270380/21314863/3e134c26-c61f-11e6-9856-2d5944501b2e.PNG)

The server side artifacts are listed below:

![folderstructure1](https://cloud.githubusercontent.com/assets/24270380/21314889/6adc9d48-c61f-11e6-8fb1-45720717af35.PNG)

##Issue Reporting:

Despite working towards building a quality product with zero errors, we end up with having some errors and feature improvements from our clients/users of the application. In case of ending-up with a bug in the application/to request feature enhancement for the application, we encourage our users/clients to report the same under our GitHub code repository portal. 

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

3)	http://www.w3schools.com/ - for AngularJS,Bootstrap,HTML and CSS fundamentals.

4)	https://spring.io/ - for Spring framework.

5)	http://hibernate.org/ - for Hibernate framework.

6)	http://www.seleniumhq.org/ - for selenium web driver automated testing framework.

7) https://travis-ci.org/ - for Travis Continuous Integration

8) https://www.ibm.com/blogs/bluemix/2015/11/postgresql-database-with-elephantsql-on-bluemix/ - for ElephantSQL service in Bluemix


