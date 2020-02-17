# Weather API

An Android application for users to search for weather forcast in any city on earth.Live forecast from current to next day i hours.

#### By Justus Onyancha

## Description

The application consumes Open Weather  API whereby the JSON objects are converted into POJOs where data is stored. Coordinator layout is used to hold the child views since it provides many different interactions within a single parent and those views inside it can also interact with one another. A Nested scrollview is also used inside the layout in order to provide a smooth scrolling effect across the activity. .

## Prerequisites

* You need to install the [Java SDK](https://sdkman.io/install) in order to create Java applications and the [Java Runtime Environment](https://sdkman.io/usage) which provides the requirements for executing a Java application.

* Android Studio is the preferred IDE for Google's Android OS. It needs to be [installed](https://developer.android.com/studio#downloads)



## Installation

* Fork then clone the project on your machine, open in Android Studio then run the application on your emulator or android device.

## Technologies Used:

* **Gradle** - to manage and download dependencies.

* **Picasso** - to load images into the application by offering automatic memory and disk caching.



* **OKHTTP3** - to allow all requests to share a socket. This created Connection pooling hence reduces request latency.

* **Postman** - to test the API endpoints.

* **jsonSchema2pojo** - to generate java classes from the json objects  

* **ButterKnife** - to Annotate fields with @BindView and a view ID to find and automatically cast the corresponding view in the layout.

* **Android Studio** - to develop the application.

## Known Bugs

* Incase any bug is found, or a request for a new functionality is needed, kindly open an issue [here](https://github.com/Justusm10moringaschool/WeatherAPI)

## Support and contact details

Feel free to contribute to the project by:

* Forking the repo
* Create a new branch (git branch my-contribution)
* Move to your branch (git checkout my-contribution)
* Make the changes in the files
* Add changes to reflect the changes made
* Commit your changes (git commit -m "Added features")
* Push to the branch (git push origin my-contriution)
* Create a Pull Request

Incase of any feedback/comments feel free to contact me at adweshshaddie@gmail.com

### License

#### Copyright (c) 2020 JUSTUS ONYANCHA

#### Licenced under the [MIT License](LICENSE)
