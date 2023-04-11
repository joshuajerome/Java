# Java

A collection of my Java projects.

## Split (In-Progress)

_Manage trip expenses simply._

### About

Split is an ios-app that allows users to manage trip expenses. Fundementally, Split allows users to create an event or organize trips into several events. The _Split_ subdirectory on this repository is a functional back-end for Split app. For ease of development with regard to the object oriented approach, Split was originally created in Java and then translated to Swift. Furthermore, if needed to create an Android-compatible version of Split, this sub-directory would serve as the primary back end code.

### Functionality

### Run Split In VSCode

#### Setup
1. Clone this repo: 
```
git clone https://git@github.com/joshuajerome/Java.git
```
3. Open cloned folder in VSCode.
4. Re-open folder in provided dev-container.
>__Note__
>_Docker Desktop should be running and Dev Container extension must be installed in VSCode_

#### Testing
1. Open a terminal window within VSCode, and navigate to subdirectory Split.
2. Compile Split:
```
gradle clean build
```
3. Run Unit Test Cases:
```
gradle -PmainClass=split.Main run
```






